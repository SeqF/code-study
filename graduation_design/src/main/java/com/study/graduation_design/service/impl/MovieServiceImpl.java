package com.study.graduation_design.service.impl;

import com.study.graduation_design.mapper.MovieMapper;
import com.study.graduation_design.pojo.Movie;
import com.study.graduation_design.pojo.MovieType;
import com.study.graduation_design.pojo.aboutpoint.*;
import com.study.graduation_design.pojo.typenumber.*;
import com.study.graduation_design.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    MovieMapper movieMapper;

    @Override
    public List<MovieHighPoint> showHighPoint() {
        List<MovieHighPoint> movieHighPoints = movieMapper.queryHighPoint();
        return movieHighPoints;
    }

    @Override
    public List<Movie> showTop50(int year) {
        List<Movie> movieList = movieMapper.queryMovieList(year);
        return movieList;
    }

    @Override
    public List<Movie2019> showTypeTrend2019() {
        List<Movie2019> movieTypes2019 = movieMapper.MovieType2019();
        return movieTypes2019;
    }

    @Override
    public List<Movie2018> showTypeTrend2018() {
        List<Movie2018> movieTypes2018 = movieMapper.MovieType2018();
        return movieTypes2018;
    }

    @Override
    public List<Movie2017> showTypeTrend2017() {
        List<Movie2017> movieTypes2017 = movieMapper.MovieType2017();
        return movieTypes2017;
    }

    @Override
    public List<Movie2016> showTypeTrend2016() {
        List<Movie2016> movieTypes2016 = movieMapper.MovieType2016();
        return movieTypes2016;
    }

    @Override
    public List<Movie2015> showTypeTrend2015() {
        List<Movie2015> movieTypes2015 = movieMapper.MovieType2015();
        return movieTypes2015;
    }

    @Override
    public MovieImdb showImdb() {
        MovieImdb movieImdb = movieMapper.queryMovieImdb();
        return movieImdb;
    }

    @Override
    public MovieMeta showMeta() {
        MovieMeta movieMeta = movieMapper.queryMovieMeta();
        return movieMeta;
    }

    @Override
    public List<MovieType> showTypeAvgPoint() {
        List<MovieType> movieTypes = movieMapper.querySumType();
        return movieTypes;
    }

    @Override
    public List<MovieStar> showStar() {
        List<MovieStar> movieStars = movieMapper.queryStar();
        return movieStars;
    }

    @Override
    public List<BestStar> showTopStar() {
        List<BestStar> bestStars = movieMapper.queryTopStar();
        return bestStars;
    }

    @Override
    public List<MovieDirector> showDirector() {
        List<MovieDirector> movieDirectors = movieMapper.queryDirector();
        return movieDirectors;
    }

    @Override
    public List<BestDirector> showTopDirector() {
        List<BestDirector> bestDirectors = movieMapper.queryTopDirector();
        return bestDirectors;
    }
}
