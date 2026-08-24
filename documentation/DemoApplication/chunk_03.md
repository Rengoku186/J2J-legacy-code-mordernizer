---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.9
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService", "ChequeProcessor"]
---

# Documentation for Code Chunk: Admin Functionalities and Utility Methods

This code chunk is part of the `DemoApplication` class and implements several administrative functionalities, including managing IFSC/Bank codes, handling batches, and resetting stuck transactions. Additionally, it includes utility methods for user login and batch cheque processing.

## Purpose
The purpose of this code is to provide administrative functionalities for managing banking operations, such as editing IFSC/Bank codes, managing cheque batches, and handling stuck transactions. It also includes utility methods for user login and batch cheque processing.

## Code Breakdown

### Case 13: Admin - Edit IFSC/Bank Codes
This section allows the admin to:
1. Add or update IFSC codes.
2. Add or update bank codes.
3. View existing IFSC codes.
4. View existing bank codes.

#### Key Operations:
- **Add/Update IFSC**: Prompts the admin to enter an IFSC code and a corresponding bank code, which is then processed by the `adminService.addOrUpdateIFSC` method.
- **Add/Update Bank Code**: Prompts the admin to enter a bank code and a bank name, which is processed by the `adminService.addOrUpdateBankCode` method.
- **View IFSCs**: Displays all IFSC codes using `adminService.displayIFSCs`.
- **View Bank Codes**: Displays all bank codes using `adminService.displayBankCodes`.

### Case 14: Admin - Manage Batches
This section allows the admin to:
1. Create a new batch of cheques.
2. View all existing batches.
3. View details of a specific batch.

#### Key Operations:
- **Create Batch**: Prompts the admin to enter a batch ID and the number of cheques in the batch. For each cheque, the admin is prompted to enter details such as account number, cheque number, currency, amount, and signature. These details are stored in a `List<BatchCheque>` and processed by `adminService.createBatch`.
- **View Batches**: Displays all batches using `adminService.displayBatches`.
- **View Batch Details**: Prompts the admin to enter a batch ID and displays its details using `adminService.displayBatchDetails`.

### Case 15: Admin - Reset Stuck Transactions
This section allows the admin to:
1. Mark a cheque as stuck.
2. Reset a stuck cheque.
3. View all stuck transactions.

#### Key Operations:
- **Mark Cheque as Stuck**: Prompts the admin to enter a cheque number, which is then marked as stuck using `adminService.markTransactionStuck`.
- **Reset Stuck Cheque**: Prompts the admin to enter a cheque number, which is reset using `adminService.resetStuckTransaction`.
- **View Stuck Transactions**: Displays all stuck transactions using `adminService.displayStuckTransactions`.

### Utility Method: `performLogin`
This method handles the user login process. It allows up to three login attempts and authenticates the user using the `userService.authenticate` method. If authentication is successful, the user is welcomed, and their details are logged using the `Logger` class. If authentication fails after three attempts, the method returns `null`.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `userService`: An instance of the `UserService` class for user authentication.

#### Returns:
- An authenticated `User` object if login is successful.
- `null` if login fails after three attempts.

### Utility Method: `processChequeBatch`
This method handles the processing of multiple cheques in a batch. It prompts the user for the number of cheques and their details, which are stored in a `List<BatchCheque>`. The method uses the `ChequeProcessor` service for processing.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `chequeProcessor`: An instance of the `ChequeProcessor` class for processing cheques.

#### Key Operations:
- Collects details for each cheque, including account number, cheque number, currency, amount, and signature.
- Handles exceptions during input collection and logs errors using the `Logger` class.

## External Dependencies
- **`AdminService`**: Provides methods for managing IFSC codes, bank codes, batches, and stuck transactions.
- **`BatchCheque`**: Represents a cheque in a batch, including details like account number, cheque number, currency, amount, and signature.
- **`Logger`**: Used for logging information, warnings, and errors.
- **`UserService`**: Handles user authentication and management.
- **`ChequeProcessor`**: Processes cheques with functionalities like signature verification, fraud detection, and currency conversion.