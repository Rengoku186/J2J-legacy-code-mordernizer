---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

## Overview
This code chunk is part of a fraud detection system implemented in the `FraudDetectionServiceV1` class. It provides various methods to detect fraudulent activities related to cheque transactions. The system evaluates multiple fraud indicators, such as duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions. Based on these checks, it determines an alert level and logs the results.

## Key Components

### 1. **Fraud Detection Methods**
The following methods are used to detect specific types of fraud:

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
- **Purpose**: Checks if a cheque is a duplicate.
- **Implementation**: Delegates the check to the `FraudDetection` class.

#### `checkAbnormalAmount(double amount)`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Implementation**: Delegates the check to the `FraudDetection` class.

#### `checkSuspiciousActivity(String accountId, double amount)`
- **Purpose**: Checks for suspicious activity based on the account ID and amount.
- **Implementation**: Delegates the check to the `FraudDetection` class.

#### `checkVelocityFraud(String accountId, double amount)`
- **Purpose**: Detects if there are too many transactions within a short period (velocity fraud).
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within the last 7 days (`VELOCITY_CHECK_DAYS`).
  - Counts the number of recent transactions and compares it to a threshold (`VELOCITY_THRESHOLD`).
  - Cleans up old transactions to optimize memory usage.

#### `checkPatternFraud(String accountId, double amount)`
- **Purpose**: Detects if the current transaction follows a suspicious pattern of similar amounts.
- **Implementation**:
  - Retrieves recent transactions for the account.
  - Compares the current amount with past amounts to calculate similarity.
  - Flags fraud if at least three past transactions have a similarity above the `PATTERN_THRESHOLD` (95%).

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
- **Purpose**: Checks if the cheque number exists in the historical records.
- **Implementation**: Uses the `ChequeHistoryManager` class to retrieve historical cheque numbers for the account.

#### `checkUnusualFrequency(String accountId)`
- **Purpose**: Detects if the frequency of recent transactions is unusually high.
- **Implementation**:
  - Retrieves the total and recent cheque counts for the account from the `ChequeHistoryManager`.
  - Compares the recent cheque count to the average monthly frequency multiplied by the `UNUSUAL_FREQUENCY_THRESHOLD` (3x).

#### `checkSimilarToRecent(String accountId, double amount)`
- **Purpose**: Checks if the current transaction amount is similar to recent transactions.
- **Implementation**: Uses the `ChequeHistoryManager` class to compare the current amount with recent cheque amounts based on a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### 2. **Alert Level Determination**
#### `determineAlertLevel(...)`
- **Purpose**: Determines the fraud alert level based on the results of the individual fraud checks.
- **Implementation**:
  - Assigns weights to each fraud indicator.
  - Calculates a total fraud score.
  - Returns an alert level (`LOW`, `MEDIUM`, `HIGH`, or `CRITICAL`) based on the score.

### 3. **Logging Fraud Checks**
#### `logFraudChecks(...)`
- **Purpose**: Logs the results of all fraud checks for a given transaction.
- **Implementation**:
  - Prints a detailed report of the fraud checks, including basic and advanced checks.
  - Summarizes whether any fraud was detected.

### 4. **Helper Methods and Classes**
#### `formatCheckResult(boolean failed)`
- **Purpose**: Formats the result of a fraud check for logging.
- **Output**: Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

#### `ChequeTransaction` (Inner Class)
- **Purpose**: Represents a cheque transaction with an amount and date.
- **Fields**:
  - `double amount`: The amount of the cheque.
  - `java.time.LocalDate date`: The date of the transaction.
- **Methods**:
  - `getAmount()`: Returns the amount of the transaction.
  - `getDate()`: Returns the date of the transaction.

## External Dependencies

### 1. **FraudDetection**
- A class used to perform basic fraud checks such as detecting duplicate cheques, abnormal amounts, and suspicious activities.

### 2. **ChequeHistoryManager**
- A class used to manage historical cheque data and perform advanced fraud checks, such as detecting historical duplicates, unusual frequencies, and similar recent transactions.

## Constants
- `VELOCITY_CHECK_DAYS`: Number of days to consider for velocity fraud detection (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).
- `PATTERN_THRESHOLD`: Similarity threshold for pattern fraud detection (95%).
- `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent transaction amounts (90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for detecting unusual frequency (3x).

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses a combination of basic and advanced checks to identify potential fraud and assigns an appropriate alert level based on the severity of the detected issues. The system also logs detailed reports of the checks performed, making it easier to audit and analyze fraud detection results.