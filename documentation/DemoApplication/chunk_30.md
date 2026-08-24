---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_30"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ChequeProcessor", "BatchCheque"]
---

# Documentation for `CreateApplication` Class

## Overview
The `CreateApplication` class serves as the entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, viewing cheque history, and managing currency exchange information.

## Key Functionalities

### 1. **System Initialization**
The `main` method initializes the following services:
- **`CurrencyExchangeService`**: Handles currency exchange operations.
- **`SignatureVerificationService`**: Verifies signatures on cheques.
- **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
- **`UserService`**: Manages user authentication and registration.
- **`ChequeHistoryManager`**: Maintains and displays cheque processing history.
- **`FraudDetectionService`**: Detects potential fraud in cheque transactions.

### 2. **Login Process**
The `performLogin` method handles user authentication. It allows up to three login attempts and returns an authenticated `User` object if successful. If authentication fails after three attempts, the application exits.

### 3. **Cheque Processing**
The application provides options for processing cheques:
- **Single Cheque Processing**: Users can input details such as account number, cheque number, currency, amount, and signature to process a single cheque.
- **Batch Cheque Processing**: Users can process multiple cheques in a batch by providing details for each cheque.

### 4. **Cheque History Management**
Users can view the history of processed cheques for a specific account using the `ChequeHistoryManager`.

### 5. **Currency Exchange Information**
The `displayCurrencyExchangeMenu` method provides options to view supported currencies, get exchange rates, and convert currencies.

### 6. **Report Generation**
The `handleReportGeneration` method allows users to generate various reports, such as daily, weekly, monthly, or custom date range reports, using the `ChequeHistoryManager`.

### 7. **Exit Option**
Users can exit the application at any time by selecting the appropriate menu option.

## Methods

### `performLogin(Scanner scanner, UserService userService)`
Handles the user login process.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `userService`: A `UserService` object for authenticating users.
- **Returns**: An authenticated `User` object or `null` if login fails after three attempts.

### `processChequeBatch(Scanner scanner, ChequeProcessor chequeProcessor)`
Handles batch processing of cheques.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `chequeProcessor`: A `ChequeProcessor` object for processing cheques.
- **Details**: Prompts the user for the number of cheques in the batch and their details, then processes each cheque.

### `displayCurrencyExchangeMenu(Scanner scanner, CurrencyExchangeService currencyExchangeService)`
Displays the currency exchange menu and handles user interactions.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `currencyExchangeService`: A `CurrencyExchangeService` object for currency-related operations.

### `handleReportGeneration(Scanner scanner, ChequeHistoryManager chequeHistoryManager)`
Handles the report generation menu and logic.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `chequeHistoryManager`: A `ChequeHistoryManager` object for managing cheque history.

## External Dependencies
The `CreateApplication` class depends on the following external classes:
- `CurrencyExchangeService`
- `SignatureVerificationService`
- `CoreBankingSystemUpdater`
- `UserService`
- `ChequeHistoryManager`
- `FraudDetectionService`
- `ChequeProcessor`
- `BatchCheque`

These classes provide the necessary functionality for currency exchange, signature verification, core banking updates, user authentication, cheque history management, fraud detection, and cheque processing.