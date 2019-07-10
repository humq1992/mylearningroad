package cn.itheima.day03.inclass;

public class code01 {
    public static void main(String[] args) {
        getSum(1,2);
        System.out.println("=====================");
        String m = getpPLus("我", "哎", "你");
        System.out.println("m = " + m);
    }

    public static void getSum(int a,int b) {
        int c=a-b;
        System.out.println("c = " + c);

    }
    public static String getpPLus(String a,String b,String c){
        String s=a+b+c;
        return s;

    }
}
