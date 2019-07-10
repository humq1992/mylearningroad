package inclass.demo03;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class testdemo03 {

    public static void main(String[] args) throws Exception{
        //用当前类的字节码文件 获得类加载器
        ClassLoader cl = testdemo03.class.getClassLoader();
        //通过获得的加载器中的方法获得配置文件的字节流
        InputStream is = cl.getResourceAsStream("tencent.properties");
        //创建一个Properties对象
        Properties pp = new Properties();
        //载入获得的流
        pp.load(is);
        //通过pp来识别要使用的类名和方法
        String s1 = pp.getProperty("className");
        String s2 = pp.getProperty("methodName");
        Class<?> cla = Class.forName(s1);
        Object o = cla.newInstance();
        Method m = cla.getDeclaredMethod(s2);
        m.invoke(o);

    }
}
