package com.nestdigital.companyappbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "securities")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
public class SecurityModel {
    @Id
    @GeneratedValue

    private int id;
    private String name;
    private String email;
    private String address;
    private String salary;
    private String password;
    private String phone;
    private int s_id;
    private String joining_date;
}
