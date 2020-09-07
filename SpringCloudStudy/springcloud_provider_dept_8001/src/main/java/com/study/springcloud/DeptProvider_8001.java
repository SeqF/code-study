package com.study.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.springcloud.mapper")
@SpringBootApplication
public class DeptProvider_8001 {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider_8001.class,args);
    }
}
