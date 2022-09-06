package com.example.jwtspringboot.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "BILL")
public class bill {
    @Id
    @Column(name = "idbill")
    private int idBill;
    @Column(name = "idemp_bill")
    private int idEmp;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "datetime")
    private Date dateTime;
    @OneToOne(targetEntity = customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idemp_bill",referencedColumnName = "idemp", insertable=false, updatable=false)
    private customer employee;
    @OneToMany(targetEntity = product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "billid",referencedColumnName = "idbill",insertable = false,updatable = false)
    private List<product> product;
}
