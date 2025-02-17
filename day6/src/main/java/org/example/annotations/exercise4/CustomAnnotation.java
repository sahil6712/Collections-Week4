package org.example.annotations.exercise4;

import java.lang.reflect.Method;

public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        // Get the TaskManager class
        Class<TaskManager> taskManagerClass = TaskManager.class;

        // Get the method with annotation
        Method method = taskManagerClass.getMethod("completeTask");

        // Check if the annotation is present
        if (method.isAnnotationPresent(TaskInfo.class)) {
            // Retrieve the annotation
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            // Display annotation details
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}