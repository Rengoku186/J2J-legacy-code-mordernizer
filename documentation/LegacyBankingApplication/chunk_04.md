---
original_file: "legacy_source/LegacyBankingApplication.java"
language: "Java"
chunk_id: "chunk_04"
confidence_score: 1.0
external_dependencies: []
---

# Documentation for LegacyBankingApplication.java (Chunk 04)

This chunk of code defines several classes and services that form the core of a banking application. The classes represent entities such as users, accounts, transactions, loans, and their respective services. Below is a detailed explanation of each class and its methods.

---

## Class: `User`
Represents a user in the system.

### Fields:
- `username` (String): The username of the user.
- `password` (String): The password of the user.
- `role` (String): The role of the user (e.g., ADMIN, CUSTOMER).

### Constructor:
- `User(String username, String password, String role)`: Initializes a new user with the given username, password, and role.

### Methods:
- `getUsername()`: Returns the username.
- `getPassword()`: Returns the password.
- `getRole()`: Returns the role.

---

## Class: `UserService`
Manages user-related operations.

### Fields:
- `users` (Map<String, User>): A map of usernames to `User` objects.

### Methods:
- `initializeDefaultUsers()`: Adds default users to the system.
- `authenticate(String username, String password)`: Authenticates a user by username and password. Returns the `User` object if successful, otherwise `null`.
- `addUser(String username, String password, String role)`: Adds a new user to the system. Returns `true` if successful, `false` if the username already exists.

---

## Class: `Account`
Represents a bank account.

### Fields:
- `accountNumber` (String): The account number.
- `customerName` (String): The name of the account holder.
- `type` (String): The type of account (e.g., SAVINGS, CURRENT).
- `balance` (double): The current balance of the account.
- `status` (String): The status of the account (e.g., ACTIVE, BLOCKED).

### Constructor:
- `Account(String accountNumber, String customerName, String type)`: Initializes a new account with a default balance of 1000.0 and status as ACTIVE.

### Methods:
- `getAccountNumber()`: Returns the account number.
- `getCustomerName()`: Returns the customer name.
- `getType()`: Returns the account type.
- `getBalance()`: Returns the account balance.
- `getStatus()`: Returns the account status.
- `deposit(double amount)`: Deposits the specified amount into the account.
- `withdraw(double amount)`: Withdraws the specified amount if the account is ACTIVE and has sufficient balance. Returns `true` if successful, `false` otherwise.
- `block()`: Blocks the account.
- `unblock()`: Unblocks the account.

---

## Class: `AccountService`
Manages account-related operations.

### Fields:
- `accounts` (Map<String, Account>): A map of account numbers to `Account` objects.

### Methods:
- `initializeDefaultAccounts()`: Adds default accounts to the system.
- `getAccount(String accountNumber)`: Retrieves an account by its number.
- `getAllAccounts()`: Returns a list of all accounts.
- `addAccount(Account account)`: Adds a new account. Returns `true` if successful, `false` if the account number already exists.
- `deposit(String accountNumber, double amount)`: Deposits the specified amount into the account. Returns `true` if successful, `false` otherwise.
- `withdraw(String accountNumber, double amount)`: Withdraws the specified amount from the account. Returns `true` if successful, `false` otherwise.
- `block(String accountNumber)`: Blocks the specified account. Returns `true` if successful, `false` otherwise.
- `unblock(String accountNumber)`: Unblocks the specified account. Returns `true` if successful, `false` otherwise.

---

## Class: `Transaction`
Represents a transaction on an account.

### Fields:
- `accountNumber` (String): The account number associated with the transaction.
- `type` (String): The type of transaction (e.g., DEPOSIT, WITHDRAWAL).
- `amount` (double): The transaction amount.
- `description` (String): A description of the transaction.
- `timestamp` (LocalDateTime): The timestamp of the transaction.

### Constructor:
- `Transaction(String accountNumber, String type, double amount, String description)`: Initializes a new transaction with the current timestamp.

### Methods:
- `getAccountNumber()`: Returns the account number.
- `getType()`: Returns the transaction type.
- `getAmount()`: Returns the transaction amount.
- `getDescription()`: Returns the transaction description.
- `getTimestamp()`: Returns the transaction timestamp in ISO format.

---

## Class: `TransactionService`
Manages transaction-related operations.

### Fields:
- `transactionMap` (Map<String, List<Transaction>>): A map of account numbers to lists of transactions.

### Methods:
- `record(String accountNumber, String type, double amount, String description)`: Records a new transaction for the specified account.
- `getTransactions(String accountNumber)`: Retrieves all transactions for the specified account. Returns an empty list if no transactions exist.
- `getAllTransactions()`: Retrieves all transactions across all accounts.

---

## Class: `FraudService`
Monitors transactions for potential fraud.

### Constants:
- `LARGE_DEPOSIT` (double): Threshold for large deposits (25000.0).
- `LARGE_WITHDRAWAL` (double): Threshold for large withdrawals (10000.0).
- `DAILY_TRANSACTION_LIMIT` (int): Maximum number of transactions allowed per day (5).

### Fields:
- `transactionCount` (Map<String, Integer>): A map of account numbers to their daily transaction counts.

### Methods:
- `checkDeposit(String account, double amount)`: Checks if a deposit exceeds the large deposit threshold and increments the transaction count. Returns `true` if the daily transaction limit is not exceeded.
- `checkWithdrawal(String account, double amount)`: Checks if a withdrawal exceeds the large withdrawal threshold and increments the transaction count. Returns `true` if the daily transaction limit is not exceeded.
- `incrementAndCheck(String account)`: Increments the transaction count for the account and checks if the daily limit is exceeded. Returns `true` if within the limit, `false` otherwise.

---

## Class: `Loan`
Represents a loan taken by a customer.

### Fields:
- `loanId` (String): The unique identifier for the loan.
- `customerId` (String): The ID of the customer who took the loan.
- `principal` (double): The principal amount of the loan.
- `interestRate` (double): The interest rate of the loan.
- `outstanding` (double): The outstanding amount to be paid.
- `status` (String): The status of the loan (e.g., OPEN, CLOSED).

### Constructor:
- `Loan(String loanId, String customerId, double principal, double interestRate)`: Initializes a new loan with the given details. The outstanding amount is calculated as `principal + (principal * interestRate / 100)`.

### Methods:
- `getLoanId()`: Returns the loan ID.
- `getCustomerId()`: Returns the customer ID.
- `getPrincipal()`: Returns the principal amount.
- `getInterestRate()`: Returns the interest rate.
- `getOutstanding()`: Returns the outstanding amount.
- `getStatus()`: Returns the loan status.
- `pay(double amount)`: Pays the specified amount towards the loan. Updates the status to CLOSED if the outstanding amount becomes zero. Returns `true` if successful, `false` otherwise.

---

## Class: `LoanService`
Manages loan-related operations.

### Fields:
- `loans` (Map<String, Loan>): A map of loan IDs to `Loan` objects.
- `sequence` (int): A counter for generating unique loan IDs.

### Methods:
- `initializeDefaultLoans()`: Adds default loans to the system.
- `createLoan(String customerId, double principal, double rate)`: Creates a new loan for the specified customer with the given principal and interest rate. Returns the created `Loan` object.
- `getLoan(String loanId)`: Retrieves a loan by its ID.
- `payLoan(String loanId, double amount)`: Pays the specified amount towards the loan. Returns `true` if successful, `false` otherwise.
- `getAllLoans()`: Retrieves a list of all loans.

---

This chunk of code provides a comprehensive implementation of a banking system, including user management, account management, transaction handling, fraud detection, and loan management. Each service class encapsulates the logic for its respective domain, ensuring modularity and maintainability.