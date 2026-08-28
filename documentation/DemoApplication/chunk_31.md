---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_31"
confidence_score: 0.95
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger Java application and contains three main functionalities:

1. **Batch Cheque Processing**: Collects user input for a batch of cheques and processes them using a `ChequeProcessor`.
2. **Currency Exchange Menu**: Provides a menu-driven interface for interacting with a `CurrencyExchangeService` to view and convert currencies.
3. **Cheque Report Generation**: Allows users to generate reports for cheque transactions over various time periods using a `ChequeHistoryManager`.

## Key Functionalities

### 1. Batch Cheque Processing
The code initializes a list of `BatchCheque` objects and collects user input for each cheque in the batch. The collected data includes:
- Account number
- Cheque number
- Currency
- Amount
- Signature

Once the data is collected, the cheques are processed using the `ChequeProcessor` class. The `processCheque` method of `ChequeProcessor` is invoked for each cheque in the batch.

#### External Dependency: `BatchCheque`
The `BatchCheque` class is used to create objects representing individual cheques. Each `BatchCheque` object contains the following fields:
- `accountNumber`
- `chequeNumber`
- `currency`
- `amount`
- `signature`

#### External Dependency: `ChequeProcessor`
The `ChequeProcessor` class is responsible for processing cheques. It includes methods for signature verification, fraud detection, currency conversion, and updating the core banking system.

---

### 2. Currency Exchange Menu
The `displayCurrencyExchangeMenu` method provides a menu-driven interface for interacting with the `CurrencyExchangeService`. The menu offers the following options:

1. View supported currencies.
2. Get the exchange rate for a specific currency.
3. Get detailed exchange rate information, including mid, buy, sell, and fee rates.
4. Convert an amount from one currency to another.
5. Return to the main menu.

#### External Dependency: `CurrencyExchangeService`
The `CurrencyExchangeService` provides methods for:
- Retrieving supported currencies.
- Fetching exchange rates for specific currencies.
- Converting amounts between currencies.

---

### 3. Cheque Report Generation
The `handleReportGeneration` method allows users to generate reports for cheque transactions. The user can choose from the following report types:

1. Daily Report (Today)
2. Weekly Report (Last 7 Days)
3. Monthly Report (Last 30 Days)
4. Custom Date Range Report
5. Return to the main menu

The method uses the `ChequeHistoryManager` to fetch cheque records for the selected time period and generates a CSV report. The report is saved to a file with a name based on the report type and date range.

#### External Dependency: `ChequeHistoryManager`
The `ChequeHistoryManager` is responsible for managing cheque transaction history. It provides methods for:
- Recording cheque transactions.
- Fetching cheque records for a specific time period.
- Generating CSV reports for cheque transactions.

---

## Additional Notes
- The `SignatureVerificationService` is a nested class within the same file and is used for verifying cheque signatures.
- The code uses `Scanner` for user input and `BufferedWriter` for writing reports to files.
- Error handling is implemented for invalid date formats and other user input errors.

## Potential Improvements
- Add more robust error handling for user input.
- Use a logging framework instead of `System.out.println` for better logging and debugging.
- Modularize the code further to improve readability and maintainability.