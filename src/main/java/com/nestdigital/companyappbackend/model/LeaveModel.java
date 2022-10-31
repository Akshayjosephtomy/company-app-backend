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
@Table(name = "leaves")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LeaveModel {

    @Id
    @GeneratedValue
    private int id;
    private int emp_code;
    private String description;
    private String type;
    private String apply_date;
    private String leave_date;
    private int status;
}
