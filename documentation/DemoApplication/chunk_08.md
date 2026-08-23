---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ChequeStatus", "ExceptionReportManager", "EmailNotificationService"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a cheque processing system. It handles the processing and cancellation of cheques, including updating the core banking system, recording cheque history, managing cheque statuses, and handling exceptions. Additionally, it includes a utility class for currency exchange services.

## Code Breakdown

### Cheque Processing
The code processes a cheque by performing the following steps:

1. **Log and Display Transaction Details:**
   - Logs and displays details such as currency, original amount, exchange rate, fee rate, fee amount, and the amount in local currency before and after applying fees.

2. **Update Core Banking System:**
   - Calls `coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency)` to update the account balance in the core banking system.

   **Dependency:**
   - `CoreBankingSystemUpdater` is a mock implementation that updates the core banking system with the account number and the final amount in local currency.

3. **Record Cheque History:**
   - Calls `chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date())` to record the cheque details in the history.

   **Dependency:**
   - `ChequeHistoryManager` is a mock implementation that stores cheque records in a history map.

4. **Update Cheque Status:**
   - Calls `chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED)` to update the status of the cheque to `PROCESSED`.

   **Dependency:**
   - `ChequeStatusManager` is a class that manages the status of cheques using a map. The status is represented by the `ChequeStatus` enum, which includes values like `ISSUED`, `PROCESSED`, and `CANCELED`.

5. **Error Handling:**
   - If an exception occurs during processing, the following actions are taken:
     - Logs the error using `Logger.error`.
     - Reports the exception using `exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage())`.

       **Dependency:**
       - `ExceptionReportManager` is a class that logs exception details, including account number, cheque number, error type, and error message.

     - Sends an email notification about the error using `emailNotificationService.sendEmail`.

       **Dependency:**
       - `EmailNotificationService` is a class that simulates sending email notifications by printing the email details to the console.

### Cheque Cancellation
The `cancelCheque` method is used to cancel a cheque. It performs the following steps:

1. **Update Cheque Status:**
   - Calls `chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED)` to update the status of the cheque to `CANCELED`.

2. **Log and Display Cancellation:**
   - Logs the cancellation using `Logger.info` and displays a message to the console.

3. **Error Handling:**
   - If an exception occurs during cancellation, it logs the error using `Logger.error` and displays an error message to the console.

### CurrencyExchangeService Class
This class provides methods for handling currency exchange rates and conversions. It includes the following features:

1. **Exchange Rate Retrieval:**
   - The `getExchangeRate` method retrieves the exchange rate for a given currency. It first checks a cache for a valid rate, then attempts to fetch the rate from an external API. If both fail, it falls back to predefined rates.

2. **Currency Conversion:**
   - The `convertCurrency` method converts an amount from one currency to another by first converting it to the base currency (USD) and then to the target currency.

3. **Detailed Exchange Rates:**
   - The `getDetailedExchangeRates` method provides detailed rate information, including mid, buy, and sell rates, as well as fees.

4. **Supported Currencies:**
   - The `getSupportedCurrencies` method returns a sorted list of all supported currency codes.

5. **Cache Validation:**
   - The `isCacheValid` method checks if a cached exchange rate is still valid based on a predefined expiry time.

### External Dependencies
- **CoreBankingSystemUpdater:** Updates the core banking system with account and transaction details.
- **ChequeHistoryManager:** Records cheque details in a history map.
- **ChequeStatusManager:** Manages the status of cheques using a map.
- **ChequeStatus:** Enum representing the status of a cheque (e.g., ISSUED, PROCESSED, CANCELED).
- **ExceptionReportManager:** Logs exception details.
- **EmailNotificationService:** Simulates sending email notifications.

## Error Handling
The code includes robust error handling mechanisms:
- Logs errors using `Logger.error`.
- Reports exceptions using `ExceptionReportManager`.
- Sends email notifications for errors using `EmailNotificationService`.

## Notes
- The `CurrencyExchangeService` class uses a combination of cached rates, external API calls, and fallback rates to provide exchange rate information. The API key is hardcoded as "demo" and should be replaced with a valid key in a production environment.
- The `CurrencyExchangeService` class also calculates buy/sell rates and fees based on the base rate.
- The `cancelCheque` method is a simple implementation that only updates the cheque status to `CANCELED` and logs the action.

This code is part of a larger system and relies on several external classes and services for its functionality.