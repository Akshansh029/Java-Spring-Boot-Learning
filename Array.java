class Student{
      int rollNo;
      String name;
      int marks;

    public Student(int m, String n, int ma) {
      rollNo = m;
      name = n;
      marks = ma;
    }
}

public class Array {
  public static void main(String[] args) {
    
    Student s1 = new Student(1, "Akshansh", 95);
    Student s2 = new Student(2, "Messi", 100);
    Student s3 = new Student(3, "Ronaldo", 90);
    
    Student[] students = new Student[3];
    students[0] = s1;
    students[1] = s2;
    students[2] = s3;

    for(Student i : students){
      System.out.printf("Rollno: %d, Name: %s, Percentage: %d\n", i.rollNo, i.name, i.marks);
    }
  }
}
