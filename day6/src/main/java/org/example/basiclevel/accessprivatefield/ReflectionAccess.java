package org.example.basiclevel.accessprivatefield;

import java.lang.reflect.Field;

public class ReflectionAccess {
    public static void main(String[] args) {
        try {
            // Step 1: Create an object of Person
            Person person = new Person(25);
            person.showAge(); // Display initial age

            // Step 2: Get the Class object
            Class<?> personClass = person.getClass();

            // Step 3: Get the private field "age"
            Field ageField = personClass.getDeclaredField("age");

            // Step 4: Make the private field accessible
            ageField.setAccessible(true);

            // Step 5: Modify the private field
            ageField.set(person, 30);

            // Step 6: Retrieve the modified value
            int modifiedAge = (int) ageField.get(person);

            // Display the modified age
            System.out.println("Modified Age: " + modifiedAge);
            person.showAge(); // Verify change in object

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

