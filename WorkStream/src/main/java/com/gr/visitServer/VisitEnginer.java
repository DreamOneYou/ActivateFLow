package com.gr.visitServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.gr.DBHerpel.DBHerpel;

public class VisitEnginer {

    // ���Ӷ���
    private Connection conn;
    // ����sql���
    private Statement stt;
    // �����
    private ResultSet set;
    private int set1;
    // ��ѯ
    @Test
    public List Select(int a) {
    	List list=new ArrayList();
        try {
            // ��ȡ����
            conn = DBHerpel.getConnection();
            if (conn == null)
                return null;
            // ����sql���
            String Sql = "select * from enginer where id_ ="+a;
            // ִ��sql���
            stt = conn.createStatement();
            // ���ؽ����
            set = stt.executeQuery(Sql);
            // ��ȡ����
            
            while (set.next()) {
            	
//                System.out.println("pre:" + set.getString(2) + "\tpost:"
//                        + set.getString(3) + "\trole:" + set.getString(4));
                if(a == set.getInt(1)) {
//                	�ж��ĸ���ɫֹͣ
                	
                    
                	list.add(set.getString(1));
                	list.add(set.getString(2));
                	list.add(set.getString(3));
                	list.add(set.getString(4));
                	list.add(set.getString(5));
                	list.add(set.getString(6));
                	
                	return list;
                }

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
    @Test
    public List Select1(int a,int day) {
    	List list=new ArrayList();
        try {
            // ��ȡ����
            conn = DBHerpel.getConnection();
            if (conn == null)
                return null;
            // ����sql���
            String Sql = "select * from enginer where id_ ="+a;
            // ִ��sql���
            stt = conn.createStatement();
            // ���ؽ����
            set = stt.executeQuery(Sql);
            // ��ȡ����
            
            while (set.next()) {
                if(a == set.getInt(1)) {
                	// ��ȡ����
                    conn = DBHerpel.getConnection();
                    if (conn == null) {
                        return null;
                    }
                	int d = Integer.parseInt(set.getString(1).toString());
                	String Sql1;
//                	�ж��ĸ���ɫֹͣ
                	if(day<7) {
//                		���С�����죬��
                		Sql1 = "update enginer set post = 'ends' where id_ = "+(d+1);

                    }else if(day>=7 & day<14) {
                    	d = d+2;
                    	System.out.println("d:"+d);
                    	Sql1 = "update enginer set post = 'ends' where id_ = "+ d;
                    }else {
                    	Sql1 = "update enginer set post = 'ends' where id_ = "+(d+3);
                    	
                    }
                	stt = conn.createStatement();
                    // ���ؽ����
                    set1 = stt.executeUpdate(Sql1);
                    
                	list.add(set.getString(1));
                	list.add(set.getString(2));
                	list.add(set.getString(3));
                	list.add(set.getString(4));
                	list.add(set.getString(5));
                	list.add(set.getString(6));
                	
                	return list;
                }

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
 // ʹ��Statement�ӿڵ�executeUpdate()���������ݿ���������
    @Test
    public void Add(int id, Object name){
        
        try {
            //��ȡ����
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            //
            
            Scanner input = new Scanner(System.in);
            
            //����sql���
            String sql = "insert into deployment values("+id+" ,'"+name+"');";
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
    public void Delete(){
        try {
            
            //��ȡ����
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            
            //��ʾ�û�����Ҫɾ�����û�
            System.out.print("������ɾ�����û�:");
            Scanner input = new Scanner(System.in);
            int user = input.nextInt();
            
            //����sql���
            String deleteSql = "DELETE FROM login WHERE user="+user+";";
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