---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_26"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Code Chunk in `DemoApplication.java`

## Overview
This code chunk is part of a fraud detection system implemented in Java. It contains methods for detecting fraudulent activities related to cheque transactions, determining alert levels based on the results of these checks, and logging the outcomes of the fraud checks. Additionally, it defines a nested static class `ChequeTransaction` to represent individual cheque transactions.

The code relies on a `ChequeHistoryManager` class (mock implementation found in the same file) to retrieve historical cheque data and perform advanced fraud checks. It also uses an `AlertLevel` enum (not defined in this chunk) to categorize the severity of detected fraud.

## Methods

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
**Purpose**: Checks if a given cheque number has been used before for the specified account.

- **Parameters**:
  - `accountId` (String): The account identifier.
  - `chequeNumber` (String): The cheque number to check.
- **Returns**: `true` if the cheque number exists in the account's historical records, otherwise `false`.
- **Dependencies**: Uses `historyManager.getChequeNumbers(accountId)` to fetch historical cheque numbers.

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
**Purpose**: Determines if the frequency of recent cheque transactions is unusually high compared to the average monthly frequency.

- **Parameters**:
  - `accountId` (String): The account identifier.
- **Returns**: `true` if the recent cheque frequency exceeds a predefined threshold, otherwise `false`.
- **Dependencies**: Uses `historyManager.getTotalChequeCount(accountId)` and `historyManager.getRecentChequeCount(accountId)` to fetch cheque counts.

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
**Purpose**: Checks if the given cheque amount is similar to recent cheque amounts for the specified account.

- **Parameters**:
  - `accountId` (String): The account identifier.
  - `amount` (double): The cheque amount to check.
- **Returns**: `true` if a similar recent cheque exists, otherwise `false`.
- **Dependencies**: Uses `historyManager.hasSimilarRecentCheque(accountId, amount, SIMILAR_AMOUNT_THRESHOLD)`.

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
**Purpose**: Determines the alert level based on the results of various fraud checks.

- **Parameters**:
  - `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
  - `isAbnormal` (boolean): Indicates if the cheque amount is abnormal.
  - `isSuspicious` (boolean): Indicates if the activity is suspicious.
  - `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
  - `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
  - `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
  - `isUnusualFrequency` (boolean): Indicates if the cheque frequency is unusual.
  - `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent cheques.
- **Returns**: An `AlertLevel` value representing the severity of the detected fraud.
- **Logic**: Assigns a score to each fraud type and calculates a total fraud score. The alert level is determined based on the total score and specific conditions.

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
**Purpose**: Logs the results of various fraud checks for a specific cheque transaction.

- **Parameters**:
  - `accountId` (String): The account identifier.
  - `chequeNumber` (String): The cheque number.
  - `amount` (double): The cheque amount.
  - `isDuplicate` (boolean): Result of the duplicate cheque check.
  - `isAbnormal` (boolean): Result of the abnormal amount check.
  - `isSuspicious` (boolean): Result of the suspicious activity check.
  - `isVelocityFraud` (boolean): Result of the velocity fraud check.
  - `isPatternFraud` (boolean): Result of the pattern fraud check.
  - `isHistoricalDuplicate` (boolean): Result of the historical duplicate check.
  - `isUnusualFrequency` (boolean): Result of the unusual frequency check.
  - `isSimilarToRecent` (boolean): Result of the similar recent amount check.
- **Output**: Prints a detailed fraud check report to the console.
- **Dependencies**: Uses `formatCheckResult(boolean)` to format the results of individual checks.

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed)
```
**Purpose**: Formats the result of a fraud check for logging purposes.

- **Parameters**:
  - `failed` (boolean): Indicates whether the check failed.
- **Returns**: A string indicating the result of the check ("FAILED ⚠️" or "Passed ✓").

### `ChequeTransaction` (Nested Static Class)
**Purpose**: Represents a cheque transaction with an amount and a date.

- **Fields**:
  - `amount` (double): The amount of the cheque.
  - `date` (LocalDate): The date of the cheque transaction.
- **Constructor**:
  - `ChequeTransaction(double amount, LocalDate date)`: Initializes the `amount` and `date` fields.
- **Methods**:
  - `getAmount()`: Returns the amount of the cheque.
  - `getDate()`: Returns the date of the cheque transaction.

## External Dependencies

### `ChequeHistoryManager`
A mock implementation of a class that manages historical cheque data. It provides methods to record and retrieve cheque information for specific accounts.

### `AlertLevel`
An enumeration (not defined in this chunk) used to represent the severity of detected fraud.

## Notes
- The `historyManager` object is assumed to be an instance of `ChequeHistoryManager`.
- Constants such as `UNUSUAL_FREQUENCY_THRESHOLD` and `SIMILAR_AMOUNT_THRESHOLD` are used but not defined in this chunk. They are likely defined elsewhere in the codebase.
- The `logFraudChecks` method uses `System.out.println` for logging, which may not be suitable for production environments. Consider using a logging framework for better control and configurability.