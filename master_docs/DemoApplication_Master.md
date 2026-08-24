# MASTER DOCUMENT: DemoApplication

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_01"
confidence_score: 1.0
external_dependencies: []
---

# Documentation for `DemoApplication.java` - Chunk 01

## Overview

This code chunk consists of import statements that bring in various Java classes and packages. These imports are used to provide functionality for handling dates, formatting, file writing, random number generation, and character encoding. Below is a detailed explanation of each imported class or package and its potential purpose in the application.

---

### Imported Classes and Packages

1. **`java.util.*`**
   - This wildcard import includes all classes from the `java.util` package.
   - Commonly used classes in this package include `ArrayList`, `HashMap`, `Date`, and `Collections`.
   - Purpose: Provides utility classes for data structures, date manipulation, and other general-purpose utilities.

2. **`java.text.SimpleDateFormat`**
   - A class for formatting and parsing dates in a locale-sensitive manner.
   - Purpose: Likely used for formatting dates into specific patterns or parsing date strings.

3. **`java.io.BufferedWriter`**
   - A class for writing text to an output stream, buffering characters to provide efficient writing.
   - Purpose: Used for writing data to files or other output streams.

4. **`java.io.FileWriter`**
   - A class for writing character files.
   - Purpose: Likely used in conjunction with `BufferedWriter` to write data to files.

5. **`java.io.IOException`**
   - An exception class that signals an I/O operation failure.
   - Purpose: Used to handle errors during file or stream operations.

6. **`java.time.LocalDate`**
   - A class representing a date (year, month, day) without a time-zone.
   - Purpose: Likely used for date-related operations in the application.

7. **`java.time.format.DateTimeFormatter`**
   - A class for formatting and parsing date-time objects.
   - Purpose: Used to format `LocalDate` or other date-time objects into specific patterns.

8. **`java.text.NumberFormat`**
   - A class for formatting and parsing numbers in a locale-sensitive manner.
   - Purpose: Likely used for formatting numbers, such as currency or percentages.

9. **`java.util.Locale`**
   - A class representing a specific geographical, political, or cultural region.
   - Purpose: Used to customize locale-sensitive operations, such as date and number formatting.

10. **`java.nio.charset.StandardCharsets`**
    - A class defining standard character sets.
    - Purpose: Used for encoding and decoding text, ensuring compatibility with specific character sets (e.g., UTF-8).

11. **`java.security.SecureRandom`**
    - A class providing a cryptographically strong random number generator.
    - Purpose: Likely used for generating secure random values, such as keys or signatures.

---

### Purpose of the Imports

The imports in this chunk suggest that the `DemoApplication` class involves:
- Handling and formatting dates and times.
- Writing data to files with proper error handling.
- Formatting numbers and handling locale-specific operations.
- Encoding text in a standard character set.
- Generating secure random values, possibly for cryptographic purposes.

These imports provide a foundation for various functionalities that are likely implemented in the rest of the `DemoApplication` class.

---

### External Dependencies

This chunk does not directly depend on any external libraries or custom classes. All imports are part of the standard Java Development Kit (JDK).

---

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `DemoApplication` Class

## Overview
The `DemoApplication` class serves as the entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for users to perform various operations related to cheque processing, fraud detection, and administrative tasks.

## Key Functionalities

### `main` Method
The `main` method is the starting point of the application. It performs the following tasks:

1. **Initialization**:
   - Initializes various services required for the cheque processing system, including:
     - `CurrencyExchangeService`
     - `SignatureVerificationService`
     - `CoreBankingSystemUpdater`
     - `UserService`
     - `ChequeHistoryManager`
     - `FraudDetectionService`
     - `ExceptionReportManager`
     - `ChequeStatusManager`
     - `EmailNotificationService`
     - `ChequeImageHandler`
     - `CryptographyService`
     - `ClearinghouseService`
   - Sets up dependencies, such as linking the `FraudDetectionService` with the `ChequeHistoryManager`.

2. **User Authentication**:
   - Calls the `performLogin` method to authenticate the user. If the user fails to log in after multiple attempts, the application exits.

3. **Main Menu**:
   - Displays a menu with various options for the user to interact with the system. The options include:
     1. Process a single cheque.
     2. Process multiple cheques in a batch.
     3. View cheque history.
     4. View currency exchange information.
     5. Generate cheque reports.
     6. Scan, encrypt, and send a cheque image.
     7. Simulate cheque printing.
     8. Exit the application.
     9. View cheque exception reports.
     10. View all cheque statuses.
     11. Cancel a cheque.
     12. Record FIR/legal complaint for a bounced cheque.
     13. Admin: Edit IFSC/Bank codes.
     14. Admin: Manage batches.
     15. Admin: Reset stuck transactions.

4. **Menu Option Handling**:
   - Based on the user's choice, the application performs the corresponding operation. Some of the key operations include:
     - **Processing a Single Cheque**: The user provides details such as account number, cheque number, currency, amount, and signature. The `ChequeProcessor` processes the cheque.
     - **Processing Multiple Cheques (Batch)**: Calls the `processChequeBatch` method to handle batch processing of cheques.
     - **Viewing Cheque History**: Calls the `displayChequeHistory` method of `ChequeHistoryManager` to display the history of cheques for a given account number.
     - **Currency Exchange Information**: Calls the `displayCurrencyExchangeMenu` method to provide options for viewing and converting currency exchange rates.
     - **Generating Cheque Reports**: Calls the `handleReportGeneration` method to generate reports based on cheque history.
     - **Scanning, Encrypting, and Sending Cheque Images**: Calls the `handleChequeImageSubmission` method to handle the process of scanning, encrypting, and sending cheque images.
     - **Simulating Cheque Printing**: Calls the `handleChequePrinting` method to simulate the printing of cheques.
     - **Viewing Cheque Exception Reports**: Calls the `displayExceptions` method of `ExceptionReportManager` to display exception reports.
     - **Viewing All Cheque Statuses**: Calls the `displayAllStatuses` method of `ChequeStatusManager` to display the statuses of all cheques.
     - **Cancelling a Cheque**: Calls the `cancelCheque` method of `ChequeProcessor` to cancel a specific cheque.
     - **Recording FIR/Legal Complaint**: Calls the `recordFIRDetails` method of `ExceptionReportManager` to record details of an FIR or legal complaint for a bounced cheque.

## External Dependencies
The `DemoApplication` class relies on the following external classes and services:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies cheque signatures.
- `CoreBankingSystemUpdater`: Updates the core banking system with cheque processing results.
- `UserService`: Manages user authentication and related operations.
- `ChequeHistoryManager`: Manages and displays cheque history.
- `FraudDetectionService`: Detects potential fraud in cheque transactions.
- `ExceptionReportManager`: Manages and displays exception reports.
- `ChequeStatusManager`: Tracks and displays the status of cheques.
- `EmailNotificationService`: Sends email notifications related to cheque processing.
- `ChequeImageHandler`: Handles cheque image processing.
- `CryptographyService`: Provides encryption and signing services for cheque images.
- `ClearinghouseService`: Sends cheque images to the clearinghouse.
- `ChequeProcessor`: Processes individual and batch cheques.
- `ChequePrintingService`: Simulates cheque printing.

## Notes
- The `performLogin` method is used for user authentication. Its implementation was not provided in the code chunk but is assumed to handle user login and return an authenticated `User` object or `null` if authentication fails.
- The methods `processChequeBatch`, `displayCurrencyExchangeMenu`, `handleReportGeneration`, `handleChequeImageSubmission`, and `handleChequePrinting` are used to handle specific operations. Their implementations were not provided in the code chunk but were found in the codebase.
- The application uses a `Scanner` object for user input and provides a menu-driven interface for ease of use.
- The application includes several administrative options, such as editing IFSC/Bank codes, managing batches, and resetting stuck transactions.

## Confidence Score
The confidence score for this documentation is 0.9, as the majority of the code and its dependencies were understood and documented. However, some methods and classes were not fully explored due to the limited context provided in the code chunk.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.9
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService", "ChequeProcessor"]
---

# Documentation for Code Chunk: Admin Functionalities and Utility Methods

This code chunk is part of the `DemoApplication` class and implements several administrative functionalities, including managing IFSC/Bank codes, handling batches, and resetting stuck transactions. Additionally, it includes utility methods for user login and batch cheque processing.

## Purpose
The purpose of this code is to provide administrative functionalities for managing banking operations, such as editing IFSC/Bank codes, managing cheque batches, and handling stuck transactions. It also includes utility methods for user login and batch cheque processing.

## Code Breakdown

### Case 13: Admin - Edit IFSC/Bank Codes
This section allows the admin to:
1. Add or update IFSC codes.
2. Add or update bank codes.
3. View existing IFSC codes.
4. View existing bank codes.

#### Key Operations:
- **Add/Update IFSC**: Prompts the admin to enter an IFSC code and a corresponding bank code, which is then processed by the `adminService.addOrUpdateIFSC` method.
- **Add/Update Bank Code**: Prompts the admin to enter a bank code and a bank name, which is processed by the `adminService.addOrUpdateBankCode` method.
- **View IFSCs**: Displays all IFSC codes using `adminService.displayIFSCs`.
- **View Bank Codes**: Displays all bank codes using `adminService.displayBankCodes`.

### Case 14: Admin - Manage Batches
This section allows the admin to:
1. Create a new batch of cheques.
2. View all existing batches.
3. View details of a specific batch.

#### Key Operations:
- **Create Batch**: Prompts the admin to enter a batch ID and the number of cheques in the batch. For each cheque, the admin is prompted to enter details such as account number, cheque number, currency, amount, and signature. These details are stored in a `List<BatchCheque>` and processed by `adminService.createBatch`.
- **View Batches**: Displays all batches using `adminService.displayBatches`.
- **View Batch Details**: Prompts the admin to enter a batch ID and displays its details using `adminService.displayBatchDetails`.

### Case 15: Admin - Reset Stuck Transactions
This section allows the admin to:
1. Mark a cheque as stuck.
2. Reset a stuck cheque.
3. View all stuck transactions.

#### Key Operations:
- **Mark Cheque as Stuck**: Prompts the admin to enter a cheque number, which is then marked as stuck using `adminService.markTransactionStuck`.
- **Reset Stuck Cheque**: Prompts the admin to enter a cheque number, which is reset using `adminService.resetStuckTransaction`.
- **View Stuck Transactions**: Displays all stuck transactions using `adminService.displayStuckTransactions`.

### Utility Method: `performLogin`
This method handles the user login process. It allows up to three login attempts and authenticates the user using the `userService.authenticate` method. If authentication is successful, the user is welcomed, and their details are logged using the `Logger` class. If authentication fails after three attempts, the method returns `null`.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `userService`: An instance of the `UserService` class for user authentication.

#### Returns:
- An authenticated `User` object if login is successful.
- `null` if login fails after three attempts.

### Utility Method: `processChequeBatch`
This method handles the processing of multiple cheques in a batch. It prompts the user for the number of cheques and their details, which are stored in a `List<BatchCheque>`. The method uses the `ChequeProcessor` service for processing.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `chequeProcessor`: An instance of the `ChequeProcessor` class for processing cheques.

#### Key Operations:
- Collects details for each cheque, including account number, cheque number, currency, amount, and signature.
- Handles exceptions during input collection and logs errors using the `Logger` class.

## External Dependencies
- **`AdminService`**: Provides methods for managing IFSC codes, bank codes, batches, and stuck transactions.
- **`BatchCheque`**: Represents a cheque in a batch, including details like account number, cheque number, currency, amount, and signature.
- **`Logger`**: Used for logging information, warnings, and errors.
- **`UserService`**: Handles user authentication and management.
- **`ChequeProcessor`**: Processes cheques with functionalities like signature verification, fraud detection, and currency conversion.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger application that handles cheque processing, currency exchange, report generation, and cheque printing. It includes methods for processing cheque batches, displaying a currency exchange menu, generating reports, and simulating cheque printing. The code interacts with several external services and classes, such as `BatchCheque`, `ChequeProcessor`, `CurrencyExchangeService`, `ChequeHistoryManager`, and `ChequePrintingService`.

## Key Functionalities

### 1. **Processing Cheque Batches**
- **Purpose**: Processes a batch of cheques by iterating over a list of `BatchCheque` objects and invoking the `processCheque` method of the `ChequeProcessor` class.
- **Error Handling**: Logs errors during cheque collection and processing using a `Logger`.
- **Key Operations**:
  - Adds `BatchCheque` objects to a list (`chequesToProcess`).
  - Iterates over the list and processes each cheque using `chequeProcessor.processCheque`.

### 2. **Currency Exchange Menu**
- **Purpose**: Provides a menu-driven interface for users to interact with the `CurrencyExchangeService`.
- **Menu Options**:
  1. View supported currencies.
  2. Get the exchange rate for a specific currency.
  3. Get detailed exchange rate information (e.g., mid, buy, sell, and fee rates).
  4. Convert an amount from one currency to another.
  5. Return to the main menu.
- **Error Handling**: Validates user input and handles unsupported currencies or invalid data gracefully.

### 3. **Report Generation**
- **Purpose**: Generates reports for cheque transactions over various time periods (daily, weekly, monthly, or custom date range).
- **Key Operations**:
  - Prompts the user to select a report type.
  - Retrieves cheque records for the specified time period using `ChequeHistoryManager.getAllChequeRecordsInPeriod`.
  - Generates a CSV report using `ChequeHistoryManager.generateChequeReportCSV` and writes it to a file.
- **Error Handling**:
  - Validates date inputs for custom date ranges.
  - Handles cases where no records are found for the selected period.

### 4. **Cheque Printing Simulation**
- **Purpose**: Simulates the process of printing a cheque using the `ChequePrintingService`.
- **Key Operations**:
  - Collects user input for payee name, amount, date, account number, and cheque number.
  - Validates the date format and defaults to the current date if invalid.

## External Dependencies

### 1. **BatchCheque**
- Represents a cheque with attributes such as account number, cheque number, currency, amount, and signature.

### 2. **ChequeProcessor**
- Handles the processing of cheques, including signature verification, fraud detection, currency conversion, and updates to the core banking system.

### 3. **CurrencyExchangeService**
- Provides functionalities for currency exchange, including retrieving supported currencies, exchange rates, and converting amounts between currencies.

### 4. **ChequeHistoryManager**
- Manages cheque transaction history and provides methods for retrieving records and generating reports.

### 5. **ChequePrintingService**
- Simulates the printing of cheques based on user-provided details.

## Error Handling
- The code includes robust error handling mechanisms, such as logging errors and validating user inputs.
- Common issues like invalid date formats, unsupported currencies, and empty cheque records are handled gracefully.

## Notes
- The `Logger` class is used for error logging but is not defined in the provided code chunk.
- The `scanner` object is used for user input and is assumed to be properly initialized elsewhere in the application.
- The `BufferedWriter` and `FileWriter` classes are used for writing reports to files, and exceptions during file operations are caught and logged.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_05"
confidence_score: 0.95
external_dependencies: ["ChequeImageHandler", "CryptographyService", "ClearinghouseService", "User"]
---

# Documentation for Code Chunk

This code chunk contains two main functionalities:

1. **Cheque Printing and Input Handling**
2. **Cheque Image Submission Process**

## 1. Cheque Printing and Input Handling
This section of the code handles user input for cheque details and simulates the printing of a cheque. The process includes:

- Prompting the user for details such as payee name, amount, date, account number, and cheque number.
- Parsing the date input and handling invalid formats by defaulting to the current date.
- Using the `ChequePrintingService` to simulate the printing of a cheque with the provided details.

### Key Methods and Classes:
- **`ChequePrintingService.printCheque`**: This method formats and prints a simulated cheque with the following details:
  - Bank name
  - Payee name
  - Amount (formatted as currency)
  - Date (formatted as `dd-MMM-yyyy`)
  - Account number
  - Cheque number

### Example Output:
The cheque is printed in a formatted manner, including placeholders for the amount in words and a signature line.

---

## 2. Cheque Image Submission Process
This section handles the submission of a cheque image for processing. The process includes:

1. **Input Collection**:
   - The user is prompted to enter the account number, cheque number, and the file path to the cheque image.

2. **Image Handling**:
   - The `ChequeImageHandler` service is used to load the image data from the provided file path.
   - If the image data cannot be loaded, the process is aborted.

3. **Encryption**:
   - The `CryptographyService` encrypts the image data using a placeholder encryption key.

4. **Digital Signing**:
   - The encrypted image data is signed using a placeholder private key derived from the current user's username.

5. **Submission**:
   - The `ClearinghouseService` submits the encrypted and signed image data along with the account and cheque numbers to the clearinghouse.

### Key Methods and Classes:
- **`ChequeImageHandler.loadImageData`**: Loads image data from the specified file path.
- **`CryptographyService.encryptData`**: Encrypts the image data using a provided encryption key.
- **`CryptographyService.signData`**: Signs the encrypted image data using a private key.
- **`ClearinghouseService.submitToClearinghouse`**: Submits the processed cheque image data to the clearinghouse.

### Error Handling:
- If the image data cannot be loaded, an error message is displayed, and the process is terminated.
- The encryption and signing processes use placeholder keys, which should be replaced with secure key management in a production environment.

---

## Additional Notes:
- The `ChequeImageHandler`, `CryptographyService`, and `ClearinghouseService` classes are external dependencies. Their definitions were found in the same file and are summarized below:

### `ChequeImageHandler`:
This service is responsible for loading image data from a specified file path. It simulates the process of scanning and uploading cheque images.

### `CryptographyService`:
This service simulates cryptographic operations, including:
- **`encryptData`**: Encrypts data using a provided key (placeholder implementation).
- **`signData`**: Signs data using a private key (placeholder implementation).

### `ClearinghouseService`:
This service simulates the submission of processed cheque data to a clearinghouse for further processing.

---

## Summary
This code chunk demonstrates a simulation of cheque processing, including both physical cheque printing and digital cheque image submission. It highlights the use of various services for handling images, encryption, signing, and submission, while also showcasing error handling for invalid inputs and failed operations.

=== NEXT CHUNK ===

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

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_07"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService"]
---

# Documentation for `SignatureVerificationService` and `ChequeProcessor` Classes

## Overview
This code chunk contains two classes:
1. `SignatureVerificationService`: A service for verifying and managing signatures associated with account numbers.
2. `ChequeProcessor`: A module for processing cheques, which includes signature verification, fraud detection, currency conversion, and updating the core banking system.

---

## `SignatureVerificationService` Class

### Purpose
The `SignatureVerificationService` class is responsible for verifying signatures associated with account numbers. It maintains a mapping of account numbers to their respective signatures and provides methods to verify and update these signatures.

### Fields
- `Map<String, String> accountSignatures`: A map that stores account numbers as keys and their corresponding signatures as values.

### Constructors
- `SignatureVerificationService()`: Initializes the service with a predefined set of account numbers and their associated signatures for demonstration purposes.

### Methods

#### `boolean verifySignature(String accountNumber, String signature)`
Verifies if the provided signature matches the one on file for the given account number.

**Parameters:**
- `accountNumber` (String): The account number to verify the signature for.
- `signature` (String): The signature to verify.

**Returns:**
- `true` if the signature matches the one on file or if no signature is on file (in which case the provided signature is accepted and stored).
- `false` if the signature does not match the one on file.

**Behavior:**
1. If the account number does not exist in the `accountSignatures` map, the provided signature is accepted and stored.
2. If the account number exists, the provided signature is compared to the stored signature.
3. Logs the result of the verification process.

#### `void updateSignature(String accountNumber, String newSignature)`
Updates the signature on file for the given account number.

**Parameters:**
- `accountNumber` (String): The account number for which the signature is to be updated.
- `newSignature` (String): The new signature to be stored.

**Behavior:**
1. Updates the `accountSignatures` map with the new signature for the given account number.
2. Logs the update operation.

---

## `ChequeProcessor` Class

### Purpose
The `ChequeProcessor` class is a comprehensive module for processing cheques. It integrates multiple services to handle various aspects of cheque processing, including:
- Signature verification
- Fraud detection
- Currency conversion
- Core banking system updates
- Cheque status management
- Exception reporting
- Email notifications

### Fields
- `CurrencyExchangeService currencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService signatureVerificationService`: Verifies signatures on cheques.
- `CoreBankingSystemUpdater coreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager chequeHistoryManager`: Manages the history of processed cheques.
- `FraudDetectionService fraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager exceptionReportManager`: Manages exception reports for issues encountered during cheque processing.
- `ChequeStatusManager chequeStatusManager`: Tracks the status of cheques (e.g., issued, processed, canceled).
- `EmailNotificationService emailNotificationService`: Sends email notifications for various events.

### Constructor
- `ChequeProcessor(CurrencyExchangeService currencyExchangeService, SignatureVerificationService signatureVerificationService, CoreBankingSystemUpdater coreBankingSystemUpdater, ChequeHistoryManager chequeHistoryManager, FraudDetectionService fraudDetectionService, ExceptionReportManager exceptionReportManager, ChequeStatusManager chequeStatusManager, EmailNotificationService emailNotificationService)`:
  Initializes the `ChequeProcessor` with the required services.

### Methods

#### `void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`
Processes a cheque by performing the following steps:

**Parameters:**
- `accountNumber` (String): The account number associated with the cheque.
- `chequeNumber` (String): The unique identifier for the cheque.
- `currency` (String): The currency of the cheque amount.
- `amount` (double): The amount of the cheque.
- `signature` (String): The signature to be verified.

**Behavior:**
1. **Cheque Status Check:**
   - Checks if the cheque has already been issued. If not, marks it as issued using `ChequeStatusManager`.

2. **Signature Verification:**
   - Verifies the signature using `SignatureVerificationService`.
   - If the signature verification fails, an exception is reported using `ExceptionReportManager`, and an email notification is sent using `EmailNotificationService`.

3. **Fraud Detection:**
   - Checks for fraudulent or duplicate cheques using `FraudDetectionService`.
   - If fraud is detected, an exception is reported, and an email notification is sent.

4. **Simulated Bounced Cheque:**
   - If the cheque amount exceeds $50,000, simulates a bounced cheque due to insufficient funds.
   - Reports an exception and sends an email notification.

5. **Simulated Delayed Cheque:**
   - If the cheque number ends with '9', simulates a delayed cheque processing.
   - Reports an exception and optionally sends a notification.

6. **Currency Conversion:**
   - If the currency is not USD, fetches detailed exchange rate information using `CurrencyExchangeService`.
   - Converts the cheque amount to local currency (USD) using the buy rate and applies a fee.

7. **Core Banking System Update:**
   - Updates the core banking system with the converted amount using `CoreBankingSystemUpdater`.

---

## External Dependencies
The `ChequeProcessor` class depends on the following external services:
- `CurrencyExchangeService`: Provides currency exchange rates and conversion functionality.
- `CoreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager`: Manages the history of processed cheques.
- `FraudDetectionService`: Detects fraudulent or duplicate cheques.
- `ExceptionReportManager`: Handles exception reporting for issues encountered during cheque processing.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications for various events.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.9
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ChequeStatus", "ExceptionReportManager", "EmailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk

This code chunk is part of a larger system that processes financial transactions, specifically handling cheques and currency exchange operations. Below is a detailed explanation of the functionality provided in this chunk.

## Key Functionalities

### 1. **Processing Cheques**
The code handles cheque processing, including:
- Logging details about the currency, amount, exchange rate, and fees.
- Calculating the final amount in the local currency after applying fees.
- Updating the core banking system with the final amount.
- Recording the cheque in the cheque history.
- Updating the cheque status to `PROCESSED` upon successful processing.
- Handling exceptions during cheque processing and notifying the user via email in case of errors.

#### Key Methods and Classes Used:
- **`coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency)`**:
  Updates the core banking system with the account number and the final amount in the local currency. This method is part of the `CoreBankingSystemUpdater` class.

- **`chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date())`**:
  Records the cheque details, including account number, cheque number, currency, amount, and the current date. This method is part of the `ChequeHistoryManager` class.

- **`chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED)`**:
  Updates the status of the cheque to `PROCESSED`. This method is part of the `ChequeStatusManager` class, which uses the `ChequeStatus` enum to represent the status of cheques (e.g., `ISSUED`, `PROCESSED`, `CANCELED`).

- **`Logger.info()` and `Logger.error()`**:
  Logs information and errors during the cheque processing.

- **`exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage())`**:
  Reports any exceptions that occur during cheque processing. This method is part of the `ExceptionReportManager` class.

- **`emailNotificationService.sendEmail()`**:
  Sends an email notification to the account holder in case of a processing error. This method is part of the `EmailNotificationService` class.

### 2. **Cancelling Cheques**
The code provides functionality to cancel a cheque by updating its status to `CANCELED` and logging the action.

#### Key Methods and Classes Used:
- **`chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED)`**:
  Updates the status of the cheque to `CANCELED`.

- **`Logger.info()` and `Logger.error()`**:
  Logs information and errors during the cheque cancellation process.

### 3. **Currency Exchange Service**
The `CurrencyExchangeService` class provides functionalities for handling currency exchange operations, including fetching exchange rates, converting currencies, and providing detailed exchange rate information.

#### Key Methods:
- **`getExchangeRate(String currency)`**:
  Fetches the exchange rate for a given currency. The method first checks a local cache for the rate, then attempts to fetch it from an external API. If both fail, it falls back to predefined rates.

- **`convertCurrency(double amount, String fromCurrency, String toCurrency)`**:
  Converts an amount from one currency to another using the exchange rates.

- **`getDetailedExchangeRates(String currency)`**:
  Provides detailed exchange rate information, including buy/sell rates and fees.

- **`getSupportedCurrencies()`**:
  Returns a list of all supported currencies, including the base currency (`USD`) and fallback rates.

#### Key Attributes:
- **`exchangeRateCache`**:
  A cache for storing exchange rates to reduce API calls.

- **`FALLBACK_RATES`**:
  A predefined map of fallback exchange rates for various currencies.

- **`CACHE_EXPIRY_MINUTES`**:
  The duration (in minutes) for which cached rates are considered valid.

- **`BASE_CURRENCY`**:
  The base currency for all exchange rate calculations (default is `USD`).

#### Helper Methods:
- **`isCacheValid(String currency)`**:
  Checks if the cached exchange rate for a given currency is still valid.

## Error Handling
The code includes robust error handling mechanisms:
- Logs errors using `Logger.error()`.
- Reports exceptions using `exceptionReportManager.reportException()`.
- Notifies users via email using `emailNotificationService.sendEmail()`.

## External Dependencies
The following external classes and enums are used in this code chunk:
- **`CoreBankingSystemUpdater`**: Updates the core banking system.
- **`ChequeHistoryManager`**: Manages cheque history records.
- **`ChequeStatusManager`**: Manages the status of cheques.
- **`ChequeStatus`**: Enum representing cheque statuses (`ISSUED`, `PROCESSED`, `CANCELED`).
- **`ExceptionReportManager`**: Handles exception reporting.
- **`EmailNotificationService`**: Sends email notifications.
- **`CurrencyRate`**: Represents exchange rate information, including the rate and the last updated timestamp.

## Summary
This code chunk is a critical part of the application, handling cheque processing, cancellation, and currency exchange operations. It integrates with multiple services and includes comprehensive error handling to ensure reliability and user notification in case of issues.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_09"
confidence_score: 0.95
external_dependencies: ["CurrencyRate", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for Code Chunk

This code chunk contains several classes and methods related to currency exchange services and fraud detection mechanisms. Below is a detailed explanation of the key components:

## 1. **Currency Exchange Service**

### Purpose
The `CurrencyExchangeService` and `CurrencyExchangeServiceV2` classes provide functionality for fetching and managing currency exchange rates. They include caching mechanisms, API integration, and fallback rates for currency conversion.

### Key Methods

#### `isCacheValid(String currency)`
- **Purpose**: Checks if the cached exchange rate for a given currency is still valid.
- **Parameters**:
  - `currency`: The currency code (e.g., "USD").
- **Returns**: `true` if the cache is valid, `false` otherwise.
- **Logic**:
  - Verifies if the currency exists in the cache.
  - Compares the current time with the cache expiry time.

#### `fetchRateFromAPI(String currency)`
- **Purpose**: Fetches the exchange rate for a given currency from an external API.
- **Parameters**:
  - `currency`: The currency code.
- **Returns**: The exchange rate as a `double`.
- **Throws**: Exception if the API call fails.
- **Logic**:
  - Constructs the API URL using the base currency and API key.
  - Makes an HTTP GET request to fetch the exchange rate.
  - Parses the response (mocked in this code).

#### `clearCache()`
- **Purpose**: Clears the exchange rate cache.
- **Logic**:
  - Empties the `exchangeRateCache` map.
  - Logs a message indicating the cache has been cleared.

#### `CurrencyExchangeServiceV2`
- **Purpose**: An enhanced version of the currency exchange service with additional features and fallback rates.
- **Key Features**:
  - Uses a `cache` map for storing exchange rates.
  - Provides fallback rates for specific currencies.
  - Includes methods for fetching exchange rates, converting currencies, and retrieving detailed exchange rate information.

## 2. **CurrencyRate Class**

### Purpose
The `CurrencyRate` class is a data structure for storing exchange rate information along with a timestamp.

### Key Methods

#### Constructor
- **Parameters**:
  - `rate`: The exchange rate value.
  - `lastUpdated`: The timestamp of the last update.

#### `getRate()`
- **Returns**: The exchange rate value.

#### `getLastUpdated()`
- **Returns**: The timestamp of the last update.

## 3. **Fraud Detection Service**

### Purpose
The `FraudDetectionService` class implements various mechanisms to detect fraudulent cheque activities. It integrates with a `ChequeHistoryManager` and uses a `FraudDetection` instance for its operations.

### Key Methods

#### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
- **Purpose**: Determines if a cheque is fraudulent based on multiple checks.
- **Parameters**:
  - `accountId`: The account ID associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `amount`: The cheque amount.
- **Returns**: `true` if the cheque is fraudulent, `false` otherwise.
- **Logic**:
  - Performs various checks, including:
    - Duplicate cheque detection.
    - Abnormal amount detection.
    - Suspicious activity detection.
    - Velocity fraud detection.
    - Pattern fraud detection.
    - Historical duplicate detection (if `ChequeHistoryManager` is available).
    - Unusual frequency detection.
    - Similarity to recent transactions.
  - Logs the results of the checks.
  - Determines the fraud alert level based on the results.

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
- **Purpose**: Checks if a cheque is a duplicate.
- **Logic**:
  - Delegates the check to the `FraudDetection` instance.

#### `checkAbnormalAmount(double amount)`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Logic**:
  - Delegates the check to the `FraudDetection` instance.

### Dependencies
- **`FraudDetection`**: A class used for performing specific fraud detection checks.
- **`ChequeHistoryManager`**: Manages historical cheque data for additional fraud checks.
- **`ChequeTransaction`**: Represents individual cheque transactions.

## Summary
This code chunk provides a comprehensive implementation of currency exchange services and fraud detection mechanisms. It includes caching, API integration, fallback rates, and various fraud detection algorithms. The code demonstrates a mix of best practices and areas for improvement, such as error handling and efficient data parsing.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

This code chunk is part of a fraud detection system implemented in the `FraudDetectionServiceV1` class. It provides various methods to detect fraudulent activities related to cheque transactions. Below is a detailed explanation of the methods and their purposes:

## Key Methods

### `isFraudulentCheque`
This method determines whether a cheque transaction is fraudulent by performing a series of checks. It evaluates the following conditions:
- **Duplicate cheque**: Checks if the cheque has already been processed.
- **Abnormal amount**: Checks if the transaction amount is unusually high or low.
- **Suspicious activity**: Checks for suspicious patterns in the account's transaction history.
- **Velocity fraud**: Checks if the number of transactions within a short period exceeds a predefined threshold.
- **Pattern fraud**: Checks for repetitive patterns in transaction amounts.
- **Historical duplicate**: Checks if the cheque matches any previously processed cheques.
- **Unusual frequency**: Checks if the frequency of transactions is abnormally high compared to historical data.
- **Similar to recent**: Checks if the transaction amount is similar to recent transactions.

The method returns `true` if any of the above checks fail, indicating potential fraud.

### `determineAlertLevel`
This method calculates the fraud alert level based on the results of the individual checks. The alert levels are:
- **LOW**: Minimal risk.
- **MEDIUM**: Moderate risk.
- **HIGH**: High risk.
- **CRITICAL**: Severe risk.

The alert level is determined by assigning weights to each check and summing them up. A higher score indicates a higher alert level.

### `logFraudChecks`
This method logs the results of the fraud checks for a given transaction. It provides a detailed report, including:
- Account ID
- Cheque number
- Transaction amount
- Results of each fraud check
- A summary indicating whether fraud was detected

### Individual Check Methods

#### `checkDuplicateCheque`
- **Purpose**: Checks if a cheque with the same number has already been processed for the given account.
- **Implementation**: Calls the `isDuplicateCheque` method of the `FraudDetection` class.

#### `checkAbnormalAmount`
- **Purpose**: Checks if the transaction amount is abnormal.
- **Implementation**: Calls the `isAbnormalAmount` method of the `FraudDetection` class.

#### `checkSuspiciousActivity`
- **Purpose**: Checks for suspicious activity in the account.
- **Implementation**: Calls the `isSuspiciousActivity` method of the `FraudDetection` class.

#### `checkVelocityFraud`
- **Purpose**: Checks if the number of transactions within the last 7 days exceeds a predefined threshold.
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within the last 7 days.
  - Compares the count of recent transactions to the `VELOCITY_THRESHOLD`.

#### `checkPatternFraud`
- **Purpose**: Checks for repetitive patterns in transaction amounts.
- **Implementation**:
  - Analyzes the similarity of the current transaction amount with previous transactions.
  - Uses a similarity threshold (`PATTERN_THRESHOLD`) to identify patterns.

#### `checkHistoricalDuplicate`
- **Purpose**: Checks if the cheque matches any previously processed cheques for the account.
- **Implementation**: Calls the `getChequeNumbers` method of the `ChequeHistoryManager` class.

#### `checkUnusualFrequency`
- **Purpose**: Checks if the frequency of transactions is abnormally high compared to historical data.
- **Implementation**:
  - Retrieves the total and recent cheque counts from the `ChequeHistoryManager`.
  - Compares the recent cheque count to the average monthly frequency multiplied by a threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

#### `checkSimilarToRecent`
- **Purpose**: Checks if the transaction amount is similar to recent transactions.
- **Implementation**: Calls the `hasSimilarRecentCheque` method of the `ChequeHistoryManager` class.

### Helper Methods

#### `formatCheckResult`
- **Purpose**: Formats the result of a fraud check for logging purposes.
- **Implementation**: Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

### Nested Class: `ChequeTransaction`
This class represents a cheque transaction and contains the following fields:
- `amount`: The transaction amount.
- `date`: The date of the transaction.

It provides getter methods for these fields.

## External Dependencies
- **`FraudDetection`**: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activities.
- **`ChequeHistoryManager`**: Manages historical cheque data and provides methods for retrieving cheque history and frequency information.

## Constants
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity fraud detection (default: 7 days).
- `VELOCITY_THRESHOLD`: The maximum allowed number of transactions within the velocity check period (default: 5).
- `PATTERN_THRESHOLD`: The similarity threshold for pattern fraud detection (default: 95%).
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for recent transaction comparison (default: 90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for detecting unusual transaction frequency (default: 3x).

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses a combination of basic and advanced checks to identify potential fraud and assigns an alert level based on the severity of the detected issues. The system is modular, allowing for easy integration with external components like `FraudDetection` and `ChequeHistoryManager`.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_11"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Fraud Detection Methods in `DemoApplication`

## Overview
This code chunk is part of a fraud detection system that evaluates whether a cheque transaction is potentially fraudulent. It implements various checks, including duplicate detection, abnormal amounts, suspicious activity, velocity fraud, and pattern analysis. Additionally, it incorporates historical data checks if a `ChequeHistoryManager` is available.

The main method, `isFraudulentCheque`, orchestrates these checks and determines the overall fraud status of a cheque transaction. The results of the checks are logged, and an alert level is determined based on the severity of the detected issues.

## Key Methods

### `isFraudulentCheque`
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount)
```
This is the main method that evaluates whether a cheque is fraudulent. It performs the following steps:
1. Executes basic fraud checks: duplicate cheque, abnormal amount, suspicious activity, velocity fraud, and pattern fraud.
2. If a `ChequeHistoryManager` is available, it performs additional checks: historical duplicate, unusual frequency, and similarity to recent transactions.
3. Logs the results of all checks.
4. Determines the fraud alert level using the `determineAlertLevel` method.
5. Returns `true` if any of the checks indicate fraud; otherwise, returns `false`.

### `checkDuplicateCheque`
```java
private boolean checkDuplicateCheque(String accountId, String chequeNumber)
```
Checks if the cheque is a duplicate using the `FraudDetection` service.

### `checkAbnormalAmount`
```java
private boolean checkAbnormalAmount(double amount)
```
Checks if the cheque amount is abnormal using the `FraudDetection` service.

### `checkSuspiciousActivity`
```java
private boolean checkSuspiciousActivity(String accountId, double amount)
```
Checks for suspicious activity associated with the account and amount using the `FraudDetection` service.

### `checkVelocityFraud`
```java
private boolean checkVelocityFraud(String accountId, double amount)
```
Detects velocity fraud by analyzing the frequency of recent transactions for the account. It uses the constants:
- `VELOCITY_CHECK_DAYS`: Number of days to consider for velocity checks (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).

### `checkPatternFraud`
```java
private boolean checkPatternFraud(String accountId, double amount)
```
Analyzes transaction patterns to detect fraud. It checks if the current transaction amount is similar to at least three recent transactions using the `PATTERN_THRESHOLD` constant (95% similarity).

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
Checks if the cheque number exists in the historical records using the `ChequeHistoryManager`.

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
Detects unusual transaction frequency by comparing recent transaction counts to the average monthly frequency. It uses the `UNUSUAL_FREQUENCY_THRESHOLD` constant (3x normal frequency).

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
Checks if the current transaction amount is similar to recent transactions using the `SIMILAR_AMOUNT_THRESHOLD` constant (90% similarity).

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
Determines the fraud alert level based on the results of the checks. The alert levels are:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
Logs the results of all fraud checks and provides a summary indicating whether fraud was detected.

### `ChequeTransaction` (Inner Class)
```java
private static class ChequeTransaction
```
Represents a cheque transaction with the following fields:
- `amount`: The transaction amount.
- `date`: The transaction date.

## Constants
- `VELOCITY_CHECK_DAYS`: 7 days.
- `VELOCITY_THRESHOLD`: 5 transactions.
- `PATTERN_THRESHOLD`: 95% similarity.
- `SIMILAR_AMOUNT_THRESHOLD`: 90% similarity.
- `UNUSUAL_FREQUENCY_THRESHOLD`: 3x normal frequency.

## External Dependencies
- `FraudDetection`: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activity.
- `ChequeHistoryManager`: Manages historical cheque data and provides methods for advanced fraud checks.
- `AlertLevel`: Enum representing the fraud alert levels.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_12"
confidence_score: 0.85
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# FraudDetectionServiceV2 Class

The `FraudDetectionServiceV2` class is a service designed to detect fraudulent cheque activities. It implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` to analyze historical cheque data. This class is part of a larger system for managing and analyzing cheque transactions.

## Fields

### Private Fields

- **fraudDetection**: An instance of the `FraudDetection` class, used to perform core fraud detection operations such as checking for duplicate cheques, abnormal amounts, and suspicious activities.
- **historyManager**: An instance of the `ChequeHistoryManager` class, used to retrieve historical cheque data for fraud analysis.
- **recentTransactions**: A `Map<String, List<ChequeTransaction>>` that stores recent cheque transactions for each account.
- **duplicateChequeCounter**: A `Map<String, Integer>` that tracks the count of duplicate cheques for each account.
- **abnormalAmounts**: A `Map<String, List<Double>>` that stores abnormal cheque amounts for each account.
- **suspiciousAmounts**: A `Map<String, List<Double>>` that stores suspicious cheque amounts for each account.
- **velocityAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for velocity-based fraud detection.
- **patternAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts for pattern-based fraud detection.
- **historicalDuplicateAmounts**: A `Map<String, List<Double>>` that tracks historical duplicate cheque amounts.
- **unusualFrequencyAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts with unusual frequency.
- **similarToRecentAmounts**: A `Map<String, List<Double>>` that tracks cheque amounts similar to recent transactions.
- **fraudLogs**: A `List<String>` that stores logs of fraud detection activities.
- **totalFraudChecks**: An integer counter for the total number of fraud checks performed.

### Constants

- **VELOCITY_CHECK_DAYS**: The number of days to consider for velocity-based fraud detection (7 days).
- **VELOCITY_THRESHOLD**: The maximum number of transactions allowed within the velocity check period (5 transactions).
- **PATTERN_THRESHOLD**: The similarity threshold for pattern-based fraud detection (95%).
- **SIMILAR_AMOUNT_THRESHOLD**: The similarity threshold for detecting amounts similar to recent transactions (90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: The multiplier for detecting unusual frequency of transactions (3x normal frequency).

## Methods

### Constructor

- **FraudDetectionServiceV2()**: Initializes the service with default values and data structures. It also creates an instance of the `FraudDetection` class.

### Public Methods

- **setHistoryManager(ChequeHistoryManager historyManager)**: Sets the `ChequeHistoryManager` instance for the service.
- **isFraudulentCheque(String accountId, String chequeNumber, double amount)**: Determines if a cheque is fraudulent by performing various checks, including:
  - Duplicate cheque detection
  - Abnormal amount detection
  - Suspicious activity detection
  - Velocity-based fraud detection
  - Pattern-based fraud detection
  - Historical duplicate detection (if `historyManager` is set)
  - Unusual frequency detection (if `historyManager` is set)
  - Similar-to-recent detection (if `historyManager` is set)

  Returns `true` if any of the checks indicate fraud, otherwise returns `false`.

### Private Methods

- **checkDuplicateCheque(String accountId, String chequeNumber)**: Checks if a cheque is a duplicate using the `FraudDetection` instance.
- **checkAbnormalAmount(double amount)**: Checks if the cheque amount is abnormal using the `FraudDetection` instance.
- **checkSuspiciousActivity(String accountId, double amount)**: Checks for suspicious activity using the `FraudDetection` instance.
- **checkVelocityFraud(String accountId, double amount)**: Checks for velocity-based fraud by analyzing the number of transactions within the last 7 days.
- **checkPatternFraud(String accountId, double amount)**: Checks for pattern-based fraud by analyzing the similarity of the current cheque amount to previous transactions.
- **checkHistoricalDuplicate(String accountId, String chequeNumber)**: Checks for historical duplicates using the `ChequeHistoryManager` instance.
- **checkUnusualFrequency(String accountId)**: Checks for unusual frequency of transactions using the `ChequeHistoryManager` instance.
- **checkSimilarToRecent(String accountId, double amount)**: Checks if the cheque amount is similar to recent transactions using the `ChequeHistoryManager` instance.
- **determineAlertLevel(...)**: Determines the fraud alert level (LOW, MEDIUM, HIGH, CRITICAL) based on the results of the fraud checks.
- **logFraudChecks(...)**: Logs the results of the fraud checks for auditing and debugging purposes.

## Enums

- **AlertLevel**: Represents the severity of a fraud alert. Possible values are:
  - `LOW`
  - `MEDIUM`
  - `HIGH`
  - `CRITICAL`

## External Dependencies

- **FraudDetection**: Used for core fraud detection operations.
- **ChequeHistoryManager**: Used for retrieving historical cheque data.
- **ChequeTransaction**: Represents a cheque transaction, including details like amount and date.

## Notes

This class is a critical component of the fraud detection system. It combines real-time and historical data analysis to identify potentially fraudulent cheque activities. The integration with `ChequeHistoryManager` enhances its capabilities by allowing it to analyze historical trends and patterns.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_13"
confidence_score: 0.9
external_dependencies: ["historyManager", "formatCheckResult", "isDuplicate", "isAbnormal", "isSuspicious", "isVelocityFraud", "isPatternFraud", "isHistoricalDuplicate", "isUnusualFrequency", "isSimilarToRecent"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a fraud detection system. It performs a series of checks to identify potential fraudulent activities related to cheque transactions. The checks are divided into two categories: **Basic Checks** and **Advanced Checks**. A summary is then printed to indicate whether any fraud was detected.

## Key Components

### Basic Checks
The following checks are performed as part of the basic fraud detection:

1. **Duplicate Check**: Determines if the cheque is a duplicate.
2. **Abnormal Amount Check**: Checks if the cheque amount exceeds a predefined threshold.
3. **Suspicious Activity Check**: Identifies if the account activity is suspicious based on predefined rules.
4. **Velocity Check**: Detects rapid transactions that may indicate fraudulent behavior.
5. **Pattern Analysis**: Analyzes transaction patterns to identify anomalies.

### Advanced Checks
If the `historyManager` object is not null, additional advanced checks are performed:

1. **Historical Duplicate Check**: Checks if the cheque matches any historical duplicates.
2. **Unusual Frequency Check**: Identifies unusual transaction frequencies.
3. **Similar Recent Amount Check**: Compares the cheque amount with recent transactions to find similarities.

### Fraud Detection Summary
After performing the checks, the system evaluates whether any fraud was detected. If any of the checks fail, a fraud alert is printed. Otherwise, a message indicating no fraud is displayed.

## Methods

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed) {
    return failed ? "FAILED ⚠️" : "Passed ✓";
}
```
This method formats the result of a check. If the check fails (`failed` is `true`), it returns "FAILED ⚠️". Otherwise, it returns "Passed ✓".

### External Dependencies

#### `historyManager`
The `historyManager` object is used to perform advanced checks. It provides methods to retrieve historical cheque data and analyze transaction patterns.

#### Fraud Detection Methods
The following methods are used to perform the checks:
- `isDuplicate`: Checks for duplicate cheques.
- `isAbnormal`: Checks for abnormal cheque amounts.
- `isSuspicious`: Identifies suspicious account activity.
- `isVelocityFraud`: Detects rapid transactions.
- `isPatternFraud`: Analyzes transaction patterns.
- `isHistoricalDuplicate`: Checks for historical duplicates.
- `isUnusualFrequency`: Identifies unusual transaction frequencies.
- `isSimilarToRecent`: Compares the cheque amount with recent transactions.

## Summary
This code chunk is a critical part of the fraud detection system, providing both basic and advanced checks to identify potential fraudulent activities. The results of these checks are formatted and displayed to the user, along with a summary indicating whether any fraud was detected.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_14"
confidence_score: 0.9
external_dependencies: ["BatchCheque"]
---

# Documentation for Code Chunk

This code chunk is part of a cheque processing application. It provides functionality for managing cheque batches and handling stuck transactions. Below is a detailed explanation of the methods included in this chunk:

## Methods

### `displayBatchDetails(String batchId)`
This method retrieves and displays the details of a specific cheque batch identified by its `batchId`.

- **Parameters:**
  - `batchId` (String): The unique identifier for the batch.
- **Functionality:**
  - Retrieves the list of cheques associated with the given `batchId` from the `batches` map.
  - If the batch is not found, it prints "Batch not found." and exits the method.
  - If the batch is found, it iterates through the list of `BatchCheque` objects and prints their details, including:
    - Account number
    - Cheque number
    - Amount
    - Currency

### `markTransactionStuck(String chequeNumber)`
This method marks a cheque as "stuck" by adding its cheque number to the `stuckTransactions` set.

- **Parameters:**
  - `chequeNumber` (String): The unique identifier for the cheque.
- **Functionality:**
  - Adds the `chequeNumber` to the `stuckTransactions` set.
  - Prints a confirmation message indicating that the cheque has been marked as stuck.

### `resetStuckTransaction(String chequeNumber)`
This method removes a cheque from the "stuck" list if it exists.

- **Parameters:**
  - `chequeNumber` (String): The unique identifier for the cheque.
- **Functionality:**
  - Attempts to remove the `chequeNumber` from the `stuckTransactions` set.
  - If successful, prints a confirmation message.
  - If the cheque was not in the "stuck" list, prints a message indicating that the cheque was not marked as stuck.

### `displayStuckTransactions()`
This method displays all cheques currently marked as "stuck."

- **Parameters:**
  - None
- **Functionality:**
  - Prints a header "--- Stuck Transactions ---".
  - If the `stuckTransactions` set is empty, prints "No stuck transactions.".
  - Otherwise, iterates through the set and prints each cheque number.

## External Dependencies

- **`BatchCheque`**: This class represents a cheque and is used to store details such as account number, cheque number, amount, and currency. The exact implementation of this class was not provided in the code chunk but is referenced in the `displayBatchDetails` method.

## Notes

- The `batches` map is used to store cheque batches, where the key is the batch ID and the value is a list of `BatchCheque` objects. This map is assumed to be defined elsewhere in the class.
- The `stuckTransactions` set is used to track cheques that are marked as "stuck." This set is also assumed to be defined elsewhere in the class.

This code is part of a larger application for managing cheque processing, and the methods here focus on batch management and handling stuck transactions.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_15"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "AdminService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequeProcessor", "ChequePrintingService"]
---

# Documentation for `ChequeApplication` Class

## Overview
The `ChequeApplication` class serves as the main entry point for a cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing a wide range of cheque-related operations. The system includes enhanced fraud detection, cheque history management, and administrative tools.

## Key Features
- User authentication and session management.
- Cheque processing (single and batch).
- Fraud detection and exception reporting.
- Currency exchange information.
- Cheque image scanning, encryption, and submission.
- Administrative tools for managing IFSC codes, batches, and stuck transactions.

## Code Walkthrough

### `main` Method
The `main` method is the entry point of the application. It performs the following tasks:

1. **Initialization**:
   - Initializes various services required for cheque processing, such as:
     - `CurrencyExchangeService`
     - `SignatureVerificationService`
     - `CoreBankingSystemUpdater`
     - `UserService`
     - `ChequeHistoryManager`
     - `FraudDetectionService`
     - `ExceptionReportManager`
     - `ChequeStatusManager`
     - `EmailNotificationService`
     - `AdminService`
     - `ChequeImageHandler`
     - `CryptographyService`
     - `ClearinghouseService`
   - Sets up dependencies, such as linking the `FraudDetectionService` with the `ChequeHistoryManager`.

2. **User Authentication**:
   - Calls the `performLogin` method to authenticate the user. If authentication fails after multiple attempts, the application exits.

3. **Main Menu**:
   - Displays a menu with various options for the user to interact with the system. The options include:
     1. Process a single cheque.
     2. Process multiple cheques in a batch.
     3. View cheque history.
     4. Display currency exchange information.
     5. Generate cheque reports.
     6. Scan, encrypt, and send a cheque image.
     7. Simulate cheque printing.
     8. Exit the application.
     9. View cheque exception reports.
     10. View all cheque statuses.
     11. Cancel a cheque.
     12. Record FIR/legal complaint for a bounced cheque.
     13. Admin: Edit IFSC/Bank codes.
     14. Admin: Manage batches.
     15. Admin: Reset stuck transactions.

4. **Menu Option Handling**:
   - The user selects an option by entering a number. The application then performs the corresponding action using helper methods and services. For example:
     - **Option 1**: Processes a single cheque using the `ChequeProcessor` service.
     - **Option 2**: Processes multiple cheques in a batch using the `processChequeBatch` method.
     - **Option 3**: Displays cheque history using the `ChequeHistoryManager`.
     - **Option 4**: Displays currency exchange information using the `displayCurrencyExchangeMenu` method.
     - **Option 5**: Generates reports using the `handleReportGeneration` method.
     - **Option 6**: Handles cheque image submission using the `handleChequeImageSubmission` method.
     - **Option 7**: Simulates cheque printing using the `ChequePrintingService`.
     - **Option 8**: Logs out and exits the application.
     - **Option 9**: Displays exception reports using the `ExceptionReportManager`.
     - **Option 10**: Displays all cheque statuses using the `ChequeStatusManager`.
     - **Option 11**: Cancels a cheque using the `ChequeProcessor`.
     - **Option 12**: Records FIR/legal complaints for bounced cheques using the `ExceptionReportManager`.

### Helper Methods

#### `performLogin`
Handles user authentication by interacting with the `UserService`. If the user fails to authenticate after multiple attempts, the application exits.

#### `processChequeBatch`
Processes multiple cheques in a batch. It collects cheque details from the user and uses the `ChequeProcessor` to process each cheque.

#### `displayCurrencyExchangeMenu`
Displays a menu for currency exchange operations, such as viewing supported currencies, getting exchange rates, and converting currencies. Interacts with the `CurrencyExchangeService`.

#### `handleReportGeneration`
Generates various reports related to cheque processing. Interacts with the `ChequeHistoryManager`.

#### `handleChequeImageSubmission`
Handles the process of scanning, encrypting, signing, and sending a cheque image. Interacts with the `ChequeImageHandler`, `CryptographyService`, and `ClearinghouseService`.

#### `handleChequePrinting`
Simulates cheque printing. Uses the `ChequePrintingService`.

## External Dependencies
The `ChequeApplication` class relies on the following external services and classes:
- `CurrencyExchangeService`
- `SignatureVerificationService`
- `CoreBankingSystemUpdater`
- `UserService`
- `ChequeHistoryManager`
- `FraudDetectionService`
- `ExceptionReportManager`
- `ChequeStatusManager`
- `EmailNotificationService`
- `AdminService`
- `ChequeImageHandler`
- `CryptographyService`
- `ClearinghouseService`
- `ChequeProcessor`
- `ChequePrintingService`

## Conclusion
The `ChequeApplication` class is a comprehensive system for managing cheque-related operations, including processing, fraud detection, and administrative tasks. It is designed to be user-friendly and extensible, with a modular architecture that allows for easy integration of new features.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_16"
confidence_score: 0.95
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService", "User", "ChequeProcessor"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of the `DemoApplication` class and implements several administrative functionalities for managing IFSC codes, bank codes, cheque batches, and stuck transactions. Additionally, it includes methods for user login and batch cheque processing. The code is structured using nested switch-case statements to handle various user choices.

## Key Functionalities

### 1. **Admin: Edit IFSC/Bank Codes**
This section allows administrators to manage IFSC and bank codes. The options include:
- Adding or updating an IFSC code.
- Adding or updating a bank code.
- Viewing all IFSC codes.
- Viewing all bank codes.

#### Code Details:
- **Option 1:** Prompts the user to enter an IFSC and a bank code, then calls `adminService.addOrUpdateIFSC(ifsc, bankCode)`.
- **Option 2:** Prompts the user to enter a bank code and name, then calls `adminService.addOrUpdateBankCode(code, name)`.
- **Option 3:** Calls `adminService.displayIFSCs()` to display all IFSC codes.
- **Option 4:** Calls `adminService.displayBankCodes()` to display all bank codes.

### 2. **Admin: Manage Batches**
This section allows administrators to manage cheque batches. The options include:
- Creating a new batch.
- Viewing all batches.
- Viewing details of a specific batch.

#### Code Details:
- **Option 1:**
  - Prompts the user to enter a batch ID and the number of cheques in the batch.
  - Collects details for each cheque (account number, cheque number, currency, amount, and signature).
  - Creates a list of `BatchCheque` objects and calls `adminService.createBatch(batchId, batchCheques)`.
- **Option 2:** Calls `adminService.displayBatches()` to display all batches.
- **Option 3:** Prompts the user to enter a batch ID and calls `adminService.displayBatchDetails(viewBatchId)`.

### 3. **Admin: Reset Stuck Transactions**
This section allows administrators to manage stuck transactions. The options include:
- Marking a cheque as stuck.
- Resetting a stuck cheque.
- Viewing all stuck transactions.

#### Code Details:
- **Option 1:** Prompts the user to enter a cheque number and calls `adminService.markTransactionStuck(stuckChq)`.
- **Option 2:** Prompts the user to enter a cheque number and calls `adminService.resetStuckTransaction(resetChq)`.
- **Option 3:** Calls `adminService.displayStuckTransactions()` to display all stuck transactions.

### 4. **User Login**
The `performLogin` method handles user authentication. It allows up to three login attempts and uses the `UserService` class to authenticate users.

#### Code Details:
- Prompts the user for a username and password.
- Calls `userService.authenticate(username, password)` to validate credentials.
- Logs successful or failed login attempts using the `Logger` class.
- Returns the authenticated `User` object or `null` if login fails after three attempts.

### 5. **Batch Cheque Processing**
The `processChequeBatch` method handles the processing of multiple cheques in a batch.

#### Code Details:
- Prompts the user to enter the number of cheques in the batch.
- Collects details for each cheque (account number, cheque number, currency, amount, and signature).
- Creates a list of `BatchCheque` objects for processing.
- Handles input errors and logs them using the `Logger` class.

## External Dependencies

### 1. **AdminService**
Provides methods for managing IFSC codes, bank codes, cheque batches, and stuck transactions.

### 2. **BatchCheque**
Represents a cheque in a batch, including details such as account number, cheque number, currency, amount, and signature.

### 3. **Logger**
Used for logging information, warnings, and errors.

### 4. **UserService**
Handles user authentication and management.

### 5. **User**
Represents a user in the system, including attributes such as username, password, and role.

### 6. **ChequeProcessor**
Processes cheques with functionalities such as signature verification, fraud detection, and currency conversion.

## Error Handling
- Exceptions during user login and cheque batch processing are caught and logged using the `Logger` class.
- Input errors are handled gracefully, and the scanner buffer is cleared to avoid cascading issues.

## Conclusion
This code chunk implements critical administrative and user-facing functionalities in the `DemoApplication`. It leverages several external services and classes to provide a robust and modular design for managing banking operations.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_17"
confidence_score: 0.95
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger Java application that handles various functionalities related to cheque processing, currency exchange, report generation, and cheque printing. Below is a detailed explanation of the methods and logic implemented in this chunk.

---

### 1. **Batch Cheque Processing**

#### Purpose
The batch cheque processing logic collects cheque details, processes them in a batch, and handles any errors that occur during the process.

#### Key Operations
- **Adding Cheques to Batch**: Cheques are added to a list (`chequesToProcess`) using the `BatchCheque` class.
- **Processing Each Cheque**: The `ChequeProcessor` class is used to process each cheque in the batch.
- **Error Handling**: Errors during cheque collection or processing are logged using the `Logger` class.

#### Code Snippet
```java
chequesToProcess.add(new BatchCheque(accountNumber, chequeNumber, currency, amount, signature));
} catch (Exception ex) {
    Logger.error("Error collecting cheque batch input: " + ex.getMessage());
    scanner.nextLine(); // Clear buffer
}

System.out.println("\nProcessing batch...");
chequesToProcess.forEach(cheque -> {
    try {
        chequeProcessor.processCheque(cheque.accountNumber, cheque.chequeNumber, cheque.currency, cheque.amount, cheque.signature);
    } catch (Exception ex) {
        Logger.error("Error processing cheque in batch: " + ex.getMessage());
    }
});
```

#### External Dependencies
- **`BatchCheque`**: Represents a cheque with attributes like account number, cheque number, currency, amount, and signature.
- **`ChequeProcessor`**: A class responsible for processing cheques, including signature verification, fraud detection, and updating the core banking system.

---

### 2. **Currency Exchange Menu**

#### Purpose
Displays a menu for currency exchange operations and handles user interactions.

#### Key Operations
- **Menu Options**:
  1. View supported currencies.
  2. Get exchange rate for a specific currency.
  3. Get detailed exchange rate information (e.g., mid, buy, sell, fee rates).
  4. Convert an amount from one currency to another.
  5. Return to the main menu.
- **User Input Handling**: The `Scanner` class is used to capture user input and navigate through the menu options.
- **Integration with `CurrencyExchangeService`**: This service provides the necessary data for currency exchange operations.

#### Code Snippet
```java
System.out.println("\n--- Currency Exchange Menu ---");
System.out.println("1. View Supported Currencies");
System.out.println("2. Get Exchange Rate");
System.out.println("3. Get Detailed Exchange Rate Information");
System.out.println("4. Convert Currency");
System.out.println("5. Return to Main Menu");
System.out.print("Enter your choice: ");

int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline

switch (choice) {
    case 1:
        List<String> supportedCurrencies = currencyExchangeService.getSupportedCurrencies();
        System.out.println("\nSupported Currencies:");
        for (String currencyCode : supportedCurrencies) {
            System.out.println("- " + currencyCode);
        }
        break;
    // Other cases omitted for brevity
}
```

#### External Dependencies
- **`CurrencyExchangeService`**: Provides methods to fetch supported currencies, exchange rates, and perform currency conversion.

---

### 3. **Report Generation**

#### Purpose
Generates reports for cheque transactions over different time periods (daily, weekly, monthly, or custom date range).

#### Key Operations
- **Date Range Selection**: Allows users to select predefined or custom date ranges.
- **Fetching Records**: Uses `ChequeHistoryManager` to retrieve cheque records for the selected period.
- **CSV Report Generation**: Generates a CSV file containing the cheque records.
- **Error Handling**: Validates user input and handles file writing errors.

#### Code Snippet
```java
List<ChequeHistoryManager.ChequeRecord> records = chequeHistoryManager.getAllChequeRecordsInPeriod(startDate, endDate);

if (records.isEmpty()) {
    System.out.println("No cheque records found for the selected period.");
    return;
}

String csvData = chequeHistoryManager.generateChequeReportCSV(records);
String fileName = reportNamePrefix + startDate.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                  "_to_" + endDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + ".csv";

try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
    writer.write(csvData);
    System.out.println("Report generated successfully: " + fileName);
} catch (IOException e) {
    System.err.println("Error writing report to file: " + e.getMessage());
}
```

#### External Dependencies
- **`ChequeHistoryManager`**: Manages cheque transaction history and provides methods to fetch records and generate reports.

---

### 4. **Cheque Printing Simulation**

#### Purpose
Simulates the process of printing a cheque by collecting user input and formatting the cheque details.

#### Key Operations
- **User Input**: Collects details such as payee name, amount, date, account number, and cheque number.
- **Date Parsing**: Parses the date input and defaults to the current date if the input is invalid.

#### Code Snippet
```java
System.out.print("Enter Payee Name: ");
String payeeName = scanner.nextLine();

System.out.print("Enter Amount: ");
double amount = scanner.nextDouble();
scanner.nextLine(); // Consume newline

System.out.print("Enter Date (YYYY-MM-DD): ");
String dateStr = scanner.nextLine();
Date chequeDate;
try {
    chequeDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
} catch (java.text.ParseException e) {
    System.out.println("Invalid date format. Please use YYYY-MM-DD. Using current date.");
    chequeDate = new Date();
}
```

#### External Dependencies
- **`ChequePrintingService`**: Handles the actual printing of cheques (not shown in this chunk).

---

## Summary
This code chunk demonstrates the implementation of key functionalities in a cheque processing system, including batch processing, currency exchange, report generation, and cheque printing. It integrates with several external services and handles user input and errors effectively.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_18"
confidence_score: 0.95
external_dependencies: ["Scanner", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequePrintingService", "User"]
---

# Documentation for Code Chunk

## Overview
This code chunk contains two main functionalities:
1. **Cheque Printing Simulation**: Captures user input for cheque details and simulates the printing of a cheque.
2. **Cheque Image Submission**: Handles the process of scanning, encrypting, signing, and submitting a cheque image to a clearinghouse.

Additionally, the code includes definitions for several utility classes, such as `ChequePrintingService`, `User`, `UserService`, and `ExceptionReportManager`.

---

## 1. Cheque Printing Simulation

### Purpose
The `handleChequePrinting` method simulates the process of printing a cheque. It collects user input for the payee name, amount, date, account number, and cheque number, and then uses the `ChequePrintingService` to print a simulated cheque.

### Code Walkthrough
```java
System.out.print("Enter Payee Name: ");
String payeeName = scanner.nextLine();
```
Prompts the user to enter the payee's name and stores it in the `payeeName` variable.

```java
System.out.print("Enter Amount: ");
double amount = scanner.nextDouble();
scanner.nextLine(); // Consume newline
```
Prompts the user to enter the cheque amount and stores it in the `amount` variable. The `scanner.nextLine()` is used to consume the newline character left by `nextDouble()`.

```java
System.out.print("Enter Date (YYYY-MM-DD): ");
String dateStr = scanner.nextLine();
Date chequeDate;
try {
    chequeDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
} catch (java.text.ParseException e) {
    System.out.println("Invalid date format. Please use YYYY-MM-DD. Using current date.");
    chequeDate = new Date();
}
```
Prompts the user to enter the cheque date in the format `YYYY-MM-DD`. If the input is invalid, the current date is used as a fallback.

```java
System.out.print("Enter Account Number: ");
String accountNumber = scanner.nextLine();

System.out.print("Enter Cheque Number: ");
String chequeNumber = scanner.nextLine();
```
Prompts the user to enter the account number and cheque number, storing them in `accountNumber` and `chequeNumber` respectively.

```java
String bankName = "Global Trust Bank";
```
Sets the bank name to a default value. This can be made configurable in the future.

```java
printingService.printCheque(payeeName, amount, chequeDate, accountNumber, chequeNumber, bankName);
```
Calls the `printCheque` method of the `ChequePrintingService` to simulate the printing of the cheque with the provided details.

---

## 2. Cheque Image Submission

### Purpose
The `handleChequeImageSubmission` method facilitates the submission of a cheque image to a clearinghouse. It involves scanning the cheque image, encrypting the image data, signing the encrypted data, and submitting it to the clearinghouse.

### Code Walkthrough
```java
System.out.print("Enter Account Number for the cheque: ");
String accountNumber = scanner.nextLine();
System.out.print("Enter Cheque Number: ");
String chequeNumber = scanner.nextLine();
System.out.print("Enter path to cheque image file (e.g., /path/to/cheque.jpg): ");
String imagePath = scanner.nextLine();
```
Prompts the user to enter the account number, cheque number, and the file path to the cheque image.

```java
byte[] imageData = imageHandler.loadImageData(imagePath);
if (imageData == null) {
    System.out.println("Failed to load image data. Aborting submission.");
    return;
}
System.out.println("Cheque image \"uploaded\" successfully from: " + imagePath);
```
Uses the `ChequeImageHandler` service to load the image data from the specified file path. If the image data cannot be loaded, the process is aborted.

```java
String encryptionKey = "a-very-secure-encryption-key"; // Placeholder
byte[] encryptedImageData = cryptoService.encryptData(imageData, encryptionKey);
System.out.println("Image data encrypted.");
```
Encrypts the image data using the `CryptographyService` with a placeholder encryption key.

```java
String privateKey = currentUser.getUsername() + "-private-key"; // Placeholder
String digitalSignature = cryptoService.signData(encryptedImageData, privateKey);
System.out.println("Encrypted image data signed. Signature: " + digitalSignature.substring(0, 10) + "...");
```
Signs the encrypted image data using the `CryptographyService` and the private key derived from the current user's username. A truncated version of the digital signature is displayed.

```java
clearinghouseService.submitToClearinghouse(accountNumber, chequeNumber, encryptedImageData, digitalSignature);
```
Submits the encrypted and signed cheque image data to the clearinghouse using the `ClearinghouseService`.

---

## 3. Utility Classes

### ChequePrintingService
This class simulates the printing of a cheque. It formats the cheque details, including the payee name, amount, date, account number, and cheque number, and prints them in a structured format.

### User
Represents a user of the system, such as an employee or account holder. It includes attributes like `username`, `password`, and `role`.

### UserService
Manages user accounts and handles authentication. It includes methods for registering new users and authenticating existing users.

### ExceptionReportManager
Manages exception reports for cheques, such as bounced, duplicate, altered, or delayed cheques. It also supports recording FIR/legal complaint details for bounced cheques.

---

## External Dependencies
- `Scanner`: Used for capturing user input.
- `ChequeImageHandler`: Handles the loading of cheque image data.
- `CryptographyService`: Provides methods for encrypting and signing data.
- `ClearinghouseService`: Facilitates the submission of cheque data to a clearinghouse.
- `ChequePrintingService`: Simulates the printing of cheques.
- `User`: Represents the currently logged-in user.

---

## Notes
- The `ChequePrintingService` and `CryptographyService` are simulated and do not perform actual printing or cryptographic operations.
- The encryption key and private key used in the `handleChequeImageSubmission` method are placeholders and should be replaced with secure key management in a real system.
- The `ExceptionReportManager` class includes a nested `FIRDetails` class for handling legal complaint details related to bounced cheques.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_19"
confidence_score: 0.95
external_dependencies: ["java.util.Date", "java.util.List", "java.util.ArrayList", "java.util.Map", "java.util.HashMap", "java.text.SimpleDateFormat", "java.nio.charset.StandardCharsets", "java.util.Arrays"]
---

# Documentation for Code Chunk

This code chunk is part of a Java application that handles various operations related to cheque processing, exception reporting, and related services. Below is a detailed explanation of the classes and methods included in this chunk.

## Classes and Methods

### 1. `ExceptionRecord`
This class represents an exception record for a cheque. It stores details about the exception, such as the account number, cheque number, type of exception, and additional details.

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
- **Description:** Initializes an `ExceptionRecord` object with the provided details.

### 2. `FIRDetails`
This class represents FIR (First Information Report) or legal complaint details related to a cheque exception.

#### Constructor:
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Description:** Initializes an `FIRDetails` object with the provided details.

### 3. `reportException`
This method is used to report a cheque exception.

#### Method Signature:
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.
- **Description:** Adds a new `ExceptionRecord` to the list of exceptions and logs the reported exception.

### 4. `recordFIRDetails`
This method is used to record FIR/legal complaint details for a bounced cheque.

#### Method Signature:
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
- **Description:** Searches for a bounced cheque exception in the list of exceptions and associates the FIR details with it. Logs the result of the operation.

### 5. `displayExceptions`
This method displays all reported cheque exceptions.

#### Method Signature:
```java
public void displayExceptions()
```
- **Description:** Prints a report of all cheque exceptions, including FIR details for bounced cheques if available.

### 6. `ChequeStatus` (Enum)
This enumeration represents the status of a cheque. Possible values are:
- `ISSUED`
- `PROCESSED`
- `CANCELED`

### 7. `ChequeStatusManager`
This class manages the status of cheques.

#### Methods:
- **`setStatus(String accountNumber, String chequeNumber, ChequeStatus status)`**
  - Sets the status of a cheque.
  - Logs the updated status.

- **`getStatus(String accountNumber, String chequeNumber)`**
  - Retrieves the status of a cheque.
  - Returns `null` if no status is found.

- **`displayAllStatuses()`**
  - Displays all recorded cheque statuses.

### 8. `Logger`
This utility class provides methods for logging messages at different levels (INFO, WARN, ERROR, DEBUG).

#### Methods:
- **`log(Level level, String message)`**
  - Logs a message with the specified level and a timestamp.
- **`info(String message)`**
  - Logs an informational message.
- **`warn(String message)`**
  - Logs a warning message.
- **`error(String message)`**
  - Logs an error message.
- **`debug(String message)`**
  - Logs a debug message.

### 9. `ChequeImageHandler`
This class simulates handling cheque images.

#### Methods:
- **`loadImageData(String filePath)`**
  - Simulates loading image data from a file path.
  - Returns a byte array representing the image data or `null` on failure.

### 10. `CryptographyService`
This class simulates cryptographic operations like encryption and digital signing.

#### Methods:
- **`encryptData(byte[] data, String key)`**
  - Simulates encrypting data using a key.
  - Returns a mock encrypted byte array.

- **`signData(byte[] data, String privateKey)`**
  - Simulates digitally signing data using a private key.
  - Returns a mock digital signature.

### 11. `ClearinghouseService`
This class simulates sending data to a clearinghouse.

#### Methods:
- **`submitToClearinghouse(String accountNumber, String chequeNumber, byte[] encryptedImageData, String digitalSignature)`**
  - Simulates submitting cheque image data and a digital signature to a clearinghouse.
  - Logs the submission process and its success.

## Summary
This code chunk provides a comprehensive set of classes and methods for managing cheque exceptions, recording FIR details, handling cheque images, performing cryptographic operations, and interacting with a clearinghouse. It also includes utility classes for logging and managing cheque statuses. The code is well-structured and demonstrates a modular approach to handling various aspects of cheque processing.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_20"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService", "Logger", "ChequeStatus"]
---

# Documentation for `DemoApplication.java` (Chunk 20)

## Overview
This code chunk contains several classes and methods that simulate a banking system's cheque processing workflow. The main components include:

1. **ChequeHistoryManager**: Manages the history of cheques for different accounts.
2. **CoreBankingSystemUpdater**: Updates the core banking system with transaction details.
3. **SignatureVerificationService**: Verifies the authenticity of signatures on cheques.
4. **ChequeProcessor**: A comprehensive module that processes cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.

## Classes and Methods

### 1. `ChequeHistoryManager`
This class is responsible for managing the history of cheques for different accounts. It provides methods to record and retrieve cheque history.

#### Inner Class: `ChequeRecord`
Represents a single cheque record with the following attributes:
- `accountNumber` (String): The account number associated with the cheque.
- `chequeNumber` (String): The unique identifier for the cheque.
- `currency` (String): The currency of the cheque.
- `amount` (double): The amount of the cheque.
- `date` (Date): The date the cheque was issued.

#### Methods
- `recordCheque(String acc, String chq, String curr, double amt, Date d)`: Records a cheque for a given account.
- `displayChequeHistory(String acc)`: Displays the number of cheque records for a given account.
- `getChequeNumbers(String acc)`: Returns a list of cheque numbers for a given account (currently returns an empty list).
- `getTotalChequeCount(String acc)`: Returns the total number of cheques for a given account (currently returns 0).
- `getRecentChequeCount(String acc)`: Returns the count of recent cheques for a given account (currently returns 0).
- `hasSimilarRecentCheque(String acc, double amt, double threshold)`: Checks if there is a similar recent cheque (currently returns false).
- `getAllChequeRecordsInPeriod(LocalDate start, LocalDate end)`: Retrieves all cheque records within a specified period (currently returns an empty list).
- `generateChequeReportCSV(List<ChequeRecord> records)`: Generates a CSV report for the given list of cheque records (currently returns a placeholder string).

### 2. `CoreBankingSystemUpdater`
This class is responsible for updating the core banking system with transaction details.

#### Methods
- `updateCoreBankingSystem(String acc, double amt)`: Updates the core banking system for a given account with the specified amount.

### 3. `SignatureVerificationService`
This class provides functionality for verifying and updating signatures associated with accounts.

#### Attributes
- `accountSignatures` (Map<String, String>): A map storing account numbers and their associated signatures.

#### Constructor
- `SignatureVerificationService()`: Initializes the service with some sample account signatures for testing purposes.

#### Methods
- `verifySignature(String accountNumber, String signature)`: Verifies if the provided signature matches the one on file for the given account. If no signature is on file, it accepts the provided signature and stores it.
- `updateSignature(String accountNumber, String newSignature)`: Updates the signature on file for a given account.

### 4. `ChequeProcessor`
This class is a comprehensive module for processing cheques. It integrates various services to handle signature verification, fraud detection, currency conversion, and core banking system updates.

#### Attributes
- `currencyExchangeService` (CurrencyExchangeService): Handles currency conversion.
- `signatureVerificationService` (SignatureVerificationService): Verifies cheque signatures.
- `coreBankingSystemUpdater` (CoreBankingSystemUpdater): Updates the core banking system.
- `chequeHistoryManager` (ChequeHistoryManager): Manages cheque history.
- `fraudDetectionService` (FraudDetectionService): Detects fraudulent cheques.
- `exceptionReportManager` (ExceptionReportManager): Manages exception reporting.
- `chequeStatusManager` (ChequeStatusManager): Tracks the status of cheques.
- `emailNotificationService` (EmailNotificationService): Sends email notifications.

#### Constructor
- `ChequeProcessor(...)`: Initializes the processor with the required services.

#### Methods
- `processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`: Processes a cheque by performing the following steps:
  1. Checks and sets the status of the cheque to `ISSUED` if not already tracked.
  2. Verifies the signature using `SignatureVerificationService`. If verification fails, an exception is reported, and an email notification is sent.
  3. Detects fraud using `FraudDetectionService`. If fraud is detected, an exception is reported, and an email notification is sent.
  4. Simulates a bounced cheque if the amount exceeds 50,000. Reports an exception and sends an email notification.
  5. Simulates a delayed cheque if the cheque number ends with '9'. Reports an exception and optionally sends a notification.

## External Dependencies
The following external classes and enums are referenced in this code:
- `CurrencyExchangeService`: Handles currency conversion.
- `FraudDetectionService`: Detects fraudulent cheques.
- `ExceptionReportManager`: Manages exception reporting.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications.
- `Logger`: Logs messages and warnings.
- `ChequeStatus`: Enum representing the status of a cheque (`ISSUED`, `PROCESSED`, `CANCELED`).

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_21"
confidence_score: 0.95
external_dependencies: ["exceptionReportManager", "Logger", "coreBankingSystemUpdater", "chequeHistoryManager", "chequeStatusManager", "emailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger system that handles cheque processing, including operations such as simulating delays, currency exchange calculations, updating the core banking system, recording cheque history, and managing cheque statuses. Additionally, it includes a method to cancel cheques and a nested class for handling currency exchange rates.

## Key Functionalities

### 1. Simulating Delayed Cheques
- **Purpose**: Simulates a delay in cheque processing if the cheque number ends with '9'.
- **Key Operations**:
  - Reports the delay using `exceptionReportManager`.
  - Logs the delay using `Logger`.
  - Optionally, a notification can be sent for delayed cheques.

### 2. Currency Exchange Calculations
- **Purpose**: Converts the cheque amount to the local currency (USD) if the cheque's currency is not USD.
- **Key Operations**:
  - Fetches detailed exchange rate information using `currencyExchangeService.getDetailedExchangeRates()`.
  - Logs errors if exchange rates are unavailable.
  - Converts the amount to local currency using the buy rate and applies a fee.
  - Logs detailed information about the conversion process.

### 3. Updating the Core Banking System
- **Purpose**: Updates the core banking system with the processed cheque amount in local currency.
- **Key Operations**:
  - Uses `coreBankingSystemUpdater.updateCoreBankingSystem()` to update the system.

### 4. Recording Cheque History
- **Purpose**: Records the cheque's details in the cheque history.
- **Key Operations**:
  - Uses `chequeHistoryManager.recordCheque()` to log the cheque's details.

### 5. Managing Cheque Status
- **Purpose**: Updates the status of the cheque to `PROCESSED` upon successful processing.
- **Key Operations**:
  - Uses `chequeStatusManager.setStatus()` to update the cheque's status.
  - Logs the successful processing of the cheque using `Logger`.

### 6. Error Handling
- **Purpose**: Handles exceptions that occur during cheque processing.
- **Key Operations**:
  - Logs the error using `Logger`.
  - Reports the error using `exceptionReportManager`.
  - Sends an email notification about the error using `emailNotificationService.sendEmail()`.

### 7. Cancelling a Cheque
- **Purpose**: Cancels a cheque and updates its status.
- **Key Operations**:
  - Uses `chequeStatusManager.setStatus()` to set the cheque's status to `CANCELED`.
  - Logs the cancellation using `Logger`.

### 8. CurrencyExchangeService Class
- **Purpose**: Provides methods for handling currency exchange rates and conversions.
- **Key Methods**:
  - `getExchangeRate(String currency)`: Fetches the exchange rate for a given currency, using cached rates, external APIs, or fallback rates.
  - `convertCurrency(double amount, String fromCurrency, String toCurrency)`: Converts an amount from one currency to another.
  - `getDetailedExchangeRates(String currency)`: Provides detailed exchange rate information, including buy/sell rates and fees.

## External Dependencies
- **exceptionReportManager**: Manages the reporting of exceptions.
- **Logger**: Logs information, errors, and other messages.
- **coreBankingSystemUpdater**: Updates the core banking system with transaction details.
- **chequeHistoryManager**: Records cheque transaction history.
- **chequeStatusManager**: Manages the status of cheques (e.g., ISSUED, PROCESSED, CANCELED).
- **emailNotificationService**: Sends email notifications for errors or other events.
- **CurrencyRate**: Represents exchange rate information, including the rate and the last updated timestamp.

## Error Handling
- The code includes robust error handling mechanisms to ensure that exceptions during cheque processing are logged, reported, and notified via email.

## Notes
- The `CurrencyExchangeService` class includes a caching mechanism for exchange rates and uses fallback rates if external APIs are unavailable.
- The code assumes that USD is the base currency for all exchange rate calculations.
- The `cancelCheque` method provides a simple way to cancel a cheque and update its status.

## Potential Enhancements
- Implement a notification system for delayed cheques.
- Add more detailed logging for each step of the cheque processing workflow.
- Enhance the `CurrencyExchangeService` to support more dynamic fee calculations.
- Improve error handling to include retry mechanisms for failed API calls.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_22"
confidence_score: 0.95
external_dependencies: ["java.time.LocalDateTime", "java.net.HttpURLConnection", "org.json.simple.parser.JSONParser", "org.json.simple.JSONObject", "java.util.Collections", "java.util.HashMap", "java.util.ArrayList", "java.util.List", "java.util.Map", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

## Overview
This chunk of code is part of a legacy Java application that provides functionalities for currency exchange rate calculations, caching, and fraud detection. The code includes methods for calculating detailed exchange rates, fetching supported currencies, validating cached rates, fetching exchange rates from an external API, and clearing the cache. Additionally, it contains a secondary implementation of a currency exchange service (`CurrencyExchangeServiceV2`), a `CurrencyRate` class for storing exchange rate data, and a `FraudDetectionService` class for detecting fraudulent cheque activities.

### Code Breakdown

#### 1. **Detailed Exchange Rate Calculation**
```java
if (baseRate <= 0) {
    return Collections.emptyMap();
}

Map<String, Double> detailedRates = new HashMap<>();
detailedRates.put("mid", baseRate);

// Calculate buy rate (slightly lower than mid rate)
double buyRate = baseRate * 0.99;
detailedRates.put("buy", buyRate);

// Calculate sell rate (slightly higher than mid rate)
double sellRate = baseRate * 1.01;
detailedRates.put("sell", sellRate);

// Calculate fees
double fee = baseRate * 0.005; // 0.5% fee
detailedRates.put("fee", fee);

return detailedRates;
```
- **Purpose**: This block calculates detailed exchange rates based on a given base rate.
  - If the `baseRate` is less than or equal to 0, it returns an empty map.
  - Otherwise, it calculates the mid, buy, sell, and fee rates and stores them in a map.
  - The `buyRate` is 1% lower than the `baseRate`, the `sellRate` is 1% higher, and the `fee` is 0.5% of the `baseRate`.

#### 2. **Fetching Supported Currencies**
```java
public List<String> getSupportedCurrencies() {
    List<String> currencies = new ArrayList<>();
    currencies.add(BASE_CURRENCY);
    currencies.addAll(FALLBACK_RATES.keySet());

    // Sort alphabetically
    Collections.sort(currencies);
    return currencies;
}
```
- **Purpose**: This method returns a list of all supported currency codes.
  - It includes the base currency (`BASE_CURRENCY`) and all keys from the `FALLBACK_RATES` map.
  - The list is sorted alphabetically before being returned.

#### 3. **Cache Validation**
```java
private boolean isCacheValid(String currency) {
    if (!exchangeRateCache.containsKey(currency)) {
        return false;
    }

    CurrencyRate cachedRate = exchangeRateCache.get(currency);
    java.time.LocalDateTime now = java.time.LocalDateTime.now();
    java.time.LocalDateTime expiryTime = cachedRate.getLastUpdated().plusMinutes(CACHE_EXPIRY_MINUTES);

    return now.isBefore(expiryTime);
}
```
- **Purpose**: This method checks if the cached exchange rate for a given currency is still valid.
  - It verifies if the currency exists in the `exchangeRateCache`.
  - If the cache exists, it checks whether the cached rate has expired by comparing the current time with the expiry time (`CACHE_EXPIRY_MINUTES` after the last update).

#### 4. **Fetching Exchange Rate from External API**
```java
private double fetchRateFromAPI(String currency) throws Exception {
    String apiUrl = "https://open.er-api.com/v6/latest/" + BASE_CURRENCY + "?apikey=" + API_KEY;

    try {
        java.net.URL url = new java.net.URL(apiUrl);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new Exception("API returned status code: " + status);
        }

        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(response.toString());
        org.json.simple.JSONObject rates = (org.json.simple.JSONObject) jsonObject.get("rates");

        if (rates != null && rates.containsKey(currency)) {
            double rate = ((Number) rates.get(currency)).doubleValue();
            System.out.println("Fetched rate from API for " + currency + ": " + rate);
            return rate;
        } else {
            throw new Exception("Currency not found in API response");
        }
    } catch (Exception e) {
        System.out.println("API fetch failed: " + e.getMessage());
        throw e;
    }
}
```
- **Purpose**: This method fetches the exchange rate for a given currency from an external API.
  - It constructs the API URL using the `BASE_CURRENCY` and `API_KEY`.
  - The method handles HTTP requests, reads the response, and parses the JSON to extract the exchange rate for the specified currency.
  - If the currency is not found or an error occurs, an exception is thrown.

#### 5. **Clearing the Cache**
```java
public void clearCache() {
    exchangeRateCache.clear();
    System.out.println("Exchange rate cache cleared");
}
```
- **Purpose**: This method clears the `exchangeRateCache` and logs a message indicating that the cache has been cleared.

### Additional Classes and Services

#### `CurrencyExchangeServiceV2`
- A simplified and less efficient version of the primary currency exchange service.
- Provides similar functionalities, such as fetching exchange rates, converting currencies, and clearing the cache.
- Uses hardcoded fallback rates and a basic JSON parsing mechanism.

#### `CurrencyRate`
- A class for storing exchange rate information along with a timestamp of the last update.
- **Fields**:
  - `rate`: The exchange rate value.
  - `lastUpdated`: The timestamp of the last update.
- **Methods**:
  - `getRate()`: Returns the exchange rate.
  - `getLastUpdated()`: Returns the timestamp of the last update.

#### `FraudDetectionService`
- A service for detecting fraudulent cheque activities.
- Implements various fraud detection mechanisms, such as velocity checks, pattern matching, and unusual frequency detection.
- **Fields**:
  - `fraudDetection`: An instance of the `FraudDetection` class.
  - `historyManager`: An instance of the `ChequeHistoryManager` class.
  - `recentTransactions`: A map of recent cheque transactions.
- **Fraud Detection Parameters**:
  - `VELOCITY_CHECK_DAYS`: Number of days for velocity checks.
  - `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period.
  - `PATTERN_THRESHOLD`: Similarity threshold for pattern matching.
  - `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for transaction amounts.
  - `UNUSUAL_FREQUENCY_THRESHOLD`: Threshold for unusual transaction frequency.
- **Fraud Alert Levels**:
  - `LOW`, `MEDIUM`, `HIGH`, `CRITICAL`.

### External Dependencies
- `java.time.LocalDateTime`: Used for handling timestamps.
- `java.net.HttpURLConnection`: Used for making HTTP requests to the external API.
- `org.json.simple.parser.JSONParser` and `org.json.simple.JSONObject`: Used for parsing JSON responses from the API.
- `java.util` classes: Used for data structures like `Map`, `List`, and utility methods like `Collections.sort`.
- `FraudDetection`, `ChequeHistoryManager`, and `ChequeTransaction`: Classes used in the fraud detection service.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_23"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation: Fraud Detection Service

This code chunk is part of a `FraudDetectionService` class, which is responsible for detecting fraudulent activities related to cheque transactions. It uses various thresholds and checks to identify potential fraud and assigns an alert level based on the severity of the detected issues.

## Constants

### Fraud Detection Thresholds
- **`VELOCITY_CHECK_DAYS`**: Number of days to consider for velocity checks (default: `7` days).
- **`VELOCITY_THRESHOLD`**: Maximum number of transactions allowed within the velocity check period (default: `5`).
- **`PATTERN_THRESHOLD`**: Similarity threshold for pattern analysis (default: `0.95` or 95%).
- **`SIMILAR_AMOUNT_THRESHOLD`**: Similarity threshold for recent cheque amounts (default: `0.90` or 90%).
- **`UNUSUAL_FREQUENCY_THRESHOLD`**: Multiplier for detecting unusual frequency of transactions (default: `3x`).

### Fraud Alert Levels
The `AlertLevel` enum defines the severity levels of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## Constructor

### `FraudDetectionService()`
Initializes the `FraudDetectionService` with the following:
- `fraudDetection`: An instance of the `FraudDetection` class.
- `recentTransactions`: A `HashMap` to store recent transactions for each account.

## Methods

### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `ChequeHistoryManager` instance to enable historical checks for fraud detection.

### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Determines whether a cheque is fraudulent by performing the following checks:
1. **Duplicate Cheque Check**: Uses `checkDuplicateCheque` to verify if the cheque has already been processed.
2. **Abnormal Amount Check**: Uses `checkAbnormalAmount` to detect unusually high amounts.
3. **Suspicious Activity Check**: Uses `checkSuspiciousActivity` to identify suspicious account activity.
4. **Velocity Fraud Check**: Uses `checkVelocityFraud` to detect rapid transactions within a short period.
5. **Pattern Fraud Check**: Uses `checkPatternFraud` to identify patterns in transaction amounts.
6. **Historical Duplicate Check**: Uses `checkHistoricalDuplicate` to find duplicate cheques in historical data (if `ChequeHistoryManager` is set).
7. **Unusual Frequency Check**: Uses `checkUnusualFrequency` to detect unusually high transaction frequency (if `ChequeHistoryManager` is set).
8. **Similar Recent Amount Check**: Uses `checkSimilarToRecent` to find recent cheques with similar amounts (if `ChequeHistoryManager` is set).

Logs the results of these checks using `logFraudChecks` and determines the alert level using `determineAlertLevel`.

Returns `true` if any of the checks indicate fraud; otherwise, returns `false`.

### Private Helper Methods

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
Checks if the cheque has already been processed using the `FraudDetection.isDuplicateCheque` method.

#### `checkAbnormalAmount(double amount)`
Checks if the cheque amount exceeds a predefined threshold using the `FraudDetection.isAbnormalAmount` method.

#### `checkSuspiciousActivity(String accountId, double amount)`
Checks for suspicious activity in the account using the `FraudDetection.isSuspiciousActivity` method.

#### `checkVelocityFraud(String accountId, double amount)`
Detects rapid transactions within a short period (velocity fraud). It:
- Tracks recent transactions for the account.
- Filters transactions within the last `VELOCITY_CHECK_DAYS`.
- Returns `true` if the number of recent transactions exceeds `VELOCITY_THRESHOLD`.

#### `checkPatternFraud(String accountId, double amount)`
Analyzes patterns in transaction amounts to detect fraud. It:
- Compares the current amount with past amounts.
- Calculates similarity using the `PATTERN_THRESHOLD`.
- Returns `true` if at least three past transactions are similar to the current one.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Checks for duplicate cheques in historical data using the `ChequeHistoryManager.getChequeNumbers` method.

#### `checkUnusualFrequency(String accountId)`
Detects unusually high transaction frequency by comparing recent transactions to the average monthly frequency. Uses the `ChequeHistoryManager.getTotalChequeCount` and `ChequeHistoryManager.getRecentChequeCount` methods.

#### `checkSimilarToRecent(String accountId, double amount)`
Checks if the current cheque amount is similar to recent amounts using the `ChequeHistoryManager.hasSimilarRecentCheque` method and the `SIMILAR_AMOUNT_THRESHOLD`.

#### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of the checks. Assigns weights to each check and calculates a total fraud score:
- `CRITICAL`: Fraud score >= 5 or duplicate/historical duplicate detected.
- `HIGH`: Fraud score >= 3.
- `MEDIUM`: Fraud score >= 2.
- `LOW`: Fraud score < 2.

#### `logFraudChecks(...)`
Logs the results of all fraud checks and provides a summary indicating whether fraud was detected.

#### `formatCheckResult(boolean failed)`
Formats the result of a fraud check as either `FAILED ⚠️` or `Passed ✓`.

### Inner Class: `ChequeTransaction`
Represents a cheque transaction with the following fields:
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

#### Constructor
- `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes a cheque transaction with the specified amount and date.

#### Methods
- `getAmount()`: Returns the transaction amount.
- `getDate()`: Returns the transaction date.

## External Dependencies
- **`FraudDetection`**: Provides methods for detecting duplicate cheques, abnormal amounts, and suspicious activity.
- **`ChequeHistoryManager`**: Provides historical data for cheques, including cheque numbers, total cheque count, and recent cheque count.

## Summary
The `FraudDetectionService` class is a comprehensive solution for detecting cheque-related fraud. It combines real-time and historical data analysis to identify various types of fraudulent activities and assigns an appropriate alert level based on the severity of the detected issues.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_24"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a fraud detection system implemented in Java. It includes methods and classes for detecting fraudulent cheque activities. The main components in this chunk are:

1. **Summary Output**: Prints a summary of fraud detection results.
2. **Helper Methods**: Includes utility methods for formatting results and performing specific fraud checks.
3. **`ChequeTransaction` Class**: Represents a cheque transaction with attributes for amount and date.
4. **`FraudDetectionServiceV1` Class**: Implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` for historical data analysis.

## Code Components

### Summary Output
```java
System.out.println("\n--- Summary ---");
if (anyFraudDetected) {
    System.out.println("⚠️ FRAUD ALERT: Potential fraud detected!");
} else {
    System.out.println("✓ No fraud detected.");
}
System.out.println("=============================\n");
```
This block prints a summary of the fraud detection results. If any fraud is detected, it displays a warning; otherwise, it confirms no fraud was found.

### `formatCheckResult` Method
```java
private String formatCheckResult(boolean failed) {
    return failed ? "FAILED ⚠️" : "Passed ✓";
}
```
This utility method formats the result of a fraud check. It returns "FAILED ⚠️" if the check failed and "Passed ✓" otherwise.

### `ChequeTransaction` Class
```java
private static class ChequeTransaction {
    private double amount;
    private java.time.LocalDate date;

    public ChequeTransaction(double amount, java.time.LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public java.time.LocalDate getDate() {
        return date;
    }
}
```
This class represents a cheque transaction with two attributes:
- `amount`: The monetary value of the cheque.
- `date`: The date of the transaction.

It includes a constructor for initializing these attributes and getter methods for accessing them.

### `FraudDetectionServiceV1` Class
#### Overview
This class is responsible for detecting fraudulent cheque activities. It uses various mechanisms, including velocity checks, pattern analysis, and historical data analysis, to identify potential fraud.

#### Attributes
- `fraudDetection`: An instance of the `FraudDetection` class, which provides core fraud detection functionalities.
- `historyManager`: An instance of the `ChequeHistoryManager` class, used for historical data analysis.
- `recentTransactions`: A map storing recent transactions for each account.

#### Fraud Detection Thresholds
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity checks.
- `VELOCITY_THRESHOLD`: The maximum number of transactions allowed within the velocity check period.
- `PATTERN_THRESHOLD`: The similarity threshold for pattern analysis.
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for comparing recent amounts.
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for determining unusual transaction frequency.

#### Methods
- **`setHistoryManager`**: Sets the `ChequeHistoryManager` instance.
- **`isFraudulentCheque`**: Determines if a cheque is fraudulent by performing various checks, including duplicate detection, abnormal amount detection, and historical analysis.
- **`checkDuplicateCheque`**: Checks if a cheque is a duplicate using the `FraudDetection` instance.
- **`checkAbnormalAmount`**: Checks if the cheque amount is abnormal.
- **`checkSuspiciousActivity`**: Checks for suspicious activity based on the account ID and amount.
- **`checkVelocityFraud`**: Detects fraud based on the frequency of recent transactions.
- **`checkPatternFraud`**: Identifies fraud based on patterns in transaction amounts.
- **`checkHistoricalDuplicate`**: Checks for duplicate cheques in historical data.
- **`checkUnusualFrequency`**: Determines if the frequency of transactions is unusually high.
- **`checkSimilarToRecent`**: Checks if the current transaction amount is similar to recent transactions.
- **`determineAlertLevel`**: Determines the level of fraud alert based on the results of various checks.
- **`logFraudChecks`**: Logs the results of all fraud checks for a given transaction.

#### `AlertLevel` Enum
Defines the levels of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## External Dependencies
- **`FraudDetection`**: Provides core fraud detection functionalities. The exact implementation details are not provided in this chunk.
- **`ChequeHistoryManager`**: Manages historical cheque data. The exact implementation details are not provided in this chunk.

## Summary
This code chunk is a comprehensive implementation of a fraud detection service for cheque transactions. It combines real-time checks with historical data analysis to identify potential fraud. The use of helper methods and a dedicated `ChequeTransaction` class ensures modularity and readability.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_25"
confidence_score: 0.95
external_dependencies: [java.time.LocalDate, java.util.Map, java.util.List, java.util.HashMap, java.util.ArrayList, FraudDetection, ChequeHistoryManager]
---

# Documentation for Fraud Detection Code Chunk

## Overview

This code chunk is part of a fraud detection system implemented in Java. It performs various checks to identify potential fraudulent activities related to cheque transactions. The checks are categorized into basic and advanced checks, and the results are displayed in a structured format. The code also includes a helper method for formatting the results of the checks and a nested class for representing cheque transactions.

## Code Components

### 1. **Basic Checks**
The following basic checks are performed to detect potential fraud:
- **Duplicate Check**: Verifies if the cheque is a duplicate.
- **Abnormal Amount Check**: Checks if the cheque amount is abnormal.
- **Suspicious Activity Check**: Identifies suspicious activities based on the account and amount.
- **Velocity Check**: Detects rapid transactions within a short period.
- **Pattern Analysis**: Analyzes patterns in transaction amounts.

The results of these checks are formatted using the `formatCheckResult` method and displayed in the console.

### 2. **Advanced Checks**
If a `historyManager` instance is available, the following advanced checks are performed:
- **Historical Duplicate Check**: Checks for duplicates in historical data.
- **Unusual Frequency Check**: Identifies unusual transaction frequencies.
- **Similar Recent Amount Check**: Compares the current transaction amount with recent transactions for similarity.

### 3. **Summary**
The results of all checks are aggregated to determine if any fraud is detected. A summary message is displayed in the console:
- If any fraud is detected, a "FRAUD ALERT" message is shown.
- Otherwise, a "No fraud detected" message is displayed.

### 4. **Helper Method: `formatCheckResult`**
This private method formats the result of a check for display purposes:
- Returns `"FAILED \u26A0\uFE0F"` if the check failed (i.e., fraud detected).
- Returns `"Passed \u2713"` if the check passed (i.e., no fraud detected).

#### Method Signature:
```java
private String formatCheckResult(boolean failed)
```

#### Parameters:
- `failed`: A boolean indicating whether the check failed.

#### Returns:
- A formatted string representing the result of the check.

### 5. **Nested Class: `ChequeTransaction`**
This private static class represents a cheque transaction with the following attributes:
- `amount`: The monetary value of the cheque.
- `date`: The date of the transaction.

#### Constructor:
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```

#### Methods:
- `getAmount()`: Returns the amount of the cheque.
- `getDate()`: Returns the date of the transaction.

### 6. **Fraud Detection Service**
The `FraudDetectionServiceV2` class implements various fraud detection mechanisms. It uses a `FraudDetection` instance and optionally a `ChequeHistoryManager` instance for historical data analysis.

#### Key Attributes:
- `fraudDetection`: An instance of the `FraudDetection` class.
- `historyManager`: An optional instance of the `ChequeHistoryManager` class.
- Various maps and lists to store transaction data and fraud logs.

#### Key Methods:
- `isFraudulentCheque`: Determines if a cheque is fraudulent based on various checks.
- `checkDuplicateCheque`: Checks for duplicate cheques.
- `checkAbnormalAmount`: Checks for abnormal cheque amounts.
- `checkSuspiciousActivity`: Identifies suspicious activities.
- `checkVelocityFraud`: Detects rapid transactions.
- `checkPatternFraud`: Analyzes patterns in transaction amounts.
- `checkHistoricalDuplicate`: Checks for duplicates in historical data.
- `checkUnusualFrequency`: Identifies unusual transaction frequencies.

#### Fraud Detection Thresholds:
- `VELOCITY_CHECK_DAYS`: Number of days for velocity check (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).
- `PATTERN_THRESHOLD`: Similarity threshold for pattern analysis (95%).
- `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent amounts (90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for unusual frequency detection (3x normal frequency).

#### Fraud Alert Levels:
The `AlertLevel` enum defines the severity of fraud alerts:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

## External Dependencies

### 1. **FraudDetection Class**
The `FraudDetection` class is responsible for performing the core fraud detection checks. It provides methods such as:
- `isDuplicateCheque`: Checks if a cheque is a duplicate.
- `isAbnormalAmount`: Determines if the cheque amount is abnormal.
- `isSuspiciousActivity`: Identifies suspicious activities based on account and amount.

### 2. **ChequeHistoryManager Class**
The `ChequeHistoryManager` class manages historical cheque data. It provides methods for recording and retrieving cheque history:
- `recordCheque`: Records a cheque transaction in the history.
- `displayChequeHistory`: Displays the history of cheques for a specific account.

#### Nested Class: `ChequeRecord`
Represents a record of a cheque transaction with attributes such as:
- `accountNumber`: The account number associated with the cheque.
- `chequeNumber`: The cheque number.
- `currency`: The currency of the transaction.
- `amount`: The amount of the cheque.
- `date`: The date of the transaction.

## Notes
- The `FraudDetection` and `ChequeHistoryManager` classes are integral to the fraud detection system. Their methods are used extensively for both basic and advanced checks.
- The `formatCheckResult` method and the `ChequeTransaction` class are utility components that enhance the readability and organization of the code.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_26"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Code Chunk in `DemoApplication.java`

## Overview
This code chunk is part of a fraud detection system for cheque transactions. It contains methods to perform various fraud checks, determine the severity of fraud alerts, and log the results of these checks. Additionally, it defines a nested class for representing cheque transactions.

## Methods

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
This method checks if a given cheque number has been used previously for a specific account.

#### Parameters:
- `accountId` (String): The unique identifier for the account.
- `chequeNumber` (String): The cheque number to check for duplicates.

#### Returns:
- `boolean`: `true` if the cheque number exists in the account's historical records, `false` otherwise.

#### Implementation:
- Retrieves a list of historical cheque numbers for the given account using `historyManager.getChequeNumbers(accountId)`.
- Checks if the provided `chequeNumber` exists in the retrieved list.

---

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
This method determines if the frequency of recent cheque transactions for a given account is unusually high compared to the average monthly frequency.

#### Parameters:
- `accountId` (String): The unique identifier for the account.

#### Returns:
- `boolean`: `true` if the recent cheque frequency exceeds the unusual frequency threshold, `false` otherwise.

#### Implementation:
- Retrieves the total and recent cheque counts for the account using `historyManager.getTotalChequeCount(accountId)` and `historyManager.getRecentChequeCount(accountId)`.
- If the total cheque count is less than 10, the method returns `false`.
- Calculates the average monthly frequency as `totalCheques / 3.0`.
- Compares the recent cheque count to the product of the average monthly frequency and the `UNUSUAL_FREQUENCY_THRESHOLD` (3).

---

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
This method checks if a given cheque amount is similar to recent cheque amounts for a specific account.

#### Parameters:
- `accountId` (String): The unique identifier for the account.
- `amount` (double): The cheque amount to compare.

#### Returns:
- `boolean`: `true` if a similar recent cheque exists, `false` otherwise.

#### Implementation:
- Uses `historyManager.hasSimilarRecentCheque(accountId, amount, SIMILAR_AMOUNT_THRESHOLD)` to determine if a similar cheque exists.

---

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
This method determines the severity of a fraud alert based on various fraud detection checks.

#### Parameters:
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the cheque amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if the cheque frequency is unusual.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent amounts.

#### Returns:
- `AlertLevel`: The severity of the fraud alert (`LOW`, `MEDIUM`, `HIGH`, or `CRITICAL`).

#### Implementation:
- Assigns weights to each fraud check and calculates a total fraud score.
- Determines the alert level based on the fraud score and specific conditions.

---

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
This method logs the results of various fraud checks for a specific cheque transaction.

#### Parameters:
- `accountId` (String): The unique identifier for the account.
- `chequeNumber` (String): The cheque number.
- `amount` (double): The cheque amount.
- Various boolean flags indicating the results of different fraud checks.

#### Implementation:
- Logs the account ID, cheque number, and amount.
- Logs the results of basic and advanced fraud checks.
- Summarizes whether any fraud was detected.

---

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed)
```
This method formats the result of a fraud check for logging purposes.

#### Parameters:
- `failed` (boolean): Indicates if the check failed.

#### Returns:
- `String`: A formatted string indicating whether the check passed or failed.

---

### `ChequeTransaction` (Nested Class)
```java
private static class ChequeTransaction
```
This nested class represents a cheque transaction with an amount and a date.

#### Fields:
- `amount` (double): The amount of the cheque.
- `date` (java.time.LocalDate): The date of the cheque transaction.

#### Constructor:
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```
Initializes a new `ChequeTransaction` with the specified amount and date.

#### Methods:
- `getAmount()`: Returns the cheque amount.
- `getDate()`: Returns the cheque date.

---

## External Dependencies
- **`ChequeHistoryManager`**: Provides methods for retrieving historical cheque data.
- **`AlertLevel`**: Enum defining fraud alert levels.
- **`UNUSUAL_FREQUENCY_THRESHOLD`**: Constant for unusual frequency detection.
- **`SIMILAR_AMOUNT_THRESHOLD`**: Constant for similar amount detection.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_27"
confidence_score: 0.95
external_dependencies: ["BatchCheque"]
---

# Documentation for `AdminService` Class and Related Methods

The provided code defines the `AdminService` class, which is a static inner class in the `DemoApplication` file. This class is responsible for managing master data, batch operations, and stuck transactions in a cheque processing system. Below is a detailed explanation of the class and its methods.

## Class: `AdminService`
The `AdminService` class provides functionality for:
1. Managing master data, such as IFSC codes and bank codes.
2. Handling batch operations for cheques.
3. Managing stuck transactions.

### Fields
- **`ifscToBankCode`**: A `Map<String, String>` that maps IFSC codes to bank codes.
- **`bankCodeToName`**: A `Map<String, String>` that maps bank codes to bank names.
- **`batches`**: A `Map<String, List<BatchCheque>>` that stores batches of cheques, where each batch is identified by a unique batch ID.
- **`stuckTransactions`**: A `Set<String>` that keeps track of cheque numbers marked as stuck.

### Methods

#### Master Data Management
1. **`addOrUpdateIFSC(String ifsc, String bankCode)`**
   - Adds or updates the mapping of an IFSC code to a bank code.
   - Prints a confirmation message.

2. **`addOrUpdateBankCode(String bankCode, String bankName)`**
   - Adds or updates the mapping of a bank code to a bank name.
   - Prints a confirmation message.

3. **`displayIFSCs()`**
   - Displays all IFSC-to-bank-code mappings.
   - Prints a message if no records are available.

4. **`displayBankCodes()`**
   - Displays all bank-code-to-bank-name mappings.
   - Prints a message if no records are available.

#### Batch Management
1. **`createBatch(String batchId, List<BatchCheque> cheques)`**
   - Creates a new batch of cheques and associates it with a unique batch ID.
   - Prints a confirmation message with the batch ID and the number of cheques in the batch.

2. **`displayBatches()`**
   - Displays a list of all batches and the number of cheques in each batch.
   - Prints a message if no batches are available.

3. **`displayBatchDetails(String batchId)`**
   - Displays detailed information about a specific batch, including account number, cheque number, amount, and currency for each cheque in the batch.
   - Prints a message if the batch is not found.

#### Stuck Transaction Management
1. **`markTransactionStuck(String chequeNumber)`**
   - Marks a cheque as stuck by adding its cheque number to the `stuckTransactions` set.
   - Prints a confirmation message.

2. **`resetStuckTransaction(String chequeNumber)`**
   - Removes a cheque number from the `stuckTransactions` set.
   - Prints a confirmation message if the cheque was successfully removed, or a message indicating that the cheque was not marked as stuck.

3. **`displayStuckTransactions()`**
   - Displays all cheque numbers currently marked as stuck.
   - Prints a message if no stuck transactions are found.

### External Dependencies
The `AdminService` class depends on the `BatchCheque` class, which represents a cheque in the system. The `BatchCheque` class has the following fields:
- **`accountNumber`**: The account number associated with the cheque.
- **`chequeNumber`**: The unique identifier for the cheque.
- **`currency`**: The currency in which the cheque is issued.
- **`amount`**: The amount of money specified on the cheque.
- **`signature`**: The signature on the cheque.

The `BatchCheque` class also includes a constructor to initialize these fields.

### Purpose
The `AdminService` class is designed to facilitate the management of master data, batch operations, and stuck transactions in a cheque processing system. It provides a structured way to handle these operations and ensures that the system can manage its data effectively.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_28"
confidence_score: 0.95
external_dependencies: ["java.util.Map", "java.util.HashMap"]
---

# Documentation for `User` and `UserService` Classes

## Overview
This code chunk defines two static classes, `User` and `UserService`, which are part of a user management and authentication system. The `User` class represents individual users, while the `UserService` class provides functionality for managing users and handling authentication.

## `User` Class
The `User` class is a simple data model that encapsulates information about a user, including their username, password, and role.

### Fields
- `private String username`: Stores the username of the user.
- `private String password`: Stores the password of the user. **Note:** In a real-world application, passwords should be hashed for security.
- `private String role`: Represents the role of the user, such as `EMPLOYEE` or `ACCOUNT_HOLDER`.

### Constructor
```java
public User(String username, String password, String role)
```
Initializes a new `User` object with the provided username, password, and role.

### Methods
- `public String getUsername()`: Returns the username of the user.
- `public String getPassword()`: Returns the password of the user.
- `public String getRole()`: Returns the role of the user.

## `UserService` Class
The `UserService` class provides methods for managing users and authenticating them. It uses a `Map` to store user data, where the key is the username and the value is a `User` object.

### Fields
- `private Map<String, User> users`: A `HashMap` that stores user data.

### Constructor
```java
public UserService()
```
The constructor initializes the `users` map and populates it with some sample users for demonstration purposes. The sample users include:
- `employee1` with password `password123` and role `EMPLOYEE`
- `account1001` with password `chequeuser` and role `ACCOUNT_HOLDER`
- `account1002` with password `securepass` and role `ACCOUNT_HOLDER`

### Methods

#### `public void registerUser(String username, String password, String role)`
Registers a new user by adding them to the `users` map.

**Parameters:**
- `username`: The username of the new user.
- `password`: The password of the new user.
- `role`: The role of the new user.

**Behavior:**
- Creates a new `User` object with the provided details.
- Adds the `User` object to the `users` map.
- Prints a message indicating that the user has been registered.

#### `public User authenticate(String username, String password)`
Authenticates a user based on their username and password.

**Parameters:**
- `username`: The username of the user attempting to authenticate.
- `password`: The password of the user attempting to authenticate.

**Returns:**
- The authenticated `User` object if the username and password match.
- `null` if authentication fails.

**Behavior:**
- Retrieves the `User` object associated with the given username from the `users` map.
- Checks if the retrieved `User` object is not `null` and if the password matches.
- Prints a success message if authentication is successful, or a failure message otherwise.

## Notes
- The `User` class currently stores passwords in plain text, which is a security risk. In a production environment, passwords should be hashed and salted.
- The `UserService` class is designed for demonstration purposes and is not thread-safe. In a multi-threaded environment, additional synchronization would be required to ensure thread safety.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_29"
confidence_score: 0.95
external_dependencies: []
---

# BatchCheque Class

The `BatchCheque` class is a simple data model used to represent a cheque in the context of a cheque processing system. This class encapsulates the details of a cheque, such as the account number, cheque number, currency, amount, and signature. It is likely used as part of a larger system for processing cheques, potentially with fraud detection capabilities.

## Purpose
The purpose of the `BatchCheque` class is to serve as a container for cheque-related data. It provides a structured way to store and pass around cheque information within the application.

## Fields

- `String accountNumber`: Represents the account number associated with the cheque.
- `String chequeNumber`: Represents the unique cheque number.
- `String currency`: Specifies the currency in which the cheque is issued.
- `double amount`: Represents the monetary value of the cheque.
- `String signature`: Stores the signature associated with the cheque, likely for verification purposes.

## Constructor

The class provides a single constructor to initialize all its fields:

```java
public BatchCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)
```

### Parameters
- `accountNumber`: The account number associated with the cheque.
- `chequeNumber`: The unique cheque number.
- `currency`: The currency in which the cheque is issued.
- `amount`: The monetary value of the cheque.
- `signature`: The signature associated with the cheque.

## Usage
The `BatchCheque` class is likely used in conjunction with other components of the cheque processing system. For example, instances of this class might be created and added to a collection for batch processing, as suggested by the following usage example:

```java
chequesToProcess.add(new BatchCheque(accountNumber, chequeNumber, currency, amount, signature));
```

This indicates that the `BatchCheque` objects are being stored in a collection (e.g., a list) for further processing, such as fraud detection or clearing.

## Additional Notes

The class does not include any methods beyond the constructor, suggesting that it is primarily intended as a data container. Any operations on the cheque data are likely performed by other components of the system.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_30"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "SignatureVerificationService", "CoreBankingSystemUpdater", "UserService", "ChequeHistoryManager", "FraudDetectionService", "ChequeProcessor", "BatchCheque"]
---

# Documentation for `CreateApplication` Class

## Overview
The `CreateApplication` class serves as the entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, viewing cheque history, and managing currency exchange information.

## Key Functionalities

### 1. **System Initialization**
The `main` method initializes the following services:
- **`CurrencyExchangeService`**: Handles currency exchange operations.
- **`SignatureVerificationService`**: Verifies signatures on cheques.
- **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
- **`UserService`**: Manages user authentication and registration.
- **`ChequeHistoryManager`**: Maintains and displays cheque processing history.
- **`FraudDetectionService`**: Detects potential fraud in cheque transactions.

### 2. **Login Process**
The `performLogin` method handles user authentication. It allows up to three login attempts and returns an authenticated `User` object if successful. If authentication fails after three attempts, the application exits.

### 3. **Cheque Processing**
The application provides options for processing cheques:
- **Single Cheque Processing**: Users can input details such as account number, cheque number, currency, amount, and signature to process a single cheque.
- **Batch Cheque Processing**: Users can process multiple cheques in a batch by providing details for each cheque.

### 4. **Cheque History Management**
Users can view the history of processed cheques for a specific account using the `ChequeHistoryManager`.

### 5. **Currency Exchange Information**
The `displayCurrencyExchangeMenu` method provides options to view supported currencies, get exchange rates, and convert currencies.

### 6. **Report Generation**
The `handleReportGeneration` method allows users to generate various reports, such as daily, weekly, monthly, or custom date range reports, using the `ChequeHistoryManager`.

### 7. **Exit Option**
Users can exit the application at any time by selecting the appropriate menu option.

## Methods

### `performLogin(Scanner scanner, UserService userService)`
Handles the user login process.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `userService`: A `UserService` object for authenticating users.
- **Returns**: An authenticated `User` object or `null` if login fails after three attempts.

### `processChequeBatch(Scanner scanner, ChequeProcessor chequeProcessor)`
Handles batch processing of cheques.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `chequeProcessor`: A `ChequeProcessor` object for processing cheques.
- **Details**: Prompts the user for the number of cheques in the batch and their details, then processes each cheque.

### `displayCurrencyExchangeMenu(Scanner scanner, CurrencyExchangeService currencyExchangeService)`
Displays the currency exchange menu and handles user interactions.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `currencyExchangeService`: A `CurrencyExchangeService` object for currency-related operations.

### `handleReportGeneration(Scanner scanner, ChequeHistoryManager chequeHistoryManager)`
Handles the report generation menu and logic.
- **Parameters**:
  - `scanner`: A `Scanner` object for reading user input.
  - `chequeHistoryManager`: A `ChequeHistoryManager` object for managing cheque history.

## External Dependencies
The `CreateApplication` class depends on the following external classes:
- `CurrencyExchangeService`
- `SignatureVerificationService`
- `CoreBankingSystemUpdater`
- `UserService`
- `ChequeHistoryManager`
- `FraudDetectionService`
- `ChequeProcessor`
- `BatchCheque`

These classes provide the necessary functionality for currency exchange, signature verification, core banking updates, user authentication, cheque history management, fraud detection, and cheque processing.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_31"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "CurrencyExchangeService", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

This code chunk contains three main functionalities:

1. **Batch Cheque Processing**
2. **Currency Exchange Menu**
3. **Cheque Report Generation**

## 1. Batch Cheque Processing
This section of the code collects details for a batch of cheques from the user and processes them using a `chequeProcessor` object. The details collected include:

- Account number
- Cheque number
- Currency
- Amount
- Signature

The collected data is stored in a list of `BatchCheque` objects, which are then processed in a batch.

### Key Operations:
- User input is collected using a `Scanner` object.
- Each cheque is added to a list of `BatchCheque` objects.
- The `chequeProcessor.processCheque` method is called for each cheque in the list.

### External Dependency:
- `BatchCheque`: Represents a cheque with attributes like account number, cheque number, currency, amount, and signature.

## 2. Currency Exchange Menu
This section provides a menu-driven interface for currency exchange operations. The menu includes the following options:

1. View supported currencies.
2. Get the exchange rate for a specific currency.
3. Get detailed exchange rate information (mid, buy, sell, and fee rates).
4. Convert an amount from one currency to another.
5. Return to the main menu.

### Key Operations:
- User input is collected to navigate the menu and perform actions.
- The `CurrencyExchangeService` is used to fetch supported currencies, exchange rates, and perform currency conversion.

### External Dependency:
- `CurrencyExchangeService`: Provides methods for currency-related operations such as fetching exchange rates and converting currencies.

## 3. Cheque Report Generation
This section handles the generation of cheque reports based on user-selected time periods. The available options are:

1. Daily Report (Today)
2. Weekly Report (Last 7 Days)
3. Monthly Report (Last 30 Days)
4. Custom Date Range Report
5. Return to the main menu

### Key Operations:
- User input is collected to select the report type and date range.
- The `ChequeHistoryManager` is used to fetch cheque records for the specified period.
- The records are written to a CSV file.

### External Dependency:
- `ChequeHistoryManager`: Manages cheque history and provides methods to fetch records and generate CSV reports.

### Error Handling:
- Input validation is performed for date formats and logical errors (e.g., start date after end date).
- Exceptions during file writing are caught and logged.

## Additional Notes:
- The `SignatureVerificationService` class is partially included, which appears to manage account signatures for verification purposes.
- The code uses standard Java libraries like `Scanner`, `LocalDate`, and `BufferedWriter` for input handling, date manipulation, and file writing, respectively.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_32"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "CurrencyRate"]
---

# Documentation for `SignatureVerificationService`, `ChequeProcessor`, and `CurrencyExchangeService`

## Overview
This code chunk contains three main components:

1. **`SignatureVerificationService`**: A service for verifying and managing account signatures.
2. **`ChequeProcessor`**: A module for processing cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
3. **`CurrencyExchangeService`**: A service for fetching and managing currency exchange rates, including fallback mechanisms.

## `SignatureVerificationService`

### Purpose
This class is responsible for verifying account signatures and managing updates to the stored signatures. It uses a `HashMap` to store account numbers and their corresponding signatures.

### Methods

- **`SignatureVerificationService()`**: Constructor that initializes the service with sample account signatures for demonstration purposes.

- **`boolean verifySignature(String accountNumber, String signature)`**:
  - Verifies if the provided signature matches the stored signature for the given account number.
  - If no signature is on file, it accepts the new signature and stores it.
  - Returns `true` if the signature is valid, `false` otherwise.

- **`void updateSignature(String accountNumber, String newSignature)`**:
  - Updates the stored signature for the specified account number.

## `ChequeProcessor`

### Purpose
This class processes cheques by performing multiple operations, including:
- Signature verification
- Fraud detection
- Currency conversion
- Updating the core banking system
- Recording cheque history

### Dependencies
- **`CurrencyExchangeService`**: For currency conversion.
- **`SignatureVerificationService`**: For signature verification.
- **`CoreBankingSystemUpdater`**: For updating the core banking system.
- **`ChequeHistoryManager`**: For recording cheque history.
- **`FraudDetectionService`**: For detecting fraudulent cheques.

### Methods

- **`ChequeProcessor(...)`**: Constructor that initializes the processor with the required services.

- **`void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`**:
  - Verifies the signature using `SignatureVerificationService`.
  - Detects fraud using `FraudDetectionService`.
  - Converts the cheque amount to the local currency using `CurrencyExchangeService`.
  - Updates the core banking system using `CoreBankingSystemUpdater`.
  - Records the cheque in the history using `ChequeHistoryManager`.

## `CurrencyExchangeService`

### Purpose
This class provides functionality for fetching and managing currency exchange rates. It includes a caching mechanism and fallback rates for cases where external API calls fail.

### Methods

- **`double getExchangeRate(String currency)`**:
  - Fetches the exchange rate for the specified currency relative to the base currency (USD).
  - Uses cached rates if available and valid.
  - Attempts to fetch rates from an external API if not cached.
  - Falls back to predefined rates if the API call fails.

### Constants
- **`BASE_CURRENCY`**: The base currency for exchange rates (USD).
- **`CACHE_EXPIRY_MINUTES`**: The duration for which cached rates are valid.
- **`FALLBACK_RATES`**: A map of predefined exchange rates for various currencies.

## External Dependencies

### `CoreBankingSystemUpdater`
A mock implementation that updates the core banking system with the account number and the amount in local currency.

### `ChequeHistoryManager`
Manages the history of processed cheques and supports report generation for various time periods.

### `FraudDetectionService`
Detects fraudulent cheques by analyzing patterns, recent transactions, and other factors.

### `CurrencyRate`
Represents a currency rate with attributes for the rate value and the last updated timestamp.

## Notes
- The `SignatureVerificationService` is a simplified implementation for demonstration purposes and may not be suitable for production use.
- The `CurrencyExchangeService` includes a fallback mechanism to ensure functionality even when external APIs are unavailable.
- The `ChequeProcessor` integrates multiple services to provide a comprehensive cheque processing workflow.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_33"
confidence_score: 0.95
external_dependencies: ["FALLBACK_RATES", "exchangeRateCache", "CurrencyRate", "CACHE_EXPIRY_MINUTES", "FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a larger application that provides currency exchange services and fraud detection for cheque transactions. It includes methods for handling currency exchange rates, converting currencies, managing exchange rate caches, and detecting fraudulent cheque activities. The code relies on external dependencies such as `FALLBACK_RATES`, `exchangeRateCache`, `CurrencyRate`, `CACHE_EXPIRY_MINUTES`, `FraudDetection`, `ChequeHistoryManager`, and `ChequeTransaction`.

## Code Breakdown

### 1. Fallback Exchange Rates
```java
Double fallbackRate = FALLBACK_RATES.get(currencyCode);
if (fallbackRate != null) {
    System.out.println("Using fallback rate for " + currencyCode + ": " + fallbackRate);
    exchangeRateCache.put(currencyCode, new CurrencyRate(fallbackRate, java.time.LocalDateTime.now()));
    return fallbackRate;
}
System.out.println("No exchange rate available for currency: " + currencyCode);
return 0.0;
```
- **Purpose**: This block uses fallback exchange rates when fetching rates from an external API fails. If a fallback rate exists for the given currency code, it is used and cached with a timestamp.
- **Key Variables**:
  - `FALLBACK_RATES`: A predefined map of fallback exchange rates for various currencies.
  - `exchangeRateCache`: A cache to store exchange rates with timestamps.
  - `CurrencyRate`: A class that encapsulates the exchange rate and the timestamp of when it was last updated.

### 2. Currency Conversion
```java
public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
    double fromRate = getExchangeRate(fromCurrency);
    double toRate = getExchangeRate(toCurrency);

    if (fromRate <= 0 || toRate <= 0) {
        System.out.println("Cannot convert: invalid exchange rates");
        return 0.0;
    }

    double amountInBaseCurrency = amount * fromRate;
    double convertedAmount = amountInBaseCurrency / toRate;

    System.out.println(String.format("Converted %.2f %s to %.2f %s",
            amount, fromCurrency.toUpperCase(), convertedAmount, toCurrency.toUpperCase()));

    return convertedAmount;
}
```
- **Purpose**: Converts an amount from one currency to another using exchange rates.
- **Key Steps**:
  1. Fetch exchange rates for the source (`fromCurrency`) and target (`toCurrency`) currencies.
  2. Validate the rates to ensure they are greater than zero.
  3. Convert the amount to the base currency and then to the target currency.
  4. Log the conversion details.

### 3. Detailed Exchange Rates
```java
public Map<String, Double> getDetailedExchangeRates(String currency) {
    String currencyCode = currency.toUpperCase();
    double baseRate = getExchangeRate(currencyCode);

    if (baseRate <= 0) {
        return Collections.emptyMap();
    }

    Map<String, Double> detailedRates = new HashMap<>();
    detailedRates.put("mid", baseRate);
    detailedRates.put("buy", baseRate * 0.99);
    detailedRates.put("sell", baseRate * 1.01);
    detailedRates.put("fee", baseRate * 0.005);

    return detailedRates;
}
```
- **Purpose**: Provides detailed exchange rate information, including mid, buy, sell rates, and fees.
- **Key Calculations**:
  - `buy`: Slightly lower than the mid rate (99%).
  - `sell`: Slightly higher than the mid rate (101%).
  - `fee`: A 0.5% fee based on the mid rate.

### 4. Supported Currencies
```java
public List<String> getSupportedCurrencies() {
    List<String> currencies = new ArrayList<>();
    currencies.add(BASE_CURRENCY);
    currencies.addAll(FALLBACK_RATES.keySet());
    Collections.sort(currencies);
    return currencies;
}
```
- **Purpose**: Returns a sorted list of all supported currency codes, including the base currency and those in the fallback rates.

### 5. Cache Validation
```java
private boolean isCacheValid(String currency) {
    if (!exchangeRateCache.containsKey(currency)) {
        return false;
    }

    CurrencyRate cachedRate = exchangeRateCache.get(currency);
    java.time.LocalDateTime now = java.time.LocalDateTime.now();
    java.time.LocalDateTime expiryTime = cachedRate.getLastUpdated().plusMinutes(CACHE_EXPIRY_MINUTES);

    return now.isBefore(expiryTime);
}
```
- **Purpose**: Checks if the cached exchange rate for a currency is still valid based on a predefined expiration time (`CACHE_EXPIRY_MINUTES`).
- **Key Variables**:
  - `exchangeRateCache`: Stores cached exchange rates.
  - `CACHE_EXPIRY_MINUTES`: The duration (in minutes) for which a cached rate is considered valid.

### 6. Fraud Detection Service
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount) {
    boolean isDuplicate = checkDuplicateCheque(accountId, chequeNumber);
    boolean isAbnormal = checkAbnormalAmount(amount);
    boolean isSuspicious = checkSuspiciousActivity(accountId, amount);
    boolean isVelocityFraud = checkVelocityFraud(accountId, amount);
    boolean isPatternFraud = checkPatternFraud(accountId, amount);

    boolean isHistoricalDuplicate = false;
    boolean isUnusualFrequency = false;
    boolean isSimilarToRecent = false;

    if (historyManager != null) {
        isHistoricalDuplicate = checkHistoricalDuplicate(accountId, chequeNumber);
        isUnusualFrequency = checkUnusualFrequency(accountId);
        isSimilarToRecent = checkSimilarToRecent(accountId, amount);
    }

    logFraudChecks(accountId, chequeNumber, amount, isDuplicate, isAbnormal,
            isSuspicious, isVelocityFraud, isPatternFraud,
            isHistoricalDuplicate, isUnusualFrequency, isSimilarToRecent);

    AlertLevel alertLevel = determineAlertLevel(isDuplicate, isAbnormal,
            isSuspicious, isVelocityFraud, isPatternFraud,
            isHistoricalDuplicate, isUnusualFrequency, isSimilarToRecent);

    System.out.println("Fraud Alert Level: " + alertLevel);

    return isDuplicate || isAbnormal || isSuspicious || isVelocityFraud || isPatternFraud ||
            isHistoricalDuplicate || isUnusualFrequency || isSimilarToRecent;
}
```
- **Purpose**: Detects fraudulent cheque activities using various checks, including duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, and pattern fraud.
- **Key Components**:
  - `FraudDetection`: A service for performing fraud detection.
  - `ChequeHistoryManager`: Manages historical cheque data for additional checks.
  - `AlertLevel`: Enum representing the severity of fraud alerts.

## External Dependencies
- **`FALLBACK_RATES`**: A predefined map of fallback exchange rates.
- **`exchangeRateCache`**: A cache for storing exchange rates with timestamps.
- **`CurrencyRate`**: A class representing an exchange rate and its last updated timestamp.
- **`CACHE_EXPIRY_MINUTES`**: The duration for which cached rates are valid.
- **`FraudDetection`**: A service for detecting fraudulent activities.
- **`ChequeHistoryManager`**: Manages historical cheque data.
- **`ChequeTransaction`**: Represents a cheque transaction, used in fraud detection.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_34"
confidence_score: 0.95
external_dependencies: ["AlertLevel", "ChequeHistoryManager", "ChequeTransaction"]
---

# Documentation for Fraud Detection Code Chunk

This code chunk is part of a fraud detection system implemented in Java. It contains methods to evaluate various fraud detection checks, log the results, and determine the alert level based on the findings. Below is a detailed explanation of the methods and their purposes:

## Methods

### `logFraudChecks`
Logs the results of various fraud detection checks for a given account and cheque. It provides a detailed report of the checks performed and their outcomes. This method is crucial for auditing and tracking the results of fraud detection mechanisms.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.
- `amount` (double): The cheque amount.
- `isDuplicate` (boolean): Result of the duplicate cheque check.
- `isAbnormal` (boolean): Result of the abnormal amount check.
- `isSuspicious` (boolean): Result of the suspicious activity check.
- `isVelocityFraud` (boolean): Result of the velocity fraud check.
- `isPatternFraud` (boolean): Result of the pattern fraud check.
- `isHistoricalDuplicate` (boolean): Result of the historical duplicate check.
- `isUnusualFrequency` (boolean): Result of the unusual frequency check.
- `isSimilarToRecent` (boolean): Result of the similar recent amount check.

This method uses the `formatCheckResult` method to format the results of each fraud check for logging purposes.

### `determineAlertLevel`
Determines the alert level based on the results of various fraud checks. The alert level can be one of the following:
- `CRITICAL`: Indicates the highest level of fraud risk.
- `HIGH`: Indicates a high level of fraud risk.
- `MEDIUM`: Indicates a moderate level of fraud risk.
- `LOW`: Indicates a low level of fraud risk.

#### Parameters:
- Various boolean flags indicating the results of different fraud checks, such as `isDuplicate`, `isAbnormal`, `isSuspicious`, etc.

#### Returns:
- `AlertLevel`: The determined alert level.

#### Logic:
The method calculates a `fraudCount` based on the results of the fraud checks:
- Duplicate or historical duplicate checks add 3 points each.
- Abnormal amount, suspicious activity, velocity fraud, and pattern fraud checks add 2 points each.
- Unusual frequency and similar recent amount checks add 1 point each.

The `fraudCount` is then used to determine the alert level:
- `CRITICAL`: `fraudCount >= 8`
- `HIGH`: `fraudCount >= 5`
- `MEDIUM`: `fraudCount >= 3`
- `LOW`: `fraudCount < 3`

### `formatCheckResult`
Formats the result of a fraud check for logging purposes. This method is used by `logFraudChecks` to create a human-readable string for each fraud check result.

#### Parameters:
- `failed` (boolean): The result of the fraud check.

#### Returns:
- `String`: A formatted string indicating whether the check passed or failed.

### `ChequeTransaction` (Inner Class)
Represents a cheque transaction with an amount and date.

#### Fields:
- `amount` (double): The transaction amount.
- `date` (java.time.LocalDate): The transaction date.

#### Constructor:
- `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes a new instance of the `ChequeTransaction` class.

#### Methods:
- `getAmount()`: Returns the transaction amount.
- `getDate()`: Returns the transaction date.

## External Dependencies

### `AlertLevel`
An enum or class used to represent the alert level. Possible values include `CRITICAL`, `HIGH`, `MEDIUM`, and `LOW`. This is used to categorize the severity of detected fraud.

### `ChequeHistoryManager`
A class responsible for managing historical cheque data. It includes the following features:
- **ChequeRecord (Inner Class)**: Represents individual cheque records with fields for account number, cheque number, currency, amount, and date.
- **Methods**:
  - `recordCheque(String acc, String chq, String curr, double amt, Date d)`: Records a cheque transaction in the history.
  - `displayChequeHistory(String acc)`: Displays the history of cheques for a specific account.

### `ChequeTransaction`
An inner class used to represent individual cheque transactions. It is used in fraud detection methods like `checkPatternFraud` to analyze transaction patterns and detect anomalies.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_35"
confidence_score: 0.9
external_dependencies: [java.time.LocalDateTime]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview

This code chunk is part of a system designed to monitor and detect potentially fraudulent or suspicious financial activities. It includes methods for identifying abnormal transaction amounts, tracking suspicious activity, recording transactions, updating account profiles, and analyzing behavioral patterns. Additionally, the code references several constants and collections that are not defined within this chunk but are critical to its functionality.

## Constants and Collections

The following constants and collections are referenced in this code but are not defined within the provided chunk. They are assumed to be declared elsewhere in the class or a parent class:

### Constants
- **`ABNORMAL_AMOUNT_THRESHOLD`**: Likely represents the threshold above which a transaction amount is considered abnormal.
- **`SUSPICIOUS_ACTIVITY_MULTIPLIER`**: Likely used to calculate a threshold for identifying suspicious activity based on abnormal amounts.
- **`AMOUNT_VARIANCE_THRESHOLD`**: Likely represents the acceptable variance between a transaction amount and the average transaction amount for an account.

### Collections
- **`accountActivity`**: Presumably a map or similar data structure that tracks the total activity for each account.
- **`accountTransactionHistory`**: Presumably a map or similar data structure that stores the transaction history for each account.
- **`accountProfiles`**: Presumably a map or similar data structure that stores the profile information for each account.

## Methods

### `isAbnormalAmount(double amount)`
- **Purpose**: Determines if a given transaction amount exceeds a predefined abnormal threshold.
- **Parameters**:
  - `amount` (double): The transaction amount to evaluate.
- **Returns**: `true` if the amount exceeds the `ABNORMAL_AMOUNT_THRESHOLD`, otherwise `false`.

---

### `isSuspiciousActivity(String accountId, double amount)`
- **Purpose**: Evaluates whether a transaction is suspicious based on the account's activity and behavioral patterns.
- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Returns**: `true` if the transaction is deemed suspicious, otherwise `false`.
- **Logic**:
  1. Retrieves the total activity for the account from `accountActivity`.
  2. Updates the total activity with the current transaction amount.
  3. Records the transaction using `recordTransaction`.
  4. Updates the account profile using `updateAccountProfile`.
  5. Checks if the total activity exceeds a threshold defined as `ABNORMAL_AMOUNT_THRESHOLD * SUSPICIOUS_ACTIVITY_MULTIPLIER`.
  6. Evaluates abnormal behavior using `isAbnormalBehavior`.
  7. Returns `true` if either the threshold is exceeded or abnormal behavior is detected.

---

### `recordTransaction(String accountId, double amount)`
- **Purpose**: Records a transaction for an account and maintains a history of transactions within the last 90 days.
- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Logic**:
  1. Initializes the transaction history for the account if it does not exist.
  2. Adds a new `TransactionRecord` with the current timestamp.
  3. Filters the transaction history to retain only records from the last 90 days.

---

### `updateAccountProfile(String accountId, double amount)`
- **Purpose**: Updates the account profile with the details of a new transaction.
- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Logic**:
  1. Initializes the account profile if it does not exist.
  2. Updates the profile's total transaction amount, transaction count, maximum transaction amount, and minimum transaction amount.

---

### `isAbnormalBehavior(String accountId, double amount)`
- **Purpose**: Determines if a transaction exhibits abnormal behavior based on the account's historical transaction data.
- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Returns**: `true` if the transaction exhibits abnormal behavior, otherwise `false`.
- **Logic**:
  1. Checks if the account profile exists.
  2. If the account has at least 5 transactions, calculates the average transaction amount.
  3. Computes the variance between the current transaction amount and the average.
  4. Returns `true` if the variance exceeds `AMOUNT_VARIANCE_THRESHOLD` and the amount is greater than the average.

---

## Inner Classes

### `TransactionRecord`
- **Purpose**: Represents a single transaction record.
- **Fields**:
  - `amount` (double): The transaction amount.
  - `timestamp` (java.time.LocalDateTime): The timestamp of the transaction.
- **Constructor**:
  - `TransactionRecord(double amount, java.time.LocalDateTime timestamp)`: Initializes a new transaction record with the specified amount and timestamp.

---

### `AccountProfile`
- **Purpose**: Represents the profile of an account, including transaction statistics.
- **Fields**:
  - `totalAmount` (double): The total amount of all transactions.
  - `transactionCount` (int): The total number of transactions.
  - `maxAmount` (double): The maximum transaction amount.
  - `minAmount` (double): The minimum transaction amount.
- **Methods**:
  - `updateWithTransaction(double amount)`: Updates the profile with a new transaction, adjusting the total amount, transaction count, maximum amount, and minimum amount.

---

## Notes
- The constants `ABNORMAL_AMOUNT_THRESHOLD`, `SUSPICIOUS_ACTIVITY_MULTIPLIER`, and `AMOUNT_VARIANCE_THRESHOLD` are not defined in this chunk but are likely declared elsewhere in the class or a parent class.
- The collections `accountActivity`, `accountTransactionHistory`, and `accountProfiles` are also not defined in this chunk but are assumed to be instance variables of the class.

## External Dependencies
- `java.time.LocalDateTime`: Used for timestamping transactions and filtering transaction history.