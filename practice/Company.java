package practice;
/*
Create:  Employee class:  name, salary, calculateAnnualSalary()

Manager class:  extra field bonus, override calculateAnnualSalary()

Expected Behavior:
- Employee annual salary = salary * 12
- Manager annual salary = (salary * 12) + bonus
 */

class Employee{
      private String name;
      private double salary;

      public Employee(String name, double sal){
            this.name = name;

            if(sal < 0){
                  throw new IllegalArgumentException("Salary cannot be negative");
            }
            this.salary = sal;
      }

      public String getName(){
            return name;
      }

      public double getSalary(){
            return salary;
      }

      public double calculateAnnualSalary(){
            double annualSalary = salary * 12;
            return annualSalary;
      }
}

class Manager extends Employee{
      private double bonus;

      public Manager(String n, double s, double b){
            super(n, s);
            if(bonus < 0){
                  throw new IllegalArgumentException("Bonus cannot be negative");
            }
            this.bonus = b;
      }

      public double getBonus() {
            return bonus;
      }

      @Override public double calculateAnnualSalary(){
            double annualSalary = super.getSalary() * 12 + bonus;
            return annualSalary;
      }

}

public class Company {
      public static void main(String[] args) {
            try{
                  Employee emp1 = new Employee("Sourabh", 75000);
                  Employee emp2 = new Employee("Arpit", 72000);
                  Employee emp3 = new Employee("Kamal", 72000);
                  Manager man = new Manager("Akshansh", 80000, 12000);
                  double emp1Salary = emp1.calculateAnnualSalary();
                  double emp2Salary = emp2.calculateAnnualSalary();
                  double manSalary = man.calculateAnnualSalary();

                  System.out.println(emp1Salary);
                  System.out.println(emp2Salary);
                  System.out.println(manSalary);
            }catch(IllegalArgumentException e){
                  System.out.println(e.getMessage());
            }
      }
}
