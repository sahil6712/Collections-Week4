package org.example.Reflection.advancedlevel.methodexecutiontiming;


import java.lang.reflect.Method;

// Step 1: Define a sample class with methods to be measured
class MathOp {
    public int add(int a, int b) {
        return a + b;
    }

    public void slowMethod() {
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 2: Utility class to measure method execution time
class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName, Object... args) {
        try {
            // Get method with matching name and parameters
            Method method = null;
            for (Method m : obj.getClass().getDeclaredMethods()) {
                if (m.getName().equals(methodName) && m.getParameterCount() == args.length) {
                    method = m;
                    break;
                }
            }

            if (method == null) {
                System.out.println("Method not found!");
                return;
            }

            method.setAccessible(true);

            // Measure execution time
            long startTime = System.nanoTime();
            Object result = method.invoke(obj, args);
            long endTime = System.nanoTime();

            // Print method execution time
            System.out.println("Method: " + methodName + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Print result if method returns a value
            if (method.getReturnType() != void.class) {
                System.out.println("Result: " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

