package org.example.set.settosortedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SetToSortedList {

    // Method to convert a Set to a sorted List
    public static List<Integer> convertToSortedList(HashSet<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // Sorting in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        HashSet<Integer> inputSet = new HashSet<>(java.util.Arrays.asList(5, 3, 9, 1));

        System.out.println("Sorted List: " + convertToSortedList(inputSet));
        // Output: [1, 3, 5, 9]
    }
}
