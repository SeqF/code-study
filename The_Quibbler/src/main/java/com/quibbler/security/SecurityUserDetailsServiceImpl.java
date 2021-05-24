package com.quibbler.security;

import cn.hutool.core.util.StrUtil;
import com.quibbler.model.entity.User;
import com.quibbler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索数据库获取user
 *
 * @author paksu
 */
@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isEmpty(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        User sysUser = userService.getByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException(String.format("%s用户不存在", username));
        }
        return new SecurityUser(sysUser.getId(), sysUser.getUserName(), sysUser.getPassword(), sysUser.getEnabled(),
                getGrantedAuthorities(sysUser.getId()));
    }

    /**
     * 通过user的id获取Authorites
     * @param id
     * @return
     */
    public List<GrantedAuthority> getGrantedAuthorities(String id) {

        //角色(ROLE_admin)、菜单操作权限(sys:user:list)
        List<GrantedAuthority> authorities = new ArrayList<>();
        //获取角色
        List<String> roleCodeList = userService.getRoleCodeByUserId(id);
        roleCodeList.forEach(code -> {
            code = "ROLE_" + code;
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(code);
            authorities.add(authority);
        });
        return authorities;
    }
}
