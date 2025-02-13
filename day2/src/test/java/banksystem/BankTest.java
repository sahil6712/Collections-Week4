package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.example.banksystem.Bank;

public class BankTest {
    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        bank.addAccount(101, 5000);
        bank.deposit(101, 1000);
        assertEquals(6000, bank.getAccounts().get(101));
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        bank.addAccount(101, 5000);
        bank.withdraw(101, 1000);
        bank.processWithdrawals();
        assertEquals(4000, bank.getAccounts().get(101));
    }

    @Test
    public void testSortingByBalance() {
        Bank bank = new Bank();
        bank.addAccount(101, 5000);
        bank.addAccount(102, 3000);
        bank.addAccount(103, 7000);

        TreeMap<Double, List<Integer>> sorted = bank.getSortedAccounts();
        assertEquals(Arrays.asList(102), sorted.get(3000.0));
        assertEquals(Arrays.asList(101), sorted.get(5000.0));
        assertEquals(Arrays.asList(103), sorted.get(7000.0));
    }
}
