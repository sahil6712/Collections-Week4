package org.example.banksystem;

import java.util.*;

public class Bank {
    private final HashMap<Integer, Double> accounts; // AccountNumber -> Balance
    private final TreeMap<Double, List<Integer>> sortedAccounts; // Balance -> AccountNumbers
    private final Queue<WithdrawalRequest> withdrawalQueue;

    public Bank() {
        this.accounts = new HashMap<>();
        this.sortedAccounts = new TreeMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber) || amount <= 0) return;
        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;

        updateSortedAccounts(accountNumber, oldBalance, newBalance);
        accounts.put(accountNumber, newBalance);
    }

    public void withdraw(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber) || amount <= 0) return;
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.getAccountNumber();
            double amount = request.getAmount();

            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                double oldBalance = accounts.get(accountNumber);
                double newBalance = oldBalance - amount;

                updateSortedAccounts(accountNumber, oldBalance, newBalance);
                accounts.put(accountNumber, newBalance);
            }
        }
    }

    private void updateSortedAccounts(int accountNumber, double oldBalance, double newBalance) {
        sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
        if (sortedAccounts.get(oldBalance).isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }
        sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public Map<Integer, Double> getAccounts() {
        return accounts;
    }

    public TreeMap<Double, List<Integer>> getSortedAccounts() {
        return sortedAccounts;
    }
}

