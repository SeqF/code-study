package com.study.swagger.controller;

import com.study.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;

//一个Controller就是一个接口
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    @ApiOperation("用户hello就完事了")//在方法里加的注释
    @GetMapping("/hello1")
    public String hello1(String username){
        return "hello"+username;
    }

    @ApiOperation("Post测试类")
    @PostMapping("/post")
    public User post(@ApiParam("用户名") User user){
        int i=1/0;
        return user;
    }
}
