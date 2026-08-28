---
original_file: "legacy_source\\DemoApplication.java"
language: "Java"
chunk_id: "chunk_18"
confidence_score: 0.95
external_dependencies: ["java.util.Scanner", "java.text.SimpleDateFormat", "java.util.Date", "java.text.ParseException", "java.util.Locale", "java.text.NumberFormat", "java.util.HashMap", "java.util.Map", "java.nio.charset.StandardCharsets", "ChequeImageHandler", "CryptographyService", "ClearinghouseService"]
---

# Documentation for Code Chunk

This code chunk contains multiple functionalities related to cheque processing, including cheque printing, cheque image submission, user management, and exception reporting. Below is a detailed explanation of the key components and their purposes:

## 1. **Cheque Printing**
The `ChequePrintingService` class provides a method to simulate the printing of a cheque. It formats the cheque details, such as payee name, amount, date, account number, and cheque number, and prints them in a structured format.

### Method: `printCheque`
- **Parameters:**
  - `payeeName` (String): The name of the payee.
  - `amount` (double): The amount to be paid.
  - `date` (Date): The date of the cheque.
  - `accountNumber` (String): The account number from which the cheque is issued.
  - `chequeNumber` (String): The cheque number.
  - `bankName` (String): The name of the bank issuing the cheque.
- **Functionality:**
  - Formats the cheque details using `SimpleDateFormat` for the date and `NumberFormat` for the amount.
  - Prints the cheque details in a structured format to the console.

## 2. **Cheque Image Submission**
The `handleChequeImageSubmission` method handles the process of scanning, encrypting, signing, and sending a cheque image to a clearinghouse.

### Method: `handleChequeImageSubmission`
- **Parameters:**
  - `scanner` (Scanner): Used to read user input.
  - `imageHandler` (ChequeImageHandler): Service to handle image upload.
  - `cryptoService` (CryptographyService): Service for encryption and signing.
  - `clearinghouseService` (ClearinghouseService): Service to send data to the clearinghouse.
  - `currentUser` (User): The currently logged-in user.
- **Functionality:**
  1. Prompts the user for account number, cheque number, and image file path.
  2. Loads the cheque image data using the `ChequeImageHandler`.
  3. Encrypts the image data using the `CryptographyService`.
  4. Signs the encrypted image data using the `CryptographyService` and the user's private key.
  5. Submits the encrypted and signed data to the clearinghouse using the `ClearinghouseService`.

## 3. **User Management**
The `User` class represents a user of the system, and the `UserService` class provides methods for user registration and authentication.

### Class: `User`
- **Attributes:**
  - `username` (String): The username of the user.
  - `password` (String): The password of the user (stored in plain text for simplicity).
  - `role` (String): The role of the user (e.g., "EMPLOYEE", "ACCOUNT_HOLDER").
- **Methods:**
  - `getUsername()`: Returns the username.
  - `getPassword()`: Returns the password.
  - `getRole()`: Returns the role.

### Class: `UserService`
- **Attributes:**
  - `users` (Map<String, User>): A map of registered users.
- **Methods:**
  - `registerUser(String username, String password, String role)`: Registers a new user.
  - `authenticate(String username, String password)`: Authenticates a user based on username and password.

## 4. **Exception Reporting**
The `ExceptionReportManager` class manages exception reports for cheques, such as bounced, duplicate, altered, or delayed cheques. It also supports recording FIR/legal complaint details for bounced cheques.

### Inner Class: `ExceptionRecord`
- **Attributes:**
  - `accountNumber` (String): The account number associated with the cheque.
  - `chequeNumber` (String): The cheque number.
  - `type` (String): The type of exception (e.g., "Bounced").
  - `details` (String): Additional details about the exception.
  - `date` (Date): The date of the exception.
  - `firDetails` (FIRDetails): Details of the FIR/legal complaint (if applicable).

### Inner Class: `FIRDetails`
- **Attributes:**
  - `firNumber` (String): The FIR number.
  - `policeStation` (String): The police station where the FIR was filed.
  - `firDate` (Date): The date of the FIR.
  - `remarks` (String): Additional remarks about the FIR.

## 5. **Email Notification Service**
The `EmailNotificationService` class simulates sending email notifications.

### Method: `sendEmail`
- **Parameters:**
  - `to` (String): The recipient's email address.
  - `subject` (String): The subject of the email.
  - `body` (String): The body of the email.
- **Functionality:**
  - Prints the email details to the console.

## External Dependencies
- `ChequeImageHandler`: Handles image loading and processing.
- `CryptographyService`: Provides encryption and signing functionalities.
- `ClearinghouseService`: Submits data to the clearinghouse.
- `java.util.Scanner`: Reads user input.
- `java.text.SimpleDateFormat`: Formats dates.
- `java.util.Date`: Represents dates.
- `java.text.ParseException`: Handles date parsing errors.
- `java.util.Locale`: Represents locale settings.
- `java.text.NumberFormat`: Formats numbers.
- `java.util.HashMap`: Provides a map implementation.
- `java.util.Map`: Represents a map interface.
- `java.nio.charset.StandardCharsets`: Provides character set constants.