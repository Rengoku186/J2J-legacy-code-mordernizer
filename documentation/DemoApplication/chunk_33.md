---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_33"
confidence_score: 0.95
external_dependencies: ["FALLBACK_RATES", "exchangeRateCache", "getExchangeRate", "ChequeHistoryManager", "FraudDetection", "ChequeTransaction", "logFraudChecks", "determineAlertLevel"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger application that handles currency exchange and fraud detection. It includes methods for currency conversion, fetching exchange rates, managing supported currencies, and detecting fraudulent cheque activities. Additionally, it defines helper classes and services to support these functionalities.

## Key Components

### 1. **Fallback Rates Handling**
The code uses a predefined map `FALLBACK_RATES` to provide exchange rates when API fetches fail. If a fallback rate is available for a given currency code, it is cached and returned. If no rate is available, a default value of `0.0` is returned.

#### Code Snippet:
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

### 2. **Currency Conversion**
The `convertCurrency` method converts an amount from one currency to another using exchange rates. It first fetches the exchange rates for the source and target currencies, validates them, and performs the conversion.

#### Method Signature:
```java
public double convertCurrency(double amount, String fromCurrency, String toCurrency)
```

#### Key Steps:
- Fetch exchange rates for `fromCurrency` and `toCurrency` using `getExchangeRate`.
- Validate the rates to ensure they are greater than zero.
- Convert the amount to the base currency and then to the target currency.
- Log the conversion details.

### 3. **Detailed Exchange Rate Information**
The `getDetailedExchangeRates` method provides detailed information about a currency's exchange rate, including buy/sell rates and fees.

#### Method Signature:
```java
public Map<String, Double> getDetailedExchangeRates(String currency)
```

#### Key Steps:
- Fetch the base exchange rate using `getExchangeRate`.
- Calculate buy and sell rates as slight variations of the base rate.
- Calculate a fee as 0.5% of the base rate.
- Return the detailed rates in a map.

### 4. **Supported Currencies**
The `getSupportedCurrencies` method returns a sorted list of all supported currency codes, including the base currency and those in `FALLBACK_RATES`.

#### Method Signature:
```java
public List<String> getSupportedCurrencies()
```

### 5. **Cache Validation**
The `isCacheValid` method checks if a cached exchange rate is still valid based on a predefined expiry time.

#### Method Signature:
```java
private boolean isCacheValid(String currency)
```

#### Key Steps:
- Check if the currency exists in the cache.
- Compare the current time with the cached rate's expiry time.

### 6. **API Rate Fetching**
The `fetchRateFromAPI` method fetches exchange rates from an external API. It uses the Open Exchange Rates API as an example and parses the JSON response to extract the required rate.

#### Method Signature:
```java
private double fetchRateFromAPI(String currency) throws Exception
```

#### Key Steps:
- Construct the API URL using the base currency and API key.
- Make an HTTP GET request and handle the response.
- Parse the JSON response to extract the exchange rate for the specified currency.
- Handle errors and log messages.

### 7. **Fraud Detection Service**
The `FraudDetectionService` class implements various fraud detection mechanisms, such as duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, and pattern fraud. It also integrates with the `ChequeHistoryManager` for historical analysis.

#### Key Features:
- **Fraud Detection Checks:**
  - Duplicate cheques
  - Abnormal amounts
  - Suspicious activity
  - Velocity fraud
  - Pattern fraud
  - Historical duplicates
  - Unusual frequency
  - Similar recent transactions

- **Fraud Alert Levels:**
  - LOW, MEDIUM, HIGH, CRITICAL

#### Method Highlights:
- `isFraudulentCheque`: Combines multiple fraud detection checks and determines the fraud alert level.
- `logFraudChecks`: Logs the results of fraud detection checks.
- `determineAlertLevel`: Determines the fraud alert level based on the results of individual checks.

### 8. **CurrencyRate Class**
The `CurrencyRate` class stores exchange rate information along with a timestamp for when the rate was last updated.

#### Key Methods:
- `getRate`: Returns the exchange rate.
- `getLastUpdated`: Returns the timestamp of the last update.

### 9. **ChequeHistoryManager Class**
The `ChequeHistoryManager` class manages historical cheque data and provides methods to record and display cheque history.

#### Key Methods:
- `recordCheque`: Records a cheque transaction.
- `displayChequeHistory`: Displays the history of cheques for a specific account.

## External Dependencies
- `FALLBACK_RATES`: A predefined map of fallback exchange rates.
- `exchangeRateCache`: A cache for storing exchange rates.
- `getExchangeRate`: A method to fetch exchange rates.
- `ChequeHistoryManager`: A class for managing cheque history.
- `FraudDetection`: A class for performing fraud detection checks.
- `ChequeTransaction`: A class representing cheque transactions.
- `logFraudChecks`: A method for logging fraud detection results.
- `determineAlertLevel`: A method for determining fraud alert levels.

## Notes
- The code relies on an external API for fetching exchange rates. The API key is hardcoded as "demo" and should be replaced with a valid key in a production environment.
- The fraud detection logic is comprehensive and includes multiple checks to ensure the security of financial transactions.
- The `CurrencyRate` and `ChequeHistoryManager` classes are utility classes that support the main functionalities of the application.