package com.example.jwtspringboot.service;

import com.example.jwtspringboot.entity.account;
import com.example.jwtspringboot.entity.bill;
import com.example.jwtspringboot.entity.customer;
import com.example.jwtspringboot.repository.AccountRepository;
import com.example.jwtspringboot.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillService implements UserDetailsService {
@Autowired
private BillRepository billRepository;
@Autowired
private AccountRepository accountRepository;

public bill saveBill(bill bill){
        return billRepository.save(bill);
        }
public List<bill> saveBills(List<bill> bills){
        return billRepository.saveAll(bills);
        }
public List<bill>searchFilter(int minQuan,int maxQuan){
        return billRepository.searchFilter(minQuan,maxQuan);
        }
public List<bill> getStudents(){
        return billRepository.findAll();
        }
public bill getBillById(int id){
        return billRepository.findById(id).orElse(null);
        }
public String deleteBill(int id){
        billRepository.deleteById(id);
        return "removed!! id = "+id;
        }
public bill updateBill(bill bill){
        bill billUpdate = billRepository.findById(bill.getIdBill()).orElse(null);
        billUpdate.setQuantity(bill.getQuantity());
        billUpdate.setDateTime(bill.getDateTime());
        billUpdate.getEmployee().setIdEmp(bill.getEmployee().getIdEmp());
        billUpdate.getEmployee().setAddress(bill.getEmployee().getAddress());
        billUpdate.getEmployee().setName(bill.getEmployee().getName());
        billUpdate.getEmployee().setPhone(bill.getEmployee().getPhone());
        return billRepository.save(bill);
        }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        account customer = accountRepository.findByUserName(username);
        if (customer == null){
        throw new UsernameNotFoundException("Not found username");
        }
        UserDetails userDetails = new User(
        customer.getUserName(),
        customer.getPassWord(), AuthorityUtils.createAuthorityList(customer.getRole())
        );
        return userDetails;
        }


//
//        public account login(LogInForm form) throws LogInException {
//            StudentAccount student = accountRepository.findByUserName(form.getUsername());
//            if (student == null){
//                throw new LogInException("Username Not Correct");
//            }
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            boolean check =  encoder.matches(form.getPassword(), student.getPassword());
//            if (check ){
//                return student;
//            }
//            throw new LogInException("Password Not Correct");
//        }
//        }
//}
}
