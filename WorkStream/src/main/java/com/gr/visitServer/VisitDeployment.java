package com.gr.visitServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.gr.DBHerpel.DBHerpel;

public class VisitDeployment {

    // ���Ӷ���
    private Connection conn;
    // ����sql���
    private Statement stt;
    // �����
    private ResultSet set;

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
            String Sql = "select * from deployment where id_="+a;
            // ִ��sql���
            stt = conn.createStatement();
            // ���ؽ����
            set = stt.executeQuery(Sql);
            // ��ȡ����
            while (set.next()) {
//            	
//                System.out.println("pre:" + set.getString(1) + "\tpost:"
//                        + set.getString(2) );
                if(a == set.getInt(1)) {
                	list.add(set.getString(1));
                	list.add(set.getString(2));
                	list.add(set.getString(3));
//                	System.out.println(list.get(0));
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
    
 // ʹ��Statement�ӿڵ�executeUpdate()���������ݿ��������
    @Test
    public void Add(int id_,int ployid, Object name){
        
        try {
            //��ȡ����
            conn = DBHerpel.getConnection();
            if(conn==null)
            return;
            //
            
            Scanner input = new Scanner(System.in);
            
            //����sql���
            String sql = "insert into deployment values("+id_+", "+ployid+",'"+name+"');";
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