---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_12"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# FraudDetectionServiceV2 Class Documentation

## Overview
The `FraudDetectionServiceV2` class is a service designed to detect fraudulent cheque activities. It implements various fraud detection mechanisms and integrates with the `ChequeHistoryManager` to analyze historical cheque data. The class uses multiple strategies to identify potential fraud, such as detecting duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, and pattern-based fraud.

## Fields

### Fraud Detection Components
- **fraudDetection**: An instance of the `FraudDetection` class, which provides methods for detecting specific types of fraud (e.g., duplicate cheques, abnormal amounts, suspicious activities).
- **historyManager**: An instance of the `ChequeHistoryManager` class, used to retrieve historical cheque data for fraud analysis.

### Data Structures
- **recentTransactions**: A map that stores recent cheque transactions for each account.
- **duplicateChequeCounter**: A map that tracks the count of duplicate cheques for each account.
- **abnormalAmounts**: A map that stores abnormal cheque amounts for each account.
- **suspiciousAmounts**: A map that stores suspicious cheque amounts for each account.
- **velocityAmounts**: A map that tracks cheque amounts for velocity fraud detection.
- **patternAmounts**: A map that tracks cheque amounts for pattern-based fraud detection.
- **historicalDuplicateAmounts**: A map that tracks historical duplicate cheque amounts.
- **unusualFrequencyAmounts**: A map that tracks cheque amounts with unusual frequency.
- **similarToRecentAmounts**: A map that tracks cheque amounts similar to recent transactions.
- **fraudLogs**: A list of strings used to log fraud detection activities.
- **totalFraudChecks**: An integer counter for the total number of fraud checks performed.

### Fraud Detection Thresholds
- **VELOCITY_CHECK_DAYS**: The number of days to consider for velocity fraud detection (default: 7 days).
- **VELOCITY_THRESHOLD**: The maximum number of transactions allowed within the velocity check period (default: 5 transactions).
- **PATTERN_THRESHOLD**: The similarity threshold for pattern-based fraud detection (default: 95%).
- **SIMILAR_AMOUNT_THRESHOLD**: The similarity threshold for detecting amounts similar to recent transactions (default: 90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: The multiplier for detecting unusual frequency of transactions (default: 3x normal frequency).

### Fraud Alert Levels
The `AlertLevel` enum defines the levels of fraud alerts:
- **LOW**
- **MEDIUM**
- **HIGH**
- **CRITICAL**

## Constructor

### FraudDetectionServiceV2()
Initializes the `FraudDetectionServiceV2` instance and its internal data structures.

## Methods

### setHistoryManager(ChequeHistoryManager historyManager)
Sets the `ChequeHistoryManager` instance for retrieving historical cheque data.

### isFraudulentCheque(String accountId, String chequeNumber, double amount)
Performs a comprehensive fraud check for a given cheque. It evaluates multiple fraud detection criteria and determines the fraud alert level.

#### Parameters:
- **accountId**: The account ID associated with the cheque.
- **chequeNumber**: The cheque number.
- **amount**: The cheque amount.

#### Returns:
- **boolean**: `true` if the cheque is fraudulent, `false` otherwise.

### Private Helper Methods

#### checkDuplicateCheque(String accountId, String chequeNumber)
Checks if the cheque is a duplicate using the `FraudDetection` class.

#### checkAbnormalAmount(double amount)
Checks if the cheque amount is abnormal using the `FraudDetection` class.

#### checkSuspiciousActivity(String accountId, double amount)
Checks for suspicious activity using the `FraudDetection` class.

#### checkVelocityFraud(String accountId, double amount)
Detects velocity fraud by analyzing the frequency of recent transactions for the account.

#### checkPatternFraud(String accountId, double amount)
Detects pattern-based fraud by analyzing the similarity of recent transaction amounts.

#### checkHistoricalDuplicate(String accountId, String chequeNumber)
Checks for historical duplicate cheques using the `ChequeHistoryManager`.

#### checkUnusualFrequency(String accountId)
Detects unusual frequency of transactions using the `ChequeHistoryManager`.

#### checkSimilarToRecent(String accountId, double amount)
Checks if the cheque amount is similar to recent transactions using the `ChequeHistoryManager`.

#### determineAlertLevel(...)
Determines the fraud alert level based on the results of various fraud checks.

#### logFraudChecks(...)
Logs the results of the fraud checks for a given cheque.

## External Dependencies

### FraudDetection
A class that provides methods for detecting specific types of fraud. The exact implementation is not provided in the current context.

### ChequeHistoryManager
A mock implementation for managing historical cheque data. It provides methods to record and retrieve cheque history.

### ChequeTransaction
A class representing a cheque transaction. The exact implementation is not provided in the current context.

## Notes
- The `FraudDetection` and `ChequeTransaction` classes are not fully defined in the provided code or search results. Their functionality is inferred based on their usage in the `FraudDetectionServiceV2` class.
- The `ChequeHistoryManager` is a mock implementation that stores and retrieves cheque history for fraud analysis.