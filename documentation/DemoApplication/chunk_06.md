---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_06"
confidence_score: 0.95
external_dependencies: ["java.util.Date", "java.util.List", "java.util.ArrayList", "java.text.SimpleDateFormat"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger application that manages cheque processing, exception handling, and related operations. It introduces classes and methods for handling cheque exceptions, recording FIR/legal complaint details, and managing cheque statuses. Additionally, it includes utility classes for logging, image handling, cryptographic operations, and clearinghouse submissions.

## Classes and Methods

### 1. `ExceptionRecord`
This class represents a record of a cheque exception. It stores details about the exception, such as the account number, cheque number, type of exception, details, and the date of occurrence. It also has an optional field for FIR/legal complaint details.

#### Constructor
```java
ExceptionRecord(String accountNumber, String chequeNumber, String type, String details, Date date)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.
  - `date`: The date when the exception occurred.
- **Behavior:** Initializes the exception record with the provided details and sets `firDetails` to `null`.

### 2. `FIRDetails`
This class represents FIR/legal complaint details associated with a bounced cheque.

#### Constructor
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Behavior:** Initializes the FIR details with the provided information.

### 3. Methods in the Main Class

#### `reportException`
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
- **Purpose:** Adds a new exception record to the list of exceptions.
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.
- **Behavior:** Creates a new `ExceptionRecord` and adds it to the `exceptions` list. Logs the exception details to the console.

#### `recordFIRDetails`
```java
public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks)
```
- **Purpose:** Records FIR/legal complaint details for a bounced cheque.
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Behavior:** Searches for a matching `ExceptionRecord` with the specified account and cheque number and a type of "Bounced". If found, associates the FIR details with the exception record and logs the update. Returns `true` if successful, otherwise logs an error and returns `false`.

#### `displayExceptions`
```java
public void displayExceptions()
```
- **Purpose:** Displays all recorded cheque exceptions and their details.
- **Behavior:**
  - If no exceptions are recorded, logs a message indicating this.
  - Otherwise, iterates through the `exceptions` list and prints the details of each exception.
  - If an exception is of type "Bounced" and has associated FIR details, these details are also displayed.

### 4. `ChequeStatusManager`
This class manages the statuses of cheques.

#### `setStatus`
```java
public void setStatus(String accountNumber, String chequeNumber, ChequeStatus status)
```
- **Purpose:** Sets the status of a cheque.
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `status`: The new status of the cheque (e.g., `ISSUED`, `PROCESSED`, `CANCELED`).
- **Behavior:** Updates the status of the specified cheque in the `chequeStatusMap`.

#### `getStatus`
```java
public ChequeStatus getStatus(String accountNumber, String chequeNumber)
```
- **Purpose:** Retrieves the status of a cheque.
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
- **Returns:** The status of the cheque, or `null` if not found.

#### `displayAllStatuses`
```java
public void displayAllStatuses()
```
- **Purpose:** Displays the statuses of all cheques.
- **Behavior:**
  - If no statuses are recorded, logs a message indicating this.
  - Otherwise, iterates through the `chequeStatusMap` and prints the status of each cheque.

### 5. `Logger`
A utility class for logging messages at different levels (INFO, WARN, ERROR, DEBUG).

#### `log`
```java
public static void log(Level level, String message)
```
- **Purpose:** Logs a message with a specified severity level.
- **Parameters:**
  - `level`: The severity level (e.g., `INFO`, `WARN`, `ERROR`, `DEBUG`).
  - `message`: The message to log.
- **Behavior:** Prints the message to the console with a timestamp and severity level.

#### Convenience Methods
- `info(String message)`: Logs an INFO message.
- `warn(String message)`: Logs a WARN message.
- `error(String message)`: Logs an ERROR message.
- `debug(String message)`: Logs a DEBUG message.

## External Dependencies
- `java.util.Date`: Used for handling dates.
- `java.util.List` and `java.util.ArrayList`: Used for managing collections of exceptions.
- `java.text.SimpleDateFormat`: Used for formatting dates for display.

## Summary
This code chunk provides robust functionality for managing cheque exceptions, recording FIR details, and tracking cheque statuses. It also includes utility classes for logging and other operations, making it a comprehensive solution for cheque processing and exception handling.