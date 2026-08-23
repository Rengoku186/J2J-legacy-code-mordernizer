---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_27"
confidence_score: 0.95
external_dependencies: ["BatchCheque"]
---

# Documentation for `AdminService` Class and Related Methods

## Overview
The `AdminService` class is a static inner class within the `DemoApplication` file. It is responsible for managing master data, batch operations, and stuck transactions in the context of a cheque processing system. The class provides methods to manage IFSC codes, bank codes, cheque batches, and stuck transactions.

The class also interacts with the `BatchCheque` class, which represents individual cheques with attributes such as account number, cheque number, currency, amount, and signature.

---

## Class: `AdminService`

### Fields

1. **`ifscToBankCode`**
   - Type: `Map<String, String>`
   - Description: Maps IFSC codes to their corresponding bank codes.

2. **`bankCodeToName`**
   - Type: `Map<String, String>`
   - Description: Maps bank codes to their corresponding bank names.

3. **`batches`**
   - Type: `Map<String, List<BatchCheque>>`
   - Description: Stores batches of cheques, where each batch is identified by a unique batch ID and contains a list of `BatchCheque` objects.

4. **`stuckTransactions`**
   - Type: `Set<String>`
   - Description: Stores a set of cheque numbers that are marked as stuck transactions.

---

### Methods

#### Master Data Management

1. **`addOrUpdateIFSC(String ifsc, String bankCode)`**
   - **Description**: Adds or updates the mapping between an IFSC code and a bank code.
   - **Parameters**:
     - `ifsc`: The IFSC code to be added or updated.
     - `bankCode`: The bank code to be associated with the given IFSC code.
   - **Output**: Prints a confirmation message indicating the mapping.

2. **`addOrUpdateBankCode(String bankCode, String bankName)`**
   - **Description**: Adds or updates the mapping between a bank code and a bank name.
   - **Parameters**:
     - `bankCode`: The bank code to be added or updated.
     - `bankName`: The name of the bank to be associated with the given bank code.
   - **Output**: Prints a confirmation message indicating the mapping.

3. **`displayIFSCs()`**
   - **Description**: Displays all IFSC-to-bank code mappings.
   - **Output**: Prints the mappings to the console. If no mappings exist, a message indicating this is displayed.

4. **`displayBankCodes()`**
   - **Description**: Displays all bank code-to-name mappings.
   - **Output**: Prints the mappings to the console. If no mappings exist, a message indicating this is displayed.

#### Batch Management

1. **`createBatch(String batchId, List<BatchCheque> cheques)`**
   - **Description**: Creates a new batch of cheques and associates it with a unique batch ID.
   - **Parameters**:
     - `batchId`: The unique identifier for the batch.
     - `cheques`: A list of `BatchCheque` objects to be included in the batch.
   - **Output**: Prints a confirmation message indicating the batch creation and the number of cheques in the batch.

2. **`displayBatches()`**
   - **Description**: Displays a summary of all batches, including their IDs and the number of cheques in each batch.
   - **Output**: Prints the batch summaries to the console. If no batches exist, a message indicating this is displayed.

3. **`displayBatchDetails(String batchId)`**
   - **Description**: Displays detailed information about a specific batch, including the account number, cheque number, amount, and currency of each cheque in the batch.
   - **Parameters**:
     - `batchId`: The unique identifier of the batch to be displayed.
   - **Output**: Prints the details of the specified batch to the console. If the batch does not exist, a message indicating this is displayed.

#### Stuck Transaction Management

1. **`markTransactionStuck(String chequeNumber)`**
   - **Description**: Marks a cheque as a stuck transaction by adding its cheque number to the `stuckTransactions` set.
   - **Parameters**:
     - `chequeNumber`: The cheque number to be marked as stuck.
   - **Output**: Prints a confirmation message indicating that the cheque has been marked as stuck.

2. **`resetStuckTransaction(String chequeNumber)`**
   - **Description**: Removes a cheque from the `stuckTransactions` set, effectively resetting its stuck status.
   - **Parameters**:
     - `chequeNumber`: The cheque number to be removed from the stuck transactions list.
   - **Output**: Prints a confirmation message indicating whether the cheque was successfully removed or if it was not marked as stuck.

3. **`displayStuckTransactions()`**
   - **Description**: Displays all cheque numbers that are currently marked as stuck transactions.
   - **Output**: Prints the list of stuck cheque numbers to the console. If no stuck transactions exist, a message indicating this is displayed.

---

## External Dependencies

### Class: `BatchCheque`
The `AdminService` class relies on the `BatchCheque` class, which represents individual cheques. The `BatchCheque` class has the following fields:

- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The unique identifier for the cheque.
- `String currency`: The currency in which the cheque is issued.
- `double amount`: The monetary value of the cheque.
- `String signature`: The signature associated with the cheque.

The `BatchCheque` class also includes a constructor to initialize these fields.