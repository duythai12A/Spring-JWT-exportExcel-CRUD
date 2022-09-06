//package com.example.springsecuritydemo.service;
//
//import com.example.springsecuritydemo.entity.bill;
//import com.example.springsecuritydemo.repository.BillRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    private BillRepository billRepository;
//
//    public bill saveBill(bill bill){
//        return billRepository.save(bill);
//    }
//    public List<bill> saveBills(List<bill> bills){
//        return billRepository.saveAll(bills);
//    }
//    public List<bill>searchFilter(int minQuan,int maxQuan){
//        return billRepository.searchFilter(minQuan,maxQuan);
//    }
//    public List<bill> getStudents(){
//        return billRepository.findAll();
//    }
//    public bill getBillById(int id){
//        return billRepository.findById(id).orElse(null);
//    }
//    public String deleteBill(int id){
//        billRepository.deleteById(id);
//        return "removed!! id = "+id;
//    }
////    public bill updateBill(bill bill){
////        bill billUpdate = billRepository.findById(bill.getIdBill()).orElse(null);
////    }
//}
