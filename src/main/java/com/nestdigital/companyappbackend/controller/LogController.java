package com.nestdigital.companyappbackend.controller;

import com.nestdigital.companyappbackend.dao.LogDao;
import com.nestdigital.companyappbackend.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    private String login(@RequestBody LogModel log) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.setLogin((String.valueOf(dt.format(now))));
        System.out.println(log.toString());
        dao.save(log);
        return "Log Successfully added";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logout")
    public String logout(@RequestBody LogModel log){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.setLogout((String.valueOf(dt.format(now))));
        dao.Logout(log.getLogout(),log.getLogout_s_id(),log.getId());
        return "Logout Successfull";
    }

    @CrossOrigin("*")
    @GetMapping("/viewalllog")
    public List<Map<String,String>>viewlog(){
        return (List<Map<String, String>>) dao.viewLog();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewmylog",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>>viewmylog(@RequestBody LogModel log){
        return (List<Map<String, String>>) dao.viewMyLog(log.getEmp_code());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewlogin")
    public List<LogModel> viewCheckIn(){
        return (List<LogModel>) dao.viewLogIn();
    }

}
