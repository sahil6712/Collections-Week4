package org.example.junit.exceptionhandling;

public class ExceptionHandling{

    // Division method that throws ArithmeticException when dividing by zero
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

