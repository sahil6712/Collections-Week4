package ListTest;

import org.example.list.rotateelements.RotateElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateElementsTest {
    static List<Integer> ls = new ArrayList<>();

    @BeforeAll
    static void setup() {
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);
        ls.add(1);
        ls.add(2);
    }

    @Test
    void rotateTest() {

        assertEquals(RotateElements.rotateList(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)),2), ls);
    }

}
