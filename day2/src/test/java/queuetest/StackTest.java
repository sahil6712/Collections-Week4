package queuetest;

import org.junit.jupiter.api.Test;
import org.example.queue.implementstackusingqueues.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    @Test
    void testPushAndPeek() {
        Stack stack = new Stack();
        stack.add(10);
        stack.add(20);
        stack.add(30);

        assertEquals(30, stack.peek(), "Top of the stack should be 30");
    }

    @Test
    void testPop() {
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        assertEquals(3, stack.pop(), "Popped element should be 3");
        assertEquals(2, stack.pop(), "Popped element should be 2");
        assertEquals(1, stack.pop(), "Popped element should be 1");
    }

    @Test
    void testPopEmptyStack() {
        Stack stack = new Stack();
        assertEquals(-1, stack.pop(), "Popping from an empty stack should return -1");
    }

    @Test
    void testPeekEmptyStack() {
        Stack stack = new Stack();
        assertEquals(-1, stack.peek(), "Peeking into an empty stack should return -1");
    }

    @Test
    void testStackOrder() {
        Stack stack = new Stack();
        stack.add(5);
        stack.add(10);
        stack.add(15);

        assertEquals(15, stack.pop(), "First pop should return 15");
        assertEquals(10, stack.pop(), "Second pop should return 10");
        assertEquals(5, stack.pop(), "Third pop should return 5");
        assertEquals(-1, stack.pop(), "Stack should be empty now, return -1");
    }
}

