---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_32"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "CurrencyRate"]
---

# Documentation for `SignatureVerificationService`, `ChequeProcessor`, and `CurrencyExchangeService`

## Overview
This code chunk contains three main components:

1. **`SignatureVerificationService`**: A service for verifying and managing account signatures.
2. **`ChequeProcessor`**: A module for processing cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
3. **`CurrencyExchangeService`**: A service for fetching and managing currency exchange rates, including fallback mechanisms.

## `SignatureVerificationService`

### Purpose
This class is responsible for verifying account signatures and managing updates to the stored signatures. It uses a `HashMap` to store account numbers and their corresponding signatures.

### Methods

- **`SignatureVerificationService()`**: Constructor that initializes the service with sample account signatures for demonstration purposes.

- **`boolean verifySignature(String accountNumber, String signature)`**:
  - Verifies if the provided signature matches the stored signature for the given account number.
  - If no signature is on file, it accepts the new signature and stores it.
  - Returns `true` if the signature is valid, `false` otherwise.

- **`void updateSignature(String accountNumber, String newSignature)`**:
  - Updates the stored signature for the specified account number.

## `ChequeProcessor`

### Purpose
This class processes cheques by performing multiple operations, including:
- Signature verification
- Fraud detection
- Currency conversion
- Updating the core banking system
- Recording cheque history

### Dependencies
- **`CurrencyExchangeService`**: For currency conversion.
- **`SignatureVerificationService`**: For signature verification.
- **`CoreBankingSystemUpdater`**: For updating the core banking system.
- **`ChequeHistoryManager`**: For recording cheque history.
- **`FraudDetectionService`**: For detecting fraudulent cheques.

### Methods

- **`ChequeProcessor(...)`**: Constructor that initializes the processor with the required services.

- **`void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`**:
  - Verifies the signature using `SignatureVerificationService`.
  - Detects fraud using `FraudDetectionService`.
  - Converts the cheque amount to the local currency using `CurrencyExchangeService`.
  - Updates the core banking system using `CoreBankingSystemUpdater`.
  - Records the cheque in the history using `ChequeHistoryManager`.

## `CurrencyExchangeService`

### Purpose
This class provides functionality for fetching and managing currency exchange rates. It includes a caching mechanism and fallback rates for cases where external API calls fail.

### Methods

- **`double getExchangeRate(String currency)`**:
  - Fetches the exchange rate for the specified currency relative to the base currency (USD).
  - Uses cached rates if available and valid.
  - Attempts to fetch rates from an external API if not cached.
  - Falls back to predefined rates if the API call fails.

### Constants
- **`BASE_CURRENCY`**: The base currency for exchange rates (USD).
- **`CACHE_EXPIRY_MINUTES`**: The duration for which cached rates are valid.
- **`FALLBACK_RATES`**: A map of predefined exchange rates for various currencies.

## External Dependencies

### `CoreBankingSystemUpdater`
A mock implementation that updates the core banking system with the account number and the amount in local currency.

### `ChequeHistoryManager`
Manages the history of processed cheques and supports report generation for various time periods.

### `FraudDetectionService`
Detects fraudulent cheques by analyzing patterns, recent transactions, and other factors.

### `CurrencyRate`
Represents a currency rate with attributes for the rate value and the last updated timestamp.

## Notes
- The `SignatureVerificationService` is a simplified implementation for demonstration purposes and may not be suitable for production use.
- The `CurrencyExchangeService` includes a fallback mechanism to ensure functionality even when external APIs are unavailable.
- The `ChequeProcessor` integrates multiple services to provide a comprehensive cheque processing workflow.