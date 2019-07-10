package afterclass;
//参数类型分别为两个 byte 类型，两个 short 类型，两个 int 类型，两个 long 类型，
//        并在 main 方法中进行测试。
//
//        思考 :
//        1,方法的返回值类型
//        2,方法的参数
//        3,方法的名字（方法重载）

public class test03_day04 {

    public static void main(String[] args) {
        System.out.println(method(1, 1));
        System.out.println(method((short) 1, 1));
        System.out.println(method(1L, 1));

    }

    public static boolean method(int a, int b) {
        System.out.println("两个int方法");
        return a == b;
    }

    public static boolean method(short a, short b) {
        System.out.println("两个short方法");
        if (a == b) {
            return true;
        } else return false;
    }

    public static boolean method(byte a, byte b) {
        System.out.println("两个byte方法");
        boolean c = a == b;
        return c;
    }

    public static boolean method(long a, long b) {
        System.out.println("两个long方法");
        boolean c = a == b ? true : false;
        return c;
    }

}
