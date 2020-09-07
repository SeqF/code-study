package com.study.blog.service.impl;

import com.study.blog.dao.UserMapper;
import com.study.blog.po.User;
import com.study.blog.service.UserService;
import com.study.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username) {
        User user=userMapper.queryByUsername(username);
        return user;
    }
}
