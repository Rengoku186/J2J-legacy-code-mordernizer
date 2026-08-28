---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_35"
confidence_score: 0.95
external_dependencies: []
---

# Documentation for `DemoApplication` Code Chunk

This code chunk is part of the `DemoApplication` class and contains methods for detecting abnormal and suspicious financial activities in user accounts. It also includes helper methods and inner classes for managing account transactions and profiles.

## Constants and Data Structures

- **`ABNORMAL_AMOUNT_THRESHOLD`**: A constant that defines the threshold for an amount to be considered abnormal.
- **`SUSPICIOUS_ACTIVITY_MULTIPLIER`**: A multiplier used to determine the threshold for suspicious activity based on the abnormal amount threshold.
- **`AMOUNT_VARIANCE_THRESHOLD`**: A constant that defines the acceptable variance in transaction amounts for detecting abnormal behavior.
- **`accountActivity`**: A map that tracks the total activity (sum of transaction amounts) for each account.
- **`accountTransactionHistory`**: A map that stores the transaction history for each account.
- **`accountProfiles`**: A map that stores the profile information for each account, including transaction statistics.

## Methods

### `isAbnormalAmount(double amount)`
Determines if a given transaction amount is abnormal.

- **Parameters**:
  - `amount` (double): The transaction amount to evaluate.
- **Returns**:
  - `true` if the amount exceeds the `ABNORMAL_AMOUNT_THRESHOLD`, otherwise `false`.

---

### `isSuspiciousActivity(String accountId, double amount)`
Checks if a transaction is suspicious based on the account's activity and behavior.

- **Parameters**:
  - `accountId` (String): The ID of the account.
  - `amount` (double): The transaction amount.
- **Returns**:
  - `true` if the transaction is suspicious, otherwise `false`.

**Logic**:
1. Updates the total activity for the account in `accountActivity`.
2. Records the transaction in `accountTransactionHistory`.
3. Updates the account's profile in `accountProfiles`.
4. Checks if the total activity exceeds the threshold defined by `ABNORMAL_AMOUNT_THRESHOLD * SUSPICIOUS_ACTIVITY_MULTIPLIER`.
5. Evaluates if the transaction exhibits abnormal behavior using the `isAbnormalBehavior` method.

---

### `recordTransaction(String accountId, double amount)`
Records a transaction in the account's transaction history.

- **Parameters**:
  - `accountId` (String): The ID of the account.
  - `amount` (double): The transaction amount.
- **Details**:
  - Adds a new `TransactionRecord` to the account's transaction history.
  - Removes transactions older than 90 days from the history.

---

### `updateAccountProfile(String accountId, double amount)`
Updates the account's profile with the details of a new transaction.

- **Parameters**:
  - `accountId` (String): The ID of the account.
  - `amount` (double): The transaction amount.
- **Details**:
  - Updates the total amount, transaction count, maximum amount, and minimum amount in the account's profile.

---

### `isAbnormalBehavior(String accountId, double amount)`
Determines if a transaction exhibits abnormal behavior based on the account's profile.

- **Parameters**:
  - `accountId` (String): The ID of the account.
  - `amount` (double): The transaction amount.
- **Returns**:
  - `true` if the transaction is abnormal, otherwise `false`.

**Logic**:
1. Checks if the account has a profile in `accountProfiles`.
2. If the account has at least 5 transactions, calculates the average transaction amount.
3. Determines if the variance between the transaction amount and the average exceeds `AMOUNT_VARIANCE_THRESHOLD` and if the amount is greater than the average.

---

## Inner Classes

### `TransactionRecord`
Represents a record of a transaction.

- **Fields**:
  - `amount` (double): The transaction amount.
  - `timestamp` (LocalDateTime): The timestamp of the transaction.
- **Constructor**:
  - Initializes the `amount` and `timestamp` fields.

---

### `AccountProfile`
Stores statistical data about an account's transactions.

- **Fields**:
  - `totalAmount` (double): The total amount of all transactions.
  - `transactionCount` (int): The number of transactions.
  - `maxAmount` (double): The maximum transaction amount.
  - `minAmount` (double): The minimum transaction amount.
- **Methods**:
  - `updateWithTransaction(double amount)`: Updates the profile with a new transaction.

---

## Purpose
This code is designed to monitor and analyze financial transactions for abnormal and suspicious activities. It maintains a history of transactions and profiles for each account, enabling the detection of unusual patterns and behaviors.