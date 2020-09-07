package com.study.blog.dao;

import com.study.blog.common.dao.MapperUtil;
import com.study.blog.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MapperUtil<User> {

    User queryByUsername(String username);
}
