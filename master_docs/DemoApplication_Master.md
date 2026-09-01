# MASTER DOCUMENT: DemoApplication

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_01"
confidence_score: 1.0
external_dependencies: ["java.util", "java.text.SimpleDateFormat", "java.io.BufferedWriter", "java.io.FileWriter", "java.io.IOException", "java.time.LocalDate", "java.time.format.DateTimeFormatter", "java.text.NumberFormat", "java.util.Locale", "java.nio.charset.StandardCharsets", "java.security.SecureRandom"]
---

# Documentation for `DemoApplication.java` (Chunk 01)

This chunk of code contains import statements that bring in various Java libraries and classes. These imports are used to enable specific functionalities in the application. Below is a detailed explanation of each import and its potential purpose:

## Import Statements

### 1. `java.util.*`
- **Purpose**: Provides access to utility classes such as `List`, `Map`, `Set`, and other data structures.
- **Potential Usage**: Managing collections of data, such as lists of items or mappings between keys and values.

### 2. `java.text.SimpleDateFormat`
- **Purpose**: Used for formatting and parsing dates in a locale-sensitive manner.
- **Potential Usage**: Formatting dates into specific patterns or parsing date strings into `Date` objects.

### 3. `java.io.BufferedWriter` and `java.io.FileWriter`
- **Purpose**: Classes for writing text to files efficiently.
  - `BufferedWriter`: Buffers characters to improve writing performance.
  - `FileWriter`: Writes character streams to files.
- **Potential Usage**: Writing logs, reports, or other text-based outputs to files.

### 4. `java.io.IOException`
- **Purpose**: Exception class for handling input/output errors.
- **Potential Usage**: Catching and handling errors that occur during file operations or other I/O processes.

### 5. `java.time.LocalDate` and `java.time.format.DateTimeFormatter`
- **Purpose**: Classes from the `java.time` package for working with dates and formatting them.
  - `LocalDate`: Represents a date without a time-zone.
  - `DateTimeFormatter`: Formats and parses date-time objects.
- **Potential Usage**: Managing and formatting dates in the application.

### 6. `java.text.NumberFormat`
- **Purpose**: Provides methods for formatting and parsing numbers in a locale-sensitive manner.
- **Potential Usage**: Formatting numbers, such as currency or percentages, for display.

### 7. `java.util.Locale`
- **Purpose**: Represents a specific geographical, political, or cultural region.
- **Potential Usage**: Customizing date, time, and number formats based on the user's locale.

### 8. `java.nio.charset.StandardCharsets`
- **Purpose**: Provides constants for standard character sets (e.g., UTF-8, ISO-8859-1).
- **Potential Usage**: Ensuring consistent character encoding for text processing and file operations.

### 9. `java.security.SecureRandom`
- **Purpose**: A cryptographically strong random number generator.
- **Potential Usage**: Generating secure keys, tokens, or signatures for cryptographic operations.

## Summary
These imports collectively enable the application to:
- Work with dates, times, and numbers in a locale-sensitive manner.
- Perform file I/O operations efficiently.
- Handle exceptions related to I/O.
- Generate secure random values for cryptographic purposes.

The specific usage of these imports will depend on the implementation details in the rest of the `DemoApplication.java` file.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `DemoApplication` Main Method

## Overview
The `DemoApplication` class serves as the entry point for a comprehensive cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing a wide range of cheque-related operations. The system includes features such as fraud detection, cheque history management, currency exchange, and cheque image processing.

## Key Components and Initialization

### Services Initialized
The following services are initialized at the start of the application:
- **CurrencyExchangeService**: Handles currency exchange operations.
- **SignatureVerificationService**: Verifies cheque signatures.
- **CoreBankingSystemUpdater**: Updates the core banking system with cheque transactions.
- **UserService**: Manages user authentication and related operations.
- **ChequeHistoryManager**: Maintains and displays cheque history.
- **FraudDetectionService**: Detects fraudulent cheque activities.
- **ExceptionReportManager**: Manages and displays exception reports.
- **ChequeStatusManager**: Tracks and displays the status of cheques.
- **EmailNotificationService**: Sends email notifications for various events.
- **ChequeImageHandler**: Handles cheque image processing.
- **CryptographyService**: Provides encryption and digital signing capabilities.
- **ClearinghouseService**: Sends cheque data to the clearinghouse.

### Dependency Setup
- The `FraudDetectionService` is configured with a dependency on the `ChequeHistoryManager`.

## Login Process
The `performLogin` method is invoked to authenticate the user. It allows up to three attempts for login. If authentication fails, the application exits.

## Menu-Driven Interface
Once authenticated, the user is presented with a menu to perform various operations. The menu options include:

1. **Process a Single Cheque**: Prompts the user for cheque details and processes it using the `ChequeProcessor`.
2. **Process Multiple Cheques (Batch)**: Invokes the `processChequeBatch` method to handle batch processing of cheques.
3. **View Cheque History**: Displays the cheque history for a specified account using the `ChequeHistoryManager`.
4. **Currency Exchange Information**: Displays a currency exchange menu using the `displayCurrencyExchangeMenu` method.
5. **Generate Cheque Reports**: Handles report generation via the `handleReportGeneration` method.
6. **Scan, Encrypt, and Send Cheque Image**: Processes cheque images using the `handleChequeImageSubmission` method.
7. **Simulate Cheque Printing**: Simulates cheque printing using the `handleChequePrinting` method.
8. **Exit**: Logs out the user and exits the application.
9. **View Cheque Exception Report**: Displays exception reports using the `ExceptionReportManager`.
10. **View All Cheque Statuses**: Displays all cheque statuses using the `ChequeStatusManager`.
11. **Cancel a Cheque**: Cancels a cheque using the `ChequeProcessor`.
12. **Record FIR/Legal Complaint for Bounced Cheque**: Records FIR details for bounced cheques using the `ExceptionReportManager`.
13. **Admin: Edit IFSC/Bank Codes**: Admin functionality for managing IFSC and bank codes.
14. **Admin: Manage Batches**: Admin functionality for managing cheque batches.
15. **Admin: Reset Stuck Transactions**: Admin functionality for resetting stuck transactions.

## Key Methods

### `performLogin`
Handles user authentication by prompting for username and password. Returns an authenticated `User` object or `null` if authentication fails after three attempts.

### `processChequeBatch`
Processes multiple cheques in a batch. Collects cheque details and processes them using the `ChequeProcessor`.

### `displayCurrencyExchangeMenu`
Displays a menu for currency exchange operations, including viewing supported currencies, getting exchange rates, and converting currencies.

### `handleReportGeneration`
Generates various reports related to cheque processing and history.

### `handleChequeImageSubmission`
Handles the scanning, encryption, signing, and sending of cheque images to the clearinghouse.

### `handleChequePrinting`
Simulates the printing of a cheque by collecting payee details, amount, and date.

## Notes
- The application uses a `Scanner` for user input.
- Exception handling is implemented for invalid inputs and operations.
- The system is designed to be extensible, with new features added to the menu as needed.

This documentation provides an overview of the main method and its associated functionalities. For detailed implementation of individual services and methods, refer to their respective documentation.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.95
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService", "ChequeProcessor"]
---

# Documentation for Code Chunk

This code chunk is part of the `DemoApplication` class and contains several functionalities related to administrative operations, user login, and batch cheque processing. Below is a detailed explanation of the code:

## Purpose
The code implements a menu-driven system for administrators to manage IFSC codes, bank codes, cheque batches, and stuck transactions. It also includes methods for user login and batch cheque processing.

## Key Functionalities

### 1. Admin: Edit IFSC/Bank Codes
This section allows administrators to:
- Add or update IFSC codes and their corresponding bank codes.
- Add or update bank codes and their corresponding bank names.
- View all stored IFSC codes.
- View all stored bank codes.

**Key Methods Used:**
- `adminService.addOrUpdateIFSC(String ifsc, String bankCode)`: Adds or updates an IFSC code and its corresponding bank code.
- `adminService.addOrUpdateBankCode(String code, String name)`: Adds or updates a bank code and its corresponding bank name.
- `adminService.displayIFSCs()`: Displays all stored IFSC codes.
- `adminService.displayBankCodes()`: Displays all stored bank codes.

### 2. Admin: Manage Batches
This section allows administrators to:
- Create a new batch of cheques by entering batch details and cheque information.
- View all existing batches.
- View details of a specific batch by entering its ID.

**Key Methods Used:**
- `adminService.createBatch(String batchId, List<BatchCheque> batchCheques)`: Creates a new batch with the given ID and list of cheques.
- `adminService.displayBatches()`: Displays all existing batches.
- `adminService.displayBatchDetails(String batchId)`: Displays details of a specific batch.

**Key Class Used:**
- `BatchCheque`: Represents a cheque in a batch. It includes details such as account number, cheque number, currency, amount, and signature.

### 3. Admin: Reset Stuck Transactions
This section allows administrators to:
- Mark a cheque as stuck by entering its cheque number.
- Reset a stuck cheque by entering its cheque number.
- View all stuck transactions.

**Key Methods Used:**
- `adminService.markTransactionStuck(String chequeNumber)`: Marks a cheque as stuck.
- `adminService.resetStuckTransaction(String chequeNumber)`: Resets a stuck cheque.
- `adminService.displayStuckTransactions()`: Displays all stuck transactions.

### 4. User Login
This method handles the user login process. It allows a user to attempt login up to three times by providing a username and password. If the login is successful, the authenticated user is returned; otherwise, `null` is returned.

**Key Method:**
- `userService.authenticate(String username, String password)`: Authenticates a user based on the provided username and password.

**Key Class Used:**
- `UserService`: Manages user authentication and registration.
- `User`: Represents a user with attributes such as username, password, and role.

### 5. Batch Cheque Processing
This method handles the processing of multiple cheques in a batch. It prompts the user to enter the number of cheques and their details, and then processes them using the `ChequeProcessor` service.

**Key Methods Used:**
- `chequeProcessor.processBatch(List<BatchCheque> chequesToProcess)`: Processes a batch of cheques.

**Key Class Used:**
- `ChequeProcessor`: Handles cheque processing, including signature verification, fraud detection, and currency conversion.

## Exception Handling
The code includes exception handling to manage errors during user input and login processes. Errors are logged using the `Logger` class.

**Key Methods Used:**
- `Logger.error(String message)`: Logs an error message.
- `Logger.warn(String message)`: Logs a warning message.
- `Logger.info(String message)`: Logs an informational message.

## External Dependencies
- `AdminService`: Provides methods for managing IFSC codes, bank codes, batches, and stuck transactions.
- `BatchCheque`: Represents a cheque in a batch.
- `Logger`: Handles logging of errors, warnings, and informational messages.
- `UserService`: Manages user authentication and registration.
- `ChequeProcessor`: Handles cheque processing, including signature verification and fraud detection.

=== NEXT CHUNK ===

---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 0.95
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk contains several methods that handle different functionalities in a cheque processing application. These include:

1. **Batch Cheque Processing**: Collecting and processing batches of cheques.
2. **Currency Exchange Menu**: Displaying a menu for currency exchange operations.
3. **Report Generation**: Generating reports for cheque transactions over different time periods.
4. **Cheque Printing Simulation**: Simulating the printing of cheques.

Each method is designed to interact with specific services and handle user input via a `Scanner` object.

---

## 1. Batch Cheque Processing

### Purpose
This section processes a batch of cheques by iterating over a list of `BatchCheque` objects and invoking the `processCheque` method of the `ChequeProcessor` class.

### Key Operations
- **Adding Cheques to Batch**: Cheques are added to a list (`chequesToProcess`) using the `BatchCheque` class.
- **Processing Cheques**: Each cheque in the batch is processed using the `ChequeProcessor` service.
- **Error Handling**: Exceptions during cheque collection or processing are logged using the `Logger` class.

### External Dependencies
- `BatchCheque`: Represents a cheque with attributes like account number, cheque number, currency, amount, and signature.
- `ChequeProcessor`: Handles the processing of individual cheques.

---

## 2. Currency Exchange Menu

### Purpose
Displays a menu for currency exchange operations and handles user interactions.

### Key Operations
- **View Supported Currencies**: Fetches and displays a list of supported currencies from the `CurrencyExchangeService`.
- **Get Exchange Rate**: Retrieves the exchange rate for a specific currency.
- **Get Detailed Exchange Rate Information**: Provides detailed information, including mid, buy, sell, and fee rates for a currency.
- **Convert Currency**: Converts an amount from one currency to another.
- **Return to Main Menu**: Exits the currency exchange menu.

### External Dependencies
- `CurrencyExchangeService`: Provides methods for fetching supported currencies, exchange rates, and performing currency conversions.

---

## 3. Report Generation

### Purpose
Generates reports for cheque transactions over different time periods (daily, weekly, monthly, or custom date range).

### Key Operations
- **Select Report Type**: Allows the user to choose the type of report (daily, weekly, monthly, or custom).
- **Fetch Cheque Records**: Retrieves cheque records for the selected time period using the `ChequeHistoryManager`.
- **Generate CSV Report**: Creates a CSV file containing the cheque records and saves it to the file system.
- **Error Handling**: Handles invalid date formats and ensures the start date is not after the end date.

### External Dependencies
- `ChequeHistoryManager`: Manages cheque transaction history and provides methods for fetching records and generating reports.

---

## 4. Cheque Printing Simulation

### Purpose
Simulates the printing of a cheque by collecting necessary details from the user and invoking the `ChequePrintingService`.

### Key Operations
- **Collect Cheque Details**: Prompts the user to enter details such as payee name, amount, date, account number, and cheque number.
- **Date Parsing**: Parses the entered date and defaults to the current date if the format is invalid.
- **Simulate Printing**: Uses the `ChequePrintingService` to simulate the printing of the cheque.

### External Dependencies
- `ChequePrintingService`: Handles the simulation of cheque printing.

---

## Error Handling
Each method includes robust error handling to manage invalid user inputs, exceptions during processing, and other potential issues. Errors are logged using the `Logger` class, and user-friendly messages are displayed to guide the user.

---

## Conclusion
This code chunk demonstrates a modular approach to handling various functionalities in a cheque processing application. It leverages multiple services and classes to perform specific tasks, ensuring a clean and maintainable codebase.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_05"
confidence_score: 0.95
external_dependencies: ["ChequeImageHandler", "CryptographyService", "ClearinghouseService", "User"]
---

# Documentation for Code Chunk

This code chunk contains two main functionalities:

1. **Cheque Printing Process**
2. **Cheque Image Submission Process**

Additionally, it includes several inner classes that provide supporting services for the application.

## Cheque Printing Process

The first part of the code handles the process of collecting cheque details from the user and printing a simulated cheque. The steps are as follows:

1. **Input Collection**:
   - The user is prompted to input the payee name, amount, date, account number, and cheque number.
   - The date is parsed using `SimpleDateFormat`. If the input date is invalid, the current date is used as a fallback.

2. **Cheque Printing**:
   - The `ChequePrintingService` class is used to simulate the printing of a cheque. It formats the cheque details and prints them to the console in a structured format.

### Key Methods

#### `ChequePrintingService.printCheque`

This method takes the following parameters:
- `payeeName`: The name of the payee.
- `amount`: The amount to be paid.
- `date`: The date of the cheque.
- `accountNumber`: The account number from which the cheque is issued.
- `chequeNumber`: The cheque number.
- `bankName`: The name of the bank issuing the cheque.

The method formats the cheque details and prints them in a structured format to the console.

---

## Cheque Image Submission Process

The second part of the code handles the submission of a cheque image for processing. The steps are as follows:

1. **Input Collection**:
   - The user is prompted to input the account number, cheque number, and the file path to the cheque image.

2. **Image Handling**:
   - The `ChequeImageHandler` service is used to load the image data from the specified file path.
   - If the image data cannot be loaded, the process is aborted.

3. **Encryption**:
   - The `CryptographyService` is used to encrypt the image data using a placeholder encryption key.

4. **Digital Signing**:
   - The encrypted image data is signed using the `CryptographyService` and the current user's private key.

5. **Submission to Clearinghouse**:
   - The `ClearinghouseService` is used to submit the encrypted and signed image data to the clearinghouse for further processing.

### Key Methods

#### `handleChequeImageSubmission`

This method takes the following parameters:
- `scanner`: A `Scanner` object for reading user input.
- `imageHandler`: An instance of `ChequeImageHandler` for handling image data.
- `cryptoService`: An instance of `CryptographyService` for encryption and signing.
- `clearinghouseService`: An instance of `ClearinghouseService` for submitting data to the clearinghouse.
- `currentUser`: The currently logged-in user.

The method orchestrates the entire process of cheque image submission, from scanning to submission.

---

## Supporting Classes

### `ChequeImageHandler`

This class simulates the handling of cheque images. It includes the following method:

#### `loadImageData`
- **Parameters**: `filePath` (String) - The path to the image file.
- **Returns**: A byte array representing the image data, or `null` if the file could not be loaded.
- **Functionality**: Simulates loading image data from a file path. In a real application, this would involve actual file I/O and image processing.

### `CryptographyService`

This class simulates cryptographic operations. It includes the following methods:

#### `encryptData`
- **Parameters**: 
  - `data` (byte[]): The data to encrypt.
  - `key` (String): The encryption key.
- **Returns**: A byte array representing the encrypted data.
- **Functionality**: Simulates data encryption by appending the key to the data.

#### `signData`
- **Parameters**:
  - `data` (byte[]): The data to sign.
  - `privateKey` (String): The private key used for signing.
- **Returns**: A string representing the digital signature.
- **Functionality**: Simulates digital signing of data.

### `ClearinghouseService`

This class is responsible for submitting encrypted and signed cheque data to the clearinghouse. It includes the following method:

#### `submitToClearinghouse`
- **Parameters**:
  - `accountNumber` (String): The account number associated with the cheque.
  - `chequeNumber` (String): The cheque number.
  - `encryptedImageData` (byte[]): The encrypted image data.
  - `digitalSignature` (String): The digital signature of the encrypted data.
- **Functionality**: Simulates the submission of cheque data to a clearinghouse for processing.

---

## Notes
- The `ChequePrintingService` and `ChequeImageHandler` classes are simulations and do not perform actual printing or image processing.
- The `CryptographyService` uses placeholder methods for encryption and signing, which should be replaced with secure implementations in a real application.
- The `ClearinghouseService` is a placeholder and does not interact with a real clearinghouse system.
- The `User` class is used to represent the currently logged-in user and provides methods to retrieve user details such as username and role.

=== NEXT CHUNK ===

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

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_07"
confidence_score: 0.95
external_dependencies: [CurrencyExchangeService, CoreBankingSystemUpdater, ChequeHistoryManager, FraudDetectionService, ExceptionReportManager, ChequeStatusManager, EmailNotificationService]
---

# Documentation for `SignatureVerificationService` and `ChequeProcessor` Classes

## Overview
This code chunk contains two main classes:

1. **`SignatureVerificationService`**: A service for verifying and managing signatures associated with bank accounts. It provides functionality to verify and update signatures.
2. **`ChequeProcessor`**: A comprehensive module for processing cheques. It integrates multiple services to handle tasks such as signature verification, fraud detection, currency conversion, and updating the core banking system.

---

## `SignatureVerificationService` Class

### Purpose
The `SignatureVerificationService` class is responsible for verifying the authenticity of signatures associated with bank accounts. It maintains a map of account numbers to their corresponding signatures and provides methods to verify and update these signatures.

### Fields
- `Map<String, String> accountSignatures`: A map that stores account numbers as keys and their corresponding signatures as values.

### Constructor
- **`SignatureVerificationService()`**: Initializes the service with a set of sample account numbers and their associated signatures for demonstration purposes.

### Methods

#### `boolean verifySignature(String accountNumber, String signature)`
Verifies if the provided signature matches the one on file for the given account number.

- **Parameters**:
  - `accountNumber`: The account number to verify.
  - `signature`: The signature to verify.
- **Returns**: `true` if the signature matches or if no signature is on file (in which case the signature is added to the file). Returns `false` if the signature does not match.
- **Behavior**:
  - If no signature is on file for the account, the provided signature is accepted and stored.
  - If a signature is on file, it is compared with the provided signature.

#### `void updateSignature(String accountNumber, String newSignature)`
Updates the signature on file for a given account number.

- **Parameters**:
  - `accountNumber`: The account number for which the signature is to be updated.
  - `newSignature`: The new signature to be stored.
- **Behavior**: Updates the signature associated with the account number in the `accountSignatures` map.

---

## `ChequeProcessor` Class

### Purpose
The `ChequeProcessor` class is a high-level module designed to process cheques. It integrates various services to perform tasks such as signature verification, fraud detection, currency conversion, and updating the core banking system.

### Fields
- `CurrencyExchangeService currencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService signatureVerificationService`: Verifies signatures on cheques.
- `CoreBankingSystemUpdater coreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager chequeHistoryManager`: Manages the history of processed cheques.
- `FraudDetectionService fraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager exceptionReportManager`: Manages exception reporting for cheque processing issues.
- `ChequeStatusManager chequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService emailNotificationService`: Sends email notifications for various events.

### Constructor
- **`ChequeProcessor(...)`**: Initializes the `ChequeProcessor` with instances of the required services.

### Methods

#### `void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`
Processes a cheque by performing the following steps:

1. **Mark Cheque as Issued**:
   - If the cheque is not already tracked, it is marked as `ISSUED` using the `ChequeStatusManager`.

2. **Verify Signature**:
   - Uses the `SignatureVerificationService` to verify the signature.
   - If verification fails, an exception is reported, and an email notification is sent.

3. **Fraud Detection**:
   - Uses the `FraudDetectionService` to check for fraudulent or duplicate cheques.
   - If fraud is detected, an exception is reported, and an email notification is sent.

4. **Simulated Bounced Cheque**:
   - If the cheque amount exceeds $50,000, it is marked as bounced, and an email notification is sent.

5. **Simulated Delayed Cheque**:
   - If the cheque number ends with '9', it is marked as delayed.

6. **Currency Conversion**:
   - If the currency is not USD, the `CurrencyExchangeService` is used to fetch detailed exchange rates and convert the amount to local currency.

7. **Update Core Banking System**:
   - The `CoreBankingSystemUpdater` is used to update the core banking system with the transaction details.

---

## External Dependencies
The `ChequeProcessor` class relies on the following external services:

1. **`CurrencyExchangeService`**: Provides currency exchange rates and conversion functionality.
2. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
3. **`ChequeHistoryManager`**: Manages the history of processed cheques.
4. **`FraudDetectionService`**: Detects fraudulent or duplicate cheques.
5. **`ExceptionReportManager`**: Reports exceptions encountered during cheque processing.
6. **`ChequeStatusManager`**: Tracks the status of cheques.
7. **`EmailNotificationService`**: Sends email notifications for various events.

---

## Notes
- The `SignatureVerificationService` is a simplified implementation and may not be suitable for production use.
- The `ChequeProcessor` includes simulated scenarios for demonstration purposes, such as bounced and delayed cheques.
- The `CurrencyExchangeService` assumes USD as the base currency and fetches detailed exchange rates for other currencies.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ExceptionReportManager", "EmailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk

This code chunk is part of a larger system that handles financial transactions, specifically related to processing and canceling cheques, as well as managing currency exchange rates. Below is a detailed explanation of the functionality provided by this code.

## **Purpose**
The code is responsible for:
1. Processing cheques, including updating the core banking system, recording cheque history, and managing cheque statuses.
2. Handling errors during cheque processing by reporting exceptions and sending email notifications.
3. Canceling cheques and updating their status.
4. Providing a `CurrencyExchangeService` class for handling currency exchange rates, including fetching rates from an external API, caching rates, and providing fallback rates.

---

## **Methods and Functionalities**

### **Cheque Processing**

#### **Key Steps in Cheque Processing:**
1. **Currency Conversion and Fee Calculation:**
   - The code calculates the amount in local currency (USD) based on the exchange rate and applies a fee.
   - The final amount is printed to the console.

   ```java
   System.out.println("Currency: " + currency.toUpperCase());
   System.out.println("Original amount: " + amount);
   System.out.println("Exchange rate (buy): " + buyRate);
   System.out.println("Fee rate: " + fee);
   System.out.println("Fee amount: " + feeAmount);
   System.out.println("Amount in local currency (before fees): " + amountInLocalCurrency);

   // Apply fee
   amountInLocalCurrency -= feeAmount;
   System.out.println("Final amount in local currency (USD): " + amountInLocalCurrency);
   ```

2. **Core Banking System Update:**
   - The `CoreBankingSystemUpdater` class is used to update the core banking system with the final amount in local currency.

   ```java
   coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);
   ```

3. **Cheque History Recording:**
   - The `ChequeHistoryManager` class records the cheque details, including account number, cheque number, currency, amount, and date.

   ```java
   chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date());
   ```

4. **Cheque Status Update:**
   - The `ChequeStatusManager` class updates the status of the cheque to `PROCESSED` upon successful processing.

   ```java
   chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED);
   ```

5. **Error Handling:**
   - If an exception occurs during cheque processing, the error is logged, and the `ExceptionReportManager` class is used to report the exception.
   - An email notification is sent to the account holder using the `EmailNotificationService` class.

   ```java
   Logger.error("Error processing cheque " + chequeNumber + ": " + ex.getMessage());
   exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage());
   emailNotificationService.sendEmail(
       accountNumber + "@bank.com",
       "Cheque Processing Error",
       "An error occurred while processing cheque " + chequeNumber + " for account " + accountNumber + ": " + ex.getMessage()
   );
   ```

### **Cheque Cancellation**

#### **Method: `cancelCheque`**
- Cancels a cheque by updating its status to `CANCELED` using the `ChequeStatusManager` class.
- Logs the cancellation and prints a confirmation message to the console.
- Handles exceptions by logging the error and printing an error message to the console.

```java
public void cancelCheque(String accountNumber, String chequeNumber) {
    try {
        chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED);
        Logger.info("Cheque canceled: " + chequeNumber + " for account: " + accountNumber);
        System.out.println("Cheque " + chequeNumber + " for account " + accountNumber + " has been canceled.");
    } catch (Exception ex) {
        Logger.error("Error canceling cheque " + chequeNumber + ": " + ex.getMessage());
        System.out.println("An error occurred while canceling the cheque.");
    }
}
```

### **Currency Exchange Service**

#### **Class: `CurrencyExchangeService`**
- Provides functionalities for handling currency exchange rates, including fetching rates from an external API, caching rates, and using fallback rates.

#### **Key Methods:**
1. **`getExchangeRate(String currency)`**
   - Fetches the exchange rate for a given currency.
   - Checks the cache for a valid rate, fetches from an external API if not cached, and falls back to predefined rates if the API fetch fails.

2. **`convertCurrency(double amount, String fromCurrency, String toCurrency)`**
   - Converts an amount from one currency to another using the exchange rates.

3. **`getDetailedExchangeRates(String currency)`**
   - Provides detailed exchange rate information, including buy/sell rates and fees.

4. **`getSupportedCurrencies()`**
   - Returns a list of all supported currencies, including the base currency (USD) and fallback rates.

5. **`isCacheValid(String currency)`**
   - Checks if the cached exchange rate for a currency is still valid based on the cache expiry time.

---

## **External Dependencies**
The following external classes and services are used in this code:
1. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
2. **`ChequeHistoryManager`**: Records cheque details for historical tracking.
3. **`ChequeStatusManager`**: Manages the status of cheques (e.g., ISSUED, PROCESSED, CANCELED).
4. **`ExceptionReportManager`**: Reports exceptions that occur during cheque processing.
5. **`EmailNotificationService`**: Sends email notifications for errors or other events.
6. **`CurrencyRate`**: Represents exchange rate information, including the rate and the last updated timestamp.

=== NEXT CHUNK ===

---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Logic in `DemoApplication`

This chunk of code is part of a fraud detection service implemented in the `DemoApplication.java` file. It defines various methods and logic to detect fraudulent cheque activities based on multiple criteria. Below is a detailed explanation of the code:

## Purpose
The primary purpose of this code is to evaluate whether a cheque transaction is fraudulent by performing a series of checks. These checks include duplicate detection, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions. Based on the results of these checks, an alert level is determined, and a fraud report is generated.

## Key Components

### 1. `isFraudulentCheque`
This method is the main entry point for fraud detection. It takes the following parameters:
- `accountId`: The account ID associated with the cheque.
- `chequeNumber`: The cheque number.
- `amount`: The amount of the cheque.

It performs the following checks:
- **Duplicate Cheque Check**: Calls `checkDuplicateCheque` to determine if the cheque is a duplicate.
- **Abnormal Amount Check**: Calls `checkAbnormalAmount` to check if the amount is abnormal.
- **Suspicious Activity Check**: Calls `checkSuspiciousActivity` to detect suspicious activity.
- **Velocity Fraud Check**: Calls `checkVelocityFraud` to detect rapid transactions.
- **Pattern Fraud Check**: Calls `checkPatternFraud` to identify patterns in transaction amounts.
- **Historical Duplicate Check**: Calls `checkHistoricalDuplicate` if a `ChequeHistoryManager` is set.
- **Unusual Frequency Check**: Calls `checkUnusualFrequency` if a `ChequeHistoryManager` is set.
- **Similarity to Recent Transactions Check**: Calls `checkSimilarToRecent` if a `ChequeHistoryManager` is set.

The method then determines the fraud alert level using the `determineAlertLevel` method and logs the results using the `logFraudChecks` method.

### 2. Fraud Detection Methods

#### `checkDuplicateCheque`
Checks if the given cheque number has already been used for the specified account. It uses the `FraudDetection` class to perform this check.

#### `checkAbnormalAmount`
Checks if the cheque amount is abnormally high or low using the `FraudDetection` class.

#### `checkSuspiciousActivity`
Checks for suspicious activity based on the account ID and cheque amount using the `FraudDetection` class.

#### `checkVelocityFraud`
Detects rapid transactions within a specified time frame (`VELOCITY_CHECK_DAYS`). If the number of transactions exceeds the `VELOCITY_THRESHOLD`, it flags the account for velocity fraud.

#### `checkPatternFraud`
Analyzes recent transactions for patterns in amounts. If three or more transactions have a similarity score greater than `PATTERN_THRESHOLD`, it flags the account for pattern fraud.

#### `checkHistoricalDuplicate`
Checks if the cheque number exists in the historical records of the account using the `ChequeHistoryManager` class.

#### `checkUnusualFrequency`
Compares the recent cheque frequency with the average monthly frequency. If the recent frequency exceeds the average by a factor of `UNUSUAL_FREQUENCY_THRESHOLD`, it flags the account for unusual frequency.

#### `checkSimilarToRecent`
Checks if the cheque amount is similar to recent transactions using a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### 3. `determineAlertLevel`
Determines the fraud alert level based on the results of the checks. The alert levels are:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

The alert level is determined by assigning weights to each type of fraud and summing them up.

### 4. `logFraudChecks`
Logs the results of all fraud checks and provides a summary indicating whether any fraud was detected.

### 5. `ChequeTransaction` Class
A helper class that represents a cheque transaction with the following fields:
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

### 6. External Dependencies
- **`FraudDetection`**: A service used to perform basic fraud checks like duplicate cheques, abnormal amounts, and suspicious activity.
- **`ChequeHistoryManager`**: A service used to manage and query historical cheque data.

### Constants
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity fraud detection.
- `VELOCITY_THRESHOLD`: The maximum number of transactions allowed within the velocity check period.
- `PATTERN_THRESHOLD`: The similarity threshold for pattern fraud detection.
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for recent transaction comparison.
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for detecting unusual frequency.

## Summary
This code provides a comprehensive framework for detecting fraudulent cheque activities. It integrates multiple detection mechanisms and uses external services (`FraudDetection` and `ChequeHistoryManager`) to enhance its capabilities. The results of the checks are logged, and an appropriate alert level is determined to indicate the severity of the detected fraud.