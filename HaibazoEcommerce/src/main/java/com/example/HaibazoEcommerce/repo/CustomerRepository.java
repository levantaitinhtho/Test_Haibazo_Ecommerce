package com.example.HaibazoEcommerce.repo;

import com.example.HaibazoEcommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByPhoneNumber(String phoneNumber);
}

