import os
import glob
from langchain_core.tools import tool
from langchain_community.embeddings.fastembed import FastEmbedEmbeddings
from langchain_community.vectorstores import Chroma
from langchain_text_splitters import RecursiveCharacterTextSplitter, Language
from langgraph.prebuilt import create_react_agent
import config
from utils import setup_logger

logger = setup_logger("IngestionAgent")

# Initialize the embedding model and vector store globally
embeddings = FastEmbedEmbeddings()
vector_store = Chroma(persist_directory=config.CHROMA_DB_DIR, embedding_function=embeddings)

@tool
def list_files_in_directory(directory_path: str) -> list[str]:
    """Lists all Java files in the specified directory and its subdirectories."""
    logger.info(f"Listing files in: {directory_path}")
    pattern = os.path.join(directory_path, "**", "*.java")
    files = glob.glob(pattern, recursive=True)
    return files

@tool
def chunk_and_embed_file(file_path: str) -> str:
    """Reads a Java file, chunks it intelligently, and stores the embeddings in the vector database."""
    logger.info(f"Chunking and embedding: {file_path}")
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            code = f.read()
            
        java_splitter = RecursiveCharacterTextSplitter.from_language(
            language=Language.JAVA, 
            chunk_size=1000, 
            chunk_overlap=100
        )
        docs = java_splitter.create_documents([code], metadatas=[{"source": file_path}])
        
        # De-duplicate: Delete existing chunks for this file before inserting
        try:
            existing = vector_store.get(where={"source": file_path})
            if existing and existing.get("ids"):
                vector_store.delete(ids=existing["ids"])
        except Exception as e:
            logger.warning(f"Failed to clean up old chunks for {file_path}: {e}")
        
        # Save to ChromaDB safely using the global client
        vector_store.add_documents(docs)
        # Assuming Chroma auto-persists in this version, otherwise call vector_store.persist()
        return f"Successfully embedded {len(docs)} chunks from {file_path}"
    except Exception as e:
        logger.error(f"Error embedding file {file_path}: {e}")
        return f"Error embedding file {file_path}: {e}"

def create_ingestion_agent():
    llm = config.get_llm()
    
    tools = [list_files_in_directory, chunk_and_embed_file]
    
    system_prompt = """
    You are an autonomous Codebase Ingestion Agent.
    Your job is to index legacy codebases so that other agents can search them later.
    When given a directory, you should first list all the files in it.
    Then, iterate through those files and use the chunk_and_embed_file tool on each of them.
    Report back when all files have been successfully embedded.
    """
    
    return create_react_agent(llm, tools, prompt=system_prompt)
