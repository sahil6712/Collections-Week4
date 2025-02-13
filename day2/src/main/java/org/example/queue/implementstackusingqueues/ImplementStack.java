package org.example.queue.implementstackusingqueues;

public class ImplementStack {
    public static void main(String[] args) {

        // Create the object of the stack
        Stack s = new Stack();

        // Add elements of the stack
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(1);
        s.add(2);
        s.add(3);

        // Remove the elements
        s.pop();

        System.out.println("Peek of the stack is: "+s.peek());

        // Display the data of the stack
        while (s.peek() != -1) {
            System.out.println(s.pop());
        }
    }
}
