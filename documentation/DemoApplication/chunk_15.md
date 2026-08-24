---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_15"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "AdminService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `ChequeApplication` Class

## Overview
The `ChequeApplication` class serves as the main entry point for a cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing a wide range of cheque-related operations. The system includes enhanced fraud detection, cheque history management, and administrative tools.

## Key Features
- User authentication and session management.
- Cheque processing (single and batch).
- Fraud detection and exception reporting.
- Currency exchange information.
- Cheque image scanning, encryption, and submission.
- Administrative tools for managing IFSC codes, batches, and stuck transactions.

## Code Walkthrough

### `main` Method
The `main` method is the entry point of the application. It performs the following tasks:

1. **Initialization**:
   - Initializes various services required for cheque processing, such as:
     - `CurrencyExchangeService`
     - `SignatureVerificationService`
     - `CoreBankingSystemUpdater`
     - `UserService`
     - `ChequeHistoryManager`
     - `FraudDetectionService`
     - `ExceptionReportManager`
     - `ChequeStatusManager`
     - `EmailNotificationService`
     - `AdminService`
     - `ChequeImageHandler`
     - `CryptographyService`
     - `ClearinghouseService`
   - Sets up dependencies, such as linking the `FraudDetectionService` with the `ChequeHistoryManager`.

2. **User Authentication**:
   - Calls the `performLogin` method to authenticate the user. If authentication fails after multiple attempts, the application exits.

3. **Main Menu**:
   - Displays a menu with various options for the user to interact with the system. The options include:
     1. Process a single cheque.
     2. Process multiple cheques in a batch.
     3. View cheque history.
     4. Display currency exchange information.
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
   - The user selects an option by entering a number. The application then performs the corresponding action using helper methods and services. For example:
     - **Option 1**: Processes a single cheque using the `ChequeProcessor` service.
     - **Option 2**: Processes multiple cheques in a batch using the `processChequeBatch` method.
     - **Option 3**: Displays cheque history using the `ChequeHistoryManager`.
     - **Option 4**: Displays currency exchange information using the `displayCurrencyExchangeMenu` method.
     - **Option 5**: Generates reports using the `handleReportGeneration` method.
     - **Option 6**: Handles cheque image submission using the `handleChequeImageSubmission` method.
     - **Option 7**: Simulates cheque printing using the `ChequePrintingService`.
     - **Option 8**: Logs out and exits the application.
     - **Option 9**: Displays exception reports using the `ExceptionReportManager`.
     - **Option 10**: Displays all cheque statuses using the `ChequeStatusManager`.
     - **Option 11**: Cancels a cheque using the `ChequeProcessor`.
     - **Option 12**: Records FIR/legal complaints for bounced cheques using the `ExceptionReportManager`.

### Helper Methods

#### `performLogin`
Handles user authentication by interacting with the `UserService`. If the user fails to authenticate after multiple attempts, the application exits.

#### `processChequeBatch`
Processes multiple cheques in a batch. It collects cheque details from the user and uses the `ChequeProcessor` to process each cheque.

#### `displayCurrencyExchangeMenu`
Displays a menu for currency exchange operations, such as viewing supported currencies, getting exchange rates, and converting currencies. Interacts with the `CurrencyExchangeService`.

#### `handleReportGeneration`
Generates various reports related to cheque processing. Interacts with the `ChequeHistoryManager`.

#### `handleChequeImageSubmission`
Handles the process of scanning, encrypting, signing, and sending a cheque image. Interacts with the `ChequeImageHandler`, `CryptographyService`, and `ClearinghouseService`.

#### `handleChequePrinting`
Simulates cheque printing. Uses the `ChequePrintingService`.

## External Dependencies
The `ChequeApplication` class relies on the following external services and classes:
- `CurrencyExchangeService`
- `SignatureVerificationService`
- `CoreBankingSystemUpdater`
- `UserService`
- `ChequeHistoryManager`
- `FraudDetectionService`
- `ExceptionReportManager`
- `ChequeStatusManager`
- `EmailNotificationService`
- `AdminService`
- `ChequeImageHandler`
- `CryptographyService`
- `ClearinghouseService`
- `ChequeProcessor`
- `ChequePrintingService`

## Conclusion
The `ChequeApplication` class is a comprehensive system for managing cheque-related operations, including processing, fraud detection, and administrative tasks. It is designed to be user-friendly and extensible, with a modular architecture that allows for easy integration of new features.