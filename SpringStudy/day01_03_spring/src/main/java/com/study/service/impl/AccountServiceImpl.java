package com.study.service.impl;

import com.study.dao.IAccountDao;
import com.study.dao.impl.AccountDaoImpl;
import com.study.service.IAccountService;

/*
 * 账户的业务层实现类*/
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }

}
