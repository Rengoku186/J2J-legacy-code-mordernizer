---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_32"
confidence_score: 0.9
external_dependencies: ["CurrencyRate", "CurrencyExchangeService", "CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService"]
---

# Documentation for `SignatureVerificationService`, `ChequeProcessor`, and `CurrencyExchangeService`

## Overview
This code chunk contains three main components:
1. **`SignatureVerificationService`**: A service for verifying and managing account signatures.
2. **`ChequeProcessor`**: A module for processing cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
3. **`CurrencyExchangeService`**: A service for fetching and managing currency exchange rates, including fallback mechanisms and caching.

---

## `SignatureVerificationService`

### Purpose
The `SignatureVerificationService` is responsible for verifying account signatures and managing updates to the stored signatures. It uses a `HashMap` to store account numbers and their associated signatures.

### Fields
- `Map<String, String> accountSignatures`: Stores account numbers and their corresponding signatures.

### Methods

#### Constructor
```java
public SignatureVerificationService()
```
Initializes the service with some sample account signatures for demonstration purposes.

#### `verifySignature`
```java
public boolean verifySignature(String accountNumber, String signature)
```
Verifies if the provided signature matches the one on file for the given account number.
- **Parameters**:
  - `accountNumber`: The account number.
  - `signature`: The signature to verify.
- **Returns**: `true` if the signature is valid, `false` otherwise.
- **Behavior**:
  - If no signature is on file, it accepts the provided signature and stores it.
  - Compares the provided signature with the stored signature.

#### `updateSignature`
```java
public void updateSignature(String accountNumber, String newSignature)
```
Updates the stored signature for a given account number.
- **Parameters**:
  - `accountNumber`: The account number.
  - `newSignature`: The new signature to store.

---

## `ChequeProcessor`

### Purpose
The `ChequeProcessor` handles the end-to-end processing of cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.

### Fields
- `CurrencyExchangeService currencyExchangeService`: Service for currency exchange operations.
- `SignatureVerificationService signatureVerificationService`: Service for signature verification.
- `CoreBankingSystemUpdater coreBankingSystemUpdater`: Service for updating the core banking system.
- `ChequeHistoryManager chequeHistoryManager`: Service for recording cheque history.
- `FraudDetectionService fraudDetectionService`: Service for detecting fraudulent cheques.

### Methods

#### Constructor
```java
public ChequeProcessor(CurrencyExchangeService currencyExchangeService,
                       SignatureVerificationService signatureVerificationService,
                       CoreBankingSystemUpdater coreBankingSystemUpdater,
                       ChequeHistoryManager chequeHistoryManager,
                       FraudDetectionService fraudDetectionService)
```
Initializes the `ChequeProcessor` with the required services.

#### `processCheque`
```java
public void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)
```
Processes a cheque by performing the following steps:
1. Verifies the signature using `SignatureVerificationService`.
2. Detects fraud using `FraudDetectionService`.
3. Converts the amount to local currency if necessary using `CurrencyExchangeService`.
4. Updates the core banking system using `CoreBankingSystemUpdater`.
5. Records the cheque history using `ChequeHistoryManager`.

- **Parameters**:
  - `accountNumber`: The account number.
  - `chequeNumber`: The cheque number.
  - `currency`: The currency of the cheque.
  - `amount`: The amount on the cheque.
  - `signature`: The signature on the cheque.

---

## `CurrencyExchangeService`

### Purpose
The `CurrencyExchangeService` provides functionality for fetching and managing currency exchange rates. It includes mechanisms for caching rates, using fallback rates, and fetching rates from an external API.

### Fields
- `Map<String, CurrencyRate> exchangeRateCache`: Caches exchange rates for currencies.
- `static final String BASE_CURRENCY`: The base currency (USD).
- `static final long CACHE_EXPIRY_MINUTES`: Cache expiry time in minutes.
- `static final String API_KEY`: API key for fetching rates from an external source.
- `static final Map<String, Double> FALLBACK_RATES`: Fallback exchange rates for various currencies.

### Methods

#### `getExchangeRate`
```java
public double getExchangeRate(String currency)
```
Fetches the exchange rate for a specific currency.
- **Parameters**:
  - `currency`: The currency code (e.g., EUR, GBP).
- **Returns**: The exchange rate relative to the base currency (USD).
- **Behavior**:
  - Checks the cache for a valid rate.
  - Attempts to fetch the rate from an external API.
  - Falls back to predefined rates if the API fetch fails.

---

## External Dependencies
- `CurrencyRate`: Represents a currency rate with its value and last updated timestamp.
- `CurrencyExchangeService`: Provides detailed exchange rate information.
- `CoreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager`: Records cheque processing history.
- `FraudDetectionService`: Detects fraudulent cheques.

---

This documentation provides a detailed overview of the services and their methods, ensuring clarity for developers working with this code.