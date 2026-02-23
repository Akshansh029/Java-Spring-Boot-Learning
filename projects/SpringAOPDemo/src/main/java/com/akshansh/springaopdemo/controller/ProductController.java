package com.akshansh.springaopdemo.controller;

import com.akshansh.springaopdemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        String product = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
