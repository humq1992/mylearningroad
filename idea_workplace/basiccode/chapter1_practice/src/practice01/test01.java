package practice01;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组的长度:");
        int m = sc.nextInt();
        int[] array = new int[m];
        for (int i = 0; i < array.length; i++) {
            System.out.println("请输入数组第"+(i+1)+"个数据");
            int n=sc.nextInt();
            array[i]=n;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
        System.out.println("输入需要交换的位数");
        exchange(array,sc.nextInt(),sc.nextInt());
        System.out.println("============方法执行后============");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }

    public static int[] exchange(int[] arr, int x, int y) {
        int temp = arr[x-1];
        arr[x-1] = arr[y-1];
        arr[y-1] = temp;

    return arr;}
}
