package com.akshansh;

import jakarta.persistence.*;

@Entity
public class Laptop {
    @Id
    @Column(name = "l_id")
    private int lid;
    private String brand;
    private String model;
    private int ram;
    @ManyToOne
    @JoinColumn(name = "student_roll_no")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Laptop() {}

    public Laptop(int lid, String brand, String model, int ram, Student student) {
        this.lid = lid;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.student = student;
    }

    public int getLid() {
        return lid;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
