import os
from langchain_core.tools import tool
from langchain_openai import AzureChatOpenAI
from langgraph.prebuilt import create_react_agent
from langchain_community.embeddings.fastembed import FastEmbedEmbeddings
from langchain_community.vectorstores import Chroma

@tool
def search_codebase(query: str) -> str:
    """Searches the vector database for code chunks matching the query to verify accuracy."""
    print(f"[Eval Tool Execution] Searching codebase for: {query}")
    import time
    time.sleep(3)
    try:
        embeddings = FastEmbedEmbeddings()
        vector_store = Chroma(persist_directory="./chroma_db", embedding_function=embeddings)
        results = vector_store.similarity_search(query, k=3)
        
        if not results:
            return "No matching code found in the database."
            
        context = "\n\n---\n\n".join([f"Source: {res.metadata.get('source', 'Unknown')}\n{res.page_content}" for res in results])
        return context
    except Exception as e:
        return f"Error searching codebase: {e}"

def create_eval_agent():
    llm = AzureChatOpenAI(
        api_key=os.environ.get("AZURE_OPENAI_KEY_GPT4o"),
        azure_endpoint=os.environ.get("AZURE_OPENAI_ENDPOINT"),
        azure_deployment=os.environ.get("AZURE_OPENAI_DEPLOYMENT"),
        api_version="2025-01-01-preview",
        temperature=0,
        max_retries=6
    )
    
    tools = [search_codebase]
    
    system_prompt = """
    You are an autonomous Document Evaluator Agent.
    Your task is to review Markdown documentation generated for a Java codebase.
    You must grade the documentation strictly on a Pass/Fail scale based on these 4 criteria:
    
    1. Completeness: Does the documentation cover the entire chunk provided?
    2. Accuracy: Are the descriptions technically correct based on the Java code?
    3. Dependency: Are external class calls properly identified and explained?
    4. Traceability: Is the origin (file and chunk) clearly traceable via YAML frontmatter?
    
    Use the search_codebase tool to verify accuracy and dependencies if needed.
    
    You MUST output your final evaluation in the following format:
    RESULT: [PASS or FAIL]
    FEEDBACK: [Provide your detailed feedback and reasons here]
    """
    
    return create_react_agent(llm, tools, prompt=system_prompt)
