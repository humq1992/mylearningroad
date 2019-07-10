package com.itheima.day09;

import java.util.Scanner;

public class test_01 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String s=sc.nextLine();
        int i = s.length();
        System.out.println("请输入删除字符");

        String delete=sc.nextLine();
        //用split分割字符串；
        String[] str2 = s.split(delete);
        //创建一个接受新字符串的空字符串；
        String outp="";
        for (int i1 = 0; i1 < str2.length; i1++) {
            outp = outp+str2[i1];
        }
        //原本字符串的长度i减去删除后字符串长度i1再除以删除字符的长度即删除次数。
        int i1 = outp.length();
        int count=(i-i1)/delete.length();
        System.out.println("删除字符次数为："+count);
        System.out.println("删除后字符为："+outp
        );

    }
}