---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Logic in `DemoApplication`

This chunk of code is part of a fraud detection service implemented in the `DemoApplication.java` file. It defines various methods and logic to detect fraudulent cheque activities based on multiple criteria. Below is a detailed explanation of the code:

## Purpose
The primary purpose of this code is to evaluate whether a cheque transaction is fraudulent by performing a series of checks. These checks include duplicate detection, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions. Based on the results of these checks, an alert level is determined, and a fraud report is generated.

## Key Components

### 1. `isFraudulentCheque`
This method is the main entry point for fraud detection. It takes the following parameters:
- `accountId`: The account ID associated with the cheque.
- `chequeNumber`: The cheque number.
- `amount`: The amount of the cheque.

It performs the following checks:
- **Duplicate Cheque Check**: Calls `checkDuplicateCheque` to determine if the cheque is a duplicate.
- **Abnormal Amount Check**: Calls `checkAbnormalAmount` to check if the amount is abnormal.
- **Suspicious Activity Check**: Calls `checkSuspiciousActivity` to detect suspicious activity.
- **Velocity Fraud Check**: Calls `checkVelocityFraud` to detect rapid transactions.
- **Pattern Fraud Check**: Calls `checkPatternFraud` to identify patterns in transaction amounts.
- **Historical Duplicate Check**: Calls `checkHistoricalDuplicate` if a `ChequeHistoryManager` is set.
- **Unusual Frequency Check**: Calls `checkUnusualFrequency` if a `ChequeHistoryManager` is set.
- **Similarity to Recent Transactions Check**: Calls `checkSimilarToRecent` if a `ChequeHistoryManager` is set.

The method then determines the fraud alert level using the `determineAlertLevel` method and logs the results using the `logFraudChecks` method.

### 2. Fraud Detection Methods

#### `checkDuplicateCheque`
Checks if the given cheque number has already been used for the specified account. It uses the `FraudDetection` class to perform this check.

#### `checkAbnormalAmount`
Checks if the cheque amount is abnormally high or low using the `FraudDetection` class.

#### `checkSuspiciousActivity`
Checks for suspicious activity based on the account ID and cheque amount using the `FraudDetection` class.

#### `checkVelocityFraud`
Detects rapid transactions within a specified time frame (`VELOCITY_CHECK_DAYS`). If the number of transactions exceeds the `VELOCITY_THRESHOLD`, it flags the account for velocity fraud.

#### `checkPatternFraud`
Analyzes recent transactions for patterns in amounts. If three or more transactions have a similarity score greater than `PATTERN_THRESHOLD`, it flags the account for pattern fraud.

#### `checkHistoricalDuplicate`
Checks if the cheque number exists in the historical records of the account using the `ChequeHistoryManager` class.

#### `checkUnusualFrequency`
Compares the recent cheque frequency with the average monthly frequency. If the recent frequency exceeds the average by a factor of `UNUSUAL_FREQUENCY_THRESHOLD`, it flags the account for unusual frequency.

#### `checkSimilarToRecent`
Checks if the cheque amount is similar to recent transactions using a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### 3. `determineAlertLevel`
Determines the fraud alert level based on the results of the checks. The alert levels are:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

The alert level is determined by assigning weights to each type of fraud and summing them up.

### 4. `logFraudChecks`
Logs the results of all fraud checks and provides a summary indicating whether any fraud was detected.

### 5. `ChequeTransaction` Class
A helper class that represents a cheque transaction with the following fields:
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

### 6. External Dependencies
- **`FraudDetection`**: A service used to perform basic fraud checks like duplicate cheques, abnormal amounts, and suspicious activity.
- **`ChequeHistoryManager`**: A service used to manage and query historical cheque data.

### Constants
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity fraud detection.
- `VELOCITY_THRESHOLD`: The maximum number of transactions allowed within the velocity check period.
- `PATTERN_THRESHOLD`: The similarity threshold for pattern fraud detection.
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for recent transaction comparison.
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for detecting unusual frequency.

## Summary
This code provides a comprehensive framework for detecting fraudulent cheque activities. It integrates multiple detection mechanisms and uses external services (`FraudDetection` and `ChequeHistoryManager`) to enhance its capabilities. The results of the checks are logged, and an appropriate alert level is determined to indicate the severity of the detected fraud.