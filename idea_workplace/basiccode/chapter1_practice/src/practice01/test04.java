package practice01;

public class test04 {
    public static void main(String[] args) {
    int[] arr1={1,2,3,4,6};
    int[] arr2={2,3,4,5};
    int[] unionT=union(arr1,arr2);
        for (int i = 0; i < unionT.length; i++) {
            System.out.print(unionT[i]+"  ");
        }
    }
    public static int[] union(int[]arr1,int[]arr2){
        int[] union=new int[arr1.length+arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            union[i]=arr1[i];

        }
        for (int i = 0; i < arr2.length; i++) {
            union[arr1.length+i]=arr2[i];


        }return union;
    }
}
