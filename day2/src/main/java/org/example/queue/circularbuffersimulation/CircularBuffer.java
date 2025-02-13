package org.example.queue.circularbuffersimulation;

public class CircularBuffer {
    private final int[] buffer;
    private int head = 0; // Points to the oldest element
    private int tail = 0; // Points to the next insertion index
    private int size = 0; // Current number of elements
    private final int capacity; // Fixed size of the buffer

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public void enqueue(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite the oldest element
        }
    }

    public Integer dequeue() {
        if (size == 0) {
            return null; // Buffer is empty
        }
        int value = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    public Integer peek() {
        return (size == 0) ? null : buffer[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public int[] getBufferContents() {
        int[] contents = new int[size];
        for (int i = 0; i < size; i++) {
            contents[i] = buffer[(head + i) % capacity];
        }
        return contents;
    }


    private static void printBuffer(CircularBuffer buffer) {
        int[] contents = buffer.getBufferContents();
        System.out.print("Buffer: ");
        for (int num : contents) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        System.out.println("Adding 1, 2, 3...");
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        printBuffer(buffer);

        System.out.println("Adding 4 (overwrites 1)...");
        buffer.enqueue(4);
        printBuffer(buffer);

        System.out.println("Removing an element...");
        buffer.dequeue();
        printBuffer(buffer);

        System.out.println("Adding 5...");
        buffer.enqueue(5);
        printBuffer(buffer);

        System.out.println("Peeking: " + buffer.peek());
    }

}
