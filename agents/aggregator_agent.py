import os
import glob

def run_aggregator():
    """
    Aggregates all markdown chunks in documentation/ into master_docs/.
    This uses the 'copy/paste' concatenation method directly, bypassing the LLM
    to ensure 100% data retention and save API costs.
    """
    if not os.path.exists("documentation"):
        raise FileNotFoundError("No documentation folder found to aggregate.")

    class_dirs = [d for d in os.listdir("documentation") if os.path.isdir(os.path.join("documentation", d))]
    
    for c_dir in class_dirs:
        md_files = glob.glob(f"documentation/{c_dir}/*.md")
        # Sort to ensure chunk_01, chunk_02, etc. are processed in order
        md_files.sort()
        
        all_content = []
        for f_path in md_files:
            with open(f_path, 'r', encoding='utf-8') as file:
                all_content.append(file.read())
                
        combined_content = "\n\n=== NEXT CHUNK ===\n\n".join(all_content)
        
        master_dir = "master_docs"
        os.makedirs(master_dir, exist_ok=True)
        master_path = os.path.join(master_dir, f"{c_dir}_Master.md")
        
        with open(master_path, "w", encoding="utf-8") as f:
            f.write(f"# MASTER DOCUMENT: {c_dir}\n\n")
            f.write(combined_content)
            
    return f"Successfully aggregated documentation into {master_dir}/"
