package org.example.datastreams;

public class Main {
    public static void main(String[] args) {
        String filename = "student_data.bin";
        Student student = new Student(101, "John Doe", 3.8);
        student.saveToFile(filename);

        Student retrievedStudent = Student.readFromFile(filename);
        if (retrievedStudent != null) {
            System.out.println("Student Details Retrieved:");
            System.out.println("Roll Number: " + retrievedStudent.getRollNumber());
            System.out.println("Name: " + retrievedStudent.getName());
            System.out.println("GPA: " + retrievedStudent.getGpa());
        }
    }
}
