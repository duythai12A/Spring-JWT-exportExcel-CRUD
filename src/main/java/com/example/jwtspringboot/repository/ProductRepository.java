package com.example.jwtspringboot.repository;

import com.example.jwtspringboot.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product,Integer> {
}
