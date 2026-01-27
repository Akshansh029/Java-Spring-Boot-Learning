package com.akshansh.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String pincode;

    public Address(){}

    public Address(String streetName, String city, String state, String country, String pincode) {
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
