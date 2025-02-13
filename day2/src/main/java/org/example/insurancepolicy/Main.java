package org.example.insurancepolicy;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        Scanner scanner = new Scanner(System.in);

        // Adding sample policies
        manager.addPolicy(new InsurancePolicy("P1001", "John Doe", LocalDate.now().plusDays(10)));
        manager.addPolicy(new InsurancePolicy("P1002", "Alice Smith", LocalDate.now().plusDays(40)));
        manager.addPolicy(new InsurancePolicy("P1003", "Bob Johnson", LocalDate.now().plusDays(5)));
        manager.addPolicy(new InsurancePolicy("P1004", "John Doe", LocalDate.now().minusDays(1))); // Expired policy

        while (true) {
            System.out.println("\nInsurance Policy Management System");
            System.out.println("1. Add a new policy");
            System.out.println("2. View a policy by number");
            System.out.println("3. List policies expiring soon");
            System.out.println("4. List policies by holder");
            System.out.println("5. Remove expired policies");
            System.out.println("6. View all policies");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter policy number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter policy holder name: ");
                    String holderName = scanner.nextLine();
                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

                    manager.addPolicy(new InsurancePolicy(policyNumber, holderName, expiryDate));
                    System.out.println("Policy added successfully!");
                    break;

                case 2:
                    System.out.print("Enter policy number: ");
                    String searchNumber = scanner.nextLine();
                    InsurancePolicy policy = manager.getPolicyByNumber(searchNumber);
                    System.out.println(policy != null ? policy : "Policy not found.");
                    break;

                case 3:
                    List<InsurancePolicy> expiringPolicies = manager.getPoliciesExpiringSoon();
                    System.out.println("Policies expiring soon:");
                    expiringPolicies.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter policy holder name: ");
                    String searchHolder = scanner.nextLine();
                    List<InsurancePolicy> holderPolicies = manager.getPoliciesByHolder(searchHolder);
                    System.out.println("Policies for " + searchHolder + ":");
                    holderPolicies.forEach(System.out::println);
                    break;

                case 5:
                    manager.removeExpiredPolicies();
                    System.out.println("Expired policies removed.");
                    break;

                case 6:
                    System.out.println("All policies:");
                    manager.getAllPolicies().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}