package org.example.banksystem;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adding accounts
        bank.addAccount(101, 5000);
        bank.addAccount(102, 3000);
        bank.addAccount(103, 7000);

        // Depositing money
        bank.deposit(102, 2000);

        // Withdrawing money (queued)
        bank.withdraw(101, 1000);
        bank.withdraw(103, 500);

        // Process withdrawals
        bank.processWithdrawals();

        // Display accounts and balances
        System.out.println("Accounts: " + bank.getAccounts());
        System.out.println("Sorted Accounts: " + bank.getSortedAccounts());
    }
}
