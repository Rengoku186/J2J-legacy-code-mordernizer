---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_13"
confidence_score: 0.9
external_dependencies: ["historyManager", "formatCheckResult", "isDuplicate", "isAbnormal", "isSuspicious", "isVelocityFraud", "isPatternFraud", "isHistoricalDuplicate", "isUnusualFrequency", "isSimilarToRecent"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a fraud detection system. It performs a series of checks to identify potential fraudulent activities related to cheque transactions. The checks are divided into two categories: **Basic Checks** and **Advanced Checks**. A summary is then printed to indicate whether any fraud was detected.

## Key Components

### Basic Checks
The following checks are performed as part of the basic fraud detection:

1. **Duplicate Check**: Determines if the cheque is a duplicate.
2. **Abnormal Amount Check**: Checks if the cheque amount exceeds a predefined threshold.
3. **Suspicious Activity Check**: Identifies if the account activity is suspicious based on predefined rules.
4. **Velocity Check**: Detects rapid transactions that may indicate fraudulent behavior.
5. **Pattern Analysis**: Analyzes transaction patterns to identify anomalies.

### Advanced Checks
If the `historyManager` object is not null, additional advanced checks are performed:

1. **Historical Duplicate Check**: Checks if the cheque matches any historical duplicates.
2. **Unusual Frequency Check**: Identifies unusual transaction frequencies.
3. **Similar Recent Amount Check**: Compares the cheque amount with recent transactions to find similarities.

### Fraud Detection Summary
After performing the checks, the system evaluates whether any fraud was detected. If any of the checks fail, a fraud alert is printed. Otherwise, a message indicating no fraud is displayed.

## Methods

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed) {
    return failed ? "FAILED ⚠️" : "Passed ✓";
}
```
This method formats the result of a check. If the check fails (`failed` is `true`), it returns "FAILED ⚠️". Otherwise, it returns "Passed ✓".

### External Dependencies

#### `historyManager`
The `historyManager` object is used to perform advanced checks. It provides methods to retrieve historical cheque data and analyze transaction patterns.

#### Fraud Detection Methods
The following methods are used to perform the checks:
- `isDuplicate`: Checks for duplicate cheques.
- `isAbnormal`: Checks for abnormal cheque amounts.
- `isSuspicious`: Identifies suspicious account activity.
- `isVelocityFraud`: Detects rapid transactions.
- `isPatternFraud`: Analyzes transaction patterns.
- `isHistoricalDuplicate`: Checks for historical duplicates.
- `isUnusualFrequency`: Identifies unusual transaction frequencies.
- `isSimilarToRecent`: Compares the cheque amount with recent transactions.

## Summary
This code chunk is a critical part of the fraud detection system, providing both basic and advanced checks to identify potential fraudulent activities. The results of these checks are formatted and displayed to the user, along with a summary indicating whether any fraud was detected.