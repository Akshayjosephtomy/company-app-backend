package com.nestdigital.companyappbackend.dao;

import com.nestdigital.companyappbackend.model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Query(value = "SELECT * WHERE name = :name OR s_id = :s_id",nativeQuery = true)
    List<SecurityModel> searchSecurity(String name,int s_id);

    @Query(value = "SELECT * FROM `securities` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<SecurityModel>signIn(String email,String password);


    @Modifying
    @Query(value = "UPDATE `securities` SET `email`= :email,`name`= :name,`password`= :password,`phone`= :phone,`s_id`= :s_id ,salary= :salary,address= :address WHERE `s_id`= :s_id",nativeQuery = true)
    void editSecurity(String email,String name,String password,String phone,Integer s_id,String salary,String address);
}
