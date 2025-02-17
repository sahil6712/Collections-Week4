package org.example.annotations.exercise2;

// Step 3: Test the Deprecated Method
public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Call the deprecated method (will show a warning)
        api.oldFeature();

        // Call the new method (recommended usage)
        api.newFeature();
    }
}