---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_30"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ChequeProcessor", "BatchCheque"]
---

# Documentation for `CreateApplication` Class

## Overview
The `CreateApplication` class serves as the entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, viewing cheque history, and performing other related operations.

## Class Structure
The class contains the following key components:

### Main Method
The `main` method is the starting point of the application. It performs the following tasks:

1. **Initialization**:
   - Prints a welcome message.
   - Initializes various services required for the application:
     - `CurrencyExchangeService`: Handles currency exchange operations.
     - `SignatureVerificationService`: Verifies signatures on cheques.
     - `CoreBankingSystemUpdater`: Updates the core banking system with transaction details.
     - `UserService`: Manages user authentication and registration.
     - `ChequeHistoryManager`: Maintains and displays cheque transaction history.
     - `FraudDetectionService`: Detects fraudulent activities in cheque transactions.
   - Sets up dependencies, such as linking the `FraudDetectionService` with the `ChequeHistoryManager`.

2. **User Authentication**:
   - Calls the `performLogin` method to authenticate the user.
   - Exits the application if login fails after the maximum allowed attempts.

3. **Menu-Driven Interface**:
   - Displays a menu with options for various operations, including:
     - Processing a single cheque.
     - Processing multiple cheques in a batch.
     - Viewing cheque history.
     - Accessing currency exchange information.
     - Generating cheque reports.
     - Exiting the application.
   - Handles user input and invokes the appropriate methods based on the selected option.

### Helper Methods

#### `performLogin`
Handles the user login process.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `UserService userService`: Used to authenticate the user.
- **Returns**: An authenticated `User` object if login is successful, or `null` if login fails after the maximum allowed attempts.
- **Logic**:
  - Prompts the user for a username and password.
  - Validates the credentials using the `UserService`.
  - Allows up to three login attempts before exiting.

#### `processChequeBatch`
Handles the processing of multiple cheques in a batch.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `ChequeProcessor chequeProcessor`: Used to process the cheques.
- **Logic**:
  - Prompts the user for the number of cheques in the batch.
  - Collects details for each cheque (account number, cheque number, currency, amount, and signature).
  - Adds the cheque details to a list and processes them using the `ChequeProcessor`.

#### `displayCurrencyExchangeMenu`
Displays the currency exchange menu and handles user interactions.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `CurrencyExchangeService currencyExchangeService`: Used to fetch and display currency exchange information.

#### `handleReportGeneration`
Handles the generation of cheque reports.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `ChequeHistoryManager chequeHistoryManager`: Used to fetch and display cheque history for report generation.

## External Dependencies
The `CreateApplication` class relies on the following external classes:

1. **`CurrencyExchangeService`**: Manages currency exchange operations.
2. **`SignatureVerificationService`**: Verifies the authenticity of cheque signatures.
3. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
4. **`UserService`**: Handles user authentication and registration.
5. **`ChequeHistoryManager`**: Maintains and displays cheque transaction history.
6. **`FraudDetectionService`**: Detects fraudulent activities in cheque transactions.
7. **`ChequeProcessor`**: Processes cheques, including signature verification, fraud detection, and core banking updates.
8. **`BatchCheque`**: Represents a cheque in a batch processing operation.

## Key Features
- **User Authentication**: Ensures only authorized users can access the system.
- **Cheque Processing**: Supports both single and batch cheque processing.
- **Fraud Detection**: Integrates fraud detection mechanisms to ensure secure transactions.
- **Cheque History Management**: Allows users to view the history of processed cheques.
- **Currency Exchange**: Provides information on currency exchange rates and conversions.
- **Report Generation**: Enables users to generate reports based on cheque history.

## Notes
- The application uses a `Scanner` for user input, which may not be suitable for production environments due to potential security risks (e.g., reading passwords in plain text).
- The services used in this application appear to be mock implementations, as indicated by the search results.
- The `BatchCheque` class is used to represent individual cheques in batch processing but its implementation details were not fully provided in the code chunk.