package com.example.jwtspringboot.repository;

import com.example.jwtspringboot.entity.bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<bill,Integer> {
    @Query("SELECT b from bill b where b.quantity>=?1 and b.quantity<=?2")
    List<bill>searchFilter(int minQuan,int maxQuan);
}
