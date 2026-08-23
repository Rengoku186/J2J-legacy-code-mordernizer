import streamlit as st
import os
import glob
import time
from dotenv import load_dotenv
from langchain_core.messages import HumanMessage
from agents.documentation_agent import create_doc_agent

# Initialize environment
load_dotenv()
if "doc_agent" not in st.session_state:
    st.session_state.doc_agent = create_doc_agent()

st.set_page_config(page_title="Multi-Agent Pipeline Dashboard", layout="wide")

st.sidebar.title("Flagged Documents")

flagged_files = glob.glob("flagged_documents/**/*.md", recursive=True)
if not flagged_files:
    st.sidebar.success("No flagged documents found!")
    st.success("Pipeline is clean. No documents are flagged for review.")
else:
    selected_file = st.sidebar.selectbox("Select a file to review:", flagged_files)
    
    st.title("Review Flagged Document")
    st.write(f"**File:** `{selected_file}`")
    
    with open(selected_file, 'r', encoding='utf-8') as f:
        content = f.read()
        
    col1, col2 = st.columns([2, 1])
    
    with col1:
        st.markdown("### Document Content (with Feedback)")
        # Put content in a scrollable container or just raw markdown
        st.markdown(content)
        
    with col2:
        st.markdown("### Human Action")
        user_comments = st.text_area("Add your comments for the rewrite:", height=150)
        
        target_path = selected_file.replace("flagged_documents", "documentation").replace("\\", "/")
        
        if st.button("Approve (No Rewrite)", type="primary"):
            os.makedirs(os.path.dirname(target_path), exist_ok=True)
            os.rename(selected_file, target_path)
            st.success(f"Moved to {target_path}. Refreshing...")
            time.sleep(1)
            st.rerun()
            
        if st.button("Send for Rework"):
            if not user_comments.strip():
                st.error("Please add comments before sending for rework.")
            else:
                with st.spinner("Agent is rewriting the documentation... (This might take a minute depending on rate limits)"):
                    rework_instruction = f"""
This documentation was flagged by the QA Evaluator and a Human Reviewer.
Please rewrite the documentation for this chunk based on the human's feedback.

Original File Content:
```markdown
{content}
```

Human Feedback:
{user_comments}

Rewrite the documentation and write it to '{target_path}'. Ensure you follow all metadata rules.
"""
                    inputs = {"messages": [HumanMessage(content=rework_instruction)]}
                    
                    try:
                        for chunk in st.session_state.doc_agent.stream(inputs, stream_mode="values"):
                            pass 
                            
                        # If success, the doc_agent wrote the new file to target_path via its tool.
                        if os.path.exists(selected_file):
                            os.remove(selected_file)
                        st.success(f"Rewrite complete! Saved to {target_path}. Refreshing...")
                        time.sleep(2)
                        st.rerun()
                        
                    except Exception as e:
                        error_msg = str(e).lower()
                        if "429" in error_msg or "rate limit" in error_msg:
                            st.error("Azure Rate Limit Hit! Please wait a minute and try again.")
                        else:
                            st.error(f"Error during rework: {e}")

st.sidebar.markdown("---")
st.sidebar.title("Pipeline Controls")
if st.sidebar.button("▶ Run Full Pipeline (main.py)"):
    st.sidebar.info("Pipeline started in background. Please check the terminal running Streamlit for logs.")
    import subprocess
    # Run synchronously in background
    subprocess.Popen(["python", "main.py"])
