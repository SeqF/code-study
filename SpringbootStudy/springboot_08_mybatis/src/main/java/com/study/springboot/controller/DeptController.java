package com.study.springboot.controller;

import com.study.springboot.mapper.DepartmentMapper;
import com.study.springboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(Integer id){
        return departmentMapper.getDepById(id);
    }
}
