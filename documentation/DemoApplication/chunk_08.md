---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.9
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ChequeStatus", "ExceptionReportManager", "EmailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk

This code chunk is part of a larger system that processes financial transactions, specifically handling cheques and currency exchange operations. Below is a detailed explanation of the functionality provided in this chunk.

## Key Functionalities

### 1. **Processing Cheques**
The code handles cheque processing, including:
- Logging details about the currency, amount, exchange rate, and fees.
- Calculating the final amount in the local currency after applying fees.
- Updating the core banking system with the final amount.
- Recording the cheque in the cheque history.
- Updating the cheque status to `PROCESSED` upon successful processing.
- Handling exceptions during cheque processing and notifying the user via email in case of errors.

#### Key Methods and Classes Used:
- **`coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency)`**:
  Updates the core banking system with the account number and the final amount in the local currency. This method is part of the `CoreBankingSystemUpdater` class.

- **`chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date())`**:
  Records the cheque details, including account number, cheque number, currency, amount, and the current date. This method is part of the `ChequeHistoryManager` class.

- **`chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED)`**:
  Updates the status of the cheque to `PROCESSED`. This method is part of the `ChequeStatusManager` class, which uses the `ChequeStatus` enum to represent the status of cheques (e.g., `ISSUED`, `PROCESSED`, `CANCELED`).

- **`Logger.info()` and `Logger.error()`**:
  Logs information and errors during the cheque processing.

- **`exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage())`**:
  Reports any exceptions that occur during cheque processing. This method is part of the `ExceptionReportManager` class.

- **`emailNotificationService.sendEmail()`**:
  Sends an email notification to the account holder in case of a processing error. This method is part of the `EmailNotificationService` class.

### 2. **Cancelling Cheques**
The code provides functionality to cancel a cheque by updating its status to `CANCELED` and logging the action.

#### Key Methods and Classes Used:
- **`chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED)`**:
  Updates the status of the cheque to `CANCELED`.

- **`Logger.info()` and `Logger.error()`**:
  Logs information and errors during the cheque cancellation process.

### 3. **Currency Exchange Service**
The `CurrencyExchangeService` class provides functionalities for handling currency exchange operations, including fetching exchange rates, converting currencies, and providing detailed exchange rate information.

#### Key Methods:
- **`getExchangeRate(String currency)`**:
  Fetches the exchange rate for a given currency. The method first checks a local cache for the rate, then attempts to fetch it from an external API. If both fail, it falls back to predefined rates.

- **`convertCurrency(double amount, String fromCurrency, String toCurrency)`**:
  Converts an amount from one currency to another using the exchange rates.

- **`getDetailedExchangeRates(String currency)`**:
  Provides detailed exchange rate information, including buy/sell rates and fees.

- **`getSupportedCurrencies()`**:
  Returns a list of all supported currencies, including the base currency (`USD`) and fallback rates.

#### Key Attributes:
- **`exchangeRateCache`**:
  A cache for storing exchange rates to reduce API calls.

- **`FALLBACK_RATES`**:
  A predefined map of fallback exchange rates for various currencies.

- **`CACHE_EXPIRY_MINUTES`**:
  The duration (in minutes) for which cached rates are considered valid.

- **`BASE_CURRENCY`**:
  The base currency for all exchange rate calculations (default is `USD`).

#### Helper Methods:
- **`isCacheValid(String currency)`**:
  Checks if the cached exchange rate for a given currency is still valid.

## Error Handling
The code includes robust error handling mechanisms:
- Logs errors using `Logger.error()`.
- Reports exceptions using `exceptionReportManager.reportException()`.
- Notifies users via email using `emailNotificationService.sendEmail()`.

## External Dependencies
The following external classes and enums are used in this code chunk:
- **`CoreBankingSystemUpdater`**: Updates the core banking system.
- **`ChequeHistoryManager`**: Manages cheque history records.
- **`ChequeStatusManager`**: Manages the status of cheques.
- **`ChequeStatus`**: Enum representing cheque statuses (`ISSUED`, `PROCESSED`, `CANCELED`).
- **`ExceptionReportManager`**: Handles exception reporting.
- **`EmailNotificationService`**: Sends email notifications.
- **`CurrencyRate`**: Represents exchange rate information, including the rate and the last updated timestamp.

## Summary
This code chunk is a critical part of the application, handling cheque processing, cancellation, and currency exchange operations. It integrates with multiple services and includes comprehensive error handling to ensure reliability and user notification in case of issues.