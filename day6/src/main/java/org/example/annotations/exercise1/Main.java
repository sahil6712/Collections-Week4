package org.example.annotations.exercise1;

public class Main {
    // Step 3: Test the Method Override

    public static void main(String[] args) {
        Animal myDog = new Dog(); // Polymorphism
        myDog.makeSound(); // Calls the overridden method in Dog class
    }
}
