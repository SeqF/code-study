package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //代表这个类会被Spring接管，被注解后，类中的所有方法，如果返回值是String，就会自动被视图解析器解析，跳转到具体页面
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test(Model model){

        model.addAttribute("msg","ControllerTest2");
        return "test";
    }
}
