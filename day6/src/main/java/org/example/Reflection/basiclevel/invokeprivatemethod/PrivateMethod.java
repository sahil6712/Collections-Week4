package org.example.Reflection.basiclevel.invokeprivatemethod;

import java.lang.reflect.Method;

public class PrivateMethod {
    public static void main(String[] args) {
        try {
            // Step 1: Create an object of Calculator
            Calculator calculator = new Calculator();

            // Step 2: Get the Class object
            Class<?> calculatorClass = calculator.getClass();

            // Step 3: Get the private method "multiply"
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            // Step 4: Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Step 5: Invoke the private method
            int result = (int) multiplyMethod.invoke(calculator, 6, 7);

            // Display the result
            System.out.println("Result of multiply(6, 7): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

