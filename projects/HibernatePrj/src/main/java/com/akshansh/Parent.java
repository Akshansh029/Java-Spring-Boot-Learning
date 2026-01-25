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
    private Address address;

    public Parent(int pId, String firstName, String lastName, int pAge, Address address) {
        this.pId = pId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pAge = pAge;
        this.address = address;
    }

    public int getpId() {
        return pId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getpAge() {
        return pAge;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "pId=" + pId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pAge=" + pAge +
                ", address=" + address +
                '}';
    }
}
