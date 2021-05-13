package com.quibbler.controller;


import com.quibbler.model.entity.User;
import com.quibbler.utils.Result;
import com.quibbler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import static com.quibbler.utils.Result.successWithData;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public Result index() {
        User user = new User();
        return Result.successWithData(user);
    }

    @PostMapping("/login")
    public Result userLogin() {
        return Result.successWithMessage("Login Success");
    }
}
