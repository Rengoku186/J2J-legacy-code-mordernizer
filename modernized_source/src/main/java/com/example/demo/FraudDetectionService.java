package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FraudDetectionService {

    private static final int VELOCITY_CHECK_DAYS = 7;
    private static final int VELOCITY_THRESHOLD = 5;
    private static final double PATTERN_THRESHOLD = 0.9;
    private static final double SIMILAR_AMOUNT_THRESHOLD = 0.95;
    private static final double UNUSUAL_FREQUENCY_THRESHOLD = 2.0;

    private final Map<String, List<ChequeTransaction>> transactionHistory = new HashMap<>();

    public boolean isFraudulentCheque(String accountId, String chequeNumber, double amount) {
        boolean[] fraudChecks = new boolean[8];

        fraudChecks[0] = checkDuplicateCheque(accountId, chequeNumber);
        fraudChecks[1] = checkAbnormalAmount(accountId, amount);
        fraudChecks[2] = checkSuspiciousActivity(accountId, amount);
        fraudChecks[3] = checkVelocityFraud(accountId);
        fraudChecks[4] = checkPatternFraud(accountId);
        fraudChecks[5] = checkHistoricalDuplicate(accountId, chequeNumber);
        fraudChecks[6] = checkUnusualFrequency(accountId);
        fraudChecks[7] = checkSimilarToRecent(accountId, amount);

        String alertLevel = determineAlertLevel(fraudChecks);
        logFraudChecks(accountId, chequeNumber, fraudChecks);

        return !alertLevel.equals("LOW");
    }

    private boolean checkDuplicateCheque(String accountId, String chequeNumber) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        return transactions.stream().anyMatch(tx -> tx.getChequeNumber().equals(chequeNumber));
    }

    private boolean checkAbnormalAmount(String accountId, double amount) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        if (transactions.isEmpty()) return false;

        double average = transactions.stream().mapToDouble(ChequeTransaction::getAmount).average().orElse(0);
        double standardDeviation = Math.sqrt(transactions.stream()
                .mapToDouble(tx -> Math.pow(tx.getAmount() - average, 2))
                .average()
                .orElse(0));

        return amount > average + 3 * standardDeviation || amount < average - 3 * standardDeviation;
    }

    private boolean checkSuspiciousActivity(String accountId, double amount) {
        return amount > 100000; // Example threshold for suspicious activity
    }

    private boolean checkVelocityFraud(String accountId) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        Date now = new Date();
        long count = transactions.stream()
                .filter(tx -> (now.getTime() - tx.getDate().getTime()) <= VELOCITY_CHECK_DAYS * 24 * 60 * 60 * 1000L)
                .count();
        return count > VELOCITY_THRESHOLD;
    }

    private boolean checkPatternFraud(String accountId) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        if (transactions.size() < 3) return false;

        for (int i = 0; i < transactions.size() - 2; i++) {
            double amount1 = transactions.get(i).getAmount();
            double amount2 = transactions.get(i + 1).getAmount();
            double amount3 = transactions.get(i + 2).getAmount();

            if (isSimilar(amount1, amount2) && isSimilar(amount2, amount3)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHistoricalDuplicate(String accountId, String chequeNumber) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        return transactions.stream().anyMatch(tx -> tx.getChequeNumber().equals(chequeNumber));
    }

    private boolean checkUnusualFrequency(String accountId) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        if (transactions.isEmpty()) return false;

        Map<Integer, Long> monthlyCounts = transactions.stream()
                .collect(Collectors.groupingBy(tx -> tx.getDate().getMonth(), Collectors.counting()));

        double averageFrequency = monthlyCounts.values().stream().mapToLong(Long::longValue).average().orElse(0);
        long currentMonthCount = monthlyCounts.getOrDefault(new Date().getMonth(), 0L);

        return currentMonthCount > UNUSUAL_FREQUENCY_THRESHOLD * averageFrequency;
    }

    private boolean checkSimilarToRecent(String accountId, double amount) {
        List<ChequeTransaction> transactions = transactionHistory.getOrDefault(accountId, new ArrayList<>());
        if (transactions.isEmpty()) return false;

        return transactions.stream()
                .mapToDouble(ChequeTransaction::getAmount)
                .anyMatch(txAmount -> isSimilar(txAmount, amount));
    }

    private boolean isSimilar(double amount1, double amount2) {
        double ratio = Math.min(amount1, amount2) / Math.max(amount1, amount2);
        return ratio >= SIMILAR_AMOUNT_THRESHOLD;
    }

    private String determineAlertLevel(boolean[] fraudChecks) {
        int score = 0;
        for (boolean check : fraudChecks) {
            if (check) score++;
        }

        if (score >= 5) return "CRITICAL";
        if (score >= 3) return "HIGH";
        if (score >= 1) return "MEDIUM";
        return "LOW";
    }

    private void logFraudChecks(String accountId, String chequeNumber, boolean[] fraudChecks) {
        System.out.println("Fraud checks for account: " + accountId + ", cheque: " + chequeNumber);
        System.out.println("Duplicate Cheque: " + fraudChecks[0]);
        System.out.println("Abnormal Amount: " + fraudChecks[1]);
        System.out.println("Suspicious Activity: " + fraudChecks[2]);
        System.out.println("Velocity Fraud: " + fraudChecks[3]);
        System.out.println("Pattern Fraud: " + fraudChecks[4]);
        System.out.println("Historical Duplicate: " + fraudChecks[5]);
        System.out.println("Unusual Frequency: " + fraudChecks[6]);
        System.out.println("Similar to Recent Transactions: " + fraudChecks[7]);
    }

    private static class ChequeTransaction {
        private final String chequeNumber;
        private final double amount;
        private final Date date;

        public ChequeTransaction(String chequeNumber, double amount, Date date) {
            this.chequeNumber = chequeNumber;
            this.amount = amount;
            this.date = date;
        }

        public String getChequeNumber() {
            return chequeNumber;
        }

        public double getAmount() {
            return amount;
        }

        public Date getDate() {
            return date;
        }
    }
}