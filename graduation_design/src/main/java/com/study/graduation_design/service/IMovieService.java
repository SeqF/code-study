package com.study.graduation_design.service;

import com.study.graduation_design.pojo.Movie;
import com.study.graduation_design.pojo.MovieType;
import com.study.graduation_design.pojo.aboutpoint.*;
import com.study.graduation_design.pojo.typenumber.*;

import java.util.List;

public interface IMovieService {

    List<MovieHighPoint> showHighPoint();

    List<Movie> showTop50(int year);

    List<Movie2019> showTypeTrend2019();
    List<Movie2018> showTypeTrend2018();
    List<Movie2017> showTypeTrend2017();
    List<Movie2016> showTypeTrend2016();
    List<Movie2015> showTypeTrend2015();

    MovieImdb showImdb();

    MovieMeta showMeta();

    List<MovieType> showTypeAvgPoint();

    List<MovieStar> showStar();
    List<BestStar> showTopStar();

    List<MovieDirector> showDirector();
    List<BestDirector> showTopDirector();
}
