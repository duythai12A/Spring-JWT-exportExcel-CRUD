package com.example.jwtspringboot.repository;

import com.example.jwtspringboot.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<account,String> {

    account findByUserName(String username);
}
