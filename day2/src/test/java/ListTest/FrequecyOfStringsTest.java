package ListTest;

import org.example.list.frequencyofelements.FrequencyOfStrings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequecyOfStringsTest {
    static String[] str = {"Ram", "Ram", "Krishna","Krishna","Ramkrishn"};
    static HashMap<String, Integer> hs = new HashMap<>();
    @BeforeAll
    static void setup() {
        hs.put(str[0],2);
        hs.put(str[2],2);
        hs.put(str[4],1);
    }

    @Test
    void frequencyFinderTest() {
        assertEquals(hs, FrequencyOfStrings.frequencyFinder(str));
    }
}
