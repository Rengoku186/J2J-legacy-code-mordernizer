package com.example.demo;

import java.util.Scanner;

public class LegacyBankingApplication {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize required services
        UserService userService = new UserService();
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        FraudService fraudService = new FraudService();
        LoanService loanService = new LoanService();
        ReportService reportService = new ReportService();
        NotificationService notificationService = new NotificationService();
        AdminService adminService = new AdminService();
        AuditService auditService = new AuditService();

        // Create an instance of BankingApplication with all required services
        BankingApplication bankingApplication = new BankingApplication(
            userService,
            accountService,
            transactionService,
            fraudService,
            loanService,
            reportService,
            notificationService,
            adminService,
            auditService
        );

        bankingApplication.start();
    }
}