package com.itheima.bean;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;

public class myaroundmethod  {
    public Object aroundmethod(ProceedingJoinPoint pdj){
        Object rtValue=null;
        Object[] args = pdj.getArgs();
        System.out.println("在这里写前置通知");
        try {
            rtValue=pdj.proceed(args);//在这里会调用配置中的aop标签中限定的类方法
            System.out.println("在这里写后置通知");
            return  rtValue;
        } catch (Throwable throwable) {
            System.out.println("这里写的是异常通知");
            throw new RuntimeException(throwable);//必须使用
        }finally {
            System.out.println("这里是最终通知");
        }


    }
}
