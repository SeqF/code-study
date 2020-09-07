package com.study.test;

import com.study.domain.Account;
import com.study.service.IAccountService;
import config.SpringConfiguratioin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/*
 * 使用junit单元测试，测试我们的单元配置*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguratioin.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer() {
        as.transfer("bbb", "ccc", 666f);
    }
}
