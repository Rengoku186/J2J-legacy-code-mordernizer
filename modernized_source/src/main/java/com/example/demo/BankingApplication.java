package com.example.demo;

import java.util.List;
import java.util.Scanner;

public class BankingApplication {

    // Services
    private final UserService userService;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final FraudService fraudService;
    private final LoanService loanService;
    private final ReportService reportService;
    private final NotificationService notificationService;
    private final AdminService adminService;
    private final AuditService auditService;

    // Constructor
    public BankingApplication(UserService userService, AccountService accountService, TransactionService transactionService,
                               FraudService fraudService, LoanService loanService, ReportService reportService,
                               NotificationService notificationService, AdminService adminService, AuditService auditService) {
        this.userService = userService;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.fraudService = fraudService;
        this.loanService = loanService;
        this.reportService = reportService;
        this.notificationService = notificationService;
        this.adminService = adminService;
        this.auditService = auditService;
    }

    // Public Methods
    public void start() {
        System.out.println("Welcome to the Legacy Banking Application!");
        userService.initializeDefaultUsers();
        accountService.initializeDefaultAccounts();
        loanService.initializeDefaultLoans();

        User loggedInUser = login();
        if (loggedInUser == null) {
            System.out.println("Failed to log in. Exiting application.");
            return;
        }

        boolean running = true;
        while (running) {
            printMainMenu();
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(LegacyBankingApplication.SCANNER.nextLine());
            switch (choice) {
                case 1 -> processDeposit();
                case 2 -> processWithdrawal();
                case 3 -> showAccount();
                case 4 -> showTransactions();
                case 5 -> processLoan();
                case 6 -> showReports();
                case 7 -> adminOperations();
                case 8 -> {
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Private Methods
    private User login() {
        System.out.println("Please log in.");
        for (int attempts = 0; attempts < 3; attempts++) {
            System.out.print("Username: ");
            String username = LegacyBankingApplication.SCANNER.nextLine();
            System.out.print("Password: ");
            String password = LegacyBankingApplication.SCANNER.nextLine();

            User user = userService.authenticate(username, password);
            if (user != null) {
                System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
                return user;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
        return null;
    }

    private void printMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Account");
        System.out.println("4. View Transactions");
        System.out.println("5. Loan Operations");
        System.out.println("6. Reports");
        System.out.println("7. Admin Operations");
        System.out.println("8. Exit");
    }

    private void processDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = LegacyBankingApplication.SCANNER.nextLine();
        System.out.print("Enter deposit amount: ");
        double amount = parseAmount();

        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit failed.");
            return;
        }

        if (!fraudService.checkDeposit(accountNumber, amount)) {
            System.out.println("Fraud check failed. Deposit not allowed.");
            return;
        }

        if (accountService.deposit(accountNumber, amount)) {
            transactionService.record(accountNumber, "DEPOSIT", amount, "Deposit made");
            notificationService.send("Deposit of " + amount + " made to account " + accountNumber);
            auditService.record("DEPOSIT", "Account: " + accountNumber + ", Amount: " + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed. Please check the account number.");
        }
    }

    private void processWithdrawal() {
        System.out.print("Enter account number: ");
        String accountNumber = LegacyBankingApplication.SCANNER.nextLine();
        System.out.print("Enter withdrawal amount: ");
        double amount = parseAmount();

        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal failed.");
            return;
        }

        if (!fraudService.checkWithdrawal(accountNumber, amount)) {
            System.out.println("Fraud check failed. Withdrawal not allowed.");
            return;
        }

        if (accountService.withdraw(accountNumber, amount)) {
            transactionService.record(accountNumber, "WITHDRAWAL", amount, "Withdrawal made");
            notificationService.send("Withdrawal of " + amount + " made from account " + accountNumber);
            auditService.record("WITHDRAWAL", "Account: " + accountNumber + ", Amount: " + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Please check the account number or balance.");
        }
    }

    private void showAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = LegacyBankingApplication.SCANNER.nextLine();
        Account account = accountService.getAccount(accountNumber);

        if (account != null) {
            System.out.println("Account Details:");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Customer Name: " + account.getCustomerName());
            System.out.println("Type: " + account.getType());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Status: " + account.getStatus());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void showTransactions() {
        System.out.print("Enter account number: ");
        String accountNumber = LegacyBankingApplication.SCANNER.nextLine();
        List<Transaction> transactions = transactionService.getTransactions(accountNumber);

        if (transactions != null && !transactions.isEmpty()) {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getTimestamp() + " - " + transaction.getType() + " - " + transaction.getAmount() + " - " + transaction.getDescription());
            }
        } else {
            System.out.println("No transactions found for this account.");
        }
    }

    private void processLoan() {
        System.out.println("Loan Operations:");
        System.out.println("1. Create Loan");
        System.out.println("2. View Loan");
        System.out.println("3. Pay Loan");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(LegacyBankingApplication.SCANNER.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.print("Enter customer ID: ");
                String customerId = LegacyBankingApplication.SCANNER.nextLine();
                System.out.print("Enter principal amount: ");
                double principal = parseAmount();
                System.out.print("Enter interest rate: ");
                double rate = parseAmount();

                Loan loan = loanService.createLoan(customerId, principal, rate);
                if (loan != null) {
                    System.out.println("Loan created successfully. Loan ID: " + loan.getLoanId());
                } else {
                    System.out.println("Failed to create loan.");
                }
            }
            case 2 -> {
                System.out.print("Enter loan ID: ");
                String loanId = LegacyBankingApplication.SCANNER.nextLine();
                Loan loan = loanService.getLoan(loanId);

                if (loan != null) {
                    System.out.println("Loan Details:");
                    System.out.println("Loan ID: " + loan.getLoanId());
                    System.out.println("Customer ID: " + loan.getCustomerId());
                    System.out.println("Principal: " + loan.getPrincipal());
                    System.out.println("Interest Rate: " + loan.getInterestRate());
                    System.out.println("Outstanding: " + loan.getOutstanding());
                    System.out.println("Status: " + loan.getStatus());
                } else {
                    System.out.println("Loan not found.");
                }
            }
            case 3 -> {
                System.out.print("Enter loan ID: ");
                String loanId = LegacyBankingApplication.SCANNER.nextLine();
                System.out.print("Enter payment amount: ");
                double amount = parseAmount();

                if (loanService.payLoan(loanId, amount)) {
                    System.out.println("Payment successful.");
                } else {
                    System.out.println("Payment failed. Please check the loan ID or amount.");
                }
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void showReports() {
        System.out.println("Reports:");
        System.out.println("1. Account Summary");
        System.out.println("2. Transaction Summary");
        System.out.println("3. Loan Summary");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(LegacyBankingApplication.SCANNER.nextLine());

        switch (choice) {
            case 1 -> reportService.accountSummary(accountService.getAllAccounts());
            case 2 -> reportService.transactionSummary(transactionService.getAllTransactions());
            case 3 -> reportService.loanSummary(loanService.getAllLoans());
            default -> System.out.println("Invalid choice.");
        }
    }

    private void adminOperations() {
        System.out.println("Admin Operations:");
        System.out.println("1. Create Account");
        System.out.println("2. Block Account");
        System.out.println("3. Unblock Account");
        System.out.println("4. View Audit Log");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(LegacyBankingApplication.SCANNER.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.print("Enter account number: ");
                String number = LegacyBankingApplication.SCANNER.nextLine();
                System.out.print("Enter customer name: ");
                String name = LegacyBankingApplication.SCANNER.nextLine();
                System.out.print("Enter account type: ");
                String type = LegacyBankingApplication.SCANNER.nextLine();

                if (adminService.createAccount(number, name, type, accountService)) {
                    System.out.println("Account created successfully.");
                } else {
                    System.out.println("Failed to create account. Account number may already exist.");
                }
            }
            case 2 -> {
                System.out.print("Enter account number: ");
                String accountNumber = LegacyBankingApplication.SCANNER.nextLine();
                adminService.blockAccount(accountNumber, accountService);
            }
            case 3 -> {
                System.out.print("Enter account number: ");
                String accountNumber = LegacyBankingApplication.SCANNER.nextLine();
                adminService.unblockAccount(accountNumber, accountService);
            }
            case 4 -> auditService.printAll();
            default -> System.out.println("Invalid choice.");
        }
    }

    private double parseAmount() {
        try {
            return Double.parseDouble(LegacyBankingApplication.SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.");
            return -1;
        }
    }
}