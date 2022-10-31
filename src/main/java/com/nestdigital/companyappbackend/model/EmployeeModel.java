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
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int emp_code;
    private String email;
    private String password;
    private String salary;
    private String dob;
    private String phone;
    private String address;
    private String joining_date;
}
