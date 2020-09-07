package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {

    // 原来的：http://localhost:8080/add?a=1&b=2
    // RestFUL风格：http://localhost:8080/a/b

    @GetMapping("/add/{a}/{b}")  //默认是GET方法
    public String restful1(@PathVariable int a, @PathVariable int b, Model model){

        int restful=a+b;
        model.addAttribute("msg","结果1为："+ restful);

        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String restful2(@PathVariable int a, @PathVariable int b, Model model){

        int restful=a+b;
        model.addAttribute("msg","结果2为："+ restful);

        return "test";
    }
}
