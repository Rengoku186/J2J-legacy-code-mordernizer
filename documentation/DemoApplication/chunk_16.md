---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_16"
confidence_score: 0.9
external_dependencies: ["AdminService", "BatchCheque", "Logger"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of the `DemoApplication` class and implements several administrative functionalities for managing IFSC/Bank codes, batches, and stuck transactions. It also includes methods for user login and batch cheque processing. The code relies on external services such as `AdminService` and `Logger` for its operations.

## Code Breakdown

### Case 13: Admin - Edit IFSC/Bank Codes
This section provides an interface for administrators to manage IFSC and bank codes. The options include:

1. **Add/Update IFSC**: Prompts the user to input an IFSC code and a corresponding bank code, then calls `adminService.addOrUpdateIFSC(ifsc, bankCode)` to save or update the information.
2. **Add/Update Bank Code**: Prompts the user to input a bank code and a bank name, then calls `adminService.addOrUpdateBankCode(code, name)` to save or update the information.
3. **View IFSCs**: Calls `adminService.displayIFSCs()` to display all stored IFSC codes.
4. **View Bank Codes**: Calls `adminService.displayBankCodes()` to display all stored bank codes.
5. **Return**: Exits the current menu.

### Case 14: Admin - Manage Batches
This section provides an interface for administrators to manage cheque batches. The options include:

1. **Create Batch**: Prompts the user to input a batch ID and the number of cheques in the batch. For each cheque, the user is prompted to input details such as account number, cheque number, currency, amount, and signature. These details are stored in a `BatchCheque` object, which is added to a list. Finally, the list is passed to `adminService.createBatch(batchId, batchCheques)` to create the batch.
2. **View Batches**: Calls `adminService.displayBatches()` to display all batches.
3. **View Batch Details**: Prompts the user to input a batch ID and calls `adminService.displayBatchDetails(viewBatchId)` to display details of the specified batch.
4. **Return**: Exits the current menu.

### Case 15: Admin - Reset Stuck Transactions
This section provides an interface for administrators to manage stuck transactions. The options include:

1. **Mark Cheque as Stuck**: Prompts the user to input a cheque number and calls `adminService.markTransactionStuck(stuckChq)` to mark the transaction as stuck.
2. **Reset Stuck Cheque**: Prompts the user to input a cheque number and calls `adminService.resetStuckTransaction(resetChq)` to reset the stuck transaction.
3. **View Stuck Transactions**: Calls `adminService.displayStuckTransactions()` to display all stuck transactions.
4. **Return**: Exits the current menu.

### Exception Handling
The code includes a `try-catch` block to handle any exceptions that may occur during the execution of the main logic. If an exception is caught, it is logged using the `Logger` class, and the stack trace is printed.

### Method: `performLogin`
This method handles the user login process. It allows up to three attempts for the user to log in by providing a username and password. If authentication is successful, the method returns the authenticated `User` object. Otherwise, it returns `null` after three failed attempts.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `userService`: A `UserService` object for authenticating the user.

#### Key Operations:
- Prompts the user for a username and password.
- Calls `userService.authenticate(username, password)` to verify credentials.
- Logs successful or failed login attempts using the `Logger` class.

### Method: `processChequeBatch`
This method handles the processing of multiple cheques in a batch. It prompts the user to input the number of cheques and their details, then processes them using the `ChequeProcessor` service.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `chequeProcessor`: A `ChequeProcessor` object for processing cheques.

#### Key Operations:
- Prompts the user for the number of cheques in the batch.
- Iteratively collects details for each cheque, including account number, cheque number, currency, amount, and signature.
- Creates a `BatchCheque` object for each cheque and adds it to a list.
- Passes the list to `chequeProcessor` for processing.
- Handles exceptions during input collection and logs errors using the `Logger` class.

## External Dependencies
- **`AdminService`**: Provides methods for managing IFSC codes, bank codes, batches, and stuck transactions.
- **`BatchCheque`**: Represents a cheque with details such as account number, cheque number, currency, amount, and signature.
- **`Logger`**: Used for logging information, warnings, and errors.

## Notes
- The `AdminService` and `BatchCheque` classes are defined elsewhere in the codebase.
- The `Logger` class is used for logging but its implementation details are not provided in this chunk.
- The code assumes that user input is valid and does not include extensive input validation.