package afterclass;

public class test03 {
    public static void main(String[] args) {
        String str = "AdfdfadfDFEFdfefom";
        String out = firstCase(str);
        System.out.println(out);
    }

    public static String firstCase(String str) {
        String s = str.toLowerCase();
        String sub = s.substring(1);
        String fir = s.substring(0, 1);
        String first = fir.toUpperCase();
        return (first + sub);

    }
}
