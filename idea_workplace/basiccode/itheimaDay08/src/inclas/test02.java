package inclas;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入");
        String str=sc.nextLine();
        char[] arr = str.toCharArray();
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<='Z'&&arr[i]>='A'){
                a++;
            }else if(arr[i]<='9'&&arr[i]>='0'){
                b++;
            }else if(arr[i]<='z'&&arr[i]>='a'){
                c++;
            }else{
                d++;
            }
        }
        System.out.println("大写字母："+a);
        System.out.println("小写字母："+b);
        System.out.println("数字："+c);
        System.out.println("其他："+d);
    }
}
