<!-- EVALUATOR FEEDBACK:
RESULT: FAIL  
FEEDBACK:  

1. **Completeness**: The documentation does a good job of summarizing the key components of the provided Java code, including fraud detection checks, helper methods, and the `AdminService` class. However, it fails to mention the `BatchCheque` class, which is referenced in the `AdminService` class but not defined in the provided code. This omission leaves a gap in understanding the functionality of the `AdminService` class.  

2. **Accuracy**: The descriptions of the fraud detection checks, helper methods, and nested classes are accurate and align with the provided Java code. However, the documentation does not clarify that the `BatchCheque` class is an external dependency, which is critical for understanding the `AdminService` class's batch management functionality.  

3. **Dependency**: The `BatchCheque` class is referenced in the `AdminService` class but is not defined in the provided code. The documentation acknowledges this but does not explicitly identify it as an external dependency or provide any explanation about its role or expected structure. This lack of clarity impacts the overall quality of the documentation.  

4. **Traceability**: The YAML frontmatter provides clear traceability to the source file (`legacy_source/DemoApplication.java`) and chunk ID (`chunk_13`). This aspect of the documentation is satisfactory.  

To pass, the documentation must explicitly identify and explain the `BatchCheque` class as an external dependency and provide a more complete overview of its role in the `AdminService` class.
-->

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_13"
confidence_score: 0.9
external_dependencies: []
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview

This code chunk is part of a larger application that performs fraud detection and administrative tasks related to cheque transactions. The provided code includes:

1. **Fraud Detection Checks**: A series of checks to identify potential fraudulent activities.
2. **Helper Method**: A utility method to format the results of the checks.
3. **Nested Classes**: Definitions for `ChequeTransaction`, `TransactionRecord`, and `AccountProfile` classes, which are used to manage transaction data and account profiles.
4. **AdminService Class**: A class for managing master data, batch processing, and stuck transactions.

---

## Key Components

### Fraud Detection Checks

The code performs a series of fraud detection checks and prints the results to the console. These checks include:

- **Basic Checks**:
  - Duplicate Check
  - Abnormal Amount Check
  - Suspicious Activity Check
  - Velocity Check
  - Pattern Analysis

- **Advanced Checks** (executed if `historyManager` is not null):
  - Historical Duplicate Check
  - Unusual Frequency Check
  - Similar Recent Amount Check

The results of these checks are formatted using the `formatCheckResult` method and displayed in the console. If any fraud is detected, a summary message is printed to alert the user.

### `formatCheckResult` Method

This private helper method formats the result of a fraud detection check.

#### Method Signature:
```java
private String formatCheckResult(boolean failed)
```

#### Parameters:
- `failed`: A boolean indicating whether the check failed.

#### Returns:
- A string indicating the result of the check:
  - `"FAILED ⚠️"` if the check failed.
  - `"Passed ✓"` if the check passed.

---

### `ChequeTransaction` Class

A nested class representing a cheque transaction.

#### Fields:
- `amount` (double): The amount of the cheque.
- `date` (java.time.LocalDate): The date of the cheque.

#### Constructor:
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```

#### Methods:
- `getAmount()`: Returns the amount of the cheque.
- `getDate()`: Returns the date of the cheque.

---

### `FraudDetection` Class

A static class implementing core fraud detection mechanisms.

#### Key Features:
- **Thresholds**:
  - `ABNORMAL_AMOUNT_THRESHOLD`: The maximum amount considered normal.
  - `SUSPICIOUS_ACTIVITY_MULTIPLIER`: Multiplier for suspicious activity detection.
  - `AMOUNT_VARIANCE_THRESHOLD`: Threshold for detecting abnormal behavior based on transaction variance.

- **Methods**:
  - `isDuplicateCheque`: Checks if a cheque is a duplicate.
  - `isAbnormalAmount`: Checks if an amount exceeds the abnormal threshold.
  - `isSuspiciousActivity`: Checks for suspicious activity based on account activity and transaction history.

- **Helper Methods**:
  - `recordTransaction`: Records a transaction in the account's history.
  - `updateAccountProfile`: Updates the account profile with transaction data.
  - `isAbnormalBehavior`: Checks for abnormal behavior based on transaction variance.

#### Nested Classes:
- `TransactionRecord`: Represents a transaction record with amount and timestamp.
- `AccountProfile`: Represents an account profile with transaction statistics.

---

### `AdminService` Class

A class for managing master data, batch processing, and stuck transactions.

#### Features:
1. **Master Data Management**:
   - `addOrUpdateIFSC`: Maps an IFSC code to a bank code.
   - `addOrUpdateBankCode`: Maps a bank code to a bank name.
   - `displayIFSCs`: Displays all IFSC-to-bank-code mappings.
   - `displayBankCodes`: Displays all bank-code-to-name mappings.

2. **Batch Management**:
   - `createBatch`: Creates a batch of cheques.
   - `displayBatches`: Displays a list of all batches.
   - `displayBatchDetails`: Displays details of a specific batch.

3. **Stuck Transaction Management**:
   - `markTransactionStuck`: Marks a cheque as stuck.

---

## Notes

- The `BatchCheque` class is referenced in the `AdminService` class but is not defined in the provided code. It is likely defined elsewhere in the codebase.
- The `formatCheckResult` method is a simple utility for formatting check results and is used extensively in the fraud detection checks.

---