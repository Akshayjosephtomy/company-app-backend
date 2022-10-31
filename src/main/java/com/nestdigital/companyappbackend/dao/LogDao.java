package com.nestdigital.companyappbackend.dao;

import com.nestdigital.companyappbackend.model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `logs` SET `logout`= :logout,`logout_s_id`= :logout_s_id WHERE `id`= :log_id",nativeQuery = true)
    void Logout(String logout,int logout_s_id,int log_id);

    @Query(value = "SELECT l.id, l.emp_code, l.login, l.login_s_id, l.logout, l.logout_s_id,e.name AS employee_name,e.emp_code,s1.name AS login_s_name,s2.name AS logout_s_name FROM logs l JOIN employees e JOIN securities s1 JOIN securities s2 ON l.emp_code= e.emp_code AND l.login_s_id= s1.s_id AND l.logout_s_id= s2.s_id",nativeQuery = true)
    public List<Map<String,String>>viewLog();

    @Query(value = "\n" +
            "SELECT l.id, l.emp_code AS log_emp_code, l.login, l.login_s_id, l.logout, l.logout_s_id,e.name AS employee_name,e.emp_code AS employee_code,s1.name AS login_s_name,s2.name AS logout_s_name FROM logs l JOIN employees e JOIN securities s1 JOIN securities s2 ON l.emp_code=e.emp_code AND l.login_s_id=s1.s_id AND l.logout_s_id=s2.s_id WHERE l.emp_code= :emp_code",nativeQuery = true)
    public List<Map<String,String>>viewMyLog(Integer emp_code);

    @Query(value ="SELECT * FROM logs where logout_s_id = 0",nativeQuery = true)
    public List<LogModel> viewLogIn();
}
