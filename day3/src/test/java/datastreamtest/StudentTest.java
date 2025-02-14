package datastreamtest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.datastreams.Student;
import org.junit.jupiter.api.Test;
import java.io.File;

class StudentTest {
    @Test
    void testSaveAndReadStudent() {
        String filename = "student_data.bin";
        Student student = new Student(101, "John Doe", 3.8);
        student.saveToFile(filename);

        Student retrievedStudent = Student.readFromFile(filename);
        assertNotNull(retrievedStudent);
        assertEquals(101, retrievedStudent.getRollNumber());
        assertEquals("John Doe", retrievedStudent.getName());
        assertEquals(3.8, retrievedStudent.getGpa(), 0.01);

        // Cleanup
        new File(filename).delete();
    }
}