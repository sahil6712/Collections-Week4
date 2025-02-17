package org.example.annotations.intermediatelevel.methodexecutiontime;

import java.lang.annotation.*;
        import java.lang.reflect.*;

// Step 1: Define the @LogExecutionTime Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for Reflection
@Target(ElementType.METHOD) // Can be applied to methods only
@interface LogExecutionTime {
}

// Step 2: Create a Class with Methods to be Logged
class Performance {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(500); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Create a Proxy to Intercept Method Calls and Log Execution Time
class PerformanceLogger {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        Class<?> clazz = target.getClass();
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                (proxy, method, args) -> {
                    Method originalMethod = clazz.getMethod(method.getName(), method.getParameterTypes());
                    if (originalMethod.isAnnotationPresent(LogExecutionTime.class)) {
                        long startTime = System.nanoTime();
                        Object result = method.invoke(target, args);
                        long endTime = System.nanoTime();
                        System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
                        return result;
                    }
                    return method.invoke(target, args);
                }
        );
    }
}

