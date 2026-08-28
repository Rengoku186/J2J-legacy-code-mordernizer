---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_07"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "Logger", "ChequeStatus"]
---

# Documentation for `SignatureVerificationService` and `ChequeProcessor`

## Overview
This code defines two main components:

1. **`SignatureVerificationService`**: A service responsible for verifying and managing signatures associated with bank accounts.
2. **`ChequeProcessor`**: A module for processing cheques, which includes signature verification, fraud detection, currency conversion, and updating the core banking system.

---

## `SignatureVerificationService`

### Purpose
The `SignatureVerificationService` is a utility class that manages and verifies signatures associated with bank accounts. It is initialized with a set of sample signatures for demonstration purposes.

### Fields
- `accountSignatures`: A `Map<String, String>` that stores account numbers as keys and their corresponding signatures as values.

### Constructor
- **`SignatureVerificationService()`**
  - Initializes the `accountSignatures` map with some sample account numbers and their corresponding signatures.

### Methods

#### `boolean verifySignature(String accountNumber, String signature)`
Verifies if the provided signature matches the one on file for the given account number.

- **Parameters**:
  - `accountNumber`: The account number to verify the signature against.
  - `signature`: The signature to verify.
- **Returns**: `true` if the signature matches the one on file or if no signature is on file (in which case the provided signature is accepted and stored). Returns `false` if the signature does not match.
- **Behavior**:
  - If the account number does not exist in the `accountSignatures` map, the provided signature is accepted and stored.
  - If the account number exists, the provided signature is compared with the stored signature.

#### `void updateSignature(String accountNumber, String newSignature)`
Updates the signature on file for a given account number.

- **Parameters**:
  - `accountNumber`: The account number for which the signature is to be updated.
  - `newSignature`: The new signature to be stored.
- **Behavior**: Updates the `accountSignatures` map with the new signature for the specified account number.

---

## `ChequeProcessor`

### Purpose
The `ChequeProcessor` is a comprehensive module designed to handle the processing of cheques. It integrates multiple services to perform tasks such as signature verification, fraud detection, currency conversion, and updating the core banking system.

### Fields
- `currencyExchangeService`: An instance of `CurrencyExchangeService` for handling currency conversions.
- `signatureVerificationService`: An instance of `SignatureVerificationService` for verifying cheque signatures.
- `coreBankingSystemUpdater`: An instance of `CoreBankingSystemUpdater` for updating the core banking system.
- `chequeHistoryManager`: An instance of `ChequeHistoryManager` for managing cheque history.
- `fraudDetectionService`: An instance of `FraudDetectionService` for detecting fraudulent cheques.
- `exceptionReportManager`: An instance of `ExceptionReportManager` for reporting exceptions during cheque processing.
- `chequeStatusManager`: An instance of `ChequeStatusManager` for tracking the status of cheques.
- `emailNotificationService`: An instance of `EmailNotificationService` for sending email notifications.

### Constructor
- **`ChequeProcessor`**
  - Initializes the `ChequeProcessor` with instances of the required services.
  - **Parameters**:
    - `currencyExchangeService`: The service for currency exchange operations.
    - `signatureVerificationService`: The service for signature verification.
    - `coreBankingSystemUpdater`: The service for updating the core banking system.
    - `chequeHistoryManager`: The service for managing cheque history.
    - `fraudDetectionService`: The service for fraud detection.
    - `exceptionReportManager`: The service for reporting exceptions.
    - `chequeStatusManager`: The service for managing cheque statuses.
    - `emailNotificationService`: The service for sending email notifications.

### Methods

#### `void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`
Processes a cheque by performing various checks and operations.

- **Parameters**:
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The unique identifier for the cheque.
  - `currency`: The currency of the cheque amount.
  - `amount`: The amount of the cheque.
  - `signature`: The signature to be verified.
- **Behavior**:
  1. Checks if the cheque is already tracked in the `ChequeStatusManager`. If not, marks it as `ISSUED`.
  2. Verifies the signature using the `SignatureVerificationService`. If the signature is invalid, an exception is reported, and an email notification is sent.
  3. Checks for fraudulent activity using the `FraudDetectionService`. If fraud is detected, an exception is reported, and an email notification is sent.
  4. Simulates a bounced cheque if the amount exceeds $50,000, reporting an exception and sending an email notification.
  5. Simulates a delayed cheque if the cheque number ends with '9', reporting an exception.
  6. If the currency is not USD, retrieves detailed exchange rate information from the `CurrencyExchangeService` and converts the amount to local currency, applying any applicable fees.
  7. Updates the core banking system with the converted amount using the `CoreBankingSystemUpdater`.

---

## External Dependencies
The following external classes and services are used in this code:

1. **`CurrencyExchangeService`**: Provides currency exchange rates and detailed exchange rate information.
2. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
3. **`ChequeHistoryManager`**: Manages the history of cheques for accounts.
4. **`FraudDetectionService`**: Detects fraudulent or duplicate cheques.
5. **`ExceptionReportManager`**: Reports exceptions encountered during cheque processing.
6. **`ChequeStatusManager`**: Tracks the status of cheques (e.g., ISSUED, PROCESSED, CANCELED).
7. **`EmailNotificationService`**: Sends email notifications to account holders.
8. **`Logger`**: Logs information, warnings, and errors.
9. **`ChequeStatus`**: Enum representing the status of a cheque (ISSUED, PROCESSED, CANCELED).