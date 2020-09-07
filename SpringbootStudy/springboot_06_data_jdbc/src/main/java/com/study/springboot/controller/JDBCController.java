package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有实体类，数据库的东西，怎么获取？  Map
    @GetMapping("/citylist")
    public List<Map<String, Object>> cityList() {
        String sql = "select * from city";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addcity")
    public String addCity(){
        String sql="insert into world.city()values()";
        jdbcTemplate.update(sql);
        return "update-ok";

    }
}
