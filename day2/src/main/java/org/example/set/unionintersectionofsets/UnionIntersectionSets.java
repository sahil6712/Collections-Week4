package org.example.set.unionintersectionofsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UnionIntersectionSets {

    // Method to get the intersectio  of sets
    public static  <T> ArrayList<T> findIntersection(HashSet<T> set1, HashSet<T> set2) {
        ArrayList<T> list = new ArrayList<>();

        // Iterate the set
        for(T ele:set1) {
            if(set2.contains(ele)) {
                list.add(ele);   // Add common element in the list
            }
        }

        return list;
    }

    // Method to get the intersection of two sets
    public static <T> HashSet<T> findUnion(HashSet<T> set1, HashSet<T> set2) {

        HashSet<T> union = new HashSet<>();
        // Iterate the set1
        for(T ele:set1) {
            union.add(ele);
        }

        // Iterate the set2
        for(T ele:set2) {
            union.add(ele);
        }
        return union;
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(3,2,6,7,1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1,2,3,4,5));

        System.out.println("Intesection of "+set1+" and "+set2);
        System.out.println(findIntersection(set1,set2));

        System.out.println("Union of "+set1+" and "+set2);
        System.out.println(findUnion(set1,set2));
    }
}
