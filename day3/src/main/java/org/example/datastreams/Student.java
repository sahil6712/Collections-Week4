package org.example.datastreams;

import java.io.*;

public class Student implements Serializable {
    private int rollNumber;
    private String name;
    private double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void saveToFile(String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student readFromFile(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            return new Student(rollNumber, name, gpa);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

