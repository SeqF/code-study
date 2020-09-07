package com.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

public class HelloController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //ModelAndView 视图和模型
        ModelAndView mv = new ModelAndView();

        //业务代码
        //封装对象，放在ModelAndView中
        mv.addObject("msg","HelloSpringMVC!");

        //视图跳转
        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("hello"); // 完整路径 :/WEB-INF/jsp/hello.jsp
        return mv;
    }
}
