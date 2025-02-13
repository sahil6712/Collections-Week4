package queuetest;

import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;
import org.example.queue.hospitaltriage.Patient;

class HospitalTriageTest {

    @Test
    void testPatientPriorityQueueOrder() {
        // Create patients
        Patient p1 = new Patient("Sam", 32);
        Patient p2 = new Patient("John", 49);
        Patient p3 = new Patient("Lee", 24);

        // PriorityQueue with custom comparator
        PriorityQueue<Patient> pq = new PriorityQueue<>((o1, o2) -> o2.severity - o1.severity);

        // Add patients to queue
        pq.add(p1);
        pq.add(p2);
        pq.add(p3);

        // Test if highest severity comes first
        assertEquals(p2, pq.poll()); // John (49) should be dequeued first
        assertEquals(p1, pq.poll()); // Sam (32) should be next
        assertEquals(p3, pq.poll()); // Lee (24) should be last
    }

    @Test
    void testEmptyPriorityQueue() {
        PriorityQueue<Patient> pq = new PriorityQueue<>((o1, o2) -> o2.severity - o1.severity);

        // Ensure the queue is empty
        assertTrue(pq.isEmpty());

        // Polling from an empty queue should return null
        assertNull(pq.poll());
    }

    @Test
    void testAddAndCheckSize() {
        PriorityQueue<Patient> pq = new PriorityQueue<>((o1, o2) -> o2.severity - o1.severity);

        // Add patients
        pq.add(new Patient("Anna", 40));
        pq.add(new Patient("Mike", 20));

        // Ensure size is 2
        assertEquals(2, pq.size());
    }
}
