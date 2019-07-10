package Java;
/*
* 1. 定义方法 found(String str)，要求如下:
        形参: String str
        返回值类型 int
        实现:从str中随机获取一个字符，将该字符打印在控制台，并且统计该字符在str中出现的次数

2. 在main方法中完成以下要求，提示用户从控制台键盘录入一个字符串,调用found(String str)方法，在控制台输出返回的次数

*/

import java.util.Random;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的字符串");
        String str=sc.nextLine();
        System.out.println("总共出现了"+found(str)+"次");

    }
    public static int found(String str){
        char[] array = str.toCharArray();
        Random r=new Random();
        int count=0;
        int i1 = r.nextInt(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i]==array[i1]) {
                count++;
            }
        }
        System.out.println("随机字符："+array[i1]);
        return count;
    }
}
