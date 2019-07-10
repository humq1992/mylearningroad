package itheimaDay04.inclass;

public class code03_printmethod {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 45, 6, 7, 8};
        System.out.println(printarray(arr)[0]);

    }

    public static int[] printarray(int[] array/*此处的array为声明的参数名称，数组也可以作为方法中的参数*/) {
        int sum=0;
        //方法中传递的array实际为地址值
        for (int i = 0; i < array.length; i++) {
           sum=sum+array[i];
            //打印出来的为地址值所对应数组内的数字值
        }
        int arevage=sum/array.length;
        int[]arrayback={sum,arevage};

        return arrayback;
    }
}
