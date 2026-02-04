package com.akshansh.app.service;

import com.akshansh.app.model.Laptop;
import com.akshansh.app.repository.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository repo;

    public LaptopService(LaptopRepository repo){
        this.repo = repo;
    }

    public void addLaptop(Laptop lap){
        repo.save(lap);
    }
}
