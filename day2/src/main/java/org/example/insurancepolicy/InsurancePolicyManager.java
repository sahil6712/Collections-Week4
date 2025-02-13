package org.example.insurancepolicy;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private LinkedHashMap<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> expirySortedPolicies = new TreeMap<>();

    // Add a policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        expirySortedPolicies.put(policy.getExpiryDate(), policy);
    }

    // Retrieve a policy by policy number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring in the next 30 days
    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(30);

        for (Map.Entry<LocalDate, InsurancePolicy> entry : expirySortedPolicies.entrySet()) {
            if (!entry.getKey().isAfter(cutoffDate)) {
                expiringPolicies.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }

    // List policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String policyHolderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = expirySortedPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                String policyNumber = entry.getValue().getPolicyNumber();
                policyMap.remove(policyNumber);
                orderedPolicyMap.remove(policyNumber);
                iterator.remove();
            }
        }
    }

    // List all policies in insertion order
    public List<InsurancePolicy> getAllPolicies() {
        return new ArrayList<>(orderedPolicyMap.values());
    }
}
