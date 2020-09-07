package com.study.thequibbler.controller;


import com.study.thequibbler.common.lang.Result;
import com.study.thequibbler.entity.User;
import com.study.thequibbler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/thequibbler/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public Result index() {
        User user = userService.getById(1);
        return Result.success(user);
    }
}
