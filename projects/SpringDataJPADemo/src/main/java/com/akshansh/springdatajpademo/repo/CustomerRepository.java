package com.akshansh.springdatajpademo.repo;

import com.akshansh.springdatajpademo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.lastName = ?1")
    List<Customer> findByLastName(String lastName);

    @Query("SELECT c FROM Customer c WHERE c.firstName = ?1")
    List<Customer> findByFirstName(String firstName);

    Customer findById(long id);
}
