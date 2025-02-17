package org.example.annotations.beginnerlevel.markimportantmethods;

import java.lang.reflect.Method;


public class AnnotationExample {
    public static void main(String[] args) {
        // Get the class
        Class<TaskHandler> clazz = TaskHandler.class;

        // Iterate through all methods
        for (Method method : clazz.getDeclaredMethods()) {
            // Check if @ImportantMethod is present
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " | Level: " + annotation.level());
            }
        }
    }
}