package org.example.advancedlevel.dependencyinjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// Step 2: Define Repository Class
class UserRepository {
    public void fetchData() {
        System.out.println("Fetching user data from the database...");
    }
}

// Step 3: Define Service Class that depends on UserRepository
class UserService {
    @Inject // Mark this field for Dependency Injection
    private UserRepository userRepository;

    public void serve() {
        userRepository.fetchData();
        System.out.println("UserService is processing data...");
    }
}

// Step 4: Implement Dependency Injection Container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    // Method to get or create an instance of a class
    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        // Create a new instance
        T instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);

        // Inject dependencies
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> dependencyType = field.getType();
                Object dependency = getInstance(dependencyType); // Recursively get the dependency

                field.setAccessible(true);
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}


