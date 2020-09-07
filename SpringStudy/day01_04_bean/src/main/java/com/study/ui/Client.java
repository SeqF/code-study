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
    *
    * */
    public static void main(String[] args) {
          //1.获取核心容器对象
//        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
//        //2.根据id获取Bean对象，两种方式
        IAccountService as = (IAccountService)ac.getBean("accountService");//第一种方式，直接强转
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);//第二种方式，传入自解码来强转
        as.saveAccount();

        //手动关闭容器
        ac.close();


    }

}
