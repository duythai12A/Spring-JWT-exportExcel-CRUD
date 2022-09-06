package com.example.jwtspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "CUSTOMER")
public class customer {
    @Id
    @Column(name = "idemp")
    private int idEmp;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private int phone;
    @Column(name = "username")
    private String userName;
    @OneToOne(targetEntity = account.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "username",referencedColumnName = "username", insertable=false, updatable=false)
    private account account;
}
