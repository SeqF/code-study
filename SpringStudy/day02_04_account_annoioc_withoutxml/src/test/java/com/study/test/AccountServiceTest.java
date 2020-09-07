package com.study.test;

import com.study.domain.Account;
import com.study.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
 * 使用junit单元测试，测试我们的单元配置
 *
 * 1.junit单元测试中，没有main方法也能执行
 *      junit集成了一个main方法，该方法就会判断当前测试类中哪些方法有 @Test注解
 *      junit就会让有@Test注解的方法执行
 * 2.junit不会管我们是否采用spring框架
 *       在执行测试方法时，junit根本不知道我们是不是使用了spring框架
 *       所以也就不会为我们读取配置文件/配置类创建spring核心容器
 * 4.由以上可知，当测试方法执行时，没有IOC容器，就算写了Autowired注解，也无法实现注入
 *
 * Spring整合junit的配置
 *     1.导入spring整合junit的jar（坐标）
 *     2.使用junit提供的一个注解把原有的main方法替换，替换成spring提供的
 *         @Runwith
 *     3.告知spring的运行器，spring的ioc创建是基于xml还是注解的，并说明位置
 *         @ContextConfiguration
 *                  Locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes:指定注解类所在的位置
 *  当我们使用spring 5.x版本时，要求junit的jar包必须是4.1.2及以上*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    private ApplicationContext ac;
    @Autowired
    private IAccountService as;

    @Before
    public void init() {
        //1.获取容器
        // ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        as = ac.getBean("accountService", IAccountService.class);
    }

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
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
        account.setName("testanno");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUppdate() {
        //3.执行方法
        Account account = as.findAccountById(1);
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
