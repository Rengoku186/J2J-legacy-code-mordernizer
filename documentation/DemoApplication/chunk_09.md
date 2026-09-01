---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_09"
confidence_score: 0.95
external_dependencies: ["java.util.Collections", "java.util.Map", "java.util.HashMap", "java.util.List", "java.util.ArrayList", "java.net.HttpURLConnection", "java.net.URL", "java.io.BufferedReader", "java.io.InputStreamReader", "java.time.LocalDateTime", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for Code Chunk

## Overview
This code chunk contains multiple classes and methods related to currency exchange services, fraud detection, and caching mechanisms. It includes functionalities for fetching exchange rates, managing caches, and detecting fraudulent cheque activities. Below is a detailed explanation of the key components and their purposes.

---

## Classes and Methods

### 1. **CurrencyExchangeServiceV2**
This class provides an enhanced version of a currency exchange service. It supports multiple currencies, detailed exchange rate calculations, and dynamic fetching of rates from external APIs. However, it is noted as an inefficient and non-best-practice implementation.

#### Key Fields:
- `cache`: A `Map<String, Double>` used to store cached exchange rates.
- `BASE`: A `String` representing the base currency (default is "USD").
- `KEY`: A `String` representing the API key (default is "demo").
- `RATES`: A static `Map<String, Double>` containing fallback exchange rates for specific currencies.

#### Key Methods:
- **`getExchangeRateV2(String currency)`**: Fetches the exchange rate for a given currency. It first checks the cache, then attempts to fetch the rate from an external API, and finally falls back to predefined rates if necessary.
- **`convertCurrencyV2(double amount, String from, String to)`**: Converts an amount from one currency to another using their exchange rates.
- **`getDetailedExchangeRatesV2(String currency)`**: Provides detailed exchange rate information, including mid, buy, sell, and fee rates.
- **`getSupportedCurrenciesV2()`**: Returns a list of supported currencies.
- **`fetchRateFromAPIV2(String currency)`**: Fetches the exchange rate for a currency from an external API. This method includes basic error handling and inefficient JSON parsing.
- **`clearCacheV2()`**: Clears the exchange rate cache.
- **`isCacheValid(String currency)`**: Checks if the cached rate for a given currency is still valid. It verifies if the currency exists in the cache and if the cached rate has not expired. The expiration is determined by comparing the current time with the last updated time of the cached rate plus a predefined expiry duration (`CACHE_EXPIRY_MINUTES`).

---

### 2. **CurrencyRate**
This class is used to store currency rate information along with a timestamp indicating when the rate was last updated.

#### Fields:
- `rate`: A `double` representing the exchange rate.
- `lastUpdated`: A `java.time.LocalDateTime` object representing the timestamp of the last update.

#### Methods:
- **`CurrencyRate(double rate, java.time.LocalDateTime lastUpdated)`**: Constructor to initialize the rate and timestamp.
- **`getRate()`**: Returns the exchange rate.
- **`getLastUpdated()`**: Returns the timestamp of the last update.

---

### 3. **FraudDetectionService**
This class implements various fraud detection mechanisms for cheque transactions. It uses a `FraudDetection` object and a `ChequeHistoryManager` to analyze transactions.

#### Key Fields:
- `fraudDetection`: An instance of the `FraudDetection` class used for fraud detection logic.
- `historyManager`: An instance of the `ChequeHistoryManager` class for managing cheque history.
- `recentTransactions`: A `Map<String, List<ChequeTransaction>>` storing recent transactions for accounts.
- Fraud detection thresholds:
  - `VELOCITY_CHECK_DAYS`: Number of days for velocity checks.
  - `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period.
  - `PATTERN_THRESHOLD`: Similarity threshold for pattern-based fraud detection.
  - `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for detecting similar transaction amounts.
  - `UNUSUAL_FREQUENCY_THRESHOLD`: Threshold for detecting unusual transaction frequency.

#### Key Methods:
- **`isFraudulentCheque(String accountId, String chequeNumber, double amount)`**: Determines if a cheque is fraudulent based on various checks, including duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, and pattern fraud. It also considers historical duplicates, unusual frequency, and similarity to recent transactions if a `ChequeHistoryManager` is set.
- **`setHistoryManager(ChequeHistoryManager historyManager)`**: Sets the `ChequeHistoryManager` instance.
- **`checkDuplicateCheque(String accountId, String chequeNumber)`**: Checks if a cheque is a duplicate using the `FraudDetection` instance.
- **`checkAbnormalAmount(double amount)`**: Checks if the cheque amount is abnormal using the `FraudDetection` instance.

---

## External Dependencies
The following external classes and libraries are used in this code:
- `java.util.Collections`: Used for sorting collections.
- `java.util.Map`, `java.util.HashMap`, `java.util.List`, `java.util.ArrayList`: Used for data structures.
- `java.net.HttpURLConnection`, `java.net.URL`: Used for making HTTP requests to external APIs.
- `java.io.BufferedReader`, `java.io.InputStreamReader`: Used for reading API responses.
- `java.time.LocalDateTime`: Used for handling timestamps.
- `FraudDetection`: A custom class for fraud detection logic.
- `ChequeHistoryManager`: A custom class for managing cheque history.
- `ChequeTransaction`: A custom class representing cheque transactions.

---

## Notes
- The `fetchRateFromAPI` and `fetchRateFromAPIV2` methods use hardcoded API URLs and keys, which is not a best practice for production systems.
- The JSON parsing in `fetchRateFromAPIV2` is inefficient and should be replaced with a proper JSON parsing library.
- The `CurrencyExchangeServiceV2` class is described as an inefficient implementation and may require optimization for production use.
- The `FraudDetectionService` class relies on external classes (`FraudDetection`, `ChequeHistoryManager`, and `ChequeTransaction`) for its functionality, which are not defined in this code chunk.