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

    // ���Ӷ���
    private Connection conn;
    // ����sql���
    private Statement stt;
    // �����
    private ResultSet set;

    // ��ѯ
    @Test
    public List Select(Object assigne) {
    	List list=new ArrayList();
        try {
            // ��ȡ����
            conn = DBHerpel.getConnection();
            if (conn == null)
                return null;
            // ����sql���
//            System.out.println(assigne);
            String Sql = "select * from task where ASSIGNEE = '"+assigne+"'";
//            System.out.println(Sql);
            // ִ��sql���
            stt = conn.createStatement();
            // ���ؽ����
            set = stt.executeQuery(Sql);
            // ��ȡ����
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

            // �ͷ���Դ
            try {
                set.close();
                conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return list;
    }
    
 // ʹ��Statement�ӿڵ�executeUpdate()���������ݿ��������
    @Test
    public void Add(int ID, Object object,Object object2,Object
    		object3,Object object4,Object deploymentID){
        
        try {
            //��ȡ����
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            //
            int id = ID;
            Scanner input = new Scanner(System.in);
   
            //����sql���
            String sql = "insert into task values("+id+" , '"+object+"','"+object2+"' ,"
            		+ " '"+object3+"','"+object4+"',"+deploymentID+");";
            //��ȡStatement����
            stt = conn.createStatement();
            //ִ��sql���
            stt.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //�ͷ���Դ
            try {
                
                conn.close();
                
            } catch (Exception e2) {}
            
        }
        
        
    }
    
  //ʹ��Statement�ӿڵ�executeUpdate()����ʵ�ִ����ݿ�ɾ������
    public void Delete(Object user){
        try {
            
            //��ȡ����
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            
            //��ʾ�û�����Ҫɾ�����û�
//            System.out.print("������ɾ�����û�:");
//            Scanner input = new Scanner(System.in);
            
            //����sql���
            String deleteSql = "DELETE FROM task WHERE ASSIGNEE='"+user+"'";
            //��ȡStatement����
            stt = conn.createStatement();
            //ִ��sql���
            stt.executeUpdate(deleteSql);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //�ͷ���Դ
            try {
                conn.close();
                
            } catch (Exception e2) {}
            
        }
    }



}