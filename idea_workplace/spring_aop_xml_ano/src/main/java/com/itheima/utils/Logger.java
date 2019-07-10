package com.itheima.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
public class Logger {
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pt1(){}
    @Before("pt1()")
    public void before(){
        System.out.println("开始打印日志前置");
    }
    @After("pt1()")
    public void after(){
        System.out.println("开始打印日志前置");
    }
    @AfterReturning("pt1()")
    public void afterreturning(){
        System.out.println("开始打印日志前置");
    }
    @AfterThrowing("pt1()")
    public void afterthrowing(){
        System.out.println("开始打印日志前置");
    }
}
