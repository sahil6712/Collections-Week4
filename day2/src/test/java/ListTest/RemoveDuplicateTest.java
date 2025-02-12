package ListTest;

import org.example.list.removeduplicates.RemoveDuplicates;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateTest {

    static List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,1,2,3,11,1,1,2,4));
    static List<Integer> expected = new ArrayList<>();


    @BeforeAll
    static void findExpextedResult() {
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(11);
        expected.add(4);

    }

    @Test
    void testRemoveDuplicate() {
        assertEquals(expected, RemoveDuplicates.removeDuplicates(ls));
    }
}
