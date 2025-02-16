package exceptionpropagationtest;

import org.example.exceptionpropagation.ExceptionPropagation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionPropagationTest {

    @Test
    void testExceptionPropagation() {
        Exception exception = assertThrows(ArithmeticException.class, ExceptionPropagation::method2);
        assertEquals("Division by zero", exception.getMessage());
    }
}
