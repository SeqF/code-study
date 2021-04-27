package com.quibbler.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.quibbler.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author paksu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_movie")
@ApiModel(value = "Movie对象", description = "")
public class Movie extends BaseEntity {

    private static final long serialVersionUID = -4179929627723948688L;

    private String name;

    private int runTime;

    private String starring;

    private String director;

    private String country;

    private LocalDate release_time;


}
