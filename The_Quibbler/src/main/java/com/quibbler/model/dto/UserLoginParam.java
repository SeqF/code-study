package com.quibbler.model.dto;

import lombok.Data;

/**
 * User 登录参数
 * @author paksu
 */
@Data
public class UserLoginParam {

    private String username;

    private String password;

    private String captcha;

    private String key;
}
