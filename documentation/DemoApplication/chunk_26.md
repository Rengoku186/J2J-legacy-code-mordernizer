---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_26"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Code Chunk in `DemoApplication.java`

## Overview
This code chunk is part of a fraud detection system for cheque transactions. It contains methods to perform various fraud checks, determine the severity of fraud alerts, and log the results of these checks. Additionally, it defines a nested class for representing cheque transactions.

## Methods

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
This method checks if a given cheque number has been used previously for a specific account.

#### Parameters:
- `accountId` (String): The unique identifier for the account.
- `chequeNumber` (String): The cheque number to check for duplicates.

#### Returns:
- `boolean`: `true` if the cheque number exists in the account's historical records, `false` otherwise.

#### Implementation:
- Retrieves a list of historical cheque numbers for the given account using `historyManager.getChequeNumbers(accountId)`.
- Checks if the provided `chequeNumber` exists in the retrieved list.

---

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
This method determines if the frequency of recent cheque transactions for a given account is unusually high compared to the average monthly frequency.

#### Parameters:
- `accountId` (String): The unique identifier for the account.

#### Returns:
- `boolean`: `true` if the recent cheque frequency exceeds the unusual frequency threshold, `false` otherwise.

#### Implementation:
- Retrieves the total and recent cheque counts for the account using `historyManager.getTotalChequeCount(accountId)` and `historyManager.getRecentChequeCount(accountId)`.
- If the total cheque count is less than 10, the method returns `false`.
- Calculates the average monthly frequency as `totalCheques / 3.0`.
- Compares the recent cheque count to the product of the average monthly frequency and the `UNUSUAL_FREQUENCY_THRESHOLD` (3).

---

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
This method checks if a given cheque amount is similar to recent cheque amounts for a specific account.

#### Parameters:
- `accountId` (String): The unique identifier for the account.
- `amount` (double): The cheque amount to compare.

#### Returns:
- `boolean`: `true` if a similar recent cheque exists, `false` otherwise.

#### Implementation:
- Uses `historyManager.hasSimilarRecentCheque(accountId, amount, SIMILAR_AMOUNT_THRESHOLD)` to determine if a similar cheque exists.

---

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
This method determines the severity of a fraud alert based on various fraud detection checks.

#### Parameters:
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the cheque amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if the cheque frequency is unusual.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent amounts.

#### Returns:
- `AlertLevel`: The severity of the fraud alert (`LOW`, `MEDIUM`, `HIGH`, or `CRITICAL`).

#### Implementation:
- Assigns weights to each fraud check and calculates a total fraud score.
- Determines the alert level based on the fraud score and specific conditions.

---

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
This method logs the results of various fraud checks for a specific cheque transaction.

#### Parameters:
- `accountId` (String): The unique identifier for the account.
- `chequeNumber` (String): The cheque number.
- `amount` (double): The cheque amount.
- Various boolean flags indicating the results of different fraud checks.

#### Implementation:
- Logs the account ID, cheque number, and amount.
- Logs the results of basic and advanced fraud checks.
- Summarizes whether any fraud was detected.

---

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed)
```
This method formats the result of a fraud check for logging purposes.

#### Parameters:
- `failed` (boolean): Indicates if the check failed.

#### Returns:
- `String`: A formatted string indicating whether the check passed or failed.

---

### `ChequeTransaction` (Nested Class)
```java
private static class ChequeTransaction
```
This nested class represents a cheque transaction with an amount and a date.

#### Fields:
- `amount` (double): The amount of the cheque.
- `date` (java.time.LocalDate): The date of the cheque transaction.

#### Constructor:
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```
Initializes a new `ChequeTransaction` with the specified amount and date.

#### Methods:
- `getAmount()`: Returns the cheque amount.
- `getDate()`: Returns the cheque date.

---

## External Dependencies
- **`ChequeHistoryManager`**: Provides methods for retrieving historical cheque data.
- **`AlertLevel`**: Enum defining fraud alert levels.
- **`UNUSUAL_FREQUENCY_THRESHOLD`**: Constant for unusual frequency detection.
- **`SIMILAR_AMOUNT_THRESHOLD`**: Constant for similar amount detection.