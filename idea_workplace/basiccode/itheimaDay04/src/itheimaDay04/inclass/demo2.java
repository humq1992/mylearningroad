package itheimaDay04.inclass;

public class demo2 {
    public static void main(String[] args) {
        int[] array = {23, 55, 32, 18, 67, 75, 97, 12, 78, 89};
        System.out.println(getSum(array));
        System.out.println(getMax(array));
        System.out.println(getMin(array));
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;

    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

}
