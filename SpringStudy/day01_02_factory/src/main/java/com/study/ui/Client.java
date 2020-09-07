package com.study.ui;

import com.study.dao.IAccountDao;
import com.study.factory.BeanFactory;
import com.study.service.IAccountService;
import com.study.service.impl.AccountServiceImpl;

/*
*模拟一个表现层，用于调用业务层实现类
*  */
public class Client {

    public static void main(String[] args) {
        //IAccountService as=new AccountServiceImpl();
        for (int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }

}
