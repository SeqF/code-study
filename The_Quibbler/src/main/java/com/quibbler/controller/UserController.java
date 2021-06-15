package com.quibbler.controller;


import cn.hutool.core.util.StrUtil;
import com.quibbler.common.exception.CaptchaException;
import com.quibbler.global.Constans;
import com.quibbler.model.dto.UserLoginParam;
import com.quibbler.model.entity.User;
import com.quibbler.utils.JwtUtil;
import com.quibbler.utils.RedisUtil;
import com.quibbler.utils.Result;
import com.quibbler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    RedisUtil redisUtil;

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/index")
    public Result index() {
        User user = new User();
        return Result.successWithData(user);
    }

    @PostMapping("/login")
    public Result userLogin(@RequestBody UserLoginParam param) {
        String username = param.getUsername();
        String token = jwtUtil.generateToken(username);
        String captcha = param.getCaptcha();
        String key = param.getKey();

        if (StrUtil.isBlank(captcha) || StrUtil.isBlank(key)) {
            return Result.errorWithMessage("验证码错误");
        }

        if (!captcha.equals(redisUtil.hGet(Constans.CAPTCHA_KEY, key))) {
            return Result.errorWithMessage("验证码错误");
        }

        redisUtil.hDelete(Constans.CAPTCHA_KEY, key);
        return Result.successWithDataAndMessage(token, "Login Success");
    }
}
