package org.example.Reflection.advancedlevel.generatejson;
import java.lang.reflect.Field;
class JSON {
    public static String toJson(Object obj) {
        if (obj == null) return "null";

        StringBuilder json = new StringBuilder("{");
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Allow access to private fields

            try {
                Object value = field.get(obj);
                json.append("\"").append(field.getName()).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\""); // Quote Strings
                } else {
                    json.append(value); // Numbers, Booleans, etc.
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json.append("}");
        return json.toString();
    }
}

// Sample class for testing
class Person {
    private String name;
    private int age;
    private boolean isStudent;

    public Person(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }
}

