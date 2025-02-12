package org.example.list.findnthfromlast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FindNthFromLast {

    // Method to get nth last element without using size of the list
    public static <T> T findNthFromLast(List<T> list, int n) {

        // Iterators
        Iterator<T> itr1 = list.iterator();
        Iterator<T> itr2 = list.iterator();

        int i = 0; // Variable used to keep the distance between itr1 and itr2 of length n
        while(i<n) {
            itr2.next();
            i++;
        }
        int j =0; // to store the final nth index from the last
        while(itr2.hasNext()) {
            itr2.next();
            itr1.next();
            j++;
        }

        return  list.get(j);  //  Return the nth last element
    }

    public static void main(String[] args) {

        // list
        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int nth = 3; // nth is the position from the last where we need to get the element

        // Call the method to get the nth last element
        System.out.println("The element is: "+findNthFromLast(ls,nth));

    }
}
