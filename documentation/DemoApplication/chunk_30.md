---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_30"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ChequeProcessor", "BatchCheque"]
---

# Documentation for `CreateApplication` Class

## Overview
The `CreateApplication` class serves as the entry point for the Cheque Processing System. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, viewing cheque history, and managing currency exchange information. The system also incorporates fraud detection and core banking system updates.

## Key Functionalities

### 1. **System Initialization**
The `main` method initializes the following services:
- **CurrencyExchangeService**: Handles currency exchange operations.
- **SignatureVerificationService**: Verifies cheque signatures.
- **CoreBankingSystemUpdater**: Updates the core banking system with transaction details.
- **UserService**: Manages user authentication and registration.
- **ChequeHistoryManager**: Maintains and displays cheque processing history.
- **FraudDetectionService**: Detects potential fraudulent activities in cheque processing.

The `FraudDetectionService` is configured with a dependency on `ChequeHistoryManager` to access historical cheque data.

### 2. **User Authentication**
The `performLogin` method handles user authentication. It allows up to three login attempts and returns an authenticated `User` object if successful. If authentication fails after three attempts, the system exits.

### 3. **Cheque Processing Menu**
Once authenticated, the user is presented with a menu to perform the following actions:
- **Process a Single Cheque**: Prompts the user for cheque details and processes it using the `ChequeProcessor`.
- **Process Multiple Cheques (Batch)**: Collects details for multiple cheques and processes them in a batch.
- **View Cheque History**: Displays the processing history for a specific account.
- **Currency Exchange Information**: Provides options to view supported currencies, get exchange rates, and convert currencies.
- **Generate Cheque Reports**: Handles report generation for processed cheques.
- **Exit**: Exits the application.

### 4. **Cheque Processing**
The `ChequeProcessor` is initialized with the following dependencies:
- `CurrencyExchangeService`
- `SignatureVerificationService`
- `CoreBankingSystemUpdater`
- `ChequeHistoryManager`
- `FraudDetectionService`

It processes cheques by verifying signatures, detecting fraud, converting currencies, and updating the core banking system.

### 5. **Batch Cheque Processing**
The `processChequeBatch` method collects details for multiple cheques from the user and processes them in a batch using the `ChequeProcessor`.

### 6. **Currency Exchange Menu**
The `displayCurrencyExchangeMenu` method provides a menu-driven interface for currency exchange operations, including viewing supported currencies, fetching exchange rates, and converting currencies.

## Methods

### `public static void main(String[] args)`
The main entry point of the application. It initializes services, handles user authentication, and provides a menu-driven interface for cheque processing and related operations.

### `private static User performLogin(Scanner scanner, UserService userService)`
Handles the user login process.
- **Parameters**:
  - `scanner`: The `Scanner` object for user input.
  - `userService`: The `UserService` object for user authentication.
- **Returns**: An authenticated `User` object or `null` if authentication fails after three attempts.

### `private static void processChequeBatch(Scanner scanner, ChequeProcessor chequeProcessor)`
Handles batch processing of cheques.
- **Parameters**:
  - `scanner`: The `Scanner` object for user input.
  - `chequeProcessor`: The `ChequeProcessor` object for processing cheques.

### `private static void displayCurrencyExchangeMenu(Scanner scanner, CurrencyExchangeService currencyExchangeService)`
Provides a menu-driven interface for currency exchange operations.
- **Parameters**:
  - `scanner`: The `Scanner` object for user input.
  - `currencyExchangeService`: The `CurrencyExchangeService` object for currency exchange operations.

## External Dependencies
The `CreateApplication` class depends on the following external classes:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies cheque signatures.
- `CoreBankingSystemUpdater`: Updates the core banking system.
- `UserService`: Manages user authentication and registration.
- `ChequeHistoryManager`: Maintains cheque processing history.
- `FraudDetectionService`: Detects fraudulent activities.
- `ChequeProcessor`: Processes cheques with various services.
- `BatchCheque`: Represents a cheque in batch processing.

## Notes
- The application uses a `Scanner` object for user input, which is closed upon exiting the application.
- The `performLogin` method uses a simple username-password authentication mechanism. In a real-world application, a more secure authentication method should be implemented.
- The `processChequeBatch` method uses a `List` of `BatchCheque` objects to store cheque details for batch processing.