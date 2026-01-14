package practice;

import java.util.Scanner;

/* 
Concepts: HAS-A relationship

Problem Statement:
Create:
- Subject class → subjectName, marks
- Student class → name, rollNumber, Subject[]

Tasks:
- Calculate total marks
- Calculate percentage
- Display grade
 */

class Subject{
      private String subjectName;
      private int marks;

      public Subject(String sName, int m){
            if(sName.length() == 0){
                  throw new IllegalArgumentException("Subject name cannot be empty");
            }
            if(m < 0){
                  throw new IllegalArgumentException("Marks cannot be negative");
            }
            this.subjectName = sName;
            this.marks = m;
      }

      public String getSubjectName() {
            return subjectName;
      }

      public int getMarks() {
            return marks;
      }
}

class Student{
      private String name;
      private String rollNumber;
      private Subject[] subjects;

      public Student(String n, String rollNo, Subject[] subs){
            if(n.length() == 0){
                  throw new IllegalArgumentException("Name cannot be empty");
            }
            if(rollNo.length() == 0){
                  throw new IllegalArgumentException("Roll number cannot be empty");
            }
            if (subs == null || subs.length == 0) {
                  throw new IllegalArgumentException("Needs at least 1 subject");
            }
              
            this.name = n;
            this.rollNumber = rollNo;
            this.subjects = subs;
      }

      public int getTotalMarks(){
            int res = 0;
            for (Subject i : subjects) {
                  res += i.getMarks();
            }
            return res;
      }

      public double getPercentage() {
            return (getTotalMarks() / (subjects.length * 100.0)) * 100;
      }
        

      public char getGrade(){
            double percent = getPercentage();
            if (percent >= 90) return 'A';
            else if (percent >= 80) return 'B';
            else if (percent >= 70) return 'C';
            else if (percent >= 60) return 'D';
            else if (percent >= 50) return 'E';
            else return 'F';
      }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }
}

public class ResultSystem {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter number of subjects: ");
            int subSize = sc.nextInt();
            sc.nextLine();
            
            Subject[] subjects = new Subject[subSize];
            
            System.out.println("Enter subject details: ");
            for(int i = 0; i < subSize; i++){
                  try {
                        System.out.printf("Subject %d name: \n", i+1);
                        String subName = sc.nextLine();
                        System.out.printf("Subject %d marks: \n", i+1);
                        int subMarks = sc.nextInt();
                        sc.nextLine();
                        subjects[i] = new Subject(subName, subMarks);
                  } catch (Exception e) {
                        System.out.println(e.getMessage());
                  }
            }

            System.out.println("Enter student's name: ");
            String stuName = sc.nextLine();
            System.out.println("Enter student's roll number: ");
            String stuRollNo = sc.nextLine();
            try {
                  Student student = new Student(stuName, stuRollNo, subjects);
                  System.out.printf("%s's total marks: %d\n", student.getName(), student.getTotalMarks());
                  System.out.printf("%s's percentage: %.2f\n", student.getName(), student.getPercentage());
                  System.out.printf("%s's grade: %c\n", student.getName(), student.getGrade());
            } catch (Exception e) {
                  System.out.println(e.getMessage());
            }

            sc.close();
      }
}
