---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_21"
confidence_score: 0.9
external_dependencies: ["exceptionReportManager", "Logger", "currencyExchangeService", "coreBankingSystemUpdater", "chequeHistoryManager", "chequeStatusManager", "emailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a larger system that processes cheques, handles currency exchange, and manages cheque statuses. It includes logic for handling delayed cheques, converting foreign currency amounts to local currency, updating the core banking system, recording cheque history, and managing cheque statuses. Additionally, it provides a method to cancel cheques and includes a nested `CurrencyExchangeService` class for handling currency exchange rates and conversions.

## Code Breakdown

### 1. Simulating Delayed Cheques
```java
if (chequeNumber.endsWith("9")) {
    exceptionReportManager.reportException(accountNumber, chequeNumber, "Delayed", "Cheque processing delayed (simulated)");
    Logger.info("Cheque processing delayed for cheque: " + chequeNumber);
    System.out.println("Cheque processing delayed (simulated).");
    // Optional: send notification for delayed cheques if desired
}
```
- **Purpose**: Simulates a delay in cheque processing if the cheque number ends with '9'.
- **Key Actions**:
  - Reports the delay using `exceptionReportManager`.
  - Logs the delay using `Logger`.
  - Prints a message to the console.

### 2. Currency Conversion for Non-Local Currencies
```java
if (!"USD".equalsIgnoreCase(currency)) {
    Map<String, Double> detailedRates = currencyExchangeService.getDetailedExchangeRates(currency);

    if (detailedRates.isEmpty()) {
        Logger.error("Exchange rate unavailable for currency: " + currency);
        System.out.println("Failed to fetch exchange rate. Cheque processing aborted.");
        return;
    }

    double buyRate = detailedRates.get("buy");
    double fee = detailedRates.get("fee");

    amountInLocalCurrency = amount * buyRate;
    double feeAmount = amount * fee;

    System.out.println("Currency: " + currency.toUpperCase());
    System.out.println("Original amount: " + amount);
    System.out.println("Exchange rate (buy): " + buyRate);
    System.out.println("Fee rate: " + fee);
    System.out.println("Fee amount: " + feeAmount);
    System.out.println("Amount in local currency (before fees): " + amountInLocalCurrency);

    amountInLocalCurrency -= feeAmount;
    System.out.println("Final amount in local currency (USD): " + amountInLocalCurrency);
} else {
    System.out.println("Processing in local currency (USD): " + amountInLocalCurrency);
}
```
- **Purpose**: Converts the cheque amount to the local currency (USD) if the cheque is in a foreign currency.
- **Key Actions**:
  - Fetches detailed exchange rates using `currencyExchangeService`.
  - Logs an error and aborts processing if exchange rates are unavailable.
  - Calculates the amount in local currency using the buy rate and deducts a fee.
  - Prints detailed information about the conversion process.

### 3. Updating the Core Banking System
```java
coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);
```
- **Purpose**: Updates the core banking system with the account number and the converted amount in local currency.
- **Dependency**: `coreBankingSystemUpdater` is responsible for this operation.

### 4. Recording Cheque History
```java
chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date());
```
- **Purpose**: Records the cheque details, including account number, cheque number, currency, amount, and the current date.
- **Dependency**: `chequeHistoryManager` handles the recording of cheque history.

### 5. Updating Cheque Status
```java
chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED);
Logger.info("Cheque processed successfully: " + chequeNumber);
System.out.println("Cheque processed successfully.");
```
- **Purpose**: Updates the status of the cheque to `PROCESSED` upon successful processing.
- **Key Actions**:
  - Updates the status using `chequeStatusManager`.
  - Logs the successful processing using `Logger`.
  - Prints a success message to the console.

### 6. Error Handling
```java
} catch (Exception ex) {
    Logger.error("Error processing cheque " + chequeNumber + ": " + ex.getMessage());
    exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage());
    System.out.println("An error occurred during cheque processing. Please check logs.");
    emailNotificationService.sendEmail(
        accountNumber + "@bank.com",
        "Cheque Processing Error",
        "An error occurred while processing cheque " + chequeNumber + " for account " + accountNumber + ": " + ex.getMessage()
    );
}
```
- **Purpose**: Handles exceptions that occur during cheque processing.
- **Key Actions**:
  - Logs the error using `Logger`.
  - Reports the error using `exceptionReportManager`.
  - Sends an email notification using `emailNotificationService`.

### 7. Cancelling a Cheque
```java
public void cancelCheque(String accountNumber, String chequeNumber) {
    try {
        chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED);
        Logger.info("Cheque canceled: " + chequeNumber + " for account: " + accountNumber);
        System.out.println("Cheque " + chequeNumber + " for account " + accountNumber + " has been canceled.");
    } catch (Exception ex) {
        Logger.error("Error canceling cheque " + chequeNumber + ": " + ex.getMessage());
        System.out.println("An error occurred while canceling the cheque.");
    }
}
```
- **Purpose**: Cancels a cheque and updates its status to `CANCELED`.
- **Key Actions**:
  - Updates the status using `chequeStatusManager`.
  - Logs the cancellation using `Logger`.
  - Prints a cancellation message to the console.
  - Handles exceptions by logging errors and printing error messages.

### 8. `CurrencyExchangeService` Class
The `CurrencyExchangeService` class provides methods for fetching and converting currency exchange rates. It includes:

#### Methods:
1. **`getExchangeRate(String currency)`**:
   - Fetches the exchange rate for a given currency.
   - Uses a cache for previously fetched rates.
   - Falls back to predefined rates if the API is unavailable.

2. **`convertCurrency(double amount, String fromCurrency, String toCurrency)`**:
   - Converts an amount from one currency to another using exchange rates.

3. **`getDetailedExchangeRates(String currency)`**:
   - Provides detailed exchange rate information, including buy/sell rates and fees.

#### Attributes:
- `exchangeRateCache`: A cache for storing exchange rates.
- `BASE_CURRENCY`: The base currency (USD).
- `CACHE_EXPIRY_MINUTES`: Cache expiry time in minutes.
- `API_KEY`: API key for fetching rates from an external source.
- `FALLBACK_RATES`: Predefined fallback rates for various currencies.

## External Dependencies
- **`exceptionReportManager`**: Handles reporting of exceptions.
- **`Logger`**: Logs messages and errors.
- **`currencyExchangeService`**: Provides currency exchange rates and conversion methods.
- **`coreBankingSystemUpdater`**: Updates the core banking system.
- **`chequeHistoryManager`**: Records cheque history.
- **`chequeStatusManager`**: Manages the status of cheques.
- **`emailNotificationService`**: Sends email notifications.
- **`CurrencyRate`**: Represents exchange rate information, including the rate and last updated timestamp.