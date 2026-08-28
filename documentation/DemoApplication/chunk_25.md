---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_25"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "FraudDetection"]
---

# Documentation for Fraud Detection Code Chunk

## Overview
This code chunk is part of a fraud detection system implemented in Java. It performs various checks to identify potentially fraudulent cheque transactions. The checks are categorized into **Basic Checks** and **Advanced Checks**, and a summary is provided at the end to indicate whether any fraud was detected.

The code also includes helper methods and classes, such as `formatCheckResult` for formatting check results and `ChequeTransaction` for representing individual cheque transactions.

## Key Components

### Basic Checks
The following checks are performed for every transaction:
- **Duplicate Check**: Verifies if the cheque is a duplicate.
- **Abnormal Amount Check**: Checks if the cheque amount is abnormal.
- **Suspicious Activity Check**: Detects suspicious activity based on the account and amount.
- **Velocity Check**: Ensures that the number of transactions within a specific time frame does not exceed a threshold.
- **Pattern Analysis**: Identifies patterns in transaction amounts that may indicate fraud.

### Advanced Checks
If a `ChequeHistoryManager` instance is available, the following additional checks are performed:
- **Historical Duplicate Check**: Checks if the cheque number exists in historical records.
- **Unusual Frequency Check**: Detects if the frequency of transactions is unusually high compared to historical data.
- **Similar Recent Amount Check**: Compares the current transaction amount with recent transactions to identify similarities.

### Summary
After performing all checks, the system outputs a summary:
- If any fraud is detected, a **Fraud Alert** is raised.
- Otherwise, it confirms that no fraud was detected.

## Methods

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed) {
    return failed ? "FAILED ⚠️" : "Passed ✓";
}
```
This helper method formats the result of a check. It returns "FAILED ⚠️" if the check fails and "Passed ✓" if it passes.

### `ChequeTransaction`
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
This class represents a cheque transaction with the following attributes:
- `amount`: The monetary value of the cheque.
- `date`: The date of the transaction.

It provides getter methods to access these attributes.

## External Dependencies

### `ChequeHistoryManager`
The `ChequeHistoryManager` class is used for managing historical cheque data. It provides methods such as:
- `getChequeNumbers(String accountId)`: Retrieves a list of cheque numbers for a given account.
- `getTotalChequeCount(String accountId)`: Returns the total number of cheques for an account.
- `getRecentChequeCount(String accountId)`: Returns the number of recent cheques for an account.

### `FraudDetection`
The `FraudDetection` class is responsible for implementing the core logic of various fraud detection checks, such as:
- `isDuplicateCheque(String accountId, String chequeNumber)`
- `isAbnormalAmount(double amount)`
- `isSuspiciousActivity(String accountId, double amount)`

## Summary
This code chunk is a critical part of the fraud detection system, providing both basic and advanced checks for identifying fraudulent cheque transactions. It relies on external classes like `ChequeHistoryManager` and `FraudDetection` to perform its operations. The results of the checks are displayed in a user-friendly format, and a summary is provided to indicate whether any fraud was detected.