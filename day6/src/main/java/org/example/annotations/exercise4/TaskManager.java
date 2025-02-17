package org.example.annotations.exercise4;


import java.lang.annotation.*;
        import java.lang.reflect.Method;

// Step 1: Define a Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD) // Can be applied to methods only
@interface TaskInfo {
    String priority();     // Field to store priority
    String assignedTo();   // Field to store assigned person
}

// Step 2: Apply the Annotation to a Method
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}
