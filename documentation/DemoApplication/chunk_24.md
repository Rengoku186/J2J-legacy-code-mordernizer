---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_24"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a fraud detection system implemented in Java. It includes methods and classes for detecting fraudulent cheque activities. The main components in this chunk are:

1. **Summary Output**: Prints a summary of fraud detection results.
2. **Helper Methods**: Includes utility methods for formatting results and performing specific fraud checks.
3. **`ChequeTransaction` Class**: Represents a cheque transaction with attributes for amount and date.
4. **`FraudDetectionServiceV1` Class**: Implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` for historical data analysis.

## Code Components

### Summary Output
```java
System.out.println("\n--- Summary ---");
if (anyFraudDetected) {
    System.out.println("⚠️ FRAUD ALERT: Potential fraud detected!");
} else {
    System.out.println("✓ No fraud detected.");
}
System.out.println("=============================\n");
```
This block prints a summary of the fraud detection results. If any fraud is detected, it displays a warning; otherwise, it confirms no fraud was found.

### `formatCheckResult` Method
```java
private String formatCheckResult(boolean failed) {
    return failed ? "FAILED ⚠️" : "Passed ✓";
}
```
This utility method formats the result of a fraud check. It returns "FAILED ⚠️" if the check failed and "Passed ✓" otherwise.

### `ChequeTransaction` Class
```java
private static class ChequeTransaction {
    private double amount;
    private java.time.LocalDate date;

    public ChequeTransaction(double amount, java.time.LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public java.time.LocalDate getDate() {
        return date;
    }
}
```
This class represents a cheque transaction with two attributes:
- `amount`: The monetary value of the cheque.
- `date`: The date of the transaction.

It includes a constructor for initializing these attributes and getter methods for accessing them.

### `FraudDetectionServiceV1` Class
#### Overview
This class is responsible for detecting fraudulent cheque activities. It uses various mechanisms, including velocity checks, pattern analysis, and historical data analysis, to identify potential fraud.

#### Attributes
- `fraudDetection`: An instance of the `FraudDetection` class, which provides core fraud detection functionalities.
- `historyManager`: An instance of the `ChequeHistoryManager` class, used for historical data analysis.
- `recentTransactions`: A map storing recent transactions for each account.

#### Fraud Detection Thresholds
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity checks.
- `VELOCITY_THRESHOLD`: The maximum number of transactions allowed within the velocity check period.
- `PATTERN_THRESHOLD`: The similarity threshold for pattern analysis.
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for comparing recent amounts.
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for determining unusual transaction frequency.

#### Methods
- **`setHistoryManager`**: Sets the `ChequeHistoryManager` instance.
- **`isFraudulentCheque`**: Determines if a cheque is fraudulent by performing various checks, including duplicate detection, abnormal amount detection, and historical analysis.
- **`checkDuplicateCheque`**: Checks if a cheque is a duplicate using the `FraudDetection` instance.
- **`checkAbnormalAmount`**: Checks if the cheque amount is abnormal.
- **`checkSuspiciousActivity`**: Checks for suspicious activity based on the account ID and amount.
- **`checkVelocityFraud`**: Detects fraud based on the frequency of recent transactions.
- **`checkPatternFraud`**: Identifies fraud based on patterns in transaction amounts.
- **`checkHistoricalDuplicate`**: Checks for duplicate cheques in historical data.
- **`checkUnusualFrequency`**: Determines if the frequency of transactions is unusually high.
- **`checkSimilarToRecent`**: Checks if the current transaction amount is similar to recent transactions.
- **`determineAlertLevel`**: Determines the level of fraud alert based on the results of various checks.
- **`logFraudChecks`**: Logs the results of all fraud checks for a given transaction.

#### `AlertLevel` Enum
Defines the levels of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## External Dependencies
- **`FraudDetection`**: Provides core fraud detection functionalities. The exact implementation details are not provided in this chunk.
- **`ChequeHistoryManager`**: Manages historical cheque data. The exact implementation details are not provided in this chunk.

## Summary
This code chunk is a comprehensive implementation of a fraud detection service for cheque transactions. It combines real-time checks with historical data analysis to identify potential fraud. The use of helper methods and a dedicated `ChequeTransaction` class ensures modularity and readability.