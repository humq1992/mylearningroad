package com.itheima.day09;

public class zi extends fu{
    int num=1;
    int numzi=2;
    public  void method(){
        System.out.println("子类方法");
    }
    public void methodzi(){
        int num=2;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
