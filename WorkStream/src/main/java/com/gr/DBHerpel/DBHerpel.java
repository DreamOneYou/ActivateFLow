package com.gr.DBHerpel;

import java.sql.*; //����

import org.junit.Test;

/** 
 * ClassName: DBHerpel
 * @Description: TODO ���ݿ⸨����
 * @author ����i
 */
//@Test
public class DBHerpel {

    private static Connection Conn; // ���ݿ����Ӷ���

    // ���ݿ����ӵ�ַ
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=MyProcess";

    // ���ݿ���û���
    private static String UserName = "sa";
    // ���ݿ������
    private static String Password = "sa123456";

    /**
     * * @Description: TODO ��ȡ�������ݿ��Connection����
     * @param @return
     * @return Connection �������ݵĶ���
     * @author ����i
     */
    public static Connection getConnection() {

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // ��������

//            System.out.println("���������ɹ�!!!");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {

            //ͨ��DriverManager���getConenction����ָ����������,�������ݿ�
            Conn = DriverManager.getConnection(URL, UserName, Password);
            System.out.println("�������ݿ�ɹ�!!!");

            //�������Ӷ���
            return Conn;

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

}