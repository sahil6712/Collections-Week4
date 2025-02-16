package org.example.junit.testingcalculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {

        // Two inputs
        int a = 10;
        int b = 5;

        // Create the object of the class
        Calculator calc = new Calculator();

        // Perform operations
        System.out.println("Addition: "+calc.add(a,b));
        System.out.println("Subtraction: "+calc.subtract(a,b));
        System.out.println("Multiplication: "+calc.multiply(a,b));
        System.out.println("Division: "+calc.divide(a,b));
    }
}