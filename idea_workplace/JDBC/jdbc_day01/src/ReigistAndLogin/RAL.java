package ReigistAndLogin;

import JDBCUnits.JDBCUnits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RAL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入账号");
        String u=sc.nextLine();
        System.out.println("请输入密码");
        String p=sc.nextLine();
        System.out.println(login(u,p)?"登陆成功":"登陆失败");
        //System.out.println(exist(u)?"账号存在或出现异常":"可以正常创建");
        //regist(u,p);
    }
    public static  boolean login(String username,String password){
        Connection conn =null;
        PreparedStatement ppstat =null;
        ResultSet resultSet =null;
        boolean next =false;
        try {
            conn = JDBCUnits.getConnection();
            String sql="SELECT*FROM student where name=? AND passerword=?";
            ppstat = conn.prepareStatement(sql);
            ppstat.setString(1,username);
            ppstat.setString(2,password);
            resultSet = ppstat.executeQuery();
            //初始化的B为TRUE存在同样ID，创建失败，如果报错，未获得resultset也同样无法改变B的初始化数值，无法创建，
            // 如果存在同样的值 resultset.next()会改变B为TRUE也无法创建，只有查询无才可以正常返回false，可正常创建。
            next = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUnits.close(ppstat,conn,resultSet);
        }return next;

    }

    public static  void regist(String username,String password){
        if(exist(username)==false){Connection conn =null;
            PreparedStatement ppstat =null;
            try {
                conn = JDBCUnits.getConnection();
                String sql="INSERT INTO student VALUES (NULL,?,?);";
                ppstat = conn.prepareStatement(sql);
                ppstat.setString(1,username);
                ppstat.setString(2,password);
                int i = ppstat.executeUpdate();
                System.out.println(i>0?"注册成功":"注册失败");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUnits.close(ppstat,conn);
            }
        }else{
            System.out.println("账号已经存在,注册失败");
        }
    }
    public static  boolean exist(String username){
        Connection conn =null;
        PreparedStatement ppstat =null;
        ResultSet resultSet =null;
        boolean b=true;

        try {
            conn = JDBCUnits.getConnection();
            String sql="SELECT*FROM student where  name=?";
            ppstat = conn.prepareStatement(sql);
            ppstat.setString(1,username);
            resultSet = ppstat.executeQuery();
            //初始化的B为TRUE存在同样ID，创建失败，如果报错，未获得resultset也同样无法改变B的初始化数值，无法创建，
            // 如果存在同样的值 resultset.next()会改变B为TRUE也无法创建，只有查询无才可以正常返回false，可正常创建。
            b = resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUnits.close(ppstat,conn,resultSet);
            return b;
        }

    }
}
