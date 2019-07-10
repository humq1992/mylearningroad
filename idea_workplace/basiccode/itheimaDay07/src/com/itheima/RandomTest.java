package com.itheima;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        int i = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        for (int j = 0; j <= 10; j++) {
            if (j == 10) {
                System.out.println("so much like caixukun");
                break;
            }
            System.out.println("请输入你的猜测");
            int num = sc.nextInt();
            if (num > i) {
                System.out.println("太大了");
            } else if (num < i) {
                System.out.println("太小了");
            } else {
                System.out.println("这你都猜到了");
                break;
            }

        }

    }
}
