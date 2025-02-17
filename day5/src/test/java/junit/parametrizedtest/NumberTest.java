package junit.parametrizedtest;

import org.example.junit.parametrizedtest.ParameterizedTest;
import org.example.junit.parametrizedtest.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})  // Even numbers
    void testIsEven_WithEvenNumbers(int number) {
        assertTrue(Number.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})  // Odd numbers
    void testIsEven_WithOddNumbers(int number) {
        assertFalse(Number.isEven(number), number + " should be odd");
    }
}

