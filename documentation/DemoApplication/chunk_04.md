---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 0.95
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk contains several methods that handle different functionalities in a cheque processing application. These include:

1. **Batch Cheque Processing**: Collecting and processing batches of cheques.
2. **Currency Exchange Menu**: Displaying a menu for currency exchange operations.
3. **Report Generation**: Generating reports for cheque transactions over different time periods.
4. **Cheque Printing Simulation**: Simulating the printing of cheques.

Each method is designed to interact with specific services and handle user input via a `Scanner` object.

---

## 1. Batch Cheque Processing

### Purpose
This section processes a batch of cheques by iterating over a list of `BatchCheque` objects and invoking the `processCheque` method of the `ChequeProcessor` class.

### Key Operations
- **Adding Cheques to Batch**: Cheques are added to a list (`chequesToProcess`) using the `BatchCheque` class.
- **Processing Cheques**: Each cheque in the batch is processed using the `ChequeProcessor` service.
- **Error Handling**: Exceptions during cheque collection or processing are logged using the `Logger` class.

### External Dependencies
- `BatchCheque`: Represents a cheque with attributes like account number, cheque number, currency, amount, and signature.
- `ChequeProcessor`: Handles the processing of individual cheques.

---

## 2. Currency Exchange Menu

### Purpose
Displays a menu for currency exchange operations and handles user interactions.

### Key Operations
- **View Supported Currencies**: Fetches and displays a list of supported currencies from the `CurrencyExchangeService`.
- **Get Exchange Rate**: Retrieves the exchange rate for a specific currency.
- **Get Detailed Exchange Rate Information**: Provides detailed information, including mid, buy, sell, and fee rates for a currency.
- **Convert Currency**: Converts an amount from one currency to another.
- **Return to Main Menu**: Exits the currency exchange menu.

### External Dependencies
- `CurrencyExchangeService`: Provides methods for fetching supported currencies, exchange rates, and performing currency conversions.

---

## 3. Report Generation

### Purpose
Generates reports for cheque transactions over different time periods (daily, weekly, monthly, or custom date range).

### Key Operations
- **Select Report Type**: Allows the user to choose the type of report (daily, weekly, monthly, or custom).
- **Fetch Cheque Records**: Retrieves cheque records for the selected time period using the `ChequeHistoryManager`.
- **Generate CSV Report**: Creates a CSV file containing the cheque records and saves it to the file system.
- **Error Handling**: Handles invalid date formats and ensures the start date is not after the end date.

### External Dependencies
- `ChequeHistoryManager`: Manages cheque transaction history and provides methods for fetching records and generating reports.

---

## 4. Cheque Printing Simulation

### Purpose
Simulates the printing of a cheque by collecting necessary details from the user and invoking the `ChequePrintingService`.

### Key Operations
- **Collect Cheque Details**: Prompts the user to enter details such as payee name, amount, date, account number, and cheque number.
- **Date Parsing**: Parses the entered date and defaults to the current date if the format is invalid.
- **Simulate Printing**: Uses the `ChequePrintingService` to simulate the printing of the cheque.

### External Dependencies
- `ChequePrintingService`: Handles the simulation of cheque printing.

---

## Error Handling
Each method includes robust error handling to manage invalid user inputs, exceptions during processing, and other potential issues. Errors are logged using the `Logger` class, and user-friendly messages are displayed to guide the user.

---

## Conclusion
This code chunk demonstrates a modular approach to handling various functionalities in a cheque processing application. It leverages multiple services and classes to perform specific tasks, ensuring a clean and maintainable codebase.