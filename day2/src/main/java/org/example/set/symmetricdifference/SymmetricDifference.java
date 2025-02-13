package org.example.set.symmetricdifference;

import java.util.HashSet;

public class SymmetricDifference {

    // Method to find the symmetric difference of sets
    public static <T> HashSet<T> findSymmetricDifference(HashSet<T> set1, HashSet<T> set2) {
        HashSet<T> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2); // Union of both sets

        HashSet<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Intersection of both sets

        symmetricDiff.removeAll(intersection); // Removing common elements

        return symmetricDiff;
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(java.util.Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(java.util.Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference of " + set1 + " and " + set2);
        System.out.println(findSymmetricDifference(set1, set2)); // Output: {1, 2, 4, 5}
    }
}
