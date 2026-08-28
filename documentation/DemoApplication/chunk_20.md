---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_20"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "Logger", "ChequeStatus"]
---

# Documentation for `DemoApplication` - Cheque Processing Module

This section of the `DemoApplication` contains the implementation of several classes and methods related to cheque processing, including mock implementations of services and a comprehensive `ChequeProcessor` class. Below is a detailed explanation of the code:

## Classes and Methods

### 1. `ChequeHistoryManager`
This class is a mock implementation for managing cheque history. It provides methods to record and retrieve cheque-related data.

#### Inner Class: `ChequeRecord`
Represents a single cheque record with the following fields:
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String currency`: The currency of the cheque.
- `double amount`: The amount of the cheque.
- `Date date`: The date of the cheque.

**Constructor:**
```java
ChequeRecord(String acc, String chq, String curr, double amt, Date d)
```
Initializes a new cheque record with the provided details.

#### Methods:
- `void recordCheque(String acc, String chq, String curr, double amt, Date d)`: Records a cheque for the given account.
- `void displayChequeHistory(String acc)`: Displays the number of cheque records for a specific account.
- `List<String> getChequeNumbers(String acc)`: Returns a list of cheque numbers for the given account (currently returns an empty list).
- `int getTotalChequeCount(String acc)`: Returns the total number of cheques for the account (currently returns 0).
- `int getRecentChequeCount(String acc)`: Returns the count of recent cheques for the account (currently returns 0).
- `boolean hasSimilarRecentCheque(String acc, double amt, double threshold)`: Checks for similar recent cheques (currently always returns false).
- `List<ChequeRecord> getAllChequeRecordsInPeriod(LocalDate start, LocalDate end)`: Retrieves all cheque records within a specified period (currently returns an empty list).
- `String generateChequeReportCSV(List<ChequeRecord> records)`: Generates a CSV report for the given cheque records (currently returns a placeholder string).

### 2. `CoreBankingSystemUpdater`
A mock implementation for updating the core banking system.

#### Methods:
- `void updateCoreBankingSystem(String acc, double amt)`: Updates the core banking system for the given account and amount.

### 3. `SignatureVerificationService`
This class provides functionality for verifying and updating signatures associated with accounts.

#### Fields:
- `Map<String, String> accountSignatures`: Stores account numbers and their associated signatures.

#### Constructor:
- `SignatureVerificationService()`: Initializes the service with some sample signatures for demonstration purposes.

#### Methods:
- `boolean verifySignature(String accountNumber, String signature)`: Verifies if the provided signature matches the one on file for the account. If no signature is on file, it accepts the new signature and stores it.
- `void updateSignature(String accountNumber, String newSignature)`: Updates the signature on file for the given account.

### 4. `ChequeProcessor`
This class is responsible for processing cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.

#### Dependencies:
The class depends on the following services:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies signatures on cheques.
- `CoreBankingSystemUpdater`: Updates the core banking system.
- `ChequeHistoryManager`: Manages cheque history.
- `FraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager`: Reports exceptions during cheque processing.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications.

#### Constructor:
```java
ChequeProcessor(CurrencyExchangeService currencyExchangeService,
                SignatureVerificationService signatureVerificationService,
                CoreBankingSystemUpdater coreBankingSystemUpdater,
                ChequeHistoryManager chequeHistoryManager,
                FraudDetectionService fraudDetectionService,
                ExceptionReportManager exceptionReportManager,
                ChequeStatusManager chequeStatusManager,
                EmailNotificationService emailNotificationService)
```
Initializes the `ChequeProcessor` with the required dependencies.

#### Method: `void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`
Processes a cheque by performing the following steps:
1. Checks if the cheque is already tracked. If not, marks it as issued using `ChequeStatusManager`.
2. Logs the processing of the cheque.
3. Verifies the signature using `SignatureVerificationService`. If verification fails, an exception is reported, and an email notification is sent.
4. Checks for fraudulent activity using `FraudDetectionService`. If fraud is detected, an exception is reported, and an email notification is sent.
5. Simulates a bounced cheque if the amount exceeds 50,000. Reports an exception and sends an email notification.
6. Simulates a delayed cheque if the cheque number ends with '9'. Reports an exception and logs the delay.

### 5. Enum: `ChequeStatus`
Represents the status of a cheque. Possible values:
- `ISSUED`
- `PROCESSED`
- `CANCELED`

### 6. `ChequeStatusManager`
Manages the status of cheques.

#### Fields:
- `Map<String, ChequeStatus> chequeStatusMap`: Maps a combination of account number and cheque number to a `ChequeStatus`.

#### Methods:
- `void setStatus(String accountNumber, String chequeNumber, ChequeStatus status)`: Sets the status of a cheque.
- `ChequeStatus getStatus(String accountNumber, String chequeNumber)`: Retrieves the status of a cheque.

## External Dependencies
The following external classes and services are referenced in this code:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `FraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager`: Reports exceptions during cheque processing.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications.
- `Logger`: Logs messages for debugging and monitoring.
- `ChequeStatus`: Enum representing the status of a cheque.