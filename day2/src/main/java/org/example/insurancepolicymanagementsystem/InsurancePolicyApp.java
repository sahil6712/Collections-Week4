package org.example.insurancepolicymanagementsystem;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class InsurancePolicyApp {
    public static void main(String[] args) {
        PolicyManager policyManager = new PolicyManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Insurance Policy Management System ---");
            System.out.println("1. Add Policy");
            System.out.println("2. View All Policies");
            System.out.println("3. View Policies Expiring Soon");
            System.out.println("4. View Policies by Coverage Type");
            System.out.println("5. View Duplicate Policies");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addPolicy(policyManager, scanner);
                    break;
                case 2:
                    displayPolicies("All Policies", policyManager.getAllPolicies());
                    break;
                case 3:
                    displayPolicies("Policies Expiring Soon", policyManager.getPoliciesExpiringSoon());
                    break;
                case 4:
                    System.out.print("Enter coverage type (Health, Auto, Home): ");
                    String coverageType = scanner.nextLine();
                    displayPolicies("Policies with Coverage Type: " + coverageType, policyManager.getPoliciesByCoverageType(coverageType));
                    break;
                case 5:
                    displayPolicies("Duplicate Policies", policyManager.getDuplicatePolicies());
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private static void addPolicy(PolicyManager policyManager, Scanner scanner) {
        System.out.print("Enter Policy Number: ");
        String policyNumber = scanner.nextLine();
        System.out.print("Enter Policyholder Name: ");
        String policyholderName = scanner.nextLine();
        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        LocalDate expiryDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Coverage Type (Health, Auto, Home): ");
        String coverageType = scanner.nextLine();
        System.out.print("Enter Premium Amount: ");
        double premiumAmount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Policy policy = new Policy(policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
        policyManager.addPolicy(policy);
        System.out.println("Policy added successfully!");
    }

    private static void displayPolicies(String title, Set<Policy> policies) {
        System.out.println("\n--- " + title + " ---");
        if (policies.isEmpty()) {
            System.out.println("No policies found.");
        } else {
            for (Policy policy : policies) {
                System.out.println(policy);
            }
        }
    }
}
