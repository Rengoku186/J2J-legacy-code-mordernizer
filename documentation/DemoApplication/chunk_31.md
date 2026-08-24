---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_31"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "CurrencyExchangeService", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

This code chunk contains three main functionalities:

1. **Batch Cheque Processing**
2. **Currency Exchange Menu**
3. **Cheque Report Generation**

## 1. Batch Cheque Processing
This section of the code collects details for a batch of cheques from the user and processes them using a `chequeProcessor` object. The details collected include:

- Account number
- Cheque number
- Currency
- Amount
- Signature

The collected data is stored in a list of `BatchCheque` objects, which are then processed in a batch.

### Key Operations:
- User input is collected using a `Scanner` object.
- Each cheque is added to a list of `BatchCheque` objects.
- The `chequeProcessor.processCheque` method is called for each cheque in the list.

### External Dependency:
- `BatchCheque`: Represents a cheque with attributes like account number, cheque number, currency, amount, and signature.

## 2. Currency Exchange Menu
This section provides a menu-driven interface for currency exchange operations. The menu includes the following options:

1. View supported currencies.
2. Get the exchange rate for a specific currency.
3. Get detailed exchange rate information (mid, buy, sell, and fee rates).
4. Convert an amount from one currency to another.
5. Return to the main menu.

### Key Operations:
- User input is collected to navigate the menu and perform actions.
- The `CurrencyExchangeService` is used to fetch supported currencies, exchange rates, and perform currency conversion.

### External Dependency:
- `CurrencyExchangeService`: Provides methods for currency-related operations such as fetching exchange rates and converting currencies.

## 3. Cheque Report Generation
This section handles the generation of cheque reports based on user-selected time periods. The available options are:

1. Daily Report (Today)
2. Weekly Report (Last 7 Days)
3. Monthly Report (Last 30 Days)
4. Custom Date Range Report
5. Return to the main menu

### Key Operations:
- User input is collected to select the report type and date range.
- The `ChequeHistoryManager` is used to fetch cheque records for the specified period.
- The records are written to a CSV file.

### External Dependency:
- `ChequeHistoryManager`: Manages cheque history and provides methods to fetch records and generate CSV reports.

### Error Handling:
- Input validation is performed for date formats and logical errors (e.g., start date after end date).
- Exceptions during file writing are caught and logged.

## Additional Notes:
- The `SignatureVerificationService` class is partially included, which appears to manage account signatures for verification purposes.
- The code uses standard Java libraries like `Scanner`, `LocalDate`, and `BufferedWriter` for input handling, date manipulation, and file writing, respectively.