---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_13"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "FraudDetection", "AdminService"]
---

## Overview
This code chunk is part of a larger Java-based application that includes functionality for fraud detection, cheque transaction management, and administrative operations. It integrates basic and advanced fraud detection checks, provides methods for managing master data and batch transactions, and handles stuck transactions. The system is modular, leveraging external dependencies like `ChequeHistoryManager` and `FraudDetection` for enhanced functionality.

### Key Components

#### Fraud Detection
The fraud detection system is divided into two categories:

1. **Basic Checks**:
   - **Duplicate Check**: Identifies if the cheque is a duplicate.
   - **Abnormal Amount Check**: Flags cheques with amounts exceeding a predefined threshold.
   - **Suspicious Activity Check**: Detects unusual account activity or transaction patterns.
   - **Velocity Check**: Monitors rapid transactions that may indicate fraud.
   - **Pattern Analysis**: Analyzes transaction patterns for irregularities.

2. **Advanced Checks** (if `ChequeHistoryManager` is available):
   - **Historical Duplicate Check**: Compares the cheque against historical data for duplicates.
   - **Unusual Frequency Check**: Detects unusually high transaction frequencies.
   - **Similar Recent Amount Check**: Identifies cheques with amounts similar to recent transactions.

#### Administrative Services
The `AdminService` class provides methods for managing master data and batch transactions:

- **`addOrUpdateIFSC(String ifsc, String bankCode)`**:
  - Maps an IFSC code to a bank code.
  - Logs the mapping operation.

- **`createBatch(String batchId, List<BatchCheque> cheques)`**:
  - Creates a new batch of cheques identified by a unique batch ID.
  - Stores the batch for future processing.

- **`markTransactionStuck(String chequeNumber)`**:
  - Marks a cheque transaction as stuck.
  - Adds the cheque number to a set of stuck transactions.

#### Fraud Detection Summary
After performing the checks, the system determines if any fraud has been detected. If any check fails, a fraud alert is generated; otherwise, a message indicating no fraud is displayed.

### Methods

#### `formatCheckResult(boolean failed)`
This private method formats the result of a check into a user-friendly string.

- **Parameters**:
  - `failed` (boolean): Indicates whether the check failed.
- **Returns**: A string indicating the result of the check ("FAILED ⚠️" or "Passed ✓").

#### `ChequeTransaction` (Nested Class)
This static nested class represents a cheque transaction.

- **Fields**:
  - `amount` (double): The amount of the cheque.
  - `date` (java.time.LocalDate): The date of the cheque transaction.
- **Constructor**:
  - `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes a cheque transaction with the specified amount and date.
- **Methods**:
  - `getAmount()`: Returns the amount of the cheque.
  - `getDate()`: Returns the date of the cheque transaction.

### External Dependencies

#### `ChequeHistoryManager`
This class manages the history of cheque transactions. It provides methods to record and retrieve historical cheque data, which are utilized in advanced fraud detection checks.

#### `FraudDetection`
This class implements the core fraud detection mechanisms, including methods for detecting duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, and pattern fraud. It also supports advanced checks like historical duplicate detection, unusual frequency detection, and similar recent amount detection.

#### `AdminService`
This class handles administrative tasks such as managing master data (e.g., IFSC codes and bank codes) and batch transactions. It also provides functionality for marking transactions as stuck.

### Summary
This code chunk is a critical component of a comprehensive fraud detection and transaction management system. It combines basic and advanced fraud detection checks with administrative capabilities to ensure robust and efficient operations. The modular design and use of external dependencies like `ChequeHistoryManager`, `FraudDetection`, and `AdminService` enhance the system's functionality and maintainability.