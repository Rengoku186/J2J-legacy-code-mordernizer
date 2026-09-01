import streamlit as st
import os
import glob
import time
import json
import subprocess
import sys
from dotenv import load_dotenv
from langchain_core.messages import HumanMessage
from agents.documentation_agent import create_doc_agent

# Initialize environment
load_dotenv()
if "doc_agent" not in st.session_state:
    st.session_state.doc_agent = create_doc_agent()

st.set_page_config(page_title="Agentic Modernization Dashboard", layout="wide", page_icon="⚡")

# Custom CSS for Premium UI
st.markdown("""
<style>
    /* Global styles and typography */
    @import url('https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap');
    
    html, body, [class*="css"] {
        font-family: 'Outfit', sans-serif;
    }
    
    /* App background */
    .stApp {
        background: linear-gradient(135deg, #0f172a 0%, #1e1b4b 100%);
        color: #e2e8f0;
    }
    
    /* Headings */
    h1, h2, h3 {
        color: #f8fafc !important;
        font-weight: 700 !important;
        letter-spacing: -0.5px;
    }
    
    /* Glassmorphism Containers (Cards, tabs) */
    div.stTabs [data-baseweb="tab-list"] {
        background: rgba(255, 255, 255, 0.05);
        border-radius: 12px;
        padding: 5px;
        backdrop-filter: blur(10px);
        border: 1px solid rgba(255,255,255,0.1);
        gap: 10px;
    }
    
    div.stTabs [data-baseweb="tab"] {
        color: #94a3b8 !important;
        border-radius: 8px !important;
        padding: 10px 20px !important;
        font-weight: 600;
        transition: all 0.3s ease;
    }
    
    div.stTabs [aria-selected="true"] {
        background: rgba(255, 255, 255, 0.15) !important;
        color: #ffffff !important;
        border-bottom: 2px solid #8b5cf6 !important;
    }
    
    /* Buttons */
    div.stButton > button {
        background: linear-gradient(90deg, #6366f1 0%, #8b5cf6 100%) !important;
        color: white !important;
        border: none !important;
        border-radius: 8px !important;
        padding: 12px 24px !important;
        font-weight: 600 !important;
        box-shadow: 0 4px 15px rgba(99, 102, 241, 0.4) !important;
        transition: transform 0.2s ease, box-shadow 0.2s ease !important;
    }
    
    div.stButton > button:hover {
        transform: translateY(-2px) !important;
        box-shadow: 0 6px 20px rgba(99, 102, 241, 0.6) !important;
    }
    
    /* Input areas */
    .stTextArea textarea {
        background: rgba(15, 23, 42, 0.6) !important;
        border: 1px solid rgba(139, 92, 246, 0.3) !important;
        color: #f8fafc !important;
        border-radius: 8px !important;
        padding: 12px !important;
    }
    
    .stTextArea textarea:focus {
        border-color: #8b5cf6 !important;
        box-shadow: 0 0 0 2px rgba(139, 92, 246, 0.2) !important;
    }

    /* Expanders */
    .streamlit-expanderHeader {
        background: rgba(255, 255, 255, 0.05) !important;
        border-radius: 8px !important;
        border: 1px solid rgba(255, 255, 255, 0.1) !important;
        color: #e2e8f0 !important;
        font-weight: 600 !important;
    }
</style>
""", unsafe_allow_html=True)

st.title("⚡ Agentic Modernization Dashboard")
st.markdown("Monitor and control the LangGraph-based Orchestrator pipeline.")

tab1, tab2, tab3 = st.tabs(["🚀 Agentic Orchestrator", "🔍 Audit Report", "✍️ Rework Flagged Docs"])

# ==========================================
# TAB 1: AGENTIC ORCHESTRATOR
# ==========================================
with tab1:
    st.markdown("### Full Agentic Pipeline")
    st.write("Launch the autonomous Supervisor to orchestrate Ingestion, Documentation, Evaluation, Aggregation, and Code Generation.")
    
    if st.button("▶ Launch Agentic Pipeline", use_container_width=True):
        with st.spinner("Pipeline is running in the background... This may take several minutes."):
            try:
                # Using subprocess to run the orchestrator script synchronously.
                result = subprocess.run(
                    [sys.executable, "agentic_main.py"], 
                    capture_output=True, 
                    text=True
                )
                if result.returncode == 0:
                    st.success("✅ Workflow completed successfully!")
                    with st.expander("View Logs"):
                        st.code(result.stdout)
                else:
                    st.error("❌ Pipeline failed or threw an error.")
                    with st.expander("View Error Logs"):
                        st.code(result.stderr)
            except Exception as e:
                st.error(f"Failed to launch pipeline: {e}")

# ==========================================
# TAB 2: AUDIT REPORT
# ==========================================
with tab2:
    st.markdown("### Evaluation Audit Report")
    st.write("Review the QA outcome of every evaluated chunk.")
    
    if os.path.exists("audit_report.json"):
        with open("audit_report.json", "r", encoding="utf-8") as f:
            try:
                audit_data = json.load(f)
                
                # Metrics row
                total = len(audit_data)
                passed = sum(1 for d in audit_data if d.get("status") == "passed")
                flagged = total - passed
                
                col1, col2, col3 = st.columns(3)
                col1.metric("Total Chunks Evaluated", total)
                col2.metric("Passed", passed)
                col3.metric("Flagged", flagged)
                
                st.markdown("---")
                
                for item in audit_data:
                    status_emoji = "✅" if item.get("status") == "passed" else "❌"
                    with st.expander(f"{status_emoji} {item.get('source_file')} - {item.get('chunk_id')}"):
                        st.write(f"**Status:** {item.get('status').upper()}")
                        st.markdown("**Evaluator Feedback:**")
                        
                        # Try to format JSON beautifully if it's raw string JSON
                        feedback = item.get("feedback", "")
                        try:
                            # Strip markdown if present
                            clean_fb = feedback.strip()
                            if clean_fb.startswith("```json"): clean_fb = clean_fb[7:]
                            if clean_fb.endswith("```"): clean_fb = clean_fb[:-3]
                            fb_json = json.loads(clean_fb.strip())
                            st.json(fb_json)
                        except:
                            st.code(feedback)
            except json.JSONDecodeError:
                st.error("Failed to parse audit_report.json.")
    else:
        st.info("No audit report found. Run the pipeline first.")

# ==========================================
# TAB 3: REWORK FLAGGED DOCS
# ==========================================
with tab3:
    st.markdown("### Human-in-the-Loop Refinement")
    flagged_files = glob.glob("flagged_documents/**/*.md", recursive=True)
    
    if not flagged_files:
        st.success("🎉 Pipeline is clean. No documents are flagged for review.")
    else:
        selected_file = st.selectbox("Select a file to review:", flagged_files)
        
        st.write(f"**Reviewing File:** `{selected_file}`")
        
        with open(selected_file, 'r', encoding='utf-8') as f:
            content = f.read()
            
        col1, col2 = st.columns([2, 1])
        
        with col1:
            st.markdown("#### Document Content (with Feedback)")
            st.markdown(f'<div style="background: rgba(0,0,0,0.3); padding: 15px; border-radius: 8px; max-height: 500px; overflow-y: auto;">{content}</div>', unsafe_allow_html=True)
            
        with col2:
            st.markdown("#### Human Action")
            user_comments = st.text_area("Add your comments for the rewrite:", height=150)
            
            target_path = selected_file.replace("flagged_documents", "documentation").replace("\\", "/")
            
            if st.button("✅ Approve (No Rewrite)", use_container_width=True):
                os.makedirs(os.path.dirname(target_path), exist_ok=True)
                os.rename(selected_file, target_path)
                st.success(f"Moved to {target_path}. Refreshing...")
                time.sleep(1)
                st.rerun()
                
            if st.button("🔄 Send for Rework", use_container_width=True):
                if not user_comments.strip():
                    st.error("Please add comments before sending for rework.")
                else:
                    with st.spinner("Agent is rewriting the documentation..."):
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
