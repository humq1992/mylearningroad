package cn.itheima.day03.inclass;

public class code03 {
    public static void main(String[] args) {
        System.out.println("结果是" + getSum());
    }

    public static int getSum() {
        int Sum = 0;
        for (int i = 1; i <= 100; i++) {
            Sum += i;
        }
        return Sum;
    }
}
