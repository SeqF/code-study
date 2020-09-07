package com.study.test;

import com.study.domain.Account;
import com.study.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
* 使用junit单元测试，测试我们的单元配置*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts=as.findAllAccount();
        for(Account account :accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as =ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUppdate() {
        //3.执行方法
        Account account =as.findAccountById(1);
        account.setMoney(1564f);
        account.setName("swns");
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(5);

    }
}
