package nestedtrycatchtest;

import org.example.nestedtrycatch.NestedTryCatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NestedTryCatchTest {

    @Test
    void testValidDivision() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals("Result: 6", NestedTryCatch.divideElement(arr, 2, 5));
    }

    @Test
    void testInvalidIndex() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals("Invalid array index!", NestedTryCatch.divideElement(arr, 10, 5));
    }

    @Test
    void testDivisionByZero() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals("Cannot divide by zero!", NestedTryCatch.divideElement(arr, 2, 0));
    }
}
