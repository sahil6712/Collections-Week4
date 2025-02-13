package org.example.queue.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

    // Using queue to implement stack
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // Method to add element to the stack

    public void add(Integer data) {
        queue2.offer(data);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // Swap the queues
        Queue<Integer> q = queue1;
        queue1 = queue2;
        queue2 = q;
    }

    // Method to pop the element

    public int pop() {
        if(queue1.isEmpty()) {
            return -1;
        }
        return queue1.poll();

    }

    // Method to get the top element
    public int peek() {
        if(queue1.isEmpty()) {
            return -1;
        }
        return queue1.peek();
    }
}
