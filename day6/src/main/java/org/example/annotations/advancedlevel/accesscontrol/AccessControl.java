package org.example.annotations.advancedlevel.accesscontrol;

import java.lang.annotation.*;
        import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for Reflection
@Target(ElementType.METHOD) // Can be applied to methods only
@interface RoleAllowed {
    String[] value(); // Allowed roles
}



// Step 3: Simulate User Roles and Check Access Control
class AccessControl {
    private final String currentUserRole;

    public AccessControl(String currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    public void invokeMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            // Check if method has @RoleAllowed annotation
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                // Check if current user has permission
                for (String role : roleAllowed.value()) {
                    if (role.equals(currentUserRole)) {
                        method.invoke(obj);
                        return;
                    }
                }
                System.out.println("Access Denied! You do not have permission to execute " + methodName);
            } else {
                method.invoke(obj); // If no annotation, execute normally
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


