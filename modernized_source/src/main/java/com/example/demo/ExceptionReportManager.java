package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ExceptionReportManager {

    private final List<ExceptionRecord> exceptionRecords = new ArrayList<>();

    @Data
    public static class ExceptionRecord {
        private String accountNumber;
        private String chequeNumber;
        private String type;
        private String details;
        private Date date;
        private FIRDetails firDetails;

        public ExceptionRecord(String accountNumber, String chequeNumber, String type, String details, Date date) {
            this.accountNumber = accountNumber;
            this.chequeNumber = chequeNumber;
            this.type = type;
            this.details = details;
            this.date = date;
        }
    }

    @Data
    public static class FIRDetails {
        private String firNumber;
        private String policeStation;
        private Date firDate;
        private String remarks;

        public FIRDetails(String firNumber, String policeStation, Date firDate, String remarks) {
            this.firNumber = firNumber;
            this.policeStation = policeStation;
            this.firDate = firDate;
            this.remarks = remarks;
        }
    }

    public void reportException(String accountNumber, String chequeNumber, String type, String details) {
        ExceptionRecord exceptionRecord = new ExceptionRecord(accountNumber, chequeNumber, type, details, new Date());
        exceptionRecords.add(exceptionRecord);
        System.out.println("Exception reported: " + exceptionRecord);
    }

    public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks) {
        Optional<ExceptionRecord> recordOptional = exceptionRecords.stream()
                .filter(record -> record.getAccountNumber().equals(accountNumber)
                        && record.getChequeNumber().equals(chequeNumber)
                        && "Bounced".equalsIgnoreCase(record.getType()))
                .findFirst();

        if (recordOptional.isPresent()) {
            ExceptionRecord record = recordOptional.get();
            FIRDetails firDetails = new FIRDetails(firNumber, policeStation, firDate, remarks);
            record.setFirDetails(firDetails);
            System.out.println("FIR details recorded for cheque: " + chequeNumber);
            return true;
        } else {
            System.out.println("No matching bounced cheque found for FIR recording.");
            return false;
        }
    }

    public void displayExceptions() {
        if (exceptionRecords.isEmpty()) {
            System.out.println("No exceptions recorded.");
            return;
        }

        System.out.println("--- Exception Records ---");
        for (ExceptionRecord record : exceptionRecords) {
            System.out.println("Account Number: " + record.getAccountNumber());
            System.out.println("Cheque Number: " + record.getChequeNumber());
            System.out.println("Type: " + record.getType());
            System.out.println("Details: " + record.getDetails());
            System.out.println("Date: " + record.getDate());
            if ("Bounced".equalsIgnoreCase(record.getType()) && record.getFirDetails() != null) {
                FIRDetails firDetails = record.getFirDetails();
                System.out.println("  FIR Number: " + firDetails.getFirNumber());
                System.out.println("  Police Station: " + firDetails.getPoliceStation());
                System.out.println("  FIR Date: " + firDetails.getFirDate());
                System.out.println("  Remarks: " + firDetails.getRemarks());
            }
            System.out.println("-------------------------");
        }
    }
}