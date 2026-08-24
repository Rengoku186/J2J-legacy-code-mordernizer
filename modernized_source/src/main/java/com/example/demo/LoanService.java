package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
@Setter
public class LoanService {

    private Map<String, Loan> loans = new HashMap<>();
    private int sequence = 1;

    public void initializeDefaultLoans() {
        // Adding two default loans for demonstration purposes
        Loan loan1 = new Loan("L001", "user1", 10000.0, 5.0);
        loan1.setOutstanding(loan1.getPrincipal() + (loan1.getPrincipal() * loan1.getInterestRate() / 100));
        loan1.setStatus("OPEN");
        loans.put(loan1.getLoanId(), loan1);

        Loan loan2 = new Loan("L002", "user2", 20000.0, 6.5);
        loan2.setOutstanding(loan2.getPrincipal() + (loan2.getPrincipal() * loan2.getInterestRate() / 100));
        loan2.setStatus("OPEN");
        loans.put(loan2.getLoanId(), loan2);
    }

    public Loan createLoan(String customerId, double principal, double rate) {
        // Generate a unique loan ID
        String loanId = "L" + String.format("%03d", sequence++);
        // Create a new loan
        Loan loan = new Loan(loanId, customerId, principal, rate);
        loan.setOutstanding(principal + (principal * rate / 100));
        loan.setStatus("OPEN");
        // Add the loan to the map
        loans.put(loanId, loan);
        return loan;
    }

    public Loan getLoan(String loanId) {
        // Retrieve the loan by its ID
        return loans.get(loanId);
    }

    public boolean payLoan(String loanId, double amount) {
        // Retrieve the loan
        Loan loan = loans.get(loanId);
        if (loan == null || !"OPEN".equals(loan.getStatus())) {
            return false; // Loan not found or already closed
        }
        // Process the payment
        double outstanding = loan.getOutstanding();
        if (amount >= outstanding) {
            loan.setOutstanding(0.0);
            loan.setStatus("CLOSED");
        } else {
            loan.setOutstanding(outstanding - amount);
        }
        return true;
    }

    public List<Loan> getAllLoans() {
        // Return all loans as a list
        return new ArrayList<>(loans.values());
    }
}