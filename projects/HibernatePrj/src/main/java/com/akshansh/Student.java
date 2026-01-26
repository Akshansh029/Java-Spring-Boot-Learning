package com.akshansh;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    private int rollNo;
    private String sName;
    private int marks;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public Student() {}

    public Student(int rollNo, String sName, int marks, List<Laptop> laptops) {
        this.rollNo = rollNo;
        this.sName = sName;
        this.marks = marks;
        this.laptops = laptops;
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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", marks=" + marks +
                ", laptops=" + laptops +
                '}';
    }
}
