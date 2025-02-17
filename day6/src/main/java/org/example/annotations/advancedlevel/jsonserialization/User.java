package org.example.annotations.advancedlevel.jsonserialization;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for Reflection
@Target(ElementType.FIELD) // Can be applied to fields only
@interface JsonField {
    String name(); // Custom JSON key name
}

// Step 2: Create the User Class with Annotated Fields
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // Not annotated, should not be included in JSON

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

// Step 3: Create a JSON Serializer Using Reflection
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // Access private fields

                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    String jsonKey = annotation.name();
                    String jsonValue = field.get(obj).toString();
                    jsonMap.put(jsonKey, jsonValue);
                }
            }

            // Convert map to JSON string format
            StringBuilder jsonString = new StringBuilder("{");
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                jsonString.append("\"").append(entry.getKey()).append("\": \"")
                        .append(entry.getValue()).append("\", ");
            }

            // Remove trailing comma and space, then close JSON
            if (jsonString.length() > 1) {
                jsonString.setLength(jsonString.length() - 2);
            }
            jsonString.append("}");

            return jsonString.toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error during JSON serialization", e);
        }
    }
}


