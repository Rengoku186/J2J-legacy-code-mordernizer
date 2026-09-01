package com.example.demo;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ChequeProcessor {

    private final CurrencyExchangeService currencyExchangeService;
    private final SignatureVerificationService signatureVerificationService;
    private final CoreBankingSystemUpdater coreBankingSystemUpdater;
    private final ChequeHistoryManager chequeHistoryManager;
    private final FraudDetectionService fraudDetectionService;
    private final ExceptionReportManager exceptionReportManager;
    private final ChequeStatusManager chequeStatusManager;
    private final EmailNotificationService emailNotificationService;
    private final Logger logger = new Logger();

    public void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature) {
        try {
            // Step 1: Mark cheque as issued
            if (chequeStatusManager.getStatus(accountNumber, chequeNumber) == null) {
                chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatusManager.ChequeStatus.ISSUED);
            }

            // Step 2: Verify signature
            boolean isSignatureValid = signatureVerificationService.verifySignature(accountNumber, signature);
            if (!isSignatureValid) {
                String errorMessage = "Signature verification failed for cheque " + chequeNumber + " on account " + accountNumber;
                exceptionReportManager.reportException(accountNumber, chequeNumber, "SignatureVerificationFailed", errorMessage);
                emailNotificationService.sendEmail(
                        accountNumber + "@bank.com",
                        "Cheque Processing Error",
                        errorMessage
                );
                return;
            }

            // Step 3: Fraud detection
            boolean isFraudulent = fraudDetectionService.isFraudulentCheque(accountNumber, chequeNumber, amount);
            if (isFraudulent) {
                String errorMessage = "Fraudulent cheque detected: " + chequeNumber + " on account " + accountNumber;
                exceptionReportManager.reportException(accountNumber, chequeNumber, "FraudulentCheque", errorMessage);
                emailNotificationService.sendEmail(
                        accountNumber + "@bank.com",
                        "Cheque Processing Error",
                        errorMessage
                );
                return;
            }

            // Step 4: Simulate bounced cheque
            if (amount > 50000) {
                String errorMessage = "Cheque " + chequeNumber + " for account " + accountNumber + " has bounced due to insufficient funds.";
                exceptionReportManager.reportException(accountNumber, chequeNumber, "BouncedCheque", errorMessage);
                emailNotificationService.sendEmail(
                        accountNumber + "@bank.com",
                        "Cheque Bounced",
                        errorMessage
                );
                return;
            }

            // Step 5: Simulate delayed cheque
            if (chequeNumber.endsWith("9")) {
                String warningMessage = "Cheque " + chequeNumber + " for account " + accountNumber + " is delayed.";
                exceptionReportManager.reportException(accountNumber, chequeNumber, "DelayedCheque", warningMessage);
                emailNotificationService.sendEmail(
                        accountNumber + "@bank.com",
                        "Cheque Delayed",
                        warningMessage
                );
            }

            // Step 6: Currency conversion
            double amountInLocalCurrency = amount;
            if (!"USD".equalsIgnoreCase(currency)) {
                CurrencyExchangeService.CurrencyRate rate = currencyExchangeService.getExchangeRate(currency);
                if (rate == null) {
                    throw new IllegalArgumentException("Exchange rate not available for currency: " + currency);
                }
                double buyRate = rate.getDetailedRates().get("buy");
                double fee = rate.getDetailedRates().get("fee");
                double feeAmount = amount * fee;
                amountInLocalCurrency = (amount * buyRate) - feeAmount;
            }

            // Step 7: Update core banking system
            coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);

            // Step 8: Record cheque history
            chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, new Date());

            // Step 9: Update cheque status
            chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatusManager.ChequeStatus.PROCESSED);

            // Step 10: Notify success
            emailNotificationService.sendEmail(
                    accountNumber + "@bank.com",
                    "Cheque Processed Successfully",
                    "Your cheque " + chequeNumber + " for account " + accountNumber + " has been processed successfully."
            );

        } catch (Exception ex) {
            logger.error("Error processing cheque " + chequeNumber + ": " + ex.getMessage());
            exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", ex.getMessage());
            emailNotificationService.sendEmail(
                    accountNumber + "@bank.com",
                    "Cheque Processing Error",
                    "An error occurred while processing cheque " + chequeNumber + " for account " + accountNumber + ": " + ex.getMessage()
            );
        }
    }

    public void cancelCheque(String accountNumber, String chequeNumber) {
        try {
            chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatusManager.ChequeStatus.CANCELED);
            logger.info("Cheque canceled: " + chequeNumber + " for account: " + accountNumber);
            System.out.println("Cheque " + chequeNumber + " for account " + accountNumber + " has been canceled.");
        } catch (Exception ex) {
            logger.error("Error canceling cheque " + chequeNumber + ": " + ex.getMessage());
            System.out.println("An error occurred while canceling the cheque.");
        }
    }
}