package throwthrowstest;

import org.example.throwthrows.InterestCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InterestCalculatorTest {

    @Test
    void testValidInterestCalculation() {
        assertEquals(100.0, InterestCalculator.calculateInterest(1000, 5, 2));
    }

    @Test
    void testNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                InterestCalculator.calculateInterest(-1000, 5, 2)
        );
        assertEquals("Invalid input: Amount and rate must be positive", exception.getMessage());
    }

    @Test
    void testNegativeRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                InterestCalculator.calculateInterest(1000, -5, 2)
        );
        assertEquals("Invalid input: Amount and rate must be positive", exception.getMessage());
    }
}
