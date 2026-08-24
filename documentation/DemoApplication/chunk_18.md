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