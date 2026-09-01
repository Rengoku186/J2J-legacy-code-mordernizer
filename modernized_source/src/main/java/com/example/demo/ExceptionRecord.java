package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionRecord {

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
        this.firDetails = null; // Initialize FIR details as null by default
    }

    public void addFIRDetails(String firNumber, String policeStation, Date firDate, String remarks) {
        this.firDetails = new FIRDetails(firNumber, policeStation, firDate, remarks);
    }

    public boolean hasFIRDetails() {
        return this.firDetails != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExceptionRecord{")
          .append("accountNumber='").append(accountNumber).append('\'')
          .append(", chequeNumber='").append(chequeNumber).append('\'')
          .append(", type='").append(type).append('\'')
          .append(", details='").append(details).append('\'')
          .append(", date=").append(date);
        if (firDetails != null) {
            sb.append(", firDetails=").append(firDetails);
        }
        sb.append('}');
        return sb.toString();
    }
}