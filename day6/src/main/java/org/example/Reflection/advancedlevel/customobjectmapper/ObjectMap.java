package org.example.Reflection.advancedlevel.customobjectmapper;

import java.lang.reflect.Field;
import java.util.Map;

class ObjectMap {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Step 1: Create an instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Step 2: Iterate through the map and set field values
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    // Get the field by name
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow access to private fields

                    // Set the field value
                    field.set(obj, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Sample class for testing
class Person {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}


