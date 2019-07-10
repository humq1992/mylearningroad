package JDBCUnits;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUnits {
    //成员变量必须为静态变量，静态变量才可以被静态代码块访问，才可以传入，静态方法，工具类一般成员方法都为静态方法
    private static String url;
    private  static String user;
    private static String password;
    private static  String driver;
    static {
        try {
            //通过本工具类的classloader来获取url地址
            //通过url地址来直接获得path地址
            ClassLoader cll = JDBCUnits.class.getClassLoader();
            URL resource = cll.getResource("jdbc.properties");
            Properties pp = new Properties();
            pp.load(new FileReader(resource.getPath()));
            url = pp.getProperty("url");
            user=pp.getProperty("user");
            password=pp.getProperty("password");
            driver=pp.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        return  DriverManager.getConnection(url,user,password);
    }


    public static  void close(Statement stat,Connection conn){
        //在关闭资源的时候，需要判断资源是否为空，
        // 因为在上面申请资源时如果出现了错误，则可能有资源为空，
        // 空资源关闭会产生空指针异常；
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //用重载的方式来写查询方式的三个资源的关闭
    public static  void close(Statement stat, Connection conn, ResultSet resultset){
        if(resultset!=null){
            try {
                resultset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
