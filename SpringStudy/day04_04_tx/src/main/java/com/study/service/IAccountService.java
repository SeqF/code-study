package com.study.service;

import com.study.domain.Account;

/*
* 账户的业务层接口
* */
public interface IAccountService {

    /*
    * 根据id查询账户信息
    * */
    Account findAccountById(Integer accountId);

    /*
    * 转账
    * @param sourceName  转账账户名称
    * @param targetName  转入账户名称
    * @param money       转账金额*/
    void transfer(String sourceName,String targetName,Float money);
}
