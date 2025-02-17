package org.example.Reflection.basiclevel.getclassinfo;

import java.lang.reflect.Constructor;
import java.util.Scanner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Accept class name from user
            System.out.print("Enter the fully qualified class name: ");
            String className = scanner.nextLine();

            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Display class name
            System.out.println("\nClass: " + clazz.getName());

            // Display constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

            // Display methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  " + method);
            }

            // Display fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found! Make sure to enter the correct class name.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
