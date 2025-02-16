package banktransactionsystemtest;

import org.example.banktransactionsystem.BankAccount;
import org.example.banktransactionsystem.InsufficientBalanceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testValidWithdrawal() throws InsufficientBalanceException {
        BankAccount account = new BankAccount(1000);
        assertEquals("Withdrawal successful, new balance: 500.0", account.withdraw(500));
    }

    @Test
    void testInsufficientBalance() {
        BankAccount account = new BankAccount(1000);
        Exception exception = assertThrows(InsufficientBalanceException.class, () -> account.withdraw(1500));
        assertEquals("Insufficient balance!", exception.getMessage());
    }

    @Test
    void testNegativeAmount() {
        BankAccount account = new BankAccount(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
        assertEquals("Invalid amount!", exception.getMessage());
    }
}
