package org.example.annotations.exercise2;

// Step 1: Define a class with a deprecated method
class LegacyAPI {

    @Deprecated // Marks this method as outdated
    public void oldFeature() {
        System.out.println("Warning: oldFeature() is deprecated. Use newFeature() instead.");
    }

    // Step 2: Introduce a new method as a replacement
    public void newFeature() {
        System.out.println("newFeature() is the recommended method to use.");
    }
}


