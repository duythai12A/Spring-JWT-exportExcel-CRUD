package com.example.jwtspringboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name = "ACCOUNT")
public class account {
    @Id
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    //@JsonIgnore//bỏ hiện mật khẩu
    private String passWord;
    @Column(name = "role")
    private String role;
}
