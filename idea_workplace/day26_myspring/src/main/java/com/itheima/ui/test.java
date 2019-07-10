package com.itheima.ui;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountImpl;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        for (int i = 0; i < 5; i++) {

            AccountImpl accountdaoimpl = ac.getBean("account1", AccountImpl.class);


            System.out.println(accountdaoimpl);

        }
    }
}
