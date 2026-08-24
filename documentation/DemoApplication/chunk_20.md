---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_20"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "Logger", "ChequeStatus"]
---

# Documentation for `DemoApplication.java` (Chunk 20)

## Overview
This code chunk contains several classes and methods that simulate a banking system's cheque processing workflow. The main components include:

1. **ChequeHistoryManager**: Manages the history of cheques for different accounts.
2. **CoreBankingSystemUpdater**: Updates the core banking system with transaction details.
3. **SignatureVerificationService**: Verifies the authenticity of signatures on cheques.
4. **ChequeProcessor**: A comprehensive module that processes cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.

## Classes and Methods

### 1. `ChequeHistoryManager`
This class is responsible for managing the history of cheques for different accounts. It provides methods to record and retrieve cheque history.

#### Inner Class: `ChequeRecord`
Represents a single cheque record with the following attributes:
- `accountNumber` (String): The account number associated with the cheque.
- `chequeNumber` (String): The unique identifier for the cheque.
- `currency` (String): The currency of the cheque.
- `amount` (double): The amount of the cheque.
- `date` (Date): The date the cheque was issued.

#### Methods
- `recordCheque(String acc, String chq, String curr, double amt, Date d)`: Records a cheque for a given account.
- `displayChequeHistory(String acc)`: Displays the number of cheque records for a given account.
- `getChequeNumbers(String acc)`: Returns a list of cheque numbers for a given account (currently returns an empty list).
- `getTotalChequeCount(String acc)`: Returns the total number of cheques for a given account (currently returns 0).
- `getRecentChequeCount(String acc)`: Returns the count of recent cheques for a given account (currently returns 0).
- `hasSimilarRecentCheque(String acc, double amt, double threshold)`: Checks if there is a similar recent cheque (currently returns false).
- `getAllChequeRecordsInPeriod(LocalDate start, LocalDate end)`: Retrieves all cheque records within a specified period (currently returns an empty list).
- `generateChequeReportCSV(List<ChequeRecord> records)`: Generates a CSV report for the given list of cheque records (currently returns a placeholder string).

### 2. `CoreBankingSystemUpdater`
This class is responsible for updating the core banking system with transaction details.

#### Methods
- `updateCoreBankingSystem(String acc, double amt)`: Updates the core banking system for a given account with the specified amount.

### 3. `SignatureVerificationService`
This class provides functionality for verifying and updating signatures associated with accounts.

#### Attributes
- `accountSignatures` (Map<String, String>): A map storing account numbers and their associated signatures.

#### Constructor
- `SignatureVerificationService()`: Initializes the service with some sample account signatures for testing purposes.

#### Methods
- `verifySignature(String accountNumber, String signature)`: Verifies if the provided signature matches the one on file for the given account. If no signature is on file, it accepts the provided signature and stores it.
- `updateSignature(String accountNumber, String newSignature)`: Updates the signature on file for a given account.

### 4. `ChequeProcessor`
This class is a comprehensive module for processing cheques. It integrates various services to handle signature verification, fraud detection, currency conversion, and core banking system updates.

#### Attributes
- `currencyExchangeService` (CurrencyExchangeService): Handles currency conversion.
- `signatureVerificationService` (SignatureVerificationService): Verifies cheque signatures.
- `coreBankingSystemUpdater` (CoreBankingSystemUpdater): Updates the core banking system.
- `chequeHistoryManager` (ChequeHistoryManager): Manages cheque history.
- `fraudDetectionService` (FraudDetectionService): Detects fraudulent cheques.
- `exceptionReportManager` (ExceptionReportManager): Manages exception reporting.
- `chequeStatusManager` (ChequeStatusManager): Tracks the status of cheques.
- `emailNotificationService` (EmailNotificationService): Sends email notifications.

#### Constructor
- `ChequeProcessor(...)`: Initializes the processor with the required services.

#### Methods
- `processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`: Processes a cheque by performing the following steps:
  1. Checks and sets the status of the cheque to `ISSUED` if not already tracked.
  2. Verifies the signature using `SignatureVerificationService`. If verification fails, an exception is reported, and an email notification is sent.
  3. Detects fraud using `FraudDetectionService`. If fraud is detected, an exception is reported, and an email notification is sent.
  4. Simulates a bounced cheque if the amount exceeds 50,000. Reports an exception and sends an email notification.
  5. Simulates a delayed cheque if the cheque number ends with '9'. Reports an exception and optionally sends a notification.

## External Dependencies
The following external classes and enums are referenced in this code:
- `CurrencyExchangeService`: Handles currency conversion.
- `FraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager`: Manages exception reporting.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications.
- `Logger`: Logs messages and warnings.
- `ChequeStatus`: Enum representing the status of a cheque (`ISSUED`, `PROCESSED`, `CANCELED`).