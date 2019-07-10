package com.itheima.service.impl;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS ,readOnly =true)
public class AccountServiceImpl implements IAccountService {
@Autowired
  private AccountDaoImpl accountDao;


  @Override
  @Transactional(propagation = Propagation.REQUIRED ,readOnly =false)
    public void transfer(String source, String target, float money) {
              accountDao.transfer(source,target,money);
    }
}
