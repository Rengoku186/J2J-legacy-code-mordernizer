---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_34"
confidence_score: 0.95
external_dependencies: ["AlertLevel", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

## Overview
This code chunk is part of a fraud detection system that evaluates various fraud indicators for cheque transactions. It performs checks for duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions. Based on these checks, it determines an alert level and logs the results.

## Key Methods and Classes

### 1. `logFraudChecks`
Logs the results of various fraud checks for a given transaction. It provides a detailed report of the checks performed and their outcomes.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.
- `amount` (double): The amount of the cheque.
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if there is unusual frequency in transactions.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent transactions.

### 2. `determineAlertLevel`
Determines the alert level based on the results of the fraud checks.

#### Parameters:
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if there is unusual frequency in transactions.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent transactions.

#### Returns:
- `AlertLevel`: The determined alert level (CRITICAL, HIGH, MEDIUM, LOW).

### 3. `checkDuplicateCheque`
Checks if a cheque is a duplicate by consulting the `fraudDetection` object.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.

#### Returns:
- `boolean`: True if the cheque is a duplicate, false otherwise.

### 4. `checkAbnormalAmount`
Checks if the cheque amount is abnormal.

#### Parameters:
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if the amount is abnormal, false otherwise.

### 5. `checkSuspiciousActivity`
Checks for suspicious activity based on the account ID and amount.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if suspicious activity is detected, false otherwise.

### 6. `checkVelocityFraud`
Checks for velocity fraud by analyzing recent transactions.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if velocity fraud is detected, false otherwise.

### 7. `checkPatternFraud`
Checks for pattern fraud by analyzing recent transaction amounts for patterns.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if pattern fraud is detected, false otherwise.

### 8. `checkHistoricalDuplicate`
Checks if the cheque is a historical duplicate by consulting the `historyManager`.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.

#### Returns:
- `boolean`: True if the cheque is a historical duplicate, false otherwise.

### 9. `checkUnusualFrequency`
Checks for unusual frequency of transactions for the given account.

#### Parameters:
- `accountId` (String): The account identifier.

#### Returns:
- `boolean`: True if unusual frequency is detected, false otherwise.

### 10. `checkSimilarToRecent`
Checks if the cheque amount is similar to recent transactions.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if the amount is similar to recent transactions, false otherwise.

### 11. `formatCheckResult`
Formats the result of a fraud check for logging purposes.

#### Parameters:
- `failed` (boolean): Indicates if the check failed.

#### Returns:
- `String`: A formatted string indicating the result of the check ("FAILED ⚠️" or "Passed ✓").

### 12. `ChequeTransaction` (Inner Class)
Represents a cheque transaction with an amount and a date.

#### Fields:
- `amount` (double): The amount of the transaction.
- `date` (LocalDate): The date of the transaction.

#### Constructor:
- `ChequeTransaction(double amount, LocalDate date)`: Initializes a new cheque transaction.

#### Methods:
- `getAmount()`: Returns the transaction amount.
- `getDate()`: Returns the transaction date.

## External Dependencies

### 1. `AlertLevel`
An external class used to represent the severity of a fraud alert. Possible values include `CRITICAL`, `HIGH`, `MEDIUM`, and `LOW`.

### 2. `ChequeHistoryManager`
A mock implementation of a class that manages historical cheque data. It provides methods to record and retrieve cheque history for accounts.

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses various checks to identify potential fraud and assigns an alert level based on the results. The system also logs detailed reports of the checks performed, making it easier to analyze and act upon potential fraud cases.