---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_24"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection and Cheque Management Code Chunk

## Overview
This code chunk is part of a fraud detection system for cheque transactions. It includes methods for detecting fraudulent activities based on various criteria, such as duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, and pattern fraud. Additionally, it integrates with a `ChequeHistoryManager` to perform historical checks and manage cheque transaction history.

## Key Components

### 1. **Summary Output**
The code includes a summary output section that prints the results of fraud detection checks:
```java
System.out.println("\n--- Summary ---");
if (anyFraudDetected) {
    System.out.println("⚠️ FRAUD ALERT: Potential fraud detected!");
} else {
    System.out.println("✓ No fraud detected.");
}
System.out.println("=============================\n");
```
This provides a user-friendly summary of whether fraud was detected.

### 2. **Helper Method: `formatCheckResult`**
This method formats the result of a fraud check for display purposes:
```java
private String formatCheckResult(boolean failed) {
    return failed ? "FAILED ⚠️" : "Passed ✓";
}
```
- **Input:** A boolean indicating whether the check failed.
- **Output:** A formatted string indicating the result.

### 3. **Inner Class: `ChequeTransaction`**
This class represents a cheque transaction with two attributes:
- `amount` (double): The amount of the cheque.
- `date` (LocalDate): The date of the transaction.

#### Constructor:
```java
public ChequeTransaction(double amount, java.time.LocalDate date) {
    this.amount = amount;
    this.date = date;
}
```
#### Getters:
```java
public double getAmount() {
    return amount;
}

public java.time.LocalDate getDate() {
    return date;
}
```

### 4. **Class: `FraudDetectionServiceV1`**
This class implements the core fraud detection logic. It uses various thresholds and criteria to determine if a cheque is fraudulent.

#### Key Attributes:
- `FraudDetection fraudDetection`: An instance of the `FraudDetection` class for performing basic fraud checks.
- `ChequeHistoryManager historyManager`: Manages historical cheque data.
- `Map<String, List<ChequeTransaction>> recentTransactions`: Tracks recent transactions for velocity and pattern checks.

#### Fraud Detection Thresholds:
- `VELOCITY_CHECK_DAYS`: Number of days for velocity checks.
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period.
- `PATTERN_THRESHOLD`: Similarity threshold for pattern analysis.
- `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent amounts.
- `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for detecting unusual frequency.

#### Fraud Alert Levels:
The `AlertLevel` enum defines four levels of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

#### Methods:
1. **`isFraudulentCheque`**
   - Determines if a cheque is fraudulent based on multiple checks.
   - Integrates with `ChequeHistoryManager` for historical checks.

2. **`checkDuplicateCheque`**
   - Checks for duplicate cheques using `FraudDetection`.

3. **`checkAbnormalAmount`**
   - Checks if the cheque amount is abnormal.

4. **`checkSuspiciousActivity`**
   - Checks for suspicious activity based on account and amount.

5. **`checkVelocityFraud`**
   - Detects velocity fraud by analyzing recent transactions.

6. **`checkPatternFraud`**
   - Detects pattern fraud by analyzing transaction amounts for similarity.

7. **`checkHistoricalDuplicate`**
   - Checks for duplicate cheques in historical data.

8. **`checkUnusualFrequency`**
   - Detects unusual frequency of transactions.

9. **`checkSimilarToRecent`**
   - Checks if the amount is similar to recent transactions.

10. **`determineAlertLevel`**
    - Determines the fraud alert level based on the results of various checks.

11. **`logFraudChecks`**
    - Logs the results of all fraud checks for auditing purposes.

### 5. **External Dependencies**
- **`FraudDetection`**: Provides methods for basic fraud checks, such as detecting duplicate cheques and abnormal amounts.
- **`ChequeHistoryManager`**: Manages historical cheque data and provides methods for retrieving cheque numbers, total cheque counts, and recent cheque counts.

#### `ChequeHistoryManager` Example:
```java
static class ChequeHistoryManager {
    private Map<String, List<ChequeRecord>> history = new HashMap<>();

    public void recordCheque(String acc, String chq, String curr, double amt, Date d) {
        history.computeIfAbsent(acc, k -> new ArrayList<>()).add(new ChequeRecord(acc, chq, curr, amt, d));
    }

    public void displayChequeHistory(String acc) {
        System.out.println("History for " + acc + ": " + history.getOrDefault(acc, Collections.emptyList()).size() + " records.");
    }
}
```

## Summary
This code chunk provides a comprehensive implementation of a fraud detection system for cheque transactions. It uses a combination of real-time and historical data to identify potential fraud and assigns an alert level based on the severity of the detected issues. The integration with `FraudDetection` and `ChequeHistoryManager` enhances its capabilities, making it a robust solution for detecting fraudulent cheque activities.