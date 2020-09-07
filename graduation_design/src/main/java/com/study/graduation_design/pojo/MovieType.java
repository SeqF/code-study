package com.study.graduation_design.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*这个实体类用来记录5年来各类型的总数和相应的IMDB评分*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieType {

    private String type;
    private float avgpoint;
    private int number;
}
