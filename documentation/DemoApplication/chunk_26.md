---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_26"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Fraud Detection Methods in `DemoApplication`

This section of the `DemoApplication` class contains methods related to fraud detection and logging. These methods utilize a `historyManager` object, which is an instance of the `ChequeHistoryManager` class, to perform various checks on cheque transactions. The methods are designed to identify potential fraudulent activities based on historical data, transaction patterns, and other criteria.

## Methods

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
**Purpose:**
Checks if a given cheque number has already been used for a specific account in the past.

**Parameters:**
- `accountId` (String): The unique identifier for the account.
- `chequeNumber` (String): The cheque number to check for duplicates.

**Returns:**
- `boolean`: `true` if the cheque number exists in the account's historical records, `false` otherwise.

**Dependencies:**
- `historyManager.getChequeNumbers(accountId)`: Retrieves a list of cheque numbers associated with the given account ID.

---

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
**Purpose:**
Determines if the frequency of recent cheque transactions for a given account is unusually high compared to the average monthly frequency.

**Parameters:**
- `accountId` (String): The unique identifier for the account.

**Returns:**
- `boolean`: `true` if the recent cheque frequency exceeds the threshold, `false` otherwise.

**Logic:**
1. Retrieves the total number of cheques and the number of recent cheques for the account using `historyManager`.
2. If the total number of cheques is less than 10, the method returns `false`.
3. Calculates the average monthly frequency of cheques over the last three months.
4. Compares the recent cheque count to the average monthly frequency multiplied by a predefined threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

**Dependencies:**
- `historyManager.getTotalChequeCount(accountId)`: Retrieves the total number of cheques for the account.
- `historyManager.getRecentChequeCount(accountId)`: Retrieves the number of recent cheques for the account.

---

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
**Purpose:**
Checks if the given cheque amount is similar to recent cheque amounts for the account.

**Parameters:**
- `accountId` (String): The unique identifier for the account.
- `amount` (double): The cheque amount to compare.

**Returns:**
- `boolean`: `true` if a similar recent cheque exists, `false` otherwise.

**Dependencies:**
- `historyManager.hasSimilarRecentCheque(accountId, amount, SIMILAR_AMOUNT_THRESHOLD)`: Checks for similar recent cheques based on a predefined threshold.

---

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
**Purpose:**
Determines the alert level for a transaction based on various fraud detection checks.

**Parameters:**
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the cheque amount is abnormal.
- `isSuspicious` (boolean): Indicates if the transaction is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if the cheque frequency is unusual.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent amounts.

**Returns:**
- `AlertLevel`: The determined alert level (`CRITICAL`, `HIGH`, `MEDIUM`, or `LOW`).

**Logic:**
1. Initializes a `fraudCount` variable to 0.
2. Increments `fraudCount` based on the results of the fraud checks.
3. Determines the alert level based on the `fraudCount` and specific conditions.

**Dependencies:**
- `AlertLevel`: Enum representing different alert levels.

---

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
**Purpose:**
Logs the results of various fraud detection checks for a given transaction.

**Parameters:**
- `accountId` (String): The unique identifier for the account.
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

**Behavior:**
1. Logs the account ID, cheque number, and amount.
2. Logs the results of basic and advanced fraud checks.
3. Summarizes whether any fraud was detected.

**Dependencies:**
- `formatCheckResult(boolean)`: Formats the result of a fraud check as "FAILED" or "Passed".

---

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed)
```
**Purpose:**
Formats the result of a fraud check for logging purposes.

**Parameters:**
- `failed` (boolean): Indicates whether the check failed.

**Returns:**
- `String`: "FAILED ⚠️" if the check failed, "Passed ✓" otherwise.

---

### `ChequeTransaction` (Inner Class)
```java
private static class ChequeTransaction
```
**Purpose:**
Represents a cheque transaction with an amount and a date.

**Fields:**
- `amount` (double): The amount of the cheque.
- `date` (java.time.LocalDate): The date of the cheque transaction.

**Constructor:**
- `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes the `amount` and `date` fields.

**Methods:**
- `getAmount()`: Returns the cheque amount.
- `getDate()`: Returns the cheque date.

---

## External Dependencies

### `ChequeHistoryManager`
The `historyManager` object is an instance of the `ChequeHistoryManager` class, which provides methods to manage and query historical cheque data. Relevant methods include:
- `getChequeNumbers(String accountId)`: Retrieves a list of cheque numbers for a given account.
- `getTotalChequeCount(String accountId)`: Retrieves the total number of cheques for an account.
- `getRecentChequeCount(String accountId)`: Retrieves the number of recent cheques for an account.
- `hasSimilarRecentCheque(String accountId, double amount, double threshold)`: Checks if a similar recent cheque exists for the account.

### `AlertLevel`
An enumeration representing different levels of fraud alerts, such as `CRITICAL`, `HIGH`, `MEDIUM`, and `LOW`.