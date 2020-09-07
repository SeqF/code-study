package com.study.blog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.study.blog.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean  step 3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
         * anon: 无需认证就可以访问
         * authc: 必须认证了才能访问
         * user: 必须有记住我功能才能用
         * perms: 拥有对某个资源的权限才能访问
         * role: 拥有某个角色权限才能访问
         * */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权,正常的情况下，没有授权会跳到授权页面
//        filterMap.put("/user/add","perms[user:add]");
//        filterMap.put("/user/update","perms[user:update]");
//        //拦截
//        filterMap.put("/user/*","authc");
//        bean.setFilterChainDefinitionMap(filterMap);

        filterMap.put("/**","anon");
        filterMap.put("/static/**","anon");
        filterMap.put("/admin","anon");
        filterMap.put("/admin/login","anon");
        filterMap.put("/admin/**","authc");

        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        bean.setLoginUrl("/admin");
        //设置未授权页面
        bean.setUnauthorizedUrl("/error/error");
        return bean;
    }

    //DefaultWebSecurityManager  step 2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm对象 ,  需要自定义类：step 1
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        //配置加密方式
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    //整合ShiroDialect：用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //使用MD5加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数，加密次数
        hashedCredentialsMatcher.setHashIterations(3);
        return hashedCredentialsMatcher;
    }


}
