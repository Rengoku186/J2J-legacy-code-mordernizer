---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_23"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation: Fraud Detection Service

This code chunk is part of a `FraudDetectionService` class, which is responsible for detecting fraudulent activities related to cheque transactions. It uses various thresholds and checks to identify potential fraud and assigns an alert level based on the severity of the detected issues.

## Constants

### Fraud Detection Thresholds
- **`VELOCITY_CHECK_DAYS`**: Number of days to consider for velocity checks (default: `7` days).
- **`VELOCITY_THRESHOLD`**: Maximum number of transactions allowed within the velocity check period (default: `5`).
- **`PATTERN_THRESHOLD`**: Similarity threshold for pattern analysis (default: `0.95` or 95%).
- **`SIMILAR_AMOUNT_THRESHOLD`**: Similarity threshold for recent cheque amounts (default: `0.90` or 90%).
- **`UNUSUAL_FREQUENCY_THRESHOLD`**: Multiplier for detecting unusual frequency of transactions (default: `3x`).

### Fraud Alert Levels
The `AlertLevel` enum defines the severity levels of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## Constructor

### `FraudDetectionService()`
Initializes the `FraudDetectionService` with the following:
- `fraudDetection`: An instance of the `FraudDetection` class.
- `recentTransactions`: A `HashMap` to store recent transactions for each account.

## Methods

### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `ChequeHistoryManager` instance to enable historical checks for fraud detection.

### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Determines whether a cheque is fraudulent by performing the following checks:
1. **Duplicate Cheque Check**: Uses `checkDuplicateCheque` to verify if the cheque has already been processed.
2. **Abnormal Amount Check**: Uses `checkAbnormalAmount` to detect unusually high amounts.
3. **Suspicious Activity Check**: Uses `checkSuspiciousActivity` to identify suspicious account activity.
4. **Velocity Fraud Check**: Uses `checkVelocityFraud` to detect rapid transactions within a short period.
5. **Pattern Fraud Check**: Uses `checkPatternFraud` to identify patterns in transaction amounts.
6. **Historical Duplicate Check**: Uses `checkHistoricalDuplicate` to find duplicate cheques in historical data (if `ChequeHistoryManager` is set).
7. **Unusual Frequency Check**: Uses `checkUnusualFrequency` to detect unusually high transaction frequency (if `ChequeHistoryManager` is set).
8. **Similar Recent Amount Check**: Uses `checkSimilarToRecent` to find recent cheques with similar amounts (if `ChequeHistoryManager` is set).

Logs the results of these checks using `logFraudChecks` and determines the alert level using `determineAlertLevel`.

Returns `true` if any of the checks indicate fraud; otherwise, returns `false`.

### Private Helper Methods

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
Checks if the cheque has already been processed using the `FraudDetection.isDuplicateCheque` method.

#### `checkAbnormalAmount(double amount)`
Checks if the cheque amount exceeds a predefined threshold using the `FraudDetection.isAbnormalAmount` method.

#### `checkSuspiciousActivity(String accountId, double amount)`
Checks for suspicious activity in the account using the `FraudDetection.isSuspiciousActivity` method.

#### `checkVelocityFraud(String accountId, double amount)`
Detects rapid transactions within a short period (velocity fraud). It:
- Tracks recent transactions for the account.
- Filters transactions within the last `VELOCITY_CHECK_DAYS`.
- Returns `true` if the number of recent transactions exceeds `VELOCITY_THRESHOLD`.

#### `checkPatternFraud(String accountId, double amount)`
Analyzes patterns in transaction amounts to detect fraud. It:
- Compares the current amount with past amounts.
- Calculates similarity using the `PATTERN_THRESHOLD`.
- Returns `true` if at least three past transactions are similar to the current one.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Checks for duplicate cheques in historical data using the `ChequeHistoryManager.getChequeNumbers` method.

#### `checkUnusualFrequency(String accountId)`
Detects unusually high transaction frequency by comparing recent transactions to the average monthly frequency. Uses the `ChequeHistoryManager.getTotalChequeCount` and `ChequeHistoryManager.getRecentChequeCount` methods.

#### `checkSimilarToRecent(String accountId, double amount)`
Checks if the current cheque amount is similar to recent amounts using the `ChequeHistoryManager.hasSimilarRecentCheque` method and the `SIMILAR_AMOUNT_THRESHOLD`.

#### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of the checks. Assigns weights to each check and calculates a total fraud score:
- `CRITICAL`: Fraud score >= 5 or duplicate/historical duplicate detected.
- `HIGH`: Fraud score >= 3.
- `MEDIUM`: Fraud score >= 2.
- `LOW`: Fraud score < 2.

#### `logFraudChecks(...)`
Logs the results of all fraud checks and provides a summary indicating whether fraud was detected.

#### `formatCheckResult(boolean failed)`
Formats the result of a fraud check as either `FAILED ⚠️` or `Passed ✓`.

### Inner Class: `ChequeTransaction`
Represents a cheque transaction with the following fields:
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

#### Constructor
- `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes a cheque transaction with the specified amount and date.

#### Methods
- `getAmount()`: Returns the transaction amount.
- `getDate()`: Returns the transaction date.

## External Dependencies
- **`FraudDetection`**: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activity.
- **`ChequeHistoryManager`**: Provides historical data for cheques, including cheque numbers, total cheque count, and recent cheque count.

## Summary
The `FraudDetectionService` class is a comprehensive solution for detecting cheque-related fraud. It combines real-time and historical data analysis to identify various types of fraudulent activities and assigns an appropriate alert level based on the severity of the detected issues.