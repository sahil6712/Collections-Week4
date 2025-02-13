package org.example.set.findsubsets;

import java.util.HashSet;

public class SubsetChecker {

    // Method to check if set1 is a subset of set2
    public static <T> boolean isSubset(HashSet<T> set1, HashSet<T> set2) {
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(java.util.Arrays.asList(2, 3));
        HashSet<Integer> set2 = new HashSet<>(java.util.Arrays.asList(1, 2, 3, 4));

        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
        // Output: true
    }
}

