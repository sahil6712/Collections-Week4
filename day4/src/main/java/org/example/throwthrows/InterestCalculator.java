package org.example.throwthrows;

public class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Interest: " + calculateInterest(1000, 5, 2)); // Valid case
            System.out.println("Interest: " + calculateInterest(-1000, 5, 2)); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
