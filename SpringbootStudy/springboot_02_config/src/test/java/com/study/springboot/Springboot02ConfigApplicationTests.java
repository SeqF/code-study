package com.study.springboot;

import com.study.springboot.bean.Person;
import com.study.springboot.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* SpringBoot单元测试
*
* 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
* */
@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean hello=ioc.containsBean("helloService");
        System.out.println(hello);
    }
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
