---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_24"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for `FraudDetectionServiceV1` and Related Classes

This documentation provides an overview of the `FraudDetectionServiceV1` class and its related components, as well as their purpose and functionality.

## Overview
The `FraudDetectionServiceV1` class is a service designed to detect fraudulent cheque activities. It implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` to analyze historical cheque data. The service evaluates multiple fraud detection criteria and determines the likelihood of fraudulent activity for a given cheque.

### Key Components
- **`FraudDetection`**: A dependency used for performing basic fraud detection checks such as duplicate cheques, abnormal amounts, and suspicious activities.
- **`ChequeHistoryManager`**: A dependency that provides historical cheque data for advanced fraud detection checks.
- **`ChequeTransaction`**: A nested static class representing a single cheque transaction, including its amount and date.
- **`AlertLevel`**: An enumeration representing the severity of detected fraud, with levels: `LOW`, `MEDIUM`, `HIGH`, and `CRITICAL`.

## Class: `FraudDetectionServiceV1`

### Fields
- **`fraudDetection`**: An instance of the `FraudDetection` class used for basic fraud detection checks.
- **`historyManager`**: An instance of the `ChequeHistoryManager` class used for advanced fraud detection checks.
- **`recentTransactions`**: A map storing recent cheque transactions for each account, used for velocity and pattern fraud detection.

### Constants
- **`VELOCITY_CHECK_DAYS`**: The number of days to consider for velocity fraud detection (default: 7 days).
- **`VELOCITY_THRESHOLD`**: The maximum number of cheques allowed within the velocity check period (default: 5 cheques).
- **`PATTERN_THRESHOLD`**: The similarity threshold for detecting pattern fraud (default: 95%).
- **`SIMILAR_AMOUNT_THRESHOLD`**: The similarity threshold for detecting cheques with similar amounts (default: 90%).
- **`UNUSUAL_FREQUENCY_THRESHOLD`**: The multiplier for detecting unusual cheque frequency (default: 3x normal frequency).

### Methods

#### `FraudDetectionServiceV1()`
Constructor that initializes the `fraudDetection` instance and the `recentTransactions` map.

#### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `historyManager` instance for accessing historical cheque data.

#### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Determines if a cheque is fraudulent based on various checks. Returns `true` if any of the checks indicate fraud.

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
Checks if the cheque is a duplicate using the `FraudDetection` class.

#### `checkAbnormalAmount(double amount)`
Checks if the cheque amount is abnormal using the `FraudDetection` class.

#### `checkSuspiciousActivity(String accountId, double amount)`
Checks for suspicious activity using the `FraudDetection` class.

#### `checkVelocityFraud(String accountId, double amount)`
Detects velocity fraud by analyzing the number of cheques issued within a specific time frame.

#### `checkPatternFraud(String accountId, double amount)`
Detects pattern fraud by analyzing the similarity of recent cheque amounts.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Checks if the cheque is a duplicate of any historical cheques using the `ChequeHistoryManager`.

#### `checkUnusualFrequency(String accountId)`
Detects unusual cheque frequency by comparing recent cheque activity to historical averages using the `ChequeHistoryManager`.

#### `checkSimilarToRecent(String accountId, double amount)`
Checks if the cheque amount is similar to recent cheque amounts using the `ChequeHistoryManager`.

#### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of the various fraud detection checks. Returns an `AlertLevel` value.

#### `logFraudChecks(...)`
Logs the results of all fraud detection checks for a given cheque.

## Nested Class: `ChequeTransaction`

### Fields
- **`amount`**: The amount of the cheque transaction.
- **`date`**: The date of the cheque transaction.

### Constructor
- **`ChequeTransaction(double amount, java.time.LocalDate date)`**: Initializes a new `ChequeTransaction` with the specified amount and date.

### Methods
- **`getAmount()`**: Returns the amount of the cheque transaction.
- **`getDate()`**: Returns the date of the cheque transaction.

## External Dependencies

### `FraudDetection`
The `FraudDetection` class is used to perform basic fraud detection checks. It provides methods such as `isDuplicateCheque`, `isAbnormalAmount`, and `isSuspiciousActivity`.

### `ChequeHistoryManager`
The `ChequeHistoryManager` class is a mock implementation that provides historical cheque data. It includes methods for recording and retrieving cheque history, such as `getChequeNumbers`, `getTotalChequeCount`, `getRecentChequeCount`, and `hasSimilarRecentCheque`.