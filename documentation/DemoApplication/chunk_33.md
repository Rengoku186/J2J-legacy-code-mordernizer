---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_33"
confidence_score: 0.95
external_dependencies: ["org.json.simple.parser.JSONParser", "org.json.simple.JSONObject", "ChequeHistoryManager", "FraudDetection", "ChequeTransaction"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger application that provides currency exchange services and fraud detection for cheque transactions. It includes methods for handling fallback exchange rates, currency conversion, detailed exchange rate calculations, and fraud detection mechanisms. Additionally, it defines helper classes and services such as `CurrencyRate` and `FraudDetectionService`.

## Key Components and Methods

### 1. **Fallback Exchange Rates**
The code uses a predefined map `FALLBACK_RATES` to store exchange rates for various currencies in case the external API fetch fails. If a fallback rate is available for a given currency, it is cached and returned.

#### Example:
```java
Double fallbackRate = FALLBACK_RATES.get(currencyCode);
if (fallbackRate != null) {
    System.out.println("Using fallback rate for " + currencyCode + ": " + fallbackRate);
    exchangeRateCache.put(currencyCode, new CurrencyRate(fallbackRate, java.time.LocalDateTime.now()));
    return fallbackRate;
}
```

### 2. **Currency Conversion**
The `convertCurrency` method converts an amount from one currency to another using exchange rates. It first retrieves the exchange rates for the source and target currencies, validates them, and performs the conversion.

#### Method Signature:
```java
public double convertCurrency(double amount, String fromCurrency, String toCurrency)
```

#### Key Steps:
- Fetch exchange rates for both currencies.
- Convert the amount to the base currency and then to the target currency.
- Log the conversion details.

### 3. **Detailed Exchange Rate Information**
The `getDetailedExchangeRates` method provides additional details about exchange rates, including buy/sell rates and fees.

#### Method Signature:
```java
public Map<String, Double> getDetailedExchangeRates(String currency)
```

#### Key Steps:
- Calculate buy and sell rates as slight variations of the base rate.
- Calculate a fee as a percentage of the base rate.
- Return a map containing the detailed rate information.

### 4. **Supported Currencies**
The `getSupportedCurrencies` method returns a sorted list of all supported currency codes, including the base currency and those in the fallback rates.

#### Method Signature:
```java
public List<String> getSupportedCurrencies()
```

### 5. **Cache Validation**
The `isCacheValid` method checks if a cached exchange rate is still valid based on a predefined expiry time (`CACHE_EXPIRY_MINUTES`).

#### Method Signature:
```java
private boolean isCacheValid(String currency)
```

### 6. **Fetch Rate from API**
The `fetchRateFromAPI` method retrieves exchange rates from an external API (e.g., Open Exchange Rates API). It handles HTTP requests, parses JSON responses, and extracts the required exchange rate.

#### Method Signature:
```java
private double fetchRateFromAPI(String currency) throws Exception
```

#### Key Steps:
- Construct the API URL using the base currency and API key.
- Make an HTTP GET request and handle the response.
- Parse the JSON response to extract the exchange rate for the specified currency.
- Handle errors and log messages.

### 7. **Clear Cache**
The `clearCache` method clears all cached exchange rates.

#### Method Signature:
```java
public void clearCache()
```

### 8. **CurrencyRate Class**
This helper class stores exchange rate information along with a timestamp indicating when the rate was last updated.

#### Key Fields:
- `rate`: The exchange rate value.
- `lastUpdated`: The timestamp of the last update.

#### Key Methods:
- `getRate()`: Returns the exchange rate.
- `getLastUpdated()`: Returns the timestamp of the last update.

### 9. **FraudDetectionService Class**
This class implements various fraud detection mechanisms for cheque transactions. It uses a `ChequeHistoryManager` to track historical cheque data and detect anomalies.

#### Key Features:
- **Fraud Detection Checks**: Includes checks for duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions.
- **Fraud Alert Levels**: Determines the severity of fraud using predefined thresholds.

#### Method Signature:
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount)
```

#### Key Steps:
- Perform various fraud detection checks.
- Log the results of the checks.
- Determine the overall fraud alert level.
- Return whether the cheque is fraudulent.

### 10. **ChequeHistoryManager Class**
This mock implementation manages the history of cheque transactions for fraud detection purposes.

#### Key Features:
- Records cheque transactions.
- Displays the history of cheques for a specific account.

#### Example:
```java
public void recordCheque(String acc, String chq, String curr, double amt, Date d) {
    history.computeIfAbsent(acc, k -> new ArrayList<>()).add(new ChequeRecord(acc, chq, curr, amt, d));
}
```

## External Dependencies
- **`org.json.simple.parser.JSONParser`**: Used for parsing JSON responses from the external API.
- **`org.json.simple.JSONObject`**: Represents JSON objects in the parsed response.
- **`ChequeHistoryManager`**: Manages historical cheque data.
- **`FraudDetection`**: Implements fraud detection logic.
- **`ChequeTransaction`**: Represents cheque transaction data.

## Notes
- The `API_KEY` used in the `fetchRateFromAPI` method is a placeholder and should be replaced with a valid key in production.
- The `CACHE_EXPIRY_MINUTES` constant determines how long cached exchange rates remain valid.
- The fraud detection logic relies on multiple thresholds and historical data to identify suspicious activities.