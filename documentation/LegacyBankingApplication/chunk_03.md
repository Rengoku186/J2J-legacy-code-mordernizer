---
original_file: "legacy_source\LegacyBankingApplication.java"
language: "Java"
chunk_id: "chunk_03"
confidence_score: 0.95
external_dependencies: ["LegacyBankingApplication.SCANNER", "reportService", "accountService", "transactionService", "loanService", "adminService", "auditService"]
---

# Documentation for `showReports`, `adminOperations`, and `parseAmount` Methods

## Overview
This code chunk is part of the `LegacyBankingApplication` class and contains three private methods:

1. `showReports`: Displays a menu for generating various reports and invokes the appropriate service methods based on user input.
2. `adminOperations`: Provides a menu for administrative operations such as creating, blocking, and unblocking accounts, as well as viewing audit logs.
3. `parseAmount`: Parses a user-provided input string into a `double` value, with error handling for invalid inputs.

These methods rely on several external services and classes, including `LegacyBankingApplication.SCANNER`, `reportService`, `accountService`, `transactionService`, `loanService`, `adminService`, and `auditService`.

---

## Method: `showReports`

### Purpose
The `showReports` method provides a menu for generating different types of reports, such as account summaries, transaction summaries, and loan summaries. It uses the `SCANNER` object to capture user input and calls the appropriate methods from the `reportService` to generate the selected report.

### Code Walkthrough
1. Displays a menu with three options:
   - `1. Account Summary`
   - `2. Transaction Summary`
   - `3. Loan Summary`
2. Prompts the user to input their choice.
3. Based on the user's choice:
   - Calls `reportService.accountSummary` with the list of all accounts retrieved from `accountService.getAllAccounts()`.
   - Calls `reportService.transactionSummary` with the list of all transactions retrieved from `transactionService.getAllTransactions()`.
   - Calls `reportService.loanSummary` with the list of all loans retrieved from `loanService.getAllLoans()`.
4. Prints an error message for invalid choices.

### External Dependencies
- **`LegacyBankingApplication.SCANNER`**: A `Scanner` object used for reading user input.
- **`reportService`**: Provides methods for generating reports.
  - `accountSummary(List<Account>)`
  - `transactionSummary(List<Transaction>)`
  - `loanSummary(List<Loan>)`
- **`accountService.getAllAccounts()`**: Retrieves a list of all accounts.
- **`transactionService.getAllTransactions()`**: Retrieves a list of all transactions.
- **`loanService.getAllLoans()`**: Retrieves a list of all loans.

---

## Method: `adminOperations`

### Purpose
The `adminOperations` method provides a menu for performing administrative tasks, such as creating accounts, blocking/unblocking accounts, and viewing audit logs. It uses the `SCANNER` object to capture user input and calls the appropriate methods from the `adminService` and `auditService`.

### Code Walkthrough
1. Displays a menu with four options:
   - `1. Create Account`
   - `2. Block Account`
   - `3. Unblock Account`
   - `4. View Audit Log`
2. Prompts the user to input their choice.
3. Based on the user's choice:
   - **Create Account**:
     - Prompts the user for account details (number, name, type).
     - Calls `adminService.createAccount` with the provided details and `accountService`.
     - Prints a success or failure message based on the result.
   - **Block Account**:
     - Prompts the user for the account number.
     - Calls `adminService.blockAccount` with the account number and `accountService`.
   - **Unblock Account**:
     - Prompts the user for the account number.
     - Calls `adminService.unblockAccount` with the account number and `accountService`.
   - **View Audit Log**:
     - Calls `auditService.printAll()` to display the audit log.
4. Prints an error message for invalid choices.

### External Dependencies
- **`LegacyBankingApplication.SCANNER`**: A `Scanner` object used for reading user input.
- **`adminService`**: Provides methods for administrative operations.
  - `createAccount(String, String, String, AccountService)`
  - `blockAccount(String, AccountService)`
  - `unblockAccount(String, AccountService)`
- **`auditService.printAll()`**: Prints the audit log.
- **`accountService`**: Used as a dependency for `adminService` methods.

---

## Method: `parseAmount`

### Purpose
The `parseAmount` method reads a user-provided input string and attempts to parse it into a `double` value. If the input is invalid, it returns `-1`.

### Code Walkthrough
1. Reads a line of input using `LegacyBankingApplication.SCANNER.nextLine()`.
2. Attempts to parse the input into a `double` using `Double.parseDouble()`.
3. Catches any exceptions (e.g., `NumberFormatException`) and returns `-1` if parsing fails.

### External Dependencies
- **`LegacyBankingApplication.SCANNER`**: A `Scanner` object used for reading user input.

---

## Summary
This code chunk provides functionality for generating reports, performing administrative operations, and parsing user-provided numeric input. It relies on several external services (`reportService`, `adminService`, `auditService`, etc.) and the `LegacyBankingApplication.SCANNER` object for user interaction. The methods are designed to handle user input robustly, with error handling for invalid choices and inputs.