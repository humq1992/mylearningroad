package JDBCUnits;

import java.sql.*;

public class test {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet =null;
        try {
             connection = JDBCUnits.getConnection();
             statement = connection.createStatement();

             resultSet = statement.executeQuery("SELECT id,ename,joindate,salary,bonus,dept_id FROM emp ");
            while(resultSet.next()){
                int id= resultSet.getInt(1);
                String name=resultSet.getString("ename");
                Date date=resultSet.getDate("joindate");
                double salary=resultSet.getDouble(4);
                double bonus=resultSet.getDouble(5);
                int dept_id=resultSet.getInt(6);
                System.out.println(id+"--"+name+"--"+date+"--"+salary+"--"+bonus+"--"+dept_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUnits.close(statement,connection,resultSet);
        }
    }
}
