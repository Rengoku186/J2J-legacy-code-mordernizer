---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_29"
confidence_score: 0.9
external_dependencies: []
---

# Documentation for `BatchCheque` Class

## Overview
The `BatchCheque` class is a simple data structure used to represent a cheque in the context of a cheque processing system. This system is designed to process cheques with fraud detection capabilities. The class encapsulates the details of a cheque, such as the account number, cheque number, currency, amount, and signature.

## Class Definition
```java
class BatchCheque {
    String accountNumber;
    String chequeNumber;
    String currency;
    double amount;
    String signature;

    public BatchCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature) {
        this.accountNumber = accountNumber;
        this.chequeNumber = chequeNumber;
        this.currency = currency;
        this.amount = amount;
        this.signature = signature;
    }
}
```

### Fields
- `String accountNumber`: Represents the account number associated with the cheque.
- `String chequeNumber`: Represents the unique cheque number.
- `String currency`: Specifies the currency in which the cheque is issued.
- `double amount`: Represents the monetary value of the cheque.
- `String signature`: Stores the signature associated with the cheque for validation purposes.

### Constructor
The class provides a parameterized constructor to initialize all the fields of the `BatchCheque` object.

#### Parameters:
1. `String accountNumber`: The account number associated with the cheque.
2. `String chequeNumber`: The unique cheque number.
3. `String currency`: The currency in which the cheque is issued.
4. `double amount`: The monetary value of the cheque.
5. `String signature`: The signature associated with the cheque.

### Usage
The `BatchCheque` class is used to create objects that represent individual cheques. These objects can then be processed by the cheque processing system, which may include operations like fraud detection, validation, and further processing.

Example usage:
```java
BatchCheque cheque = new BatchCheque("123456789", "987654321", "USD", 1500.00, "John Doe");
```