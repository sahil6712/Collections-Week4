package queuetest;

import org.example.queue.reverse.ReverseQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class ReverseQueueTest {

    @Test
    void testReverse() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> expected = new LinkedList<>(Arrays.asList(30, 20, 10));

        assertEquals(expected, ReverseQueue.reverse(queue), "Queue reversal is incorrect");
    }
}
