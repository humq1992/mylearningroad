package cn.itheima.day03.inclass;

public class code05 {
    public static void main(String[] args) {
        System.out.println(method(1,1));
        System.out.println(method((short)1,1));
        System.out.println(method(1L,1));

    }
    public static boolean method(int a,int b){
        System.out.println("两个int方法");
        return a==b;
    }
    public static boolean method(short a,short b){
        System.out.println("两个short方法");
        if (a==b){
            return true;
        }else return false;
    }
    public static boolean method(byte a,byte b){
        System.out.println("两个byte方法");
        boolean c=a==b;
        return c;
    }
    public static boolean method(long a,long b){
        System.out.println("两个long方法");
        boolean c=a==b?true:false;
        return c;
    }

}
