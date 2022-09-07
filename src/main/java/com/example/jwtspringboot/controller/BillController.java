package com.example.jwtspringboot.controller;

import com.example.jwtspringboot.entity.account;
import com.example.jwtspringboot.entity.bill;
import com.example.jwtspringboot.excel.BillExcelExporter;
import com.example.jwtspringboot.repository.BillRepository;
import com.example.jwtspringboot.service.BillService;
import com.example.jwtspringboot.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillService service;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/addBill")
    public bill addBill(@RequestBody bill bill){
        return service.saveBill(bill);
    }
    @GetMapping("/getBills")
    public List<bill> findAllStudents(){
        return service.getStudents();
    }
    @PostMapping("/allBills")
    public List<bill>addBilss(@RequestBody List<bill>bill){
        return service.saveBills(bill);
    }
    @GetMapping("/searchFilter/{minQuan}/{maxQuan}")
    public List<bill>findBillFilter(@PathVariable(value = "minQuan")int minQuan,@PathVariable(value = "maxQuan")int maxQuan){
        return service.searchFilter(minQuan,maxQuan);
    }
    @GetMapping("/bill/{id}")
    public bill findById(@PathVariable(name = "id") int id){
        return service.getBillById(id);
    }
    @PutMapping("/update")
    public bill updateBill(@RequestBody bill bill){
       return service.updateBill(bill);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBill(@PathVariable(value = "id") int id){
        return service.deleteBill(id);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody account account) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUserName(),account.getPassWord()));
        }catch (Exception e){
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(account.getUserName());
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response)throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headervalue="attachment; filename=Bill_info.xlsx";
        response.setHeader(headerKey,headervalue);
        List<bill>listBill = billRepository.findAll();

        BillExcelExporter exp = new BillExcelExporter(listBill);
        exp.export(response);
    }

}
