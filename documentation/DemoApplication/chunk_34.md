---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_34"
confidence_score: 0.95
external_dependencies: ["AlertLevel", "ChequeHistoryManager", "VELOCITY_CHECK_DAYS", "VELOCITY_THRESHOLD", "PATTERN_THRESHOLD", "UNUSUAL_FREQUENCY_THRESHOLD", "SIMILAR_AMOUNT_THRESHOLD"]
---

# Documentation for Fraud Detection Methods

This section of the code implements a comprehensive fraud detection mechanism for cheque transactions. It includes methods to evaluate various fraud indicators, log the results, and determine the overall fraud alert level.

## Key Methods and Their Purpose

### 1. `logFraudChecks`
Logs the results of various fraud checks for a given transaction.

#### Parameters:
- `accountId` (String): The account ID associated with the cheque.
- `chequeNumber` (String): The cheque number.
- `amount` (double): The transaction amount.
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque matches a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if the transaction frequency is unusual.
- `isSimilarToRecent` (boolean): Indicates if the amount is similar to recent transactions.

#### Functionality:
- Logs the results of each fraud check.
- Provides a summary indicating whether any fraud was detected.

---

### 2. `determineAlertLevel`
Determines the overall fraud alert level based on the results of individual fraud checks.

#### Parameters:
- Various boolean flags indicating the results of individual fraud checks (e.g., `isDuplicate`, `isAbnormal`, etc.).

#### Returns:
- `AlertLevel`: The overall fraud alert level, which can be one of the following:
  - `LOW`
  - `MEDIUM`
  - `HIGH`
  - `CRITICAL`

#### Functionality:
- Assigns weights to different fraud indicators.
- Calculates a cumulative fraud score.
- Determines the alert level based on the score and specific conditions.

---

### 3. Individual Fraud Check Methods

#### `checkDuplicateCheque`
Checks if a cheque is a duplicate.
- **Parameters:** `accountId` (String), `chequeNumber` (String)
- **Returns:** `boolean`
- **Logic:** Uses the `fraudDetection.isDuplicateCheque` method.

#### `checkAbnormalAmount`
Checks if the transaction amount is abnormal.
- **Parameters:** `amount` (double)
- **Returns:** `boolean`
- **Logic:** Compares the amount against a predefined threshold.

#### `checkSuspiciousActivity`
Checks for suspicious activity based on account history.
- **Parameters:** `accountId` (String), `amount` (double)
- **Returns:** `boolean`
- **Logic:** Evaluates total activity and abnormal behavior.

#### `checkVelocityFraud`
Detects velocity fraud by analyzing recent transactions.
- **Parameters:** `accountId` (String), `amount` (double)
- **Returns:** `boolean`
- **Logic:**
  - Counts transactions within a recent time window (`VELOCITY_CHECK_DAYS`).
  - Compares the count against a threshold (`VELOCITY_THRESHOLD`).

#### `checkPatternFraud`
Detects pattern fraud by analyzing transaction similarities.
- **Parameters:** `accountId` (String), `amount` (double)
- **Returns:** `boolean`
- **Logic:**
  - Compares the current transaction amount with previous amounts.
  - Uses a similarity threshold (`PATTERN_THRESHOLD`).

#### `checkHistoricalDuplicate`
Checks if the cheque matches any historical duplicates.
- **Parameters:** `accountId` (String), `chequeNumber` (String)
- **Returns:** `boolean`
- **Logic:** Compares the cheque number against historical records.

#### `checkUnusualFrequency`
Detects unusual transaction frequency.
- **Parameters:** `accountId` (String)
- **Returns:** `boolean`
- **Logic:**
  - Compares recent transaction frequency against historical averages.
  - Uses a multiplier threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

#### `checkSimilarToRecent`
Checks if the transaction amount is similar to recent transactions.
- **Parameters:** `accountId` (String), `amount` (double)
- **Returns:** `boolean`
- **Logic:** Uses a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

---

### 4. Helper Methods

#### `formatCheckResult`
Formats the result of a fraud check for logging purposes.
- **Parameters:** `failed` (boolean)
- **Returns:** `String`
- **Logic:** Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

---

### 5. Supporting Classes

#### `ChequeTransaction`
Represents a cheque transaction.
- **Fields:**
  - `amount` (double): The transaction amount.
  - `date` (LocalDate): The transaction date.
- **Methods:**
  - `getAmount()`: Returns the transaction amount.
  - `getDate()`: Returns the transaction date.

#### `AlertLevel`
An enumeration representing fraud alert levels.
- **Values:** `LOW`, `MEDIUM`, `HIGH`, `CRITICAL`

---

### External Dependencies

- **`AlertLevel`**: Enum for fraud alert levels.
- **`ChequeHistoryManager`**: Manages historical cheque data.
- **Constants:**
  - `VELOCITY_CHECK_DAYS`: Number of days for velocity fraud detection.
  - `VELOCITY_THRESHOLD`: Threshold for velocity fraud detection.
  - `PATTERN_THRESHOLD`: Similarity threshold for pattern fraud detection.
  - `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for unusual frequency detection.
  - `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent transaction comparison.