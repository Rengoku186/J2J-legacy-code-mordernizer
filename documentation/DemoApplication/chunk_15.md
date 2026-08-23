---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_15"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "AdminService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `ChequeApplication` Class

## Overview
The `ChequeApplication` class serves as the entry point for a comprehensive cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing multiple cheque-related operations. The system includes enhanced fraud detection, cheque history management, and administrative tools.

## Key Functionalities

### 1. **System Initialization**
The `main` method initializes the following services:
- **CurrencyExchangeService**: Handles currency exchange operations.
- **SignatureVerificationService**: Verifies cheque signatures.
- **CoreBankingSystemUpdater**: Updates the core banking system with cheque transactions.
- **UserService**: Manages user authentication and information.
- **ChequeHistoryManager**: Tracks and displays cheque history.
- **FraudDetectionService**: Detects fraudulent cheque activities.
- **ExceptionReportManager**: Manages and displays cheque exception reports.
- **ChequeStatusManager**: Tracks the status of cheques.
- **EmailNotificationService**: Sends email notifications.
- **AdminService**: Provides administrative functionalities.
- **ChequeImageHandler**: Handles cheque image processing.
- **CryptographyService**: Encrypts and signs cheque data.
- **ClearinghouseService**: Sends cheque data to the clearinghouse.

### 2. **User Authentication**
The `performLogin` method is invoked to authenticate the user. If authentication fails after multiple attempts, the system exits.

### 3. **Menu-Driven Operations**
The application provides a menu with the following options:

#### Cheque Processing
- **Process a Single Cheque**: Prompts the user for cheque details and processes it using the `ChequeProcessor`.
- **Process Multiple Cheques (Batch)**: Invokes the `processChequeBatch` method to handle batch processing.

#### Cheque History and Reports
- **View Cheque History**: Displays the cheque history for a specific account using `ChequeHistoryManager`.
- **Generate Cheque Reports**: Calls `handleReportGeneration` to generate detailed reports.

#### Currency Exchange
- **Currency Exchange Information**: Displays a currency exchange menu using `displayCurrencyExchangeMenu`.

#### Cheque Image Handling
- **Scan, Encrypt, and Send Cheque Image**: Uses `handleChequeImageSubmission` to process cheque images.

#### Administrative Tools
- **Edit IFSC/Bank Codes**: Allows administrators to edit bank codes.
- **Manage Batches**: Provides batch management functionalities.
- **Reset Stuck Transactions**: Resets transactions stuck in the system.

#### Miscellaneous
- **Simulate Cheque Printing**: Uses `handleChequePrinting` to simulate cheque printing.
- **View Cheque Exception Report**: Displays exceptions using `ExceptionReportManager`.
- **View All Cheque Statuses**: Lists all cheque statuses using `ChequeStatusManager`.
- **Cancel a Cheque**: Cancels a cheque using `ChequeProcessor`.
- **Record FIR/Legal Complaint for Bounced Cheque**: Records FIR details for bounced cheques using `ExceptionReportManager`.

### 4. **Exit**
The user can log out and exit the system by selecting the appropriate menu option.

## External Dependencies
The `ChequeApplication` class relies on the following external classes and services:
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

## Notes
- The `performLogin`, `processChequeBatch`, `displayCurrencyExchangeMenu`, `handleReportGeneration`, `handleChequeImageSubmission`, and `handleChequePrinting` methods are defined elsewhere in the codebase.
- The application uses a `Scanner` object for user input.
- The system includes robust error handling for invalid inputs and failed operations.

This documentation provides an overview of the `ChequeApplication` class and its functionalities. For detailed implementation of the referenced methods, refer to their respective documentation.