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
@Table(name = "logs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LogModel {

    @Id
    @GeneratedValue
    private int id;
    private int emp_code;
    private int login_s_id;
    private String login;
    private String logout;
    private int logout_s_id;
}
