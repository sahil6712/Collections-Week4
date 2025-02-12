package ListTest;

import org.example.list.reverselist.ReverseList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseListTest {

    ReverseList list;
    static LinkedList<Integer> list1 = new LinkedList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

    @BeforeAll
    static void addElement() {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);

    }


    @Test
    void testReverse() {
        assertEquals(Arrays.asList(3,2,1),list.reverse(list2));
    }

    @Test
    void testReverseLinkedList() {
        assertEquals(Arrays.asList(3,2,1),list.reverseLinkedList(list1));
    }
}
