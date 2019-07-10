package afterclass;
//        1.求两个数据之和(两个整数 )
//        2.判断两个数据是否相等(两个整数)
//        3.找出两个数中较大的值(两个整数)
//        4.找出两个数中较小的值(两个整数)
//
//        思考 :
//        1,方法的返回值类型
//        2,方法的参数
//        3,方法的名字

public class test01_day04 {
    public static void main(String[] args) {
        System.out.println(getSum(1,2));
        System.out.println(same(1,2 ));
        System.out.println(max(1,2));
        System.out.println(min(1,2));
    }
    public static int getSum(int a,int b){
        int Sum=a+b;
        return Sum;
    }
    public static boolean same(int a, int b){
        boolean same=a==b;
        return same;
    }
    public static int max(int a,int b){
        int max=a>b?a:b;
        return max;
    }
    public static int min(int a,int b){
        int min=a>b?b:a;
        return min;
    }
}
