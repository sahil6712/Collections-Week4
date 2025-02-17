package org.example.Reflection.advancedlevel.dependencyinjection;


public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();

        // Get an instance of UserService with injected dependencies
        UserService userService = container.getInstance(UserService.class);

        // Call the method to check if injection worked
        userService.serve();
    }
}