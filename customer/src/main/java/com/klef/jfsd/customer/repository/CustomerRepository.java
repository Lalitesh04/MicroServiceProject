package com.klef.jfsd.customer.repository;

import com.klef.jfsd.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
}
