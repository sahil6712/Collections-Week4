package queuetest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.queue.circularbuffersimulation.CircularBuffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularBufferTest {
    private CircularBuffer buffer;

    @BeforeEach
    void setUp() {
        buffer = new CircularBuffer(3);
    }

    @Test
    void testEnqueueAndPeek() {
        buffer.enqueue(1);
        assertEquals(1, buffer.peek());

        buffer.enqueue(2);
        assertEquals(1, buffer.peek());
    }

    @Test
    void testEnqueueOverwrite() {
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4); // Overwrites 1

        assertArrayEquals(new int[]{2, 3, 4}, buffer.getBufferContents());
    }

    @Test
    void testDequeue() {
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        assertEquals(1, buffer.dequeue());
        assertEquals(2, buffer.peek());

        assertEquals(2, buffer.dequeue());
        assertEquals(3, buffer.peek());

        assertEquals(3, buffer.dequeue());
        assertNull(buffer.dequeue()); // Empty buffer should return null
    }

    @Test
    void testIsEmptyAndIsFull() {
        assertTrue(buffer.isEmpty());

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        assertTrue(buffer.isFull());

        buffer.dequeue();
        assertFalse(buffer.isFull());
        assertFalse(buffer.isEmpty());
    }
}
