package com.study.blog.shiro;

import com.study.blog.po.User;
import com.study.blog.service.UserService;
import com.study.blog.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        //拿到User对象
        User currentUser=(User)subject.getPrincipal();

        //设置当前用户的权限
//        info.addStringPermission();

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");

        //获取在Controller中被封装的用户数据
        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        //连接数据库,获取用户
        User user=userService.checkUser(userToken.getUsername());

        if(user==null){
            //此用户不存在
            return null;  //抛出异常 UnknownAccountException
        }
        //密码认证  shiro帮你做
        //可以加密： MD5：202cb962ac59075b964b07152d234b70、MD5盐值加密：202cb962ac59075b964b07152d234b70+username
        //获取盐值
        ByteSource credentialsSalt= ByteSource.Util.bytes(user.getUsername());
        //获取数据库中的密码
        String credentials=user.getPassword();
        return new SimpleAuthenticationInfo(user,credentials,credentialsSalt,getName());
    }
}
