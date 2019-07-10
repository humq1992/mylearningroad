package com;

import java.util.Scanner;

public class arrayCopy {
    public static void main(String[] args) {
        char[] ch={'i','t','c','a','s','t','a'};
        char[] ch2=new char[6];
        System.arraycopy(ch,0,ch2,0,6);
        System.out.println(ch2);
        Scanner sc=new Scanner(System.in);
        String next = sc.next();
    }
}
