package org.example.serialization;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 75000));
        employees.add(new Employee(103, "Charlie", "Finance", 65000));

        // Serialize Employees
        EmployeeSerializer.serializeEmployees(employees);

        // Deserialize Employees
        List<Employee> deserializedEmployees = EmployeeDeserializer.deserializeEmployees();
        if (deserializedEmployees != null) {
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }
}

