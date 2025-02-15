package org.example.finallyblock;

import java.util.Scanner;

public class FinallyBlock {
    public static String performDivision(int numerator, int denominator) {
        try {
            int result = numerator / denominator;
            return "Result: " + result;
        } catch (ArithmeticException e) {
            return "Cannot divide by zero";
        } finally {
            System.out.println("Operation completed");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int numerator = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();

        System.out.println(performDivision(numerator, denominator));
        scanner.close();
    }
}

