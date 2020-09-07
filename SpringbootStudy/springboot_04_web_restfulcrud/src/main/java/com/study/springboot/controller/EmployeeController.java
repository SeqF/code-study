package com.study.springboot.controller;

import com.study.springboot.dao.EmployeeDao;
import com.study.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps1")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "list";
    }
}
