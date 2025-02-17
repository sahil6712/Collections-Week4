package org.example.annotations.advancedlevel.customcaching;


import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for Reflection
@Target(ElementType.METHOD) // Can be applied to methods only
@interface CacheResult {
}

// Step 2: Define an Interface for the Service
interface ServiceInterface {
    int computeSquare(int num);
}

// Step 3: Create a Service Implementing the Interface
class Service implements ServiceInterface {

    @CacheResult
    public int computeSquare(int num) {
        System.out.println("Computing square of " + num); // Simulate expensive computation
        return num * num;
    }
}

// Step 4: Implement a Dynamic Proxy to Handle Caching
class CacheProxyHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CacheProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + Arrays.toString(args); // Unique cache key

            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for " + Arrays.toString(args));
                return cache.get(key);
            }

            Object result = method.invoke(target, args); // Call actual method
            cache.put(key, result); // Store result in cache
            return result;
        }

        return method.invoke(target, args); // Call method normally if not annotated
    }
}

