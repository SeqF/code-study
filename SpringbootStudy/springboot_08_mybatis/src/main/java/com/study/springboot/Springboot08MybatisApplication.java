package com.study.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.springboot.mapper")
@SpringBootApplication
public class Springboot08MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08MybatisApplication.class, args);
    }

}
