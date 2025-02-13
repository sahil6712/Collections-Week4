package settest;

import org.example.set.settosortedlist.SetToSortedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class SetToSortedListTest {

    @Test
    void testConvertToSortedList() {
        HashSet<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> expectedSortedList = Arrays.asList(1, 3, 5, 9);
        List<Integer> actualSortedList = SetToSortedList.convertToSortedList(inputSet);

        assertEquals(expectedSortedList, actualSortedList, "Sorted list is incorrect");
    }
}
