package com.itheima.beanFactory;

import com.itheima.dao.impl.AccountImpl;
import com.itheima.service.impl.AccountServiceImpl;

public class BeanFactory {
    public AccountServiceImpl getaccountservice(){
        return  new AccountServiceImpl();
    }
    public AccountImpl getAccountImpl(){
        return  new AccountImpl();
    }
}
