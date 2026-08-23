---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_31"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

This code chunk is part of a larger Java application and contains three main functionalities:

1. **Batch Cheque Processing**
2. **Currency Exchange Menu**
3. **Cheque Report Generation**

## 1. Batch Cheque Processing

This section of the code collects details for a batch of cheques from the user and processes them using a `ChequeProcessor` instance.

### Key Steps:
- A list `chequesToProcess` is initialized to store `BatchCheque` objects.
- A loop iterates `batchSize` times to collect cheque details (account number, cheque number, currency, amount, and signature) from the user via a `Scanner`.
- Each cheque is added to the `chequesToProcess` list as a `BatchCheque` object.
- After collecting all cheques, the `ChequeProcessor` processes each cheque in the list by calling its `processCheque` method.

### External Dependencies:
- **`BatchCheque`**: Represents a cheque with attributes such as account number, cheque number, currency, amount, and signature.
- **`ChequeProcessor`**: A service responsible for processing cheques. It includes functionalities like signature verification, fraud detection, currency conversion, and updating the core banking system.

## 2. Currency Exchange Menu

This section provides a menu-driven interface for users to interact with a `CurrencyExchangeService` to perform various currency-related operations.

### Menu Options:
1. **View Supported Currencies**: Displays a list of currencies supported by the service.
2. **Get Exchange Rate**: Allows the user to input a currency code and retrieves the exchange rate for that currency.
3. **Get Detailed Exchange Rate Information**: Provides detailed exchange rate information (mid, buy, sell, and fee rates) for a specific currency.
4. **Convert Currency**: Converts an amount from one currency to another using the `convertCurrency` method of `CurrencyExchangeService`.
5. **Return to Main Menu**: Exits the currency exchange menu.

### External Dependencies:
- **`CurrencyExchangeService`**: Provides methods to get supported currencies, fetch exchange rates, and perform currency conversions.

## 3. Cheque Report Generation

This section handles the generation of cheque reports for different time periods or custom date ranges.

### Key Steps:
- Displays a menu with options for generating daily, weekly, monthly, or custom date range reports.
- Based on the user's choice, determines the start and end dates for the report.
- Fetches cheque records for the specified date range using the `ChequeHistoryManager`.
- If records are found, generates a CSV report and writes it to a file.

### External Dependencies:
- **`ChequeHistoryManager`**: Manages cheque history and provides methods to fetch records within a specific date range and generate CSV reports.

### Error Handling:
- Ensures proper handling of invalid date formats and cases where the start date is after the end date.
- Handles exceptions during file writing and informs the user of any errors.

## Additional Notes:
- The `SignatureVerificationService` class is partially included in the chunk and appears to provide a mechanism for verifying cheque signatures.
- The `Scanner` object is used extensively for user input throughout the code.

This chunk demonstrates a combination of user interaction, data processing, and integration with external services to achieve its functionality.