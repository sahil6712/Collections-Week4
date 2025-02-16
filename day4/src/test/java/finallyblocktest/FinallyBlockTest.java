package finallyblocktest;

import org.example.finallyblock.FinallyBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinallyBlockTest {

    @Test
    void testValidDivision() {
        assertEquals("Result: 5", FinallyBlock.performDivision(10, 2));
    }

    @Test
    void testDivisionByZero() {
        assertEquals("Cannot divide by zero", FinallyBlock.performDivision(10, 0));
    }
}
