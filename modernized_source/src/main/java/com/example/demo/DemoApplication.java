package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final UserService userService;
    private final ChequeProcessor chequeProcessor;
    private final ChequeHistoryManager chequeHistoryManager;
    private final CurrencyExchangeService currencyExchangeService;
    private final ExceptionReportManager exceptionReportManager;
    private final ChequeStatusManager chequeStatusManager;
    private final EmailNotificationService emailNotificationService;
    private final AdminService adminService;

    public DemoApplication(UserService userService,
                           ChequeProcessor chequeProcessor,
                           ChequeHistoryManager chequeHistoryManager,
                           CurrencyExchangeService currencyExchangeService,
                           ExceptionReportManager exceptionReportManager,
                           ChequeStatusManager chequeStatusManager,
                           EmailNotificationService emailNotificationService,
                           AdminService adminService) {
        this.userService = userService;
        this.chequeProcessor = chequeProcessor;
        this.chequeHistoryManager = chequeHistoryManager;
        this.currencyExchangeService = currencyExchangeService;
        this.exceptionReportManager = exceptionReportManager;
        this.chequeStatusManager = chequeStatusManager;
        this.emailNotificationService = emailNotificationService;
        this.adminService = adminService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cheque Processing System!");

        if (!performLogin(scanner)) {
            System.out.println("Login failed. Exiting application.");
            return;
        }

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1 -> processSingleCheque(scanner);
                case 2 -> processChequeBatch(scanner);
                case 3 -> viewChequeHistory(scanner);
                case 4 -> displayCurrencyExchangeMenu(scanner);
                case 5 -> handleReportGeneration(scanner);
                case 6 -> handleChequeImageSubmission(scanner);
                case 7 -> handleChequePrinting(scanner);
                case 8 -> {
                    System.out.println("Exiting application. Goodbye!");
                    return;
                }
                case 9 -> viewExceptionReports();
                case 10 -> viewAllChequeStatuses();
                case 11 -> cancelCheque(scanner);
                case 12 -> recordFIRForBouncedCheque(scanner);
                case 13 -> adminEditIFSCBankCodes(scanner);
                case 14 -> adminManageBatches(scanner);
                case 15 -> adminResetStuckTransactions(scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private boolean performLogin(Scanner scanner) {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (userService.authenticate(username, password)) {
                System.out.println("Login successful. Welcome, " + username + "!");
                return true;
            } else {
                attempts--;
                System.out.println("Invalid credentials. Attempts remaining: " + attempts);
            }
        }
        return false;
    }

    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Process a Single Cheque");
        System.out.println("2. Process Multiple Cheques (Batch)");
        System.out.println("3. View Cheque History");
        System.out.println("4. Currency Exchange Information");
        System.out.println("5. Generate Cheque Reports");
        System.out.println("6. Scan, Encrypt, and Send Cheque Image");
        System.out.println("7. Simulate Cheque Printing");
        System.out.println("8. Exit");
        System.out.println("9. View Cheque Exception Report");
        System.out.println("10. View All Cheque Statuses");
        System.out.println("11. Cancel a Cheque");
        System.out.println("12. Record FIR/Legal Complaint for Bounced Cheque");
        System.out.println("13. Admin: Edit IFSC/Bank Codes");
        System.out.println("14. Admin: Manage Batches");
        System.out.println("15. Admin: Reset Stuck Transactions");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processSingleCheque(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter cheque number: ");
        String chequeNumber = scanner.nextLine();
        System.out.print("Enter currency: ");
        String currency = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter signature: ");
        String signature = scanner.nextLine();

        chequeProcessor.processCheque(accountNumber, chequeNumber, currency, amount, signature);
    }

    private void processChequeBatch(Scanner scanner) {
        System.out.print("Enter the number of cheques to process: ");
        int count = Integer.parseInt(scanner.nextLine());
        List<BatchCheque> cheques = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for cheque " + (i + 1) + ":");
            System.out.print("Account number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Cheque number: ");
            String chequeNumber = scanner.nextLine();
            System.out.print("Currency: ");
            String currency = scanner.nextLine();
            System.out.print("Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            System.out.print("Signature: ");
            String signature = scanner.nextLine();

            cheques.add(new BatchCheque(accountNumber, chequeNumber, currency, amount, signature));
        }

        cheques.forEach(cheque -> chequeProcessor.processCheque(
                cheque.getAccountNumber(),
                cheque.getChequeNumber(),
                cheque.getCurrency(),
                cheque.getAmount(),
                cheque.getSignature()
        ));
    }

    private void viewChequeHistory(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        List<ChequeHistoryManager.ChequeRecord> history = chequeHistoryManager.getChequeHistory(accountNumber);

        if (history.isEmpty()) {
            System.out.println("No cheque history found for account: " + accountNumber);
        } else {
            System.out.println("Cheque History:");
            history.forEach(record -> System.out.println(
                    "Cheque Number: " + record.getChequeNumber() +
                            ", Amount: " + record.getAmount() +
                            ", Currency: " + record.getCurrency() +
                            ", Date: " + record.getDate()
            ));
        }
    }

    private void displayCurrencyExchangeMenu(Scanner scanner) {
        System.out.println("Currency Exchange Menu:");
        System.out.println("1. View Supported Currencies");
        System.out.println("2. Get Exchange Rate");
        System.out.println("3. Convert Currency");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = getUserChoice(scanner);

        switch (choice) {
            case 1 -> {
                List<String> currencies = currencyExchangeService.getSupportedCurrencies();
                System.out.println("Supported Currencies: " + currencies);
            }
            case 2 -> {
                System.out.print("Enter currency: ");
                String currency = scanner.nextLine();
                CurrencyExchangeService.CurrencyRate rate = currencyExchangeService.getExchangeRate(currency);
                if (rate != null) {
                    System.out.println("Exchange Rate for " + currency + ": " + rate.getRate());
                } else {
                    System.out.println("Exchange rate not available for " + currency);
                }
            }
            case 3 -> {
                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter from currency: ");
                String fromCurrency = scanner.nextLine();
                System.out.print("Enter to currency: ");
                String toCurrency = scanner.nextLine();

                try {
                    double convertedAmount = currencyExchangeService.convertCurrency(amount, fromCurrency, toCurrency);
                    System.out.println("Converted Amount: " + convertedAmount + " " + toCurrency);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 4 -> System.out.println("Returning to main menu...");
            default -> System.out.println("Invalid choice. Returning to main menu...");
        }
    }

    private void handleReportGeneration(Scanner scanner) {
        System.out.println("Report Generation:");
        System.out.println("1. Daily Report");
        System.out.println("2. Weekly Report");
        System.out.println("3. Monthly Report");
        System.out.println("4. Custom Date Range");
        System.out.print("Enter your choice: ");
        int choice = getUserChoice(scanner);

        Date startDate = null, endDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (choice == 4) {
            try {
                System.out.print("Enter start date (yyyy-MM-dd): ");
                startDate = sdf.parse(scanner.nextLine());
                System.out.print("Enter end date (yyyy-MM-dd): ");
                endDate = sdf.parse(scanner.nextLine());

                if (startDate.after(endDate)) {
                    System.out.println("Start date cannot be after end date.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
                return;
            }
        }

        // Generate report logic here
        System.out.println("Report generation is not implemented yet.");
    }

    private void handleChequeImageSubmission(Scanner scanner) {
        System.out.println("Cheque Image Submission is not implemented yet.");
    }

    private void handleChequePrinting(Scanner scanner) {
        System.out.println("Cheque Printing Simulation is not implemented yet.");
    }

    private void viewExceptionReports() {
        exceptionReportManager.displayExceptions();
    }

    private void viewAllChequeStatuses() {
        chequeStatusManager.displayAllStatuses();
    }

    private void cancelCheque(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter cheque number: ");
        String chequeNumber = scanner.nextLine();

        chequeProcessor.cancelCheque(accountNumber, chequeNumber);
    }

    private void recordFIRForBouncedCheque(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter cheque number: ");
        String chequeNumber = scanner.nextLine();
        System.out.print("Enter FIR number: ");
        String firNumber = scanner.nextLine();
        System.out.print("Enter police station: ");
        String policeStation = scanner.nextLine();
        System.out.print("Enter FIR date (yyyy-MM-dd): ");
        String firDateStr = scanner.nextLine();
        System.out.print("Enter remarks: ");
        String remarks = scanner.nextLine();

        try {
            Date firDate = new SimpleDateFormat("yyyy-MM-dd").parse(firDateStr);
            boolean success = exceptionReportManager.recordFIRDetails(accountNumber, chequeNumber, firNumber, policeStation, firDate, remarks);

            if (success) {
                System.out.println("FIR details recorded successfully.");
            } else {
                System.out.println("Failed to record FIR details. Cheque not found or not bounced.");
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }

    private void adminEditIFSCBankCodes(Scanner scanner) {
        System.out.println("Admin: Edit IFSC/Bank Codes is not implemented yet.");
    }

    private void adminManageBatches(Scanner scanner) {
        System.out.println("Admin: Manage Batches is not implemented yet.");
    }

    private void adminResetStuckTransactions(Scanner scanner) {
        System.out.println("Admin: Reset Stuck Transactions is not implemented yet.");
    }
}