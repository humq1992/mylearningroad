package com.itheima.dao.impl;

import com.itheima.dao.IAcccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAcccountDao{

    @Override
    public List<Account> findaccout() {
        List<Account> list=super.getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }

    @Override
    public Account findbyname(String name) {
        Account account = super.getJdbcTemplate().queryForObject("select * from account where username=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        return account;
    }

    @Override
    public void updataaccount(String name,float money) {
        super.getJdbcTemplate().update("UPDATE account set money=? where username=? ",money,name);

    }

    @Override
    public void transfer(String sname, String tname, float money) {
        Account saccount = this.findbyname(sname);
        Account taccount = this.findbyname(tname);
        float smoney=saccount.getMoney()-money;
        float tmoney=taccount.getMoney()+money;
        this.updataaccount(sname,smoney);
        int i=1/0;
        this.updataaccount(tname,tmoney);

    }
}
