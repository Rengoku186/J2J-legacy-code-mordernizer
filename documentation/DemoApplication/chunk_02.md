---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `DemoApplication` Class

## Overview
The `DemoApplication` class serves as the entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for users to perform various operations related to cheque processing, fraud detection, and administrative tasks.

## Key Functionalities

### `main` Method
The `main` method is the starting point of the application. It performs the following tasks:

1. **Initialization**:
   - Initializes various services required for the cheque processing system, including:
     - `CurrencyExchangeService`
     - `SignatureVerificationService`
     - `CoreBankingSystemUpdater`
     - `UserService`
     - `ChequeHistoryManager`
     - `FraudDetectionService`
     - `ExceptionReportManager`
     - `ChequeStatusManager`
     - `EmailNotificationService`
     - `ChequeImageHandler`
     - `CryptographyService`
     - `ClearinghouseService`
   - Sets up dependencies, such as linking the `FraudDetectionService` with the `ChequeHistoryManager`.

2. **User Authentication**:
   - Calls the `performLogin` method to authenticate the user. If the user fails to log in after multiple attempts, the application exits.

3. **Main Menu**:
   - Displays a menu with various options for the user to interact with the system. The options include:
     1. Process a single cheque.
     2. Process multiple cheques in a batch.
     3. View cheque history.
     4. View currency exchange information.
     5. Generate cheque reports.
     6. Scan, encrypt, and send a cheque image.
     7. Simulate cheque printing.
     8. Exit the application.
     9. View cheque exception reports.
     10. View all cheque statuses.
     11. Cancel a cheque.
     12. Record FIR/legal complaint for a bounced cheque.
     13. Admin: Edit IFSC/Bank codes.
     14. Admin: Manage batches.
     15. Admin: Reset stuck transactions.

4. **Menu Option Handling**:
   - Based on the user's choice, the application performs the corresponding operation. Some of the key operations include:
     - **Processing a Single Cheque**: The user provides details such as account number, cheque number, currency, amount, and signature. The `ChequeProcessor` processes the cheque.
     - **Processing Multiple Cheques (Batch)**: Calls the `processChequeBatch` method to handle batch processing of cheques.
     - **Viewing Cheque History**: Calls the `displayChequeHistory` method of `ChequeHistoryManager` to display the history of cheques for a given account number.
     - **Currency Exchange Information**: Calls the `displayCurrencyExchangeMenu` method to provide options for viewing and converting currency exchange rates.
     - **Generating Cheque Reports**: Calls the `handleReportGeneration` method to generate reports based on cheque history.
     - **Scanning, Encrypting, and Sending Cheque Images**: Calls the `handleChequeImageSubmission` method to handle the process of scanning, encrypting, and sending cheque images.
     - **Simulating Cheque Printing**: Calls the `handleChequePrinting` method to simulate the printing of cheques.
     - **Viewing Cheque Exception Reports**: Calls the `displayExceptions` method of `ExceptionReportManager` to display exception reports.
     - **Viewing All Cheque Statuses**: Calls the `displayAllStatuses` method of `ChequeStatusManager` to display the statuses of all cheques.
     - **Cancelling a Cheque**: Calls the `cancelCheque` method of `ChequeProcessor` to cancel a specific cheque.
     - **Recording FIR/Legal Complaint**: Calls the `recordFIRDetails` method of `ExceptionReportManager` to record details of an FIR or legal complaint for a bounced cheque.

## External Dependencies
The `DemoApplication` class relies on the following external classes and services:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies cheque signatures.
- `CoreBankingSystemUpdater`: Updates the core banking system with cheque processing results.
- `UserService`: Manages user authentication and related operations.
- `ChequeHistoryManager`: Manages and displays cheque history.
- `FraudDetectionService`: Detects potential fraud in cheque transactions.
- `ExceptionReportManager`: Manages and displays exception reports.
- `ChequeStatusManager`: Tracks and displays the status of cheques.
- `EmailNotificationService`: Sends email notifications related to cheque processing.
- `ChequeImageHandler`: Handles cheque image processing.
- `CryptographyService`: Provides encryption and signing services for cheque images.
- `ClearinghouseService`: Sends cheque images to the clearinghouse.
- `ChequeProcessor`: Processes individual and batch cheques.
- `ChequePrintingService`: Simulates cheque printing.

## Notes
- The `performLogin` method is used for user authentication. Its implementation was not provided in the code chunk but is assumed to handle user login and return an authenticated `User` object or `null` if authentication fails.
- The methods `processChequeBatch`, `displayCurrencyExchangeMenu`, `handleReportGeneration`, `handleChequeImageSubmission`, and `handleChequePrinting` are used to handle specific operations. Their implementations were not provided in the code chunk but were found in the codebase.
- The application uses a `Scanner` object for user input and provides a menu-driven interface for ease of use.
- The application includes several administrative options, such as editing IFSC/Bank codes, managing batches, and resetting stuck transactions.

## Confidence Score
The confidence score for this documentation is 0.9, as the majority of the code and its dependencies were understood and documented. However, some methods and classes were not fully explored due to the limited context provided in the code chunk.