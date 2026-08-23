---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_25"
confidence_score: 0.9
external_dependencies: ["java.time.LocalDate", "java.util.HashMap", "java.util.List", "java.util.ArrayList", "java.util.Map"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a fraud detection system for cheque transactions. It performs various checks to identify potential fraudulent activities, such as duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, and pattern analysis. Additionally, if a `ChequeHistoryManager` is available, it performs advanced checks like historical duplicate detection, unusual frequency checks, and similarity to recent transactions.

The code also includes a helper method for formatting check results and a nested class `ChequeTransaction` to represent individual cheque transactions. Furthermore, it defines a `FraudDetectionServiceV2` class that encapsulates the logic for detecting fraudulent cheque activities.

---

## Code Details

### Fraud Detection Checks
The code performs the following checks:

1. **Basic Checks:**
   - **Duplicate Check:** Verifies if the cheque is a duplicate.
   - **Abnormal Amount Check:** Checks if the cheque amount is abnormal.
   - **Suspicious Activity Check:** Identifies suspicious activities related to the cheque.
   - **Velocity Check:** Determines if there are too many transactions within a short period.
   - **Pattern Analysis:** Checks for patterns in transaction amounts that may indicate fraud.

2. **Advanced Checks (if `historyManager` is available):**
   - **Historical Duplicate Check:** Verifies if the cheque number has been used in the past.
   - **Unusual Frequency Check:** Checks if the frequency of transactions is unusually high compared to historical data.
   - **Similar Recent Amount Check:** Determines if the cheque amount is similar to recent transactions.

### Fraud Summary
After performing the checks, the code determines if any fraud has been detected. If any of the checks fail, a fraud alert is raised; otherwise, it confirms that no fraud has been detected.

### Helper Method: `formatCheckResult`
This private method formats the result of a fraud check for display purposes.

#### Method Signature
```java
private String formatCheckResult(boolean failed)
```

#### Parameters
- `failed` (boolean): Indicates whether the check failed.

#### Returns
- A string indicating the result of the check:
  - "FAILED ⚠️" if the check failed.
  - "Passed ✓" if the check passed.

### Nested Class: `ChequeTransaction`
This private static class represents a cheque transaction with an amount and a date.

#### Constructor
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```
- `amount` (double): The amount of the cheque.
- `date` (LocalDate): The date of the cheque transaction.

#### Methods
- `getAmount()`: Returns the amount of the cheque.
- `getDate()`: Returns the date of the cheque transaction.

### Class: `FraudDetectionServiceV2`
This class implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` for advanced checks.

#### Fields
- `fraudDetection`: An instance of the `FraudDetection` class used for performing basic fraud checks.
- `historyManager`: An optional `ChequeHistoryManager` instance for advanced checks.
- Various `Map` objects to store transaction data for different types of fraud checks.
- `fraudLogs`: A list to store logs of detected frauds.
- `totalFraudChecks`: A counter for the total number of fraud checks performed.

#### Fraud Detection Thresholds
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity checks (default: 7 days).
- `VELOCITY_THRESHOLD`: The maximum number of transactions allowed within the velocity check period (default: 5).
- `PATTERN_THRESHOLD`: The similarity threshold for pattern analysis (default: 95%).
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for recent amounts (default: 90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for determining unusual frequency (default: 3x).

#### Fraud Alert Levels
The `AlertLevel` enum defines the severity of detected fraud:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

#### Constructor
The class provides two constructors:
1. Default constructor: Initializes all fields with default values.
2. Parameterized constructor: Accepts a `ChequeHistoryManager` instance for advanced checks.

#### Methods
- `isFraudulentCheque(String accountId, String chequeNumber, double amount)`: Main method to determine if a cheque is fraudulent. It performs all basic and advanced checks and logs the results.
- `checkDuplicateCheque(String accountId, String chequeNumber)`: Checks for duplicate cheques.
- `checkAbnormalAmount(double amount)`: Checks if the cheque amount is abnormal.
- `checkSuspiciousActivity(String accountId, double amount)`: Identifies suspicious activities.
- `checkVelocityFraud(String accountId, double amount)`: Checks for a high frequency of transactions within a short period.
- `checkPatternFraud(String accountId, double amount)`: Analyzes patterns in transaction amounts.
- `checkHistoricalDuplicate(String accountId, String chequeNumber)`: Checks for historical duplicates using `ChequeHistoryManager`.
- `checkUnusualFrequency(String accountId)`: Checks for unusual transaction frequency using `ChequeHistoryManager`.
- `checkSimilarToRecent(String accountId, double amount)`: Checks if the cheque amount is similar to recent transactions.

---

## External Dependencies
- `java.time.LocalDate`: Used for handling dates in cheque transactions.
- `java.util.HashMap`, `java.util.List`, `java.util.ArrayList`, `java.util.Map`: Used for storing and managing transaction data.

---

## Notes
- The `FraudDetection` and `ChequeHistoryManager` classes are external dependencies and are not defined in this code chunk. Their methods are used for performing specific fraud checks.
- The `formatCheckResult` method is used extensively to format the results of the fraud checks for display purposes.
- The `ChequeTransaction` class is a utility class for representing individual cheque transactions with an amount and a date.