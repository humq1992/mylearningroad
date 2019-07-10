package inclass.demo04;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
@SuppressWarnings("all")
@MyAno(className="inclass.demo03.tencentpay",methodName = "say")
public class testdemo03 {

    public static void main(String[] args) throws Exception{
        Class<testdemo03> clas = testdemo03.class;
        MyAno an = clas.getAnnotation(MyAno.class);
        String s1 = an.className();
        String s2 = an.methodName();
        Class<?> cla = Class.forName(s1);
        Object o = cla.newInstance();
        Method m = cla.getDeclaredMethod(s2);
        m.invoke(o);

    }
}
