package jdbc;

import java.sql.*;

public class JDBCdemo02 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db03", "root", "root");
            String sql="SELECT id,ename,joindate,salary,bonus,dept_id FROM emp ";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
           while(resultSet.next()){
                int id= resultSet.getInt(1);
                String name=resultSet.getString("ename");
                Date date=resultSet.getDate("joindate");
                double salary=resultSet.getDouble(4);
                double bonus=resultSet.getDouble(5);
                int dept_id=resultSet.getInt(6);
               System.out.println(id+"--"+name+"--"+date+"--"+salary+"--"+bonus+"--"+dept_id);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //资源释放时候必须分开处理异常，防止再一个资源关闭时，出现异常
            //导致另外两个资源无法关闭
            try {if(resultSet!=null){resultSet.close();}


            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
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

    }

}
