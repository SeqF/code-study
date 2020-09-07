package com.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        /*redisTemplate
        * opsForValue  操作字符串，类似String
        * opsForList   操作List，类似List
        * opsForXXX 其他数据类型...*/

        /*除了基本操作，常用方法都可以直接通过redisTemplate操作，如：事务，基本的CRUD*/

//        //获取redis的连接对象
//        RedisConnection connection=redisTemplate.getConnectionFactory().getConnection();
//        connection.flushAll();
//
        redisTemplate.opsForValue().set("mykey","a");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test() throws JsonProcessingException {
        //真实开发一般使用json来传递对象
        User user = new User("拍手", 1);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
