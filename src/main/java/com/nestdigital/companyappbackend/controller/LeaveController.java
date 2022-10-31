package com.nestdigital.companyappbackend.controller;

import com.nestdigital.companyappbackend.dao.LeaveDao;
import com.nestdigital.companyappbackend.model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave")
    private String applyleave(@RequestBody LeaveModel model){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model.setApply_date((String.valueOf(date.format(now))));
        model.setStatus(0);
        dao.save(model);
        return "Leave applied";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leavestatus",consumes = "application/json",produces = "application/json")
    private String leavestatus(@RequestBody LeaveModel leave){
        dao.leaveStatus(leave.getId(),leave.getStatus());
        return "Success";
    }

    @CrossOrigin("*")
    @GetMapping("/viewallleaves")
    public List<Map<String,String>> viewAllLeaves(){
        return (List<Map<String, String>>) dao.viewAllLeave();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/viewmyleaves")
    private List<Map<String,String>>viewmleaves(@RequestBody LeaveModel leave){
        return (List<Map<String, String>>) dao.viewMyLeaves(leave.getEmp_code());
    }



}
