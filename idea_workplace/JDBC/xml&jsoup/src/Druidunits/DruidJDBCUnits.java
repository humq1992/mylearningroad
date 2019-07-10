package Druidunits;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidJDBCUnits {
    private static DataSource ds;

    static {

        try {
            Properties pp = new Properties();
            pp.load(DruidJDBCUnits.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return  ds;
    }



    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Statement stat,Connection conn){
        close(null,stat,conn);
    }

    public static void close(ResultSet r, Statement stat, Connection conn) {
        if (r != null) {
            try {
                r.close();
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
