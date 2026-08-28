import os
import sys
from dotenv import load_dotenv
from langchain_core.messages import HumanMessage
from agents.orchestrator_agent import create_orchestrator_agent

# Load environment variables
load_dotenv()

if __name__ == "__main__":
    if not os.environ.get("AZURE_OPENAI_KEY_GPT4o"):
        print("Warning: AZURE_OPENAI_KEY_GPT4o environment variable is not set.")
        print("Please ensure your .env file has the Azure OpenAI credentials.")
        sys.exit(1)

    print("===========================================")
    print("Agentic Orchestrator Pipeline Started")
    print("===========================================")
    
    # Initialize the LangGraph Supervisor
    orchestrator = create_orchestrator_agent()
    
    # This is a high-level natural language prompt sent to the Supervisor.
    # The Supervisor will parse this and decide to route execution to Ingestion, then Documentation, then Evaluation.
    user_instruction = (
        "Please process the entire legacy_source codebase. "
        "First, run Ingestion to index the files. "
        "Second, run Documentation to generate the markdown docs. "
        "Third, run Evaluation to QA the generated docs. "
        "Finish when all three are complete."
    )
    
    inputs = {"messages": [HumanMessage(content=user_instruction)]}
    
    # Stream the graph execution
    for s in orchestrator.stream(inputs, stream_mode="values"):
        if "messages" in s and s["messages"]:
            message = s["messages"][-1]
            if message.name:
                print(f"\n--- Finished: {message.name} ---")
                print(message.content)
            elif isinstance(message, HumanMessage):
                print(f"\n--- User Instruction ---")
                print(message.content)
        if "next_node" in s:
            if s["next_node"] == "FINISH":
                print(f"\n[Supervisor] Task complete. Terminating graph.")
            else:
                print(f"\n[Supervisor Decision] Routing to: {s['next_node']}")

    print("\n===========================================")
    print("Workflow completed successfully!")
