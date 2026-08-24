---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_22"
confidence_score: 0.95
external_dependencies: ["java.time.LocalDateTime", "java.net.HttpURLConnection", "org.json.simple.parser.JSONParser", "org.json.simple.JSONObject", "java.util.Collections", "java.util.HashMap", "java.util.ArrayList", "java.util.List", "java.util.Map", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

## Overview
This chunk of code is part of a legacy Java application that provides functionalities for currency exchange rate calculations, caching, and fraud detection. The code includes methods for calculating detailed exchange rates, fetching supported currencies, validating cached rates, fetching exchange rates from an external API, and clearing the cache. Additionally, it contains a secondary implementation of a currency exchange service (`CurrencyExchangeServiceV2`), a `CurrencyRate` class for storing exchange rate data, and a `FraudDetectionService` class for detecting fraudulent cheque activities.

### Code Breakdown

#### 1. **Detailed Exchange Rate Calculation**
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
- **Purpose**: This block calculates detailed exchange rates based on a given base rate.
  - If the `baseRate` is less than or equal to 0, it returns an empty map.
  - Otherwise, it calculates the mid, buy, sell, and fee rates and stores them in a map.
  - The `buyRate` is 1% lower than the `baseRate`, the `sellRate` is 1% higher, and the `fee` is 0.5% of the `baseRate`.

#### 2. **Fetching Supported Currencies**
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
- **Purpose**: This method returns a list of all supported currency codes.
  - It includes the base currency (`BASE_CURRENCY`) and all keys from the `FALLBACK_RATES` map.
  - The list is sorted alphabetically before being returned.

#### 3. **Cache Validation**
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
- **Purpose**: This method checks if the cached exchange rate for a given currency is still valid.
  - It verifies if the currency exists in the `exchangeRateCache`.
  - If the cache exists, it checks whether the cached rate has expired by comparing the current time with the expiry time (`CACHE_EXPIRY_MINUTES` after the last update).

#### 4. **Fetching Exchange Rate from External API**
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
- **Purpose**: This method fetches the exchange rate for a given currency from an external API.
  - It constructs the API URL using the `BASE_CURRENCY` and `API_KEY`.
  - The method handles HTTP requests, reads the response, and parses the JSON to extract the exchange rate for the specified currency.
  - If the currency is not found or an error occurs, an exception is thrown.

#### 5. **Clearing the Cache**
```java
public void clearCache() {
    exchangeRateCache.clear();
    System.out.println("Exchange rate cache cleared");
}
```
- **Purpose**: This method clears the `exchangeRateCache` and logs a message indicating that the cache has been cleared.

### Additional Classes and Services

#### `CurrencyExchangeServiceV2`
- A simplified and less efficient version of the primary currency exchange service.
- Provides similar functionalities, such as fetching exchange rates, converting currencies, and clearing the cache.
- Uses hardcoded fallback rates and a basic JSON parsing mechanism.

#### `CurrencyRate`
- A class for storing exchange rate information along with a timestamp of the last update.
- **Fields**:
  - `rate`: The exchange rate value.
  - `lastUpdated`: The timestamp of the last update.
- **Methods**:
  - `getRate()`: Returns the exchange rate.
  - `getLastUpdated()`: Returns the timestamp of the last update.

#### `FraudDetectionService`
- A service for detecting fraudulent cheque activities.
- Implements various fraud detection mechanisms, such as velocity checks, pattern matching, and unusual frequency detection.
- **Fields**:
  - `fraudDetection`: An instance of the `FraudDetection` class.
  - `historyManager`: An instance of the `ChequeHistoryManager` class.
  - `recentTransactions`: A map of recent cheque transactions.
- **Fraud Detection Parameters**:
  - `VELOCITY_CHECK_DAYS`: Number of days for velocity checks.
  - `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period.
  - `PATTERN_THRESHOLD`: Similarity threshold for pattern matching.
  - `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for transaction amounts.
  - `UNUSUAL_FREQUENCY_THRESHOLD`: Threshold for unusual transaction frequency.
- **Fraud Alert Levels**:
  - `LOW`, `MEDIUM`, `HIGH`, `CRITICAL`.

### External Dependencies
- `java.time.LocalDateTime`: Used for handling timestamps.
- `java.net.HttpURLConnection`: Used for making HTTP requests to the external API.
- `org.json.simple.parser.JSONParser` and `org.json.simple.JSONObject`: Used for parsing JSON responses from the API.
- `java.util` classes: Used for data structures like `Map`, `List`, and utility methods like `Collections.sort`.
- `FraudDetection`, `ChequeHistoryManager`, and `ChequeTransaction`: Classes used in the fraud detection service.