package com.akshansh;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parent_table")
public class Parent {
    @Id
    private int pId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "p_age")
    private int pAge;

    public Parent(int pId, String firstName, String lastName, int pAge) {
        this.pId = pId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pAge = pAge;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "pId=" + pId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pAge=" + pAge +
                '}';
    }
}
