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
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 4051895274842714033L;

    private String nickname;

    private String content;

    private String avatar;

    private Integer blogId;

    private Integer parentCommentId;


}
