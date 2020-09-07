package com.study.mapper;

import com.study.pojo.User;

import java.util.List;

public interface UserMapper {

    //根据ID查询用户
    User getUserById(int id);

    //更新用户
    int updateUser(User user);
}
