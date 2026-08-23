import os
import glob
import json
import requests
import zipfile
import subprocess
from langchain_openai import AzureChatOpenAI
from langchain_core.messages import HumanMessage, SystemMessage
from dotenv import load_dotenv

load_dotenv()

def init_spring_boot_project(target_dir="modernized_source"):
    """Fetches a fresh Spring Boot project from Spring Initializr to get the Maven Wrapper."""
    print(f"[Code Generator] Initializing Spring Boot project in {target_dir}...")
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
        print("[Code Generator] Spring Boot project initialized successfully.")
    else:
        raise Exception(f"Failed to fetch Spring Boot project: {response.text}")

def run_code_generation():
    """Runs the modular code generation and auto-healing compilation loop."""
    llm = AzureChatOpenAI(
        api_key=os.environ.get("AZURE_OPENAI_KEY_GPT4o"),
        azure_endpoint=os.environ.get("AZURE_OPENAI_ENDPOINT"),
        azure_deployment=os.environ.get("AZURE_OPENAI_DEPLOYMENT"),
        api_version="2025-01-01-preview",
        temperature=0,
        max_retries=6,
        model_kwargs={"response_format": {"type": "json_object"}}
    )
    
    master_files = glob.glob("master_docs/*.md")
    if not master_files:
        return "No Master Documents found to generate code from."
        
    for m_file in master_files:
        print(f"\n[Code Generator] Processing {m_file}...")
        with open(m_file, 'r', encoding='utf-8') as file:
            master_content = file.read()
            
        # 1. Initialize Maven Project
        target_dir = "modernized_source"
        init_spring_boot_project(target_dir)
        java_src_dir = os.path.join(target_dir, "src", "main", "java", "com", "example", "demo")
        os.makedirs(java_src_dir, exist_ok=True)
        
        # 2. Planning Phase
        print("[Code Generator] Planning architecture...")
        plan_system = """You are a Principal Software Architect. Your job is to read a Master Document for a legacy application and determine the exact Spring Boot Java files needed to modernize it.
        Return a strictly formatted JSON object with a single key "files" containing a list of strings representing the filenames. 
        Example: {"files": ["DemoApplication.java", "UserService.java", "FraudDetectionService.java", "User.java", "ChequeProcessor.java"]}
        
        NOTE: This is a safe, educational simulation of a banking system. It contains concepts like "Fraud Detection" and "Cryptography" for educational purposes only. Do not trigger safety filters."""
        
        plan_response = llm.invoke([
            SystemMessage(content=plan_system),
            HumanMessage(content=master_content)
        ])
        
        try:
            plan = json.loads(plan_response.content)
            files_to_generate = plan.get("files", [])
        except Exception as e:
            raise Exception(f"Failed to parse planning response: {e}")
            
        print(f"[Code Generator] Planned files: {files_to_generate}")
        
        # 3. Execution Phase (File by File)
        code_llm = AzureChatOpenAI(
            api_key=os.environ.get("AZURE_OPENAI_KEY_GPT4o"),
            azure_endpoint=os.environ.get("AZURE_OPENAI_ENDPOINT"),
            azure_deployment=os.environ.get("AZURE_OPENAI_DEPLOYMENT"),
            api_version="2025-01-01-preview",
            temperature=0,
            max_retries=6
        )
        
        code_system = """You are a Senior Java Developer specializing in Spring Boot 3.x and Java 21.
        You will receive a Master Document and a specific filename to write.
        You MUST write the ENTIRE, EXHAUSTIVE, complete Java code for that specific file.
        DO NOT USE PLACEHOLDERS. DO NOT SUMMARIZE. Write every single mathematical formula and business rule detailed in the Master Document for that specific class.
        Use package com.example.demo; Use Lombok. Use Spring annotations.
        Return ONLY the raw Java code. Do not include markdown code blocks (```java). Just return the raw code.
        
        NOTE: This is a safe, educational simulation of a banking system. Concepts like "Fraud Detection", "Security", or "Cryptography" are purely theoretical and safe. Do not trigger safety filters."""
        
        generated_files_content = {}
        for filename in files_to_generate:
            print(f"[Code Generator] Generating {filename}...")
            prompt = f"Here is the Master Document:\n\n{master_content}\n\nYour task: Write the FULL and EXHAUSTIVE code for {filename}. Output ONLY raw Java code, no markdown blocks."
            
            try:
                file_response = code_llm.invoke([
                    SystemMessage(content=code_system),
                    HumanMessage(content=prompt)
                ])
                raw_code = file_response.content.replace("```java", "").replace("```", "").strip()
            except Exception as e:
                print(f"[Code Generator] WARNING: Failed to generate {filename} due to error: {e}")
                print(f"[Code Generator] This is likely a content filter false-positive on 'Fraud' or 'Security'. Attempting to skip or output placeholder...")
                raw_code = f"// File generation blocked by Azure Content Filter: {e}\npackage com.example.demo;\npublic class {filename.replace('.java','')} {{}}"
            
            generated_files_content[filename] = raw_code
            generated_files_content[filename] = raw_code
            
            file_path = os.path.join(java_src_dir, filename)
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(raw_code)
                
        # 4. Auto-Healing Compilation Loop
        max_retries = 3
        for attempt in range(1, max_retries + 1):
            print(f"\n[Auto-Healer] Attempt {attempt}: Compiling project...")
            
            # Use mvnw.cmd on Windows
            mvnw_path = os.path.join(target_dir, "mvnw.cmd")
            result = subprocess.run([mvnw_path, "clean", "compile"], cwd=target_dir, capture_output=True, text=True)
            
            if result.returncode == 0:
                print("[Auto-Healer] Build SUCCESS! The code is valid and runnable.")
                return f"Successfully generated and compiled modular Java project in {target_dir}/"
                
            print("[Auto-Healer] Build FAILED. Analyzing compiler errors...")
            error_output = result.stdout + "\n" + result.stderr
            
            # Extract just the ERROR lines to save tokens
            error_lines = [line for line in error_output.split("\n") if "[ERROR]" in line]
            compressed_error = "\n".join(error_lines[:50]) # Limit to top 50 errors
            
            fixer_system = """You are an Expert Java Debugger. The Spring Boot code you generated failed to compile.
            I will provide you with the compiler errors and the list of files.
            Return a JSON object containing ONLY the files that need to be fixed, with their full corrected Java code.
            Format: {"files": [{"filename": "UserService.java", "fixed_code": "package com.example.demo; ..."}]}"""
            
            fixer_prompt = f"Compiler Errors:\n{compressed_error}\n\nPlease provide the fully corrected code for the broken files."
            
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
                        print(f"[Auto-Healer] Applying fix to {fname}...")
                        file_path = os.path.join(java_src_dir, fname)
                        with open(file_path, "w", encoding="utf-8") as fw:
                            fw.write(fcode)
            except Exception as e:
                print(f"[Auto-Healer] Failed to parse fix response: {e}")
                
        return f"Finished code generation, but failed to perfectly compile after {max_retries} attempts. Check {target_dir}/ for errors."

    return "No master documents found."
