package org.example.map.groupemployee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeGrouping {
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.FINANCE)
        );

        Map<Department, List<Employee>> groupedEmployees = groupByDepartment(employees);

        groupedEmployees.forEach((dept, empList) ->
                System.out.println(dept + ": " + empList)
        );
    }
}
