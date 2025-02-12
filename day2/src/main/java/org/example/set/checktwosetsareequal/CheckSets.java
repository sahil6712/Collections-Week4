package org.example.set.checktwosetsareequal;

import java.util.Arrays;
import java.util.HashSet;

public class CheckSets {

    // Method to check are two hashset contains same element
    public static <T> boolean findSetsEqual(HashSet<T> set1, HashSet<T> set2) {
        if(set1.size() != set2.size()) {
            return false;
        }
        for(T ele:set1) {
            if(!set2.contains(ele)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        set1.addAll(Arrays.asList(1,2,3));
        set2.addAll(Arrays.asList(1,2,3));

        // call method to get the output
        if(findSetsEqual(set1, set2)) {
            System.out.println("Both the sets are equal: ");
        }
        else {
            System.out.println("Both the sets are different: ");
        }

    }
}
