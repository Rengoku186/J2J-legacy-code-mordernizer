---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_14"
confidence_score: 0.9
external_dependencies: ["BatchCheque"]
---

# Documentation for Code Chunk

This code chunk is part of a cheque processing application. It provides functionality for managing cheque batches and handling stuck transactions. Below is a detailed explanation of the methods included in this chunk:

## Methods

### `displayBatchDetails(String batchId)`
This method retrieves and displays the details of a specific cheque batch identified by its `batchId`.

- **Parameters:**
  - `batchId` (String): The unique identifier for the batch.
- **Functionality:**
  - Retrieves the list of cheques associated with the given `batchId` from the `batches` map.
  - If the batch is not found, it prints "Batch not found." and exits the method.
  - If the batch is found, it iterates through the list of `BatchCheque` objects and prints their details, including:
    - Account number
    - Cheque number
    - Amount
    - Currency

### `markTransactionStuck(String chequeNumber)`
This method marks a cheque as "stuck" by adding its cheque number to the `stuckTransactions` set.

- **Parameters:**
  - `chequeNumber` (String): The unique identifier for the cheque.
- **Functionality:**
  - Adds the `chequeNumber` to the `stuckTransactions` set.
  - Prints a confirmation message indicating that the cheque has been marked as stuck.

### `resetStuckTransaction(String chequeNumber)`
This method removes a cheque from the "stuck" list if it exists.

- **Parameters:**
  - `chequeNumber` (String): The unique identifier for the cheque.
- **Functionality:**
  - Attempts to remove the `chequeNumber` from the `stuckTransactions` set.
  - If successful, prints a confirmation message.
  - If the cheque was not in the "stuck" list, prints a message indicating that the cheque was not marked as stuck.

### `displayStuckTransactions()`
This method displays all cheques currently marked as "stuck."

- **Parameters:**
  - None
- **Functionality:**
  - Prints a header "--- Stuck Transactions ---".
  - If the `stuckTransactions` set is empty, prints "No stuck transactions.".
  - Otherwise, iterates through the set and prints each cheque number.

## External Dependencies

- **`BatchCheque`**: This class represents a cheque and is used to store details such as account number, cheque number, amount, and currency. The exact implementation of this class was not provided in the code chunk but is referenced in the `displayBatchDetails` method.

## Notes

- The `batches` map is used to store cheque batches, where the key is the batch ID and the value is a list of `BatchCheque` objects. This map is assumed to be defined elsewhere in the class.
- The `stuckTransactions` set is used to track cheques that are marked as "stuck." This set is also assumed to be defined elsewhere in the class.

This code is part of a larger application for managing cheque processing, and the methods here focus on batch management and handling stuck transactions.