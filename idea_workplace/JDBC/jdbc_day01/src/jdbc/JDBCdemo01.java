package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCdemo01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db03","root","root");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db03","root","root");
        String sql="update emp set salary=5000 where id=1001";
        // insert into 表名(列名1,列名2,...列名n) values(值1,值2,...值n)
        //* 语法：
        //		* update 表名 set 列名1 = 值1, 列名2 = 值2,... where 条件;
        //	* 注意：
        //		1. 如果不加任何条件，则会将表中所有记录全部修改。
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate(sql);

        stmt.close();
        connection.close();
        System.out.println(i>0?"修改成功":"修改失败");

    }
}
