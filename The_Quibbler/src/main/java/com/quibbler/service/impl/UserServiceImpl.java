package com.quibbler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.quibbler.service.UserService;
import com.quibbler.model.entity.User;
import com.quibbler.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quibbler.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    RedisUtil redisUtil;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public User getById(Serializable id) {

//        //查询Redis缓存中的所有数据
//        List<User> userList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
//        if (userList != null && userList.size() > 0) {
//            for (User user : userList) {
//                if (user.getId().equals(id)) {
//                    return user;
//                }
//            }
//        }
//        //如果缓存中没有，则查询数据库中的数据，并设置回缓存中
//        User user = this.getById(id);
//        if (user != null) {
//            redisTemplate.opsForList().leftPush(ALL_USER, user);
//        }
//        return user;
        return new User();
    }

    @Override
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        return getOne(wrapper);
    }

    @Override
    public List<String> getRoleCodeByUserId(String id) {
        return baseMapper.getRoleCodeByUserId(id);
    }

}
