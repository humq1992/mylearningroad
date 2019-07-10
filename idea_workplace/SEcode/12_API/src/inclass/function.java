package inclass;

import java.util.function.Function;

public class function {
    public static void main(String[] args) {
        String s="扎利纳骨,100";
        int b=method(s,a->a.split(",")[1],a->Integer.parseInt(a),a->a+100 );
        System.out.println(b);

    }
    public  static int method(String s, Function<String,String>fun1,Function<String,Integer>fun2,Function<Integer,Integer>fun3){

        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }
}
