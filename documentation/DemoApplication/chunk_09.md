---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_09"
confidence_score: 0.95
external_dependencies: ["CurrencyRate", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for Code Chunk

This code chunk contains several classes and methods related to currency exchange services and fraud detection mechanisms. Below is a detailed explanation of the key components:

## 1. **Currency Exchange Service**

### Purpose
The `CurrencyExchangeService` and `CurrencyExchangeServiceV2` classes provide functionality for fetching and managing currency exchange rates. They include caching mechanisms, API integration, and fallback rates for currency conversion.

### Key Methods

#### `isCacheValid(String currency)`
- **Purpose**: Checks if the cached exchange rate for a given currency is still valid.
- **Parameters**:
  - `currency`: The currency code (e.g., "USD").
- **Returns**: `true` if the cache is valid, `false` otherwise.
- **Logic**:
  - Verifies if the currency exists in the cache.
  - Compares the current time with the cache expiry time.

#### `fetchRateFromAPI(String currency)`
- **Purpose**: Fetches the exchange rate for a given currency from an external API.
- **Parameters**:
  - `currency`: The currency code.
- **Returns**: The exchange rate as a `double`.
- **Throws**: Exception if the API call fails.
- **Logic**:
  - Constructs the API URL using the base currency and API key.
  - Makes an HTTP GET request to fetch the exchange rate.
  - Parses the response (mocked in this code).

#### `clearCache()`
- **Purpose**: Clears the exchange rate cache.
- **Logic**:
  - Empties the `exchangeRateCache` map.
  - Logs a message indicating the cache has been cleared.

#### `CurrencyExchangeServiceV2`
- **Purpose**: An enhanced version of the currency exchange service with additional features and fallback rates.
- **Key Features**:
  - Uses a `cache` map for storing exchange rates.
  - Provides fallback rates for specific currencies.
  - Includes methods for fetching exchange rates, converting currencies, and retrieving detailed exchange rate information.

## 2. **CurrencyRate Class**

### Purpose
The `CurrencyRate` class is a data structure for storing exchange rate information along with a timestamp.

### Key Methods

#### Constructor
- **Parameters**:
  - `rate`: The exchange rate value.
  - `lastUpdated`: The timestamp of the last update.

#### `getRate()`
- **Returns**: The exchange rate value.

#### `getLastUpdated()`
- **Returns**: The timestamp of the last update.

## 3. **Fraud Detection Service**

### Purpose
The `FraudDetectionService` class implements various mechanisms to detect fraudulent cheque activities. It integrates with a `ChequeHistoryManager` and uses a `FraudDetection` instance for its operations.

### Key Methods

#### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
- **Purpose**: Determines if a cheque is fraudulent based on multiple checks.
- **Parameters**:
  - `accountId`: The account ID associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `amount`: The cheque amount.
- **Returns**: `true` if the cheque is fraudulent, `false` otherwise.
- **Logic**:
  - Performs various checks, including:
    - Duplicate cheque detection.
    - Abnormal amount detection.
    - Suspicious activity detection.
    - Velocity fraud detection.
    - Pattern fraud detection.
    - Historical duplicate detection (if `ChequeHistoryManager` is available).
    - Unusual frequency detection.
    - Similarity to recent transactions.
  - Logs the results of the checks.
  - Determines the fraud alert level based on the results.

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
- **Purpose**: Checks if a cheque is a duplicate.
- **Logic**:
  - Delegates the check to the `FraudDetection` instance.

#### `checkAbnormalAmount(double amount)`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Logic**:
  - Delegates the check to the `FraudDetection` instance.

### Dependencies
- **`FraudDetection`**: A class used for performing specific fraud detection checks.
- **`ChequeHistoryManager`**: Manages historical cheque data for additional fraud checks.
- **`ChequeTransaction`**: Represents individual cheque transactions.

## Summary
This code chunk provides a comprehensive implementation of currency exchange services and fraud detection mechanisms. It includes caching, API integration, fallback rates, and various fraud detection algorithms. The code demonstrates a mix of best practices and areas for improvement, such as error handling and efficient data parsing.