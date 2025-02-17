package org.example.Reflection.intermediatelevel.dynamicmethodinvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodInvoke {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Step 1: Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();
            Class<?> mathClass = mathOps.getClass();

            // Step 2: Take user input for method name
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Step 3: Get the method dynamically
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            // Step 4: Take user input for parameters
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Step 5: Invoke the method dynamically
            Object result = method.invoke(mathOps, num1, num2);

            // Display the result
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found! Please enter a valid method name.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}