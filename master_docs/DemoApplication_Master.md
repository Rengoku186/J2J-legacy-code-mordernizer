# MASTER DOCUMENT: DemoApplication

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_01"
confidence_score: 0.95
external_dependencies: ["java.util", "java.text.SimpleDateFormat", "java.io.BufferedWriter", "java.io.FileWriter", "java.io.IOException", "java.time.LocalDate", "java.time.format.DateTimeFormatter", "java.text.NumberFormat", "java.util.Locale", "java.nio.charset.StandardCharsets", "java.security.SecureRandom"]
---

# Documentation for `DemoApplication.java` - Chunk 01

This chunk of code contains the import statements for the `DemoApplication` class. These imports bring in various Java standard library classes and packages that are used throughout the application. Below is a breakdown of the imported classes and their potential purposes:

## Imported Classes and Packages

1. **`java.util.*`**:
   - Provides utility classes such as `ArrayList`, `HashMap`, `Scanner`, and more.
   - Likely used for data structures, collections, and utility methods.

2. **`java.text.SimpleDateFormat`**:
   - A class for formatting and parsing dates in a locale-sensitive manner.
   - Commonly used to format `Date` objects into readable strings or parse strings into `Date` objects.

3. **`java.io.BufferedWriter`**:
   - A class for writing text to an output stream, buffering characters to provide efficient writing of single characters, arrays, and strings.
   - Likely used for writing data to files or other output streams.

4. **`java.io.FileWriter`**:
   - A class for writing character files.
   - Often used in conjunction with `BufferedWriter` for file writing operations.

5. **`java.io.IOException`**:
   - An exception class that signals that an I/O operation has failed or been interrupted.
   - Likely used to handle errors during file or stream operations.

6. **`java.time.LocalDate`**:
   - A class representing a date (year, month, day) without a time-zone.
   - Useful for date-related operations without time or timezone considerations.

7. **`java.time.format.DateTimeFormatter`**:
   - A class for formatting and parsing date-time objects.
   - Likely used to format `LocalDate` objects into strings or parse strings into `LocalDate` objects.

8. **`java.text.NumberFormat`**:
   - A class for formatting and parsing numbers in a locale-sensitive manner.
   - Useful for formatting numbers, currencies, or percentages.

9. **`java.util.Locale`**:
   - A class that represents a specific geographical, political, or cultural region.
   - Often used in conjunction with `NumberFormat` or `SimpleDateFormat` for locale-sensitive operations.

10. **`java.nio.charset.StandardCharsets`**:
    - A class defining standard charsets (e.g., UTF-8, ISO-8859-1).
    - Likely used for encoding and decoding byte streams.

11. **`java.security.SecureRandom`**:
    - A class providing a cryptographically strong random number generator.
    - Likely used for generating secure keys, tokens, or signatures.

## Purpose of the Imports

These imports collectively suggest that the `DemoApplication` class involves:
- Handling dates and times in a locale-sensitive manner.
- Performing file I/O operations.
- Formatting numbers and text.
- Generating secure random values.
- Utilizing collections and utility classes for data manipulation.

The specific usage of these imports will be clearer when analyzing the methods and logic within the `DemoApplication` class.

---

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.9
external_dependencies: [CurrencyExchangeService, SignatureVerificationService, CoreBankingSystemUpdater, UserService, ChequeHistoryManager, FraudDetectionService, ExceptionReportManager, ChequeStatusManager, EmailNotificationService, ChequeImageHandler, CryptographyService, ClearinghouseService, ChequeProcessor, ChequePrintingService, FIRDetails, ExceptionRecord]
---

# Documentation for `DemoApplication` Class (Chunk 02)

## Overview
The `DemoApplication` class serves as the main entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, managing cheque history, and performing administrative tasks.

## Key Functionalities

### 1. **Initialization**
The `main` method initializes the following services:
- `CurrencyExchangeService`: Handles currency exchange operations.
- `SignatureVerificationService`: Verifies cheque signatures.
- `CoreBankingSystemUpdater`: Updates the core banking system.
- `UserService`: Manages user authentication and related operations.
- `ChequeHistoryManager`: Manages and displays cheque history.
- `FraudDetectionService`: Detects fraudulent activities.
- `ExceptionReportManager`: Manages and displays exception reports.
- `ChequeStatusManager`: Tracks the status of cheques.
- `EmailNotificationService`: Sends email notifications.
- `ChequeImageHandler`: Handles cheque image processing.
- `CryptographyService`: Provides encryption and signing services.
- `ClearinghouseService`: Facilitates communication with the clearinghouse.

### 2. **Login Process**
The `performLogin` method is invoked to authenticate the user. If the user fails to log in after multiple attempts, the application exits.

### 3. **Menu Options**
The application provides a menu-driven interface with the following options:

#### Option 1: Process a Single Cheque
Prompts the user for account number, cheque number, currency, amount, and signature, and processes the cheque using the `ChequeProcessor` service.

#### Option 2: Process Multiple Cheques (Batch)
Invokes the `processChequeBatch` method to process multiple cheques in a batch.

#### Option 3: View Cheque History
Prompts the user for an account number and displays the cheque history using the `ChequeHistoryManager`.

#### Option 4: Currency Exchange Information
Displays a currency exchange menu and handles user interactions via the `displayCurrencyExchangeMenu` method.

#### Option 5: Generate Cheque Reports
Generates cheque reports using the `handleReportGeneration` method.

#### Option 6: Scan, Encrypt, and Send Cheque Image
Handles the process of scanning, encrypting, signing, and sending a cheque image using the `handleChequeImageSubmission` method.

#### Option 7: Simulate Cheque Printing
Simulates cheque printing using the `ChequePrintingService` and the `handleChequePrinting` method.

#### Option 8: Exit
Logs out the user and exits the application.

#### Option 9: View Cheque Exception Report
Displays exception reports using the `ExceptionReportManager`.

#### Option 10: View All Cheque Statuses
Displays all cheque statuses using the `ChequeStatusManager`.

#### Option 11: Cancel a Cheque
Prompts the user for account and cheque numbers and cancels the cheque using the `ChequeProcessor`.

#### Option 12: Record FIR/Legal Complaint for Bounced Cheque
Prompts the user for details about a bounced cheque and records FIR/legal complaint details using the `recordFIRDetails` method in the `ExceptionReportManager`.

#### Option 13: Admin: Edit IFSC/Bank Codes
Admin functionality to edit IFSC or bank codes (implementation not shown in this chunk).

#### Option 14: Admin: Manage Batches
Admin functionality to manage cheque batches (implementation not shown in this chunk).

#### Option 15: Admin: Reset Stuck Transactions
Admin functionality to reset stuck transactions (implementation not shown in this chunk).

## External Dependencies
The following external classes and services are used in this chunk:
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
- `ChequeProcessor`
- `ChequePrintingService`
- `FIRDetails`
- `ExceptionRecord`

## Notes
- The `performLogin`, `processChequeBatch`, `displayCurrencyExchangeMenu`, `handleReportGeneration`, `handleChequeImageSubmission`, and `handleChequePrinting` methods are defined elsewhere in the codebase.
- The `recordFIRDetails` method is part of the `ExceptionReportManager` class and is used to record FIR/legal complaint details for bounced cheques.
- The application uses a `Scanner` object for user input.
- The `main` method contains a loop that continuously displays the menu until the user chooses to exit.

This chunk provides a comprehensive overview of the main application logic, including initialization, user authentication, and the menu-driven interface for various cheque processing and administrative tasks.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.9
external_dependencies: ["AdminService", "BatchCheque", "Logger", "UserService"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of the `DemoApplication` class and contains several functionalities related to administrative tasks, user login, and batch cheque processing. The code is structured into multiple `case` blocks within a `switch` statement, each handling a specific administrative operation. Additionally, the chunk includes two private static methods: `performLogin` and `processChequeBatch`.

## Code Breakdown

### Case 13: Admin - Edit IFSC/Bank Codes
This block allows an admin to manage IFSC and bank codes. The admin can:
1. Add or update an IFSC code.
2. Add or update a bank code.
3. View all IFSC codes.
4. View all bank codes.
5. Return to the previous menu.

The admin's choice is captured using a `Scanner` object, and the corresponding action is performed by invoking methods from the `AdminService` class:
- `addOrUpdateIFSC(String ifsc, String bankCode)`: Adds or updates an IFSC code and its associated bank code.
- `addOrUpdateBankCode(String code, String name)`: Adds or updates a bank code and its associated bank name.
- `displayIFSCs()`: Displays all stored IFSC codes.
- `displayBankCodes()`: Displays all stored bank codes.

### Case 14: Admin - Manage Batches
This block allows an admin to manage cheque batches. The admin can:
1. Create a new batch by providing a batch ID and details for each cheque in the batch.
2. View all existing batches.
3. View details of a specific batch by providing its batch ID.
4. Return to the previous menu.

The admin's choice is captured using a `Scanner` object, and the corresponding action is performed by invoking methods from the `AdminService` class:
- `createBatch(String batchId, List<BatchCheque> batchCheques)`: Creates a new batch with the specified ID and a list of cheques.
- `displayBatches()`: Displays all existing batches.
- `displayBatchDetails(String batchId)`: Displays details of a specific batch.

The `BatchCheque` class is used to represent individual cheques in a batch. Each cheque includes details such as account number, cheque number, currency, amount, and signature.

### Case 15: Admin - Reset Stuck Transactions
This block allows an admin to manage stuck transactions. The admin can:
1. Mark a cheque as stuck by providing its cheque number.
2. Reset a stuck cheque by providing its cheque number.
3. View all stuck transactions.
4. Return to the previous menu.

The admin's choice is captured using a `Scanner` object, and the corresponding action is performed by invoking methods from the `AdminService` class:
- `markTransactionStuck(String chequeNumber)`: Marks a cheque as stuck.
- `resetStuckTransaction(String chequeNumber)`: Resets a stuck cheque.
- `displayStuckTransactions()`: Displays all stuck transactions.

### Exception Handling
The `try-catch` block ensures that any exceptions occurring during the execution of the main logic are caught and logged using the `Logger` class. The error message and stack trace are printed to the console for debugging purposes.

### Method: `performLogin`
This method handles the user login process. It allows a user to attempt login up to three times by providing a username and password. The method uses the `UserService` class to authenticate the user:
- `User authenticate(String username, String password)`: Authenticates the user based on the provided credentials.

If authentication is successful, the method returns the authenticated `User` object. Otherwise, it returns `null` after three failed attempts.

### Method: `processChequeBatch`
This method handles the processing of multiple cheques in a batch. It prompts the user to enter the number of cheques and their details, including account number, cheque number, currency, amount, and signature. The cheques are stored in a `List<BatchCheque>` and processed using the `ChequeProcessor` service.

## External Dependencies
- **AdminService**: Provides methods for managing IFSC codes, bank codes, cheque batches, and stuck transactions.
- **BatchCheque**: Represents individual cheques with details such as account number, cheque number, currency, amount, and signature.
- **Logger**: Used for logging errors and informational messages.
- **UserService**: Handles user authentication and management.

## Notes
- The `AdminService` class is instantiated in the `DemoApplication` class, but its implementation details are not provided in this chunk.
- The `BatchCheque` class is used to represent cheque details, but its implementation is not provided in this chunk.
- The `Logger` class is used for logging, but its implementation is not provided in this chunk.
- The `UserService` class is responsible for user authentication and management, and its implementation is partially available in the codebase.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 0.95
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk

This code chunk is part of a larger application and contains several functionalities related to cheque processing, currency exchange, report generation, and cheque printing. Below is a detailed explanation of the purpose and methods in this chunk.

## Key Functionalities

### 1. **Batch Cheque Processing**
This section of the code handles the processing of a batch of cheques. It performs the following steps:

- **Adding Cheques to the Batch:**
  ```java
  chequesToProcess.add(new BatchCheque(accountNumber, chequeNumber, currency, amount, signature));
  ```
  - Creates a new `BatchCheque` object with the provided details (account number, cheque number, currency, amount, and signature) and adds it to the `chequesToProcess` list.
  - If an exception occurs during this process, it logs the error and clears the scanner buffer.

- **Processing the Batch:**
  ```java
  chequesToProcess.forEach(cheque -> {
      try {
          chequeProcessor.processCheque(cheque.accountNumber, cheque.chequeNumber, cheque.currency, cheque.amount, cheque.signature);
      } catch (Exception ex) {
          Logger.error("Error processing cheque in batch: " + ex.getMessage());
      }
  });
  ```
  - Iterates over the `chequesToProcess` list and processes each cheque using the `ChequeProcessor` class.
  - Logs any errors encountered during the processing of individual cheques.

### 2. **Currency Exchange Menu**
The `displayCurrencyExchangeMenu` method provides a user interface for interacting with the currency exchange service. It supports the following options:

- **View Supported Currencies:**
  Retrieves and displays a list of supported currencies from the `CurrencyExchangeService`.

- **Get Exchange Rate:**
  Prompts the user for a currency code and retrieves the exchange rate for that currency using the `CurrencyExchangeService`.

- **Get Detailed Exchange Rate Information:**
  Prompts the user for a currency code and retrieves detailed exchange rate information (mid, buy, sell, and fee rates) from the `CurrencyExchangeService`.

- **Convert Currency:**
  Prompts the user for an amount, source currency, and target currency, and converts the amount using the `CurrencyExchangeService`.

- **Return to Main Menu:**
  Exits the currency exchange menu.

### 3. **Report Generation**
The `handleReportGeneration` method provides a user interface for generating cheque reports. It supports the following options:

- **Daily Report:**
  Generates a report for cheques processed on the current day.

- **Weekly Report:**
  Generates a report for cheques processed in the last 7 days.

- **Monthly Report:**
  Generates a report for cheques processed in the last 30 days.

- **Custom Date Range Report:**
  Prompts the user for a start and end date, and generates a report for cheques processed within that range.

- **Return to Main Menu:**
  Exits the report generation menu.

The generated report is saved as a CSV file with a name based on the selected date range.

### 4. **Cheque Printing Simulation**
The `handleChequePrinting` method simulates the process of printing a cheque. It performs the following steps:

- Prompts the user for the payee name, amount, date, account number, and cheque number.
- Parses the date input and defaults to the current date if the input is invalid.
- Uses the `ChequePrintingService` to simulate the printing of the cheque.

## External Dependencies

- **`BatchCheque`:** Represents a cheque with attributes such as account number, cheque number, currency, amount, and signature.
- **`ChequeProcessor`:** Handles the processing of cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
- **`CurrencyExchangeService`:** Provides functionalities for currency exchange, including retrieving exchange rates and converting currencies.
- **`ChequeHistoryManager`:** Manages the history of cheques, including retrieving records for specific time periods and generating reports in CSV format.
- **`ChequePrintingService`:** Simulates the printing of cheques.

## Error Handling

- Errors during cheque batch input or processing are logged using the `Logger.error` method.
- Invalid user inputs, such as incorrect date formats or unsupported currency codes, are handled gracefully with appropriate error messages.
- If no cheque records are found for a selected report period, a message is displayed to the user.
- Errors during file writing for report generation are caught and logged.

This code chunk demonstrates robust error handling and provides a user-friendly interface for managing cheques, currency exchange, and report generation.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_05"
confidence_score: 0.95
external_dependencies: ["Scanner", "ChequePrintingService", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "User"]
---

# Documentation for Code Chunk

## Overview
This code chunk contains two main functionalities:
1. **Cheque Printing Simulation**: Captures user input for cheque details and simulates the printing of a cheque using the `ChequePrintingService`.
2. **Cheque Image Submission**: Handles the process of scanning, encrypting, signing, and sending a cheque image to a clearinghouse using various services such as `ChequeImageHandler`, `CryptographyService`, and `ClearinghouseService`.

Additionally, the chunk includes inner classes for services like `ChequePrintingService`, `CryptographyService`, and `UserService`, as well as a `User` class and a `BatchCheque` class.

---

## 1. Cheque Printing Simulation

### Method: `handleChequePrinting`
This method simulates the process of printing a cheque by collecting user input and using the `ChequePrintingService` to display a formatted cheque.

#### Parameters:
- `Scanner scanner`: Used to capture user input from the console.
- `ChequePrintingService printingService`: A service responsible for simulating the printing of a cheque.

#### Workflow:
1. Prompts the user to enter the payee name, amount, date, account number, and cheque number.
2. Parses the date input by the user. If the input is invalid, the current date is used as a fallback.
3. Uses the `ChequePrintingService` to print the cheque with the provided details.

---

## 2. Cheque Image Submission

### Method: `handleChequeImageSubmission`
This method handles the process of scanning, encrypting, signing, and sending a cheque image to a clearinghouse.

#### Parameters:
- `Scanner scanner`: Used to capture user input from the console.
- `ChequeImageHandler imageHandler`: A service responsible for handling the loading of cheque image data.
- `CryptographyService cryptoService`: A service for encrypting and signing data.
- `ClearinghouseService clearinghouseService`: A service for submitting the cheque image to a clearinghouse.
- `User currentUser`: The currently logged-in user, used for signing the encrypted data.

#### Workflow:
1. Prompts the user to enter the account number, cheque number, and the path to the cheque image file.
2. Uses the `ChequeImageHandler` to load the image data from the specified file path.
3. Encrypts the image data using a placeholder encryption key with the `CryptographyService`.
4. Signs the encrypted image data using the `CryptographyService` and the private key of the current user.
5. Submits the encrypted and signed image data to the clearinghouse using the `ClearinghouseService`.

---

## 3. Inner Classes

### Class: `ChequePrintingService`
This class simulates the process of printing a cheque.

#### Method: `printCheque`
Prints a formatted cheque with the provided details.

**Parameters:**
- `String payeeName`: The name of the payee.
- `double amount`: The amount to be paid.
- `Date date`: The date of the cheque.
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String bankName`: The name of the bank issuing the cheque.

---

### Class: `CryptographyService`
This class simulates cryptographic operations such as encryption and digital signing.

#### Method: `encryptData`
Simulates encrypting data using a placeholder encryption mechanism.

**Parameters:**
- `byte[] data`: The data to encrypt.
- `String key`: The encryption key.

**Returns:**
- `byte[]`: The encrypted data.

#### Method: `signData`
Simulates signing data using a placeholder signing mechanism.

**Parameters:**
- `byte[] data`: The data to sign.
- `String privateKey`: The private key used for signing.

**Returns:**
- `String`: The digital signature.

---

### Class: `User`
Represents a user of the system, such as an employee or account holder.

#### Fields:
- `String username`: The username of the user.
- `String password`: The password of the user (stored in plain text for simulation purposes).
- `String role`: The role of the user (e.g., "EMPLOYEE", "ACCOUNT_HOLDER").

#### Methods:
- `getUsername()`: Returns the username.
- `getPassword()`: Returns the password.
- `getRole()`: Returns the role.

---

### Class: `UserService`
Manages user accounts and handles authentication.

#### Method: `registerUser`
Registers a new user.

**Parameters:**
- `String username`: The username of the new user.
- `String password`: The password of the new user.
- `String role`: The role of the new user.

#### Method: `authenticate`
Authenticates a user based on their username and password.

**Parameters:**
- `String username`: The username of the user.
- `String password`: The password of the user.

**Returns:**
- `User`: The authenticated user object if successful, or `null` otherwise.

---

### Class: `BatchCheque`
Represents a single cheque transaction for batch processing.

#### Fields:
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String currency`: The currency of the cheque.
- `double amount`: The amount of the cheque.
- `String signature`: The digital signature of the cheque.

---

## External Dependencies
- `Scanner`: Used for capturing user input.
- `ChequePrintingService`: Simulates the printing of cheques.
- `ChequeImageHandler`: Handles the loading of cheque image data.
- `CryptographyService`: Provides encryption and signing functionalities.
- `ClearinghouseService`: Submits encrypted and signed cheque data to a clearinghouse.
- `User`: Represents the currently logged-in user.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_06"
confidence_score: 0.95
external_dependencies: ["java.util.Date", "java.util.List", "java.util.ArrayList", "java.util.Map", "java.util.HashMap", "java.text.SimpleDateFormat", "java.nio.charset.StandardCharsets", "java.util.Arrays"]
---

# Documentation for Code Chunk

This code chunk is part of a larger Java application and contains several classes and methods related to handling cheque exceptions, FIR/legal complaint details, cheque statuses, logging, image handling, cryptographic operations, and clearinghouse submissions. Below is a detailed explanation of the components in this code chunk:

## Classes and Methods

### 1. `ExceptionRecord` Class
This class represents a record of an exception related to a cheque. It stores details such as the account number, cheque number, type of exception, additional details, and the date of the exception. It also optionally stores FIR/legal complaint details.

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
- **Behavior:** Initializes the exception record with the provided details and sets `firDetails` to `null`.

### 2. `FIRDetails` Class
This class represents FIR/legal complaint details for a bounced cheque. It stores information such as the FIR number, police station, FIR date, and remarks.

#### Constructor:
```java
FIRDetails(String firNumber, String policeStation, Date firDate, String remarks)
```
- **Parameters:**
  - `firNumber`: The FIR number.
  - `policeStation`: The name of the police station where the FIR was filed.
  - `firDate`: The date of the FIR.
  - `remarks`: Additional remarks about the FIR.
- **Behavior:** Initializes the FIR details with the provided information.

### 3. `reportException` Method
This method is used to report a cheque exception by creating a new `ExceptionRecord` and adding it to the list of exceptions.

#### Method Signature:
```java
public void reportException(String accountNumber, String chequeNumber, String type, String details)
```
- **Parameters:**
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `type`: The type of exception (e.g., "Bounced").
  - `details`: Additional details about the exception.
- **Behavior:**
  - Creates a new `ExceptionRecord` with the provided details and the current date.
  - Adds the record to the `exceptions` list.
  - Prints a message indicating that the exception has been reported.

### 4. `recordFIRDetails` Method
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
- **Behavior:**
  - Searches the `exceptions` list for a matching `ExceptionRecord` with the specified account number, cheque number, and type "Bounced".
  - If a match is found, updates the `firDetails` field of the record with the provided FIR details and prints a success message.
  - If no match is found, prints an error message and returns `false`.

### 5. `displayExceptions` Method
This method displays all reported cheque exceptions, including any associated FIR/legal complaint details for bounced cheques.

#### Method Signature:
```java
public void displayExceptions()
```
- **Behavior:**
  - If the `exceptions` list is empty, prints a message indicating that no exceptions have been reported.
  - Otherwise, iterates through the `exceptions` list and prints the details of each exception.
  - If an exception is of type "Bounced" and has associated FIR details, prints the FIR details as well.

### 6. `ChequeStatus` Enum
This enumeration represents the possible statuses of a cheque:
- `ISSUED`
- `PROCESSED`
- `CANCELED`

### 7. `ChequeStatusManager` Class
This class manages the statuses of cheques using a map where the key is a combination of the account number and cheque number, and the value is the cheque's status.

#### Methods:
- `setStatus(String accountNumber, String chequeNumber, ChequeStatus status)`: Sets the status of a cheque.
- `getStatus(String accountNumber, String chequeNumber)`: Retrieves the status of a cheque.
- `displayAllStatuses()`: Displays all recorded cheque statuses.

### 8. `Logger` Class
This utility class provides methods for logging messages at different levels (INFO, WARN, ERROR, DEBUG).

#### Methods:
- `log(Level level, String message)`: Logs a message with the specified level and a timestamp.
- `info(String message)`, `warn(String message)`, `error(String message)`, `debug(String message)`: Convenience methods for logging messages at specific levels.

### 9. `ChequeImageHandler` Class
This class simulates handling cheque images, including loading image data from a file path.

#### Method:
- `loadImageData(String filePath)`: Simulates loading image data from a file path and returns a byte array representing the image data.

### 10. `CryptographyService` Class
This class simulates cryptographic operations such as encryption and digital signing.

#### Methods:
- `encryptData(byte[] data, String key)`: Simulates encrypting data with a key.
- `signData(byte[] data, String privateKey)`: Simulates digitally signing data with a private key.

### 11. `ClearinghouseService` Class
This class simulates submitting cheque image data and signatures to a clearinghouse.

#### Method:
- `submitToClearinghouse(String accountNumber, String chequeNumber, byte[] encryptedImageData, String digitalSignature)`: Simulates submitting data to a clearinghouse.

### 12. `SignatureVerificationService` Class
This class simulates verifying signatures on cheques.

#### Constructor:
- Initializes the service with some sample signatures for testing.

---

This code chunk provides a comprehensive set of functionalities for managing cheque-related operations, including exception handling, FIR recording, status tracking, logging, image handling, cryptographic operations, and clearinghouse submissions.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_07"
confidence_score: 0.95
external_dependencies: ["CurrencyExchangeService", "CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService"]
---

# Documentation: `SignatureVerificationService` and `ChequeProcessor` Classes

## Overview
This code chunk contains two main classes:

1. **`SignatureVerificationService`**: A service for verifying and managing signatures associated with bank accounts. It provides methods to verify and update signatures for accounts.
2. **`ChequeProcessor`**: A module responsible for processing cheques. It integrates multiple services such as signature verification, fraud detection, currency conversion, and core banking system updates to handle cheque processing.

---

## `SignatureVerificationService` Class

### Purpose
The `SignatureVerificationService` class is a utility for managing and verifying account signatures. It is a simplified implementation designed for demonstration purposes.

### Fields
- `accountSignatures`: A `Map<String, String>` that stores account numbers as keys and their corresponding signatures as values.

### Constructor
- **`SignatureVerificationService()`**: Initializes the service with a set of sample account numbers and their corresponding signatures for testing purposes.

### Methods

#### `boolean verifySignature(String accountNumber, String signature)`
- **Description**: Verifies if the provided signature matches the one on file for the given account number.
- **Parameters**:
  - `accountNumber`: The account number to verify the signature for.
  - `signature`: The signature to be verified.
- **Returns**: `true` if the signature matches the one on file or if no signature is on file (in which case the provided signature is accepted and stored). Returns `false` if the signature does not match.
- **Behavior**:
  - If no signature is on file for the account, the provided signature is accepted and stored.
  - If a signature is on file, it is compared with the provided signature. If they match, the method returns `true`; otherwise, it returns `false`.

#### `void updateSignature(String accountNumber, String newSignature)`
- **Description**: Updates the signature on file for a given account number.
- **Parameters**:
  - `accountNumber`: The account number for which the signature is to be updated.
  - `newSignature`: The new signature to be stored.
- **Behavior**: Updates the `accountSignatures` map with the new signature for the specified account number.

---

## `ChequeProcessor` Class

### Purpose
The `ChequeProcessor` class is responsible for processing cheques. It integrates various services to perform tasks such as signature verification, fraud detection, currency conversion, and updating the core banking system.

### Fields
- `currencyExchangeService`: An instance of `CurrencyExchangeService` used for currency conversion.
- `signatureVerificationService`: An instance of `SignatureVerificationService` used for signature verification.
- `coreBankingSystemUpdater`: An instance of `CoreBankingSystemUpdater` used to update the core banking system.
- `chequeHistoryManager`: An instance of `ChequeHistoryManager` used to manage cheque history.
- `fraudDetectionService`: An instance of `FraudDetectionService` used for fraud detection.
- `exceptionReportManager`: An instance of `ExceptionReportManager` used to report exceptions during cheque processing.
- `chequeStatusManager`: An instance of `ChequeStatusManager` used to track the status of cheques.
- `emailNotificationService`: An instance of `EmailNotificationService` used to send email notifications.

### Constructor
- **`ChequeProcessor(...)`**: Initializes the `ChequeProcessor` with instances of the required services.

### Methods

#### `void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`
- **Description**: Processes a cheque by performing various checks and operations.
- **Parameters**:
  - `accountNumber`: The account number associated with the cheque.
  - `chequeNumber`: The cheque number.
  - `currency`: The currency of the cheque amount.
  - `amount`: The amount of the cheque.
  - `signature`: The signature to be verified.
- **Behavior**:
  1. Checks if the cheque is already tracked in the `ChequeStatusManager`. If not, marks it as `ISSUED`.
  2. Verifies the signature using the `SignatureVerificationService`. If verification fails, reports an exception and sends an email notification.
  3. Performs fraud detection using the `FraudDetectionService`. If the cheque is fraudulent, reports an exception and sends an email notification.
  4. Simulates a bounced cheque if the amount exceeds $50,000, reporting an exception and sending an email notification.
  5. Simulates a delayed cheque if the cheque number ends with '9', reporting an exception.
  6. Converts the cheque amount to local currency using the `CurrencyExchangeService` if the currency is not USD. Applies exchange rates and fees.
  7. Updates the core banking system with the final amount in local currency using the `CoreBankingSystemUpdater`.

---

## External Dependencies
The following external classes and services are used in this code:

1. **`CurrencyExchangeService`**: Provides currency exchange rates and detailed exchange rate information.
2. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
3. **`ChequeHistoryManager`**: Manages the history of cheques processed.
4. **`FraudDetectionService`**: Detects fraudulent or duplicate cheques.
5. **`ExceptionReportManager`**: Reports exceptions encountered during cheque processing.
6. **`ChequeStatusManager`**: Tracks the status of cheques (e.g., issued, processed, canceled).
7. **`EmailNotificationService`**: Sends email notifications to account holders regarding cheque processing issues.

---

## Notes
- The `SignatureVerificationService` is a simplified implementation and may not be suitable for production use.
- The `ChequeProcessor` class relies on several external services, which are assumed to be implemented elsewhere in the codebase.
- The `processCheque` method includes simulated scenarios for bounced and delayed cheques, which may not reflect real-world banking operations.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_08"
confidence_score: 0.95
external_dependencies: ["CoreBankingSystemUpdater", "ChequeHistoryManager", "ChequeStatusManager", "ChequeStatus", "ExceptionReportManager", "EmailNotificationService"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a cheque processing system. It handles the processing and cancellation of cheques, including updating the core banking system, recording cheque history, managing cheque statuses, and handling exceptions. Additionally, it includes a utility class for currency exchange services.

## Code Breakdown

### Cheque Processing
The code processes a cheque by performing the following steps:

1. **Log and Display Transaction Details:**
   - Logs and displays details such as currency, original amount, exchange rate, fee rate, fee amount, and the amount in local currency before and after applying fees.

2. **Update Core Banking System:**
   - Calls `coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency)` to update the account balance in the core banking system.

   **Dependency:**
   - `CoreBankingSystemUpdater` is a mock implementation that updates the core banking system with the account number and the final amount in local currency.

3. **Record Cheque History:**
   - Calls `chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date())` to record the cheque details in the history.

   **Dependency:**
   - `ChequeHistoryManager` is a mock implementation that stores cheque records in a history map.

4. **Update Cheque Status:**
   - Calls `chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED)` to update the status of the cheque to `PROCESSED`.

   **Dependency:**
   - `ChequeStatusManager` is a class that manages the status of cheques using a map. The status is represented by the `ChequeStatus` enum, which includes values like `ISSUED`, `PROCESSED`, and `CANCELED`.

5. **Error Handling:**
   - If an exception occurs during processing, the following actions are taken:
     - Logs the error using `Logger.error`.
     - Reports the exception using `exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage())`.

       **Dependency:**
       - `ExceptionReportManager` is a class that logs exception details, including account number, cheque number, error type, and error message.

     - Sends an email notification about the error using `emailNotificationService.sendEmail`.

       **Dependency:**
       - `EmailNotificationService` is a class that simulates sending email notifications by printing the email details to the console.

### Cheque Cancellation
The `cancelCheque` method is used to cancel a cheque. It performs the following steps:

1. **Update Cheque Status:**
   - Calls `chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.CANCELED)` to update the status of the cheque to `CANCELED`.

2. **Log and Display Cancellation:**
   - Logs the cancellation using `Logger.info` and displays a message to the console.

3. **Error Handling:**
   - If an exception occurs during cancellation, it logs the error using `Logger.error` and displays an error message to the console.

### CurrencyExchangeService Class
This class provides methods for handling currency exchange rates and conversions. It includes the following features:

1. **Exchange Rate Retrieval:**
   - The `getExchangeRate` method retrieves the exchange rate for a given currency. It first checks a cache for a valid rate, then attempts to fetch the rate from an external API. If both fail, it falls back to predefined rates.

2. **Currency Conversion:**
   - The `convertCurrency` method converts an amount from one currency to another by first converting it to the base currency (USD) and then to the target currency.

3. **Detailed Exchange Rates:**
   - The `getDetailedExchangeRates` method provides detailed rate information, including mid, buy, and sell rates, as well as fees.

4. **Supported Currencies:**
   - The `getSupportedCurrencies` method returns a sorted list of all supported currency codes.

5. **Cache Validation:**
   - The `isCacheValid` method checks if a cached exchange rate is still valid based on a predefined expiry time.

### External Dependencies
- **CoreBankingSystemUpdater:** Updates the core banking system with account and transaction details.
- **ChequeHistoryManager:** Records cheque details in a history map.
- **ChequeStatusManager:** Manages the status of cheques using a map.
- **ChequeStatus:** Enum representing the status of a cheque (e.g., ISSUED, PROCESSED, CANCELED).
- **ExceptionReportManager:** Logs exception details.
- **EmailNotificationService:** Simulates sending email notifications.

## Error Handling
The code includes robust error handling mechanisms:
- Logs errors using `Logger.error`.
- Reports exceptions using `ExceptionReportManager`.
- Sends email notifications for errors using `EmailNotificationService`.

## Notes
- The `CurrencyExchangeService` class uses a combination of cached rates, external API calls, and fallback rates to provide exchange rate information. The API key is hardcoded as "demo" and should be replaced with a valid key in a production environment.
- The `CurrencyExchangeService` class also calculates buy/sell rates and fees based on the base rate.
- The `cancelCheque` method is a simple implementation that only updates the cheque status to `CANCELED` and logs the action.

This code is part of a larger system and relies on several external classes and services for its functionality.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_09"
confidence_score: 0.95
external_dependencies: ["java.util.Collections", "java.util.HashMap", "java.util.Map", "java.util.List", "java.util.ArrayList", "java.net.HttpURLConnection", "java.net.URL", "java.io.BufferedReader", "java.io.InputStreamReader", "java.time.LocalDateTime", "java.util.Date", "FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

## Overview
This code chunk contains multiple classes and methods related to currency exchange services and fraud detection. The main components include:

1. **CurrencyExchangeService**: A service for managing currency exchange rates, including caching, fetching rates from an external API, and clearing the cache.
2. **CurrencyExchangeServiceV2**: An enhanced version of the currency exchange service with additional features and a fallback mechanism for exchange rates.
3. **CurrencyRate**: A data class to store currency rate information along with a timestamp.
4. **FraudDetectionService**: A service for detecting fraudulent cheque activities using various fraud detection mechanisms.

## Detailed Explanation

### CurrencyExchangeService
This class provides functionality for managing currency exchange rates. It includes the following key components:

- **exchangeRateCache**: A `Map<String, CurrencyRate>` that stores cached exchange rates for different currencies.
- **BASE_CURRENCY**: A constant representing the base currency ("USD").
- **CACHE_EXPIRY_MINUTES**: A constant defining the cache expiry time (60 minutes).
- **API_KEY**: A placeholder for the API key used to fetch exchange rates from an external API.

#### Methods

1. **isCacheValid(String currency)**
   - Checks if the cached exchange rate for a given currency is still valid.
   - Compares the current time with the cache's expiry time.
   - Returns `true` if the cache is valid, otherwise `false`.

2. **fetchRateFromAPI(String currency)**
   - Fetches the exchange rate for a given currency from an external API (e.g., Open Exchange Rates API).
   - Uses `java.net.HttpURLConnection` to make an HTTP GET request.
   - Parses the API response to extract the exchange rate (mocked in this code).
   - Throws an exception if the API call fails or returns an error status code.

3. **clearCache()**
   - Clears the `exchangeRateCache`.
   - Logs a message indicating that the cache has been cleared.

### CurrencyExchangeServiceV2
This is an enhanced version of the `CurrencyExchangeService` with additional features and a fallback mechanism for exchange rates.

#### Key Components
- **cache**: A `Map<String, Double>` that stores cached exchange rates.
- **BASE**: A constant representing the base currency ("USD").
- **KEY**: A placeholder for the API key used to fetch exchange rates from an external API.
- **RATES**: A static map containing fallback exchange rates for various currencies.

#### Methods

1. **getExchangeRateV2(String currency)**
   - Retrieves the exchange rate for a given currency.
   - Checks the cache first, then attempts to fetch the rate from an external API.
   - Falls back to predefined rates if the API call fails.

2. **convertCurrencyV2(double amount, String from, String to)**
   - Converts an amount from one currency to another using exchange rates.
   - Returns `0.0` if the exchange rate for either currency is unavailable.

3. **getDetailedExchangeRatesV2(String currency)**
   - Provides detailed exchange rate information for a given currency, including mid, buy, sell, and fee rates.

4. **getSupportedCurrenciesV2()**
   - Returns a list of supported currencies, including the base currency and those in the fallback rates.

5. **fetchRateFromAPIV2(String currency)**
   - Fetches the exchange rate for a given currency from an external API.
   - Parses the API response to extract the exchange rate (inefficiently).

6. **clearCacheV2()**
   - Clears the `cache`.

### CurrencyRate
A simple data class to store currency rate information along with a timestamp.

#### Fields
- **rate**: The exchange rate.
- **lastUpdated**: The timestamp of the last update.

#### Constructor
- **CurrencyRate(double rate, java.time.LocalDateTime lastUpdated)**: Initializes the `rate` and `lastUpdated` fields.

#### Methods
- **getRate()**: Returns the exchange rate.
- **getLastUpdated()**: Returns the timestamp of the last update.

### FraudDetectionService
This class implements various mechanisms to detect fraudulent cheque activities. It uses a `FraudDetection` instance and a `ChequeHistoryManager` for historical data.

#### Key Components
- **fraudDetection**: An instance of the `FraudDetection` class.
- **historyManager**: An instance of the `ChequeHistoryManager` class.
- **recentTransactions**: A `Map<String, List<ChequeTransaction>>` to store recent transactions.
- **Fraud detection thresholds**:
  - `VELOCITY_CHECK_DAYS`: Number of days for velocity checks (7 days).
  - `VELOCITY_THRESHOLD`: Maximum allowed transactions in the velocity check period (5 transactions).
  - `PATTERN_THRESHOLD`: Similarity threshold for pattern-based fraud detection (95%).
  - `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for amount-based fraud detection (90%).
  - `UNUSUAL_FREQUENCY_THRESHOLD`: Threshold for unusual frequency detection (3x normal frequency).

#### Methods

1. **isFraudulentCheque(String accountId, String chequeNumber, double amount)**
   - Checks if a cheque is fraudulent based on various criteria, including duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions.
   - Logs the results of the fraud checks and determines the fraud alert level.
   - Returns `true` if any of the checks indicate fraud, otherwise `false`.

2. **checkDuplicateCheque(String accountId, String chequeNumber)**
   - Checks if the cheque is a duplicate using the `FraudDetection` instance.

3. **checkAbnormalAmount(double amount)**
   - Checks if the cheque amount is abnormal using the `FraudDetection` instance.

### External Dependencies
- **java.util.Collections**: Used for sorting collections.
- **java.util.HashMap**: Used for storing key-value pairs.
- **java.util.Map**: Interface for key-value mappings.
- **java.util.List**: Interface for ordered collections.
- **java.util.ArrayList**: Implementation of the `List` interface.
- **java.net.HttpURLConnection**: Used for making HTTP requests.
- **java.net.URL**: Represents a URL.
- **java.io.BufferedReader**: Used for reading text from an input stream.
- **java.io.InputStreamReader**: Converts byte streams to character streams.
- **java.time.LocalDateTime**: Represents date-time without a time-zone.
- **java.util.Date**: Represents a specific instant in time.
- **FraudDetection**: A class used for fraud detection (implementation not provided in this chunk).
- **ChequeHistoryManager**: A class for managing cheque history records.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_10"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

## Overview
This code chunk is part of a fraud detection system implemented in the `FraudDetectionServiceV1` class. It provides various methods to detect fraudulent activities related to cheque transactions. The system evaluates multiple fraud indicators, such as duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions. Based on these checks, it determines an alert level and logs the results.

## Key Components

### 1. **Fraud Detection Methods**
The following methods are used to detect specific types of fraud:

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
- **Purpose**: Checks if a cheque is a duplicate.
- **Implementation**: Delegates the check to the `FraudDetection` class.

#### `checkAbnormalAmount(double amount)`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Implementation**: Delegates the check to the `FraudDetection` class.

#### `checkSuspiciousActivity(String accountId, double amount)`
- **Purpose**: Checks for suspicious activity based on the account ID and amount.
- **Implementation**: Delegates the check to the `FraudDetection` class.

#### `checkVelocityFraud(String accountId, double amount)`
- **Purpose**: Detects if there are too many transactions within a short period (velocity fraud).
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within the last 7 days (`VELOCITY_CHECK_DAYS`).
  - Counts the number of recent transactions and compares it to a threshold (`VELOCITY_THRESHOLD`).
  - Cleans up old transactions to optimize memory usage.

#### `checkPatternFraud(String accountId, double amount)`
- **Purpose**: Detects if the current transaction follows a suspicious pattern of similar amounts.
- **Implementation**:
  - Retrieves recent transactions for the account.
  - Compares the current amount with past amounts to calculate similarity.
  - Flags fraud if at least three past transactions have a similarity above the `PATTERN_THRESHOLD` (95%).

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
- **Purpose**: Checks if the cheque number exists in the historical records.
- **Implementation**: Uses the `ChequeHistoryManager` class to retrieve historical cheque numbers for the account.

#### `checkUnusualFrequency(String accountId)`
- **Purpose**: Detects if the frequency of recent transactions is unusually high.
- **Implementation**:
  - Retrieves the total and recent cheque counts for the account from the `ChequeHistoryManager`.
  - Compares the recent cheque count to the average monthly frequency multiplied by the `UNUSUAL_FREQUENCY_THRESHOLD` (3x).

#### `checkSimilarToRecent(String accountId, double amount)`
- **Purpose**: Checks if the current transaction amount is similar to recent transactions.
- **Implementation**: Uses the `ChequeHistoryManager` class to compare the current amount with recent cheque amounts based on a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### 2. **Alert Level Determination**
#### `determineAlertLevel(...)`
- **Purpose**: Determines the fraud alert level based on the results of the individual fraud checks.
- **Implementation**:
  - Assigns weights to each fraud indicator.
  - Calculates a total fraud score.
  - Returns an alert level (`LOW`, `MEDIUM`, `HIGH`, or `CRITICAL`) based on the score.

### 3. **Logging Fraud Checks**
#### `logFraudChecks(...)`
- **Purpose**: Logs the results of all fraud checks for a given transaction.
- **Implementation**:
  - Prints a detailed report of the fraud checks, including basic and advanced checks.
  - Summarizes whether any fraud was detected.

### 4. **Helper Methods and Classes**
#### `formatCheckResult(boolean failed)`
- **Purpose**: Formats the result of a fraud check for logging.
- **Output**: Returns "FAILED ⚠️" if the check failed, otherwise "Passed ✓".

#### `ChequeTransaction` (Inner Class)
- **Purpose**: Represents a cheque transaction with an amount and date.
- **Fields**:
  - `double amount`: The amount of the cheque.
  - `java.time.LocalDate date`: The date of the transaction.
- **Methods**:
  - `getAmount()`: Returns the amount of the transaction.
  - `getDate()`: Returns the date of the transaction.

## External Dependencies

### 1. **FraudDetection**
- A class used to perform basic fraud checks such as detecting duplicate cheques, abnormal amounts, and suspicious activities.

### 2. **ChequeHistoryManager**
- A class used to manage historical cheque data and perform advanced fraud checks, such as detecting historical duplicates, unusual frequencies, and similar recent transactions.

## Constants
- `VELOCITY_CHECK_DAYS`: Number of days to consider for velocity fraud detection (7 days).
- `VELOCITY_THRESHOLD`: Maximum allowed transactions within the velocity check period (5 transactions).
- `PATTERN_THRESHOLD`: Similarity threshold for pattern fraud detection (95%).
- `SIMILAR_AMOUNT_THRESHOLD`: Similarity threshold for recent transaction amounts (90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: Multiplier for detecting unusual frequency (3x).

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses a combination of basic and advanced checks to identify potential fraud and assigns an appropriate alert level based on the severity of the detected issues. The system also logs detailed reports of the checks performed, making it easier to audit and analyze fraud detection results.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_11"
confidence_score: 0.95
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Documentation: Fraud Detection Methods in `DemoApplication`

This code chunk is part of a fraud detection system implemented in the `DemoApplication.java` file. It defines a method `isFraudulentCheque` that evaluates whether a cheque transaction is potentially fraudulent based on various criteria. The class also includes helper methods to perform specific fraud checks and utility methods for logging and formatting results.

## `isFraudulentCheque` Method

### Purpose
The `isFraudulentCheque` method determines whether a cheque transaction is fraudulent by performing a series of checks. It evaluates the transaction based on duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions.

### Parameters
- `String accountId`: The unique identifier for the account associated with the cheque.
- `String chequeNumber`: The unique identifier for the cheque.
- `double amount`: The monetary value of the cheque.

### Returns
- `boolean`: Returns `true` if the cheque is deemed fraudulent based on any of the checks; otherwise, returns `false`.

### Workflow
1. **Basic Checks**:
   - `checkDuplicateCheque`: Checks if the cheque is a duplicate.
   - `checkAbnormalAmount`: Checks if the cheque amount is abnormal.
   - `checkSuspiciousActivity`: Checks for suspicious activity associated with the account and amount.
   - `checkVelocityFraud`: Checks if the transaction frequency exceeds a predefined threshold.
   - `checkPatternFraud`: Checks for patterns in recent transactions that indicate fraud.

2. **Advanced Checks** (if `historyManager` is available):
   - `checkHistoricalDuplicate`: Checks if the cheque number exists in historical records.
   - `checkUnusualFrequency`: Checks if the frequency of transactions is unusually high.
   - `checkSimilarToRecent`: Checks if the cheque amount is similar to recent transactions.

3. **Logging**:
   - `logFraudChecks`: Logs the results of all fraud checks for auditing and debugging purposes.

4. **Alert Level Determination**:
   - `determineAlertLevel`: Assigns an alert level (CRITICAL, HIGH, MEDIUM, LOW) based on the results of the checks.

5. **Final Decision**:
   - Returns `true` if any of the checks indicate fraud; otherwise, returns `false`.

## Helper Methods

### `checkDuplicateCheque`
- **Purpose**: Checks if the cheque is a duplicate.
- **Implementation**: Delegates to the `isDuplicateCheque` method of the `FraudDetection` class.

### `checkAbnormalAmount`
- **Purpose**: Checks if the cheque amount is abnormal.
- **Implementation**: Delegates to the `isAbnormalAmount` method of the `FraudDetection` class.

### `checkSuspiciousActivity`
- **Purpose**: Checks for suspicious activity based on the account and amount.
- **Implementation**: Delegates to the `isSuspiciousActivity` method of the `FraudDetection` class.

### `checkVelocityFraud`
- **Purpose**: Checks if the transaction frequency exceeds a predefined threshold.
- **Implementation**:
  - Maintains a list of recent transactions for each account.
  - Filters transactions within a specific time window (`VELOCITY_CHECK_DAYS`).
  - Compares the count of recent transactions to a threshold (`VELOCITY_THRESHOLD`).

### `checkPatternFraud`
- **Purpose**: Checks for patterns in recent transactions that indicate fraud.
- **Implementation**:
  - Analyzes recent transactions for the account.
  - Compares the similarity of amounts to a predefined threshold (`PATTERN_THRESHOLD`).

### `checkHistoricalDuplicate`
- **Purpose**: Checks if the cheque number exists in historical records.
- **Implementation**: Uses the `ChequeHistoryManager` class to retrieve historical cheque numbers for the account.

### `checkUnusualFrequency`
- **Purpose**: Checks if the frequency of transactions is unusually high.
- **Implementation**:
  - Retrieves total and recent cheque counts from the `ChequeHistoryManager`.
  - Compares recent cheque counts to an average monthly frequency multiplied by a threshold (`UNUSUAL_FREQUENCY_THRESHOLD`).

### `checkSimilarToRecent`
- **Purpose**: Checks if the cheque amount is similar to recent transactions.
- **Implementation**: Uses the `ChequeHistoryManager` to find similar recent cheques based on a similarity threshold (`SIMILAR_AMOUNT_THRESHOLD`).

### `determineAlertLevel`
- **Purpose**: Assigns an alert level based on the results of the fraud checks.
- **Implementation**:
  - Calculates a fraud score based on the number and severity of failed checks.
  - Returns one of the following alert levels: `CRITICAL`, `HIGH`, `MEDIUM`, or `LOW`.

### `logFraudChecks`
- **Purpose**: Logs the results of all fraud checks for auditing and debugging purposes.
- **Implementation**:
  - Prints a detailed report of the fraud checks, including basic and advanced checks.
  - Summarizes whether any fraud was detected.

### `formatCheckResult`
- **Purpose**: Formats the result of a fraud check for logging.
- **Implementation**: Returns "FAILED ⚠️" if the check failed, otherwise returns "Passed ✓".

## Nested Class: `ChequeTransaction`

### Purpose
Represents a single cheque transaction with an amount and a date.

### Fields
- `double amount`: The monetary value of the cheque.
- `java.time.LocalDate date`: The date of the transaction.

### Constructor
- `ChequeTransaction(double amount, java.time.LocalDate date)`: Initializes the transaction with the specified amount and date.

### Methods
- `double getAmount()`: Returns the amount of the transaction.
- `java.time.LocalDate getDate()`: Returns the date of the transaction.

## External Dependencies

### `FraudDetection`
A service class used for basic fraud checks such as duplicate cheques, abnormal amounts, and suspicious activity.

### `ChequeHistoryManager`
A mock implementation that manages historical cheque data. Provides methods to retrieve cheque history and analyze transaction patterns.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_12"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager", "ChequeTransaction"]
---

# FraudDetectionServiceV2 Class Documentation

## Overview
The `FraudDetectionServiceV2` class is a service designed to detect fraudulent cheque activities. It implements various fraud detection mechanisms and integrates with the `ChequeHistoryManager` to analyze historical cheque data. The class uses multiple strategies to identify potential fraud, such as detecting duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, and pattern-based fraud.

## Fields

### Fraud Detection Components
- **fraudDetection**: An instance of the `FraudDetection` class, which provides methods for detecting specific types of fraud (e.g., duplicate cheques, abnormal amounts, suspicious activities).
- **historyManager**: An instance of the `ChequeHistoryManager` class, used to retrieve historical cheque data for fraud analysis.

### Data Structures
- **recentTransactions**: A map that stores recent cheque transactions for each account.
- **duplicateChequeCounter**: A map that tracks the count of duplicate cheques for each account.
- **abnormalAmounts**: A map that stores abnormal cheque amounts for each account.
- **suspiciousAmounts**: A map that stores suspicious cheque amounts for each account.
- **velocityAmounts**: A map that tracks cheque amounts for velocity fraud detection.
- **patternAmounts**: A map that tracks cheque amounts for pattern-based fraud detection.
- **historicalDuplicateAmounts**: A map that tracks historical duplicate cheque amounts.
- **unusualFrequencyAmounts**: A map that tracks cheque amounts with unusual frequency.
- **similarToRecentAmounts**: A map that tracks cheque amounts similar to recent transactions.
- **fraudLogs**: A list of strings used to log fraud detection activities.
- **totalFraudChecks**: An integer counter for the total number of fraud checks performed.

### Fraud Detection Thresholds
- **VELOCITY_CHECK_DAYS**: The number of days to consider for velocity fraud detection (default: 7 days).
- **VELOCITY_THRESHOLD**: The maximum number of transactions allowed within the velocity check period (default: 5 transactions).
- **PATTERN_THRESHOLD**: The similarity threshold for pattern-based fraud detection (default: 95%).
- **SIMILAR_AMOUNT_THRESHOLD**: The similarity threshold for detecting amounts similar to recent transactions (default: 90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: The multiplier for detecting unusual frequency of transactions (default: 3x normal frequency).

### Fraud Alert Levels
The `AlertLevel` enum defines the levels of fraud alerts:
- **LOW**
- **MEDIUM**
- **HIGH**
- **CRITICAL**

## Constructor

### FraudDetectionServiceV2()
Initializes the `FraudDetectionServiceV2` instance and its internal data structures.

## Methods

### setHistoryManager(ChequeHistoryManager historyManager)
Sets the `ChequeHistoryManager` instance for retrieving historical cheque data.

### isFraudulentCheque(String accountId, String chequeNumber, double amount)
Performs a comprehensive fraud check for a given cheque. It evaluates multiple fraud detection criteria and determines the fraud alert level.

#### Parameters:
- **accountId**: The account ID associated with the cheque.
- **chequeNumber**: The cheque number.
- **amount**: The cheque amount.

#### Returns:
- **boolean**: `true` if the cheque is fraudulent, `false` otherwise.

### Private Helper Methods

#### checkDuplicateCheque(String accountId, String chequeNumber)
Checks if the cheque is a duplicate using the `FraudDetection` class.

#### checkAbnormalAmount(double amount)
Checks if the cheque amount is abnormal using the `FraudDetection` class.

#### checkSuspiciousActivity(String accountId, double amount)
Checks for suspicious activity using the `FraudDetection` class.

#### checkVelocityFraud(String accountId, double amount)
Detects velocity fraud by analyzing the frequency of recent transactions for the account.

#### checkPatternFraud(String accountId, double amount)
Detects pattern-based fraud by analyzing the similarity of recent transaction amounts.

#### checkHistoricalDuplicate(String accountId, String chequeNumber)
Checks for historical duplicate cheques using the `ChequeHistoryManager`.

#### checkUnusualFrequency(String accountId)
Detects unusual frequency of transactions using the `ChequeHistoryManager`.

#### checkSimilarToRecent(String accountId, double amount)
Checks if the cheque amount is similar to recent transactions using the `ChequeHistoryManager`.

#### determineAlertLevel(...)
Determines the fraud alert level based on the results of various fraud checks.

#### logFraudChecks(...)
Logs the results of the fraud checks for a given cheque.

## External Dependencies

### FraudDetection
A class that provides methods for detecting specific types of fraud. The exact implementation is not provided in the current context.

### ChequeHistoryManager
A mock implementation for managing historical cheque data. It provides methods to record and retrieve cheque history.

### ChequeTransaction
A class representing a cheque transaction. The exact implementation is not provided in the current context.

## Notes
- The `FraudDetection` and `ChequeTransaction` classes are not fully defined in the provided code or search results. Their functionality is inferred based on their usage in the `FraudDetectionServiceV2` class.
- The `ChequeHistoryManager` is a mock implementation that stores and retrieves cheque history for fraud analysis.

=== NEXT CHUNK ===

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

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_14"
confidence_score: 0.9
external_dependencies: ["BatchCheque"]
---

# Documentation for Code Chunk

This code chunk is part of a Java application that appears to manage cheque processing, including batch details and stuck transactions. Below is a detailed explanation of the methods in this chunk:

## Methods

### `displayBatchDetails(String batchId)`
This method retrieves and displays the details of a specific batch of cheques identified by the `batchId`.

#### Parameters:
- `batchId` (String): The unique identifier for the batch of cheques.

#### Functionality:
1. Retrieves the list of `BatchCheque` objects associated with the given `batchId` from the `batches` map.
2. If no batch is found for the given `batchId`, it prints "Batch not found." and exits the method.
3. If a batch is found, it iterates through the list of `BatchCheque` objects and prints the details of each cheque, including:
   - Account number
   - Cheque number
   - Amount
   - Currency

#### Dependencies:
- `BatchCheque`: A class representing a cheque in a batch. It contains fields such as `accountNumber`, `chequeNumber`, `amount`, and `currency`.
- `batches`: A `Map` that stores batch IDs as keys and lists of `BatchCheque` objects as values.

---

### `markTransactionStuck(String chequeNumber)`
This method marks a cheque as "stuck" by adding its cheque number to a collection of stuck transactions.

#### Parameters:
- `chequeNumber` (String): The unique identifier of the cheque to be marked as stuck.

#### Functionality:
1. Adds the `chequeNumber` to the `stuckTransactions` collection.
2. Prints a confirmation message indicating that the cheque has been marked as stuck.

#### Dependencies:
- `stuckTransactions`: A collection (likely a `Set` or `List`) that stores the cheque numbers of stuck transactions.

---

### `resetStuckTransaction(String chequeNumber)`
This method removes a cheque from the list of stuck transactions.

#### Parameters:
- `chequeNumber` (String): The unique identifier of the cheque to be reset.

#### Functionality:
1. Attempts to remove the `chequeNumber` from the `stuckTransactions` collection.
2. If the cheque number is successfully removed, it prints a confirmation message.
3. If the cheque number is not found in the `stuckTransactions` collection, it prints a message indicating that the cheque was not marked as stuck.

#### Dependencies:
- `stuckTransactions`: A collection that stores the cheque numbers of stuck transactions.

---

### `displayStuckTransactions()`
This method displays all the cheque numbers currently marked as stuck.

#### Parameters:
- None

#### Functionality:
1. Prints a header "--- Stuck Transactions ---".
2. If the `stuckTransactions` collection is empty, it prints "No stuck transactions.".
3. If the collection is not empty, it iterates through the `stuckTransactions` collection and prints each cheque number.

#### Dependencies:
- `stuckTransactions`: A collection that stores the cheque numbers of stuck transactions.

---

## External Dependencies
- **`BatchCheque`**: A class representing a cheque in a batch. It is used in the `displayBatchDetails` method to access cheque details such as `accountNumber`, `chequeNumber`, `amount`, and `currency`.
- **`batches`**: A `Map` that associates batch IDs with lists of `BatchCheque` objects. It is used in the `displayBatchDetails` method.
- **`stuckTransactions`**: A collection (likely a `Set` or `List`) that stores the cheque numbers of stuck transactions. It is used in the `markTransactionStuck`, `resetStuckTransaction`, and `displayStuckTransactions` methods.

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
The `ChequeApplication` class serves as the entry point for a comprehensive cheque processing system. It initializes various services, handles user authentication, and provides a menu-driven interface for performing multiple cheque-related operations. The system includes enhanced fraud detection, cheque history management, and administrative tools.

## Key Functionalities

### 1. **System Initialization**
The `main` method initializes the following services:
- **CurrencyExchangeService**: Handles currency exchange operations.
- **SignatureVerificationService**: Verifies cheque signatures.
- **CoreBankingSystemUpdater**: Updates the core banking system with cheque transactions.
- **UserService**: Manages user authentication and information.
- **ChequeHistoryManager**: Tracks and displays cheque history.
- **FraudDetectionService**: Detects fraudulent cheque activities.
- **ExceptionReportManager**: Manages and displays cheque exception reports.
- **ChequeStatusManager**: Tracks the status of cheques.
- **EmailNotificationService**: Sends email notifications.
- **AdminService**: Provides administrative functionalities.
- **ChequeImageHandler**: Handles cheque image processing.
- **CryptographyService**: Encrypts and signs cheque data.
- **ClearinghouseService**: Sends cheque data to the clearinghouse.

### 2. **User Authentication**
The `performLogin` method is invoked to authenticate the user. If authentication fails after multiple attempts, the system exits.

### 3. **Menu-Driven Operations**
The application provides a menu with the following options:

#### Cheque Processing
- **Process a Single Cheque**: Prompts the user for cheque details and processes it using the `ChequeProcessor`.
- **Process Multiple Cheques (Batch)**: Invokes the `processChequeBatch` method to handle batch processing.

#### Cheque History and Reports
- **View Cheque History**: Displays the cheque history for a specific account using `ChequeHistoryManager`.
- **Generate Cheque Reports**: Calls `handleReportGeneration` to generate detailed reports.

#### Currency Exchange
- **Currency Exchange Information**: Displays a currency exchange menu using `displayCurrencyExchangeMenu`.

#### Cheque Image Handling
- **Scan, Encrypt, and Send Cheque Image**: Uses `handleChequeImageSubmission` to process cheque images.

#### Administrative Tools
- **Edit IFSC/Bank Codes**: Allows administrators to edit bank codes.
- **Manage Batches**: Provides batch management functionalities.
- **Reset Stuck Transactions**: Resets transactions stuck in the system.

#### Miscellaneous
- **Simulate Cheque Printing**: Uses `handleChequePrinting` to simulate cheque printing.
- **View Cheque Exception Report**: Displays exceptions using `ExceptionReportManager`.
- **View All Cheque Statuses**: Lists all cheque statuses using `ChequeStatusManager`.
- **Cancel a Cheque**: Cancels a cheque using `ChequeProcessor`.
- **Record FIR/Legal Complaint for Bounced Cheque**: Records FIR details for bounced cheques using `ExceptionReportManager`.

### 4. **Exit**
The user can log out and exit the system by selecting the appropriate menu option.

## External Dependencies
The `ChequeApplication` class relies on the following external classes and services:
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

## Notes
- The `performLogin`, `processChequeBatch`, `displayCurrencyExchangeMenu`, `handleReportGeneration`, `handleChequeImageSubmission`, and `handleChequePrinting` methods are defined elsewhere in the codebase.
- The application uses a `Scanner` object for user input.
- The system includes robust error handling for invalid inputs and failed operations.

This documentation provides an overview of the `ChequeApplication` class and its functionalities. For detailed implementation of the referenced methods, refer to their respective documentation.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_16"
confidence_score: 0.9
external_dependencies: ["AdminService", "BatchCheque", "Logger"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of the `DemoApplication` class and implements several administrative functionalities for managing IFSC/Bank codes, batches, and stuck transactions. It also includes methods for user login and batch cheque processing. The code relies on external services such as `AdminService` and `Logger` for its operations.

## Code Breakdown

### Case 13: Admin - Edit IFSC/Bank Codes
This section provides an interface for administrators to manage IFSC and bank codes. The options include:

1. **Add/Update IFSC**: Prompts the user to input an IFSC code and a corresponding bank code, then calls `adminService.addOrUpdateIFSC(ifsc, bankCode)` to save or update the information.
2. **Add/Update Bank Code**: Prompts the user to input a bank code and a bank name, then calls `adminService.addOrUpdateBankCode(code, name)` to save or update the information.
3. **View IFSCs**: Calls `adminService.displayIFSCs()` to display all stored IFSC codes.
4. **View Bank Codes**: Calls `adminService.displayBankCodes()` to display all stored bank codes.
5. **Return**: Exits the current menu.

### Case 14: Admin - Manage Batches
This section provides an interface for administrators to manage cheque batches. The options include:

1. **Create Batch**: Prompts the user to input a batch ID and the number of cheques in the batch. For each cheque, the user is prompted to input details such as account number, cheque number, currency, amount, and signature. These details are stored in a `BatchCheque` object, which is added to a list. Finally, the list is passed to `adminService.createBatch(batchId, batchCheques)` to create the batch.
2. **View Batches**: Calls `adminService.displayBatches()` to display all batches.
3. **View Batch Details**: Prompts the user to input a batch ID and calls `adminService.displayBatchDetails(viewBatchId)` to display details of the specified batch.
4. **Return**: Exits the current menu.

### Case 15: Admin - Reset Stuck Transactions
This section provides an interface for administrators to manage stuck transactions. The options include:

1. **Mark Cheque as Stuck**: Prompts the user to input a cheque number and calls `adminService.markTransactionStuck(stuckChq)` to mark the transaction as stuck.
2. **Reset Stuck Cheque**: Prompts the user to input a cheque number and calls `adminService.resetStuckTransaction(resetChq)` to reset the stuck transaction.
3. **View Stuck Transactions**: Calls `adminService.displayStuckTransactions()` to display all stuck transactions.
4. **Return**: Exits the current menu.

### Exception Handling
The code includes a `try-catch` block to handle any exceptions that may occur during the execution of the main logic. If an exception is caught, it is logged using the `Logger` class, and the stack trace is printed.

### Method: `performLogin`
This method handles the user login process. It allows up to three attempts for the user to log in by providing a username and password. If authentication is successful, the method returns the authenticated `User` object. Otherwise, it returns `null` after three failed attempts.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `userService`: A `UserService` object for authenticating the user.

#### Key Operations:
- Prompts the user for a username and password.
- Calls `userService.authenticate(username, password)` to verify credentials.
- Logs successful or failed login attempts using the `Logger` class.

### Method: `processChequeBatch`
This method handles the processing of multiple cheques in a batch. It prompts the user to input the number of cheques and their details, then processes them using the `ChequeProcessor` service.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `chequeProcessor`: A `ChequeProcessor` object for processing cheques.

#### Key Operations:
- Prompts the user for the number of cheques in the batch.
- Iteratively collects details for each cheque, including account number, cheque number, currency, amount, and signature.
- Creates a `BatchCheque` object for each cheque and adds it to a list.
- Passes the list to `chequeProcessor` for processing.
- Handles exceptions during input collection and logs errors using the `Logger` class.

## External Dependencies
- **`AdminService`**: Provides methods for managing IFSC codes, bank codes, batches, and stuck transactions.
- **`BatchCheque`**: Represents a cheque with details such as account number, cheque number, currency, amount, and signature.
- **`Logger`**: Used for logging information, warnings, and errors.

## Notes
- The `AdminService` and `BatchCheque` classes are defined elsewhere in the codebase.
- The `Logger` class is used for logging but its implementation details are not provided in this chunk.
- The code assumes that user input is valid and does not include extensive input validation.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_17"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager", "ChequePrintingService"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a larger application that handles various banking operations, including cheque processing, currency exchange, report generation, and cheque printing. The provided code includes several methods that perform specific tasks related to these operations. Below is a detailed explanation of the code.

---

### 1. **Batch Cheque Processing**
This section of the code processes a batch of cheques. It adds cheques to a list (`chequesToProcess`) and processes them using a `ChequeProcessor` instance.

#### Key Components:
- **`chequesToProcess`**: A collection that stores instances of `BatchCheque`.
- **`BatchCheque`**: Represents a cheque with attributes such as `accountNumber`, `chequeNumber`, `currency`, `amount`, and `signature`.
- **`chequeProcessor`**: An instance of the `ChequeProcessor` class, which handles the processing of cheques.

#### Workflow:
1. Cheques are added to the `chequesToProcess` list using the `BatchCheque` constructor.
2. If an exception occurs during input collection, it is logged using the `Logger.error` method, and the scanner buffer is cleared.
3. The batch of cheques is processed using the `chequeProcessor.processCheque` method.
4. Any exceptions during processing are logged.

#### External Dependencies:
- `BatchCheque`: Represents a cheque object.
- `ChequeProcessor`: A class responsible for processing cheques. It includes functionalities like signature verification, fraud detection, and currency conversion.

---

### 2. **Currency Exchange Menu**
This method (`displayCurrencyExchangeMenu`) provides a user interface for currency exchange operations. It interacts with the `CurrencyExchangeService` to perform various tasks.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `currencyExchangeService`: An instance of `CurrencyExchangeService` that provides currency exchange functionalities.

#### Menu Options:
1. **View Supported Currencies**: Displays a list of currencies supported by the service.
2. **Get Exchange Rate**: Retrieves the exchange rate for a specific currency.
3. **Get Detailed Exchange Rate Information**: Provides detailed information, including mid, buy, sell, and fee rates for a specific currency.
4. **Convert Currency**: Converts an amount from one currency to another.
5. **Return to Main Menu**: Exits the currency exchange menu.

#### External Dependencies:
- `CurrencyExchangeService`: Provides methods like `getSupportedCurrencies`, `getExchangeRate`, `getDetailedExchangeRates`, and `convertCurrency`.

---

### 3. **Report Generation**
The `handleReportGeneration` method generates reports for cheque transactions over different time periods.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `chequeHistoryManager`: An instance of `ChequeHistoryManager` that manages cheque transaction history.

#### Workflow:
1. Displays a menu with options for generating daily, weekly, monthly, or custom date range reports.
2. Based on the user's choice, determines the date range for the report.
3. Retrieves cheque records for the specified period using `chequeHistoryManager.getAllChequeRecordsInPeriod`.
4. Generates a CSV report using `chequeHistoryManager.generateChequeReportCSV` and writes it to a file.
5. Handles errors such as invalid date formats or no records found.

#### External Dependencies:
- `ChequeHistoryManager`: Manages cheque transaction history and provides methods for retrieving and generating reports.

---

### 4. **Cheque Printing Simulation**
The `handleChequePrinting` method simulates the process of printing a cheque.

#### Parameters:
- `scanner`: A `Scanner` object for reading user input.
- `printingService`: An instance of `ChequePrintingService` that handles cheque printing operations.

#### Workflow:
1. Prompts the user to input details such as payee name, amount, date, account number, and cheque number.
2. Parses the date input and defaults to the current date if the input is invalid.
3. Uses the `printingService` to simulate the cheque printing process.

#### External Dependencies:
- `ChequePrintingService`: Provides methods for simulating cheque printing.

---

## Error Handling
- Exceptions during cheque input collection and processing are logged using `Logger.error`.
- Invalid user inputs, such as incorrect date formats, are handled with appropriate error messages.
- If no records are found for a report, the user is notified.

## Summary
This code chunk is part of a comprehensive banking application that handles cheque processing, currency exchange, report generation, and cheque printing. It relies on several external services and classes to perform these operations efficiently and includes robust error handling to ensure smooth execution.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_18"
confidence_score: 0.95
external_dependencies: ["Scanner", "ChequeImageHandler", "CryptographyService", "ClearinghouseService", "ChequePrintingService", "User"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk contains two main functionalities:
1. **Cheque Printing Simulation**: A method to simulate the process of printing a cheque.
2. **Cheque Image Submission**: A method to handle the process of scanning, encrypting, signing, and sending a cheque image to a clearinghouse.

Additionally, the code includes the implementation of several inner classes that provide services for cheque printing, cryptographic operations, user management, and exception reporting.

---

## 1. Cheque Printing Simulation

### Method: `handleChequePrinting`
This method simulates the process of printing a cheque. It collects user input for various cheque details, validates the input, and then uses the `ChequePrintingService` to print the cheque.

#### Parameters:
- `Scanner scanner`: Used to read user input from the console.
- `ChequePrintingService printingService`: A service responsible for simulating the cheque printing process.

#### Workflow:
1. Prompts the user to enter the payee name, amount, date, account number, and cheque number.
2. Validates the date input. If the date format is invalid, the current date is used as a fallback.
3. Uses the `ChequePrintingService` to print the cheque with the provided details.

#### Example Output:
The cheque is printed in a formatted manner, including details like the bank name, payee name, amount, date, account number, and cheque number.

---

## 2. Cheque Image Submission

### Method: `handleChequeImageSubmission`
This method handles the process of scanning, encrypting, signing, and sending a cheque image to a clearinghouse.

#### Parameters:
- `Scanner scanner`: Used to read user input from the console.
- `ChequeImageHandler imageHandler`: A service responsible for handling cheque image uploads.
- `CryptographyService cryptoService`: A service for encrypting and signing data.
- `ClearinghouseService clearinghouseService`: A service for submitting data to the clearinghouse.
- `User currentUser`: The currently logged-in user.

#### Workflow:
1. Prompts the user to enter the account number, cheque number, and the path to the cheque image file.
2. Uses the `ChequeImageHandler` to load the image data from the specified file path.
   - If the image data cannot be loaded, the process is aborted.
3. Encrypts the image data using a placeholder encryption key and the `CryptographyService`.
4. Signs the encrypted image data using a placeholder private key derived from the current user's username.
5. Submits the encrypted and signed image data to the clearinghouse using the `ClearinghouseService`.

---

## 3. Inner Classes

### 3.1 `ChequePrintingService`
This class simulates the process of printing a cheque. It formats the cheque details, including the bank name, payee name, amount, date, account number, and cheque number, and prints them in a structured format.

#### Method: `printCheque`
- **Parameters:**
  - `String payeeName`: The name of the payee.
  - `double amount`: The amount to be paid.
  - `Date date`: The date of the cheque.
  - `String accountNumber`: The account number associated with the cheque.
  - `String chequeNumber`: The cheque number.
  - `String bankName`: The name of the bank issuing the cheque.
- **Output:**
  - Prints a formatted representation of the cheque to the console.

### 3.2 `User`
This class represents a user of the system, such as an employee or an account holder.

#### Fields:
- `String username`: The username of the user.
- `String password`: The password of the user (stored in plain text, which is not secure).
- `String role`: The role of the user (e.g., "EMPLOYEE", "ACCOUNT_HOLDER").

#### Methods:
- `getUsername()`: Returns the username.
- `getPassword()`: Returns the password.
- `getRole()`: Returns the role of the user.

### 3.3 `UserService`
This class manages users and handles authentication.

#### Methods:
- `registerUser(String username, String password, String role)`: Registers a new user with the specified username, password, and role.
- `authenticate(String username, String password)`: Authenticates a user based on their username and password. Returns the `User` object if authentication is successful, otherwise returns `null`.

### 3.4 `BatchCheque`
This class represents a single cheque transaction for batch processing.

#### Fields:
- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The cheque number.
- `String currency`: The currency of the cheque.
- `double amount`: The amount of the cheque.
- `String signature`: The digital signature of the cheque.

### 3.5 `ExceptionReportManager`
This class manages exception reports for cheques, such as bounced, duplicate, altered, or delayed cheques. It also supports recording FIR/legal complaint details for bounced cheques.

#### Inner Class: `ExceptionRecord`
- **Fields:**
  - `String accountNumber`: The account number associated with the cheque.
  - `String chequeNumber`: The cheque number.
  - `String type`: The type of exception (e.g., "bounced", "duplicate").
  - `String details`: Additional details about the exception.
  - `Date date`: The date of the exception.
  - `FIRDetails firDetails`: Details of any FIR or legal complaint related to the exception.

#### Inner Class: `FIRDetails`
- **Fields:**
  - `String firNumber`: The FIR number.
  - `String policeStation`: The police station where the FIR was filed.
  - `Date firDate`: The date the FIR was filed.
  - `String remarks`: Additional remarks about the FIR.

---

## External Dependencies
- `Scanner`: Used for reading user input.
- `ChequeImageHandler`: Handles cheque image uploads.
- `CryptographyService`: Provides methods for encrypting and signing data.
- `ClearinghouseService`: Submits encrypted and signed data to the clearinghouse.
- `ChequePrintingService`: Simulates the process of printing cheques.
- `User`: Represents a user of the system.

=== NEXT CHUNK ===

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

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_20"
confidence_score: 0.9
external_dependencies: ["CurrencyExchangeService", "FraudDetectionService", "ExceptionReportManager", "ChequeStatusManager", "EmailNotificationService"]
---

# Documentation for `DemoApplication` Code Chunk

This code chunk contains several mock implementations and a `ChequeProcessor` class that integrates multiple services to process cheques. Below is a detailed explanation of the components and their roles:

## 1. `ChequeHistoryManager`
This class is responsible for managing the history of cheques for different accounts. It provides methods to record and display cheque history.

### Methods:
- **`recordCheque(String acc, String chq, String curr, double amt, Date d)`**:
  Records a cheque for a given account.
- **`displayChequeHistory(String acc)`**:
  Displays the number of cheques recorded for a specific account.
- **`getChequeNumbers(String acc)`**:
  Returns a list of cheque numbers for a given account (currently returns an empty list).
- **`getTotalChequeCount(String acc)`**:
  Returns the total number of cheques for a given account (currently returns 0).
- **`getRecentChequeCount(String acc)`**:
  Returns the count of recent cheques for a given account (currently returns 0).
- **`hasSimilarRecentCheque(String acc, double amt, double threshold)`**:
  Checks if there is a similar recent cheque (currently always returns false).
- **`getAllChequeRecordsInPeriod(LocalDate start, LocalDate end)`**:
  Retrieves all cheque records within a specified period (currently returns an empty list).
- **`generateChequeReportCSV(List<ChequeRecord> records)`**:
  Generates a CSV report for the given cheque records (currently returns a placeholder string).

## 2. `CoreBankingSystemUpdater`
This class provides a method to update the core banking system with transaction details.

### Methods:
- **`updateCoreBankingSystem(String acc, double amt)`**:
  Updates the core banking system for a given account and amount.

## 3. `SignatureVerificationService`
This service verifies the signatures on cheques against stored signatures for accounts.

### Fields:
- **`accountSignatures`**:
  A map storing account numbers and their corresponding signatures.

### Methods:
- **`verifySignature(String accountNumber, String signature)`**:
  Verifies if the provided signature matches the stored signature for the account. If no signature is on file, it accepts the new signature and stores it.
- **`updateSignature(String accountNumber, String newSignature)`**:
  Updates the stored signature for a given account.

## 4. `ChequeProcessor`
This class integrates multiple services to process cheques. It handles signature verification, fraud detection, currency conversion, and updates to the core banking system.

### Dependencies:
- **`CurrencyExchangeService`**: Handles currency conversion.
- **`SignatureVerificationService`**: Verifies cheque signatures.
- **`CoreBankingSystemUpdater`**: Updates the core banking system.
- **`ChequeHistoryManager`**: Manages cheque history.
- **`FraudDetectionService`**: Detects fraudulent cheques.
- **`ExceptionReportManager`**: Logs exceptions during cheque processing.
- **`ChequeStatusManager`**: Tracks the status of cheques.
- **`EmailNotificationService`**: Sends email notifications.

### Methods:
- **`processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)`**:
  Processes a cheque by performing the following steps:
  1. Checks and updates the cheque status using `ChequeStatusManager`.
  2. Verifies the signature using `SignatureVerificationService`. If verification fails, an exception is reported, and an email notification is sent.
  3. Detects fraudulent cheques using `FraudDetectionService`. If fraud is detected, an exception is reported, and an email notification is sent.
  4. Simulates cheque bouncing for amounts greater than 50,000 and reports an exception.
  5. Simulates delayed cheque processing for cheque numbers ending in '9' and reports an exception.

### Notes:
- The `processCheque` method includes logging and exception handling for various scenarios, such as signature mismatches, fraudulent cheques, and simulated cheque bounces or delays.
- The method uses the `Logger` class for logging and the `exceptionReportManager` for reporting issues.

### External Dependencies:
- **`CurrencyExchangeService`**: Used for currency conversion.
- **`FraudDetectionService`**: Used for detecting fraudulent cheques.
- **`ExceptionReportManager`**: Used for logging exceptions.
- **`ChequeStatusManager`**: Used for tracking cheque statuses.
- **`EmailNotificationService`**: Used for sending email notifications.

### Enum:
- **`ChequeStatus`**:
  Represents the status of a cheque. Possible values are:
  - `ISSUED`
  - `PROCESSED`
  - `CANCELED`

This code chunk provides a comprehensive framework for cheque processing, including various checks and updates to ensure the integrity and security of transactions.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_21"
confidence_score: 0.9
external_dependencies: ["exceptionReportManager", "Logger", "currencyExchangeService", "coreBankingSystemUpdater", "chequeHistoryManager", "chequeStatusManager", "emailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a larger system that processes cheques, handles currency exchange, and manages cheque statuses. It includes logic for handling delayed cheques, converting foreign currency amounts to local currency, updating the core banking system, recording cheque history, and managing cheque statuses. Additionally, it provides a method to cancel cheques and includes a nested `CurrencyExchangeService` class for handling currency exchange rates and conversions.

## Code Breakdown

### 1. Simulating Delayed Cheques
```java
if (chequeNumber.endsWith("9")) {
    exceptionReportManager.reportException(accountNumber, chequeNumber, "Delayed", "Cheque processing delayed (simulated)");
    Logger.info("Cheque processing delayed for cheque: " + chequeNumber);
    System.out.println("Cheque processing delayed (simulated).");
    // Optional: send notification for delayed cheques if desired
}
```
- **Purpose**: Simulates a delay in cheque processing if the cheque number ends with '9'.
- **Key Actions**:
  - Reports the delay using `exceptionReportManager`.
  - Logs the delay using `Logger`.
  - Prints a message to the console.

### 2. Currency Conversion for Non-Local Currencies
```java
if (!"USD".equalsIgnoreCase(currency)) {
    Map<String, Double> detailedRates = currencyExchangeService.getDetailedExchangeRates(currency);

    if (detailedRates.isEmpty()) {
        Logger.error("Exchange rate unavailable for currency: " + currency);
        System.out.println("Failed to fetch exchange rate. Cheque processing aborted.");
        return;
    }

    double buyRate = detailedRates.get("buy");
    double fee = detailedRates.get("fee");

    amountInLocalCurrency = amount * buyRate;
    double feeAmount = amount * fee;

    System.out.println("Currency: " + currency.toUpperCase());
    System.out.println("Original amount: " + amount);
    System.out.println("Exchange rate (buy): " + buyRate);
    System.out.println("Fee rate: " + fee);
    System.out.println("Fee amount: " + feeAmount);
    System.out.println("Amount in local currency (before fees): " + amountInLocalCurrency);

    amountInLocalCurrency -= feeAmount;
    System.out.println("Final amount in local currency (USD): " + amountInLocalCurrency);
} else {
    System.out.println("Processing in local currency (USD): " + amountInLocalCurrency);
}
```
- **Purpose**: Converts the cheque amount to the local currency (USD) if the cheque is in a foreign currency.
- **Key Actions**:
  - Fetches detailed exchange rates using `currencyExchangeService`.
  - Logs an error and aborts processing if exchange rates are unavailable.
  - Calculates the amount in local currency using the buy rate and deducts a fee.
  - Prints detailed information about the conversion process.

### 3. Updating the Core Banking System
```java
coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);
```
- **Purpose**: Updates the core banking system with the account number and the converted amount in local currency.
- **Dependency**: `coreBankingSystemUpdater` is responsible for this operation.

### 4. Recording Cheque History
```java
chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new java.util.Date());
```
- **Purpose**: Records the cheque details, including account number, cheque number, currency, amount, and the current date.
- **Dependency**: `chequeHistoryManager` handles the recording of cheque history.

### 5. Updating Cheque Status
```java
chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED);
Logger.info("Cheque processed successfully: " + chequeNumber);
System.out.println("Cheque processed successfully.");
```
- **Purpose**: Updates the status of the cheque to `PROCESSED` upon successful processing.
- **Key Actions**:
  - Updates the status using `chequeStatusManager`.
  - Logs the successful processing using `Logger`.
  - Prints a success message to the console.

### 6. Error Handling
```java
} catch (Exception ex) {
    Logger.error("Error processing cheque " + chequeNumber + ": " + ex.getMessage());
    exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage());
    System.out.println("An error occurred during cheque processing. Please check logs.");
    emailNotificationService.sendEmail(
        accountNumber + "@bank.com",
        "Cheque Processing Error",
        "An error occurred while processing cheque " + chequeNumber + " for account " + accountNumber + ": " + ex.getMessage()
    );
}
```
- **Purpose**: Handles exceptions that occur during cheque processing.
- **Key Actions**:
  - Logs the error using `Logger`.
  - Reports the error using `exceptionReportManager`.
  - Sends an email notification using `emailNotificationService`.

### 7. Cancelling a Cheque
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
- **Purpose**: Cancels a cheque and updates its status to `CANCELED`.
- **Key Actions**:
  - Updates the status using `chequeStatusManager`.
  - Logs the cancellation using `Logger`.
  - Prints a cancellation message to the console.
  - Handles exceptions by logging errors and printing error messages.

### 8. `CurrencyExchangeService` Class
The `CurrencyExchangeService` class provides methods for fetching and converting currency exchange rates. It includes:

#### Methods:
1. **`getExchangeRate(String currency)`**:
   - Fetches the exchange rate for a given currency.
   - Uses a cache for previously fetched rates.
   - Falls back to predefined rates if the API is unavailable.

2. **`convertCurrency(double amount, String fromCurrency, String toCurrency)`**:
   - Converts an amount from one currency to another using exchange rates.

3. **`getDetailedExchangeRates(String currency)`**:
   - Provides detailed exchange rate information, including buy/sell rates and fees.

#### Attributes:
- `exchangeRateCache`: A cache for storing exchange rates.
- `BASE_CURRENCY`: The base currency (USD).
- `CACHE_EXPIRY_MINUTES`: Cache expiry time in minutes.
- `API_KEY`: API key for fetching rates from an external source.
- `FALLBACK_RATES`: Predefined fallback rates for various currencies.

## External Dependencies
- **`exceptionReportManager`**: Handles reporting of exceptions.
- **`Logger`**: Logs messages and errors.
- **`currencyExchangeService`**: Provides currency exchange rates and conversion methods.
- **`coreBankingSystemUpdater`**: Updates the core banking system.
- **`chequeHistoryManager`**: Records cheque history.
- **`chequeStatusManager`**: Manages the status of cheques.
- **`emailNotificationService`**: Sends email notifications.
- **`CurrencyRate`**: Represents exchange rate information, including the rate and last updated timestamp.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_22"
confidence_score: 0.95
external_dependencies: ["CurrencyRate", "ChequeHistoryManager", "FraudDetection", "ChequeTransaction"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a legacy Java application that provides functionalities for currency exchange rate calculations, caching, and fraud detection. It includes methods for calculating detailed exchange rates, fetching rates from an external API, managing supported currencies, and detecting fraudulent activities related to cheques.

## Code Breakdown

### 1. **Detailed Exchange Rate Calculation**
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
This block calculates detailed exchange rates based on a given base rate. It computes the mid, buy, sell, and fee rates and stores them in a `HashMap` with descriptive keys. If the base rate is less than or equal to zero, an empty map is returned.

- **`mid`**: The base rate.
- **`buy`**: 1% lower than the base rate.
- **`sell`**: 1% higher than the base rate.
- **`fee`**: 0.5% of the base rate.

### 2. **Supported Currencies Retrieval**
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
This method returns a list of all supported currency codes. It includes the base currency (`BASE_CURRENCY`) and all keys from the `FALLBACK_RATES` map. The list is sorted alphabetically before being returned.

### 3. **Cache Validation**
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
This private method checks if the cached exchange rate for a given currency is still valid. It compares the current time with the cache expiry time, which is calculated by adding `CACHE_EXPIRY_MINUTES` to the last updated timestamp of the cached rate.

### 4. **Fetching Exchange Rate from External API**
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

        // Parse JSON response
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
This method fetches the exchange rate for a given currency from an external API. It constructs the API URL using the `BASE_CURRENCY` and `API_KEY`. If the API response is successful, it parses the JSON response to extract the exchange rate for the specified currency. If the currency is not found or an error occurs, an exception is thrown.

### 5. **Clearing the Cache**
```java
public void clearCache() {
    exchangeRateCache.clear();
    System.out.println("Exchange rate cache cleared");
}
```
This method clears the `exchangeRateCache` and logs a message indicating that the cache has been cleared.

### 6. **CurrencyExchangeServiceV2 Class**
This class is an enhanced version of the currency exchange service. It includes methods for fetching exchange rates, converting currencies, and retrieving detailed exchange rates. It also uses a fallback mechanism for exchange rates when the API is unavailable.

#### Key Features:
- **`getExchangeRateV2`**: Fetches the exchange rate for a given currency, using a cache or fallback rates if the API is unavailable.
- **`convertCurrencyV2`**: Converts an amount from one currency to another using the exchange rates.
- **`getDetailedExchangeRatesV2`**: Retrieves detailed exchange rates (mid, buy, sell, fee) for a given currency.
- **`getSupportedCurrenciesV2`**: Returns a list of supported currencies.
- **`fetchRateFromAPIV2`**: Fetches the exchange rate for a currency from an external API.
- **`clearCacheV2`**: Clears the cache of exchange rates.

### 7. **CurrencyRate Class**
This class is used to store currency rate information along with a timestamp indicating when the rate was last updated.

#### Fields:
- **`rate`**: The exchange rate.
- **`lastUpdated`**: The timestamp of the last update.

#### Methods:
- **`getRate`**: Returns the exchange rate.
- **`getLastUpdated`**: Returns the last updated timestamp.

### 8. **FraudDetectionService Class**
This class implements fraud detection mechanisms for cheque transactions. It uses a `ChequeHistoryManager` to manage cheque history and detect fraudulent activities based on various thresholds.

#### Key Features:
- **Fraud Detection Thresholds**:
  - Velocity Check: Monitors the number of transactions within a specific period.
  - Pattern Similarity: Detects patterns with a similarity threshold.
  - Unusual Frequency: Flags transactions with unusually high frequency.
- **Alert Levels**: Defines different levels of fraud alerts (LOW, MEDIUM, HIGH, CRITICAL).

#### Dependencies:
- **`FraudDetection`**: A class or module for detecting fraud.
- **`ChequeHistoryManager`**: Manages the history of cheque transactions.
- **`ChequeTransaction`**: Represents individual cheque transactions.

## External Dependencies
- **`CurrencyRate`**: Used for caching exchange rates with timestamps.
- **`ChequeHistoryManager`**: Manages cheque transaction history.
- **`FraudDetection`**: Provides fraud detection capabilities.
- **`ChequeTransaction`**: Represents cheque transactions for fraud detection.

## Notes
- The code contains hardcoded API keys and fallback rates, which should be replaced with secure and dynamic configurations in a production environment.
- The JSON parsing in `fetchRateFromAPIV2` is inefficient and should be replaced with a robust library or method for better performance and maintainability.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_23"
confidence_score: 0.9
external_dependencies: ["FraudDetection", "ChequeHistoryManager"]
---

# Fraud Detection Service Documentation

## Overview
This chunk of code implements a fraud detection service for cheque transactions. It defines thresholds for various fraud detection mechanisms, provides methods to evaluate transactions for potential fraud, and determines the severity of detected fraud. The service also logs the results of fraud checks and categorizes the fraud into different alert levels.

## Key Components

### Fraud Detection Thresholds
The following constants define thresholds for detecting fraudulent activities:
- **VELOCITY_CHECK_DAYS**: Number of days to consider for velocity checks (default: 7 days).
- **VELOCITY_THRESHOLD**: Maximum allowed transactions within the velocity check period (default: 5 transactions).
- **PATTERN_THRESHOLD**: Similarity threshold for detecting pattern-based fraud (default: 95%).
- **SIMILAR_AMOUNT_THRESHOLD**: Similarity threshold for recent transaction amounts (default: 90%).
- **UNUSUAL_FREQUENCY_THRESHOLD**: Multiplier for detecting unusual frequency of transactions (default: 3x normal frequency).

### Fraud Alert Levels
An enumeration `AlertLevel` is defined to categorize the severity of detected fraud:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

### Constructor
```java
public FraudDetectionService()
```
Initializes the `FraudDetection` instance and a `HashMap` to store recent transactions.

### Methods

#### `setHistoryManager(ChequeHistoryManager historyManager)`
Sets the `ChequeHistoryManager` instance for accessing historical cheque data.

#### `isFraudulentCheque(String accountId, String chequeNumber, double amount)`
Evaluates a cheque transaction for potential fraud by performing various checks:
- Duplicate cheque detection.
- Abnormal amount detection.
- Suspicious activity detection.
- Velocity-based fraud detection.
- Pattern-based fraud detection.
- Historical duplicate detection (if `ChequeHistoryManager` is set).
- Unusual frequency detection (if `ChequeHistoryManager` is set).
- Similar recent transaction detection (if `ChequeHistoryManager` is set).

Returns `true` if any of the checks indicate fraud, otherwise returns `false`.

#### `checkDuplicateCheque(String accountId, String chequeNumber)`
Checks if the cheque is a duplicate using the `FraudDetection` instance.

#### `checkAbnormalAmount(double amount)`
Checks if the cheque amount is abnormal using the `FraudDetection` instance.

#### `checkSuspiciousActivity(String accountId, double amount)`
Checks for suspicious activity using the `FraudDetection` instance.

#### `checkVelocityFraud(String accountId, double amount)`
Detects velocity-based fraud by analyzing the number of transactions within the last `VELOCITY_CHECK_DAYS` days. If the count exceeds `VELOCITY_THRESHOLD`, it flags the transaction as fraudulent.

#### `checkPatternFraud(String accountId, double amount)`
Analyzes recent transactions for pattern-based fraud by comparing the similarity of transaction amounts. Flags fraud if at least three transactions have a similarity above `PATTERN_THRESHOLD`.

#### `checkHistoricalDuplicate(String accountId, String chequeNumber)`
Checks if the cheque number exists in the historical data provided by the `ChequeHistoryManager`.

#### `checkUnusualFrequency(String accountId)`
Detects unusual frequency of transactions by comparing recent transaction counts to the average monthly frequency. Flags fraud if the recent count exceeds the average by `UNUSUAL_FREQUENCY_THRESHOLD`.

#### `checkSimilarToRecent(String accountId, double amount)`
Checks if the transaction amount is similar to recent transactions using the `ChequeHistoryManager`.

#### `determineAlertLevel(...)`
Determines the fraud alert level based on the results of various checks. The alert levels are categorized as `LOW`, `MEDIUM`, `HIGH`, or `CRITICAL` based on the severity of detected fraud.

#### `logFraudChecks(...)`
Logs the results of all fraud checks and provides a summary of whether fraud was detected.

#### `formatCheckResult(boolean failed)`
Formats the result of a fraud check for logging purposes.

### Inner Class: `ChequeTransaction`
Represents a cheque transaction with the following fields:
- `amount`: The transaction amount.
- `date`: The transaction date.

Provides getter methods for both fields.

## External Dependencies
- **FraudDetection**: Used for performing core fraud detection checks (e.g., duplicate cheque, abnormal amount, suspicious activity).
- **ChequeHistoryManager**: Provides historical data for advanced fraud checks (e.g., historical duplicates, unusual frequency, similar recent transactions).

## Usage
This service can be used in financial systems to detect and categorize fraudulent cheque transactions. It integrates with external systems for historical data and provides detailed logging for audit purposes.

=== NEXT CHUNK ===

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

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_25"
confidence_score: 0.9
external_dependencies: ["java.time.LocalDate", "java.util.HashMap", "java.util.List", "java.util.ArrayList", "java.util.Map"]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview
This code chunk is part of a fraud detection system for cheque transactions. It performs various checks to identify potential fraudulent activities, such as duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, and pattern analysis. Additionally, if a `ChequeHistoryManager` is available, it performs advanced checks like historical duplicate detection, unusual frequency checks, and similarity to recent transactions.

The code also includes a helper method for formatting check results and a nested class `ChequeTransaction` to represent individual cheque transactions. Furthermore, it defines a `FraudDetectionServiceV2` class that encapsulates the logic for detecting fraudulent cheque activities.

---

## Code Details

### Fraud Detection Checks
The code performs the following checks:

1. **Basic Checks:**
   - **Duplicate Check:** Verifies if the cheque is a duplicate.
   - **Abnormal Amount Check:** Checks if the cheque amount is abnormal.
   - **Suspicious Activity Check:** Identifies suspicious activities related to the cheque.
   - **Velocity Check:** Determines if there are too many transactions within a short period.
   - **Pattern Analysis:** Checks for patterns in transaction amounts that may indicate fraud.

2. **Advanced Checks (if `historyManager` is available):**
   - **Historical Duplicate Check:** Verifies if the cheque number has been used in the past.
   - **Unusual Frequency Check:** Checks if the frequency of transactions is unusually high compared to historical data.
   - **Similar Recent Amount Check:** Determines if the cheque amount is similar to recent transactions.

### Fraud Summary
After performing the checks, the code determines if any fraud has been detected. If any of the checks fail, a fraud alert is raised; otherwise, it confirms that no fraud has been detected.

### Helper Method: `formatCheckResult`
This private method formats the result of a fraud check for display purposes.

#### Method Signature
```java
private String formatCheckResult(boolean failed)
```

#### Parameters
- `failed` (boolean): Indicates whether the check failed.

#### Returns
- A string indicating the result of the check:
  - "FAILED ⚠️" if the check failed.
  - "Passed ✓" if the check passed.

### Nested Class: `ChequeTransaction`
This private static class represents a cheque transaction with an amount and a date.

#### Constructor
```java
public ChequeTransaction(double amount, java.time.LocalDate date)
```
- `amount` (double): The amount of the cheque.
- `date` (LocalDate): The date of the cheque transaction.

#### Methods
- `getAmount()`: Returns the amount of the cheque.
- `getDate()`: Returns the date of the cheque transaction.

### Class: `FraudDetectionServiceV2`
This class implements various fraud detection mechanisms and integrates with a `ChequeHistoryManager` for advanced checks.

#### Fields
- `fraudDetection`: An instance of the `FraudDetection` class used for performing basic fraud checks.
- `historyManager`: An optional `ChequeHistoryManager` instance for advanced checks.
- Various `Map` objects to store transaction data for different types of fraud checks.
- `fraudLogs`: A list to store logs of detected frauds.
- `totalFraudChecks`: A counter for the total number of fraud checks performed.

#### Fraud Detection Thresholds
- `VELOCITY_CHECK_DAYS`: The number of days to consider for velocity checks (default: 7 days).
- `VELOCITY_THRESHOLD`: The maximum number of transactions allowed within the velocity check period (default: 5).
- `PATTERN_THRESHOLD`: The similarity threshold for pattern analysis (default: 95%).
- `SIMILAR_AMOUNT_THRESHOLD`: The similarity threshold for recent amounts (default: 90%).
- `UNUSUAL_FREQUENCY_THRESHOLD`: The multiplier for determining unusual frequency (default: 3x).

#### Fraud Alert Levels
The `AlertLevel` enum defines the severity of detected fraud:
- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

#### Constructor
The class provides two constructors:
1. Default constructor: Initializes all fields with default values.
2. Parameterized constructor: Accepts a `ChequeHistoryManager` instance for advanced checks.

#### Methods
- `isFraudulentCheque(String accountId, String chequeNumber, double amount)`: Main method to determine if a cheque is fraudulent. It performs all basic and advanced checks and logs the results.
- `checkDuplicateCheque(String accountId, String chequeNumber)`: Checks for duplicate cheques.
- `checkAbnormalAmount(double amount)`: Checks if the cheque amount is abnormal.
- `checkSuspiciousActivity(String accountId, double amount)`: Identifies suspicious activities.
- `checkVelocityFraud(String accountId, double amount)`: Checks for a high frequency of transactions within a short period.
- `checkPatternFraud(String accountId, double amount)`: Analyzes patterns in transaction amounts.
- `checkHistoricalDuplicate(String accountId, String chequeNumber)`: Checks for historical duplicates using `ChequeHistoryManager`.
- `checkUnusualFrequency(String accountId)`: Checks for unusual transaction frequency using `ChequeHistoryManager`.
- `checkSimilarToRecent(String accountId, double amount)`: Checks if the cheque amount is similar to recent transactions.

---

## External Dependencies
- `java.time.LocalDate`: Used for handling dates in cheque transactions.
- `java.util.HashMap`, `java.util.List`, `java.util.ArrayList`, `java.util.Map`: Used for storing and managing transaction data.

---

## Notes
- The `FraudDetection` and `ChequeHistoryManager` classes are external dependencies and are not defined in this code chunk. Their methods are used for performing specific fraud checks.
- The `formatCheckResult` method is used extensively to format the results of the fraud checks for display purposes.
- The `ChequeTransaction` class is a utility class for representing individual cheque transactions with an amount and a date.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_26"
confidence_score: 0.95
external_dependencies: ["ChequeHistoryManager", "AlertLevel"]
---

# Documentation for Code Chunk in `DemoApplication.java`

## Overview
This code chunk is part of a fraud detection system implemented in Java. It contains methods for detecting fraudulent activities related to cheque transactions, determining alert levels based on the results of these checks, and logging the outcomes of the fraud checks. Additionally, it defines a nested static class `ChequeTransaction` to represent individual cheque transactions.

The code relies on a `ChequeHistoryManager` class (mock implementation found in the same file) to retrieve historical cheque data and perform advanced fraud checks. It also uses an `AlertLevel` enum (not defined in this chunk) to categorize the severity of detected fraud.

## Methods

### `checkHistoricalDuplicate`
```java
private boolean checkHistoricalDuplicate(String accountId, String chequeNumber)
```
**Purpose**: Checks if a given cheque number has been used before for the specified account.

- **Parameters**:
  - `accountId` (String): The account identifier.
  - `chequeNumber` (String): The cheque number to check.
- **Returns**: `true` if the cheque number exists in the account's historical records, otherwise `false`.
- **Dependencies**: Uses `historyManager.getChequeNumbers(accountId)` to fetch historical cheque numbers.

### `checkUnusualFrequency`
```java
private boolean checkUnusualFrequency(String accountId)
```
**Purpose**: Determines if the frequency of recent cheque transactions is unusually high compared to the average monthly frequency.

- **Parameters**:
  - `accountId` (String): The account identifier.
- **Returns**: `true` if the recent cheque frequency exceeds a predefined threshold, otherwise `false`.
- **Dependencies**: Uses `historyManager.getTotalChequeCount(accountId)` and `historyManager.getRecentChequeCount(accountId)` to fetch cheque counts.

### `checkSimilarToRecent`
```java
private boolean checkSimilarToRecent(String accountId, double amount)
```
**Purpose**: Checks if the given cheque amount is similar to recent cheque amounts for the specified account.

- **Parameters**:
  - `accountId` (String): The account identifier.
  - `amount` (double): The cheque amount to check.
- **Returns**: `true` if a similar recent cheque exists, otherwise `false`.
- **Dependencies**: Uses `historyManager.hasSimilarRecentCheque(accountId, amount, SIMILAR_AMOUNT_THRESHOLD)`.

### `determineAlertLevel`
```java
private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal,
                                       boolean isSuspicious, boolean isVelocityFraud,
                                       boolean isPatternFraud, boolean isHistoricalDuplicate,
                                       boolean isUnusualFrequency, boolean isSimilarToRecent)
```
**Purpose**: Determines the alert level based on the results of various fraud checks.

- **Parameters**:
  - `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
  - `isAbnormal` (boolean): Indicates if the cheque amount is abnormal.
  - `isSuspicious` (boolean): Indicates if the activity is suspicious.
  - `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
  - `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
  - `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
  - `isUnusualFrequency` (boolean): Indicates if the cheque frequency is unusual.
  - `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent cheques.
- **Returns**: An `AlertLevel` value representing the severity of the detected fraud.
- **Logic**: Assigns a score to each fraud type and calculates a total fraud score. The alert level is determined based on the total score and specific conditions.

### `logFraudChecks`
```java
private void logFraudChecks(String accountId, String chequeNumber, double amount,
                            boolean isDuplicate, boolean isAbnormal, boolean isSuspicious,
                            boolean isVelocityFraud, boolean isPatternFraud,
                            boolean isHistoricalDuplicate, boolean isUnusualFrequency,
                            boolean isSimilarToRecent)
```
**Purpose**: Logs the results of various fraud checks for a specific cheque transaction.

- **Parameters**:
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
- **Output**: Prints a detailed fraud check report to the console.
- **Dependencies**: Uses `formatCheckResult(boolean)` to format the results of individual checks.

### `formatCheckResult`
```java
private String formatCheckResult(boolean failed)
```
**Purpose**: Formats the result of a fraud check for logging purposes.

- **Parameters**:
  - `failed` (boolean): Indicates whether the check failed.
- **Returns**: A string indicating the result of the check ("FAILED ⚠️" or "Passed ✓").

### `ChequeTransaction` (Nested Static Class)
**Purpose**: Represents a cheque transaction with an amount and a date.

- **Fields**:
  - `amount` (double): The amount of the cheque.
  - `date` (LocalDate): The date of the cheque transaction.
- **Constructor**:
  - `ChequeTransaction(double amount, LocalDate date)`: Initializes the `amount` and `date` fields.
- **Methods**:
  - `getAmount()`: Returns the amount of the cheque.
  - `getDate()`: Returns the date of the cheque transaction.

## External Dependencies

### `ChequeHistoryManager`
A mock implementation of a class that manages historical cheque data. It provides methods to record and retrieve cheque information for specific accounts.

### `AlertLevel`
An enumeration (not defined in this chunk) used to represent the severity of detected fraud.

## Notes
- The `historyManager` object is assumed to be an instance of `ChequeHistoryManager`.
- Constants such as `UNUSUAL_FREQUENCY_THRESHOLD` and `SIMILAR_AMOUNT_THRESHOLD` are used but not defined in this chunk. They are likely defined elsewhere in the codebase.
- The `logFraudChecks` method uses `System.out.println` for logging, which may not be suitable for production environments. Consider using a logging framework for better control and configurability.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_27"
confidence_score: 0.95
external_dependencies: ["BatchCheque"]
---

# Documentation for `AdminService` Class and Related Methods

## Overview
The `AdminService` class is a static inner class within the `DemoApplication` file. It is responsible for managing master data, batch operations, and stuck transactions in the context of a cheque processing system. The class provides methods to manage IFSC codes, bank codes, cheque batches, and stuck transactions.

The class also interacts with the `BatchCheque` class, which represents individual cheques with attributes such as account number, cheque number, currency, amount, and signature.

---

## Class: `AdminService`

### Fields

1. **`ifscToBankCode`**
   - Type: `Map<String, String>`
   - Description: Maps IFSC codes to their corresponding bank codes.

2. **`bankCodeToName`**
   - Type: `Map<String, String>`
   - Description: Maps bank codes to their corresponding bank names.

3. **`batches`**
   - Type: `Map<String, List<BatchCheque>>`
   - Description: Stores batches of cheques, where each batch is identified by a unique batch ID and contains a list of `BatchCheque` objects.

4. **`stuckTransactions`**
   - Type: `Set<String>`
   - Description: Stores a set of cheque numbers that are marked as stuck transactions.

---

### Methods

#### Master Data Management

1. **`addOrUpdateIFSC(String ifsc, String bankCode)`**
   - **Description**: Adds or updates the mapping between an IFSC code and a bank code.
   - **Parameters**:
     - `ifsc`: The IFSC code to be added or updated.
     - `bankCode`: The bank code to be associated with the given IFSC code.
   - **Output**: Prints a confirmation message indicating the mapping.

2. **`addOrUpdateBankCode(String bankCode, String bankName)`**
   - **Description**: Adds or updates the mapping between a bank code and a bank name.
   - **Parameters**:
     - `bankCode`: The bank code to be added or updated.
     - `bankName`: The name of the bank to be associated with the given bank code.
   - **Output**: Prints a confirmation message indicating the mapping.

3. **`displayIFSCs()`**
   - **Description**: Displays all IFSC-to-bank code mappings.
   - **Output**: Prints the mappings to the console. If no mappings exist, a message indicating this is displayed.

4. **`displayBankCodes()`**
   - **Description**: Displays all bank code-to-name mappings.
   - **Output**: Prints the mappings to the console. If no mappings exist, a message indicating this is displayed.

#### Batch Management

1. **`createBatch(String batchId, List<BatchCheque> cheques)`**
   - **Description**: Creates a new batch of cheques and associates it with a unique batch ID.
   - **Parameters**:
     - `batchId`: The unique identifier for the batch.
     - `cheques`: A list of `BatchCheque` objects to be included in the batch.
   - **Output**: Prints a confirmation message indicating the batch creation and the number of cheques in the batch.

2. **`displayBatches()`**
   - **Description**: Displays a summary of all batches, including their IDs and the number of cheques in each batch.
   - **Output**: Prints the batch summaries to the console. If no batches exist, a message indicating this is displayed.

3. **`displayBatchDetails(String batchId)`**
   - **Description**: Displays detailed information about a specific batch, including the account number, cheque number, amount, and currency of each cheque in the batch.
   - **Parameters**:
     - `batchId`: The unique identifier of the batch to be displayed.
   - **Output**: Prints the details of the specified batch to the console. If the batch does not exist, a message indicating this is displayed.

#### Stuck Transaction Management

1. **`markTransactionStuck(String chequeNumber)`**
   - **Description**: Marks a cheque as a stuck transaction by adding its cheque number to the `stuckTransactions` set.
   - **Parameters**:
     - `chequeNumber`: The cheque number to be marked as stuck.
   - **Output**: Prints a confirmation message indicating that the cheque has been marked as stuck.

2. **`resetStuckTransaction(String chequeNumber)`**
   - **Description**: Removes a cheque from the `stuckTransactions` set, effectively resetting its stuck status.
   - **Parameters**:
     - `chequeNumber`: The cheque number to be removed from the stuck transactions list.
   - **Output**: Prints a confirmation message indicating whether the cheque was successfully removed or if it was not marked as stuck.

3. **`displayStuckTransactions()`**
   - **Description**: Displays all cheque numbers that are currently marked as stuck transactions.
   - **Output**: Prints the list of stuck cheque numbers to the console. If no stuck transactions exist, a message indicating this is displayed.

---

## External Dependencies

### Class: `BatchCheque`
The `AdminService` class relies on the `BatchCheque` class, which represents individual cheques. The `BatchCheque` class has the following fields:

- `String accountNumber`: The account number associated with the cheque.
- `String chequeNumber`: The unique identifier for the cheque.
- `String currency`: The currency in which the cheque is issued.
- `double amount`: The monetary value of the cheque.
- `String signature`: The signature associated with the cheque.

The `BatchCheque` class also includes a constructor to initialize these fields.

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
This code defines two static classes, `User` and `UserService`, which are part of a user management and authentication system. The `User` class represents individual users with attributes such as username, password, and role. The `UserService` class provides functionality to manage users, including registering new users and authenticating existing ones.

## `User` Class
The `User` class is a simple data model that encapsulates the following attributes:

### Fields
- `username` (String): The username of the user.
- `password` (String): The password of the user. **Note:** In a real-world application, passwords should be hashed and not stored in plain text.
- `role` (String): The role of the user, such as `EMPLOYEE` or `ACCOUNT_HOLDER`.

### Constructor
```java
public User(String username, String password, String role)
```
Initializes a new `User` object with the provided `username`, `password`, and `role`.

### Methods
- `getUsername()`: Returns the username of the user.
- `getPassword()`: Returns the password of the user.
- `getRole()`: Returns the role of the user.

## `UserService` Class
The `UserService` class provides methods to manage users and handle authentication.

### Fields
- `users` (Map<String, User>): A map that stores `User` objects, with the username as the key.

### Constructor
```java
public UserService()
```
Initializes the `UserService` and populates it with some sample users for demonstration purposes:
- `employee1` with password `password123` and role `EMPLOYEE`
- `account1001` with password `chequeuser` and role `ACCOUNT_HOLDER`
- `account1002` with password `securepass` and role `ACCOUNT_HOLDER`

### Methods

#### `registerUser`
```java
public void registerUser(String username, String password, String role)
```
Registers a new user by adding them to the `users` map.

**Parameters:**
- `username` (String): The username of the new user.
- `password` (String): The password of the new user.
- `role` (String): The role of the new user.

**Behavior:**
- Creates a new `User` object and stores it in the `users` map.
- Prints a message indicating the user has been registered.

#### `authenticate`
```java
public User authenticate(String username, String password)
```
Authenticates a user based on their username and password.

**Parameters:**
- `username` (String): The username of the user attempting to authenticate.
- `password` (String): The password of the user attempting to authenticate.

**Returns:**
- The authenticated `User` object if the username and password match.
- `null` if authentication fails.

**Behavior:**
- Retrieves the `User` object from the `users` map using the provided username.
- Compares the provided password with the stored password.
- Prints a message indicating whether authentication was successful or failed.

## Notes
- The `password` field in the `User` class is stored in plain text, which is a security risk. In a production environment, passwords should be hashed and salted.
- The `UserService` class is initialized with hardcoded sample users, which is suitable for demonstration purposes but not for production use.

## External Dependencies
- `java.util.Map`: Used to store the mapping between usernames and `User` objects.
- `java.util.HashMap`: Implementation of the `Map` interface used to store user data.

=== NEXT CHUNK ===

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
The `CreateApplication` class serves as the entry point for a Cheque Processing System with enhanced fraud detection capabilities. It initializes various services, handles user authentication, and provides a menu-driven interface for processing cheques, viewing cheque history, and performing other related operations.

## Class Structure
The class contains the following key components:

### Main Method
The `main` method is the starting point of the application. It performs the following tasks:

1. **Initialization**:
   - Prints a welcome message.
   - Initializes various services required for the application:
     - `CurrencyExchangeService`: Handles currency exchange operations.
     - `SignatureVerificationService`: Verifies signatures on cheques.
     - `CoreBankingSystemUpdater`: Updates the core banking system with transaction details.
     - `UserService`: Manages user authentication and registration.
     - `ChequeHistoryManager`: Maintains and displays cheque transaction history.
     - `FraudDetectionService`: Detects fraudulent activities in cheque transactions.
   - Sets up dependencies, such as linking the `FraudDetectionService` with the `ChequeHistoryManager`.

2. **User Authentication**:
   - Calls the `performLogin` method to authenticate the user.
   - Exits the application if login fails after the maximum allowed attempts.

3. **Menu-Driven Interface**:
   - Displays a menu with options for various operations, including:
     - Processing a single cheque.
     - Processing multiple cheques in a batch.
     - Viewing cheque history.
     - Accessing currency exchange information.
     - Generating cheque reports.
     - Exiting the application.
   - Handles user input and invokes the appropriate methods based on the selected option.

### Helper Methods

#### `performLogin`
Handles the user login process.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `UserService userService`: Used to authenticate the user.
- **Returns**: An authenticated `User` object if login is successful, or `null` if login fails after the maximum allowed attempts.
- **Logic**:
  - Prompts the user for a username and password.
  - Validates the credentials using the `UserService`.
  - Allows up to three login attempts before exiting.

#### `processChequeBatch`
Handles the processing of multiple cheques in a batch.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `ChequeProcessor chequeProcessor`: Used to process the cheques.
- **Logic**:
  - Prompts the user for the number of cheques in the batch.
  - Collects details for each cheque (account number, cheque number, currency, amount, and signature).
  - Adds the cheque details to a list and processes them using the `ChequeProcessor`.

#### `displayCurrencyExchangeMenu`
Displays the currency exchange menu and handles user interactions.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `CurrencyExchangeService currencyExchangeService`: Used to fetch and display currency exchange information.

#### `handleReportGeneration`
Handles the generation of cheque reports.
- **Parameters**:
  - `Scanner scanner`: Used to read user input.
  - `ChequeHistoryManager chequeHistoryManager`: Used to fetch and display cheque history for report generation.

## External Dependencies
The `CreateApplication` class relies on the following external classes:

1. **`CurrencyExchangeService`**: Manages currency exchange operations.
2. **`SignatureVerificationService`**: Verifies the authenticity of cheque signatures.
3. **`CoreBankingSystemUpdater`**: Updates the core banking system with transaction details.
4. **`UserService`**: Handles user authentication and registration.
5. **`ChequeHistoryManager`**: Maintains and displays cheque transaction history.
6. **`FraudDetectionService`**: Detects fraudulent activities in cheque transactions.
7. **`ChequeProcessor`**: Processes cheques, including signature verification, fraud detection, and core banking updates.
8. **`BatchCheque`**: Represents a cheque in a batch processing operation.

## Key Features
- **User Authentication**: Ensures only authorized users can access the system.
- **Cheque Processing**: Supports both single and batch cheque processing.
- **Fraud Detection**: Integrates fraud detection mechanisms to ensure secure transactions.
- **Cheque History Management**: Allows users to view the history of processed cheques.
- **Currency Exchange**: Provides information on currency exchange rates and conversions.
- **Report Generation**: Enables users to generate reports based on cheque history.

## Notes
- The application uses a `Scanner` for user input, which may not be suitable for production environments due to potential security risks (e.g., reading passwords in plain text).
- The services used in this application appear to be mock implementations, as indicated by the search results.
- The `BatchCheque` class is used to represent individual cheques in batch processing but its implementation details were not fully provided in the code chunk.

=== NEXT CHUNK ===

---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_31"
confidence_score: 0.9
external_dependencies: ["BatchCheque", "ChequeProcessor", "CurrencyExchangeService", "ChequeHistoryManager"]
---

# Documentation for Code Chunk

This code chunk is part of a larger Java application and contains three main functionalities:

1. **Batch Cheque Processing**
2. **Currency Exchange Menu**
3. **Cheque Report Generation**

## 1. Batch Cheque Processing

This section of the code collects details for a batch of cheques from the user and processes them using a `ChequeProcessor` instance.

### Key Steps:
- A list `chequesToProcess` is initialized to store `BatchCheque` objects.
- A loop iterates `batchSize` times to collect cheque details (account number, cheque number, currency, amount, and signature) from the user via a `Scanner`.
- Each cheque is added to the `chequesToProcess` list as a `BatchCheque` object.
- After collecting all cheques, the `ChequeProcessor` processes each cheque in the list by calling its `processCheque` method.

### External Dependencies:
- **`BatchCheque`**: Represents a cheque with attributes such as account number, cheque number, currency, amount, and signature.
- **`ChequeProcessor`**: A service responsible for processing cheques. It includes functionalities like signature verification, fraud detection, currency conversion, and updating the core banking system.

## 2. Currency Exchange Menu

This section provides a menu-driven interface for users to interact with a `CurrencyExchangeService` to perform various currency-related operations.

### Menu Options:
1. **View Supported Currencies**: Displays a list of currencies supported by the service.
2. **Get Exchange Rate**: Allows the user to input a currency code and retrieves the exchange rate for that currency.
3. **Get Detailed Exchange Rate Information**: Provides detailed exchange rate information (mid, buy, sell, and fee rates) for a specific currency.
4. **Convert Currency**: Converts an amount from one currency to another using the `convertCurrency` method of `CurrencyExchangeService`.
5. **Return to Main Menu**: Exits the currency exchange menu.

### External Dependencies:
- **`CurrencyExchangeService`**: Provides methods to get supported currencies, fetch exchange rates, and perform currency conversions.

## 3. Cheque Report Generation

This section handles the generation of cheque reports for different time periods or custom date ranges.

### Key Steps:
- Displays a menu with options for generating daily, weekly, monthly, or custom date range reports.
- Based on the user's choice, determines the start and end dates for the report.
- Fetches cheque records for the specified date range using the `ChequeHistoryManager`.
- If records are found, generates a CSV report and writes it to a file.

### External Dependencies:
- **`ChequeHistoryManager`**: Manages cheque history and provides methods to fetch records within a specific date range and generate CSV reports.

### Error Handling:
- Ensures proper handling of invalid date formats and cases where the start date is after the end date.
- Handles exceptions during file writing and informs the user of any errors.

## Additional Notes:
- The `SignatureVerificationService` class is partially included in the chunk and appears to provide a mechanism for verifying cheque signatures.
- The `Scanner` object is used extensively for user input throughout the code.

This chunk demonstrates a combination of user interaction, data processing, and integration with external services to achieve its functionality.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_32"
confidence_score: 0.9
external_dependencies: ["CurrencyRate", "CurrencyExchangeService", "CoreBankingSystemUpdater", "ChequeHistoryManager", "FraudDetectionService"]
---

# Documentation for `SignatureVerificationService`, `ChequeProcessor`, and `CurrencyExchangeService`

## Overview
This code chunk contains three main components:
1. **`SignatureVerificationService`**: A service for verifying and managing account signatures.
2. **`ChequeProcessor`**: A module for processing cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.
3. **`CurrencyExchangeService`**: A service for fetching and managing currency exchange rates, including fallback mechanisms and caching.

---

## `SignatureVerificationService`

### Purpose
The `SignatureVerificationService` is responsible for verifying account signatures and managing updates to the stored signatures. It uses a `HashMap` to store account numbers and their associated signatures.

### Fields
- `Map<String, String> accountSignatures`: Stores account numbers and their corresponding signatures.

### Methods

#### Constructor
```java
public SignatureVerificationService()
```
Initializes the service with some sample account signatures for demonstration purposes.

#### `verifySignature`
```java
public boolean verifySignature(String accountNumber, String signature)
```
Verifies if the provided signature matches the one on file for the given account number.
- **Parameters**:
  - `accountNumber`: The account number.
  - `signature`: The signature to verify.
- **Returns**: `true` if the signature is valid, `false` otherwise.
- **Behavior**:
  - If no signature is on file, it accepts the provided signature and stores it.
  - Compares the provided signature with the stored signature.

#### `updateSignature`
```java
public void updateSignature(String accountNumber, String newSignature)
```
Updates the stored signature for a given account number.
- **Parameters**:
  - `accountNumber`: The account number.
  - `newSignature`: The new signature to store.

---

## `ChequeProcessor`

### Purpose
The `ChequeProcessor` handles the end-to-end processing of cheques, including signature verification, fraud detection, currency conversion, and updating the core banking system.

### Fields
- `CurrencyExchangeService currencyExchangeService`: Service for currency exchange operations.
- `SignatureVerificationService signatureVerificationService`: Service for signature verification.
- `CoreBankingSystemUpdater coreBankingSystemUpdater`: Service for updating the core banking system.
- `ChequeHistoryManager chequeHistoryManager`: Service for recording cheque history.
- `FraudDetectionService fraudDetectionService`: Service for detecting fraudulent cheques.

### Methods

#### Constructor
```java
public ChequeProcessor(CurrencyExchangeService currencyExchangeService,
                       SignatureVerificationService signatureVerificationService,
                       CoreBankingSystemUpdater coreBankingSystemUpdater,
                       ChequeHistoryManager chequeHistoryManager,
                       FraudDetectionService fraudDetectionService)
```
Initializes the `ChequeProcessor` with the required services.

#### `processCheque`
```java
public void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature)
```
Processes a cheque by performing the following steps:
1. Verifies the signature using `SignatureVerificationService`.
2. Detects fraud using `FraudDetectionService`.
3. Converts the amount to local currency if necessary using `CurrencyExchangeService`.
4. Updates the core banking system using `CoreBankingSystemUpdater`.
5. Records the cheque history using `ChequeHistoryManager`.

- **Parameters**:
  - `accountNumber`: The account number.
  - `chequeNumber`: The cheque number.
  - `currency`: The currency of the cheque.
  - `amount`: The amount on the cheque.
  - `signature`: The signature on the cheque.

---

## `CurrencyExchangeService`

### Purpose
The `CurrencyExchangeService` provides functionality for fetching and managing currency exchange rates. It includes mechanisms for caching rates, using fallback rates, and fetching rates from an external API.

### Fields
- `Map<String, CurrencyRate> exchangeRateCache`: Caches exchange rates for currencies.
- `static final String BASE_CURRENCY`: The base currency (USD).
- `static final long CACHE_EXPIRY_MINUTES`: Cache expiry time in minutes.
- `static final String API_KEY`: API key for fetching rates from an external source.
- `static final Map<String, Double> FALLBACK_RATES`: Fallback exchange rates for various currencies.

### Methods

#### `getExchangeRate`
```java
public double getExchangeRate(String currency)
```
Fetches the exchange rate for a specific currency.
- **Parameters**:
  - `currency`: The currency code (e.g., EUR, GBP).
- **Returns**: The exchange rate relative to the base currency (USD).
- **Behavior**:
  - Checks the cache for a valid rate.
  - Attempts to fetch the rate from an external API.
  - Falls back to predefined rates if the API fetch fails.

---

## External Dependencies
- `CurrencyRate`: Represents a currency rate with its value and last updated timestamp.
- `CurrencyExchangeService`: Provides detailed exchange rate information.
- `CoreBankingSystemUpdater`: Updates the core banking system with transaction details.
- `ChequeHistoryManager`: Records cheque processing history.
- `FraudDetectionService`: Detects fraudulent cheques.

---

This documentation provides a detailed overview of the services and their methods, ensuring clarity for developers working with this code.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_33"
confidence_score: 0.95
external_dependencies: ["org.json.simple.parser.JSONParser", "org.json.simple.JSONObject", "ChequeHistoryManager", "FraudDetection", "ChequeTransaction"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a larger application that provides currency exchange services and fraud detection for cheque transactions. It includes methods for handling fallback exchange rates, currency conversion, detailed exchange rate calculations, and fraud detection mechanisms. Additionally, it defines helper classes and services such as `CurrencyRate` and `FraudDetectionService`.

## Key Components and Methods

### 1. **Fallback Exchange Rates**
The code uses a predefined map `FALLBACK_RATES` to store exchange rates for various currencies in case the external API fetch fails. If a fallback rate is available for a given currency, it is cached and returned.

#### Example:
```java
Double fallbackRate = FALLBACK_RATES.get(currencyCode);
if (fallbackRate != null) {
    System.out.println("Using fallback rate for " + currencyCode + ": " + fallbackRate);
    exchangeRateCache.put(currencyCode, new CurrencyRate(fallbackRate, java.time.LocalDateTime.now()));
    return fallbackRate;
}
```

### 2. **Currency Conversion**
The `convertCurrency` method converts an amount from one currency to another using exchange rates. It first retrieves the exchange rates for the source and target currencies, validates them, and performs the conversion.

#### Method Signature:
```java
public double convertCurrency(double amount, String fromCurrency, String toCurrency)
```

#### Key Steps:
- Fetch exchange rates for both currencies.
- Convert the amount to the base currency and then to the target currency.
- Log the conversion details.

### 3. **Detailed Exchange Rate Information**
The `getDetailedExchangeRates` method provides additional details about exchange rates, including buy/sell rates and fees.

#### Method Signature:
```java
public Map<String, Double> getDetailedExchangeRates(String currency)
```

#### Key Steps:
- Calculate buy and sell rates as slight variations of the base rate.
- Calculate a fee as a percentage of the base rate.
- Return a map containing the detailed rate information.

### 4. **Supported Currencies**
The `getSupportedCurrencies` method returns a sorted list of all supported currency codes, including the base currency and those in the fallback rates.

#### Method Signature:
```java
public List<String> getSupportedCurrencies()
```

### 5. **Cache Validation**
The `isCacheValid` method checks if a cached exchange rate is still valid based on a predefined expiry time (`CACHE_EXPIRY_MINUTES`).

#### Method Signature:
```java
private boolean isCacheValid(String currency)
```

### 6. **Fetch Rate from API**
The `fetchRateFromAPI` method retrieves exchange rates from an external API (e.g., Open Exchange Rates API). It handles HTTP requests, parses JSON responses, and extracts the required exchange rate.

#### Method Signature:
```java
private double fetchRateFromAPI(String currency) throws Exception
```

#### Key Steps:
- Construct the API URL using the base currency and API key.
- Make an HTTP GET request and handle the response.
- Parse the JSON response to extract the exchange rate for the specified currency.
- Handle errors and log messages.

### 7. **Clear Cache**
The `clearCache` method clears all cached exchange rates.

#### Method Signature:
```java
public void clearCache()
```

### 8. **CurrencyRate Class**
This helper class stores exchange rate information along with a timestamp indicating when the rate was last updated.

#### Key Fields:
- `rate`: The exchange rate value.
- `lastUpdated`: The timestamp of the last update.

#### Key Methods:
- `getRate()`: Returns the exchange rate.
- `getLastUpdated()`: Returns the timestamp of the last update.

### 9. **FraudDetectionService Class**
This class implements various fraud detection mechanisms for cheque transactions. It uses a `ChequeHistoryManager` to track historical cheque data and detect anomalies.

#### Key Features:
- **Fraud Detection Checks**: Includes checks for duplicate cheques, abnormal amounts, suspicious activity, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions.
- **Fraud Alert Levels**: Determines the severity of fraud using predefined thresholds.

#### Method Signature:
```java
public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount)
```

#### Key Steps:
- Perform various fraud detection checks.
- Log the results of the checks.
- Determine the overall fraud alert level.
- Return whether the cheque is fraudulent.

### 10. **ChequeHistoryManager Class**
This mock implementation manages the history of cheque transactions for fraud detection purposes.

#### Key Features:
- Records cheque transactions.
- Displays the history of cheques for a specific account.

#### Example:
```java
public void recordCheque(String acc, String chq, String curr, double amt, Date d) {
    history.computeIfAbsent(acc, k -> new ArrayList<>()).add(new ChequeRecord(acc, chq, curr, amt, d));
}
```

## External Dependencies
- **`org.json.simple.parser.JSONParser`**: Used for parsing JSON responses from the external API.
- **`org.json.simple.JSONObject`**: Represents JSON objects in the parsed response.
- **`ChequeHistoryManager`**: Manages historical cheque data.
- **`FraudDetection`**: Implements fraud detection logic.
- **`ChequeTransaction`**: Represents cheque transaction data.

## Notes
- The `API_KEY` used in the `fetchRateFromAPI` method is a placeholder and should be replaced with a valid key in production.
- The `CACHE_EXPIRY_MINUTES` constant determines how long cached exchange rates remain valid.
- The fraud detection logic relies on multiple thresholds and historical data to identify suspicious activities.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_34"
confidence_score: 0.95
external_dependencies: ["AlertLevel", "ChequeHistoryManager"]
---

# Documentation for Fraud Detection Code Chunk

## Overview
This code chunk is part of a fraud detection system that evaluates various fraud indicators for cheque transactions. It performs checks for duplicate cheques, abnormal amounts, suspicious activities, velocity fraud, pattern fraud, historical duplicates, unusual frequency, and similarity to recent transactions. Based on these checks, it determines an alert level and logs the results.

## Key Methods and Classes

### 1. `logFraudChecks`
Logs the results of various fraud checks for a given transaction. It provides a detailed report of the checks performed and their outcomes.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.
- `amount` (double): The amount of the cheque.
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if there is unusual frequency in transactions.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent transactions.

### 2. `determineAlertLevel`
Determines the alert level based on the results of the fraud checks.

#### Parameters:
- `isDuplicate` (boolean): Indicates if the cheque is a duplicate.
- `isAbnormal` (boolean): Indicates if the amount is abnormal.
- `isSuspicious` (boolean): Indicates if the activity is suspicious.
- `isVelocityFraud` (boolean): Indicates if velocity fraud is detected.
- `isPatternFraud` (boolean): Indicates if pattern fraud is detected.
- `isHistoricalDuplicate` (boolean): Indicates if the cheque is a historical duplicate.
- `isUnusualFrequency` (boolean): Indicates if there is unusual frequency in transactions.
- `isSimilarToRecent` (boolean): Indicates if the cheque amount is similar to recent transactions.

#### Returns:
- `AlertLevel`: The determined alert level (CRITICAL, HIGH, MEDIUM, LOW).

### 3. `checkDuplicateCheque`
Checks if a cheque is a duplicate by consulting the `fraudDetection` object.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.

#### Returns:
- `boolean`: True if the cheque is a duplicate, false otherwise.

### 4. `checkAbnormalAmount`
Checks if the cheque amount is abnormal.

#### Parameters:
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if the amount is abnormal, false otherwise.

### 5. `checkSuspiciousActivity`
Checks for suspicious activity based on the account ID and amount.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if suspicious activity is detected, false otherwise.

### 6. `checkVelocityFraud`
Checks for velocity fraud by analyzing recent transactions.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if velocity fraud is detected, false otherwise.

### 7. `checkPatternFraud`
Checks for pattern fraud by analyzing recent transaction amounts for patterns.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if pattern fraud is detected, false otherwise.

### 8. `checkHistoricalDuplicate`
Checks if the cheque is a historical duplicate by consulting the `historyManager`.

#### Parameters:
- `accountId` (String): The account identifier.
- `chequeNumber` (String): The cheque number.

#### Returns:
- `boolean`: True if the cheque is a historical duplicate, false otherwise.

### 9. `checkUnusualFrequency`
Checks for unusual frequency of transactions for the given account.

#### Parameters:
- `accountId` (String): The account identifier.

#### Returns:
- `boolean`: True if unusual frequency is detected, false otherwise.

### 10. `checkSimilarToRecent`
Checks if the cheque amount is similar to recent transactions.

#### Parameters:
- `accountId` (String): The account identifier.
- `amount` (double): The amount of the cheque.

#### Returns:
- `boolean`: True if the amount is similar to recent transactions, false otherwise.

### 11. `formatCheckResult`
Formats the result of a fraud check for logging purposes.

#### Parameters:
- `failed` (boolean): Indicates if the check failed.

#### Returns:
- `String`: A formatted string indicating the result of the check ("FAILED ⚠️" or "Passed ✓").

### 12. `ChequeTransaction` (Inner Class)
Represents a cheque transaction with an amount and a date.

#### Fields:
- `amount` (double): The amount of the transaction.
- `date` (LocalDate): The date of the transaction.

#### Constructor:
- `ChequeTransaction(double amount, LocalDate date)`: Initializes a new cheque transaction.

#### Methods:
- `getAmount()`: Returns the transaction amount.
- `getDate()`: Returns the transaction date.

## External Dependencies

### 1. `AlertLevel`
An external class used to represent the severity of a fraud alert. Possible values include `CRITICAL`, `HIGH`, `MEDIUM`, and `LOW`.

### 2. `ChequeHistoryManager`
A mock implementation of a class that manages historical cheque data. It provides methods to record and retrieve cheque history for accounts.

## Summary
This code chunk is a comprehensive implementation of a fraud detection system for cheque transactions. It uses various checks to identify potential fraud and assigns an alert level based on the results. The system also logs detailed reports of the checks performed, making it easier to analyze and act upon potential fraud cases.

=== NEXT CHUNK ===

---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_35"
confidence_score: 0.95
external_dependencies: [java.time.LocalDateTime]
---

# Documentation for Code Chunk from `DemoApplication.java`

## Overview

This code chunk is part of a system that monitors and evaluates account activities for potential fraud or suspicious behavior. It includes methods to determine if a transaction amount is abnormal, assess suspicious activity, record transactions, update account profiles, and evaluate abnormal behavior patterns. Additionally, it defines two inner classes, `TransactionRecord` and `AccountProfile`, to manage transaction history and account-related data.

---

## Methods

### `isAbnormalAmount(double amount)`
Determines if a given transaction amount exceeds a predefined threshold.

- **Parameters**:
  - `amount` (double): The transaction amount to evaluate.
- **Returns**:
  - `true` if the amount exceeds the `ABNORMAL_AMOUNT_THRESHOLD`.
  - `false` otherwise.

---

### `isSuspiciousActivity(String accountId, double amount)`
Evaluates whether a transaction is suspicious based on the account's activity and behavior.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Returns**:
  - `true` if the transaction is deemed suspicious.
  - `false` otherwise.
- **Logic**:
  1. Retrieves the total activity for the account from the `accountActivity` map.
  2. Updates the total activity with the current transaction amount.
  3. Records the transaction using `recordTransaction`.
  4. Updates the account profile using `updateAccountProfile`.
  5. Checks if the total activity exceeds a threshold (`ABNORMAL_AMOUNT_THRESHOLD * SUSPICIOUS_ACTIVITY_MULTIPLIER`).
  6. Evaluates abnormal behavior using `isAbnormalBehavior`.
  7. Returns `true` if either the threshold is exceeded or abnormal behavior is detected.

---

### `recordTransaction(String accountId, double amount)`
Records a transaction in the account's transaction history and removes records older than 90 days.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Logic**:
  1. Checks if the account exists in the `accountTransactionHistory` map. If not, initializes a new list for the account.
  2. Adds a new `TransactionRecord` with the current timestamp to the account's transaction history.
  3. Filters the transaction history to retain only records from the last 90 days.

---

### `updateAccountProfile(String accountId, double amount)`
Updates the account's profile with the new transaction data.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Logic**:
  1. Checks if the account exists in the `accountProfiles` map. If not, initializes a new `AccountProfile` for the account.
  2. Updates the account profile with the new transaction using the `updateWithTransaction` method of the `AccountProfile` class.

---

### `isAbnormalBehavior(String accountId, double amount)`
Determines if a transaction exhibits abnormal behavior based on the account's transaction history.

- **Parameters**:
  - `accountId` (String): The unique identifier for the account.
  - `amount` (double): The transaction amount.
- **Returns**:
  - `true` if the transaction exhibits abnormal behavior.
  - `false` otherwise.
- **Logic**:
  1. Checks if the account exists in the `accountProfiles` map. If not, returns `false`.
  2. Retrieves the account's profile and calculates the average transaction amount.
  3. Computes the variance between the current transaction amount and the average.
  4. Returns `true` if the variance exceeds the `AMOUNT_VARIANCE_THRESHOLD` and the amount is greater than the average.

---

## Inner Classes

### `TransactionRecord`
Represents a single transaction record.

- **Fields**:
  - `amount` (double): The transaction amount.
  - `timestamp` (LocalDateTime): The timestamp of the transaction.
- **Constructor**:
  - `TransactionRecord(double amount, LocalDateTime timestamp)`: Initializes a new transaction record with the specified amount and timestamp.

---

### `AccountProfile`
Represents the profile of an account, including transaction statistics.

- **Fields**:
  - `totalAmount` (double): The total amount of all transactions.
  - `transactionCount` (int): The total number of transactions.
  - `maxAmount` (double): The maximum transaction amount.
  - `minAmount` (double): The minimum transaction amount.
- **Methods**:
  - `updateWithTransaction(double amount)`: Updates the profile with a new transaction, adjusting the total amount, transaction count, and min/max amounts.

---

## Constants and External Dependencies

- **Constants**:
  - `ABNORMAL_AMOUNT_THRESHOLD`: A predefined threshold for abnormal transaction amounts.
  - `SUSPICIOUS_ACTIVITY_MULTIPLIER`: A multiplier used to determine suspicious activity thresholds.
  - `AMOUNT_VARIANCE_THRESHOLD`: A threshold for detecting abnormal behavior based on transaction variance.
- **External Dependencies**:
  - `java.time.LocalDateTime`: Used for timestamping transactions and filtering transaction history.

---