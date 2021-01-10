package com.gr.DBHerpel;

import java.sql.*; //导包

import org.junit.Test;

/** 
 * ClassName: DBHerpel
 * @Description: TODO 数据库辅助类
 * @author 情绪i
 */
//@Test
public class DBHerpel {

    private static Connection Conn; // 数据库连接对象

    // 数据库连接地址
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=MyProcess";

    // 数据库的用户名
    private static String UserName = "sa";
    // 数据库的密码
    private static String Password = "sa123456";

    /**
     * * @Description: TODO 获取访问数据库的Connection对象
     * @param @return
     * @return Connection 连接数据的对象
     * @author 情绪i
     */
    public static Connection getConnection() {

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 加载驱动

//            System.out.println("加载驱动成功!!!");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {

            //通过DriverManager类的getConenction方法指定三个参数,连接数据库
            Conn = DriverManager.getConnection(URL, UserName, Password);
            System.out.println("连接数据库成功!!!");

            //返回连接对象
            return Conn;

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

}