package practice01;

public class test03 {
    public static void main(String[] args) {
        printNum();

    }

    public static void printNum() {
        int count = 0;
        for (int i = 1; i <= 500; i++) {
            if (i % 2 == 0 && i % 5 == 0) {
                if (i % 7 == 0) {
                    count++;
                    System.out.println(i);


                }
            }

        }
        System.out.println(count);
    }
}
