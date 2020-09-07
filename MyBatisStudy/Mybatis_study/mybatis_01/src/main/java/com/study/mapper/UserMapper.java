package com.study.mapper;

import com.study.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //模糊查询
    List<User> getUserListLike(String value);
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);
    int addUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);

}
