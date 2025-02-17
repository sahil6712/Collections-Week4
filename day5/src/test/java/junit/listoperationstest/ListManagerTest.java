package junit.listoperationstest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        assertEquals(1, list.size(), "List size should be 1 after adding an element");
        assertTrue(list.contains(5), "List should contain the added element 5");
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        ListManager.removeElement(list, 5);
        assertEquals(1, list.size(), "List size should be 1 after removing an element");
        assertFalse(list.contains(5), "List should not contain removed element 5");
    }

    @Test
    void testRemoveElement_NotPresent() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        ListManager.removeElement(list, 5); // Trying to remove an element that is not present
        assertEquals(1, list.size(), "List size should remain unchanged when removing a non-existent element");
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list), "Size of empty list should be 0");
        list.add(1);
        list.add(2);
        assertEquals(2, ListManager.getSize(list), "Size should be 2 after adding two elements");
    }

    @Test
    void testNullListOperations() {
        assertDoesNotThrow(() -> ListManager.addElement(null, 5), "Adding to a null list should not throw an exception");
        assertDoesNotThrow(() -> ListManager.removeElement(null, 5), "Removing from a null list should not throw an exception");
        assertEquals(0, ListManager.getSize(null), "Size of a null list should be 0");
    }
}
