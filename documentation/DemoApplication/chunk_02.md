---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.9
external_dependencies: [CurrencyExchangeService, SignatureVerificationService, CoreBankingSystemUpdater, UserService, ChequeHistoryManager, FraudDetectionService, ExceptionReportManager, ChequeStatusManager, EmailNotificationService, ChequeImageHandler, CryptographyService, ClearinghouseService, ChequeProcessor, ChequePrintingService, FIRDetails, ExceptionRecord]
---

# Documentation for `DemoApplication` Class (Chunk 02)

## Overview
The `DemoApplication` class serves as the main entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, managing cheque history, and performing administrative tasks.

## Key Functionalities

### 1. **Initialization**
The `main` method initializes the following services:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies cheque signatures.
- `CoreBankingSystemUpdater`: Updates the core banking system.
- `UserService`: Manages user authentication and related operations.
- `ChequeHistoryManager`: Manages and displays cheque history.
- `FraudDetectionService`: Detects fraudulent activities.
- `ExceptionReportManager`: Manages and displays exception reports.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications.
- `ChequeImageHandler`: Handles cheque image processing.
- `CryptographyService`: Provides encryption and signing services.
- `ClearinghouseService`: Facilitates communication with the clearinghouse.

### 2. **Login Process**
The `performLogin` method is invoked to authenticate the user. If the user fails to log in after multiple attempts, the application exits.

### 3. **Menu Options**
The application provides a menu-driven interface with the following options:

#### Option 1: Process a Single Cheque
Prompts the user for account number, cheque number, currency, amount, and signature, and processes the cheque using the `ChequeProcessor` service.

#### Option 2: Process Multiple Cheques (Batch)
Invokes the `processChequeBatch` method to process multiple cheques in a batch.

#### Option 3: View Cheque History
Prompts the user for an account number and displays the cheque history using the `ChequeHistoryManager`.

#### Option 4: Currency Exchange Information
Displays a currency exchange menu and handles user interactions via the `displayCurrencyExchangeMenu` method.

#### Option 5: Generate Cheque Reports
Generates cheque reports using the `handleReportGeneration` method.

#### Option 6: Scan, Encrypt, and Send Cheque Image
Handles the process of scanning, encrypting, signing, and sending a cheque image using the `handleChequeImageSubmission` method.

#### Option 7: Simulate Cheque Printing
Simulates cheque printing using the `ChequePrintingService` and the `handleChequePrinting` method.

#### Option 8: Exit
Logs out the user and exits the application.

#### Option 9: View Cheque Exception Report
Displays exception reports using the `ExceptionReportManager`.

#### Option 10: View All Cheque Statuses
Displays all cheque statuses using the `ChequeStatusManager`.

#### Option 11: Cancel a Cheque
Prompts the user for account and cheque numbers and cancels the cheque using the `ChequeProcessor`.

#### Option 12: Record FIR/Legal Complaint for Bounced Cheque
Prompts the user for details about a bounced cheque and records FIR/legal complaint details using the `recordFIRDetails` method in the `ExceptionReportManager`.

#### Option 13: Admin: Edit IFSC/Bank Codes
Admin functionality to edit IFSC or bank codes (implementation not shown in this chunk).

#### Option 14: Admin: Manage Batches
Admin functionality to manage cheque batches (implementation not shown in this chunk).

#### Option 15: Admin: Reset Stuck Transactions
Admin functionality to reset stuck transactions (implementation not shown in this chunk).

## External Dependencies
The following external classes and services are used in this chunk:
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
- `ChequeProcessor`
- `ChequePrintingService`
- `FIRDetails`
- `ExceptionRecord`

## Notes
- The `performLogin`, `processChequeBatch`, `displayCurrencyExchangeMenu`, `handleReportGeneration`, `handleChequeImageSubmission`, and `handleChequePrinting` methods are defined elsewhere in the codebase.
- The `recordFIRDetails` method is part of the `ExceptionReportManager` class and is used to record FIR/legal complaint details for bounced cheques.
- The application uses a `Scanner` object for user input.
- The `main` method contains a loop that continuously displays the menu until the user chooses to exit.

This chunk provides a comprehensive overview of the main application logic, including initialization, user authentication, and the menu-driven interface for various cheque processing and administrative tasks.