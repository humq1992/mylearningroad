package com.itheima.service.impl;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class AccountServiceImpl implements IAccountService {
  @Autowired
  private AccountDaoImpl accountDao;

    @Override
    public void transfer(String source, String target, float money) {

    }
}
