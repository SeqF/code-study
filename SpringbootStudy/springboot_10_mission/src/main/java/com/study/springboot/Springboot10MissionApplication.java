package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync  //开启异步注解功能
@EnableScheduling  //开始定时功能
@SpringBootApplication
public class Springboot10MissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10MissionApplication.class, args);
    }

}
