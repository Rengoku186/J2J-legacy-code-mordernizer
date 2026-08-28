---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_11"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Fraud Detection Methods in `DemoApplication`

## Overview
This section of the code implements a comprehensive fraud detection mechanism for cheque transactions. It evaluates multiple criteria to determine whether a cheque is potentially fraudulent. The main method, `isFraudulentCheque`, orchestrates the fraud detection process by invoking various helper methods that perform specific checks.

## Key Methods

### `isFraudulentCheque`
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount)
```
This is the main method that determines whether a cheque is fraudulent. It performs the following checks:

1. **Duplicate Check**: Verifies if the cheque has already been processed.
2. **Abnormal Amount Check**: Checks if the cheque amount is unusually high or low.
3. **Suspicious Activity Check**: Detects any suspicious activity associated with the account.
4. **Velocity Fraud Check**: Ensures that the number of transactions within a specific time frame does not exceed a predefined threshold.
5. **Pattern Fraud Check**: Identifies patterns in transaction amounts that may indicate fraud.
6. **Historical Duplicate Check**: Checks if the cheque matches any previously processed cheques for the account.
7. **Unusual Frequency Check**: Evaluates if the frequency of transactions is abnormal compared to historical data.
8. **Similar Recent Amount Check**: Compares the cheque amount with recent transactions to identify similarities.

The method logs the results of these checks and determines an overall fraud alert level using the `determineAlertLevel` method. It returns `true` if any of the checks indicate potential fraud.

### `checkDuplicateCheque`
```java
private boolean checkDuplicateCheque(String accountId, String chequeNumber)
```
Checks if the given cheque number has already been processed for the specified account. This is done using the `FraudDetection` service.

### `checkAbnormalAmount`
```java
private boolean checkAbnormalAmount(double amount)
```
Determines if the cheque amount is abnormal by consulting the `FraudDetection` service.

### `checkSuspiciousActivity`
```java
private boolean checkSuspiciousActivity(String accountId, double amount)
```
Checks for suspicious activity related to the account and amount using the `FraudDetection` service.

### `checkVelocityFraud`
```java
private boolean checkVelocityFraud(String accountId, double amount)
```
Analyzes the frequency of transactions for the account within a specific time frame. If the number of transactions exceeds a predefined threshold (`VELOCITY_THRESHOLD`), it flags the account for velocity fraud.

### `checkPatternFraud`
```java
private boolean checkPatternFraud(String accountId, double amount)
```
Identifies patterns in transaction amounts. If the number of similar transactions exceeds a threshold (`PATTERN_THRESHOLD`), it flags the account for pattern fraud.

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
Checks if the cheque number matches any historical records for the account. This is done using the `ChequeHistoryManager`.

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
Evaluates the frequency of transactions for the account. If the recent transaction frequency significantly exceeds the historical average, it flags the account for unusual frequency.

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
Compares the cheque amount with recent transactions to identify similarities. If the similarity exceeds a threshold (`SIMILAR_AMOUNT_THRESHOLD`), it flags the account.

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
Determines the overall fraud alert level based on the results of the individual checks. The alert levels are:
- **CRITICAL**: High likelihood of fraud.
- **HIGH**: Moderate likelihood of fraud.
- **MEDIUM**: Low likelihood of fraud.
- **LOW**: Minimal likelihood of fraud.

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
Logs the results of all fraud checks for auditing and debugging purposes. The log includes a summary indicating whether any fraud was detected.

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed)
```
Formats the result of a fraud check for logging purposes. Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

### `ChequeTransaction` (Inner Class)
```java
private static class ChequeTransaction
```
Represents a single cheque transaction with the following fields:
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

## External Dependencies

### `FraudDetection`
A service used to perform basic fraud detection checks such as duplicate cheques, abnormal amounts, and suspicious activities.

### `ChequeHistoryManager`
Manages historical cheque data and provides methods to retrieve historical records for fraud detection.

### `AlertLevel`
An enumeration or class that defines the various levels of fraud alerts (e.g., CRITICAL, HIGH, MEDIUM, LOW).