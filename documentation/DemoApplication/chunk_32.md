---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_32"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "CurrencyRate", "fetchRateFromAPI"]
---

# Documentation for `SignatureVerificationService`, `ChequeProcessor`, and `CurrencyExchangeService`

## Overview
This chunk of code provides implementations for three key components of a cheque processing system:

1. **`SignatureVerificationService`**: Handles signature verification for accounts.
2. **`ChequeProcessor`**: Manages the end-to-end processing of cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
3. **`CurrencyExchangeService`**: Provides exchange rate information and currency conversion functionality.

---

## `SignatureVerificationService`

### Purpose
The `SignatureVerificationService` is responsible for verifying the signatures associated with account numbers. It maintains a map of account numbers to their corresponding signatures.

### Key Methods

- **`verifySignature(String accountNumber, String signature)`**
  - Verifies if the provided signature matches the one on file for the given account number.
  - If no signature exists for the account, it accepts the provided signature and stores it (for demonstration purposes).
  - Returns `true` if the signature is valid, `false` otherwise.

- **`updateSignature(String accountNumber, String newSignature)`**
  - Updates the stored signature for a given account number.

---

## `ChequeProcessor`

### Purpose
The `ChequeProcessor` handles the complete lifecycle of cheque processing, including:
- Signature verification
- Fraud detection
- Currency conversion
- Updating the core banking system
- Recording cheque history

### Dependencies
The `ChequeProcessor` relies on the following external services:
- **`CurrencyExchangeService`**: For currency conversion.
- **`SignatureVerificationService`**: For signature verification.
- **`CoreBankingSystemUpdater`**: For updating the core banking system.
- **`ChequeHistoryManager`**: For recording cheque history.
- **`FraudDetectionService`**: For detecting fraudulent cheques.

### Key Methods

- **`processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`**
  - Processes a cheque by performing the following steps:
    1. Verifies the signature using `SignatureVerificationService`.
    2. Checks for fraud using `FraudDetectionService`.
    3. Converts the cheque amount to the local currency (USD) if necessary, using `CurrencyExchangeService`.
    4. Updates the core banking system with the processed amount using `CoreBankingSystemUpdater`.
    5. Records the cheque details in the history using `ChequeHistoryManager`.

---

## `CurrencyExchangeService`

### Purpose
The `CurrencyExchangeService` provides exchange rate information and performs currency conversions. It supports multiple currencies and includes a caching mechanism for exchange rates.

### Key Features
- Maintains a cache of exchange rates with expiry times.
- Fetches exchange rates from an external API.
- Provides fallback rates in case the API is unavailable.

### Key Methods

- **`getExchangeRate(String currency)`**
  - Fetches the exchange rate for the specified currency relative to the base currency (USD).
  - Checks the cache for a valid rate before attempting to fetch from an external API.
  - Uses fallback rates if the API fetch fails.

- **`fetchRateFromAPI(String currencyCode)`**
  - Attempts to fetch the exchange rate for a currency from an external API.
  - Caches the fetched rate if successful.

---

## External Dependencies

### `CoreBankingSystemUpdater`
- Updates the core banking system with the processed cheque amount.
- Mock implementation found in the same file.

### `ChequeHistoryManager`
- Records and manages the history of processed cheques.
- Mock implementation found in the same file.

### `FraudDetectionService`
- Detects fraudulent cheques based on various criteria.
- Implementation details found in the same file.

### `CurrencyRate`
- Represents exchange rate information, including the rate and the last updated timestamp.
- Used for caching exchange rates.

### `fetchRateFromAPI`
- Fetches exchange rates from an external API.
- Used in `CurrencyExchangeService` to dynamically update rates.

---

## Notes
- The `SignatureVerificationService` and `ChequeProcessor` are tightly coupled with the `CurrencyExchangeService` and other external services.
- The `CurrencyExchangeService` includes a fallback mechanism to ensure functionality even when the external API is unavailable.
- The `ChequeProcessor` demonstrates a clear sequence of operations for cheque processing, making it a central component of the system.