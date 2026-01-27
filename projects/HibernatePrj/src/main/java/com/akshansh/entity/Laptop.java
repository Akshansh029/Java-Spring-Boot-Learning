package com.akshansh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {
    @Id
    @Column(name = "l_id")
    private int lid;
    private String brand;
    private String model;
    private int ram;
    @ManyToMany(mappedBy = "laptops")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }

    public Laptop() {}

    public Laptop(int lid, String brand, String model, int ram, List<Student> students) {
        this.lid = lid;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.students = students;
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
