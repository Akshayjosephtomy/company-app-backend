package com.nestdigital.companyappbackend.controller;

import com.nestdigital.companyappbackend.dao.SecurityDao;
import com.nestdigital.companyappbackend.model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    private String addsecurity(@RequestBody SecurityModel security){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String currentdate= String.valueOf(dt.format(now));
        security.setJoining_date(currentdate);
        System.out.println(security.toString());
        dao.save(security);
        return "Successfully added";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesecurity",consumes = "application/json",produces = "application/json")
    private String deletesecurity(@RequestBody SecurityModel security){
        System.out.println(security.toString());
        dao.deleteById(security.getId());
        return "Successfully deleted";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewsecurity")
    public List<SecurityModel> viewsecurity(){
        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> searchsecurity(@RequestBody SecurityModel security){
        return (List<SecurityModel>) dao.searchSecurity(security.getName(),security.getS_id());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signinsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel>signinsecurity(@RequestBody SecurityModel signin){
        return (List<SecurityModel>) dao.signIn(signin.getEmail(),signin.getPassword());
    }



    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editsecurity",consumes = "application/json",produces = "application/json")
    public String editsecurity(@RequestBody SecurityModel security){
        dao.editSecurity(security.getEmail(),security.getName(),security.getPassword(),security.getPhone(),security.getS_id(),security.getSalary(),security.getAddress());
        return "Edited Successfully";
    }
}
