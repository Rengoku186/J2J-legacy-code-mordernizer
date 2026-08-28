---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_23"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Fraud Detection Service Documentation

This chunk of code implements a `FraudDetectionService` class that provides functionality to detect fraudulent cheque transactions. It uses various thresholds and checks to determine whether a transaction is potentially fraudulent. The service also categorizes the severity of fraud into different alert levels.

## Constants

### Fraud Detection Thresholds
- **`VELOCITY_CHECK_DAYS`**: Number of days to consider for velocity checks (7 days).
- **`VELOCITY_THRESHOLD`**: Maximum allowed transactions within the velocity check period (5 transactions).
- **`PATTERN_THRESHOLD`**: Similarity threshold for pattern analysis (95%).
- **`SIMILAR_AMOUNT_THRESHOLD`**: Similarity threshold for recent amounts (90%).
- **`UNUSUAL_FREQUENCY_THRESHOLD`**: Multiplier for unusual frequency detection (3x normal frequency).

### Fraud Alert Levels
The `AlertLevel` enum defines four levels of fraud severity:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## Constructor

### `FraudDetectionService()`
Initializes the service with the following:
- A `FraudDetection` instance for performing core fraud checks.
- A `HashMap` to store recent transactions for each account.

## Methods

### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `ChequeHistoryManager` instance to enable historical checks.

### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Determines if a cheque is fraudulent by performing the following checks:
1. **Duplicate Cheque Check**: Checks if the cheque number is a duplicate.
2. **Abnormal Amount Check**: Checks if the amount is abnormal.
3. **Suspicious Activity Check**: Checks for suspicious activity based on the account and amount.
4. **Velocity Fraud Check**: Checks if the transaction exceeds the velocity threshold.
5. **Pattern Fraud Check**: Checks for patterns in recent transactions.
6. **Historical Duplicate Check**: (if `historyManager` is set) Checks for duplicates in historical records.
7. **Unusual Frequency Check**: (if `historyManager` is set) Checks for unusual transaction frequency.
8. **Similar Recent Amount Check**: (if `historyManager` is set) Checks for recent transactions with similar amounts.

Logs the results of all checks and determines the fraud alert level using the `determineAlertLevel` method. Returns `true` if any of the checks indicate fraud.

### Private Helper Methods

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
Uses the `FraudDetection` instance to check for duplicate cheques.

#### `checkAbnormalAmount(double amount)`
Uses the `FraudDetection` instance to check if the amount is abnormal.

#### `checkSuspiciousActivity(String accountId, double amount)`
Uses the `FraudDetection` instance to check for suspicious activity.

#### `checkVelocityFraud(String accountId, double amount)`
Checks if the number of transactions within the last `VELOCITY_CHECK_DAYS` exceeds the `VELOCITY_THRESHOLD`. Cleans up old transactions from the record.

#### `checkPatternFraud(String accountId, double amount)`
Analyzes recent transactions to detect patterns of similar amounts exceeding the `PATTERN_THRESHOLD`.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Uses the `ChequeHistoryManager` to check for duplicate cheques in historical records.

#### `checkUnusualFrequency(String accountId)`
Uses the `ChequeHistoryManager` to check if the recent transaction frequency exceeds the `UNUSUAL_FREQUENCY_THRESHOLD`.

#### `checkSimilarToRecent(String accountId, double amount)`
Uses the `ChequeHistoryManager` to check for recent transactions with amounts similar to the given amount, based on the `SIMILAR_AMOUNT_THRESHOLD`.

#### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of the various checks. The alert levels are determined as follows:
- `CRITICAL`: Fraud count >= 5 or duplicate/historical duplicate detected.
- `HIGH`: Fraud count >= 3.
- `MEDIUM`: Fraud count >= 2.
- `LOW`: Fraud count < 2.

#### `logFraudChecks(...)`
Logs the results of all fraud checks and provides a summary indicating whether fraud was detected.

#### `formatCheckResult(boolean failed)`
Formats the result of a fraud check as either "FAILED ⚠️" or "Passed ✓".

### Nested Class: `ChequeTransaction`
Represents a cheque transaction with the following fields:
- `amount`: The transaction amount.
- `date`: The transaction date.

## External Dependencies

### `FraudDetection`
A class used for performing core fraud detection checks such as duplicate cheques, abnormal amounts, and suspicious activity.

### `ChequeHistoryManager`
A class used for managing historical cheque data. Provides methods to:
- Retrieve historical cheque numbers for an account.
- Get the total and recent cheque counts for an account.
- Check for recent cheques with similar amounts.

## Summary
The `FraudDetectionService` class is a comprehensive solution for detecting fraudulent cheque transactions. It combines real-time and historical analysis to identify potential fraud and categorizes the severity of fraud into alert levels. The service is highly configurable and relies on external dependencies (`FraudDetection` and `ChequeHistoryManager`) for core functionality and historical data management.