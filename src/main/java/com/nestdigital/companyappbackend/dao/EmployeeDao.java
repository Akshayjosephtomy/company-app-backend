package com.nestdigital.companyappbackend.dao;

import com.nestdigital.companyappbackend.model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT * FROM `employees` WHERE name = :name OR emp_code = :emp_code",nativeQuery = true)
    List<EmployeeModel> searchEmployee(String name,int emp_code);

    @Query(value = "SELECT * FROM `employees` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<EmployeeModel>signIn(String email,String password);

    @Modifying
    @Query(value = "UPDATE `employees` SET `address`= :address,`dob`= :dob,`email`= :email,`emp_code`= :emp_code,`name`= :name,`password`= :password,`phone`= :phone,`salary`= :salary WHERE emp_code = :emp_code",nativeQuery = true)
    void editEmployee(String address,String dob,String email,Integer emp_code,String name,String password,String phone,String salary);
}
