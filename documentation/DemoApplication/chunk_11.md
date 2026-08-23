---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_11"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation: Fraud Detection Methods in `DemoApplication`

This code chunk is part of a fraud detection system implemented in the `DemoApplication.java` file. It defines a method `isFraudulentCheque` that evaluates whether a cheque transaction is potentially fraudulent based on various criteria. The class also includes helper methods to perform specific fraud checks and utility methods for logging and formatting results.

## `isFraudulentCheque` Method

### Purpose
The `isFraudulentCheque` method determines whether a cheque transaction is fraudulent by performing a series of checks. It evaluates the transaction based on duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions.

### Parameters
- `String accountId`: The unique identifier for the account associated with the cheque.
- `String chequeNumber`: The unique identifier for the cheque.
- `double amount`: The monetary value of the cheque.

### Returns
- `boolean`: Returns `true` if the cheque is deemed fraudulent based on any of the checks; otherwise, returns `false`.

### Workflow
1. **Basic Checks**:
   - `checkDuplicateCheque`: Checks if the cheque is a duplicate.
   - `checkAbnormalAmount`: Checks if the cheque amount is abnormal.
   - `checkSuspiciousActivity`: Checks for suspicious activity associated with the account and amount.
   - `checkVelocityFraud`: Checks if the transaction frequency exceeds a predefined threshold.
   - `checkPatternFraud`: Checks for patterns in recent transactions that indicate fraud.

2. **Advanced Checks** (if `historyManager` is available):
   - `checkHistoricalDuplicate`: Checks if the cheque number exists in historical records.
   - `checkUnusualFrequency`: Checks if the frequency of transactions is unusually high.
   - `checkSimilarToRecent`: Checks if the cheque amount is similar to recent transactions.

3. **Logging**:
   - `logFraudChecks`: Logs the results of all fraud checks for auditing and debugging purposes.

4. **Alert Level Determination**:
   - `determineAlertLevel`: Assigns an alert level (CRITICAL, HIGH, MEDIUM, LOW) based on the results of the checks.

5. **Final Decision**:
   - Returns `true` if any of the checks indicate fraud; otherwise, returns `false`.

## Helper Methods

### `checkDuplicateCheque`
- **Purpose**: Checks if the cheque is a duplicate.
- **Implementation**: Delegates to the `isDuplicateCheque` method of the `FraudDetection` class.

### `checkAbnormalAmount`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Implementation**: Delegates to the `isAbnormalAmount` method of the `FraudDetection` class.

### `checkSuspiciousActivity`
- **Purpose**: Checks for suspicious activity based on the account and amount.
- **Implementation**: Delegates to the `isSuspiciousActivity` method of the `FraudDetection` class.

### `checkVelocityFraud`
- **Purpose**: Checks if the transaction frequency exceeds a predefined threshold.
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within a specific time window (`VELOCITY_CHECK_DAYS`).
  - Compares the count of recent transactions to a threshold (`VELOCITY_THRESHOLD`).

### `checkPatternFraud`
- **Purpose**: Checks for patterns in recent transactions that indicate fraud.
- **Implementation**:
  - Analyzes recent transactions for the account.
  - Compares the similarity of amounts to a predefined threshold (`PATTERN_THRESHOLD`).

### `checkHistoricalDuplicate`
- **Purpose**: Checks if the cheque number exists in historical records.
- **Implementation**: Uses the `ChequeHistoryManager` class to retrieve historical cheque numbers for the account.

### `checkUnusualFrequency`
- **Purpose**: Checks if the frequency of transactions is unusually high.
- **Implementation**:
  - Retrieves total and recent cheque counts from the `ChequeHistoryManager`.
  - Compares recent cheque counts to an average monthly frequency multiplied by a threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

### `checkSimilarToRecent`
- **Purpose**: Checks if the cheque amount is similar to recent transactions.
- **Implementation**: Uses the `ChequeHistoryManager` to find similar recent cheques based on a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### `determineAlertLevel`
- **Purpose**: Assigns an alert level based on the results of the fraud checks.
- **Implementation**:
  - Calculates a fraud score based on the number and severity of failed checks.
  - Returns one of the following alert levels: `CRITICAL`, `HIGH`, `MEDIUM`, or `LOW`.

### `logFraudChecks`
- **Purpose**: Logs the results of all fraud checks for auditing and debugging purposes.
- **Implementation**:
  - Prints a detailed report of the fraud checks, including basic and advanced checks.
  - Summarizes whether any fraud was detected.

### `formatCheckResult`
- **Purpose**: Formats the result of a fraud check for logging.
- **Implementation**: Returns "FAILED ⚠️" if the check failed, otherwise returns "Passed ✓".

## Nested Class: `ChequeTransaction`

### Purpose
Represents a single cheque transaction with an amount and a date.

### Fields
- `double amount`: The monetary value of the cheque.
- `java.time.LocalDate date`: The date of the transaction.

### Constructor
- `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes the transaction with the specified amount and date.

### Methods
- `double getAmount()`: Returns the amount of the transaction.
- `java.time.LocalDate getDate()`: Returns the date of the transaction.

## External Dependencies

### `FraudDetection`
A service class used for basic fraud checks such as duplicate cheques, abnormal amounts, and suspicious activity.

### `ChequeHistoryManager`
A mock implementation that manages historical cheque data. Provides methods to retrieve cheque history and analyze transaction patterns.