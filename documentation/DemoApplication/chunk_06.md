---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_06"
confidence_score: 0.95
external_dependencies: ["java.util.Date", "java.util.List", "java.util.ArrayList", "java.text.SimpleDateFormat", "java.nio.charset.StandardCharsets", "java.util.Arrays"]
---

# Documentation for `DemoApplication` Code Chunk

This section of the `DemoApplication` class contains several nested classes and methods that handle various functionalities related to cheque management, exception reporting, logging, and cryptographic operations. Below is a detailed explanation of the code:

## Classes and Methods

### 1. `ExceptionRecord` Class
This class represents an exception record for a cheque. It stores details about the exception, such as the account number, cheque number, type of exception, details, and the date of the exception. Additionally, it can store FIR/legal complaint details.

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

### 2. `FIRDetails` Class
This class represents FIR/legal complaint details for a bounced cheque.

#### Constructor:
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Purpose:** Initializes an `FIRDetails` object with the provided details.

### 3. `reportException` Method
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.
- **Purpose:** Adds a new `ExceptionRecord` to the list of exceptions and logs the reported exception.

### 4. `recordFIRDetails` Method
```java
public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Returns:** `true` if the FIR details were successfully recorded, `false` otherwise.
- **Purpose:** Searches for a bounced cheque exception in the list of exceptions and associates the provided FIR details with it. Logs the result of the operation.

### 5. `displayExceptions` Method
```java
public void displayExceptions()
```
- **Purpose:** Displays all reported cheque exceptions. If an exception is of type "Bounced" and has associated FIR details, those details are also displayed.

### 6. `ChequeStatus` Enum
This enumeration represents the possible statuses of a cheque:
- `ISSUED`
- `PROCESSED`
- `CANCELED`

### 7. `ChequeStatusManager` Class
This class manages the status of cheques using a map where the key is a combination of the account number and cheque number, and the value is the `ChequeStatus`.

#### Methods:
- **`setStatus(String accountNumber, String chequeNumber, ChequeStatus status)`**
  - Sets the status of a cheque.
- **`getStatus(String accountNumber, String chequeNumber)`**
  - Retrieves the status of a cheque.
- **`displayAllStatuses()`**
  - Displays all recorded cheque statuses.

### 8. `Logger` Class
A utility class for logging messages with different levels of severity.

#### Methods:
- **`log(Level level, String message)`**
  - Logs a message with a specified severity level.
- **`info(String message)`**
  - Logs an informational message.
- **`warn(String message)`**
  - Logs a warning message.
- **`error(String message)`**
  - Logs an error message.
- **`debug(String message)`**
  - Logs a debug message.

### 9. `ChequeImageHandler` Class
This class simulates handling of cheque images.

#### Method:
- **`loadImageData(String filePath)`**
  - Simulates loading image data from a file path.
  - **Returns:** A byte array representing the image data, or `null` on failure.

### 10. `CryptographyService` Class
This class simulates cryptographic operations like encryption and digital signing.

#### Methods:
- **`encryptData(byte[] data, String key)`**
  - Simulates encrypting data using a key.
  - **Returns:** Mock encrypted data as a byte array.
- **`signData(byte[] data, String privateKey)`**
  - Simulates digitally signing data using a private key.
  - **Returns:** A mock digital signature as a string.

### 11. `ClearinghouseService` Class
This class simulates the submission of cheque image data and digital signatures to a clearinghouse.

#### Method:
- **`submitToClearinghouse(String accountNumber, String chequeNumber, byte[] encryptedImageData, String digitalSignature)`**
  - Simulates submitting cheque data to a clearinghouse.

### 12. `SignatureVerificationService` Class
This class simulates the verification of signatures on cheques.

#### Constructor:
```java
public SignatureVerificationService()
```
- Initializes the service with some sample account signatures for testing.

---

## External Dependencies
- `java.util.Date`: Used for handling date and time.
- `java.util.List` and `java.util.ArrayList`: Used for managing collections of exceptions.
- `java.text.SimpleDateFormat`: Used for formatting dates.
- `java.nio.charset.StandardCharsets`: Used for encoding strings to byte arrays.
- `java.util.Arrays`: Used for array operations, such as generating hash codes.

---

This code provides a comprehensive set of functionalities for managing cheque-related operations, including exception reporting, FIR recording, logging, image handling, cryptographic operations, and signature verification. It is designed for a banking or financial application that deals with cheque processing and related workflows.