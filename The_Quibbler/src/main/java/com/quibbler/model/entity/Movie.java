package com.quibbler.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.quibbler.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author paksu
 */
@Data
@TableName("t_movie")
@ApiModel(value = "Movie对象", description = "")
public class Movie extends BaseEntity {

    private static final long serialVersionUID = -4179929627723948688L;

    private String name;

    private int runTime;

    private String starring;

    private String director;

    private String country;

    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate releaseTime;


}
