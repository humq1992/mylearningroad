package inclass.demo01;

import inclass.demo01.dick;

import java.lang.reflect.Field;

public class testdemo {
    public static void main(String[] args) throws Exception {
      method(dick.class,"file","尼玛还");
    }
    public static void method(Class clazz,String file,String str) throws Exception {
        Object o = clazz.newInstance();
        Field field = clazz.getDeclaredField(file);
        field.setAccessible(true);
        field.set(o,str);
        System.out.println(o);

    }
}
