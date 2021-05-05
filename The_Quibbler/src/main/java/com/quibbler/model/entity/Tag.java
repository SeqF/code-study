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
@TableName("t_tag")
@ApiModel(value="Tag对象", description="")
public class Tag extends BaseEntity {

    private static final long serialVersionUID = -5093099417478758879L;

    private String name;


}
