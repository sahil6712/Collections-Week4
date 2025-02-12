package listtest;

import org.example.list.findnthfromlast.FindNthFromLast;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindNthFromLastTest {

    FindNthFromLast obj;
    static List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    @Test
    void testNthLast() {
        assertEquals(7,FindNthFromLast.findNthFromLast(ls,3));
    }
}
