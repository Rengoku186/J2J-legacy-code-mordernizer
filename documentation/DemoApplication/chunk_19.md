---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_19"
confidence_score: 0.95
external_dependencies: ["java.util.Date", "java.util.List", "java.util.ArrayList", "java.util.HashMap", "java.util.Map", "java.text.SimpleDateFormat", "java.nio.charset.StandardCharsets", "java.util.Arrays"]
---

# Documentation for `DemoApplication` Chunk

This section of the `DemoApplication` class contains several nested classes and methods that handle various functionalities related to cheque management, exception reporting, logging, image handling, cryptographic operations, and data submission to a clearinghouse.

## Classes and Methods

### 1. **`ExceptionRecord` Class**
This class represents an exception record for a cheque. It stores details about the exception, such as the account number, cheque number, type of exception, details, and the date of the exception.

#### Constructor:
```java
ExceptionRecord(String accountNumber, String chequeNumber, String type, String details, Date date)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.
  - `date`: The date when the exception occurred.
- **Purpose:** Initializes an `ExceptionRecord` object with the provided details.

### 2. **`FIRDetails` Class**
This class represents FIR (First Information Report) or legal complaint details for a bounced cheque.

#### Constructor:
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `firNumber`: The FIR number.
  - `policeStation`: The police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Purpose:** Initializes an `FIRDetails` object with the provided details.

### 3. **`reportException` Method**
This method reports a cheque exception by creating an `ExceptionRecord` and adding it to the list of exceptions.

#### Signature:
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception.
  - `details`: Additional details about the exception.
- **Purpose:** Adds a new exception record to the list and logs the exception.

### 4. **`recordFIRDetails` Method**
This method records FIR/legal complaint details for a bounced cheque.

#### Signature:
```java
public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `firNumber`: The FIR number.
  - `policeStation`: The police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Returns:** `true` if the FIR details were successfully recorded, `false` otherwise.
- **Purpose:** Updates the `FIRDetails` for a specific bounced cheque exception.

### 5. **`displayExceptions` Method**
This method displays all reported cheque exceptions, including FIR details for bounced cheques.

#### Signature:
```java
public void displayExceptions()
```
- **Purpose:** Prints a report of all cheque exceptions, including FIR details for bounced cheques.

### 6. **`ChequeStatusManager` Class**
This class manages the status of cheques (e.g., issued, processed, canceled).

#### Methods:
- **`setStatus`**: Sets the status of a cheque.
  ```java
  public void setStatus(String accountNumber, String chequeNumber, ChequeStatus status)
  ```
- **`getStatus`**: Retrieves the status of a cheque.
  ```java
  public ChequeStatus getStatus(String accountNumber, String chequeNumber)
  ```
- **`displayAllStatuses`**: Displays all recorded cheque statuses.
  ```java
  public void displayAllStatuses()
  ```

### 7. **`Logger` Class**
A utility class for logging messages at different levels (INFO, WARN, ERROR, DEBUG).

#### Methods:
- **`log`**: Logs a message with a specified level.
  ```java
  public static void log(Level level, String message)
  ```
- **Convenience Methods:**
  - `info(String message)`
  - `warn(String message)`
  - `error(String message)`
  - `debug(String message)`

### 8. **`ChequeImageHandler` Class**
This class simulates handling of cheque images, including loading image data from a file path.

#### Method:
- **`loadImageData`**: Simulates loading image data.
  ```java
  public byte[] loadImageData(String filePath)
  ```

### 9. **`CryptographyService` Class**
This class simulates cryptographic operations like encryption and digital signing.

#### Methods:
- **`encryptData`**: Simulates encrypting data.
  ```java
  public byte[] encryptData(byte[] data, String key)
  ```
- **`signData`**: Simulates digitally signing data.
  ```java
  public String signData(byte[] data, String privateKey)
  ```

### 10. **`ClearinghouseService` Class**
This class simulates the submission of cheque image data and digital signatures to a clearinghouse.

#### Method:
- **`submitToClearinghouse`**: Simulates submitting data to a clearinghouse.
  ```java
  public void submitToClearinghouse(String accountNumber, String chequeNumber, byte[] encryptedImageData, String digitalSignature)
  ```

## Summary
This chunk of the `DemoApplication` class provides a comprehensive set of functionalities for managing cheque exceptions, FIR details, cheque statuses, logging, image handling, cryptographic operations, and clearinghouse submissions. It demonstrates a modular approach to handling various aspects of cheque processing in a simulated environment.