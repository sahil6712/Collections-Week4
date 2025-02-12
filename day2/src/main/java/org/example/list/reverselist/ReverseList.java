package org.example.list.reverselist;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {

    // Method to reverse a list
    public static <T> List<T> reverse(List<T> list) {

        // Iterating the list
        for(int i=0; i<(list.size()/2); i++) {

            // Swapping logic
            T temp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,temp);
        }
        return list;
    }
    public static void main(String[] args) {

        // List to store the elements
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        // Call the method to reverse the list
        reverse(list);

        // Display the list
        System.out.println("Reverse list is: ");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
