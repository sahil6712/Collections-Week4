package maptest;

import org.example.map.groupemployee.Department;
import org.example.map.groupemployee.Employee;
import org.example.map.groupemployee.EmployeeGrouping;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class EmployeeGroupingTest {

    @Test
    void testGroupByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR)
        );

        Map<Department, List<Employee>> grouped = EmployeeGrouping.groupByDepartment(employees);

        assertEquals(2, grouped.get(Department.HR).size());
        assertEquals(1, grouped.get(Department.IT).size());
        assertTrue(grouped.get(Department.HR).contains(new Employee("Alice", Department.HR)));
        assertTrue(grouped.get(Department.HR).contains(new Employee("Carol", Department.HR)));
        assertTrue(grouped.get(Department.IT).contains(new Employee("Bob", Department.IT)));
    }
}

