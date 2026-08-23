---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_14"
confidence_score: 0.9
external_dependencies: ["BatchCheque"]
---

# Documentation for Code Chunk

This code chunk is part of a Java application that appears to manage cheque processing, including batch details and stuck transactions. Below is a detailed explanation of the methods in this chunk:

## Methods

### `displayBatchDetails(String batchId)`
This method retrieves and displays the details of a specific batch of cheques identified by the `batchId`.

#### Parameters:
- `batchId` (String): The unique identifier for the batch of cheques.

#### Functionality:
1. Retrieves the list of `BatchCheque` objects associated with the given `batchId` from the `batches` map.
2. If no batch is found for the given `batchId`, it prints "Batch not found." and exits the method.
3. If a batch is found, it iterates through the list of `BatchCheque` objects and prints the details of each cheque, including:
   - Account number
   - Cheque number
   - Amount
   - Currency

#### Dependencies:
- `BatchCheque`: A class representing a cheque in a batch. It contains fields such as `accountNumber`, `chequeNumber`, `amount`, and `currency`.
- `batches`: A `Map` that stores batch IDs as keys and lists of `BatchCheque` objects as values.

---

### `markTransactionStuck(String chequeNumber)`
This method marks a cheque as "stuck" by adding its cheque number to a collection of stuck transactions.

#### Parameters:
- `chequeNumber` (String): The unique identifier of the cheque to be marked as stuck.

#### Functionality:
1. Adds the `chequeNumber` to the `stuckTransactions` collection.
2. Prints a confirmation message indicating that the cheque has been marked as stuck.

#### Dependencies:
- `stuckTransactions`: A collection (likely a `Set` or `List`) that stores the cheque numbers of stuck transactions.

---

### `resetStuckTransaction(String chequeNumber)`
This method removes a cheque from the list of stuck transactions.

#### Parameters:
- `chequeNumber` (String): The unique identifier of the cheque to be reset.

#### Functionality:
1. Attempts to remove the `chequeNumber` from the `stuckTransactions` collection.
2. If the cheque number is successfully removed, it prints a confirmation message.
3. If the cheque number is not found in the `stuckTransactions` collection, it prints a message indicating that the cheque was not marked as stuck.

#### Dependencies:
- `stuckTransactions`: A collection that stores the cheque numbers of stuck transactions.

---

### `displayStuckTransactions()`
This method displays all the cheque numbers currently marked as stuck.

#### Parameters:
- None

#### Functionality:
1. Prints a header "--- Stuck Transactions ---".
2. If the `stuckTransactions` collection is empty, it prints "No stuck transactions.".
3. If the collection is not empty, it iterates through the `stuckTransactions` collection and prints each cheque number.

#### Dependencies:
- `stuckTransactions`: A collection that stores the cheque numbers of stuck transactions.

---

## External Dependencies
- **`BatchCheque`**: A class representing a cheque in a batch. It is used in the `displayBatchDetails` method to access cheque details such as `accountNumber`, `chequeNumber`, `amount`, and `currency`.
- **`batches`**: A `Map` that associates batch IDs with lists of `BatchCheque` objects. It is used in the `displayBatchDetails` method.
- **`stuckTransactions`**: A collection (likely a `Set` or `List`) that stores the cheque numbers of stuck transactions. It is used in the `markTransactionStuck`, `resetStuckTransaction`, and `displayStuckTransactions` methods.