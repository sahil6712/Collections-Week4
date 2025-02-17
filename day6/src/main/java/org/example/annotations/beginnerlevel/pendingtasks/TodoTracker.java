package org.example.annotations.beginnerlevel.pendingtasks;

import java.lang.reflect.Method;

public class TodoTracker {
    public static void main(String[] args) {
        Class<org.example.annotations.beginnerlevel.pendingtasks.ProjectTasks> clazz = ProjectTasks.class;

        // Iterate through all methods in ProjectTasks class
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("---------------------------------");
            }
        }
    }
}
