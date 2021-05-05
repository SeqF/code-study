package com.quibbler.listener;

import com.quibbler.model.entity.User;
import com.quibbler.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author paksu
 */
//@WebListener
public class UserListener implements ServletContextListener {

    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserService userService;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //查询数据库所有用户
        List<User> userList = userService.list();
        //清除缓存中的用户数据
        redisTemplate.delete(ALL_USER);
        //将数据存放到Redis缓存中1
        redisTemplate.opsForList().leftPushAll(ALL_USER, userList);
        //查询所有的用户信息
        List queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);

//        System.out.println("缓存中目前的用户数："+queryUserList.size());
//
//        System.out.println("ServletContext上下文初始化");

        logger.info("ServletContext上下文初始化");
        logger.info("缓存中目前的用户数有：" + queryUserList.size()+"人");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("ServletContext上下文销毁");
        logger.info("ServletContext上下文销毁");
    }
}
