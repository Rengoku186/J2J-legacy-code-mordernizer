---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_33"
confidence_score: 0.95
external_dependencies: ["FALLBACK_RATES", "exchangeRateCache", "CurrencyRate", "CACHE_EXPIRY_MINUTES", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a larger application that provides currency exchange services and fraud detection for cheque transactions. It includes methods for handling currency exchange rates, converting currencies, managing exchange rate caches, and detecting fraudulent cheque activities. The code relies on external dependencies such as `FALLBACK_RATES`, `exchangeRateCache`, `CurrencyRate`, `CACHE_EXPIRY_MINUTES`, `FraudDetection`, `ChequeHistoryManager`, and `ChequeTransaction`.

## Code Breakdown

### 1. Fallback Exchange Rates
```java
Double fallbackRate = FALLBACK_RATES.get(currencyCode);
if (fallbackRate != null) {
    System.out.println("Using fallback rate for " + currencyCode + ": " + fallbackRate);
    exchangeRateCache.put(currencyCode, new CurrencyRate(fallbackRate, java.time.LocalDateTime.now()));
    return fallbackRate;
}
System.out.println("No exchange rate available for currency: " + currencyCode);
return 0.0;
```
- **Purpose**: This block uses fallback exchange rates when fetching rates from an external API fails. If a fallback rate exists for the given currency code, it is used and cached with a timestamp.
- **Key Variables**:
  - `FALLBACK_RATES`: A predefined map of fallback exchange rates for various currencies.
  - `exchangeRateCache`: A cache to store exchange rates with timestamps.
  - `CurrencyRate`: A class that encapsulates the exchange rate and the timestamp of when it was last updated.

### 2. Currency Conversion
```java
public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
    double fromRate = getExchangeRate(fromCurrency);
    double toRate = getExchangeRate(toCurrency);

    if (fromRate <= 0 || toRate <= 0) {
        System.out.println("Cannot convert: invalid exchange rates");
        return 0.0;
    }

    double amountInBaseCurrency = amount * fromRate;
    double convertedAmount = amountInBaseCurrency / toRate;

    System.out.println(String.format("Converted %.2f %s to %.2f %s",
            amount, fromCurrency.toUpperCase(), convertedAmount, toCurrency.toUpperCase()));

    return convertedAmount;
}
```
- **Purpose**: Converts an amount from one currency to another using exchange rates.
- **Key Steps**:
  1. Fetch exchange rates for the source (`fromCurrency`) and target (`toCurrency`) currencies.
  2. Validate the rates to ensure they are greater than zero.
  3. Convert the amount to the base currency and then to the target currency.
  4. Log the conversion details.

### 3. Detailed Exchange Rates
```java
public Map<String, Double> getDetailedExchangeRates(String currency) {
    String currencyCode = currency.toUpperCase();
    double baseRate = getExchangeRate(currencyCode);

    if (baseRate <= 0) {
        return Collections.emptyMap();
    }

    Map<String, Double> detailedRates = new HashMap<>();
    detailedRates.put("mid", baseRate);
    detailedRates.put("buy", baseRate * 0.99);
    detailedRates.put("sell", baseRate * 1.01);
    detailedRates.put("fee", baseRate * 0.005);

    return detailedRates;
}
```
- **Purpose**: Provides detailed exchange rate information, including mid, buy, sell rates, and fees.
- **Key Calculations**:
  - `buy`: Slightly lower than the mid rate (99%).
  - `sell`: Slightly higher than the mid rate (101%).
  - `fee`: A 0.5% fee based on the mid rate.

### 4. Supported Currencies
```java
public List<String> getSupportedCurrencies() {
    List<String> currencies = new ArrayList<>();
    currencies.add(BASE_CURRENCY);
    currencies.addAll(FALLBACK_RATES.keySet());
    Collections.sort(currencies);
    return currencies;
}
```
- **Purpose**: Returns a sorted list of all supported currency codes, including the base currency and those in the fallback rates.

### 5. Cache Validation
```java
private boolean isCacheValid(String currency) {
    if (!exchangeRateCache.containsKey(currency)) {
        return false;
    }

    CurrencyRate cachedRate = exchangeRateCache.get(currency);
    java.time.LocalDateTime now = java.time.LocalDateTime.now();
    java.time.LocalDateTime expiryTime = cachedRate.getLastUpdated().plusMinutes(CACHE_EXPIRY_MINUTES);

    return now.isBefore(expiryTime);
}
```
- **Purpose**: Checks if the cached exchange rate for a currency is still valid based on a predefined expiration time (`CACHE_EXPIRY_MINUTES`).
- **Key Variables**:
  - `exchangeRateCache`: Stores cached exchange rates.
  - `CACHE_EXPIRY_MINUTES`: The duration (in minutes) for which a cached rate is considered valid.

### 6. Fraud Detection Service
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount) {
    boolean isDuplicate = checkDuplicateCheque(accountId, chequeNumber);
    boolean isAbnormal = checkAbnormalAmount(amount);
    boolean isSuspicious = checkSuspiciousActivity(accountId, amount);
    boolean isVelocityFraud = checkVelocityFraud(accountId, amount);
    boolean isPatternFraud = checkPatternFraud(accountId, amount);

    boolean isHistoricalDuplicate = false;
    boolean isUnusualFrequency = false;
    boolean isSimilarToRecent = false;

    if (historyManager != null) {
        isHistoricalDuplicate = checkHistoricalDuplicate(accountId, chequeNumber);
        isUnusualFrequency = checkUnusualFrequency(accountId);
        isSimilarToRecent = checkSimilarToRecent(accountId, amount);
    }

    logFraudChecks(accountId, chequeNumber, amount, isDuplicate, isAbnormal,
            isSuspicious, isVelocityFraud, isPatternFraud,
            isHistoricalDuplicate, isUnusualFrequency, isSimilarToRecent);

    AlertLevel alertLevel = determineAlertLevel(isDuplicate, isAbnormal,
            isSuspicious, isVelocityFraud, isPatternFraud,
            isHistoricalDuplicate, isUnusualFrequency, isSimilarToRecent);

    System.out.println("Fraud Alert Level: " + alertLevel);

    return isDuplicate || isAbnormal || isSuspicious || isVelocityFraud || isPatternFraud ||
            isHistoricalDuplicate || isUnusualFrequency || isSimilarToRecent;
}
```
- **Purpose**: Detects fraudulent cheque activities using various checks, including duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, and pattern fraud.
- **Key Components**:
  - `FraudDetection`: A service for performing fraud detection.
  - `ChequeHistoryManager`: Manages historical cheque data for additional checks.
  - `AlertLevel`: Enum representing the severity of fraud alerts.

## External Dependencies
- **`FALLBACK_RATES`**: A predefined map of fallback exchange rates.
- **`exchangeRateCache`**: A cache for storing exchange rates with timestamps.
- **`CurrencyRate`**: A class representing an exchange rate and its last updated timestamp.
- **`CACHE_EXPIRY_MINUTES`**: The duration for which cached rates are valid.
- **`FraudDetection`**: A service for detecting fraudulent activities.
- **`ChequeHistoryManager`**: Manages historical cheque data.
- **`ChequeTransaction`**: Represents a cheque transaction, used in fraud detection.