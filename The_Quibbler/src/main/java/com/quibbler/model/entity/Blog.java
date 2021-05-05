package com.quibbler.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.quibbler.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Data
@TableName("t_blog")
@ApiModel(value="Blog对象", description="")
public class Blog extends BaseEntity {

    private static final long serialVersionUID = -8436088707339130369L;

    private String title;

    private String content;

    private String headPicture;

    private String flag;

    private Integer views;

    private Integer shareStatement;

    private Integer appreciation;

    private Boolean recommended;

    private Integer published;

    private Integer comment;

    private Integer typeId;

    private Integer userId;


}
