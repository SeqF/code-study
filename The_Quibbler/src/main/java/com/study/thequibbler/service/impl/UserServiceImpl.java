package com.study.thequibbler.service.impl;

import com.study.thequibbler.entity.User;
import com.study.thequibbler.mapper.UserMapper;
import com.study.thequibbler.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
