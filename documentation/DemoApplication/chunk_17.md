---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_17"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a larger application that handles various banking operations, including cheque processing, currency exchange, report generation, and cheque printing. The provided code includes several methods that perform specific tasks related to these operations. Below is a detailed explanation of the code.

---

### 1. **Batch Cheque Processing**
This section of the code processes a batch of cheques. It adds cheques to a list (`chequesToProcess`) and processes them using a `ChequeProcessor` instance.

#### Key Components:
- **`chequesToProcess`**: A collection that stores instances of `BatchCheque`.
- **`BatchCheque`**: Represents a cheque with attributes such as `accountNumber`, `chequeNumber`, `currency`, `amount`, and `signature`.
- **`chequeProcessor`**: An instance of the `ChequeProcessor` class, which handles the processing of cheques.

#### Workflow:
1. Cheques are added to the `chequesToProcess` list using the `BatchCheque` constructor.
2. If an exception occurs during input collection, it is logged using the `Logger.error` method, and the scanner buffer is cleared.
3. The batch of cheques is processed using the `chequeProcessor.processCheque` method.
4. Any exceptions during processing are logged.

#### External Dependencies:
- `BatchCheque`: Represents a cheque object.
- `ChequeProcessor`: A class responsible for processing cheques. It includes functionalities like signature verification, fraud detection, and currency conversion.

---

### 2. **Currency Exchange Menu**
This method (`displayCurrencyExchangeMenu`) provides a user interface for currency exchange operations. It interacts with the `CurrencyExchangeService` to perform various tasks.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `currencyExchangeService`: An instance of `CurrencyExchangeService` that provides currency exchange functionalities.

#### Menu Options:
1. **View Supported Currencies**: Displays a list of currencies supported by the service.
2. **Get Exchange Rate**: Retrieves the exchange rate for a specific currency.
3. **Get Detailed Exchange Rate Information**: Provides detailed information, including mid, buy, sell, and fee rates for a specific currency.
4. **Convert Currency**: Converts an amount from one currency to another.
5. **Return to Main Menu**: Exits the currency exchange menu.

#### External Dependencies:
- `CurrencyExchangeService`: Provides methods like `getSupportedCurrencies`, `getExchangeRate`, `getDetailedExchangeRates`, and `convertCurrency`.

---

### 3. **Report Generation**
The `handleReportGeneration` method generates reports for cheque transactions over different time periods.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `chequeHistoryManager`: An instance of `ChequeHistoryManager` that manages cheque transaction history.

#### Workflow:
1. Displays a menu with options for generating daily, weekly, monthly, or custom date range reports.
2. Based on the user's choice, determines the date range for the report.
3. Retrieves cheque records for the specified period using `chequeHistoryManager.getAllChequeRecordsInPeriod`.
4. Generates a CSV report using `chequeHistoryManager.generateChequeReportCSV` and writes it to a file.
5. Handles errors such as invalid date formats or no records found.

#### External Dependencies:
- `ChequeHistoryManager`: Manages cheque transaction history and provides methods for retrieving and generating reports.

---

### 4. **Cheque Printing Simulation**
The `handleChequePrinting` method simulates the process of printing a cheque.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `printingService`: An instance of `ChequePrintingService` that handles cheque printing operations.

#### Workflow:
1. Prompts the user to input details such as payee name, amount, date, account number, and cheque number.
2. Parses the date input and defaults to the current date if the input is invalid.
3. Uses the `printingService` to simulate the cheque printing process.

#### External Dependencies:
- `ChequePrintingService`: Provides methods for simulating cheque printing.

---

## Error Handling
- Exceptions during cheque input collection and processing are logged using `Logger.error`.
- Invalid user inputs, such as incorrect date formats, are handled with appropriate error messages.
- If no records are found for a report, the user is notified.

## Summary
This code chunk is part of a comprehensive banking application that handles cheque processing, currency exchange, report generation, and cheque printing. It relies on several external services and classes to perform these operations efficiently and includes robust error handling to ensure smooth execution.