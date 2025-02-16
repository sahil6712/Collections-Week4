package org.example.uncheckedexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionCalculator {
    public static String divideNumbers(int numerator, int denominator) {
        try {
            return "Result: " + (numerator / denominator);
        } catch (ArithmeticException e) {
            return "Cannot divide by zero";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            System.out.println(divideNumbers(numerator, denominator));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
