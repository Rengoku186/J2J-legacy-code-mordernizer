---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.9
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of the `DemoApplication` class and contains several functionalities related to administrative tasks, user login, and batch cheque processing. The code is structured into multiple `case` blocks within a `switch` statement, each handling a specific administrative operation. Additionally, the chunk includes two private static methods: `performLogin` and `processChequeBatch`.

## Code Breakdown

### Case 13: Admin - Edit IFSC/Bank Codes
This block allows an admin to manage IFSC and bank codes. The admin can:
1. Add or update an IFSC code.
2. Add or update a bank code.
3. View all IFSC codes.
4. View all bank codes.
5. Return to the previous menu.

The admin's choice is captured using a `Scanner` object, and the corresponding action is performed by invoking methods from the `AdminService` class:
- `addOrUpdateIFSC(String ifsc, String bankCode)`: Adds or updates an IFSC code and its associated bank code.
- `addOrUpdateBankCode(String code, String name)`: Adds or updates a bank code and its associated bank name.
- `displayIFSCs()`: Displays all stored IFSC codes.
- `displayBankCodes()`: Displays all stored bank codes.

### Case 14: Admin - Manage Batches
This block allows an admin to manage cheque batches. The admin can:
1. Create a new batch by providing a batch ID and details for each cheque in the batch.
2. View all existing batches.
3. View details of a specific batch by providing its batch ID.
4. Return to the previous menu.

The admin's choice is captured using a `Scanner` object, and the corresponding action is performed by invoking methods from the `AdminService` class:
- `createBatch(String batchId, List<BatchCheque> batchCheques)`: Creates a new batch with the specified ID and a list of cheques.
- `displayBatches()`: Displays all existing batches.
- `displayBatchDetails(String batchId)`: Displays details of a specific batch.

The `BatchCheque` class is used to represent individual cheques in a batch. Each cheque includes details such as account number, cheque number, currency, amount, and signature.

### Case 15: Admin - Reset Stuck Transactions
This block allows an admin to manage stuck transactions. The admin can:
1. Mark a cheque as stuck by providing its cheque number.
2. Reset a stuck cheque by providing its cheque number.
3. View all stuck transactions.
4. Return to the previous menu.

The admin's choice is captured using a `Scanner` object, and the corresponding action is performed by invoking methods from the `AdminService` class:
- `markTransactionStuck(String chequeNumber)`: Marks a cheque as stuck.
- `resetStuckTransaction(String chequeNumber)`: Resets a stuck cheque.
- `displayStuckTransactions()`: Displays all stuck transactions.

### Exception Handling
The `try-catch` block ensures that any exceptions occurring during the execution of the main logic are caught and logged using the `Logger` class. The error message and stack trace are printed to the console for debugging purposes.

### Method: `performLogin`
This method handles the user login process. It allows a user to attempt login up to three times by providing a username and password. The method uses the `UserService` class to authenticate the user:
- `User authenticate(String username, String password)`: Authenticates the user based on the provided credentials.

If authentication is successful, the method returns the authenticated `User` object. Otherwise, it returns `null` after three failed attempts.

### Method: `processChequeBatch`
This method handles the processing of multiple cheques in a batch. It prompts the user to enter the number of cheques and their details, including account number, cheque number, currency, amount, and signature. The cheques are stored in a `List<BatchCheque>` and processed using the `ChequeProcessor` service.

## External Dependencies
- **AdminService**: Provides methods for managing IFSC codes, bank codes, cheque batches, and stuck transactions.
- **BatchCheque**: Represents individual cheques with details such as account number, cheque number, currency, amount, and signature.
- **Logger**: Used for logging errors and informational messages.
- **UserService**: Handles user authentication and management.

## Notes
- The `AdminService` class is instantiated in the `DemoApplication` class, but its implementation details are not provided in this chunk.
- The `BatchCheque` class is used to represent cheque details, but its implementation is not provided in this chunk.
- The `Logger` class is used for logging, but its implementation is not provided in this chunk.
- The `UserService` class is responsible for user authentication and management, and its implementation is partially available in the codebase.