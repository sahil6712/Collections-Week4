package junit.bankingtransactionstest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.junit.bankingtransactions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0); // Initialize with $100 balance
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    void testWithdraw_Success() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be updated after successful withdrawal");
    }

    @Test
    void testWithdraw_InsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testDeposit_NegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdraw_NegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    @Test
    void testInitialNegativeBalance_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BankAccount(-50.0));
        assertEquals("Initial balance cannot be negative", exception.getMessage());
    }
}
