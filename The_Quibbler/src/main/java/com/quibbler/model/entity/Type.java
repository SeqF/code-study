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
@TableName("t_type")
@ApiModel(value="Type对象", description="")
public class Type extends BaseEntity{


    private static final long serialVersionUID = 480055779480980152L;

    private String name;


}
