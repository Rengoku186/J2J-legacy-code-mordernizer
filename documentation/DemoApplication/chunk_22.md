---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_22"
confidence_score: 0.95
external_dependencies: ["CurrencyRate", "ChequeHistoryManager", "FraudDetection", "ChequeTransaction"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a legacy Java application that provides functionalities for currency exchange rate calculations, caching, and fraud detection. It includes methods for calculating detailed exchange rates, fetching rates from an external API, managing supported currencies, and detecting fraudulent activities related to cheques.

## Code Breakdown

### 1. **Detailed Exchange Rate Calculation**
```java
if (baseRate <= 0) {
    return Collections.emptyMap();
}

Map<String, Double> detailedRates = new HashMap<>();
detailedRates.put("mid", baseRate);

// Calculate buy rate (slightly lower than mid rate)
double buyRate = baseRate * 0.99;
detailedRates.put("buy", buyRate);

// Calculate sell rate (slightly higher than mid rate)
double sellRate = baseRate * 1.01;
detailedRates.put("sell", sellRate);

// Calculate fees
double fee = baseRate * 0.005; // 0.5% fee
detailedRates.put("fee", fee);

return detailedRates;
```
This block calculates detailed exchange rates based on a given base rate. It computes the mid, buy, sell, and fee rates and stores them in a `HashMap` with descriptive keys. If the base rate is less than or equal to zero, an empty map is returned.

- **`mid`**: The base rate.
- **`buy`**: 1% lower than the base rate.
- **`sell`**: 1% higher than the base rate.
- **`fee`**: 0.5% of the base rate.

### 2. **Supported Currencies Retrieval**
```java
public List<String> getSupportedCurrencies() {
    List<String> currencies = new ArrayList<>();
    currencies.add(BASE_CURRENCY);
    currencies.addAll(FALLBACK_RATES.keySet());

    // Sort alphabetically
    Collections.sort(currencies);
    return currencies;
}
```
This method returns a list of all supported currency codes. It includes the base currency (`BASE_CURRENCY`) and all keys from the `FALLBACK_RATES` map. The list is sorted alphabetically before being returned.

### 3. **Cache Validation**
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
This private method checks if the cached exchange rate for a given currency is still valid. It compares the current time with the cache expiry time, which is calculated by adding `CACHE_EXPIRY_MINUTES` to the last updated timestamp of the cached rate.

### 4. **Fetching Exchange Rate from External API**
```java
private double fetchRateFromAPI(String currency) throws Exception {
    String apiUrl = "https://open.er-api.com/v6/latest/" + BASE_CURRENCY + "?apikey=" + API_KEY;

    try {
        java.net.URL url = new java.net.URL(apiUrl);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new Exception("API returned status code: " + status);
        }

        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parse JSON response
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(response.toString());
        org.json.simple.JSONObject rates = (org.json.simple.JSONObject) jsonObject.get("rates");

        if (rates != null && rates.containsKey(currency)) {
            double rate = ((Number) rates.get(currency)).doubleValue();
            System.out.println("Fetched rate from API for " + currency + ": " + rate);
            return rate;
        } else {
            throw new Exception("Currency not found in API response");
        }
    } catch (Exception e) {
        System.out.println("API fetch failed: " + e.getMessage());
        throw e;
    }
}
```
This method fetches the exchange rate for a given currency from an external API. It constructs the API URL using the `BASE_CURRENCY` and `API_KEY`. If the API response is successful, it parses the JSON response to extract the exchange rate for the specified currency. If the currency is not found or an error occurs, an exception is thrown.

### 5. **Clearing the Cache**
```java
public void clearCache() {
    exchangeRateCache.clear();
    System.out.println("Exchange rate cache cleared");
}
```
This method clears the `exchangeRateCache` and logs a message indicating that the cache has been cleared.

### 6. **CurrencyExchangeServiceV2 Class**
This class is an enhanced version of the currency exchange service. It includes methods for fetching exchange rates, converting currencies, and retrieving detailed exchange rates. It also uses a fallback mechanism for exchange rates when the API is unavailable.

#### Key Features:
- **`getExchangeRateV2`**: Fetches the exchange rate for a given currency, using a cache or fallback rates if the API is unavailable.
- **`convertCurrencyV2`**: Converts an amount from one currency to another using the exchange rates.
- **`getDetailedExchangeRatesV2`**: Retrieves detailed exchange rates (mid, buy, sell, fee) for a given currency.
- **`getSupportedCurrenciesV2`**: Returns a list of supported currencies.
- **`fetchRateFromAPIV2`**: Fetches the exchange rate for a currency from an external API.
- **`clearCacheV2`**: Clears the cache of exchange rates.

### 7. **CurrencyRate Class**
This class is used to store currency rate information along with a timestamp indicating when the rate was last updated.

#### Fields:
- **`rate`**: The exchange rate.
- **`lastUpdated`**: The timestamp of the last update.

#### Methods:
- **`getRate`**: Returns the exchange rate.
- **`getLastUpdated`**: Returns the last updated timestamp.

### 8. **FraudDetectionService Class**
This class implements fraud detection mechanisms for cheque transactions. It uses a `ChequeHistoryManager` to manage cheque history and detect fraudulent activities based on various thresholds.

#### Key Features:
- **Fraud Detection Thresholds**:
  - Velocity Check: Monitors the number of transactions within a specific period.
  - Pattern Similarity: Detects patterns with a similarity threshold.
  - Unusual Frequency: Flags transactions with unusually high frequency.
- **Alert Levels**: Defines different levels of fraud alerts (LOW, MEDIUM, HIGH, CRITICAL).

#### Dependencies:
- **`FraudDetection`**: A class or module for detecting fraud.
- **`ChequeHistoryManager`**: Manages the history of cheque transactions.
- **`ChequeTransaction`**: Represents individual cheque transactions.

## External Dependencies
- **`CurrencyRate`**: Used for caching exchange rates with timestamps.
- **`ChequeHistoryManager`**: Manages cheque transaction history.
- **`FraudDetection`**: Provides fraud detection capabilities.
- **`ChequeTransaction`**: Represents cheque transactions for fraud detection.

## Notes
- The code contains hardcoded API keys and fallback rates, which should be replaced with secure and dynamic configurations in a production environment.
- The JSON parsing in `fetchRateFromAPIV2` is inefficient and should be replaced with a robust library or method for better performance and maintainability.