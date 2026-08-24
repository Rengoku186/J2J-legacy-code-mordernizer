---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_16"
confidence_score: 0.95
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService", "User", "ChequeProcessor"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of the `DemoApplication` class and implements several administrative functionalities for managing IFSC codes, bank codes, cheque batches, and stuck transactions. Additionally, it includes methods for user login and batch cheque processing. The code is structured using nested switch-case statements to handle various user choices.

## Key Functionalities

### 1. **Admin: Edit IFSC/Bank Codes**
This section allows administrators to manage IFSC and bank codes. The options include:
- Adding or updating an IFSC code.
- Adding or updating a bank code.
- Viewing all IFSC codes.
- Viewing all bank codes.

#### Code Details:
- **Option 1:** Prompts the user to enter an IFSC and a bank code, then calls `adminService.addOrUpdateIFSC(ifsc, bankCode)`.
- **Option 2:** Prompts the user to enter a bank code and name, then calls `adminService.addOrUpdateBankCode(code, name)`.
- **Option 3:** Calls `adminService.displayIFSCs()` to display all IFSC codes.
- **Option 4:** Calls `adminService.displayBankCodes()` to display all bank codes.

### 2. **Admin: Manage Batches**
This section allows administrators to manage cheque batches. The options include:
- Creating a new batch.
- Viewing all batches.
- Viewing details of a specific batch.

#### Code Details:
- **Option 1:**
  - Prompts the user to enter a batch ID and the number of cheques in the batch.
  - Collects details for each cheque (account number, cheque number, currency, amount, and signature).
  - Creates a list of `BatchCheque` objects and calls `adminService.createBatch(batchId, batchCheques)`.
- **Option 2:** Calls `adminService.displayBatches()` to display all batches.
- **Option 3:** Prompts the user to enter a batch ID and calls `adminService.displayBatchDetails(viewBatchId)`.

### 3. **Admin: Reset Stuck Transactions**
This section allows administrators to manage stuck transactions. The options include:
- Marking a cheque as stuck.
- Resetting a stuck cheque.
- Viewing all stuck transactions.

#### Code Details:
- **Option 1:** Prompts the user to enter a cheque number and calls `adminService.markTransactionStuck(stuckChq)`.
- **Option 2:** Prompts the user to enter a cheque number and calls `adminService.resetStuckTransaction(resetChq)`.
- **Option 3:** Calls `adminService.displayStuckTransactions()` to display all stuck transactions.

### 4. **User Login**
The `performLogin` method handles user authentication. It allows up to three login attempts and uses the `UserService` class to authenticate users.

#### Code Details:
- Prompts the user for a username and password.
- Calls `userService.authenticate(username, password)` to validate credentials.
- Logs successful or failed login attempts using the `Logger` class.
- Returns the authenticated `User` object or `null` if login fails after three attempts.

### 5. **Batch Cheque Processing**
The `processChequeBatch` method handles the processing of multiple cheques in a batch.

#### Code Details:
- Prompts the user to enter the number of cheques in the batch.
- Collects details for each cheque (account number, cheque number, currency, amount, and signature).
- Creates a list of `BatchCheque` objects for processing.
- Handles input errors and logs them using the `Logger` class.

## External Dependencies

### 1. **AdminService**
Provides methods for managing IFSC codes, bank codes, cheque batches, and stuck transactions.

### 2. **BatchCheque**
Represents a cheque in a batch, including details such as account number, cheque number, currency, amount, and signature.

### 3. **Logger**
Used for logging information, warnings, and errors.

### 4. **UserService**
Handles user authentication and management.

### 5. **User**
Represents a user in the system, including attributes such as username, password, and role.

### 6. **ChequeProcessor**
Processes cheques with functionalities such as signature verification, fraud detection, and currency conversion.

## Error Handling
- Exceptions during user login and cheque batch processing are caught and logged using the `Logger` class.
- Input errors are handled gracefully, and the scanner buffer is cleared to avoid cascading issues.

## Conclusion
This code chunk implements critical administrative and user-facing functionalities in the `DemoApplication`. It leverages several external services and classes to provide a robust and modular design for managing banking operations.