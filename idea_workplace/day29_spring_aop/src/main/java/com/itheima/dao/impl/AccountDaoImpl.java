package com.itheima.dao.impl;

import com.itheima.dao.IAcccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
@Repository("accountdao")
public class AccountDaoImpl implements IAcccountDao {
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public void transfer(String source, String target, float money) {
        Account sourceaccount =null;
        Account targetaccount =null;
        try {
            sourceaccount = runner.query("select * from account where username=source", new BeanHandler<Account>(Account.class));
            targetaccount = runner.query("select * from account where username=target", new BeanHandler<Account>(Account.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        float smoney=sourceaccount.getMoney()-money;
        float tmoney=targetaccount.getMoney()+money;
        try {
            runner.update("updata account set money=? where id=?",smoney,sourceaccount.getId());
            runner.update("updata account set money=? where id=?",tmoney,targetaccount.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
