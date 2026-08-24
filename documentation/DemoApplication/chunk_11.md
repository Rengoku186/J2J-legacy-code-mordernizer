---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_11"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Fraud Detection Methods in `DemoApplication`

## Overview
This code chunk is part of a fraud detection system that evaluates whether a cheque transaction is potentially fraudulent. It implements various checks, including duplicate detection, abnormal amounts, suspicious activity, velocity fraud, and pattern analysis. Additionally, it incorporates historical data checks if a `ChequeHistoryManager` is available.

The main method, `isFraudulentCheque`, orchestrates these checks and determines the overall fraud status of a cheque transaction. The results of the checks are logged, and an alert level is determined based on the severity of the detected issues.

## Key Methods

### `isFraudulentCheque`
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount)
```
This is the main method that evaluates whether a cheque is fraudulent. It performs the following steps:
1. Executes basic fraud checks: duplicate cheque, abnormal amount, suspicious activity, velocity fraud, and pattern fraud.
2. If a `ChequeHistoryManager` is available, it performs additional checks: historical duplicate, unusual frequency, and similarity to recent transactions.
3. Logs the results of all checks.
4. Determines the fraud alert level using the `determineAlertLevel` method.
5. Returns `true` if any of the checks indicate fraud; otherwise, returns `false`.

### `checkDuplicateCheque`
```java
private boolean checkDuplicateCheque(String accountId, String chequeNumber)
```
Checks if the cheque is a duplicate using the `FraudDetection` service.

### `checkAbnormalAmount`
```java
private boolean checkAbnormalAmount(double amount)
```
Checks if the cheque amount is abnormal using the `FraudDetection` service.

### `checkSuspiciousActivity`
```java
private boolean checkSuspiciousActivity(String accountId, double amount)
```
Checks for suspicious activity associated with the account and amount using the `FraudDetection` service.

### `checkVelocityFraud`
```java
private boolean checkVelocityFraud(String accountId, double amount)
```
Detects velocity fraud by analyzing the frequency of recent transactions for the account. It uses the constants:
- `VELOCITY_CHECK_DAYS`: Number of days to consider for velocity checks (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).

### `checkPatternFraud`
```java
private boolean checkPatternFraud(String accountId, double amount)
```
Analyzes transaction patterns to detect fraud. It checks if the current transaction amount is similar to at least three recent transactions using the `PATTERN_THRESHOLD` constant (95% similarity).

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
Checks if the cheque number exists in the historical records using the `ChequeHistoryManager`.

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
Detects unusual transaction frequency by comparing recent transaction counts to the average monthly frequency. It uses the `UNUSUAL_FREQUENCY_THRESHOLD` constant (3x normal frequency).

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
Checks if the current transaction amount is similar to recent transactions using the `SIMILAR_AMOUNT_THRESHOLD` constant (90% similarity).

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
Determines the fraud alert level based on the results of the checks. The alert levels are:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
Logs the results of all fraud checks and provides a summary indicating whether fraud was detected.

### `ChequeTransaction` (Inner Class)
```java
private static class ChequeTransaction
```
Represents a cheque transaction with the following fields:
- `amount`: The transaction amount.
- `date`: The transaction date.

## Constants
- `VELOCITY_CHECK_DAYS`: 7 days.
- `VELOCITY_THRESHOLD`: 5 transactions.
- `PATTERN_THRESHOLD`: 95% similarity.
- `SIMILAR_AMOUNT_THRESHOLD`: 90% similarity.
- `UNUSUAL_FREQUENCY_THRESHOLD`: 3x normal frequency.

## External Dependencies
- `FraudDetection`: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activity.
- `ChequeHistoryManager`: Manages historical cheque data and provides methods for advanced fraud checks.
- `AlertLevel`: Enum representing the fraud alert levels.