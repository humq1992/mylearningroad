package afterclass;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String str=sc.nextLine();
        String str1 = str.trim();
        String sub = str1.substring(str1.length() - 3);
        System.out.println(sub);
    }
}
