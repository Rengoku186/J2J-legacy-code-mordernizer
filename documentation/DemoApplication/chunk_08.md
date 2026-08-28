---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ExceptionReportManager", "EmailNotificationService", "CurrencyRate"]
---

## Overview
This chunk of code is part of a larger application that handles cheque processing, currency exchange, and related operations. It includes methods for processing cheques, canceling cheques, and managing currency exchange rates. The code also integrates with external services and systems for core banking updates, cheque history management, exception reporting, and email notifications.

### Key Functionalities

#### 1. **Cheque Processing**
The code processes cheques by performing the following steps:
- Logs details about the currency, amount, exchange rate, and fees.
- Applies fees to calculate the final amount in the local currency.
- Updates the core banking system with the final amount.
- Records the cheque in the cheque history.
- Updates the cheque status to `PROCESSED`.
- Logs success or handles exceptions by reporting errors and sending email notifications.

#### 2. **Cheque Cancellation**
The `cancelCheque` method allows for canceling a cheque by:
- Updating the cheque status to `CANCELED`.
- Logging the cancellation or handling exceptions if an error occurs.

#### 3. **Currency Exchange Service**
The `CurrencyExchangeService` class provides functionalities for:
- Fetching exchange rates for specific currencies, with support for caching and fallback rates.
- Converting amounts between currencies.
- Providing detailed exchange rate information, including buy/sell rates and fees.
- Listing all supported currencies.

### Key Methods

#### Cheque Processing
```java
coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);
chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date());
chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED);
Logger.info("Cheque processed successfully: " + chequeNumber);
```
- **Purpose**: Updates the core banking system, records the cheque in history, and sets its status to `PROCESSED`.
- **Dependencies**: `CoreBankingSystemUpdater`, `ChequeHistoryManager`, `ChequeStatusManager`.

#### Exception Handling
```java
exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage());
emailNotificationService.sendEmail(
    accountNumber + "@bank.com",
    "Cheque Processing Error",
    "An error occurred while processing cheque " + chequeNumber + " for account " + accountNumber + ": " + ex.getMessage()
);
```
- **Purpose**: Reports exceptions and sends email notifications in case of errors during cheque processing.
- **Dependencies**: `ExceptionReportManager`, `EmailNotificationService`.

#### Cheque Cancellation
```java
chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED);
Logger.info("Cheque canceled: " + chequeNumber + " for account: " + accountNumber);
```
- **Purpose**: Cancels a cheque by updating its status to `CANCELED`.
- **Dependencies**: `ChequeStatusManager`.

#### Currency Exchange Service
- **getExchangeRate(String currency)**: Fetches the exchange rate for a given currency, using cache or fallback rates if necessary.
- **convertCurrency(double amount, String fromCurrency, String toCurrency)**: Converts an amount from one currency to another.
- **getDetailedExchangeRates(String currency)**: Provides detailed exchange rate information, including buy/sell rates and fees.
- **getSupportedCurrencies()**: Returns a list of all supported currencies.

### External Dependencies

1. **CoreBankingSystemUpdater**: Updates the core banking system with the final amount.
2. **ChequeHistoryManager**: Records cheque details in the history.
3. **ChequeStatusManager**: Manages the status of cheques (e.g., `PROCESSED`, `CANCELED`).
4. **ExceptionReportManager**: Reports exceptions that occur during cheque processing.
5. **EmailNotificationService**: Sends email notifications for errors or other events.
6. **CurrencyRate**: Represents exchange rate information, including the rate and the last updated timestamp.

### Notes
- The `CurrencyExchangeService` class uses a combination of caching, external API calls, and fallback rates to ensure reliable exchange rate data.
- Exception handling is robust, with logging, reporting, and notification mechanisms in place to handle errors gracefully.
- The code assumes the existence of several external services and classes, which are mocked or partially implemented in the provided code.