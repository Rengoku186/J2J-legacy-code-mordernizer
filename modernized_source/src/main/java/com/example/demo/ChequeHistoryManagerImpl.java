package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Implementation of the ChequeHistoryManager interface.
 */
@Service
public class ChequeHistoryManagerImpl implements ChequeHistoryManager {

    private final List<ChequeRecord> chequeRecords = new ArrayList<>();

    @Override
    public void recordCheque(String accountNumber, String chequeNumber, String currency, double amount, Date date) {
        ChequeRecord record = new ChequeRecord(accountNumber, chequeNumber, currency, amount, date);
        chequeRecords.add(record);
        System.out.println("Cheque recorded: " + record);
    }

    @Override
    public List<ChequeRecord> getChequeHistory(String accountNumber) {
        return chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isChequeDuplicate(String accountNumber, String chequeNumber) {
        return chequeRecords.stream()
                .anyMatch(record -> record.getAccountNumber().equals(accountNumber) && record.getChequeNumber().equals(chequeNumber));
    }

    @Override
    public double getAverageMonthlyFrequency(String accountNumber) {
        long count = chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .count();
        return count / 12.0; // Assuming 12 months in a year
    }

    @Override
    public List<ChequeRecord> getRecentTransactions(String accountNumber, int days) {
        Date currentDate = new Date();
        return chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .filter(record -> {
                    long diffInMillis = currentDate.getTime() - record.getDate().getTime();
                    long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
                    return diffInDays <= days;
                })
                .collect(Collectors.toList());
    }

    public List<ChequeRecord> getChequesByAccount(String accountNumber) {
        return chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());
    }

    public List<ChequeRecord> getChequesByDateRange(Date startDate, Date endDate) {
        return chequeRecords.stream()
                .filter(record -> !record.getDate().before(startDate) && !record.getDate().after(endDate))
                .collect(Collectors.toList());
    }

    public void generateReport(String accountNumber, Date startDate, Date endDate, String filePath) {
        List<ChequeRecord> filteredRecords = chequeRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber))
                .filter(record -> !record.getDate().before(startDate) && !record.getDate().after(endDate))
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Account Number,Cheque Number,Currency,Amount,Date\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (ChequeRecord record : filteredRecords) {
                writer.write(String.format("%s,%s,%s,%.2f,%s\n",
                        record.getAccountNumber(),
                        record.getChequeNumber(),
                        record.getCurrency(),
                        record.getAmount(),
                        dateFormat.format(record.getDate())));
            }
            System.out.println("Report generated successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error generating report: " + e.getMessage());
        }
    }
}