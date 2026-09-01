---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_06"
confidence_score: 0.95
external_dependencies: [Date, SimpleDateFormat, Arrays, StandardCharsets, Map, HashMap, List, ArrayList]
---

# Documentation for `DemoApplication` Code Chunk

This section of the `DemoApplication` class contains several nested classes and methods that handle various functionalities related to cheque processing, exception reporting, FIR/legal complaint handling, cheque status management, logging, image handling, cryptographic operations, and clearinghouse submissions.

## Classes and Methods

### 1. `ExceptionRecord` Class
The `ExceptionRecord` class is used to represent an exception related to a cheque. It contains the following fields:
- `accountNumber` (String): The account number associated with the cheque.
- `chequeNumber` (String): The cheque number.
- `type` (String): The type of exception (e.g., "Bounced").
- `details` (String): Additional details about the exception.
- `date` (Date): The date when the exception occurred.
- `firDetails` (FIRDetails): An optional field to store FIR/legal complaint details.

#### Constructor
```java
ExceptionRecord(String accountNumber, String chequeNumber, String type, String details, Date date)
```
Initializes an `ExceptionRecord` object with the provided details. The `firDetails` field is initialized to `null`.

---

### 2. `FIRDetails` Class
The `FIRDetails` class is used to store details of an FIR or legal complaint related to a cheque exception. It contains the following fields:
- `firNumber` (String): The FIR number.
- `policeStation` (String): The name of the police station where the FIR was filed.
- `firDate` (Date): The date of the FIR.
- `remarks` (String): Additional remarks about the FIR.

#### Constructor
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
Initializes an `FIRDetails` object with the provided FIR details.

---

### 3. Exception Reporting and FIR Handling

#### `reportException` Method
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
Adds a new `ExceptionRecord` to the `exceptions` list and logs the exception details to the console.

- **Parameters**:
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.

- **Behavior**:
  - Creates a new `ExceptionRecord` with the current date.
  - Logs the exception details to the console.

---

#### `recordFIRDetails` Method
```java
public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks)
```
Records FIR/legal complaint details for a bounced cheque exception.

- **Parameters**:
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.

- **Behavior**:
  - Searches the `exceptions` list for a matching bounced cheque exception.
  - If found, associates the FIR details with the exception and logs the update.
  - Returns `true` if the FIR details were successfully recorded, otherwise returns `false`.

---

#### `displayExceptions` Method
```java
public void displayExceptions()
```
Displays all reported cheque exceptions and their details.

- **Behavior**:
  - If no exceptions are reported, logs a message indicating this.
  - Otherwise, iterates through the `exceptions` list and prints the details of each exception.
  - If an exception is of type "Bounced" and has associated FIR details, these are also displayed.

---

### 4. `ChequeStatus` Enum
```java
enum ChequeStatus {
    ISSUED,
    PROCESSED,
    CANCELED
}
```
Represents the status of a cheque. Possible values are:
- `ISSUED`: The cheque has been issued.
- `PROCESSED`: The cheque has been processed.
- `CANCELED`: The cheque has been canceled.

---

### 5. `ChequeStatusManager` Class
The `ChequeStatusManager` class is responsible for tracking the status of cheques.

#### Fields
- `chequeStatusMap` (Map<String, ChequeStatus>): A map where the key is a combination of `accountNumber` and `chequeNumber`, and the value is the `ChequeStatus`.

#### Methods

##### `setStatus` Method
```java
public void setStatus(String accountNumber, String chequeNumber, ChequeStatus status)
```
Sets the status of a cheque.

- **Parameters**:
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `status`: The new status of the cheque.

- **Behavior**:
  - Updates the `chequeStatusMap` with the new status.
  - Logs the status update to the console.

---

##### `getStatus` Method
```java
public ChequeStatus getStatus(String accountNumber, String chequeNumber)
```
Retrieves the status of a cheque.

- **Parameters**:
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.

- **Returns**:
  - The status of the cheque, or `null` if no status is found.

---

##### `displayAllStatuses` Method
```java
public void displayAllStatuses()
```
Displays the status of all cheques.

- **Behavior**:
  - If no statuses are recorded, logs a message indicating this.
  - Otherwise, iterates through the `chequeStatusMap` and prints the status of each cheque.

---

### 6. `Logger` Class
The `Logger` class provides utility methods for logging messages at different levels.

#### Levels
- `INFO`
- `WARN`
- `ERROR`
- `DEBUG`

#### Methods
- `log(Level level, String message)`: Logs a message with the specified level and a timestamp.
- `info(String message)`: Logs an informational message.
- `warn(String message)`: Logs a warning message.
- `error(String message)`: Logs an error message.
- `debug(String message)`: Logs a debug message.

---

### 7. `ChequeImageHandler` Class
Simulates handling of cheque images.

#### `loadImageData` Method
```java
public byte[] loadImageData(String filePath)
```
Simulates loading image data from a file path.

- **Parameters**:
  - `filePath`: The path to the image file.

- **Returns**:
  - A byte array representing the image data, or `null` if the file path is invalid.

---

### 8. `CryptographyService` Class
Simulates cryptographic operations like encryption and digital signing.

#### Methods
- `encryptData(byte[] data, String key)`: Simulates encrypting data.
- `signData(byte[] data, String privateKey)`: Simulates digitally signing data.

---

### 9. `ClearinghouseService` Class
Simulates submitting cheque image data and signatures to a clearinghouse.

#### `submitToClearinghouse` Method
```java
public void submitToClearinghouse(String accountNumber, String chequeNumber, byte[] encryptedImageData, String digitalSignature)
```
Simulates the submission process.

---

### 10. `SignatureVerificationService` Class
Handles signature verification for cheques.

#### Methods
- `verifySignature(String accountNumber, String signature)`: Verifies if the provided signature matches the one on file for the account.

---