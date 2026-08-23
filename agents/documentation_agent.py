import os
from langchain_core.tools import tool
from langchain_openai import AzureChatOpenAI
from langgraph.prebuilt import create_react_agent
from langchain_community.embeddings.fastembed import FastEmbedEmbeddings
from langchain_community.vectorstores import Chroma

@tool
def read_java_file(file_path: str) -> str:
    """Reads and returns the contents of a Java file given its file path."""
    print(f"[Tool Execution] Reading code from: {file_path}")
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            return f.read()
    except Exception as e:
        return f"Error reading file: {e}"

@tool
def write_documentation(file_path: str, content: str) -> str:
    """Writes the provided markdown documentation content to the specified file path."""
    print(f"[Tool Execution] Writing documentation to: {file_path}")
    try:
        # Ensure the directory exists
        os.makedirs(os.path.dirname(os.path.abspath(file_path)), exist_ok=True)
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(content)
        return f"Successfully wrote documentation to {file_path}"
    except Exception as e:
        return f"Error writing to file: {e}"

@tool
def search_codebase(query: str) -> str:
    """Searches the vector database for code chunks matching the query to provide context."""
    print(f"[Tool Execution] Searching codebase for: {query}")
    import time
    time.sleep(3)  # Slow down the agent's LLM calls to respect rate limits
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

def create_doc_agent():
    # Initialize the LLM (gpt-4o) using Azure
    llm = AzureChatOpenAI(
        api_key=os.environ.get("AZURE_OPENAI_KEY_GPT4o"),
        azure_endpoint=os.environ.get("AZURE_OPENAI_ENDPOINT"),
        azure_deployment=os.environ.get("AZURE_OPENAI_DEPLOYMENT"),
        api_version="2025-01-01-preview",
        temperature=0,
        max_retries=6
    )
    
    tools = [read_java_file, write_documentation, search_codebase]
    
    system_prompt = """
    You are an autonomous expert technical writer and Java developer. 
    Your task is to read a chunk of a legacy Java codebase, generate well-structured and easy-to-read Markdown documentation for it, and save the documentation.
    
    IMPORTANT METADATA REQUIREMENT:
    Every Markdown file you generate MUST begin with a YAML frontmatter block containing metadata. For example:
    ---
    original_file: "path/to/file.java"
    language: "Java"
    chunk_id: "<generate_a_unique_id>"
    confidence_score: <score_between_0.0_and_1.0>
    external_dependencies: [<list_of_external_classes>]
    ---
    
    Below the metadata, document the specific chunk of code provided. Explain its purpose and methods.
    You have tools to read files, write files, and search the codebase.
    If you encounter unknown methods or classes in the chunk you are reading, use the search_codebase tool to find their definitions before writing the documentation.
    """
    
    return create_react_agent(llm, tools, prompt=system_prompt)
