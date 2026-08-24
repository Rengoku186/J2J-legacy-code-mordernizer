---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_27"
confidence_score: 0.95
external_dependencies: ["BatchCheque"]
---

# Documentation for `AdminService` Class and Related Methods

The provided code defines the `AdminService` class, which is a static inner class in the `DemoApplication` file. This class is responsible for managing master data, batch operations, and stuck transactions in a cheque processing system. Below is a detailed explanation of the class and its methods.

## Class: `AdminService`
The `AdminService` class provides functionality for:
1. Managing master data, such as IFSC codes and bank codes.
2. Handling batch operations for cheques.
3. Managing stuck transactions.

### Fields
- **`ifscToBankCode`**: A `Map<String, String>` that maps IFSC codes to bank codes.
- **`bankCodeToName`**: A `Map<String, String>` that maps bank codes to bank names.
- **`batches`**: A `Map<String, List<BatchCheque>>` that stores batches of cheques, where each batch is identified by a unique batch ID.
- **`stuckTransactions`**: A `Set<String>` that keeps track of cheque numbers marked as stuck.

### Methods

#### Master Data Management
1. **`addOrUpdateIFSC(String ifsc, String bankCode)`**
   - Adds or updates the mapping of an IFSC code to a bank code.
   - Prints a confirmation message.

2. **`addOrUpdateBankCode(String bankCode, String bankName)`**
   - Adds or updates the mapping of a bank code to a bank name.
   - Prints a confirmation message.

3. **`displayIFSCs()`**
   - Displays all IFSC-to-bank-code mappings.
   - Prints a message if no records are available.

4. **`displayBankCodes()`**
   - Displays all bank-code-to-bank-name mappings.
   - Prints a message if no records are available.

#### Batch Management
1. **`createBatch(String batchId, List<BatchCheque> cheques)`**
   - Creates a new batch of cheques and associates it with a unique batch ID.
   - Prints a confirmation message with the batch ID and the number of cheques in the batch.

2. **`displayBatches()`**
   - Displays a list of all batches and the number of cheques in each batch.
   - Prints a message if no batches are available.

3. **`displayBatchDetails(String batchId)`**
   - Displays detailed information about a specific batch, including account number, cheque number, amount, and currency for each cheque in the batch.
   - Prints a message if the batch is not found.

#### Stuck Transaction Management
1. **`markTransactionStuck(String chequeNumber)`**
   - Marks a cheque as stuck by adding its cheque number to the `stuckTransactions` set.
   - Prints a confirmation message.

2. **`resetStuckTransaction(String chequeNumber)`**
   - Removes a cheque number from the `stuckTransactions` set.
   - Prints a confirmation message if the cheque was successfully removed, or a message indicating that the cheque was not marked as stuck.

3. **`displayStuckTransactions()`**
   - Displays all cheque numbers currently marked as stuck.
   - Prints a message if no stuck transactions are found.

### External Dependencies
The `AdminService` class depends on the `BatchCheque` class, which represents a cheque in the system. The `BatchCheque` class has the following fields:
- **`accountNumber`**: The account number associated with the cheque.
- **`chequeNumber`**: The unique identifier for the cheque.
- **`currency`**: The currency in which the cheque is issued.
- **`amount`**: The amount of money specified on the cheque.
- **`signature`**: The signature on the cheque.

The `BatchCheque` class also includes a constructor to initialize these fields.

### Purpose
The `AdminService` class is designed to facilitate the management of master data, batch operations, and stuck transactions in a cheque processing system. It provides a structured way to handle these operations and ensures that the system can manage its data effectively.