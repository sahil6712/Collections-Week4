package org.example.annotations.exercise3;
import java.util.ArrayList;

public class SuppressWarning {

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings for raw types
    public static void main(String[] args) {
        // Step 1: Create an ArrayList without generics (Raw Type)
        ArrayList list = new ArrayList();  // Warning without @SuppressWarnings

        // Step 2: Add elements (Compiler shows an unchecked warning)
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        // Step 3: Print the List
        System.out.println("List Contents: " + list);
    }
}
