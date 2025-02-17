package org.example.Reflection.intermediatelevel.retrieveannotations;

public class RetrieveAnnotation {
    public static void main(String[] args) {
        // Step 3: Retrieve the annotation using Reflection
        Class<MyClass> myClass = MyClass.class;

        // Check if the @Author annotation is present
        if (myClass.isAnnotationPresent(Author.class)) {
            // Get the annotation
            Author author = myClass.getAnnotation(Author.class);
            // Display annotation value
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}

