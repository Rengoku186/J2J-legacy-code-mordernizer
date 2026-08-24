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