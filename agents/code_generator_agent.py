import os
import glob
import json
import requests
import zipfile
import subprocess
import platform
from langchain_core.messages import HumanMessage, SystemMessage
import config
from utils import setup_logger, sanitize_path

logger = setup_logger("CodeGenerator")

def init_spring_boot_project(target_dir=config.MODERNIZED_SOURCE_DIR):
    """Fetches a fresh Spring Boot project from Spring Initializr to get the Maven Wrapper."""
    logger.info(f"Initializing Spring Boot project in {target_dir}...")
    url = "https://start.spring.io/starter.zip"
    params = {
        "type": "maven-project",
        "language": "java",
        "baseDir": "",
        "groupId": "com.example",
        "artifactId": "demo",
        "name": "demo",
        "description": "Modernized Legacy App",
        "packageName": "com.example.demo",
        "packaging": "jar",
        "javaVersion": "21",
        "dependencies": "web,lombok"
    }
    
    response = requests.get(url, params=params)
    if response.status_code == 200:
        zip_path = os.path.join(target_dir, "demo.zip")
        os.makedirs(target_dir, exist_ok=True)
        with open(zip_path, "wb") as f:
            f.write(response.content)
            
        with zipfile.ZipFile(zip_path, 'r') as zip_ref:
            zip_ref.extractall(target_dir)
            
        os.remove(zip_path)
        logger.info("Spring Boot project initialized successfully.")
    else:
        raise Exception(f"Failed to fetch Spring Boot project: {response.text}")

def run_auto_healer(target_dir, java_src_dir, llm, phase_name=""):
    """Compiles the project and auto-heals any errors."""
    max_retries = 3
    for attempt in range(1, max_retries + 1):
        logger.info(f"\n[Auto-Healer {phase_name}] Attempt {attempt}: Compiling project...")
        
        is_windows = platform.system() == "Windows"
        mvn_cmd = "mvnw.cmd" if is_windows else "./mvnw"
        
        if not is_windows:
            subprocess.run(["chmod", "+x", "mvnw"], cwd=target_dir)
            
        try:
            result = subprocess.run([mvn_cmd, "clean", "compile"], cwd=target_dir, capture_output=True, text=True, shell=is_windows, timeout=300)
        except subprocess.TimeoutExpired:
            logger.error(f"[Auto-Healer {phase_name}] Maven build timed out after 300 seconds.")
            return False
            
        if result.returncode == 0:
            logger.info(f"[Auto-Healer {phase_name}] Build SUCCESS! The code is valid.")
            return True
            
        logger.warning(f"[Auto-Healer {phase_name}] Build FAILED. Analyzing compiler errors...")
        error_output = result.stdout + "\n" + result.stderr
        
        error_lines = [line for line in error_output.split("\n") if "[ERROR]" in line]
        compressed_error = "\n".join(error_lines[:50]) # Limit to top 50 errors
        
        # Read all current files to give to the healer
        current_files = ""
        for fname in os.listdir(java_src_dir):
            if fname.endswith(".java"):
                with open(os.path.join(java_src_dir, fname), "r", encoding="utf-8") as f:
                    current_files += f"\n--- {fname} ---\n{f.read()}\n"
        
        fixer_system = """You are an Expert Java Debugger. The Spring Boot code failed to compile.
        I will provide you with the compiler errors and the current source code of all files.
        Return a JSON object containing ONLY the files that need to be fixed, with their full corrected Java code.
        Format: {"files": [{"filename": "UserService.java", "fixed_code": "package com.example.demo; ..."}]}"""
        
        fixer_prompt = f"Compiler Errors:\n{compressed_error}\n\nCurrent Source Code:\n{current_files}\n\nPlease provide the fully corrected code for the broken files to fix the compiler errors."
        
        fix_response = llm.invoke([
            SystemMessage(content=fixer_system),
            HumanMessage(content=fixer_prompt)
        ])
        
        try:
            fix_plan = json.loads(fix_response.content)
            for f in fix_plan.get("files", []):
                fname = f.get("filename")
                fcode = f.get("fixed_code", "").replace("```java", "").replace("```", "").strip()
                if fname and fcode:
                    logger.info(f"[Auto-Healer {phase_name}] Applying fix to {fname}...")
                    file_path = sanitize_path(java_src_dir, fname)
                    with open(file_path, "w", encoding="utf-8") as fw:
                        fw.write(fcode)
        except Exception as e:
            logger.error(f"[Auto-Healer {phase_name}] Failed to parse fix response: {e}")
            
    logger.error(f"[Auto-Healer {phase_name}] Failed to perfectly compile after {max_retries} attempts.")
    return False

def run_code_generation():
    """Runs the modular code generation and auto-healing compilation loop."""
    llm = config.get_llm(response_format={"type": "json_object"})
    code_llm = config.get_llm()
    
    master_files = glob.glob(f"{config.MASTER_DOCS_DIR}/*.md")
    if not master_files:
        logger.error("No Master Documents found to generate code from.")
        return "No Master Documents found to generate code from."
        
    # 1. Initialize Maven Project ONCE for all master files
    target_dir = config.MODERNIZED_SOURCE_DIR
    init_spring_boot_project(target_dir)
    java_src_dir = os.path.join(target_dir, "src", "main", "java", "com", "example", "demo")
    os.makedirs(java_src_dir, exist_ok=True)
    
    generation_results = []
    
    for m_file in master_files:
        logger.info(f"\n[Code Generator] Processing {m_file}...")
        with open(m_file, 'r', encoding='utf-8') as file:
            master_content = file.read()
            
        # ---------------------------------------------------------
        # PHASE 1: Architecture Planning
        # ---------------------------------------------------------
        logger.info("[Phase 1] Planning architecture...")
        plan_system = """You are a Principal Software Architect. Read the Master Document and determine the exact Spring Boot Java files needed.
        Return a strictly formatted JSON object with a single key "files" containing a list of strings representing the filenames. 
        Example: {"files": ["DemoApplication.java", "UserService.java"]}"""
        
        plan_response = llm.invoke([
            SystemMessage(content=plan_system),
            HumanMessage(content=master_content)
        ])
        
        try:
            plan = json.loads(plan_response.content)
            files_to_generate = plan.get("files", [])
        except Exception as e:
            raise Exception(f"Failed to parse planning response: {e}")
            
        logger.info(f"[Phase 1] Planned files: {files_to_generate}")
        
        # ---------------------------------------------------------
        # PHASE 1.5: Skeleton Generation & Healing
        # ---------------------------------------------------------
        skeleton_system = """You are a Senior Java Developer specializing in Spring Boot 3.x and Java 21.
        Write ONLY the SKELETON class for the requested file.
        Include package, imports, class annotations, field declarations, and method signatures.
        DO NOT WRITE BUSINESS LOGIC. Leave all methods empty (return null, 0, or false).
        Use package com.example.demo; Use Lombok where appropriate. Use Spring annotations.
        CRITICAL RULE: A .java file MUST contain EXACTLY ONE class (the one matching the filename). Do NOT define multiple classes, inner classes, or package-private classes in the same file.
        Return ONLY the raw Java code. Do not include markdown code blocks."""
        
        for filename in files_to_generate:
            logger.info(f"[Phase 1.5] Generating SKELETON for {filename}...")
            prompt = f"Master Document:\n\n{master_content}\n\nTask: Write the SKELETON code for {filename}. Output ONLY raw Java code."
            
            try:
                file_response = code_llm.invoke([
                    SystemMessage(content=skeleton_system),
                    HumanMessage(content=prompt)
                ])
                raw_code = file_response.content.replace("```java", "").replace("```", "").strip()
            except Exception as e:
                logger.warning(f"[Phase 1.5] WARNING: Failed to generate {filename}. Fallback skeleton used.")
                raw_code = f"package com.example.demo;\npublic class {filename.replace('.java','')} {{}}"
            
            file_path = sanitize_path(java_src_dir, filename)
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(raw_code)
                
        # Heal Skeletons
        success = run_auto_healer(target_dir, java_src_dir, llm, phase_name="Skeleton")
        if not success:
            logger.warning("[Phase 1.5] Skeleton Healing failed. Continuing anyway, but Phase 2 might struggle.")
            
        # Read the healed skeletons to pass as context to Phase 2
        healed_skeletons = ""
        for filename in files_to_generate:
            file_path = sanitize_path(java_src_dir, filename)
            if os.path.exists(file_path):
                with open(file_path, "r", encoding="utf-8") as f:
                    healed_skeletons += f"--- {filename} ---\n{f.read()}\n\n"

        # ---------------------------------------------------------
        # PHASE 2: Logic Implementation
        # ---------------------------------------------------------
        logic_system = """You are a Senior Java Developer specializing in Spring Boot 3.x and Java 21.
        You are tasked with filling in the business logic for a specific file.
        You have the Master Document and the complete compiling SKELETON project context.
        Write the FULL and EXHAUSTIVE complete Java code for the file, filling in all method bodies based on the Master Document.
        Do NOT change method signatures from the skeleton. You must adhere to the skeleton's API.
        CRITICAL RULE: A .java file MUST contain EXACTLY ONE class (the one matching the filename). Do NOT define multiple classes, inner classes, or package-private classes in the same file.
        Return ONLY the raw Java code. Do not include markdown code blocks."""
        
        for filename in files_to_generate:
            logger.info(f"[Phase 2] Filling Logic for {filename}...")
            prompt = f"Master Document:\n{master_content}\n\nAll Healed Skeletons Context:\n{healed_skeletons}\n\nTask: Write the FULL IMPLEMENTED code for {filename} by filling in the skeleton's method bodies. Output ONLY raw Java code."
            
            try:
                file_response = code_llm.invoke([
                    SystemMessage(content=logic_system),
                    HumanMessage(content=prompt)
                ])
                raw_code = file_response.content.replace("```java", "").replace("```", "").strip()
            except Exception as e:
                logger.error(f"[Phase 2] WARNING: Failed to fill logic for {filename}: {e}")
                continue # Skip and leave the skeleton in place
                
            file_path = sanitize_path(java_src_dir, filename)
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(raw_code)
                
        # ---------------------------------------------------------
        # PHASE 2.5: Final Auto-Healing
        # ---------------------------------------------------------
        success = run_auto_healer(target_dir, java_src_dir, llm, phase_name="Implementation")
        if success:
            generation_results.append(f"Successfully generated and compiled modular Java project for {m_file}")
        else:
            generation_results.append(f"Finished code generation for {m_file}, but failed to perfectly compile.")
            
    return "\n".join(generation_results)
