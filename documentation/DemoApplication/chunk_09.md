---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_09"
confidence_score: 0.95
external_dependencies: ["java.util.Collections", "java.util.HashMap", "java.util.Map", "java.util.List", "java.util.ArrayList", "java.net.HttpURLConnection", "java.net.URL", "java.io.BufferedReader", "java.io.InputStreamReader", "java.time.LocalDateTime", "java.util.Date", "FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

## Overview
This code chunk contains multiple classes and methods related to currency exchange services and fraud detection. The main components include:

1. **CurrencyExchangeService**: A service for managing currency exchange rates, including caching, fetching rates from an external API, and clearing the cache.
2. **CurrencyExchangeServiceV2**: An enhanced version of the currency exchange service with additional features and a fallback mechanism for exchange rates.
3. **CurrencyRate**: A data class to store currency rate information along with a timestamp.
4. **FraudDetectionService**: A service for detecting fraudulent cheque activities using various fraud detection mechanisms.

## Detailed Explanation

### CurrencyExchangeService
This class provides functionality for managing currency exchange rates. It includes the following key components:

- **exchangeRateCache**: A `Map<String, CurrencyRate>` that stores cached exchange rates for different currencies.
- **BASE_CURRENCY**: A constant representing the base currency ("USD").
- **CACHE_EXPIRY_MINUTES**: A constant defining the cache expiry time (60 minutes).
- **API_KEY**: A placeholder for the API key used to fetch exchange rates from an external API.

#### Methods

1. **isCacheValid(String currency)**
   - Checks if the cached exchange rate for a given currency is still valid.
   - Compares the current time with the cache's expiry time.
   - Returns `true` if the cache is valid, otherwise `false`.

2. **fetchRateFromAPI(String currency)**
   - Fetches the exchange rate for a given currency from an external API (e.g., Open Exchange Rates API).
   - Uses `java.net.HttpURLConnection` to make an HTTP GET request.
   - Parses the API response to extract the exchange rate (mocked in this code).
   - Throws an exception if the API call fails or returns an error status code.

3. **clearCache()**
   - Clears the `exchangeRateCache`.
   - Logs a message indicating that the cache has been cleared.

### CurrencyExchangeServiceV2
This is an enhanced version of the `CurrencyExchangeService` with additional features and a fallback mechanism for exchange rates.

#### Key Components
- **cache**: A `Map<String, Double>` that stores cached exchange rates.
- **BASE**: A constant representing the base currency ("USD").
- **KEY**: A placeholder for the API key used to fetch exchange rates from an external API.
- **RATES**: A static map containing fallback exchange rates for various currencies.

#### Methods

1. **getExchangeRateV2(String currency)**
   - Retrieves the exchange rate for a given currency.
   - Checks the cache first, then attempts to fetch the rate from an external API.
   - Falls back to predefined rates if the API call fails.

2. **convertCurrencyV2(double amount, String from, String to)**
   - Converts an amount from one currency to another using exchange rates.
   - Returns `0.0` if the exchange rate for either currency is unavailable.

3. **getDetailedExchangeRatesV2(String currency)**
   - Provides detailed exchange rate information for a given currency, including mid, buy, sell, and fee rates.

4. **getSupportedCurrenciesV2()**
   - Returns a list of supported currencies, including the base currency and those in the fallback rates.

5. **fetchRateFromAPIV2(String currency)**
   - Fetches the exchange rate for a given currency from an external API.
   - Parses the API response to extract the exchange rate (inefficiently).

6. **clearCacheV2()**
   - Clears the `cache`.

### CurrencyRate
A simple data class to store currency rate information along with a timestamp.

#### Fields
- **rate**: The exchange rate.
- **lastUpdated**: The timestamp of the last update.

#### Constructor
- **CurrencyRate(double rate, java.time.LocalDateTime lastUpdated)**: Initializes the `rate` and `lastUpdated` fields.

#### Methods
- **getRate()**: Returns the exchange rate.
- **getLastUpdated()**: Returns the timestamp of the last update.

### FraudDetectionService
This class implements various mechanisms to detect fraudulent cheque activities. It uses a `FraudDetection` instance and a `ChequeHistoryManager` for historical data.

#### Key Components
- **fraudDetection**: An instance of the `FraudDetection` class.
- **historyManager**: An instance of the `ChequeHistoryManager` class.
- **recentTransactions**: A `Map<String, List<ChequeTransaction>>` to store recent transactions.
- **Fraud detection thresholds**:
  - `VELOCITY_CHECK_DAYS`: Number of days for velocity checks (7 days).
  - `VELOCITY_THRESHOLD`: Maximum allowed transactions in the velocity check period (5 transactions).
  - `PATTERN_THRESHOLD`: Similarity threshold for pattern-based fraud detection (95%).
  - `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for amount-based fraud detection (90%).
  - `UNUSUAL_FREQUENCY_THRESHOLD`: Threshold for unusual frequency detection (3x normal frequency).

#### Methods

1. **isFraudulentCheque(String accountId, String chequeNumber, double amount)**
   - Checks if a cheque is fraudulent based on various criteria, including duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions.
   - Logs the results of the fraud checks and determines the fraud alert level.
   - Returns `true` if any of the checks indicate fraud, otherwise `false`.

2. **checkDuplicateCheque(String accountId, String chequeNumber)**
   - Checks if the cheque is a duplicate using the `FraudDetection` instance.

3. **checkAbnormalAmount(double amount)**
   - Checks if the cheque amount is abnormal using the `FraudDetection` instance.

### External Dependencies
- **java.util.Collections**: Used for sorting collections.
- **java.util.HashMap**: Used for storing key-value pairs.
- **java.util.Map**: Interface for key-value mappings.
- **java.util.List**: Interface for ordered collections.
- **java.util.ArrayList**: Implementation of the `List` interface.
- **java.net.HttpURLConnection**: Used for making HTTP requests.
- **java.net.URL**: Represents a URL.
- **java.io.BufferedReader**: Used for reading text from an input stream.
- **java.io.InputStreamReader**: Converts byte streams to character streams.
- **java.time.LocalDateTime**: Represents date-time without a time-zone.
- **java.util.Date**: Represents a specific instant in time.
- **FraudDetection**: A class used for fraud detection (implementation not provided in this chunk).
- **ChequeHistoryManager**: A class for managing cheque history records.