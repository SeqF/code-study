package com.quibbler.security;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.quibbler.mapper.UserMapper;

import com.quibbler.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author paksu
 */
@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isEmpty(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User sysUser = userMapper.selectOne(wrapper);
        if (sysUser == null) {
            throw new UsernameNotFoundException(String.format("%s这个用户不存在", username));
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roleCodeList = userMapper.getRoleCodeByUserName(username);
        roleCodeList.forEach(code -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(code);
            authorities.add(authority);
        });
        return new SecurityUser(sysUser.getId(), sysUser.getUserName(), sysUser.getPassword(), sysUser.getEnabled(),
                authorities);
    }
}
