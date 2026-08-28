---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_12"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# FraudDetectionServiceV2 Class

The `FraudDetectionServiceV2` class is a service designed to detect fraudulent cheque activities. It implements various fraud detection mechanisms and integrates with the `ChequeHistoryManager` class to analyze historical cheque data. This class is part of a larger system for managing and detecting fraudulent financial transactions.

## Fields

- **fraudDetection**: An instance of the `FraudDetection` class, which provides methods for detecting specific types of fraud, such as duplicate cheques and abnormal amounts.
- **historyManager**: An instance of the `ChequeHistoryManager` class, used to retrieve historical cheque data for fraud detection.
- **recentTransactions**: A `Map<String, List<ChequeTransaction>>` that stores recent cheque transactions for each account.
- **duplicateChequeCounter**: A `Map<String, Integer>` that tracks the count of duplicate cheques for each account.
- **abnormalAmounts**: A `Map<String, List<Double>>` that stores abnormal cheque amounts for each account.
- **suspiciousAmounts**: A `Map<String, List<Double>>` that stores suspicious cheque amounts for each account.
- **velocityAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for velocity checks.
- **patternAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for pattern analysis.
- **historicalDuplicateAmounts**: A `Map<String, List<Double>>` that stores historical duplicate cheque amounts.
- **unusualFrequencyAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for unusual frequency checks.
- **similarToRecentAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts similar to recent transactions.
- **fraudLogs**: A `List<String>` that stores logs of fraud detection activities.
- **totalFraudChecks**: An integer counter for the total number of fraud checks performed.

### Fraud Detection Thresholds

- **VELOCITY_CHECK_DAYS**: The number of days to consider for velocity checks (default: 7 days).
- **VELOCITY_THRESHOLD**: The maximum number of transactions allowed within the velocity check period (default: 5 transactions).
- **PATTERN_THRESHOLD**: The similarity threshold for pattern analysis (default: 95%).
- **SIMILAR_AMOUNT_THRESHOLD**: The similarity threshold for comparing amounts to recent transactions (default: 90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: The multiplier for detecting unusual frequency (default: 3x normal frequency).

### Fraud Alert Levels

The `AlertLevel` enum defines the severity of fraud alerts:
- **LOW**
- **MEDIUM**
- **HIGH**
- **CRITICAL**

## Constructor

### `FraudDetectionServiceV2()`
Initializes the `FraudDetectionServiceV2` instance and its internal data structures.

## Methods

### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `ChequeHistoryManager` instance for retrieving historical cheque data.

### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Performs a comprehensive fraud check on a cheque. It evaluates multiple fraud detection mechanisms, including:
- Duplicate cheque detection
- Abnormal amount detection
- Suspicious activity detection
- Velocity fraud detection
- Pattern fraud detection
- Historical duplicate detection (if `historyManager` is set)
- Unusual frequency detection (if `historyManager` is set)
- Similarity to recent transactions (if `historyManager` is set)

Returns `true` if any fraud mechanism detects fraudulent activity; otherwise, returns `false`.

### `checkDuplicateCheque(String accountId, String chequeNumber)`
Checks if the cheque is a duplicate using the `FraudDetection` class.

### `checkAbnormalAmount(double amount)`
Checks if the cheque amount is abnormal using the `FraudDetection` class.

### `checkSuspiciousActivity(String accountId, double amount)`
Checks for suspicious activity based on the account ID and cheque amount using the `FraudDetection` class.

### `checkVelocityFraud(String accountId, double amount)`
Detects velocity fraud by analyzing the number of transactions within the last `VELOCITY_CHECK_DAYS` days. If the number of transactions exceeds `VELOCITY_THRESHOLD`, it flags the account for velocity fraud.

### `checkPatternFraud(String accountId, double amount)`
Analyzes recent transactions for the account to detect patterns of similar amounts. Flags the account if at least three transactions have a similarity score above `PATTERN_THRESHOLD`.

### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Checks if the cheque number exists in the historical records of the account using the `ChequeHistoryManager` class.

### `checkUnusualFrequency(String accountId)`
Detects unusual frequency of cheque transactions by comparing the recent transaction count to the average monthly frequency, using the `ChequeHistoryManager` class.

### `checkSimilarToRecent(String accountId, double amount)`
Checks if the cheque amount is similar to recent transactions for the account using the `ChequeHistoryManager` class and the `SIMILAR_AMOUNT_THRESHOLD`.

### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of the various fraud detection mechanisms. The alert levels are determined by the number and severity of fraud indicators.

### `logFraudChecks(...)`
Logs the results of the fraud checks for a given cheque, including the account ID, cheque number, amount, and the results of each fraud detection mechanism.

## External Dependencies

- **`FraudDetection`**: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activities.
- **`ChequeHistoryManager`**: Manages historical cheque data and provides methods for retrieving cheque history and detecting historical duplicates, unusual frequencies, and similar recent transactions.
- **`ChequeTransaction`**: Represents a single cheque transaction, including details such as amount and date.