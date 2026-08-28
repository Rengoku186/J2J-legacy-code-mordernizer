---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_15"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "AdminService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `ChequeApplication` Class

## Overview
The `ChequeApplication` class serves as the entry point for a comprehensive cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing a wide range of cheque-related operations. The system includes enhanced fraud detection, cheque history management, and administrative tools.

## Key Features
- User authentication with retry limits.
- Cheque processing (single and batch).
- Fraud detection and exception reporting.
- Currency exchange information.
- Cheque image scanning, encryption, and submission.
- Administrative tools for managing IFSC codes, batches, and transactions.

## Main Method
The `main` method is the entry point of the application. It performs the following tasks:

### 1. Initialization
- Initializes various services required for cheque processing:
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

### 2. User Authentication
- Calls the `performLogin` method to authenticate the user.
- Exits the application if the maximum login attempts are reached.

### 3. Menu-Driven Interface
- Displays a menu with various options for cheque processing and administrative tasks.
- Handles user input and executes the corresponding functionality using a `switch` statement.

## Menu Options
The menu provides the following options:

1. **Process a Single Cheque**
   - Prompts the user for account number, cheque number, currency, amount, and signature.
   - Calls the `processCheque` method of the `ChequeProcessor` to process the cheque.

2. **Process Multiple Cheques (Batch)**
   - Calls the `processChequeBatch` method to handle batch processing of cheques.

3. **View Cheque History**
   - Prompts the user for an account number and displays the cheque history using the `ChequeHistoryManager`.

4. **Currency Exchange Information**
   - Calls the `displayCurrencyExchangeMenu` method to provide currency exchange options.

5. **Generate Cheque Reports**
   - Calls the `handleReportGeneration` method to generate reports.

6. **Scan, Encrypt, and Send Cheque Image**
   - Calls the `handleChequeImageSubmission` method to handle cheque image processing.

7. **Simulate Cheque Printing**
   - Calls the `handleChequePrinting` method to simulate cheque printing.

8. **Exit**
   - Logs out the user and exits the application.

9. **View Cheque Exception Report**
   - Displays exceptions using the `ExceptionReportManager`.

10. **View All Cheque Statuses**
    - Displays all cheque statuses using the `ChequeStatusManager`.

11. **Cancel a Cheque**
    - Prompts the user for account and cheque numbers and cancels the cheque using the `ChequeProcessor`.

12. **Record FIR/Legal Complaint for Bounced Cheque**
    - Prompts the user for FIR details and records them using the `ExceptionReportManager`.

13. **Admin: Edit IFSC/Bank Codes**
    - Provides administrative functionality to edit IFSC and bank codes.

14. **Admin: Manage Batches**
    - Provides administrative functionality to manage cheque batches.

15. **Admin: Reset Stuck Transactions**
    - Provides administrative functionality to reset stuck transactions.

## Key Methods

### `performLogin`
- Authenticates the user by validating credentials.
- Returns an authenticated `User` object or `null` if authentication fails.

### `processChequeBatch`
- Handles batch processing of multiple cheques.
- Collects cheque details from the user and processes them using the `ChequeProcessor`.

### `displayCurrencyExchangeMenu`
- Displays a menu for currency exchange options.
- Allows the user to view supported currencies, get exchange rates, and convert currencies.

### `handleReportGeneration`
- Generates various reports related to cheque processing.

### `handleChequeImageSubmission`
- Handles the scanning, encryption, and submission of cheque images.
- Uses the `ChequeImageHandler`, `CryptographyService`, and `ClearinghouseService`.

### `handleChequePrinting`
- Simulates the printing of cheques.
- Uses the `ChequePrintingService`.

## External Dependencies
The class relies on several external services and managers, including:
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

These dependencies are initialized at the start of the application and are used throughout the program to perform various tasks.