package com.itheima.service.impl;

import com.itheima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    public void saveaccount() {
        System.out.println("执行了保存账户 ");
    }

    public void delaccount() {
        System.out.println("执行了删除账户");

    }

    public void updateaccount(int i) {
        System.out.println("执行了更新账户");

    }
}
