package com.akshansh.app.repository;

import com.akshansh.app.model.Laptop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaptopRepository {
    private List<Laptop> laptops;   // In-memory db for laptops

    public void save(Laptop lap){
        laptops.add(lap);
    }
}
