package com.gr.visitServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.gr.DBHerpel.DBHerpel;

public class VisitTask {

    // 连接对象
    private Connection conn;
    // 传递sql语句
    private Statement stt;
    // 结果集
    private ResultSet set;

    // 查询
    @Test
    public List Select(Object assigne) {
    	List list=new ArrayList();
        try {
            // 获取连接
            conn = DBHerpel.getConnection();
            if (conn == null)
                return null;
            // 定义sql语句
//            System.out.println(assigne);
            String Sql = "select * from task where ASSIGNEE = '"+assigne+"'";
//            System.out.println(Sql);
            // 执行sql语句
            stt = conn.createStatement();
            // 返回结果集
            set = stt.executeQuery(Sql);
            // 获取数据
            while (set.next()) {
            	
//                System.out.println(set.getString(5));
//            	if(assigne.equals(set.getInt(5))) {
	        	list.add(set.getString(1));
	        	list.add(set.getString(2));
	        	list.add(set.getString(3));
	        	list.add(set.getString(4));
	        	list.add(set.getString(5));
	        	return list;
//				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // 释放资源
            try {
                set.close();
                conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return list;
    }
    
 // 使用Statement接口的executeUpdate()方法向数据库添加数据
    @Test
    public void Add(int ID, Object object,Object object2,Object
    		object3,Object object4,Object deploymentID){
        
        try {
            //获取连接
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            //
            int id = ID;
            Scanner input = new Scanner(System.in);
   
            //定义sql语句
            String sql = "insert into task values("+id+" , '"+object+"','"+object2+"' ,"
            		+ " '"+object3+"','"+object4+"',"+deploymentID+");";
            //获取Statement对象
            stt = conn.createStatement();
            //执行sql语句
            stt.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            try {
                
                conn.close();
                
            } catch (Exception e2) {}
            
        }
        
        
    }
    
  //使用Statement接口的executeUpdate()方法实现从数据库删除数据
    public void Delete(Object user){
        try {
            
            //获取连接
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            
            //提示用户输入要删除的用户
//            System.out.print("请输入删除的用户:");
//            Scanner input = new Scanner(System.in);
            
            //定义sql语句
            String deleteSql = "DELETE FROM task WHERE ASSIGNEE='"+user+"'";
            //获取Statement对象
            stt = conn.createStatement();
            //执行sql语句
            stt.executeUpdate(deleteSql);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            try {
                conn.close();
                
            } catch (Exception e2) {}
            
        }
    }



}