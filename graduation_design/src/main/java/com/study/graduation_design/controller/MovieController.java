package com.study.graduation_design.controller;


import com.study.graduation_design.mapper.MovieMapper;
import com.study.graduation_design.pojo.Movie;
import com.study.graduation_design.pojo.MovieType;
import com.study.graduation_design.pojo.aboutpoint.*;
import com.study.graduation_design.pojo.typenumber.*;
import com.study.graduation_design.service.IMovieService;
import com.study.graduation_design.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/main.html")
    public String showHighPoint(Model model){
        List<MovieHighPoint> movieHighPoints = movieService.showHighPoint();
        model.addAttribute("highpoint", movieHighPoints);
        return "dashboard";
    }

    //这是href里面的填的连接路径
    @RequestMapping("/showTop50/{year}")
    public String showTop50(Model model, @PathVariable("year")Integer year){
        /*可以再这里搞一个year的参数，一开始由超链接点进来默认传递2019
        * 然后下拉框传递参数进来这里，再次查询返回列表*/
        List<Movie> movieList = movieService.showTop50(year);
//        System.out.println(movieList);
        model.addAttribute("top50", movieList);
        int years=year;
        return "list";
    }

    @GetMapping("/showStuffAvgPoint")
    public String showStuffAvgPoint(Model model){
        List<MovieStar> movieStars = movieService.showStar();
        model.addAttribute("stars", movieStars);
        List<MovieDirector> movieDirectors = movieService.showDirector();
        model.addAttribute("directors", movieDirectors);
        return "stuffavgpoint";
    }

    @GetMapping("/showTopStuff")
    public String showTopStuff(Model model){
        List<BestDirector> bestDirectors = movieService.showTopDirector();
        List<BestStar> bestStars = movieService.showTopStar();
        model.addAttribute("beststars", bestStars);
        model.addAttribute("bestdirectors", bestDirectors);
        return "topstuff";
    }

//    @GetMapping("/showDirector")
//    public String showDirector(Model model){
//        List<MovieDirector> movieDirectors = movieService.showDirector();
//        System.out.println(movieDirectors);
//        model.addAttribute("directors", movieDirectors);
//        return "director";
//    }

    @GetMapping("/showTypeTrend")
    public String showTypeTrend(Model model){
        List<Movie2019> movieTypes2019 = movieService.showTypeTrend2019();
        model.addAttribute("type2019",movieTypes2019);
        List<Movie2018> movieTypes2018 = movieService.showTypeTrend2018();
        model.addAttribute("type2018",movieTypes2018);
        List<Movie2017> movieTypes2017 = movieService.showTypeTrend2017();
        model.addAttribute("type2017",movieTypes2017);
        List<Movie2016> movieTypes2016 = movieService.showTypeTrend2016();
        model.addAttribute("type2016",movieTypes2016);
        List<Movie2015> movieTypes2015 = movieService.showTypeTrend2015();
        model.addAttribute("type2015",movieTypes2015);
        return "typetrend";
    }

    @GetMapping("/showImdb")
    public String showImdb(Model model){
        MovieImdb movieImdb = movieService.showImdb();
        model.addAttribute("imdb", movieImdb);
        return "imdb";
    }

    @GetMapping("/showMeta")
    public String showMeta(Model model){
        MovieMeta movieMeta = movieService.showMeta();
        model.addAttribute("meta", movieMeta);
        return "meta";
    }

    @GetMapping("/showAvgPoint")
    public String showAVGPoint(Model model){
        List<MovieType> avgPoint = movieService.showTypeAvgPoint();
        model.addAttribute("avgpoint", avgPoint);
        return "typeavgpoint";
    }

}
