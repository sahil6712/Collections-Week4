package org.example.banktransactionsystem;

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        try {
            System.out.println(account.withdraw(500)); // Valid withdrawal
            System.out.println(account.withdraw(600)); // Should throw InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
