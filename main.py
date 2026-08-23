import os
import time
from dotenv import load_dotenv
from langchain_core.messages import HumanMessage
from agents.documentation_agent import create_doc_agent
from agents.ingestion_agent import create_ingestion_agent
from agents.evaluation_agent import create_eval_agent

# Load environment variables
load_dotenv()

if __name__ == "__main__":
    # Ensure Azure OpenAI keys are set
    if not os.environ.get("AZURE_OPENAI_KEY_GPT4o"):
        print("Warning: AZURE_OPENAI_KEY_GPT4o environment variable is not set.")
        print("Please ensure your .env file has the Azure OpenAI credentials.")
        
    print("===========================================")
    print("PHASE 1: Codebase Ingestion (RAG Pipeline)")
    print("===========================================")
    
    ingestion_agent = create_ingestion_agent()
    
    ingestion_instruction = "List all files in the 'legacy_source' directory and chunk and embed each of them to index the codebase."
    inputs = {"messages": [HumanMessage(content=ingestion_instruction)]}
    
    for chunk in ingestion_agent.stream(inputs, stream_mode="values"):
        message = chunk["messages"][-1]
        message.pretty_print()
        
    print("\n===========================================")
    print("PHASE 2: Documentation Generation")
    print("===========================================")
    
    doc_agent = create_doc_agent()
    eval_agent = create_eval_agent()
    
    import glob
    from langchain_text_splitters import RecursiveCharacterTextSplitter, Language
    java_files = glob.glob("legacy_source/**/*.java", recursive=True)
    
    java_splitter = RecursiveCharacterTextSplitter.from_language(
        language=Language.JAVA, 
        chunk_size=10000, 
        chunk_overlap=1000
    )
    
    for java_file in java_files:
        print(f"\n--- Documenting {java_file} ---")
        base_name = os.path.basename(java_file).replace('.java', '')
        
        # Read the file
        try:
            with open(java_file, 'r', encoding='utf-8') as f:
                code = f.read()
        except Exception as e:
            print(f"Skipping {java_file} due to read error: {e}")
            continue
            
        chunks = java_splitter.split_text(code)
        print(f"Split {java_file} into {len(chunks)} chunks.")
        
        for i, chunk_text in enumerate(chunks):
            chunk_id = f"chunk_{i+1:02d}"
            print(f"\nProcessing {chunk_id}/{len(chunks)} for {base_name}...")
            
            doc_instruction = f"""
Read this specific chunk of code from '{java_file}'.
Use search_codebase if you see things you don't understand. 
Generate markdown documentation for this chunk, and write it to 'documentation/{base_name}/{chunk_id}.md'.

Code Chunk:
```java
{chunk_text}
```
"""
            
            inputs = {"messages": [HumanMessage(content=doc_instruction)]}
            
            success = False
            while not success:
                try:
                    for chunk in doc_agent.stream(inputs, stream_mode="values"):
                        message = chunk["messages"][-1]
                        message.pretty_print()
                    success = True
                except Exception as e:
                    error_msg = str(e).lower()
                    if "429" in error_msg or "rate limit" in error_msg or "too_many_requests" in error_msg:
                        print(f"\n[RATE LIMIT HIT] Azure is throttling us! Sleeping for 60 seconds before retrying...")
                        time.sleep(60)
                    else:
                        print(f"\n[UNEXPECTED ERROR] {e}")
                        break
                
            print(f"Sleeping for 10 seconds to avoid Azure OpenAI rate limits...")
            time.sleep(10)
            
            # --- EVALUATION PHASE ---
            doc_path = f"documentation/{base_name}/{chunk_id}.md"
            if os.path.exists(doc_path):
                print(f"Evaluating {doc_path}...")
                with open(doc_path, 'r', encoding='utf-8') as f:
                    generated_doc = f.read()
                    
                eval_instruction = f"""
Evaluate the following documentation against the source Java chunk.

Source Java Chunk:
```java
{chunk_text}
```

Generated Documentation:
```markdown
{generated_doc}
```
"""
                eval_inputs = {"messages": [HumanMessage(content=eval_instruction)]}
                
                eval_success = False
                while not eval_success:
                    try:
                        eval_response = ""
                        for eval_chunk in eval_agent.stream(eval_inputs, stream_mode="values"):
                            message = eval_chunk["messages"][-1]
                            eval_response = message.content
                        eval_success = True
                    except Exception as e:
                        error_msg = str(e).lower()
                        if "429" in error_msg or "rate limit" in error_msg or "too_many_requests" in error_msg:
                            print(f"\n[RATE LIMIT HIT] Azure is throttling evaluation! Sleeping for 60 seconds...")
                            time.sleep(60)
                        else:
                            print(f"\n[UNEXPECTED ERROR] {e}")
                            break
                            
                print(f"Evaluator Output:\n{eval_response}")
                if "RESULT: FAIL" in eval_response.upper():
                    flagged_dir = f"flagged_documents/{base_name}"
                    os.makedirs(flagged_dir, exist_ok=True)
                    flagged_path = f"{flagged_dir}/{chunk_id}.md"
                    
                    with open(flagged_path, 'w', encoding='utf-8') as f:
                        f.write(f"<!-- EVALUATOR FEEDBACK:\n{eval_response}\n-->\n\n{generated_doc}")
                        
                    os.remove(doc_path)
                    print(f"-> MOVED to {flagged_path} for human review.\n")
                else:
                    print("-> PASSED Evaluation.\n")
                
                print(f"Sleeping for 10 seconds after evaluation...")
                time.sleep(10)
            
        print(f"Sleeping for 15 seconds before next file...")
        time.sleep(15)
        
    print("\nWorkflow completed successfully!")
