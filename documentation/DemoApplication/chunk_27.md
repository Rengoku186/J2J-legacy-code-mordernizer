---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_27"
confidence_score: 0.9
external_dependencies: ["BatchCheque"]
---

# Documentation for `AdminService` Class

The `AdminService` class is a static inner class within the `DemoApplication` class. It is responsible for managing master data, batch transactions, and stuck transactions. This class provides methods to handle IFSC and bank code mappings, manage cheque batches, and track stuck transactions.

## Fields

### Master Data
- **`ifscToBankCode`**: A `Map<String, String>` that stores mappings between IFSC codes and bank codes.
- **`bankCodeToName`**: A `Map<String, String>` that stores mappings between bank codes and bank names.

### Batch Management
- **`batches`**: A `Map<String, List<BatchCheque>>` that stores batches of cheques, where each batch is identified by a unique batch ID.

### Stuck Transactions
- **`stuckTransactions`**: A `Set<String>` that stores cheque numbers marked as stuck.

## Methods

### Master Data Management

#### `addOrUpdateIFSC(String ifsc, String bankCode)`
Adds or updates the mapping of an IFSC code to a bank code.
- **Parameters**:
  - `ifsc`: The IFSC code.
  - `bankCode`: The bank code.
- **Behavior**: Updates the `ifscToBankCode` map and prints a confirmation message.

#### `addOrUpdateBankCode(String bankCode, String bankName)`
Adds or updates the mapping of a bank code to a bank name.
- **Parameters**:
  - `bankCode`: The bank code.
  - `bankName`: The bank name.
- **Behavior**: Updates the `bankCodeToName` map and prints a confirmation message.

#### `displayIFSCs()`
Displays all IFSC-to-bank-code mappings.
- **Behavior**: Prints the mappings stored in `ifscToBankCode`. If no mappings exist, it prints a message indicating that no records are available.

#### `displayBankCodes()`
Displays all bank-code-to-name mappings.
- **Behavior**: Prints the mappings stored in `bankCodeToName`. If no mappings exist, it prints a message indicating that no records are available.

### Batch Management

#### `createBatch(String batchId, List<BatchCheque> cheques)`
Creates a new batch of cheques.
- **Parameters**:
  - `batchId`: The unique identifier for the batch.
  - `cheques`: A list of `BatchCheque` objects to be included in the batch.
- **Behavior**: Adds the batch to the `batches` map and prints a confirmation message.

#### `displayBatches()`
Displays a summary of all batches.
- **Behavior**: Prints the batch IDs and the number of cheques in each batch. If no batches exist, it prints a message indicating that no batches are available.

#### `displayBatchDetails(String batchId)`
Displays the details of a specific batch.
- **Parameters**:
  - `batchId`: The unique identifier for the batch.
- **Behavior**: Prints the details of each cheque in the specified batch. If the batch does not exist, it prints an error message.

### Stuck Transaction Management

#### `markTransactionStuck(String chequeNumber)`
Marks a cheque as stuck.
- **Parameters**:
  - `chequeNumber`: The cheque number to be marked as stuck.
- **Behavior**: Adds the cheque number to the `stuckTransactions` set and prints a confirmation message.

#### `resetStuckTransaction(String chequeNumber)`
Resets a stuck cheque.
- **Parameters**:
  - `chequeNumber`: The cheque number to be reset.
- **Behavior**: Removes the cheque number from the `stuckTransactions` set and prints a confirmation message. If the cheque number is not found, it prints an error message.

#### `displayStuckTransactions()`
Displays all stuck transactions.
- **Behavior**: Prints the cheque numbers stored in `stuckTransactions`. If no stuck transactions exist, it prints a message indicating that no records are available.

## External Dependencies

The `AdminService` class depends on the `BatchCheque` class, which represents individual cheques in a batch. The `BatchCheque` class is used in batch management methods such as `createBatch` and `displayBatchDetails`.