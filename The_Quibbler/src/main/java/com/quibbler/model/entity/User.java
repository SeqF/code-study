package com.quibbler.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.quibbler.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Data
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
public class User extends BaseEntity {

    private static final long serialVersionUID = -6927162805413601298L;

    private String nickName;

    private String userName;

    private String password;

    private String email;

    private Integer type;

    private String profilePicture;



}
