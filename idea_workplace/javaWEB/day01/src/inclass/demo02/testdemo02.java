package inclass.demo02;

import inclass.demo01.dick;

import java.lang.reflect.Method;

public class testdemo02 {
    public static void main(String[] args) throws Exception {
        Class dickClass = dick.class;
        Object o = dickClass.newInstance();
        Method m=dickClass.getDeclaredMethod("use",String.class,String.class);
        m.invoke(o,"器大","无用");
        Method use2 = dickClass.getDeclaredMethod("use2");
        use2.invoke(o);

    }
}
