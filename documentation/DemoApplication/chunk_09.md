---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_09"
confidence_score: 0.95
external_dependencies: ["java.util.Collections", "java.util.Map", "java.util.HashMap", "java.util.List", "java.util.ArrayList", "java.net.URL", "java.net.HttpURLConnection", "java.io.BufferedReader", "java.io.InputStreamReader", "java.time.LocalDateTime", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for `DemoApplication.java` (Chunk 09)

This chunk of code contains several classes and methods that implement functionalities related to currency exchange and fraud detection. Below is a detailed explanation of the classes and their methods:

## 1. **Currency Exchange Service (Legacy Implementation)**

### `isCacheValid(String currency)`
- **Purpose**: Checks if the cached exchange rate for a given currency is still valid.
- **Parameters**:
  - `currency` (String): The currency code to check.
- **Returns**: `true` if the cache is valid, `false` otherwise.
- **Logic**:
  - Verifies if the `exchangeRateCache` contains the currency.
  - Compares the current time with the cache expiry time (calculated as the last updated time plus a predefined expiry duration).

### `fetchRateFromAPI(String currency)`
- **Purpose**: Fetches the exchange rate for a given currency from an external API.
- **Parameters**:
  - `currency` (String): The currency code to fetch the rate for.
- **Returns**: The exchange rate as a `double`.
- **Throws**: Exception if there is an error during the API call.
- **Logic**:
  - Constructs the API URL using the base currency and API key.
  - Makes an HTTP GET request to the API.
  - Parses the response to extract the exchange rate (mocked in this implementation).

### `clearCache()`
- **Purpose**: Clears the exchange rate cache.
- **Logic**:
  - Clears the `exchangeRateCache` map.
  - Logs a message indicating the cache has been cleared.

## 2. **Currency Exchange Service V2 (Enhanced Implementation)**

### `getExchangeRateV2(String currency)`
- **Purpose**: Retrieves the exchange rate for a given currency.
- **Parameters**:
  - `currency` (String): The currency code.
- **Returns**: The exchange rate as a `double`.
- **Logic**:
  - Checks if the currency is the base currency or if it exists in the cache.
  - Attempts to fetch the rate from an external API.
  - Falls back to predefined rates if the API call fails.

### `convertCurrencyV2(double amount, String from, String to)`
- **Purpose**: Converts an amount from one currency to another.
- **Parameters**:
  - `amount` (double): The amount to convert.
  - `from` (String): The source currency code.
  - `to` (String): The target currency code.
- **Returns**: The converted amount as a `double`.
- **Logic**:
  - Retrieves the exchange rates for the source and target currencies.
  - Calculates the converted amount using the formula `(amount * rate_from) / rate_to`.

### `getDetailedExchangeRatesV2(String currency)`
- **Purpose**: Provides detailed exchange rate information for a given currency.
- **Parameters**:
  - `currency` (String): The currency code.
- **Returns**: A map containing detailed exchange rate information, including mid, buy, sell, and fee rates.
- **Logic**:
  - Retrieves the exchange rate for the currency.
  - Calculates and returns a map with the mid, buy, sell, and fee rates.

### `getSupportedCurrenciesV2()`
- **Purpose**: Retrieves a list of supported currencies.
- **Returns**: A list of supported currency codes.
- **Logic**:
  - Returns a list containing the base currency and all keys from the predefined rates map.

### `fetchRateFromAPIV2(String currency)`
- **Purpose**: Fetches the exchange rate for a given currency from an external API.
- **Parameters**:
  - `currency` (String): The currency code to fetch the rate for.
- **Returns**: The exchange rate as a `double`.
- **Throws**: Exception if there is an error during the API call.
- **Logic**:
  - Constructs the API URL using the base currency and API key.
  - Makes an HTTP GET request to the API.
  - Parses the response to extract the exchange rate (inefficiently).

### `clearCacheV2()`
- **Purpose**: Clears the exchange rate cache.
- **Logic**:
  - Clears the `cache` map.

## 3. **CurrencyRate Class**
- **Purpose**: Represents currency rate information with a timestamp.
- **Fields**:
  - `rate` (double): The exchange rate.
  - `lastUpdated` (LocalDateTime): The timestamp of the last update.
- **Methods**:
  - `getRate()`: Returns the exchange rate.
  - `getLastUpdated()`: Returns the last updated timestamp.

## 4. **FraudDetectionService Class**
- **Purpose**: Implements fraud detection mechanisms for cheque transactions.
- **Fields**:
  - `fraudDetection` (FraudDetection): The fraud detection engine.
  - `historyManager` (ChequeHistoryManager): Manages cheque transaction history.
  - `recentTransactions` (Map<String, List<ChequeTransaction>>): Stores recent transactions.
  - Fraud detection thresholds and alert levels.
- **Methods**:
  - `setHistoryManager(ChequeHistoryManager historyManager)`: Sets the history manager.
  - `isFraudulentCheque(String accountId, String chequeNumber, double amount)`: Determines if a cheque is fraudulent based on various checks.
  - `checkDuplicateCheque(String accountId, String chequeNumber)`: Checks for duplicate cheques.
  - `checkAbnormalAmount(double amount)`: Checks if the amount is abnormal.

### Fraud Detection Thresholds
- **Velocity Check Days**: 7 days.
- **Velocity Threshold**: 5 transactions.
- **Pattern Threshold**: 95% similarity.
- **Similar Amount Threshold**: 90% similarity.
- **Unusual Frequency Threshold**: 3x normal frequency.

### Fraud Alert Levels
- **LOW, MEDIUM, HIGH, CRITICAL**: Different levels of fraud alerts based on the severity of detected issues.