package afterclass;

public class test02 {
    public static void main(String[] args) {
        String str = "123,456,789,101,102";
        String r = getR(str);
        System.out.println(r);

    }


public static String getR(String str) {
    String[] spl = str.split(",");
    String strOut = "";
    for (int i = 0; i < spl.length; i++) {
        if (i == spl.length - 1) {
            strOut = strOut + spl[spl.length-1-i];
        } else {
            strOut = strOut + spl[spl.length-1-i] + ",";
        }
    }
    return strOut;
    }



}