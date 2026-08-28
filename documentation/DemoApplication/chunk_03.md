---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.95
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService", "ChequeProcessor"]
---

# Documentation for Code Chunk

This code chunk is part of the `DemoApplication` class and implements several administrative functionalities for managing banking operations. It includes three main sections: editing IFSC/Bank codes, managing batches, and resetting stuck transactions. Additionally, it contains utility methods for user login and batch cheque processing.

## Purpose
The purpose of this code is to provide an interactive console-based interface for administrators to perform various banking operations. It uses a `Scanner` for user input and delegates operations to services like `AdminService` and `ChequeProcessor`.

## Key Functionalities

### 1. Admin: Edit IFSC/Bank Codes
This section allows administrators to:
- Add or update IFSC codes and bank codes.
- View existing IFSC codes and bank codes.

#### Code Flow
- The user is prompted to select an option from a menu.
- Based on the selection:
  - **Option 1:** Prompts the user to enter an IFSC code and a bank code, then calls `adminService.addOrUpdateIFSC(ifsc, bankCode)`.
  - **Option 2:** Prompts the user to enter a bank code and a bank name, then calls `adminService.addOrUpdateBankCode(code, name)`.
  - **Option 3:** Calls `adminService.displayIFSCs()` to display all IFSC codes.
  - **Option 4:** Calls `adminService.displayBankCodes()` to display all bank codes.
  - **Option 5:** Exits the menu.

### 2. Admin: Manage Batches
This section allows administrators to:
- Create a new batch of cheques.
- View all existing batches.
- View details of a specific batch.

#### Code Flow
- The user is prompted to select an option from a menu.
- Based on the selection:
  - **Option 1:** Prompts the user to enter a batch ID and the number of cheques in the batch. For each cheque, the user is prompted to enter details such as account number, cheque number, currency, amount, and signature. These details are used to create `BatchCheque` objects, which are then passed to `adminService.createBatch(batchId, batchCheques)`.
  - **Option 2:** Calls `adminService.displayBatches()` to display all batches.
  - **Option 3:** Prompts the user to enter a batch ID and calls `adminService.displayBatchDetails(viewBatchId)` to display details of the specified batch.
  - **Option 4:** Exits the menu.

### 3. Admin: Reset Stuck Transactions
This section allows administrators to:
- Mark a cheque as stuck.
- Reset a stuck cheque.
- View all stuck transactions.

#### Code Flow
- The user is prompted to select an option from a menu.
- Based on the selection:
  - **Option 1:** Prompts the user to enter a cheque number and calls `adminService.markTransactionStuck(stuckChq)`.
  - **Option 2:** Prompts the user to enter a cheque number and calls `adminService.resetStuckTransaction(resetChq)`.
  - **Option 3:** Calls `adminService.displayStuckTransactions()` to display all stuck transactions.
  - **Option 4:** Exits the menu.

### 4. User Login
The `performLogin` method handles user authentication.

#### Code Flow
- The user is allowed up to three attempts to log in.
- For each attempt:
  - Prompts the user to enter a username and password.
  - Calls `userService.authenticate(username, password)` to validate the credentials.
  - If authentication is successful, logs the user in and returns the `User` object.
  - If authentication fails, logs a warning and informs the user of the remaining attempts.
- If all attempts fail, the method returns `null`.

### 5. Batch Cheque Processing
The `processChequeBatch` method handles the processing of multiple cheques in a batch.

#### Code Flow
- Prompts the user to enter the number of cheques in the batch.
- For each cheque:
  - Prompts the user to enter details such as account number, cheque number, currency, amount, and signature.
  - Creates a `BatchCheque` object with the entered details and adds it to a list.
- The list of `BatchCheque` objects is then processed by the `ChequeProcessor` service.

## External Dependencies
- **AdminService:** Handles administrative operations like managing IFSC codes, bank codes, batches, and stuck transactions.
- **BatchCheque:** Represents a cheque in a batch, including details like account number, cheque number, currency, amount, and signature.
- **Logger:** Used for logging errors, warnings, and informational messages.
- **UserService:** Handles user authentication and management.
- **ChequeProcessor:** Processes batches of cheques, including signature verification and other operations.

## Error Handling
- Exceptions during user input or service calls are caught and logged using the `Logger` class.
- The application ensures that the `Scanner` buffer is cleared after invalid input to prevent infinite loops.

## Notes
- The `AdminService` and `ChequeProcessor` classes are initialized elsewhere in the application.
- The `BatchCheque` class is used to encapsulate cheque details.
- The `Logger` class is used for logging errors and warnings.
- The `UserService` class is responsible for user authentication.
- The `ChequeProcessor` class handles batch cheque processing, including validation and fraud detection.