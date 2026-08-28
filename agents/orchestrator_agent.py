import os
import glob
import time
from typing import TypedDict, Annotated, Sequence, List
import operator

from langchain_core.messages import BaseMessage, HumanMessage, AIMessage
from langchain_openai import AzureChatOpenAI
from langchain_core.prompts import ChatPromptTemplate, MessagesPlaceholder
from langgraph.graph import StateGraph, END
from pydantic import BaseModel, Field
from langchain_text_splitters import RecursiveCharacterTextSplitter, Language

from agents.ingestion_agent import create_ingestion_agent
from agents.documentation_agent import create_doc_agent
from agents.evaluation_agent import create_eval_agent

# Define the State for our Agentic Orchestrator
class AgentState(TypedDict):
    messages: Annotated[Sequence[BaseMessage], operator.add]
    next_node: str

# Define the structured output for the Supervisor
class Route(BaseModel):
    next_node: str = Field(
        description="The next agent to route to. Options are: 'Ingestion', 'Documentation', 'Evaluation', or 'FINISH'."
    )

def create_orchestrator_agent():
    # Initialize the LLM (gpt-4o) for the Supervisor
    llm = AzureChatOpenAI(
        api_key=os.environ.get("AZURE_OPENAI_KEY_GPT4o"),
        azure_endpoint=os.environ.get("AZURE_OPENAI_ENDPOINT"),
        azure_deployment=os.environ.get("AZURE_OPENAI_DEPLOYMENT"),
        api_version="2025-01-01-preview",
        temperature=0,
    )
    
    system_prompt = (
        "You are an Agentic Orchestrator (Supervisor). Your job is to manage a multi-agent pipeline for a legacy Java codebase.\n"
        "You manage three specialized teams/nodes:\n"
        "1. 'Ingestion': Indexes the codebase.\n"
        "2. 'Documentation': Generates markdown documentation.\n"
        "3. 'Evaluation': Evaluates the generated documentation for quality.\n\n"
        "Based on the conversation history and user requests, decide which team should act next.\n"
        "If all requested tasks are complete, output 'FINISH'."
    )
    
    prompt = ChatPromptTemplate.from_messages([
        ("system", system_prompt),
        MessagesPlaceholder(variable_name="messages"),
        ("system", "Given the conversation above, who should act next? Respond with exactly one of: Ingestion, Documentation, Evaluation, FINISH")
    ])
    
    def supervisor_node(state: AgentState):
        # Bind the LLM to strictly output the structured Route object
        supervisor_chain = prompt | llm.with_structured_output(Route)
        result = supervisor_chain.invoke(state)
        return {"next_node": result.next_node}
        
    def ingestion_node(state: AgentState):
        print("\n[Orchestrator] Launching Ingestion Agent...")
        agent = create_ingestion_agent()
        
        # Pass the original user instruction to the sub-agent
        result_text = ""
        for chunk in agent.stream({"messages": [state["messages"][0]]}, stream_mode="values"):
            result_text = chunk["messages"][-1].content
            
        return {"messages": [AIMessage(content=f"Ingestion Agent finished: {result_text}", name="Ingestion")]}

    def documentation_node(state: AgentState):
        print("\n[Orchestrator] Launching Documentation Agent...")
        agent = create_doc_agent()
        java_files = glob.glob("legacy_source/**/*.java", recursive=True)
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
                    chunk_id = f"chunk_{i+1:02d}"
                    print(f"  -> Agent generating doc for {base_name}/{chunk_id}")
                    doc_instruction = (
                        f"Read this chunk from '{java_file}'. "
                        f"Generate markdown documentation and write it to 'documentation/{base_name}/{chunk_id}.md'.\n"
                        f"Code:\n```java\n{chunk_text}\n```"
                    )
                    inputs = {"messages": [HumanMessage(content=doc_instruction)]}
                    
                    # Run the doc agent for this chunk
                    for _ in agent.stream(inputs, stream_mode="values"):
                        pass
                    
                    doc_results.append(f"Documented {base_name}/{chunk_id}.md")
                    time.sleep(1) # Prevent rate limits
            except Exception as e:
                doc_results.append(f"Error documenting {java_file}: {e}")
                
        summary = f"Documentation Agent finished processing {len(doc_results)} chunks."
        return {"messages": [AIMessage(content=summary, name="Documentation")]}

    def evaluation_node(state: AgentState):
        print("\n[Orchestrator] Launching Evaluation Agent...")
        agent = create_eval_agent()
        java_files = glob.glob("legacy_source/**/*.java", recursive=True)
        java_splitter = RecursiveCharacterTextSplitter.from_language(
            language=Language.JAVA, chunk_size=10000, chunk_overlap=1000
        )
        
        eval_results = []
        for java_file in java_files:
            try:
                with open(java_file, 'r', encoding='utf-8') as f:
                    code = f.read()
                chunks = java_splitter.split_text(code)
                base_name = os.path.basename(java_file).replace('.java', '')
                
                for i, chunk_text in enumerate(chunks):
                    chunk_id = f"chunk_{i+1:02d}"
                    doc_path = f"documentation/{base_name}/{chunk_id}.md"
                    
                    if os.path.exists(doc_path):
                        print(f"  -> Agent evaluating {base_name}/{chunk_id}")
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
                            
                        if "RESULT: FAIL" in eval_response.upper():
                            flagged_dir = f"flagged_documents/{base_name}"
                            os.makedirs(flagged_dir, exist_ok=True)
                            flagged_path = f"{flagged_dir}/{chunk_id}.md"
                            
                            with open(flagged_path, 'w', encoding='utf-8') as f:
                                f.write(f"<!-- EVALUATOR FEEDBACK:\n{eval_response}\n-->\n\n{generated_doc}")
                            os.remove(doc_path)
                            eval_results.append(f"Flagged {base_name}/{chunk_id}.md")
                            print(f"     [FAIL] Moved to flagged_documents")
                        else:
                            eval_results.append(f"Passed {base_name}/{chunk_id}.md")
                            print(f"     [PASS]")
                            
                        time.sleep(1) # Prevent rate limits
            except Exception as e:
                pass
                
        summary = f"Evaluation Agent finished. Processed {len(eval_results)} files."
        return {"messages": [AIMessage(content=summary, name="Evaluation")]}

    # Compile the StateGraph
    workflow = StateGraph(AgentState)
    
    workflow.add_node("Supervisor", supervisor_node)
    workflow.add_node("Ingestion", ingestion_node)
    workflow.add_node("Documentation", documentation_node)
    workflow.add_node("Evaluation", evaluation_node)
    
    # All worker nodes report back to the Supervisor
    workflow.add_edge("Ingestion", "Supervisor")
    workflow.add_edge("Documentation", "Supervisor")
    workflow.add_edge("Evaluation", "Supervisor")
    
    workflow.set_entry_point("Supervisor")
    
    # The Supervisor decides what to do next based on the state
    workflow.add_conditional_edges(
        "Supervisor",
        lambda state: state["next_node"],
        {
            "Ingestion": "Ingestion",
            "Documentation": "Documentation",
            "Evaluation": "Evaluation",
            "FINISH": END
        }
    )
    
    return workflow.compile()
