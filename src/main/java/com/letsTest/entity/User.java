package com.letsTest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String address;
    private Boolean status;
    private String collegeName;
    private String collegeRegNo;
    private String department;
    private String mobileNo;
    private String password;
    private String role;


}
