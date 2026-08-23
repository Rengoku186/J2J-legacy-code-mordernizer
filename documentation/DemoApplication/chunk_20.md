---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_20"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService"]
---

# Documentation for `DemoApplication` Code Chunk

This code chunk contains several mock implementations and a `ChequeProcessor` class that integrates multiple services to process cheques. Below is a detailed explanation of the components and their roles:

## 1. `ChequeHistoryManager`
This class is responsible for managing the history of cheques for different accounts. It provides methods to record and display cheque history.

### Methods:
- **`recordCheque(String acc, String chq, String curr, double amt, Date d)`**:
  Records a cheque for a given account.
- **`displayChequeHistory(String acc)`**:
  Displays the number of cheques recorded for a specific account.
- **`getChequeNumbers(String acc)`**:
  Returns a list of cheque numbers for a given account (currently returns an empty list).
- **`getTotalChequeCount(String acc)`**:
  Returns the total number of cheques for a given account (currently returns 0).
- **`getRecentChequeCount(String acc)`**:
  Returns the count of recent cheques for a given account (currently returns 0).
- **`hasSimilarRecentCheque(String acc, double amt, double threshold)`**:
  Checks if there is a similar recent cheque (currently always returns false).
- **`getAllChequeRecordsInPeriod(LocalDate start, LocalDate end)`**:
  Retrieves all cheque records within a specified period (currently returns an empty list).
- **`generateChequeReportCSV(List<ChequeRecord> records)`**:
  Generates a CSV report for the given cheque records (currently returns a placeholder string).

## 2. `CoreBankingSystemUpdater`
This class provides a method to update the core banking system with transaction details.

### Methods:
- **`updateCoreBankingSystem(String acc, double amt)`**:
  Updates the core banking system for a given account and amount.

## 3. `SignatureVerificationService`
This service verifies the signatures on cheques against stored signatures for accounts.

### Fields:
- **`accountSignatures`**:
  A map storing account numbers and their corresponding signatures.

### Methods:
- **`verifySignature(String accountNumber, String signature)`**:
  Verifies if the provided signature matches the stored signature for the account. If no signature is on file, it accepts the new signature and stores it.
- **`updateSignature(String accountNumber, String newSignature)`**:
  Updates the stored signature for a given account.

## 4. `ChequeProcessor`
This class integrates multiple services to process cheques. It handles signature verification, fraud detection, currency conversion, and updates to the core banking system.

### Dependencies:
- **`CurrencyExchangeService`**: Handles currency conversion.
- **`SignatureVerificationService`**: Verifies cheque signatures.
- **`CoreBankingSystemUpdater`**: Updates the core banking system.
- **`ChequeHistoryManager`**: Manages cheque history.
- **`FraudDetectionService`**: Detects fraudulent cheques.
- **`ExceptionReportManager`**: Logs exceptions during cheque processing.
- **`ChequeStatusManager`**: Tracks the status of cheques.
- **`EmailNotificationService`**: Sends email notifications.

### Methods:
- **`processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`**:
  Processes a cheque by performing the following steps:
  1. Checks and updates the cheque status using `ChequeStatusManager`.
  2. Verifies the signature using `SignatureVerificationService`. If verification fails, an exception is reported, and an email notification is sent.
  3. Detects fraudulent cheques using `FraudDetectionService`. If fraud is detected, an exception is reported, and an email notification is sent.
  4. Simulates cheque bouncing for amounts greater than 50,000 and reports an exception.
  5. Simulates delayed cheque processing for cheque numbers ending in '9' and reports an exception.

### Notes:
- The `processCheque` method includes logging and exception handling for various scenarios, such as signature mismatches, fraudulent cheques, and simulated cheque bounces or delays.
- The method uses the `Logger` class for logging and the `exceptionReportManager` for reporting issues.

### External Dependencies:
- **`CurrencyExchangeService`**: Used for currency conversion.
- **`FraudDetectionService`**: Used for detecting fraudulent cheques.
- **`ExceptionReportManager`**: Used for logging exceptions.
- **`ChequeStatusManager`**: Used for tracking cheque statuses.
- **`EmailNotificationService`**: Used for sending email notifications.

### Enum:
- **`ChequeStatus`**:
  Represents the status of a cheque. Possible values are:
  - `ISSUED`
  - `PROCESSED`
  - `CANCELED`

This code chunk provides a comprehensive framework for cheque processing, including various checks and updates to ensure the integrity and security of transactions.