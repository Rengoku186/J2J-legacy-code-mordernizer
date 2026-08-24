package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FraudDetectionService {

    private static final int VELOCITY_CHECK_DAYS = 7;
    private static final int VELOCITY_THRESHOLD = 5;
    private static final double PATTERN_THRESHOLD = 0.95;
    private static final double SIMILAR_AMOUNT_THRESHOLD = 0.90;
    private static final int UNUSUAL_FREQUENCY_THRESHOLD = 3;

    private final ChequeHistoryManager historyManager;
    private final Map<String, List<ChequeTransaction>> recentTransactions;

    public FraudDetectionService(ChequeHistoryManager historyManager) {
        this.historyManager = historyManager;
        this.recentTransactions = new HashMap<>();
    }

    public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount) {
        boolean isDuplicate = checkDuplicateCheque(accountId, chequeNumber);
        boolean isAbnormal = checkAbnormalAmount(amount);
        boolean isSuspicious = checkSuspiciousActivity(accountId, amount);
        boolean isVelocityFraud = checkVelocityFraud(accountId, amount);
        boolean isPatternFraud = checkPatternFraud(accountId, amount);

        boolean isHistoricalDuplicate = false;
        boolean isUnusualFrequency = false;
        boolean isSimilarToRecent = false;

        if (historyManager != null) {
            isHistoricalDuplicate = checkHistoricalDuplicate(accountId, chequeNumber);
            isUnusualFrequency = checkUnusualFrequency(accountId);
            isSimilarToRecent = checkSimilarToRecent(accountId, amount);
        }

        logFraudChecks(accountId, chequeNumber, amount, isDuplicate, isAbnormal, isSuspicious, isVelocityFraud, isPatternFraud, isHistoricalDuplicate, isUnusualFrequency, isSimilarToRecent);

        AlertLevel alertLevel = determineAlertLevel(isDuplicate, isAbnormal, isSuspicious, isVelocityFraud, isPatternFraud, isHistoricalDuplicate, isUnusualFrequency, isSimilarToRecent);

        log.info("Fraud Alert Level: {}", alertLevel);

        return isDuplicate || isAbnormal || isSuspicious || isVelocityFraud || isPatternFraud || isHistoricalDuplicate || isUnusualFrequency || isSimilarToRecent;
    }

    private boolean checkDuplicateCheque(String accountId, String chequeNumber) {
        List<String> chequeNumbers = historyManager.getChequeNumbers(accountId);
        return chequeNumbers != null && chequeNumbers.contains(chequeNumber);
    }

    private boolean checkAbnormalAmount(double amount) {
        return amount > 50000; // Example threshold for abnormal amount
    }

    private boolean checkSuspiciousActivity(String accountId, double amount) {
        int recentCount = historyManager.getRecentChequeCount(accountId);
        return recentCount > 10 && amount > 10000; // Example logic for suspicious activity
    }

    private boolean checkVelocityFraud(String accountId, double amount) {
        List<ChequeTransaction> transactions = recentTransactions.getOrDefault(accountId, new ArrayList<>());
        LocalDate cutoffDate = LocalDate.now().minusDays(VELOCITY_CHECK_DAYS);
        long recentCount = transactions.stream().filter(tx -> tx.getDate().isAfter(cutoffDate)).count();
        return recentCount > VELOCITY_THRESHOLD;
    }

    private boolean checkPatternFraud(String accountId, double amount) {
        List<ChequeTransaction> transactions = recentTransactions.getOrDefault(accountId, new ArrayList<>());
        long similarCount = transactions.stream().filter(tx -> Math.abs(tx.getAmount() - amount) / amount <= PATTERN_THRESHOLD).count();
        return similarCount >= 3;
    }

    private boolean checkHistoricalDuplicate(String accountId, String chequeNumber) {
        List<String> chequeNumbers = historyManager.getChequeNumbers(accountId);
        return chequeNumbers != null && chequeNumbers.contains(chequeNumber);
    }

    private boolean checkUnusualFrequency(String accountId) {
        int totalCheques = historyManager.getTotalChequeCount(accountId);
        int recentCheques = historyManager.getRecentChequeCount(accountId);
        if (totalCheques < 10) return false;
        double averageMonthlyFrequency = totalCheques / 3.0;
        return recentCheques > averageMonthlyFrequency * UNUSUAL_FREQUENCY_THRESHOLD;
    }

    private boolean checkSimilarToRecent(String accountId, double amount) {
        return historyManager.hasSimilarRecentCheque(accountId, amount, SIMILAR_AMOUNT_THRESHOLD);
    }

    private AlertLevel determineAlertLevel(boolean isDuplicate, boolean isAbnormal, boolean isSuspicious, boolean isVelocityFraud, boolean isPatternFraud, boolean isHistoricalDuplicate, boolean isUnusualFrequency, boolean isSimilarToRecent) {
        int fraudCount = 0;
        if (isDuplicate || isHistoricalDuplicate) fraudCount += 3;
        if (isAbnormal || isSuspicious || isVelocityFraud || isPatternFraud) fraudCount += 2;
        if (isUnusualFrequency || isSimilarToRecent) fraudCount += 1;

        if (fraudCount >= 8) return AlertLevel.CRITICAL;
        if (fraudCount >= 5) return AlertLevel.HIGH;
        if (fraudCount >= 3) return AlertLevel.MEDIUM;
        return AlertLevel.LOW;
    }

    private void logFraudChecks(String accountId, String chequeNumber, double amount, boolean isDuplicate, boolean isAbnormal, boolean isSuspicious, boolean isVelocityFraud, boolean isPatternFraud, boolean isHistoricalDuplicate, boolean isUnusualFrequency, boolean isSimilarToRecent) {
        log.info("Fraud Check Results for Account: {}, Cheque: {}, Amount: {}", accountId, chequeNumber, amount);
        log.info("Duplicate Check: {}", formatCheckResult(isDuplicate));
        log.info("Abnormal Amount Check: {}", formatCheckResult(isAbnormal));
        log.info("Suspicious Activity Check: {}", formatCheckResult(isSuspicious));
        log.info("Velocity Fraud Check: {}", formatCheckResult(isVelocityFraud));
        log.info("Pattern Fraud Check: {}", formatCheckResult(isPatternFraud));
        log.info("Historical Duplicate Check: {}", formatCheckResult(isHistoricalDuplicate));
        log.info("Unusual Frequency Check: {}", formatCheckResult(isUnusualFrequency));
        log.info("Similar to Recent Check: {}", formatCheckResult(isSimilarToRecent));
    }

    private String formatCheckResult(boolean failed) {
        return failed ? "FAILED ⚠️" : "Passed ✓";
    }

    private static class ChequeTransaction {
        private final double amount;
        private final LocalDate date;

        public ChequeTransaction(double amount, LocalDate date) {
            this.amount = amount;
            this.date = date;
        }

        public double getAmount() {
            return amount;
        }

        public LocalDate getDate() {
            return date;
        }
    }

    public enum AlertLevel {
        LOW, MEDIUM, HIGH, CRITICAL
    }
}