package com.study.graduation_design.pojo.aboutpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDirector {

    private String director;
    private int counts;
    private float avgpoint;
}
