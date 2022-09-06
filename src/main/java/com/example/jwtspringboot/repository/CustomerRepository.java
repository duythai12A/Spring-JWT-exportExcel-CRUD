package com.example.jwtspringboot.repository;

import com.example.jwtspringboot.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<customer,Integer> {
}
