---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_22"
confidence_score: 0.95
external_dependencies: ["CurrencyRate", "java.time.LocalDateTime", "org.json.simple.parser.JSONParser", "org.json.simple.JSONObject", "ChequeHistoryManager", "FraudDetection", "ChequeTransaction"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a legacy Java application that implements various functionalities related to currency exchange, fraud detection, and cheque history management. Below is a detailed explanation of the key components and methods in this chunk.

---

### 1. **Currency Exchange Service**
This section of the code provides methods for handling currency exchange rates, including fetching rates from an external API, calculating detailed rates, and managing a cache of exchange rates.

#### Key Methods:

- **`getSupportedCurrencies()`**
  - **Purpose**: Returns a list of all supported currency codes, including the base currency and fallback rates.
  - **Implementation**:
    - Adds the base currency (`BASE_CURRENCY`) and all keys from the `FALLBACK_RATES` map to a list.
    - Sorts the list alphabetically before returning it.

- **`isCacheValid(String currency)`**
  - **Purpose**: Checks if the cached exchange rate for a given currency is still valid.
  - **Implementation**:
    - Verifies if the currency exists in the `exchangeRateCache`.
    - Compares the current time with the cache expiry time (calculated using `CACHE_EXPIRY_MINUTES`).

- **`fetchRateFromAPI(String currency)`**
  - **Purpose**: Fetches the exchange rate for a given currency from an external API.
  - **Implementation**:
    - Constructs an API URL using the `BASE_CURRENCY` and `API_KEY`.
    - Sends an HTTP GET request and parses the JSON response to extract the exchange rate for the specified currency.
    - Handles errors such as invalid status codes or missing currency data in the API response.

- **`clearCache()`**
  - **Purpose**: Clears the exchange rate cache.
  - **Implementation**:
    - Clears the `exchangeRateCache` map and logs a message.

---

### 2. **CurrencyExchangeServiceV2**
This is an enhanced version of the currency exchange service with additional methods for detailed rate calculations and currency conversion.

#### Key Methods:

- **`getExchangeRateV2(String currency)`**
  - **Purpose**: Retrieves the exchange rate for a given currency, using a cache or fallback rates if necessary.
  - **Implementation**:
    - Checks the cache for the currency.
    - Attempts to fetch the rate from an external API.
    - Falls back to predefined rates (`RATES`) if the API fetch fails.

- **`convertCurrencyV2(double amount, String from, String to)`**
  - **Purpose**: Converts an amount from one currency to another.
  - **Implementation**:
    - Retrieves exchange rates for the source and target currencies.
    - Calculates the converted amount using the formula `(amount * rate_from) / rate_to`.

- **`getDetailedExchangeRatesV2(String currency)`**
  - **Purpose**: Provides detailed exchange rates (mid, buy, sell, and fee) for a given currency.
  - **Implementation**:
    - Calculates buy and sell rates as slight variations of the mid rate.
    - Calculates a fee as 0.5% of the mid rate.

- **`getSupportedCurrenciesV2()`**
  - **Purpose**: Returns a list of supported currencies, including the base currency and fallback rates.

- **`fetchRateFromAPIV2(String currency)`**
  - **Purpose**: Fetches the exchange rate for a given currency from an external API.
  - **Implementation**:
    - Sends an HTTP GET request to the API.
    - Parses the response to extract the exchange rate for the specified currency.

- **`clearCacheV2()`**
  - **Purpose**: Clears the cache of exchange rates.

---

### 3. **CurrencyRate Class**
This class is used to store exchange rate information along with a timestamp indicating when the rate was last updated.

#### Key Methods:

- **Constructor**: Initializes the `rate` and `lastUpdated` fields.
- **`getRate()`**: Returns the stored exchange rate.
- **`getLastUpdated()`**: Returns the timestamp of the last update.

---

### 4. **FraudDetectionService**
This service implements mechanisms for detecting fraudulent cheque activities. It uses a `ChequeHistoryManager` to maintain transaction history and applies various fraud detection algorithms.

#### Key Features:

- **Fraud Detection Thresholds**:
  - Velocity check: Limits the number of transactions within a 7-day period.
  - Pattern similarity: Detects patterns in transaction amounts with a 95% similarity threshold.
  - Unusual frequency: Flags accounts with transaction frequencies exceeding 3 times the normal rate.

- **Fraud Alert Levels**:
  - Defined as `LOW`, `MEDIUM`, `HIGH`, and `CRITICAL`.

- **Dependencies**:
  - `FraudDetection`: A class responsible for implementing specific fraud detection algorithms.
  - `ChequeHistoryManager`: Manages the history of cheque transactions.
  - `ChequeTransaction`: Represents individual cheque transactions.

---

### 5. **ChequeHistoryManager**
This class manages the history of cheque transactions for different accounts.

#### Key Methods:

- **`recordCheque(String acc, String chq, String curr, double amt, Date d)`**
  - Records a cheque transaction for a given account.

- **`displayChequeHistory(String acc)`**
  - Displays the number of cheque transactions for a given account.

---

## External Dependencies

- **`CurrencyRate`**: Represents exchange rate data with timestamps.
- **`java.time.LocalDateTime`**: Used for handling date and time operations.
- **`org.json.simple.parser.JSONParser`**: Parses JSON responses from the external API.
- **`org.json.simple.JSONObject`**: Represents JSON objects.
- **`ChequeHistoryManager`**: Manages cheque transaction history.
- **`FraudDetection`**: Implements fraud detection algorithms.
- **`ChequeTransaction`**: Represents individual cheque transactions.

---

## Notes
- The code contains some inefficiencies and non-best-practice implementations, particularly in `CurrencyExchangeServiceV2`.
- The `fetchRateFromAPIV2` method uses a rudimentary approach to parse JSON responses, which may lead to errors in production.
- The `FraudDetectionService` relies on predefined thresholds and may require customization for different use cases.