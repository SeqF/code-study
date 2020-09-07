package com.study.graduation_design.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private int index;
    private String name;
    private int year;
    private int runtime;
    private String type;
    private float imdb;
    private int meta;
    private int votes;
    private String director;
    private String star;


}
