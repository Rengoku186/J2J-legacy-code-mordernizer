---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_35"
confidence_score: 0.95
external_dependencies: [java.time.LocalDateTime]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview

This code chunk is part of a system that monitors and evaluates account activities for potential fraud or suspicious behavior. It includes methods to determine if a transaction amount is abnormal, assess suspicious activity, record transactions, update account profiles, and evaluate abnormal behavior patterns. Additionally, it defines two inner classes, `TransactionRecord` and `AccountProfile`, to manage transaction history and account-related data.

---

## Methods

### `isAbnormalAmount(double amount)`
Determines if a given transaction amount exceeds a predefined threshold.

- **Parameters**:
  - `amount` (double): The transaction amount to evaluate.
- **Returns**:
  - `true` if the amount exceeds the `ABNORMAL_AMOUNT_THRESHOLD`.
  - `false` otherwise.

---

### `isSuspiciousActivity(String accountId, double amount)`
Evaluates whether a transaction is suspicious based on the account's activity and behavior.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Returns**:
  - `true` if the transaction is deemed suspicious.
  - `false` otherwise.
- **Logic**:
  1. Retrieves the total activity for the account from the `accountActivity` map.
  2. Updates the total activity with the current transaction amount.
  3. Records the transaction using `recordTransaction`.
  4. Updates the account profile using `updateAccountProfile`.
  5. Checks if the total activity exceeds a threshold (`ABNORMAL_AMOUNT_THRESHOLD * SUSPICIOUS_ACTIVITY_MULTIPLIER`).
  6. Evaluates abnormal behavior using `isAbnormalBehavior`.
  7. Returns `true` if either the threshold is exceeded or abnormal behavior is detected.

---

### `recordTransaction(String accountId, double amount)`
Records a transaction in the account's transaction history and removes records older than 90 days.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Logic**:
  1. Checks if the account exists in the `accountTransactionHistory` map. If not, initializes a new list for the account.
  2. Adds a new `TransactionRecord` with the current timestamp to the account's transaction history.
  3. Filters the transaction history to retain only records from the last 90 days.

---

### `updateAccountProfile(String accountId, double amount)`
Updates the account's profile with the new transaction data.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Logic**:
  1. Checks if the account exists in the `accountProfiles` map. If not, initializes a new `AccountProfile` for the account.
  2. Updates the account profile with the new transaction using the `updateWithTransaction` method of the `AccountProfile` class.

---

### `isAbnormalBehavior(String accountId, double amount)`
Determines if a transaction exhibits abnormal behavior based on the account's transaction history.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Returns**:
  - `true` if the transaction exhibits abnormal behavior.
  - `false` otherwise.
- **Logic**:
  1. Checks if the account exists in the `accountProfiles` map. If not, returns `false`.
  2. Retrieves the account's profile and calculates the average transaction amount.
  3. Computes the variance between the current transaction amount and the average.
  4. Returns `true` if the variance exceeds the `AMOUNT_VARIANCE_THRESHOLD` and the amount is greater than the average.

---

## Inner Classes

### `TransactionRecord`
Represents a single transaction record.

- **Fields**:
  - `amount` (double): The transaction amount.
  - `timestamp` (LocalDateTime): The timestamp of the transaction.
- **Constructor**:
  - `TransactionRecord(double amount, LocalDateTime timestamp)`: Initializes a new transaction record with the specified amount and timestamp.

---

### `AccountProfile`
Represents the profile of an account, including transaction statistics.

- **Fields**:
  - `totalAmount` (double): The total amount of all transactions.
  - `transactionCount` (int): The total number of transactions.
  - `maxAmount` (double): The maximum transaction amount.
  - `minAmount` (double): The minimum transaction amount.
- **Methods**:
  - `updateWithTransaction(double amount)`: Updates the profile with a new transaction, adjusting the total amount, transaction count, and min/max amounts.

---

## Constants and External Dependencies

- **Constants**:
  - `ABNORMAL_AMOUNT_THRESHOLD`: A predefined threshold for abnormal transaction amounts.
  - `SUSPICIOUS_ACTIVITY_MULTIPLIER`: A multiplier used to determine suspicious activity thresholds.
  - `AMOUNT_VARIANCE_THRESHOLD`: A threshold for detecting abnormal behavior based on transaction variance.
- **External Dependencies**:
  - `java.time.LocalDateTime`: Used for timestamping transactions and filtering transaction history.

---