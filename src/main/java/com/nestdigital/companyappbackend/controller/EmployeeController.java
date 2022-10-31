package com.nestdigital.companyappbackend.controller;

import com.nestdigital.companyappbackend.dao.EmployeeDao;
import com.nestdigital.companyappbackend.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    private String addemployee(@RequestBody EmployeeModel employee){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String currentdate= String.valueOf(dt.format(now));
        employee.setJoining_date(currentdate);
        System.out.println(employee.toString());
        dao.save(employee);
        return "Successfully added";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemployee",consumes = "application/json",produces = "application/json")
    private String deleteemployee(@RequestBody EmployeeModel employee){
        System.out.println(employee.toString());
        dao.deleteById(employee.getId());
        return "Successfully deleted";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewemployee")
    public List<EmployeeModel>viewemployee(){
        return (List<EmployeeModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> searchEmployee(@RequestBody EmployeeModel employee){
        return (List<EmployeeModel>) dao.searchEmployee(employee.getName(),employee.getEmp_code());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "signinemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel>signinemployee(@RequestBody EmployeeModel signin){
        return (List<EmployeeModel>) dao.signIn(signin.getEmail(),signin.getPassword());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editemployee",consumes = "application/json",produces = "application/json")
    public String editemployee(@RequestBody EmployeeModel employee){
        dao.editEmployee(employee.getAddress(),employee.getDob(),employee.getEmail(),employee.getEmp_code(),employee.getName(),employee.getPassword(),employee.getPhone(),employee.getSalary());
        return "Edited Successfully";
    }


}
