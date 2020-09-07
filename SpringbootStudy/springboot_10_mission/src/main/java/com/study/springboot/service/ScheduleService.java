package com.study.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    //cron表达式
    //秒 分 时 日 月 周几
    @Scheduled(cron = "0 21 17 * * ?")
    public void hello(){
        System.out.println("hello，执行了");
    }
}
