import os
import glob
from langchain_core.tools import tool
from langchain_openai import AzureChatOpenAI
from langchain_community.embeddings.fastembed import FastEmbedEmbeddings
from langchain_community.vectorstores import Chroma
from langchain_text_splitters import RecursiveCharacterTextSplitter, Language
from langgraph.prebuilt import create_react_agent

# Initialize the embedding model and vector store globally
embeddings = FastEmbedEmbeddings()
vector_store_dir = "./chroma_db"
vector_store = Chroma(persist_directory=vector_store_dir, embedding_function=embeddings)

@tool
def list_files_in_directory(directory_path: str) -> list[str]:
    """Lists all Java files in the specified directory and its subdirectories."""
    print(f"[Ingestion Tool] Listing files in: {directory_path}")
    pattern = os.path.join(directory_path, "**", "*.java")
    files = glob.glob(pattern, recursive=True)
    return files

@tool
def chunk_and_embed_file(file_path: str) -> str:
    """Reads a Java file, chunks it intelligently, and stores the embeddings in the vector database."""
    print(f"[Ingestion Tool] Chunking and embedding: {file_path}")
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            code = f.read()
            
        java_splitter = RecursiveCharacterTextSplitter.from_language(
            language=Language.JAVA, 
            chunk_size=1000, 
            chunk_overlap=100
        )
        docs = java_splitter.create_documents([code], metadatas=[{"source": file_path}])
        
        # Save to ChromaDB safely using the global client
        vector_store.add_documents(docs)
        return f"Successfully embedded {len(docs)} chunks from {file_path}"
    except Exception as e:
        return f"Error embedding file {file_path}: {e}"

def create_ingestion_agent():
    llm = AzureChatOpenAI(
        api_key=os.environ.get("AZURE_OPENAI_KEY_GPT4o"),
        azure_endpoint=os.environ.get("AZURE_OPENAI_ENDPOINT"),
        azure_deployment=os.environ.get("AZURE_OPENAI_DEPLOYMENT"),
        api_version="2025-01-01-preview",
        temperature=0,
        max_retries=6
    )
    
    tools = [list_files_in_directory, chunk_and_embed_file]
    
    system_prompt = """
    You are an autonomous Codebase Ingestion Agent.
    Your job is to index legacy codebases so that other agents can search them later.
    When given a directory, you should first list all the files in it.
    Then, iterate through those files and use the chunk_and_embed_file tool on each of them.
    Report back when all files have been successfully embedded.
    """
    
    return create_react_agent(llm, tools, prompt=system_prompt)
