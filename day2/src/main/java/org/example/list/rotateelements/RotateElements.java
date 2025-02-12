package org.example.list.rotateelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateElements {

    // Method to rotate the list
    public static <T> List<T> rotateList(List<T> list, int numberOfPos) {

        numberOfPos = numberOfPos%(list.size());   // If there are number of rotation greater then array size

        // iterate the list
        int i=0;
        while(i<numberOfPos) {
            list.add(list.size(),list.get(0));
            list.remove(0);
            i++;
        }
        return list;
    }
    public static void main(String[] args) {

        // Number of positions to rotate
        int numberOfPos = 2;

        // List
        List<Integer> list = new ArrayList<>(Arrays.asList(32,45,27,81,90,108,18));

        // Display the list
        System.out.println("List: "+list);

        // Call the method to get the rotated list
        rotateList(list, numberOfPos);

        // Display the rotated list
        System.out.println("Rotated List: "+list);


    }
}
