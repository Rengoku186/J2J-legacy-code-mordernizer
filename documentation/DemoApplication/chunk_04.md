---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 0.95
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk

This code chunk is part of a larger application and contains several functionalities related to cheque processing, currency exchange, report generation, and cheque printing. Below is a detailed explanation of the purpose and methods in this chunk.

## Key Functionalities

### 1. **Batch Cheque Processing**
This section of the code handles the processing of a batch of cheques. It performs the following steps:

- **Adding Cheques to the Batch:**
  ```java
  chequesToProcess.add(new BatchCheque(accountNumber, chequeNumber, currency, amount, signature));
  ```
  - Creates a new `BatchCheque` object with the provided details (account number, cheque number, currency, amount, and signature) and adds it to the `chequesToProcess` list.
  - If an exception occurs during this process, it logs the error and clears the scanner buffer.

- **Processing the Batch:**
  ```java
  chequesToProcess.forEach(cheque -> {
      try {
          chequeProcessor.processCheque(cheque.accountNumber, cheque.chequeNumber, cheque.currency, cheque.amount, cheque.signature);
      } catch (Exception ex) {
          Logger.error("Error processing cheque in batch: " + ex.getMessage());
      }
  });
  ```
  - Iterates over the `chequesToProcess` list and processes each cheque using the `ChequeProcessor` class.
  - Logs any errors encountered during the processing of individual cheques.

### 2. **Currency Exchange Menu**
The `displayCurrencyExchangeMenu` method provides a user interface for interacting with the currency exchange service. It supports the following options:

- **View Supported Currencies:**
  Retrieves and displays a list of supported currencies from the `CurrencyExchangeService`.

- **Get Exchange Rate:**
  Prompts the user for a currency code and retrieves the exchange rate for that currency using the `CurrencyExchangeService`.

- **Get Detailed Exchange Rate Information:**
  Prompts the user for a currency code and retrieves detailed exchange rate information (mid, buy, sell, and fee rates) from the `CurrencyExchangeService`.

- **Convert Currency:**
  Prompts the user for an amount, source currency, and target currency, and converts the amount using the `CurrencyExchangeService`.

- **Return to Main Menu:**
  Exits the currency exchange menu.

### 3. **Report Generation**
The `handleReportGeneration` method provides a user interface for generating cheque reports. It supports the following options:

- **Daily Report:**
  Generates a report for cheques processed on the current day.

- **Weekly Report:**
  Generates a report for cheques processed in the last 7 days.

- **Monthly Report:**
  Generates a report for cheques processed in the last 30 days.

- **Custom Date Range Report:**
  Prompts the user for a start and end date, and generates a report for cheques processed within that range.

- **Return to Main Menu:**
  Exits the report generation menu.

The generated report is saved as a CSV file with a name based on the selected date range.

### 4. **Cheque Printing Simulation**
The `handleChequePrinting` method simulates the process of printing a cheque. It performs the following steps:

- Prompts the user for the payee name, amount, date, account number, and cheque number.
- Parses the date input and defaults to the current date if the input is invalid.
- Uses the `ChequePrintingService` to simulate the printing of the cheque.

## External Dependencies

- **`BatchCheque`:** Represents a cheque with attributes such as account number, cheque number, currency, amount, and signature.
- **`ChequeProcessor`:** Handles the processing of cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
- **`CurrencyExchangeService`:** Provides functionalities for currency exchange, including retrieving exchange rates and converting currencies.
- **`ChequeHistoryManager`:** Manages the history of cheques, including retrieving records for specific time periods and generating reports in CSV format.
- **`ChequePrintingService`:** Simulates the printing of cheques.

## Error Handling

- Errors during cheque batch input or processing are logged using the `Logger.error` method.
- Invalid user inputs, such as incorrect date formats or unsupported currency codes, are handled gracefully with appropriate error messages.
- If no cheque records are found for a selected report period, a message is displayed to the user.
- Errors during file writing for report generation are caught and logged.

This code chunk demonstrates robust error handling and provides a user-friendly interface for managing cheques, currency exchange, and report generation.