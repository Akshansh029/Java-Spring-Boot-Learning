package com.akshansh.app.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    private String brand;
    private String model;
    private int ram;
    private int rom;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public void compile(){
        System.out.println("Compiling using Laptop");
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", rom=" + rom +
                '}';
    }
}
