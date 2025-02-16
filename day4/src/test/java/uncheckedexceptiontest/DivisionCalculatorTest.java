package uncheckedexceptiontest;

import org.example.uncheckedexception.DivisionCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisionCalculatorTest {

    @Test
    void testValidDivision() {
        assertEquals("Result: 5", DivisionCalculator.divideNumbers(10, 2));
    }

    @Test
    void testDivisionByZero() {
        assertEquals("Cannot divide by zero", DivisionCalculator.divideNumbers(10, 0));
    }
}
