package org.example.annotations.intermediatelevel.methodexecutiontime;

import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws Exception {
        Performance test = new Performance();

        // Measure execution time manually using Reflection
        for (Method method : test.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(test);
                long end = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (end - start) / 1_000_000.0 + " ms");
                System.out.println("--------------------------------");
            }
        }
    }
}
