package com.study.graduation_design.pojo.aboutpoint;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 这个显示IMDB各区间的分数总量*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdb {

    private int nine_point;

    private int eight_point;

    private int seven_point;

    private int six_point;

    private int five_point;

    private int four_point;

    private int three_point;

    private int two_point;

    private int one_point;
}
