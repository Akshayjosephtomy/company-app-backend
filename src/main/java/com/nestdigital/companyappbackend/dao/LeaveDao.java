package com.nestdigital.companyappbackend.dao;

import com.nestdigital.companyappbackend.model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `leaves` SET `status`= :status WHERE id = :id",nativeQuery = true)
    void leaveStatus(int id,int status);

    @Query(value = "SELECT l.`id`, l.`description`, l.`emp_code`,l.apply_date, l.`leave_date`, l.`status`, l.`type`,e.name FROM `leaves` l JOIN employees e ON e.emp_code=l.emp_code",nativeQuery = true)
    List<Map<String,String>>viewAllLeave();

    @Query(value = "SELECT l.`id`, l.`description`, l.`emp_code`,l.apply_date, l.`leave_date`, l.`status`, l.`type`,e.name FROM `leaves` l JOIN employees e ON e.emp_code=l.emp_code where l.emp_code= :emp_code",nativeQuery = true)
    List<Map<String,String>>viewMyLeaves(Integer emp_code);
}
