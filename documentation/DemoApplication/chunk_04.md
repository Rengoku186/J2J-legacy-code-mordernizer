---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger application that handles cheque processing, currency exchange, report generation, and cheque printing. It includes methods for processing cheque batches, displaying a currency exchange menu, generating reports, and simulating cheque printing. The code interacts with several external services and classes, such as `BatchCheque`, `ChequeProcessor`, `CurrencyExchangeService`, `ChequeHistoryManager`, and `ChequePrintingService`.

## Key Functionalities

### 1. **Processing Cheque Batches**
- **Purpose**: Processes a batch of cheques by iterating over a list of `BatchCheque` objects and invoking the `processCheque` method of the `ChequeProcessor` class.
- **Error Handling**: Logs errors during cheque collection and processing using a `Logger`.
- **Key Operations**:
  - Adds `BatchCheque` objects to a list (`chequesToProcess`).
  - Iterates over the list and processes each cheque using `chequeProcessor.processCheque`.

### 2. **Currency Exchange Menu**
- **Purpose**: Provides a menu-driven interface for users to interact with the `CurrencyExchangeService`.
- **Menu Options**:
  1. View supported currencies.
  2. Get the exchange rate for a specific currency.
  3. Get detailed exchange rate information (e.g., mid, buy, sell, and fee rates).
  4. Convert an amount from one currency to another.
  5. Return to the main menu.
- **Error Handling**: Validates user input and handles unsupported currencies or invalid data gracefully.

### 3. **Report Generation**
- **Purpose**: Generates reports for cheque transactions over various time periods (daily, weekly, monthly, or custom date range).
- **Key Operations**:
  - Prompts the user to select a report type.
  - Retrieves cheque records for the specified time period using `ChequeHistoryManager.getAllChequeRecordsInPeriod`.
  - Generates a CSV report using `ChequeHistoryManager.generateChequeReportCSV` and writes it to a file.
- **Error Handling**:
  - Validates date inputs for custom date ranges.
  - Handles cases where no records are found for the selected period.

### 4. **Cheque Printing Simulation**
- **Purpose**: Simulates the process of printing a cheque using the `ChequePrintingService`.
- **Key Operations**:
  - Collects user input for payee name, amount, date, account number, and cheque number.
  - Validates the date format and defaults to the current date if invalid.

## External Dependencies

### 1. **BatchCheque**
- Represents a cheque with attributes such as account number, cheque number, currency, amount, and signature.

### 2. **ChequeProcessor**
- Handles the processing of cheques, including signature verification, fraud detection, currency conversion, and updates to the core banking system.

### 3. **CurrencyExchangeService**
- Provides functionalities for currency exchange, including retrieving supported currencies, exchange rates, and converting amounts between currencies.

### 4. **ChequeHistoryManager**
- Manages cheque transaction history and provides methods for retrieving records and generating reports.

### 5. **ChequePrintingService**
- Simulates the printing of cheques based on user-provided details.

## Error Handling
- The code includes robust error handling mechanisms, such as logging errors and validating user inputs.
- Common issues like invalid date formats, unsupported currencies, and empty cheque records are handled gracefully.

## Notes
- The `Logger` class is used for error logging but is not defined in the provided code chunk.
- The `scanner` object is used for user input and is assumed to be properly initialized elsewhere in the application.
- The `BufferedWriter` and `FileWriter` classes are used for writing reports to files, and exceptions during file operations are caught and logged.