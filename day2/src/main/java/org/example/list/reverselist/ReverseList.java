package org.example.list.reverselist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    // Method to reverse using a LinkedList
    public static <T> List<T> reverseLinkedList(LinkedList<T> list) {

        // Iterating the list
        for(int i=0; i<(list.size()/2); i++) {

            // Swapping logic
            T temp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,temp);
        }
        return list;
    }

    // Method to reverse a list using list
    public static <T> List<T> reverse(ArrayList<T> list) {

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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        LinkedList<Float> list2 = new LinkedList<>();
        list2.add(1.1f);
        list2.add(2.2f);
        list2.add(3.3f);
        list2.add(4.4f);
        list2.add(5.5f);

        // Call the method to reverse the Arraylist
        reverse(list);

        // Display the list
        System.out.println("Reverse Arraylist is: ");
        System.out.println(list);

        // Call the method to reverse a LinkedList
        reverseLinkedList(list2);

        // Display 2nd list
        System.out.println("The reverse of Linked list is: ");
        System.out.println(list2);


    }
}
