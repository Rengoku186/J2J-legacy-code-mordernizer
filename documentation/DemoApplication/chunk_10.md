---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

This code chunk is part of a fraud detection system implemented in the `FraudDetectionServiceV1` class. It provides various methods to detect fraudulent activities related to cheque transactions. Below is a detailed explanation of the methods and their purposes:

## Key Methods

### `isFraudulentCheque`
This method determines whether a cheque transaction is fraudulent by performing a series of checks. It evaluates the following conditions:
- **Duplicate cheque**: Checks if the cheque has already been processed.
- **Abnormal amount**: Checks if the transaction amount is unusually high or low.
- **Suspicious activity**: Checks for suspicious patterns in the account's transaction history.
- **Velocity fraud**: Checks if the number of transactions within a short period exceeds a predefined threshold.
- **Pattern fraud**: Checks for repetitive patterns in transaction amounts.
- **Historical duplicate**: Checks if the cheque matches any previously processed cheques.
- **Unusual frequency**: Checks if the frequency of transactions is abnormally high compared to historical data.
- **Similar to recent**: Checks if the transaction amount is similar to recent transactions.

The method returns `true` if any of the above checks fail, indicating potential fraud.

### `determineAlertLevel`
This method calculates the fraud alert level based on the results of the individual checks. The alert levels are:
- **LOW**: Minimal risk.
- **MEDIUM**: Moderate risk.
- **HIGH**: High risk.
- **CRITICAL**: Severe risk.

The alert level is determined by assigning weights to each check and summing them up. A higher score indicates a higher alert level.

### `logFraudChecks`
This method logs the results of the fraud checks for a given transaction. It provides a detailed report, including:
- Account ID
- Cheque number
- Transaction amount
- Results of each fraud check
- A summary indicating whether fraud was detected

### Individual Check Methods

#### `checkDuplicateCheque`
- **Purpose**: Checks if a cheque with the same number has already been processed for the given account.
- **Implementation**: Calls the `isDuplicateCheque` method of the `FraudDetection` class.

#### `checkAbnormalAmount`
- **Purpose**: Checks if the transaction amount is abnormal.
- **Implementation**: Calls the `isAbnormalAmount` method of the `FraudDetection` class.

#### `checkSuspiciousActivity`
- **Purpose**: Checks for suspicious activity in the account.
- **Implementation**: Calls the `isSuspiciousActivity` method of the `FraudDetection` class.

#### `checkVelocityFraud`
- **Purpose**: Checks if the number of transactions within the last 7 days exceeds a predefined threshold.
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within the last 7 days.
  - Compares the count of recent transactions to the `VELOCITY_THRESHOLD`.

#### `checkPatternFraud`
- **Purpose**: Checks for repetitive patterns in transaction amounts.
- **Implementation**:
  - Analyzes the similarity of the current transaction amount with previous transactions.
  - Uses a similarity threshold (`PATTERN_THRESHOLD`) to identify patterns.

#### `checkHistoricalDuplicate`
- **Purpose**: Checks if the cheque matches any previously processed cheques for the account.
- **Implementation**: Calls the `getChequeNumbers` method of the `ChequeHistoryManager` class.

#### `checkUnusualFrequency`
- **Purpose**: Checks if the frequency of transactions is abnormally high compared to historical data.
- **Implementation**:
  - Retrieves the total and recent cheque counts from the `ChequeHistoryManager`.
  - Compares the recent cheque count to the average monthly frequency multiplied by a threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

#### `checkSimilarToRecent`
- **Purpose**: Checks if the transaction amount is similar to recent transactions.
- **Implementation**: Calls the `hasSimilarRecentCheque` method of the `ChequeHistoryManager` class.

### Helper Methods

#### `formatCheckResult`
- **Purpose**: Formats the result of a fraud check for logging purposes.
- **Implementation**: Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

### Nested Class: `ChequeTransaction`
This class represents a cheque transaction and contains the following fields:
- `amount`: The transaction amount.
- `date`: The date of the transaction.

It provides getter methods for these fields.

## External Dependencies
- **`FraudDetection`**: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activities.
- **`ChequeHistoryManager`**: Manages historical cheque data and provides methods for retrieving cheque history and frequency information.

## Constants
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity fraud detection (default: 7 days).
- `VELOCITY_THRESHOLD`: The maximum allowed number of transactions within the velocity check period (default: 5).
- `PATTERN_THRESHOLD`: The similarity threshold for pattern fraud detection (default: 95%).
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for recent transaction comparison (default: 90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for detecting unusual transaction frequency (default: 3x).

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses a combination of basic and advanced checks to identify potential fraud and assigns an alert level based on the severity of the detected issues. The system is modular, allowing for easy integration with external components like `FraudDetection` and `ChequeHistoryManager`.