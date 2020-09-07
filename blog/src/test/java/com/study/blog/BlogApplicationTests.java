package com.study.blog;

import com.study.blog.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    BlogService blogService;
    @Test
    void contextLoads() {
        System.out.println(blogService.listBlog(1, 1, "无所事事的一天", true).getList().get(0).getTitle());

    }

}
