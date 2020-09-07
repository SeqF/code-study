package com.study.graduation_design.mapper;


import com.study.graduation_design.pojo.Movie;
import com.study.graduation_design.pojo.MovieType;
import com.study.graduation_design.pojo.aboutpoint.*;
import com.study.graduation_design.pojo.typenumber.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {

    List<Movie> queryMovieList(int year);//加个year参数

//    List<MovieType> queryMovieType();

    MovieImdb queryMovieImdb();

    MovieMeta queryMovieMeta();

    List<MovieType> querySumType();

    List<MovieStar> queryStar();

    List<BestStar> queryTopStar();

    List<MovieDirector> queryDirector();

    List<BestDirector> queryTopDirector();

    List<MovieHighPoint> queryHighPoint();

    List<MovieHighPoint> queryHighPointVotes();

    List<Movie2019> MovieType2019();

    List<Movie2018> MovieType2018();

    List<Movie2017> MovieType2017();

    List<Movie2016> MovieType2016();

    List<Movie2015> MovieType2015();

}
