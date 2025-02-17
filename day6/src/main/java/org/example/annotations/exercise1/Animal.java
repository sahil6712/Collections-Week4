package org.example.annotations.exercise1;

// Step 1: Define the Parent Class (Animal)
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

// Step 2: Create a Child Class (Dog) that Overrides makeSound()
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof woof!");
    }
}

