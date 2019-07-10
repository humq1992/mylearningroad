package com.itheima.day09;

import java.util.Scanner;

/*
* 创建一个校验用户名的
* 长度6-20位
* 可以是数字字母，但是不能数字开头。
*/
public class test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String username = sc.nextLine();
        char[] ex = username.toCharArray();
        if (ex.length >= 6 && ex.length <= 20) {
            if ((ex[0] <= 'z' && ex[0] >= 'a')|| (ex[0] >= 'A' && ex[0] <= 'Z')) {
                for (int i = 1; i < ex.length; i++) {
                    if ((ex[i] <= 'z' && ex[i] >= 'a') ||( ex[i] >= 'A' && ex[i] <= 'Z') || (ex[i] <= '9' && ex[i] >= '0')) {
                    } else {
                        System.out.println("不合法字符");
                        break;
                    }
                }

            } else {
                System.out.println("首字母不合法用户名");
            }
        }else{
            System.out.println("长度不合法用户名");
        }
    }


}
