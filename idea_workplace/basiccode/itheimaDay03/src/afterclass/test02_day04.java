package afterclass;
//        1.键盘录入长方形的长和宽       定义方法计算该长方形的周长,并在main方法中打印周长
//        2.键盘录入长方形的长和宽       定义方法计算该长方形的面积,并在main方法中打印面积
//        3.键盘录入圆的半径          定义方法计算该圆的周长,并在main方法中打印周长
//        4.键盘录入圆的半径          定义方法计算该圆的面积,并在main方法中打印面积
//
//
//        思考 :
//        1,方法的返回值类型
//        2,方法的参数
//        3,方法的名字
//
//        备注:
//        圆周率 float pi = 3.14F;

import java.util.Scanner;


public class test02_day04 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        System.out.println("请输入长方形的长和宽");
        System.out.println("周长为"+sqaR(sc.nextDouble(),sc.nextDouble()));
        System.out.println("请输入长方形的长和宽");
        System.out.println("面积为"+area(sc.nextDouble(),sc.nextDouble()));
        System.out.println("请输入圆的半径");
        System.out.println("周长为"+cirR(sc.nextDouble()));
        System.out.println("请输入圆的半径");
        System.out.println("面积为"+cirA(sc.nextDouble()));


    }
    public static double sqaR(double a,double b){
        double C=(a+b)*2;
        return    C;
    }
    public static double area(double a,double b){
        double A=a*b;
        return    A;
    }
    public static double cirR(double r){
        double cir=3.14*2*r;
        return    cir;
    }
    public  static double cirA(double r){
        double cirA=3.14*r*r;
        return cirA;
    }
}
