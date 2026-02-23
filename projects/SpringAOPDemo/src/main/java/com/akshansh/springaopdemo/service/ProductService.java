package com.akshansh.springaopdemo.service;

import com.akshansh.springaopdemo.annotation.Timed;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // Pretend this talks to a database
    @Timed
    public String findById(Long id) {
        System.out.println("  [ProductService] Finding product " + id);
        return "Product-" + id;
    }

    public void delete(Long id) {
        System.out.println("  [ProductService] Deleting product " + id);
    }
}
