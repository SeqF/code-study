package com.study.springboot.repository;

import com.study.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public class UserRepository extends JpaRepository<User,Integer> {
}
