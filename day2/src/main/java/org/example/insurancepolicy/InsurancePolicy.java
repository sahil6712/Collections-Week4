package org.example.insurancepolicy;

import java.time.LocalDate;

public class InsurancePolicy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", PolicyHolder: " + policyHolderName + ", ExpiryDate: " + expiryDate;
    }
}
