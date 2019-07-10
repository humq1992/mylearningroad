package inclas;

public class test01 {
    public static void main(String[] args) {
        String str="我dio哒不做人了";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
