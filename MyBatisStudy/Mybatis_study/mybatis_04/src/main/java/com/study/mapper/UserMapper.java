package com.study.mapper;

import com.study.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    //分页
    List<User> getUserByLimit(Map<String,Integer> map);



}
