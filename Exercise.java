class Employee {
      private String name;
      private double salary;
      
      public Employee(String name, double salary){
          this.name = name;
          this.salary = salary;
      }
      
      public String getName(){
          return name;
      }
      
      public double getSalary(){
          return salary;
      }
      
      public void getDetails(){
          System.out.printf("Name: %s, Salary: %.1f\n", name, salary);
      }
  }
  
  class Manager extends Employee {
      private String department;
      
      public Manager(String n, double s, String department){
          super(n, s);
          this.department = department;
      }
      
      @Override public void getDetails(){
          System.out.printf("Name: %s, Salary: %.1f, Department: %s\n", super.getName(), super.getSalary(), department);
      }
  }
  
  public class Exercise {
      public static void main(String[] args) {
          Employee emp = new Employee("Alice", 50000);
          Manager man = new Manager("Bob", 80000, "IT");
          
          emp.getDetails();
          man.getDetails();
      }
  }
  