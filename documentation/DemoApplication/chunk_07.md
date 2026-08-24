---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_07"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService"]
---

# Documentation for `SignatureVerificationService` and `ChequeProcessor` Classes

## Overview
This code chunk contains two classes:
1. `SignatureVerificationService`: A service for verifying and managing signatures associated with account numbers.
2. `ChequeProcessor`: A module for processing cheques, which includes signature verification, fraud detection, currency conversion, and updating the core banking system.

---

## `SignatureVerificationService` Class

### Purpose
The `SignatureVerificationService` class is responsible for verifying signatures associated with account numbers. It maintains a mapping of account numbers to their respective signatures and provides methods to verify and update these signatures.

### Fields
- `Map<String, String> accountSignatures`: A map that stores account numbers as keys and their corresponding signatures as values.

### Constructors
- `SignatureVerificationService()`: Initializes the service with a predefined set of account numbers and their associated signatures for demonstration purposes.

### Methods

#### `boolean verifySignature(String accountNumber, String signature)`
Verifies if the provided signature matches the one on file for the given account number.

**Parameters:**
- `accountNumber` (String): The account number to verify the signature for.
- `signature` (String): The signature to verify.

**Returns:**
- `true` if the signature matches the one on file or if no signature is on file (in which case the provided signature is accepted and stored).
- `false` if the signature does not match the one on file.

**Behavior:**
1. If the account number does not exist in the `accountSignatures` map, the provided signature is accepted and stored.
2. If the account number exists, the provided signature is compared to the stored signature.
3. Logs the result of the verification process.

#### `void updateSignature(String accountNumber, String newSignature)`
Updates the signature on file for the given account number.

**Parameters:**
- `accountNumber` (String): The account number for which the signature is to be updated.
- `newSignature` (String): The new signature to be stored.

**Behavior:**
1. Updates the `accountSignatures` map with the new signature for the given account number.
2. Logs the update operation.

---

## `ChequeProcessor` Class

### Purpose
The `ChequeProcessor` class is a comprehensive module for processing cheques. It integrates multiple services to handle various aspects of cheque processing, including:
- Signature verification
- Fraud detection
- Currency conversion
- Core banking system updates
- Cheque status management
- Exception reporting
- Email notifications

### Fields
- `CurrencyExchangeService currencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService signatureVerificationService`: Verifies signatures on cheques.
- `CoreBankingSystemUpdater coreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager chequeHistoryManager`: Manages the history of processed cheques.
- `FraudDetectionService fraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager exceptionReportManager`: Manages exception reports for issues encountered during cheque processing.
- `ChequeStatusManager chequeStatusManager`: Tracks the status of cheques (e.g., issued, processed, canceled).
- `EmailNotificationService emailNotificationService`: Sends email notifications for various events.

### Constructor
- `ChequeProcessor(CurrencyExchangeService currencyExchangeService, SignatureVerificationService signatureVerificationService, CoreBankingSystemUpdater coreBankingSystemUpdater, ChequeHistoryManager chequeHistoryManager, FraudDetectionService fraudDetectionService, ExceptionReportManager exceptionReportManager, ChequeStatusManager chequeStatusManager, EmailNotificationService emailNotificationService)`:
  Initializes the `ChequeProcessor` with the required services.

### Methods

#### `void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`
Processes a cheque by performing the following steps:

**Parameters:**
- `accountNumber` (String): The account number associated with the cheque.
- `chequeNumber` (String): The unique identifier for the cheque.
- `currency` (String): The currency of the cheque amount.
- `amount` (double): The amount of the cheque.
- `signature` (String): The signature to be verified.

**Behavior:**
1. **Cheque Status Check:**
   - Checks if the cheque has already been issued. If not, marks it as issued using `ChequeStatusManager`.

2. **Signature Verification:**
   - Verifies the signature using `SignatureVerificationService`.
   - If the signature verification fails, an exception is reported using `ExceptionReportManager`, and an email notification is sent using `EmailNotificationService`.

3. **Fraud Detection:**
   - Checks for fraudulent or duplicate cheques using `FraudDetectionService`.
   - If fraud is detected, an exception is reported, and an email notification is sent.

4. **Simulated Bounced Cheque:**
   - If the cheque amount exceeds $50,000, simulates a bounced cheque due to insufficient funds.
   - Reports an exception and sends an email notification.

5. **Simulated Delayed Cheque:**
   - If the cheque number ends with '9', simulates a delayed cheque processing.
   - Reports an exception and optionally sends a notification.

6. **Currency Conversion:**
   - If the currency is not USD, fetches detailed exchange rate information using `CurrencyExchangeService`.
   - Converts the cheque amount to local currency (USD) using the buy rate and applies a fee.

7. **Core Banking System Update:**
   - Updates the core banking system with the converted amount using `CoreBankingSystemUpdater`.

---

## External Dependencies
The `ChequeProcessor` class depends on the following external services:
- `CurrencyExchangeService`: Provides currency exchange rates and conversion functionality.
- `CoreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager`: Manages the history of processed cheques.
- `FraudDetectionService`: Detects fraudulent or duplicate cheques.
- `ExceptionReportManager`: Handles exception reporting for issues encountered during cheque processing.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications for various events.