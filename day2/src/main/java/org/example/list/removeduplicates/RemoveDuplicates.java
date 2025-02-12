package org.example.list.removeduplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {

    // Method to remove the duplicates while also preserving the order
    public static <T> List<T> removeDuplicates(List<T> list) {
        LinkedHashSet<T> lhs = new LinkedHashSet<>();

        for(int i=0; i<list.size(); i++) {
            if(lhs.contains(list.get(i))) {
                list.remove(i); // Remove elements form the array
                i--;
            }
            lhs.add(list.get(i));  // adding element to linkedHashSet
        }

        return list;
    }
public static void main(String[] args) {

    // List
    List<String> ls = new ArrayList<>(Arrays.asList("Sahil", "Sahil","Rahil","Char","Char","Coal"));

    System.out.println("List: "+ls+"\n");

    // Call the method to get the list
    removeDuplicates(ls);

    // Output
    System.out.println("list without the duplicates: "+ls);
}
}
