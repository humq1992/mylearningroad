package itheimaDay04.inclass;

public class code02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        for (int zhizhen1 = 0, zhizhen2 = (arr.length - 1 ); zhizhen1 < zhizhen2; zhizhen1++,zhizhen2--) {
            int temp = arr[zhizhen1];
            arr[zhizhen1] = arr[zhizhen2];
            arr[zhizhen2] = temp;


        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }
}
