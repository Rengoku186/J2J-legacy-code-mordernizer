---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `DemoApplication` (Chunk 02)

## Overview
This chunk of the `DemoApplication` class represents the main entry point of the application. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques and managing related operations. The application is designed to simulate a cheque processing system with enhanced fraud detection and additional administrative features.

## Key Functionalities

### 1. **Initialization of Services**
The following services are initialized at the start of the application:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies the authenticity of cheque signatures.
- `CoreBankingSystemUpdater`: Updates the core banking system with cheque transactions.
- `UserService`: Manages user authentication and related operations.
- `ChequeHistoryManager`: Maintains and retrieves cheque transaction history.
- `FraudDetectionService`: Detects potential fraudulent activities.
- `ExceptionReportManager`: Manages and displays exception reports.
- `ChequeStatusManager`: Tracks and displays the status of cheques.
- `EmailNotificationService`: Sends email notifications related to cheque processing.
- `ChequeImageHandler`: Handles cheque image processing.
- `CryptographyService`: Provides encryption and digital signing functionalities.
- `ClearinghouseService`: Facilitates communication with the clearinghouse.

### 2. **User Authentication**
The `performLogin` method is invoked to authenticate the user. If the user fails to log in after a certain number of attempts, the application exits.

### 3. **Menu-Driven Interface**
Once authenticated, the user is presented with a menu to perform various operations:

#### Menu Options:
1. **Process a Single Cheque**
   - Prompts the user for account number, cheque number, currency, amount, and signature.
   - Processes the cheque using the `ChequeProcessor` service.

2. **Process Multiple Cheques (Batch)**
   - Invokes the `processChequeBatch` method to process multiple cheques in a batch.

3. **View Cheque History**
   - Prompts the user for an account number and displays the cheque history using the `ChequeHistoryManager`.

4. **Currency Exchange Information**
   - Displays a currency exchange menu and handles user interactions via the `displayCurrencyExchangeMenu` method.

5. **Generate Cheque Reports**
   - Invokes the `handleReportGeneration` method to generate reports based on cheque history.

6. **Scan, Encrypt, and Send Cheque Image**
   - Handles the process of scanning, encrypting, signing, and sending a cheque image using the `handleChequeImageSubmission` method.

7. **Simulate Cheque Printing**
   - Simulates cheque printing using the `ChequePrintingService` and the `handleChequePrinting` method.

8. **Exit**
   - Logs out the user and exits the application.

9. **View Cheque Exception Report**
   - Displays exception reports using the `ExceptionReportManager`.

10. **View All Cheque Statuses**
    - Displays the status of all cheques using the `ChequeStatusManager`.

11. **Cancel a Cheque**
    - Prompts the user for account and cheque numbers and cancels the cheque using the `ChequeProcessor`.

12. **Record FIR/Legal Complaint for Bounced Cheque**
    - Records FIR details for a bounced cheque using the `ExceptionReportManager`.

13. **Admin: Edit IFSC/Bank Codes**
    - Provides administrative functionality to edit IFSC or bank codes.

14. **Admin: Manage Batches**
    - Provides administrative functionality to manage cheque batches.

15. **Admin: Reset Stuck Transactions**
    - Provides administrative functionality to reset stuck transactions.

## Key Methods

### `performLogin`
- Authenticates the user by interacting with the `UserService`.
- Returns the authenticated `User` object or `null` if authentication fails.

### `processChequeBatch`
- Handles the processing of multiple cheques in a batch.
- Collects cheque details from the user and processes them using the `ChequeProcessor`.

### `displayCurrencyExchangeMenu`
- Displays a menu for currency exchange operations.
- Allows the user to view supported currencies, get exchange rates, and convert currencies.

### `handleReportGeneration`
- Generates reports based on cheque history.
- Interacts with the `ChequeHistoryManager` to retrieve and display data.

### `handleChequeImageSubmission`
- Handles the process of scanning, encrypting, signing, and sending a cheque image.
- Utilizes the `ChequeImageHandler`, `CryptographyService`, and `ClearinghouseService`.

### `handleChequePrinting`
- Simulates the process of printing cheques.
- Interacts with the `ChequePrintingService`.

## Notes
- The application uses a `Scanner` object for user input.
- The menu loop continues until the user chooses to exit.
- Exception handling is implemented to manage invalid inputs and other runtime errors.

This chunk demonstrates a robust implementation of a menu-driven application with multiple services and functionalities, showcasing a modular and extensible design.