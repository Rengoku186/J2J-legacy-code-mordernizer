---
original_file: "legacy_source\LegacyBankingApplication.java"
language: "Java"
chunk_id: "chunk_05"
confidence_score: 0.95
external_dependencies: ["Loan", "Account", "Transaction", "AccountService"]
---

# Documentation for `LoanService`, `ReportService`, `NotificationService`, `AdminService`, and `AuditService`

This document provides an overview of the classes and methods defined in the provided code chunk. These classes are part of a legacy banking application and serve various purposes such as loan management, reporting, notifications, administrative tasks, and auditing.

## `LoanService`
The `LoanService` class is responsible for managing loans within the banking application. It provides methods to create, retrieve, and manage loans.

### Fields
- `Map<String, Loan> loans`: A map that stores loans with their unique loan IDs as keys.
- `int sequence`: A counter used to generate unique loan IDs.

### Methods

#### `void initializeDefaultLoans()`
Initializes the system with two default loans for demonstration purposes.
- Creates a loan for `user1` with a principal of `10000.0` and an interest rate of `5.0%`.
- Creates a loan for `user2` with a principal of `20000.0` and an interest rate of `6.5%`.

#### `Loan createLoan(String customerId, double principal, double rate)`
Creates a new loan for a customer.
- Generates a unique loan ID using the `sequence` field.
- Creates a `Loan` object with the provided `customerId`, `principal`, and `rate`.
- Stores the loan in the `loans` map and returns the created `Loan` object.

#### `Loan getLoan(String loanId)`
Retrieves a loan by its ID.
- Returns the `Loan` object associated with the given `loanId` from the `loans` map.

#### `boolean payLoan(String loanId, double amount)`
Processes a payment for a loan.
- Retrieves the loan using the `getLoan` method.
- If the loan exists, calls the `pay` method on the `Loan` object with the specified amount.
- Returns `true` if the payment is successful, otherwise `false`.

#### `List<Loan> getAllLoans()`
Returns a list of all loans in the system.
- Converts the values of the `loans` map into a list and returns it.

## `ReportService`
The `ReportService` class provides methods to generate summaries for accounts, transactions, and loans.

### Methods

#### `void accountSummary(List<Account> accounts)`
Prints a summary of all accounts.
- Iterates through the list of `Account` objects and prints their details (account number, customer name, and balance).
- Calculates and prints the total balance of all accounts.

#### `void transactionSummary(List<Transaction> transactions)`
Prints a summary of all transactions.
- Iterates through the list of `Transaction` objects and calculates the total deposit and withdrawal amounts.
- Prints the total deposit, total withdrawal, and the number of transactions.

#### `void loanSummary(List<Loan> loans)`
Prints a summary of all loans.
- Iterates through the list of `Loan` objects and prints their details (loan ID, customer ID, outstanding amount, and status).
- Calculates and prints the total outstanding amount for all loans.

## `NotificationService`
The `NotificationService` class is responsible for sending notifications.

### Methods

#### `void send(String message)`
Sends a notification with the specified message.
- Prints the message to the console with a `[NOTIFICATION]` prefix.

## `AdminService`
The `AdminService` class provides administrative functionalities such as creating, blocking, and unblocking accounts.

### Methods

#### `boolean createAccount(String number, String name, String type, AccountService accountService)`
Creates a new account.
- Creates an `Account` object with the specified details.
- Adds the account to the `AccountService`.
- Returns `true` if the account is successfully added, otherwise `false`.

#### `void blockAccount(String accountNumber, AccountService accountService)`
Blocks an account.
- Calls the `block` method on the `AccountService` with the specified account number.
- Prints a message indicating whether the account was successfully blocked or not.

#### `void unblockAccount(String accountNumber, AccountService accountService)`
Unblocks an account.
- Calls the `unblock` method on the `AccountService` with the specified account number.
- Prints a message indicating whether the account was successfully unblocked or not.

## `AuditService`
The `AuditService` class is responsible for recording and printing audit logs.

### Fields
- `List<String> logs`: A list that stores audit log entries.

### Methods

#### `void record(String action, String details)`
Records an audit log entry.
- Generates a timestamp for the current date and time.
- Adds a log entry with the timestamp, action, and details to the `logs` list.

#### `void printAll()`
Prints all audit log entries.
- If there are no log entries, prints a message indicating that there are no audit entries.
- Otherwise, iterates through the `logs` list and prints each entry.

## External Dependencies
The following external classes are referenced in this code:
- `Loan`: Represents a loan and provides methods to manage loan details and payments.
- `Account`: Represents a bank account and provides methods to manage account details and transactions.
- `Transaction`: Represents a financial transaction and provides methods to access transaction details.
- `AccountService`: Manages accounts and provides methods to add, retrieve, and modify accounts.