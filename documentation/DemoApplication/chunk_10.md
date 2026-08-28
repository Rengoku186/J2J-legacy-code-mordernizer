---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

## Overview
This code chunk is part of a fraud detection system implemented in the `FraudDetectionServiceV1` class. It contains methods to evaluate various fraud detection criteria for cheque transactions, determine the alert level based on the results, and log the findings. The system uses external dependencies such as `FraudDetection` and `ChequeHistoryManager` to perform specific checks.

## Key Components

### 1. **Fraud Detection Methods**
The following methods evaluate specific fraud detection criteria:

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
- **Purpose**: Checks if a cheque is a duplicate.
- **Implementation**: Delegates the check to the `FraudDetection` class via the `isDuplicateCheque` method.

#### `checkAbnormalAmount(double amount)`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Implementation**: Uses the `FraudDetection` class's `isAbnormalAmount` method.

#### `checkSuspiciousActivity(String accountId, double amount)`
- **Purpose**: Checks for suspicious activity based on the account ID and amount.
- **Implementation**: Uses the `FraudDetection` class's `isSuspiciousActivity` method.

#### `checkVelocityFraud(String accountId, double amount)`
- **Purpose**: Detects velocity fraud by analyzing the frequency of recent transactions.
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within the last 7 days (`VELOCITY_CHECK_DAYS`).
  - Compares the count of recent transactions against a threshold (`VELOCITY_THRESHOLD`).

#### `checkPatternFraud(String accountId, double amount)`
- **Purpose**: Detects pattern fraud by analyzing the similarity of recent transaction amounts.
- **Implementation**:
  - Compares the current amount with recent transaction amounts.
  - Uses a similarity threshold (`PATTERN_THRESHOLD`) to identify patterns.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
- **Purpose**: Checks if the cheque number exists in the account's historical records.
- **Implementation**: Uses the `ChequeHistoryManager` class's `getChequeNumbers` method.

#### `checkUnusualFrequency(String accountId)`
- **Purpose**: Detects unusual cheque frequency compared to historical data.
- **Implementation**:
  - Retrieves total and recent cheque counts using `ChequeHistoryManager`.
  - Compares recent cheque frequency against a threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

#### `checkSimilarToRecent(String accountId, double amount)`
- **Purpose**: Checks if the cheque amount is similar to recent amounts.
- **Implementation**: Uses the `ChequeHistoryManager` class's `hasSimilarRecentCheque` method with a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### 2. **Alert Level Determination**
#### `determineAlertLevel(...)`
- **Purpose**: Determines the fraud alert level based on the results of the fraud checks.
- **Implementation**:
  - Assigns weights to each fraud type.
  - Calculates a cumulative fraud score.
  - Returns an alert level (`LOW`, `MEDIUM`, `HIGH`, or `CRITICAL`) based on the score.

### 3. **Logging Fraud Checks**
#### `logFraudChecks(...)`
- **Purpose**: Logs the results of all fraud checks for a given transaction.
- **Implementation**:
  - Prints a detailed report of the fraud checks and their results.
  - Summarizes whether any fraud was detected.

### 4. **Helper Methods**
#### `formatCheckResult(boolean failed)`
- **Purpose**: Formats the result of a fraud check for logging.
- **Implementation**: Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

### 5. **Internal Class: `ChequeTransaction`**
- **Purpose**: Represents a cheque transaction with an amount and date.
- **Fields**:
  - `double amount`: The transaction amount.
  - `java.time.LocalDate date`: The transaction date.
- **Methods**:
  - `getAmount()`: Returns the transaction amount.
  - `getDate()`: Returns the transaction date.

## External Dependencies

### 1. **FraudDetection**
- Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activities.

### 2. **ChequeHistoryManager**
- Manages historical cheque data and provides methods to retrieve cheque numbers, total cheque counts, and recent cheque counts.

## Constants
- `VELOCITY_CHECK_DAYS`: Number of days to consider for velocity fraud detection (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).
- `PATTERN_THRESHOLD`: Similarity threshold for pattern fraud detection (95%).
- `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent cheque amount comparison (90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for detecting unusual cheque frequency (3x).

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses a combination of basic and advanced checks to identify potential fraud and assigns an appropriate alert level based on the results. The system is modular, with each fraud detection criterion implemented as a separate method, and it leverages external dependencies for historical data and specific fraud checks.