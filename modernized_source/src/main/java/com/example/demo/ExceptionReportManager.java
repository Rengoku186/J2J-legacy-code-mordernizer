package com.example.demo;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ExceptionReportManager {

    private final List<ExceptionRecord> exceptions = new ArrayList<>();

    public void reportException(String accountNumber, String chequeNumber, String type, String details) {
        try {
            ExceptionRecord exceptionRecord = new ExceptionRecord(accountNumber, chequeNumber, type, details, new Date());
            exceptions.add(exceptionRecord);
            log.info("Exception reported: Account: {}, Cheque: {}, Type: {}, Details: {}", accountNumber, chequeNumber, type, details);
        } catch (Exception e) {
            log.error("Error while reporting exception: {}", e.getMessage());
        }
    }

    public boolean recordFIRDetails(String accountNumber, String chequeNumber, String firNumber, String policeStation, Date firDate, String remarks) {
        try {
            for (ExceptionRecord exception : exceptions) {
                if (exception.getAccountNumber().equals(accountNumber) && exception.getChequeNumber().equals(chequeNumber) && "Bounced".equalsIgnoreCase(exception.getType())) {
                    FIRDetails firDetails = new FIRDetails(firNumber, policeStation, firDate, remarks);
                    exception.setFirDetails(firDetails);
                    log.info("FIR details recorded for Account: {}, Cheque: {}", accountNumber, chequeNumber);
                    return true;
                }
            }
            log.warn("No matching bounced cheque found for Account: {}, Cheque: {}", accountNumber, chequeNumber);
        } catch (Exception e) {
            log.error("Error while recording FIR details: {}", e.getMessage());
        }
        return false;
    }

    public void displayExceptions() {
        if (exceptions.isEmpty()) {
            log.info("No exceptions reported.");
            System.out.println("No exceptions reported.");
            return;
        }

        for (ExceptionRecord exception : exceptions) {
            System.out.println("Account: " + exception.getAccountNumber());
            System.out.println("Cheque: " + exception.getChequeNumber());
            System.out.println("Type: " + exception.getType());
            System.out.println("Details: " + exception.getDetails());
            System.out.println("Date: " + exception.getDate());
            if ("Bounced".equalsIgnoreCase(exception.getType()) && exception.getFirDetails() != null) {
                FIRDetails firDetails = exception.getFirDetails();
                System.out.println("FIR Number: " + firDetails.getFirNumber());
                System.out.println("Police Station: " + firDetails.getPoliceStation());
                System.out.println("FIR Date: " + firDetails.getFirDate());
                System.out.println("Remarks: " + firDetails.getRemarks());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    public static class ExceptionRecord {
        private final String accountNumber;
        private final String chequeNumber;
        private final String type;
        private final String details;
        private final Date date;
        private FIRDetails firDetails;

        public ExceptionRecord(String accountNumber, String chequeNumber, String type, String details, Date date) {
            this.accountNumber = accountNumber;
            this.chequeNumber = chequeNumber;
            this.type = type;
            this.details = details;
            this.date = date;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getChequeNumber() {
            return chequeNumber;
        }

        public String getType() {
            return type;
        }

        public String getDetails() {
            return details;
        }

        public Date getDate() {
            return date;
        }

        public FIRDetails getFirDetails() {
            return firDetails;
        }

        public void setFirDetails(FIRDetails firDetails) {
            this.firDetails = firDetails;
        }
    }

    public static class FIRDetails {
        private final String firNumber;
        private final String policeStation;
        private final Date firDate;
        private final String remarks;

        public FIRDetails(String firNumber, String policeStation, Date firDate, String remarks) {
            this.firNumber = firNumber;
            this.policeStation = policeStation;
            this.firDate = firDate;
            this.remarks = remarks;
        }

        public String getFirNumber() {
            return firNumber;
        }

        public String getPoliceStation() {
            return policeStation;
        }

        public Date getFirDate() {
            return firDate;
        }

        public String getRemarks() {
            return remarks;
        }
    }
}