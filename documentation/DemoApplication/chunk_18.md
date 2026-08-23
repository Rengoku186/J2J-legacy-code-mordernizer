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