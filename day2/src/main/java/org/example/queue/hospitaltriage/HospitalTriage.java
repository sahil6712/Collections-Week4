package org.example.queue.hospitaltriage;

import java.util.Comparator;
import java.util.PriorityQueue;

class HospitalTriage {
    public static void main(String[] args) {

        // Create patients object
        Patient p1 = new Patient("Sam",32);
        Patient p2 = new Patient("John",49);
        Patient p3 = new Patient("Lee",24);

        PriorityQueue<Patient> pq = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o2.severity-o1.severity;
            }
        });

        pq.add(p1);
        pq.add(p2);
        pq.add(p3);

        // Output
        for(Patient p:pq) {
            System.out.println(p.name+" "+p.severity);
        }
    }

}