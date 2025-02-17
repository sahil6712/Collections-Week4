package org.example.intermediatelevel.staticfields;

import java.lang.reflect.Field;

public class Modification{
    public static void main(String[] args) {
        try {
            // Step 1: Get the Class object
            Class<?> configClass = Configuration.class;

            // Step 2: Get the private static field API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Step 3: Make the private field accessible
            apiKeyField.setAccessible(true);

            // Step 4: Modify the static field
            apiKeyField.set(null, "NEW_SECRET_KEY");

            // Step 5: Print the modified value
            Configuration.printKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
