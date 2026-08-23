---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_19"
confidence_score: 1.0
external_dependencies: ["java.util.Date", "java.util.List", "java.util.ArrayList", "java.util.Map", "java.util.HashMap", "java.text.SimpleDateFormat", "java.nio.charset.StandardCharsets", "java.util.Arrays"]
---

# Documentation for Code Chunk

This code chunk is part of a larger Java application and contains several classes and methods related to handling cheque exceptions, FIR/legal complaint details, cheque statuses, logging, cheque image handling, cryptographic operations, and clearinghouse submissions. Below is a detailed explanation of the code:

## Classes and Methods

### 1. **`ExceptionRecord` Class**
This class represents an exception record for a cheque. It stores details about the exception, such as the account number, cheque number, type of exception, details, date, and optional FIR/legal complaint details.

#### Fields:
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String type`: The type of exception (e.g., "Bounced").
- `String details`: Additional details about the exception.
- `Date date`: The date when the exception occurred.
- `FIRDetails firDetails`: An optional field to store FIR/legal complaint details for bounced cheques.

#### Constructor:
```java
ExceptionRecord(String accountNumber, String chequeNumber, String type, String details, Date date)
```
Initializes an `ExceptionRecord` object with the provided details. The `firDetails` field is initialized to `null`.

---

### 2. **`FIRDetails` Class**
This class represents FIR/legal complaint details for a bounced cheque.

#### Fields:
- `String firNumber`: The FIR number.
- `String policeStation`: The name of the police station where the FIR was filed.
- `Date firDate`: The date the FIR was filed.
- `String remarks`: Additional remarks about the FIR.

#### Constructor:
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
Initializes an `FIRDetails` object with the provided FIR details.

---

### 3. **`reportException` Method**
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
This method is used to report a cheque exception. It creates a new `ExceptionRecord` object with the provided details and the current date, and adds it to the `exceptions` list.

#### Parameters:
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String type`: The type of exception (e.g., "Bounced").
- `String details`: Additional details about the exception.

#### Behavior:
- Adds the new exception record to the `exceptions` list.
- Prints a message indicating that the exception has been reported.

---

### 4. **`recordFIRDetails` Method**
```java
public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks)
```
This method is used to record FIR/legal complaint details for a bounced cheque.

#### Parameters:
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String firNumber`: The FIR number.
- `String policeStation`: The name of the police station where the FIR was filed.
- `Date firDate`: The date the FIR was filed.
- `String remarks`: Additional remarks about the FIR.

#### Behavior:
- Searches the `exceptions` list for a matching `ExceptionRecord` with the same `accountNumber`, `chequeNumber`, and a type of "Bounced".
- If a match is found, it updates the `firDetails` field of the `ExceptionRecord` with the provided FIR details and prints a success message.
- If no match is found, it prints an error message and returns `false`.

#### Returns:
- `true` if the FIR details were successfully recorded.
- `false` if no matching exception record was found.

---

### 5. **`displayExceptions` Method**
```java
public void displayExceptions()
```
This method displays all the cheque exceptions recorded in the `exceptions` list.

#### Behavior:
- If the `exceptions` list is empty, it prints a message indicating that no exceptions have been reported.
- Otherwise, it iterates through the `exceptions` list and prints the details of each exception.
- If an exception is of type "Bounced" and has associated `FIRDetails`, it also prints the FIR details.

---

### 6. **`ChequeStatus` Enum**
This enum represents the status of a cheque. Possible values are:
- `ISSUED`
- `PROCESSED`
- `CANCELED`

---

### 7. **`ChequeStatusManager` Class**
This class manages the status of cheques.

#### Fields:
- `Map<String, ChequeStatus> chequeStatusMap`: A map where the key is a combination of `accountNumber` and `chequeNumber`, and the value is the `ChequeStatus`.

#### Methods:
- `setStatus(String accountNumber, String chequeNumber, ChequeStatus status)`: Sets the status of a cheque.
- `ChequeStatus getStatus(String accountNumber, String chequeNumber)`: Retrieves the status of a cheque.
- `displayAllStatuses()`: Displays the status of all cheques in the map.

---

### 8. **`Logger` Class**
This class provides a simple logging utility with different log levels.

#### Enum:
- `Level`: Represents log levels (`INFO`, `WARN`, `ERROR`, `DEBUG`).

#### Methods:
- `log(Level level, String message)`: Logs a message with the specified level and a timestamp.
- `info(String message)`, `warn(String message)`, `error(String message)`, `debug(String message)`: Convenience methods for logging messages at specific levels.

---

### 9. **`ChequeImageHandler` Class**
This class simulates handling of cheque images.

#### Methods:
- `loadImageData(String filePath)`: Simulates loading image data from a file path. Returns a byte array representing the image data or `null` on failure.

---

### 10. **`CryptographyService` Class**
This class simulates cryptographic operations such as encryption and digital signing.

#### Methods:
- `encryptData(byte[] data, String key)`: Simulates encrypting data by appending the key to the data.
- `signData(byte[] data, String privateKey)`: Simulates digitally signing data by creating a mock hash-like string.

---

### 11. **`ClearinghouseService` Class**
This class simulates the submission of cheque image data and digital signatures to a clearinghouse.

#### Methods:
- `submitToClearinghouse(String accountNumber, String chequeNumber, byte[] encryptedImageData, String digitalSignature)`: Simulates submitting cheque image data and a digital signature to a clearinghouse.

---

## Summary
This code chunk provides a comprehensive set of classes and methods for managing cheque exceptions, recording FIR/legal complaint details, tracking cheque statuses, logging, handling cheque images, performing cryptographic operations, and simulating interactions with a clearinghouse. It demonstrates a modular approach to handling various aspects of cheque processing in a banking or financial application.