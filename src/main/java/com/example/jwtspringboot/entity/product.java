package com.example.jwtspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "PRODUCT")
public class product{
    @Id
    @Column(name = "idprd")
    private int idPrd;
    @Column(name = "nameprd")
    private String namePrd;
    @Column(name = "unitprice")
    private int unitPricel;
    @Column(name = "billid")
    private int billId;
}
