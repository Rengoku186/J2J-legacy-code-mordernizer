---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_12"
confidence_score: 0.85
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# FraudDetectionServiceV2 Class

The `FraudDetectionServiceV2` class is a service designed to detect fraudulent cheque activities. It implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` to analyze historical cheque data. This class is part of a larger system for managing and analyzing cheque transactions.

## Fields

### Private Fields

- **fraudDetection**: An instance of the `FraudDetection` class, used to perform core fraud detection operations such as checking for duplicate cheques, abnormal amounts, and suspicious activities.
- **historyManager**: An instance of the `ChequeHistoryManager` class, used to retrieve historical cheque data for fraud analysis.
- **recentTransactions**: A `Map<String, List<ChequeTransaction>>` that stores recent cheque transactions for each account.
- **duplicateChequeCounter**: A `Map<String, Integer>` that tracks the count of duplicate cheques for each account.
- **abnormalAmounts**: A `Map<String, List<Double>>` that stores abnormal cheque amounts for each account.
- **suspiciousAmounts**: A `Map<String, List<Double>>` that stores suspicious cheque amounts for each account.
- **velocityAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for velocity-based fraud detection.
- **patternAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for pattern-based fraud detection.
- **historicalDuplicateAmounts**: A `Map<String, List<Double>>` that tracks historical duplicate cheque amounts.
- **unusualFrequencyAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts with unusual frequency.
- **similarToRecentAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts similar to recent transactions.
- **fraudLogs**: A `List<String>` that stores logs of fraud detection activities.
- **totalFraudChecks**: An integer counter for the total number of fraud checks performed.

### Constants

- **VELOCITY_CHECK_DAYS**: The number of days to consider for velocity-based fraud detection (7 days).
- **VELOCITY_THRESHOLD**: The maximum number of transactions allowed within the velocity check period (5 transactions).
- **PATTERN_THRESHOLD**: The similarity threshold for pattern-based fraud detection (95%).
- **SIMILAR_AMOUNT_THRESHOLD**: The similarity threshold for detecting amounts similar to recent transactions (90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: The multiplier for detecting unusual frequency of transactions (3x normal frequency).

## Methods

### Constructor

- **FraudDetectionServiceV2()**: Initializes the service with default values and data structures. It also creates an instance of the `FraudDetection` class.

### Public Methods

- **setHistoryManager(ChequeHistoryManager historyManager)**: Sets the `ChequeHistoryManager` instance for the service.
- **isFraudulentCheque(String accountId, String chequeNumber, double amount)**: Determines if a cheque is fraudulent by performing various checks, including:
  - Duplicate cheque detection
  - Abnormal amount detection
  - Suspicious activity detection
  - Velocity-based fraud detection
  - Pattern-based fraud detection
  - Historical duplicate detection (if `historyManager` is set)
  - Unusual frequency detection (if `historyManager` is set)
  - Similar-to-recent detection (if `historyManager` is set)

  Returns `true` if any of the checks indicate fraud, otherwise returns `false`.

### Private Methods

- **checkDuplicateCheque(String accountId, String chequeNumber)**: Checks if a cheque is a duplicate using the `FraudDetection` instance.
- **checkAbnormalAmount(double amount)**: Checks if the cheque amount is abnormal using the `FraudDetection` instance.
- **checkSuspiciousActivity(String accountId, double amount)**: Checks for suspicious activity using the `FraudDetection` instance.
- **checkVelocityFraud(String accountId, double amount)**: Checks for velocity-based fraud by analyzing the number of transactions within the last 7 days.
- **checkPatternFraud(String accountId, double amount)**: Checks for pattern-based fraud by analyzing the similarity of the current cheque amount to previous transactions.
- **checkHistoricalDuplicate(String accountId, String chequeNumber)**: Checks for historical duplicates using the `ChequeHistoryManager` instance.
- **checkUnusualFrequency(String accountId)**: Checks for unusual frequency of transactions using the `ChequeHistoryManager` instance.
- **checkSimilarToRecent(String accountId, double amount)**: Checks if the cheque amount is similar to recent transactions using the `ChequeHistoryManager` instance.
- **determineAlertLevel(...)**: Determines the fraud alert level (LOW, MEDIUM, HIGH, CRITICAL) based on the results of the fraud checks.
- **logFraudChecks(...)**: Logs the results of the fraud checks for auditing and debugging purposes.

## Enums

- **AlertLevel**: Represents the severity of a fraud alert. Possible values are:
  - `LOW`
  - `MEDIUM`
  - `HIGH`
  - `CRITICAL`

## External Dependencies

- **FraudDetection**: Used for core fraud detection operations.
- **ChequeHistoryManager**: Used for retrieving historical cheque data.
- **ChequeTransaction**: Represents a cheque transaction, including details like amount and date.

## Notes

This class is a critical component of the fraud detection system. It combines real-time and historical data analysis to identify potentially fraudulent cheque activities. The integration with `ChequeHistoryManager` enhances its capabilities by allowing it to analyze historical trends and patterns.