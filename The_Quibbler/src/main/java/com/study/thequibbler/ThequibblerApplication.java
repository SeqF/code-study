package com.study.thequibbler;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
public class ThequibblerApplication {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private RedisConnectionFactory connectionFactory = null;

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    //设置RedisTemplate的序列化器
    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }

    public static void main(String[] args) {
        SpringApplication.run(ThequibblerApplication.class, args);
    }

}
