---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ExceptionReportManager", "EmailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk

This code chunk is part of a larger system that handles financial transactions, specifically related to processing and canceling cheques, as well as managing currency exchange rates. Below is a detailed explanation of the functionality provided by this code.

## **Purpose**
The code is responsible for:
1. Processing cheques, including updating the core banking system, recording cheque history, and managing cheque statuses.
2. Handling errors during cheque processing by reporting exceptions and sending email notifications.
3. Canceling cheques and updating their status.
4. Providing a `CurrencyExchangeService` class for handling currency exchange rates, including fetching rates from an external API, caching rates, and providing fallback rates.

---

## **Methods and Functionalities**

### **Cheque Processing**

#### **Key Steps in Cheque Processing:**
1. **Currency Conversion and Fee Calculation:**
   - The code calculates the amount in local currency (USD) based on the exchange rate and applies a fee.
   - The final amount is printed to the console.

   ```java
   System.out.println("Currency: " + currency.toUpperCase());
   System.out.println("Original amount: " + amount);
   System.out.println("Exchange rate (buy): " + buyRate);
   System.out.println("Fee rate: " + fee);
   System.out.println("Fee amount: " + feeAmount);
   System.out.println("Amount in local currency (before fees): " + amountInLocalCurrency);

   // Apply fee
   amountInLocalCurrency -= feeAmount;
   System.out.println("Final amount in local currency (USD): " + amountInLocalCurrency);
   ```

2. **Core Banking System Update:**
   - The `CoreBankingSystemUpdater` class is used to update the core banking system with the final amount in local currency.

   ```java
   coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);
   ```

3. **Cheque History Recording:**
   - The `ChequeHistoryManager` class records the cheque details, including account number, cheque number, currency, amount, and date.

   ```java
   chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date());
   ```

4. **Cheque Status Update:**
   - The `ChequeStatusManager` class updates the status of the cheque to `PROCESSED` upon successful processing.

   ```java
   chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED);
   ```

5. **Error Handling:**
   - If an exception occurs during cheque processing, the error is logged, and the `ExceptionReportManager` class is used to report the exception.
   - An email notification is sent to the account holder using the `EmailNotificationService` class.

   ```java
   Logger.error("Error processing cheque " + chequeNumber + ": " + ex.getMessage());
   exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage());
   emailNotificationService.sendEmail(
       accountNumber + "@bank.com",
       "Cheque Processing Error",
       "An error occurred while processing cheque " + chequeNumber + " for account " + accountNumber + ": " + ex.getMessage()
   );
   ```

### **Cheque Cancellation**

#### **Method: `cancelCheque`**
- Cancels a cheque by updating its status to `CANCELED` using the `ChequeStatusManager` class.
- Logs the cancellation and prints a confirmation message to the console.
- Handles exceptions by logging the error and printing an error message to the console.

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

### **Currency Exchange Service**

#### **Class: `CurrencyExchangeService`**
- Provides functionalities for handling currency exchange rates, including fetching rates from an external API, caching rates, and using fallback rates.

#### **Key Methods:**
1. **`getExchangeRate(String currency)`**
   - Fetches the exchange rate for a given currency.
   - Checks the cache for a valid rate, fetches from an external API if not cached, and falls back to predefined rates if the API fetch fails.

2. **`convertCurrency(double amount, String fromCurrency, String toCurrency)`**
   - Converts an amount from one currency to another using the exchange rates.

3. **`getDetailedExchangeRates(String currency)`**
   - Provides detailed exchange rate information, including buy/sell rates and fees.

4. **`getSupportedCurrencies()`**
   - Returns a list of all supported currencies, including the base currency (USD) and fallback rates.

5. **`isCacheValid(String currency)`**
   - Checks if the cached exchange rate for a currency is still valid based on the cache expiry time.

---

## **External Dependencies**
The following external classes and services are used in this code:
1. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
2. **`ChequeHistoryManager`**: Records cheque details for historical tracking.
3. **`ChequeStatusManager`**: Manages the status of cheques (e.g., ISSUED, PROCESSED, CANCELED).
4. **`ExceptionReportManager`**: Reports exceptions that occur during cheque processing.
5. **`EmailNotificationService`**: Sends email notifications for errors or other events.
6. **`CurrencyRate`**: Represents exchange rate information, including the rate and the last updated timestamp.