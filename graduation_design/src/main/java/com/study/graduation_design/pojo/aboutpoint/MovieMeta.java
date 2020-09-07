package com.study.graduation_design.pojo.aboutpoint;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*这个显示Meat各评分区间的总量*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieMeta {

    private int ninety_point;

    private int eighty_point;

    private int seventy_point;

    private int sixty_point;

    private int fifty_point;

    private int forty_point;

    private int thirty_point;

    private int twenty_point;

    private int ten_point;
}
