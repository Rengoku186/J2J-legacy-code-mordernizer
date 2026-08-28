---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_14"
confidence_score: 0.95
external_dependencies: ["BatchCheque"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a cheque processing application. It provides functionality for managing and displaying details of cheque batches, as well as handling "stuck" transactions. The methods in this chunk interact with two key data structures:

- `batches`: A `Map` that associates batch IDs with lists of `BatchCheque` objects.
- `stuckTransactions`: A `Set` that tracks cheque numbers marked as "stuck."

### External Dependency
- **`BatchCheque`**: Represents a cheque with attributes such as account number, cheque number, amount, and currency.

## Methods

### `displayBatchDetails(String batchId)`
Displays the details of a specific cheque batch identified by its `batchId`.

#### Parameters:
- `batchId` (String): The unique identifier for the batch.

#### Behavior:
1. Retrieves the list of `BatchCheque` objects associated with the given `batchId` from the `batches` map.
2. If the batch is not found, prints "Batch not found."
3. If the batch is found, iterates through the list of cheques and prints their details, including:
   - Account number
   - Cheque number
   - Amount
   - Currency

#### Example Output:
```
Batch 123 details:
Account: 001 | Cheque: 1001 | Amount: 500.00 | Currency: USD
Account: 002 | Cheque: 1002 | Amount: 300.00 | Currency: USD
```

---

### `markTransactionStuck(String chequeNumber)`
Marks a cheque as "stuck" by adding its cheque number to the `stuckTransactions` set.

#### Parameters:
- `chequeNumber` (String): The unique identifier of the cheque.

#### Behavior:
1. Adds the `chequeNumber` to the `stuckTransactions` set.
2. Prints a confirmation message.

#### Example Output:
```
Cheque 1001 marked as stuck.
```

---

### `resetStuckTransaction(String chequeNumber)`
Removes a cheque from the "stuck" transactions list.

#### Parameters:
- `chequeNumber` (String): The unique identifier of the cheque.

#### Behavior:
1. Attempts to remove the `chequeNumber` from the `stuckTransactions` set.
2. If successful, prints a confirmation message.
3. If the cheque was not in the set, prints a message indicating that the cheque was not marked as stuck.

#### Example Output:
```
Cheque 1001 reset (removed from stuck list).
```
OR
```
Cheque 1001 was not marked as stuck.
```

---

### `displayStuckTransactions()`
Displays all cheques currently marked as "stuck."

#### Behavior:
1. Checks if the `stuckTransactions` set is empty.
2. If empty, prints "No stuck transactions."
3. If not empty, iterates through the set and prints each cheque number.

#### Example Output:
```
--- Stuck Transactions ---
Cheque: 1001
Cheque: 1002
```
OR
```
--- Stuck Transactions ---
No stuck transactions.
```

## Summary
This code chunk provides essential methods for managing cheque batches and handling stuck transactions. It allows users to view batch details, mark cheques as stuck, reset stuck cheques, and display all stuck transactions. The `BatchCheque` class is a key dependency, as it represents the individual cheques within a batch.