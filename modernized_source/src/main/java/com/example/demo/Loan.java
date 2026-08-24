package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loan {

    private String loanId;
    private String customerId;
    private double principal;
    private double interestRate;
    private double outstanding;
    private String status;

    public Loan(String loanId, String customerId, double principal, double interestRate) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.principal = principal;
        this.interestRate = interestRate;
        this.outstanding = calculateOutstanding(principal, interestRate);
        this.status = "OPEN";
    }

    public String getLoanId() {
        return loanId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public String getStatus() {
        return status;
    }

    public boolean pay(double amount) {
        if (amount <= 0 || amount > outstanding) {
            return false;
        }
        outstanding -= amount;
        if (outstanding <= 0) {
            outstanding = 0;
            status = "CLOSED";
        }
        return true;
    }

    private double calculateOutstanding(double principal, double interestRate) {
        return principal + (principal * interestRate / 100);
    }
}