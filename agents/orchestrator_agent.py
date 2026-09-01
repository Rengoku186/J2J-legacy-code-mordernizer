import os
import glob
import time
import json
import sqlite3
from typing import TypedDict, Annotated, Sequence, List
import operator

from langchain_core.messages import BaseMessage, HumanMessage, AIMessage
from langchain_core.prompts import ChatPromptTemplate, MessagesPlaceholder
from langgraph.graph import StateGraph, END
from langgraph.checkpoint.sqlite import SqliteSaver
from pydantic import BaseModel, Field
from langchain_text_splitters import RecursiveCharacterTextSplitter, Language

from agents.ingestion_agent import create_ingestion_agent
from agents.documentation_agent import create_doc_agent
from agents.evaluation_agent import create_eval_agent
from agents.aggregator_agent import run_aggregator
from agents.code_generator_agent import run_code_generation
import config
from utils import setup_logger, generate_chunk_id

logger = setup_logger("Orchestrator")

# Define the State for our Agentic Orchestrator
class AgentState(TypedDict):
    messages: Annotated[Sequence[BaseMessage], operator.add]
    next_node: str
    steps: int

# Define the structured output for the Supervisor
class Route(BaseModel):
    next_node: str = Field(
        description="The next agent to route to. Options are: 'Ingestion', 'Documentation', 'Evaluation', 'Aggregation', 'CodeGeneration', or 'FINISH'."
    )

def create_orchestrator_agent():
    llm = config.get_llm()
    
    system_prompt = (
        "You are an Agentic Orchestrator (Supervisor) managing a strict, sequential multi-agent RAG and modernization pipeline for a legacy Java codebase.\n"
        "You must route execution through specialized teams in a specific order. Do NOT deviate from this workflow or hallucinate steps.\n\n"
        "TEAMS AND RESPONSIBILITIES:\n"
        "1. 'Ingestion': Your first step. It scans the legacy source, chunks it, and embeds it.\n"
        "2. 'Documentation': Your second step. It iterates through the chunks and writes Markdown documentation.\n"
        "3. 'Evaluation': Your third step. It acts as a QA agent, evaluating the generated markdown, moving failures to a flagged folder.\n"
        "4. 'Aggregation': Your fourth step. Combines passing markdown chunks into Master Documents.\n"
        "5. 'CodeGeneration': Your final step. Generates modernized Spring Boot code from the Master Documents.\n\n"
        "ROUTING RULES:\n"
        "- Read the conversation history to identify the current stage.\n"
        "- Route strictly sequentially: Ingestion -> Documentation -> Evaluation -> Aggregation -> CodeGeneration -> FINISH.\n"
        "- Only output 'FINISH' after 'CodeGeneration' has reported completion.\n"
    )
    
    prompt = ChatPromptTemplate.from_messages([
        ("system", system_prompt),
        MessagesPlaceholder(variable_name="messages"),
        ("system", "Given the conversation above, who should act next? Respond with exactly one of: Ingestion, Documentation, Evaluation, Aggregation, CodeGeneration, FINISH")
    ])
    
    def supervisor_node(state: AgentState):
        current_steps = state.get("steps", 0)
        
        # Max iteration guard
        if current_steps > 30:
            logger.warning("[Orchestrator] Max steps exceeded. Forcing FINISH.")
            return {"next_node": "FINISH", "steps": current_steps + 1}
            
        supervisor_chain = prompt | llm.with_structured_output(Route)
        result = supervisor_chain.invoke(state)
        return {"next_node": result.next_node, "steps": current_steps + 1}
        
    def ingestion_node(state: AgentState):
        logger.info("\n[Orchestrator] Launching Ingestion Agent...")
        agent = create_ingestion_agent()
        
        # Pass the original user instruction to the sub-agent
        result_text = ""
        for chunk in agent.stream({"messages": [state["messages"][0]]}, stream_mode="values"):
            result_text = chunk["messages"][-1].content
            
        return {"messages": [AIMessage(content=f"Ingestion Agent finished: {result_text}", name="Ingestion")]}

    def documentation_node(state: AgentState):
        logger.info("\n[Orchestrator] Launching Documentation Agent...")
        agent = create_doc_agent()
        java_files = glob.glob(f"{config.LEGACY_SOURCE_DIR}/**/*.java", recursive=True)
        java_splitter = RecursiveCharacterTextSplitter.from_language(
            language=Language.JAVA, chunk_size=10000, chunk_overlap=1000
        )
        
        doc_results = []
        for java_file in java_files:
            try:
                with open(java_file, 'r', encoding='utf-8') as f:
                    code = f.read()
                chunks = java_splitter.split_text(code)
                base_name = os.path.basename(java_file).replace('.java', '')
                
                for i, chunk_text in enumerate(chunks):
                    chunk_id = generate_chunk_id(i)
                    logger.info(f"  -> Agent generating doc for {base_name}/{chunk_id}")
                    doc_instruction = (
                        f"Read this chunk from '{java_file}'. "
                        f"Generate markdown documentation and write it to '{config.DOCUMENTATION_DIR}/{base_name}/{chunk_id}.md'.\n"
                        f"Code:\n```java\n{chunk_text}\n```"
                    )
                    inputs = {"messages": [HumanMessage(content=doc_instruction)]}
                    
                    # Run the doc agent for this chunk
                    for _ in agent.stream(inputs, stream_mode="values"):
                        pass
                    
                    doc_results.append(f"Documented {base_name}/{chunk_id}.md")
                    time.sleep(1) # Prevent rate limits
            except Exception as e:
                logger.error(f"Error documenting {java_file}: {e}")
                doc_results.append(f"Error documenting {java_file}: {e}")
                
        summary = f"Documentation Agent finished processing {len(doc_results)} chunks."
        return {"messages": [AIMessage(content=summary, name="Documentation")]}

    def evaluation_node(state: AgentState):
        logger.info("\n[Orchestrator] Launching Evaluation Agent...")
        agent = create_eval_agent()
        java_files = glob.glob(f"{config.LEGACY_SOURCE_DIR}/**/*.java", recursive=True)
        java_splitter = RecursiveCharacterTextSplitter.from_language(
            language=Language.JAVA, chunk_size=10000, chunk_overlap=1000
        )
        
        eval_results = []
        audit_log = []
        for java_file in java_files:
            try:
                with open(java_file, 'r', encoding='utf-8') as f:
                    code = f.read()
                chunks = java_splitter.split_text(code)
                base_name = os.path.basename(java_file).replace('.java', '')
                
                for i, chunk_text in enumerate(chunks):
                    chunk_id = generate_chunk_id(i)
                    doc_path = f"{config.DOCUMENTATION_DIR}/{base_name}/{chunk_id}.md"
                    
                    if os.path.exists(doc_path):
                        logger.info(f"  -> Agent evaluating {base_name}/{chunk_id}")
                        with open(doc_path, 'r', encoding='utf-8') as f:
                            generated_doc = f.read()
                            
                        eval_instruction = (
                            f"Evaluate the following documentation against the source Java chunk.\n"
                            f"Source Java Chunk:\n```java\n{chunk_text}\n```\n"
                            f"Generated Documentation:\n```markdown\n{generated_doc}\n```"
                        )
                        eval_inputs = {"messages": [HumanMessage(content=eval_instruction)]}
                        
                        eval_response = ""
                        for eval_chunk in agent.stream(eval_inputs, stream_mode="values"):
                            eval_response = eval_chunk["messages"][-1].content
                            
                        # Parse structured JSON output
                        try:
                            clean_response = eval_response.strip()
                            if clean_response.startswith("```json"):
                                clean_response = clean_response[7:]
                            if clean_response.endswith("```"):
                                clean_response = clean_response[:-3]
                            eval_json = json.loads(clean_response.strip())
                            passed = eval_json.get("passed", False)
                        except json.JSONDecodeError:
                            logger.error(f"Failed to parse Evaluation Agent response as JSON: {eval_response}")
                            passed = False # Default to fail if parsing error
                            
                        if not passed:
                            flagged_dir = f"{config.FLAGGED_DIR}/{base_name}"
                            os.makedirs(flagged_dir, exist_ok=True)
                            flagged_path = f"{flagged_dir}/{chunk_id}.md"
                            
                            with open(flagged_path, 'w', encoding='utf-8') as f:
                                f.write(f"<!-- EVALUATOR FEEDBACK:\n{eval_response}\n-->\n\n{generated_doc}")
                            os.remove(doc_path)
                            eval_results.append(f"Flagged {base_name}/{chunk_id}.md")
                            logger.info(f"     [FAIL] Moved to flagged_documents")
                            audit_log.append({
                                "chunk_id": chunk_id,
                                "source_file": java_file,
                                "status": "flagged",
                                "feedback": eval_response
                            })
                        else:
                            eval_results.append(f"Passed {base_name}/{chunk_id}.md")
                            logger.info(f"     [PASS]")
                            audit_log.append({
                                "chunk_id": chunk_id,
                                "source_file": java_file,
                                "status": "passed",
                                "feedback": eval_response
                            })
                            
                        time.sleep(1) # Prevent rate limits
            except Exception as e:
                logger.error(f"Error evaluating {java_file}: {e}")
                eval_results.append(f"Error evaluating {java_file}: {e}")
                
        try:
            with open(config.AUDIT_REPORT_PATH, 'w', encoding='utf-8') as f:
                json.dump(audit_log, f, indent=2)
            logger.info(f"Wrote audit report to {config.AUDIT_REPORT_PATH}")
        except Exception as e:
            logger.error(f"Failed to write audit report: {e}")

        summary = f"Evaluation Agent finished. Processed {len(eval_results)} files."
        return {"messages": [AIMessage(content=summary, name="Evaluation")]}
        
    def aggregation_node(state: AgentState):
        logger.info("\n[Orchestrator] Launching Aggregation Agent...")
        try:
            summary = run_aggregator()
        except Exception as e:
            logger.error(f"Error during aggregation: {e}")
            summary = f"Error during aggregation: {e}"
        return {"messages": [AIMessage(content=summary, name="Aggregation")]}
        
    def code_generation_node(state: AgentState):
        logger.info("\n[Orchestrator] Launching Code Generation Agent...")
        try:
            summary = run_code_generation()
        except Exception as e:
            logger.error(f"Error during code generation: {e}")
            summary = f"Error during code generation: {e}"
        return {"messages": [AIMessage(content=summary, name="CodeGeneration")]}

    # Compile the StateGraph
    workflow = StateGraph(AgentState)
    
    workflow.add_node("Supervisor", supervisor_node)
    workflow.add_node("Ingestion", ingestion_node)
    workflow.add_node("Documentation", documentation_node)
    workflow.add_node("Evaluation", evaluation_node)
    workflow.add_node("Aggregation", aggregation_node)
    workflow.add_node("CodeGeneration", code_generation_node)
    
    # All worker nodes report back to the Supervisor
    workflow.add_edge("Ingestion", "Supervisor")
    workflow.add_edge("Documentation", "Supervisor")
    workflow.add_edge("Evaluation", "Supervisor")
    workflow.add_edge("Aggregation", "Supervisor")
    workflow.add_edge("CodeGeneration", "Supervisor")
    
    workflow.set_entry_point("Supervisor")
    
    # The Supervisor decides what to do next based on the state
    workflow.add_conditional_edges(
        "Supervisor",
        lambda state: state["next_node"],
        {
            "Ingestion": "Ingestion",
            "Documentation": "Documentation",
            "Evaluation": "Evaluation",
            "Aggregation": "Aggregation",
            "CodeGeneration": "CodeGeneration",
            "FINISH": END
        }
    )
    
    conn = sqlite3.connect(config.SQLITE_DB_PATH, check_same_thread=False)
    memory = SqliteSaver(conn)
    return workflow.compile(checkpointer=memory)
