package com.akshansh.springdatajpademo.repo;

import com.akshansh.springdatajpademo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    Customer findById(long id);
}
