package itheimaDay04.inclass;

public class code01_arraymin {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6};
        int min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("min = " + min);
    }
}
