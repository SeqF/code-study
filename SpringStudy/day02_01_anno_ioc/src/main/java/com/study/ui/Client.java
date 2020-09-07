package com.study.ui;

import com.study.dao.IAccountDao;
import com.study.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.bind.annotation.XmlAccessOrder;

/*
*模拟一个表现层，用于调用业务层实现类
*  */
public class Client {

    /*
    * 获取spring的IOC核心容器，并根据id获取对象
    *
    * ApplicationContext的三个常用实现类：
    *       ClassPathXmlApplicationContext :(常用) 它可以加载类路径下的配置文件，要求配置文件必须在类路径(resources)下，不在的话加载不了
    *       FileSystemXmlApplicationContext :它可以加载磁盘任意路径下的配置文件(必须有访问权限)
    *       AnnotationConfigApplicationContext :它是用于读取注解创建容器
    *
    * 核心容器的两个接口引发出的问题
    *    ApplicationContext:  单例对象适用        采用此接口
    *         它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
    *
    *    BeanFactory:  多例对象适用
    *         它在构建核心容器时，创建对象采取的策略是延迟加载的方式，也就是说什么时候根据id获取对象了，
    *     什么时候才真正的创建对象(用的时候才创建)
    *           */
    public static void main(String[] args) {
          //1.获取核心容器对象
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象，两种方式
        IAccountService as = (IAccountService)ac.getBean("accountService");//第一种方式，直接强转
//        IAccountService as2 = (IAccountService)ac.getBean("accountService");//第一种方式，直接强转

//        IAccountDao adao=(IAccountDao)ac.getBean("accountDao");
//        System.out.println(as);
//        System.out.println(adao);
        as.saveAccount();

//        System.out.println(as == as2);


    }

}
