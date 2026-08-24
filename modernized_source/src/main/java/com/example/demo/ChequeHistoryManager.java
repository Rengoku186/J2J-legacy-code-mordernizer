package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChequeHistoryManager {

    private final List<ChequeRecord> chequeRecords = new ArrayList<>();

    public static class ChequeRecord {
        private final String accountNumber;
        private final String chequeNumber;
        private final String currency;
        private final double amount;
        private final LocalDate date;

        public ChequeRecord(String accountNumber, String chequeNumber, String currency, double amount, LocalDate date) {
            this.accountNumber = accountNumber;
            this.chequeNumber = chequeNumber;
            this.currency = currency;
            this.amount = amount;
            this.date = date;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getChequeNumber() {
            return chequeNumber;
        }

        public String getCurrency() {
            return currency;
        }

        public double getAmount() {
            return amount;
        }

        public LocalDate getDate() {
            return date;
        }
    }

    public void recordCheque(String accountNumber, String chequeNumber, String currency, double amount, LocalDate date) {
        ChequeRecord record = new ChequeRecord(accountNumber, chequeNumber, currency, amount, date);
        chequeRecords.add(record);
    }

    public void displayChequeHistory(String accountNumber) {
        List<ChequeRecord> accountRecords = chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());

        if (accountRecords.isEmpty()) {
            System.out.println("No cheque history found for account: " + accountNumber);
        } else {
            System.out.println("Cheque history for account: " + accountNumber);
            for (ChequeRecord record : accountRecords) {
                System.out.printf("Cheque Number: %s, Currency: %s, Amount: %.2f, Date: %s%n",
                        record.getChequeNumber(), record.getCurrency(), record.getAmount(), record.getDate());
            }
        }
    }

    public List<String> getChequeNumbers(String accountNumber) {
        return chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .map(ChequeRecord::getChequeNumber)
                .collect(Collectors.toList());
    }

    public int getTotalChequeCount(String accountNumber) {
        return (int) chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .count();
    }

    public int getRecentChequeCount(String accountNumber) {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        return (int) chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber) && record.getDate().isAfter(sevenDaysAgo))
                .count();
    }

    public boolean hasSimilarRecentCheque(String accountNumber, double amount, double threshold) {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        return chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber) && record.getDate().isAfter(sevenDaysAgo))
                .anyMatch(record -> Math.abs(record.getAmount() - amount) / amount <= threshold);
    }

    public List<ChequeRecord> getAllChequeRecordsInPeriod(LocalDate startDate, LocalDate endDate) {
        return chequeRecords.stream()
                .filter(record -> !record.getDate().isBefore(startDate) && !record.getDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

    public String generateChequeReportCSV(List<ChequeRecord> records) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("Account Number,Cheque Number,Currency,Amount,Date\n");
        for (ChequeRecord record : records) {
            csvBuilder.append(String.format("%s,%s,%s,%.2f,%s%n",
                    record.getAccountNumber(),
                    record.getChequeNumber(),
                    record.getCurrency(),
                    record.getAmount(),
                    record.getDate()));
        }
        return csvBuilder.toString();
    }
}