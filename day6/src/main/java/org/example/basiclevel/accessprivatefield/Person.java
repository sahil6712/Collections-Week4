package org.example.basiclevel.accessprivatefield;

import java.lang.reflect.Field;

class Person {
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }

    // Method to display age
    public void showAge() {
        System.out.println("Age: " + age);
    }
}

