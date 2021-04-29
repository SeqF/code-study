package com.quibbler;

import com.quibbler.entity.User;
import com.quibbler.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class ThequibblerApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void testRedis() {
        //增 key:name,value:ps
        redisTemplate.opsForValue().set("name","ps");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
        //删除
        redisTemplate.delete("name");
        //更新
        redisTemplate.opsForValue().set("name","bs");
        //查询
        name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);

    }

    @Test
    public void testFindById() {
        Long redisUserSize = 0L;
        //查询id=1的数据，该数据存在与Redis缓存中
        User user = userService.getById("1");
        redisUserSize = redisTemplate.opsForList().size("ALL_USER_LIST");
        System.out.println("目前缓存中的用户数量为：" + redisUserSize);
        System.out.println("--------->>>>id：" + user.getId() + " name：" + user.getNickname());
    }
}
