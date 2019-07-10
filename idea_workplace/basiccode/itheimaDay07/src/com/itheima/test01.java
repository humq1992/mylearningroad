package com.itheima;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入");
        int num1=sc.nextInt();
        System.out.println(num1);
        System.out.println("==========");
        String str2=sc.nextLine();//与之前的NextInt混合使用时候会失效。
        System.out.println("===========");
        System.out.println(str2);
        String str1=sc.nextLine();
        int num=Integer.parseInt(str1);
        System.out.println(num+10);

    }
}
