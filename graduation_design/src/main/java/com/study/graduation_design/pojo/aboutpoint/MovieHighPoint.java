package com.study.graduation_design.pojo.aboutpoint;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*这个实体类保存每年的高分电影数量，IMDB评分在8以上
*  列：year SumHighPoint*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieHighPoint {

    private int year;
    private int sumhighpoint;
}
