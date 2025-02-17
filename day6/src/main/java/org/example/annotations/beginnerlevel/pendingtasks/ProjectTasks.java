package org.example.annotations.beginnerlevel.pendingtasks;

import java.lang.annotation.*;
        import java.lang.reflect.Method;

// Step 1: Define the @Todo Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for Reflection
@Target(ElementType.METHOD) // Can be applied to methods only
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM"; // Default value
}

// Step 2: Apply the Annotation to Multiple Methods
class ProjectTasks {

    @Todo(task = "Implement login validation", assignedTo = "Alice", priority = "HIGH")
    public void validateLogin() {
        System.out.println("Validating user login...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void enhanceUI() {
        System.out.println("Enhancing UI...");
    }
}

