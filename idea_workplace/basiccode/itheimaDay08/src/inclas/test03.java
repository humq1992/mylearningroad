package inclas;

import java.util.Arrays;

public class test03 {
    public static void main(String[] args) {
        String str="asqwenmxndfefiqnwke";
        char[] ch=str.toCharArray();
        Arrays.sort(ch);
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }  System.out.println();
        for (int i = ch.length - 1; i >= 0; i--) {

            System.out.print(ch[i]);
        }
    }
}
