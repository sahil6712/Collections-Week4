package org.example.basiclevel.dynamicallycreateobject;

import java.lang.reflect.Constructor;

public class CreateObject {
    public static void main(String[] args) {
        try {
            // Step 1: Get the Class object
            Class<?> studentClass = Class.forName("Student");

            // Step 2: Create an instance using the default constructor
            Object defaultStudent = studentClass.getDeclaredConstructor().newInstance();
            System.out.print("Default Constructor: ");
            ((Student) defaultStudent).display();

            // Step 3: Create an instance using the parameterized constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
            Object paramStudent = constructor.newInstance("Alice", 22);

            System.out.print("Parameterized Constructor: ");
            ((Student) paramStudent).display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
