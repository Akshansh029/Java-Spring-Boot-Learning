package com.akshansh;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int rollNo;

    private String sName;
    private int marks;

    public Student(int rollNo, String sName, int marks) {
        this.rollNo = rollNo;
        this.sName = sName;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getsName() {
        return sName;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
