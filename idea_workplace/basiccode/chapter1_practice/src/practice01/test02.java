package practice01;

public class test02 {
    public static void main(String[] args) {
        int a=50;
        int b=30;
        int c=80;
        getMin();

    }
    public static void getMin(){
        int a=50;
        int b=30;
        int c=80;
        int min=a<b?(a<c?a:c):(b<c?b:c);
        System.out.println(min);
    }
}
