package com.itheima.service.impl;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class AccountServiceImpl implements IAccountService {

  private AccountDaoImpl accountDao;

  public void setAccountDao(AccountDaoImpl accountDao) {
    this.accountDao = accountDao;
  }

  @Override
    public void transfer(String source, String target, float money) {
              accountDao.transfer(source,target,money);
    }
}
