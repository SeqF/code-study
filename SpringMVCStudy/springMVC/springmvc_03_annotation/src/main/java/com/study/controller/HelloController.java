package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping（"/HelloController")  添加请求路径
//@RestController 类中的方法不会被视图解析器解析，直接返回的是字符串"hello"
public class HelloController {

    @RequestMapping("/hello") //真实访问地址：项目名/HelloController/hello
    public String hello(Model model){

        //封装数据
        //想模型中添加属性 msg与值，可以再JSP页面中取出并渲染
        model.addAttribute("msg","Hello,SpringMVC");

        //会被视图解析器处理
        //  web-inf/jsp/hello.jsp
        return "hello";
    }
}
