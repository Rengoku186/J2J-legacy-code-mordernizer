package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        // Initialize services
        UserService userService = new UserService();
        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        SignatureVerificationService signatureVerificationService = new SignatureVerificationService();
        CoreBankingSystemUpdater coreBankingSystemUpdater = new CoreBankingSystemUpdater();
        ChequeHistoryManager chequeHistoryManager = new ChequeHistoryManager();
        FraudDetectionService fraudDetectionService = new FraudDetectionService(chequeHistoryManager);
        ExceptionReportManager exceptionReportManager = new ExceptionReportManager();
        ChequeStatusManager chequeStatusManager = new ChequeStatusManager();
        EmailNotificationService emailNotificationService = new EmailNotificationService();
        ChequeProcessor chequeProcessor = new ChequeProcessor(
                currencyExchangeService,
                signatureVerificationService,
                coreBankingSystemUpdater,
                chequeHistoryManager,
                fraudDetectionService,
                exceptionReportManager,
                chequeStatusManager,
                emailNotificationService
        );

        Scanner scanner = new Scanner(System.in);
        User currentUser = performLogin(scanner, userService);

        if (currentUser == null) {
            System.out.println("Failed to authenticate. Exiting application.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Process a single cheque");
            System.out.println("2. Process multiple cheques in a batch");
            System.out.println("3. View cheque history");
            System.out.println("4. Display currency exchange information");
            System.out.println("5. Generate cheque reports");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    processSingleCheque(scanner, chequeProcessor);
                    break;
                case 2:
                    processChequeBatch(scanner, chequeProcessor);
                    break;
                case 3:
                    viewChequeHistory(scanner, chequeHistoryManager);
                    break;
                case 4:
                    displayCurrencyExchangeMenu(scanner, currencyExchangeService);
                    break;
                case 5:
                    handleReportGeneration(scanner, chequeHistoryManager);
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static User performLogin(Scanner scanner, UserService userService) {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            User user = userService.authenticate(username, password);
            if (user != null) {
                System.out.println("Welcome, " + user.getUsername() + "!");
                return user;
            } else {
                System.out.println("Invalid credentials. Please try again.");
                attempts++;
            }
        }
        return null;
    }

    private static void processSingleCheque(Scanner scanner, ChequeProcessor chequeProcessor) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Cheque Number: ");
        String chequeNumber = scanner.nextLine();
        System.out.print("Enter Currency: ");
        String currency = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Signature: ");
        String signature = scanner.nextLine();

        try {
            chequeProcessor.processCheque(accountNumber, chequeNumber, currency, amount, signature);
            System.out.println("Cheque processed successfully.");
        } catch (Exception e) {
            System.out.println("Error processing cheque: " + e.getMessage());
        }
    }

    private static void processChequeBatch(Scanner scanner, ChequeProcessor chequeProcessor) {
        System.out.print("Enter the number of cheques to process: ");
        int numCheques = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numCheques; i++) {
            System.out.println("\nEnter details for cheque " + (i + 1) + ":");
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter Cheque Number: ");
            String chequeNumber = scanner.nextLine();
            System.out.print("Enter Currency: ");
            String currency = scanner.nextLine();
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Signature: ");
            String signature = scanner.nextLine();

            try {
                chequeProcessor.processCheque(accountNumber, chequeNumber, currency, amount, signature);
                System.out.println("Cheque " + (i + 1) + " processed successfully.");
            } catch (Exception e) {
                System.out.println("Error processing cheque " + (i + 1) + ": " + e.getMessage());
            }
        }
    }

    private static void viewChequeHistory(Scanner scanner, ChequeHistoryManager chequeHistoryManager) {
        System.out.print("Enter Account Number to view cheque history: ");
        String accountNumber = scanner.nextLine();
        chequeHistoryManager.displayChequeHistory(accountNumber);
    }

    private static void displayCurrencyExchangeMenu(Scanner scanner, CurrencyExchangeService currencyExchangeService) {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\n--- Currency Exchange Menu ---");
            System.out.println("1. View Supported Currencies");
            System.out.println("2. Get Exchange Rate");
            System.out.println("3. Convert Currency");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<String> supportedCurrencies = currencyExchangeService.getSupportedCurrencies();
                    System.out.println("Supported Currencies: " + supportedCurrencies);
                    break;
                case 2:
                    System.out.print("Enter Currency Code: ");
                    String currency = scanner.nextLine();
                    double rate = currencyExchangeService.getExchangeRate(currency);
                    System.out.println("Exchange Rate for " + currency + ": " + rate);
                    break;
                case 3:
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter From Currency: ");
                    String fromCurrency = scanner.nextLine();
                    System.out.print("Enter To Currency: ");
                    String toCurrency = scanner.nextLine();
                    double convertedAmount = currencyExchangeService.convertCurrency(amount, fromCurrency, toCurrency);
                    System.out.println("Converted Amount: " + convertedAmount);
                    break;
                case 4:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleReportGeneration(Scanner scanner, ChequeHistoryManager chequeHistoryManager) {
        System.out.println("\n--- Report Generation Menu ---");
        System.out.println("1. Generate Daily Report");
        System.out.println("2. Generate Weekly Report");
        System.out.println("3. Generate Monthly Report");
        System.out.println("4. Generate Custom Date Range Report");
        System.out.println("5. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Generating Daily Report...");
                // Logic for daily report
                break;
            case 2:
                System.out.println("Generating Weekly Report...");
                // Logic for weekly report
                break;
            case 3:
                System.out.println("Generating Monthly Report...");
                // Logic for monthly report
                break;
            case 4:
                System.out.println("Generating Custom Date Range Report...");
                // Logic for custom date range report
                break;
            case 5:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}