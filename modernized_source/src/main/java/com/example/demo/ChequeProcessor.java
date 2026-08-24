package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void processCheque(String accountNumber, String chequeNumber, String currency, double amount, String signature) {
        try {
            // Step 1: Check and set cheque status
            ChequeStatus currentStatus = chequeStatusManager.getStatus(accountNumber, chequeNumber);
            if (currentStatus == null) {
                chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.ISSUED);
            } else if (currentStatus == ChequeStatus.PROCESSED) {
                System.out.println("Cheque already processed.");
                return;
            }

            // Step 2: Verify signature
            boolean isSignatureValid = signatureVerificationService.verifySignature(accountNumber, signature);
            if (!isSignatureValid) {
                String errorDetails = "Signature verification failed for cheque: " + chequeNumber;
                exceptionReportManager.reportException(accountNumber, chequeNumber, "SignatureError", errorDetails);
                emailNotificationService.sendErrorNotification(accountNumber, errorDetails);
                return;
            }

            // Step 3: Fraud detection
            boolean isFraudulent = fraudDetectionService.isFraudulentCheque(accountNumber, chequeNumber, amount);
            if (isFraudulent) {
                String fraudDetails = "Fraud detected for cheque: " + chequeNumber;
                exceptionReportManager.reportException(accountNumber, chequeNumber, "FraudDetection", fraudDetails);
                emailNotificationService.sendFraudAlert(accountNumber, fraudDetails);
                return;
            }

            // Step 4: Simulate bounced cheque for high amounts
            if (amount > 50000) {
                String errorDetails = "Cheque bounced due to insufficient funds for amount: " + amount;
                exceptionReportManager.reportException(accountNumber, chequeNumber, "BouncedCheque", errorDetails);
                emailNotificationService.sendErrorNotification(accountNumber, errorDetails);
                return;
            }

            // Step 5: Simulate delayed cheque for specific cheque numbers
            if (chequeNumber.endsWith("9")) {
                String delayDetails = "Cheque processing delayed for cheque: " + chequeNumber;
                exceptionReportManager.reportException(accountNumber, chequeNumber, "DelayedCheque", delayDetails);
                System.out.println(delayDetails);
            }

            // Step 6: Currency conversion
            double amountInLocalCurrency = amount;
            if (!"USD".equalsIgnoreCase(currency)) {
                double exchangeRate = currencyExchangeService.getExchangeRate(currency);
                if (exchangeRate <= 0) {
                    String errorDetails = "Failed to fetch exchange rate for currency: " + currency;
                    exceptionReportManager.reportException(accountNumber, chequeNumber, "CurrencyConversionError", errorDetails);
                    emailNotificationService.sendErrorNotification(accountNumber, errorDetails);
                    return;
                }
                amountInLocalCurrency = amount * exchangeRate;
                System.out.println("Converted " + amount + " " + currency + " to " + amountInLocalCurrency + " USD.");
            }

            // Step 7: Update core banking system
            coreBankingSystemUpdater.updateCoreBankingSystem(accountNumber, amountInLocalCurrency);

            // Step 8: Record cheque in history
            chequeHistoryManager.recordCheque(accountNumber, chequeNumber, currency, amount, java.time.LocalDate.now());

            // Step 9: Update cheque status
            chequeStatusManager.setStatus(accountNumber, chequeNumber, ChequeStatus.PROCESSED);

            // Step 10: Notify success
            System.out.println("Cheque processed successfully: " + chequeNumber);

        } catch (Exception e) {
            String errorDetails = "Error processing cheque: " + chequeNumber + ". Details: " + e.getMessage();
            exceptionReportManager.reportException(accountNumber, chequeNumber, "ProcessingError", errorDetails);
            emailNotificationService.sendErrorNotification(accountNumber, errorDetails);
            e.printStackTrace();
        }
    }
}