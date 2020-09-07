package com.study.graduation_design.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.testng.annotations.IConfigurationAnnotation;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //网站首页
        registry.addViewController("/").setViewName("dashboard");
        //首页按钮跳转
        registry.addViewController("/main.html").setViewName("dashboard");

    }
}
