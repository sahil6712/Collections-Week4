package junit.exceptionhandlingtest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.exceptionhandling.ExceptionHandling;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testValidDivision() {
        assertEquals(2, ExceptionHandling.divide(10, 5), "10 / 5 should be 2");
        assertEquals(-3, ExceptionHandling.divide(9, -3), "9 / -3 should be -3");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> ExceptionHandling.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage(), "Exception message should match");
    }
}
