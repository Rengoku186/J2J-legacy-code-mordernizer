---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_23"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Fraud Detection Service Documentation

## Overview
This chunk of code implements a fraud detection service for cheque transactions. It defines thresholds for various fraud detection mechanisms, provides methods to evaluate transactions for potential fraud, and determines the severity of detected fraud. The service also logs the results of fraud checks and categorizes the fraud into different alert levels.

## Key Components

### Fraud Detection Thresholds
The following constants define thresholds for detecting fraudulent activities:
- **VELOCITY_CHECK_DAYS**: Number of days to consider for velocity checks (default: 7 days).
- **VELOCITY_THRESHOLD**: Maximum allowed transactions within the velocity check period (default: 5 transactions).
- **PATTERN_THRESHOLD**: Similarity threshold for detecting pattern-based fraud (default: 95%).
- **SIMILAR_AMOUNT_THRESHOLD**: Similarity threshold for recent transaction amounts (default: 90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: Multiplier for detecting unusual frequency of transactions (default: 3x normal frequency).

### Fraud Alert Levels
An enumeration `AlertLevel` is defined to categorize the severity of detected fraud:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

### Constructor
```java
public FraudDetectionService()
```
Initializes the `FraudDetection` instance and a `HashMap` to store recent transactions.

### Methods

#### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `ChequeHistoryManager` instance for accessing historical cheque data.

#### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Evaluates a cheque transaction for potential fraud by performing various checks:
- Duplicate cheque detection.
- Abnormal amount detection.
- Suspicious activity detection.
- Velocity-based fraud detection.
- Pattern-based fraud detection.
- Historical duplicate detection (if `ChequeHistoryManager` is set).
- Unusual frequency detection (if `ChequeHistoryManager` is set).
- Similar recent transaction detection (if `ChequeHistoryManager` is set).

Returns `true` if any of the checks indicate fraud, otherwise returns `false`.

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
Checks if the cheque is a duplicate using the `FraudDetection` instance.

#### `checkAbnormalAmount(double amount)`
Checks if the cheque amount is abnormal using the `FraudDetection` instance.

#### `checkSuspiciousActivity(String accountId, double amount)`
Checks for suspicious activity using the `FraudDetection` instance.

#### `checkVelocityFraud(String accountId, double amount)`
Detects velocity-based fraud by analyzing the number of transactions within the last `VELOCITY_CHECK_DAYS` days. If the count exceeds `VELOCITY_THRESHOLD`, it flags the transaction as fraudulent.

#### `checkPatternFraud(String accountId, double amount)`
Analyzes recent transactions for pattern-based fraud by comparing the similarity of transaction amounts. Flags fraud if at least three transactions have a similarity above `PATTERN_THRESHOLD`.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Checks if the cheque number exists in the historical data provided by the `ChequeHistoryManager`.

#### `checkUnusualFrequency(String accountId)`
Detects unusual frequency of transactions by comparing recent transaction counts to the average monthly frequency. Flags fraud if the recent count exceeds the average by `UNUSUAL_FREQUENCY_THRESHOLD`.

#### `checkSimilarToRecent(String accountId, double amount)`
Checks if the transaction amount is similar to recent transactions using the `ChequeHistoryManager`.

#### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of various checks. The alert levels are categorized as `LOW`, `MEDIUM`, `HIGH`, or `CRITICAL` based on the severity of detected fraud.

#### `logFraudChecks(...)`
Logs the results of all fraud checks and provides a summary of whether fraud was detected.

#### `formatCheckResult(boolean failed)`
Formats the result of a fraud check for logging purposes.

### Inner Class: `ChequeTransaction`
Represents a cheque transaction with the following fields:
- `amount`: The transaction amount.
- `date`: The transaction date.

Provides getter methods for both fields.

## External Dependencies
- **FraudDetection**: Used for performing core fraud detection checks (e.g., duplicate cheque, abnormal amount, suspicious activity).
- **ChequeHistoryManager**: Provides historical data for advanced fraud checks (e.g., historical duplicates, unusual frequency, similar recent transactions).

## Usage
This service can be used in financial systems to detect and categorize fraudulent cheque transactions. It integrates with external systems for historical data and provides detailed logging for audit purposes.