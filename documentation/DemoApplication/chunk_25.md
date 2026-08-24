---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_25"
confidence_score: 0.95
external_dependencies: [java.time.LocalDate, java.util.Map, java.util.List, java.util.HashMap, java.util.ArrayList, FraudDetection, ChequeHistoryManager]
---

# Documentation for Fraud Detection Code Chunk

## Overview

This code chunk is part of a fraud detection system implemented in Java. It performs various checks to identify potential fraudulent activities related to cheque transactions. The checks are categorized into basic and advanced checks, and the results are displayed in a structured format. The code also includes a helper method for formatting the results of the checks and a nested class for representing cheque transactions.

## Code Components

### 1. **Basic Checks**
The following basic checks are performed to detect potential fraud:
- **Duplicate Check**: Verifies if the cheque is a duplicate.
- **Abnormal Amount Check**: Checks if the cheque amount is abnormal.
- **Suspicious Activity Check**: Identifies suspicious activities based on the account and amount.
- **Velocity Check**: Detects rapid transactions within a short period.
- **Pattern Analysis**: Analyzes patterns in transaction amounts.

The results of these checks are formatted using the `formatCheckResult` method and displayed in the console.

### 2. **Advanced Checks**
If a `historyManager` instance is available, the following advanced checks are performed:
- **Historical Duplicate Check**: Checks for duplicates in historical data.
- **Unusual Frequency Check**: Identifies unusual transaction frequencies.
- **Similar Recent Amount Check**: Compares the current transaction amount with recent transactions for similarity.

### 3. **Summary**
The results of all checks are aggregated to determine if any fraud is detected. A summary message is displayed in the console:
- If any fraud is detected, a "FRAUD ALERT" message is shown.
- Otherwise, a "No fraud detected" message is displayed.

### 4. **Helper Method: `formatCheckResult`**
This private method formats the result of a check for display purposes:
- Returns `"FAILED \u26A0\uFE0F"` if the check failed (i.e., fraud detected).
- Returns `"Passed \u2713"` if the check passed (i.e., no fraud detected).

#### Method Signature:
```java
private String formatCheckResult(boolean failed)
```

#### Parameters:
- `failed`: A boolean indicating whether the check failed.

#### Returns:
- A formatted string representing the result of the check.

### 5. **Nested Class: `ChequeTransaction`**
This private static class represents a cheque transaction with the following attributes:
- `amount`: The monetary value of the cheque.
- `date`: The date of the transaction.

#### Constructor:
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```

#### Methods:
- `getAmount()`: Returns the amount of the cheque.
- `getDate()`: Returns the date of the transaction.

### 6. **Fraud Detection Service**
The `FraudDetectionServiceV2` class implements various fraud detection mechanisms. It uses a `FraudDetection` instance and optionally a `ChequeHistoryManager` instance for historical data analysis.

#### Key Attributes:
- `fraudDetection`: An instance of the `FraudDetection` class.
- `historyManager`: An optional instance of the `ChequeHistoryManager` class.
- Various maps and lists to store transaction data and fraud logs.

#### Key Methods:
- `isFraudulentCheque`: Determines if a cheque is fraudulent based on various checks.
- `checkDuplicateCheque`: Checks for duplicate cheques.
- `checkAbnormalAmount`: Checks for abnormal cheque amounts.
- `checkSuspiciousActivity`: Identifies suspicious activities.
- `checkVelocityFraud`: Detects rapid transactions.
- `checkPatternFraud`: Analyzes patterns in transaction amounts.
- `checkHistoricalDuplicate`: Checks for duplicates in historical data.
- `checkUnusualFrequency`: Identifies unusual transaction frequencies.

#### Fraud Detection Thresholds:
- `VELOCITY_CHECK_DAYS`: Number of days for velocity check (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).
- `PATTERN_THRESHOLD`: Similarity threshold for pattern analysis (95%).
- `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent amounts (90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for unusual frequency detection (3x normal frequency).

#### Fraud Alert Levels:
The `AlertLevel` enum defines the severity of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## External Dependencies

### 1. **FraudDetection Class**
The `FraudDetection` class is responsible for performing the core fraud detection checks. It provides methods such as:
- `isDuplicateCheque`: Checks if a cheque is a duplicate.
- `isAbnormalAmount`: Determines if the cheque amount is abnormal.
- `isSuspiciousActivity`: Identifies suspicious activities based on account and amount.

### 2. **ChequeHistoryManager Class**
The `ChequeHistoryManager` class manages historical cheque data. It provides methods for recording and retrieving cheque history:
- `recordCheque`: Records a cheque transaction in the history.
- `displayChequeHistory`: Displays the history of cheques for a specific account.

#### Nested Class: `ChequeRecord`
Represents a record of a cheque transaction with attributes such as:
- `accountNumber`: The account number associated with the cheque.
- `chequeNumber`: The cheque number.
- `currency`: The currency of the transaction.
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

## Notes
- The `FraudDetection` and `ChequeHistoryManager` classes are integral to the fraud detection system. Their methods are used extensively for both basic and advanced checks.
- The `formatCheckResult` method and the `ChequeTransaction` class are utility components that enhance the readability and organization of the code.