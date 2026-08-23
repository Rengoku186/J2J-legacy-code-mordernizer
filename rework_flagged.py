import os
import glob
import time
from dotenv import load_dotenv
from langchain_core.messages import HumanMessage
from agents.documentation_agent import create_doc_agent

load_dotenv()

def main():
    print("===========================================")
    print("FLAGGED DOCUMENTS: HUMAN REVIEW & REWORK")
    print("===========================================")
    
    if not os.environ.get("AZURE_OPENAI_KEY_GPT4o"):
        print("Warning: AZURE_OPENAI_KEY_GPT4o environment variable is not set.")
    
    doc_agent = create_doc_agent()
    flagged_files = glob.glob("flagged_documents/**/*.md", recursive=True)
    
    if not flagged_files:
        print("No flagged documents found! Great job.")
        return
        
    for flagged_file in flagged_files:
        print(f"\n--- Reviewing {flagged_file} ---")
        with open(flagged_file, 'r', encoding='utf-8') as f:
            content = f.read()
            
        print("File contains Evaluator Feedback at the top. Please open the file in your IDE to review.")
        action = input("Enter your feedback for the Documentation Agent to rewrite it (or type 'approve' to accept as-is): ")
        
        target_path = flagged_file.replace("flagged_documents", "documentation").replace("\\", "/")
        
        if action.strip().lower() == 'approve':
            # Move back to documentation/
            os.makedirs(os.path.dirname(target_path), exist_ok=True)
            os.rename(flagged_file, target_path)
            print(f"Approved. Moved to {target_path}")
            continue
            
        print("Sending feedback to Documentation Agent for a rewrite...")
        
        rework_instruction = f"""
This documentation was flagged by the QA Evaluator and a Human Reviewer.
Please rewrite the documentation for this chunk based on the human's feedback.

Original File Content (Includes Evaluator Feedback):
```markdown
{content}
```

Human Reviewer Feedback:
{action}

Rewrite the documentation and write it to '{target_path}'. Ensure you follow all previous metadata rules (chunk_id, frontmatter, etc).
"""
        inputs = {"messages": [HumanMessage(content=rework_instruction)]}
        
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
                    print(f"\n[RATE LIMIT HIT] Azure is throttling us. Sleeping for 60 seconds...")
                    time.sleep(60)
                else:
                    print(f"\n[UNEXPECTED ERROR] {e}")
                    break
                    
        # The agent's write_documentation tool saves it to the target path.
        # So we just clean up the flagged file.
        if os.path.exists(flagged_file):
            os.remove(flagged_file)
            print(f"Deleted old flagged file: {flagged_file}")
            
        print("Sleeping 10s to respect rate limits before the next review...")
        time.sleep(10)
        
    print("\nAll flagged documents processed!")

if __name__ == "__main__":
    main()
