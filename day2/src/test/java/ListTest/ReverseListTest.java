package ListTest;

import org.example.list.reverselist.ReverseList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseListTest {

    ReverseList list;

    @Test
    void testReverse() {
        assertEquals(Arrays.asList(1,2,3,4,5,6),list.reverse(Arrays.asList(6,5,4,3,2,1)));
    }
}
