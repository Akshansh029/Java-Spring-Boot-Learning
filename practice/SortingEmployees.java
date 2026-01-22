package practice;
/*
Problem Statement
- Create an Employee class with: id, name, salary, department

Tasks
- Sort employees by salary using Comparable
- Sort employees by:
      - department (A–Z)
      - then salary (high → low) using Comparator
- Print sorted results
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee>{
      private int id;
      private String name;
      private double salary;
      private String department;

      public Employee(int i, String n, double s, String d){
            if(i < 1){
                  throw new IllegalArgumentException("Employee ID must be natural number");
            }
            if(n.isEmpty() || d.isEmpty()){
                  throw new IllegalArgumentException("Employee name and department cannot be empty");
            }
            if(s < 0){
                  throw new IllegalArgumentException("Employee salary cannot be negative");
            }
            this.id = i;
            this.name = n;
            this.salary = s;
            this.department = d;
      }

      public int getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public double getSalary() {
            return salary;
      }

      public String getDepartment() {
            return department;
      }

      @Override
      public int compareTo(Employee that){
            return Double.compare(this.salary, that.salary);
      }

      @Override
      public String toString() {
            return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
      }
}

public class SortingEmployees {
      public static void main(String[] args) {
            List<Employee> emps = new ArrayList<>();
            try {
                  emps.add(new Employee(1, "Akshansh", 80000, "IT"));
                  emps.add(new Employee(2, "Aditya", 960000, "Exec"));
                  emps.add(new Employee(3, "Sourabh", 84000, "IT"));
                  emps.add(new Employee(4, "Shehan", 72000, "Operations"));
            } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
            }
            
            System.out.println("Sorting by salary (Low -> High)");
            Collections.sort(emps);
            emps.forEach((Employee e) -> System.out.println(e.toString()));
            
            Comparator<Employee> deptThenSalary =
    Comparator.comparing(Employee::getDepartment)
              .thenComparing(
                  Comparator.comparing(Employee::getSalary).reversed()
              );

            System.out.println("\nSorting by dept then salary (High -> Low)");
            Collections.sort(emps, deptThenSalary);
            emps.forEach((Employee e) -> System.out.println(e.toString()));
      }
}
