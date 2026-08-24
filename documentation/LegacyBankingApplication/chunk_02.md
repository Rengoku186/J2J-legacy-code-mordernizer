---
original_file: "legacy_source/LegacyBankingApplication.java"
language: "Java"
chunk_id: "chunk_02"
confidence_score: 0.95
external_dependencies: ["UserService", "AccountService", "TransactionService", "FraudService", "LoanService", "ReportService", "NotificationService", "AdminService", "AuditService", "LegacyBankingApplication.SCANNER"]
---

# BankingApplication Class Documentation

The `BankingApplication` class is the core of the legacy banking transaction processing system. It provides functionality for user authentication, account management, transaction processing, loan operations, and reporting. The class interacts with various service classes to perform these operations.

## Class Overview

The `BankingApplication` class is responsible for managing the flow of the application. It initializes services, handles user interactions, and processes various banking operations such as deposits, withdrawals, and loans.

### Fields

The class contains the following private final fields, each representing a service used in the application:

- `UserService userService`: Manages user-related operations, such as authentication and user initialization.
- `AccountService accountService`: Handles account-related operations, such as deposits, withdrawals, and account initialization.
- `TransactionService transactionService`: Manages transaction records.
- `FraudService fraudService`: Performs fraud checks for deposits and withdrawals.
- `LoanService loanService`: Handles loan creation, retrieval, and payments.
- `ReportService reportService`: Generates various reports, such as account summaries and transaction summaries.
- `NotificationService notificationService`: Sends notifications to users.
- `AdminService adminService`: Manages administrative operations.
- `AuditService auditService`: Records audit logs for various operations.

### Methods

#### `public void start()`

The `start` method is the entry point for the application. It initializes default users, accounts, and loans, and then enters a loop to handle user interactions via a main menu. The method performs the following steps:

1. Displays a welcome message.
2. Initializes default users, accounts, and loans.
3. Prompts the user to log in.
4. If login is successful, displays the main menu and processes user choices.
5. Terminates the application when the user chooses to exit.

#### `private User login()`

The `login` method handles user authentication. It allows up to three attempts for the user to enter their username and password. If authentication is successful, the method returns the authenticated `User` object. Otherwise, it returns `null`.

#### `private void printMainMenu()`

Displays the main menu options to the user. The menu includes options for deposits, withdrawals, account viewing, transaction viewing, loan operations, reports, admin operations, and exiting the application.

#### `private void processDeposit()`

Handles the deposit operation. The method:

1. Prompts the user for the account number and deposit amount.
2. Validates the deposit amount.
3. Performs a fraud check using the `FraudService`.
4. Updates the account balance using the `AccountService`.
5. Records the transaction using the `TransactionService`.
6. Sends a notification using the `NotificationService`.
7. Records an audit log using the `AuditService`.

#### `private void processWithdrawal()`

Handles the withdrawal operation. The method:

1. Prompts the user for the account number and withdrawal amount.
2. Validates the withdrawal amount.
3. Performs a fraud check using the `FraudService`.
4. Updates the account balance using the `AccountService`.
5. Records the transaction using the `TransactionService`.
6. Sends a notification using the `NotificationService`.
7. Records an audit log using the `AuditService`.

#### `private void showAccount()`

Displays the details of a specific account. The method:

1. Prompts the user for the account number.
2. Retrieves the account details using the `AccountService`.
3. Displays the account details, including account number, customer name, type, balance, and status.

#### `private void showTransactions()`

Displays the transaction history for a specific account. The method:

1. Prompts the user for the account number.
2. Retrieves the transaction history using the `TransactionService`.
3. Displays the transaction details, including timestamp, type, amount, and description.

#### `private void processLoan()`

Handles loan-related operations. The method provides three options:

1. Create a new loan: Prompts the user for customer ID, principal amount, and interest rate, and creates a new loan using the `LoanService`.
2. View loan details: Prompts the user for a loan ID and retrieves the loan details using the `LoanService`.
3. Pay a loan: Prompts the user for a loan ID and payment amount, and processes the payment using the `LoanService`.

#### `private void showReports()`

Generates and displays various reports. The method provides three options:

1. Account Summary: Generates a summary of all accounts using the `ReportService`.
2. Transaction Summary: Generates a summary of all transactions using the `ReportService`.
3. Loan Summary: Generates a summary of all loans using the `ReportService`.

## External Dependencies

The `BankingApplication` class relies on the following external classes and services:

- `UserService`: For user-related operations.
- `AccountService`: For account-related operations.
- `TransactionService`: For transaction management.
- `FraudService`: For fraud checks.
- `LoanService`: For loan management.
- `ReportService`: For generating reports.
- `NotificationService`: For sending notifications.
- `AdminService`: For administrative operations.
- `AuditService`: For recording audit logs.
- `LegacyBankingApplication.SCANNER`: A static `Scanner` object used for reading user input from the console.