package serializationtest;

import org.example.serialization.Employee;
import org.example.serialization.EmployeeDeserializer;
import org.example.serialization.EmployeeSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private static final String FILE_NAME = "employees.ser";
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        // Create a list of employees before each test
        employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 75000));
        employees.add(new Employee(103, "Charlie", "Finance", 65000));
    }

    @Test
    void testSerialization() {
        EmployeeSerializer.serializeEmployees(employees);
        File file = new File(FILE_NAME);
        assertTrue(file.exists(), "File should be created after serialization");
    }

    @Test
    void testDeserialization() {
        EmployeeSerializer.serializeEmployees(employees); // Ensure data is written
        List<Employee> deserializedEmployees = EmployeeDeserializer.deserializeEmployees();

        assertNotNull(deserializedEmployees, "Deserialized employee list should not be null");
        assertEquals(3, deserializedEmployees.size(), "There should be 3 employees in the list");

        // Checking first employee details
        Employee emp = deserializedEmployees.get(0);
        assertEquals(101, emp.getId(), "Employee ID should match");
        assertEquals("Alice", emp.getName(), "Employee name should match");
        assertEquals("HR", emp.getDepartment(), "Department should match");
        assertEquals(50000, emp.getSalary(), "Salary should match");
    }

}
