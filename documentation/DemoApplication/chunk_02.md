---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `DemoApplication` Main Method

## Overview
The `DemoApplication` class serves as the entry point for a comprehensive cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing a wide range of cheque-related operations. The system includes features such as fraud detection, cheque history management, currency exchange, and cheque image processing.

## Key Components and Initialization

### Services Initialized
The following services are initialized at the start of the application:
- **CurrencyExchangeService**: Handles currency exchange operations.
- **SignatureVerificationService**: Verifies cheque signatures.
- **CoreBankingSystemUpdater**: Updates the core banking system with cheque transactions.
- **UserService**: Manages user authentication and related operations.
- **ChequeHistoryManager**: Maintains and displays cheque history.
- **FraudDetectionService**: Detects fraudulent cheque activities.
- **ExceptionReportManager**: Manages and displays exception reports.
- **ChequeStatusManager**: Tracks and displays the status of cheques.
- **EmailNotificationService**: Sends email notifications for various events.
- **ChequeImageHandler**: Handles cheque image processing.
- **CryptographyService**: Provides encryption and digital signing capabilities.
- **ClearinghouseService**: Sends cheque data to the clearinghouse.

### Dependency Setup
- The `FraudDetectionService` is configured with a dependency on the `ChequeHistoryManager`.

## Login Process
The `performLogin` method is invoked to authenticate the user. It allows up to three attempts for login. If authentication fails, the application exits.

## Menu-Driven Interface
Once authenticated, the user is presented with a menu to perform various operations. The menu options include:

1. **Process a Single Cheque**: Prompts the user for cheque details and processes it using the `ChequeProcessor`.
2. **Process Multiple Cheques (Batch)**: Invokes the `processChequeBatch` method to handle batch processing of cheques.
3. **View Cheque History**: Displays the cheque history for a specified account using the `ChequeHistoryManager`.
4. **Currency Exchange Information**: Displays a currency exchange menu using the `displayCurrencyExchangeMenu` method.
5. **Generate Cheque Reports**: Handles report generation via the `handleReportGeneration` method.
6. **Scan, Encrypt, and Send Cheque Image**: Processes cheque images using the `handleChequeImageSubmission` method.
7. **Simulate Cheque Printing**: Simulates cheque printing using the `handleChequePrinting` method.
8. **Exit**: Logs out the user and exits the application.
9. **View Cheque Exception Report**: Displays exception reports using the `ExceptionReportManager`.
10. **View All Cheque Statuses**: Displays all cheque statuses using the `ChequeStatusManager`.
11. **Cancel a Cheque**: Cancels a cheque using the `ChequeProcessor`.
12. **Record FIR/Legal Complaint for Bounced Cheque**: Records FIR details for bounced cheques using the `ExceptionReportManager`.
13. **Admin: Edit IFSC/Bank Codes**: Admin functionality for managing IFSC and bank codes.
14. **Admin: Manage Batches**: Admin functionality for managing cheque batches.
15. **Admin: Reset Stuck Transactions**: Admin functionality for resetting stuck transactions.

## Key Methods

### `performLogin`
Handles user authentication by prompting for username and password. Returns an authenticated `User` object or `null` if authentication fails after three attempts.

### `processChequeBatch`
Processes multiple cheques in a batch. Collects cheque details and processes them using the `ChequeProcessor`.

### `displayCurrencyExchangeMenu`
Displays a menu for currency exchange operations, including viewing supported currencies, getting exchange rates, and converting currencies.

### `handleReportGeneration`
Generates various reports related to cheque processing and history.

### `handleChequeImageSubmission`
Handles the scanning, encryption, signing, and sending of cheque images to the clearinghouse.

### `handleChequePrinting`
Simulates the printing of a cheque by collecting payee details, amount, and date.

## Notes
- The application uses a `Scanner` for user input.
- Exception handling is implemented for invalid inputs and operations.
- The system is designed to be extensible, with new features added to the menu as needed.

This documentation provides an overview of the main method and its associated functionalities. For detailed implementation of individual services and methods, refer to their respective documentation.