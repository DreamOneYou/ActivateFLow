package cn.qingjia;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import com.gr.visitServer.VisitEnginer;
import com.gr.visitServer.VisitTask;
import com.gr.visitServer.VisitDeployment;
public class TuiKuanProcess {
	//��������
	VisitEnginer bushu = new VisitEnginer();
	//�ҵ���������
	VisitDeployment ploy = new VisitDeployment();
	VisitTask task = new VisitTask(); //���������
	///** �������̶���*/
	@Test
	public void getTask(){
		Scanner input=new Scanner(System.in);//����һ������ɨ�������
		System.out.print("�������뵱ǰ��������id:");
		int id=input.nextInt(); //��������
		//��������
		int deploymentID=(int)(Math.random()*100);
		String name = "�˿�"+id;
		ploy.Add(id,deploymentID, name);
		List list = ploy.Select(id);
		System.out.println("��������ID:"+list.get(1));
		System.out.println("������������:"+list.get(2));
	}
	
	//��������ʵ��
	@Test
	public void startProcessInstance(){
		int a = 1;
		int taskID=(int)(Math.random()*100);
		VisitTask addTask = new VisitTask();
		List list = bushu.Select(a);
		List listploy = ploy.Select(a);
		System.out.println("��ǰ����ID:"+taskID);
		System.out.println("��ǰ����ʵ��ID:"+list.get(0));
		System.out.println("����ͼ:"+list.get(1)+"->"+list.get(2));
		System.out.println("����ID:"+listploy.get(1));
        addTask.Add(taskID, list.get(0), list.get(4), list.get(5), list.get(3), listploy.get(1));
	}
	
	/** ������ǰ�˵ĸ�������*/
	@Test
	public void findMyPersonalTask(){
		Scanner input=new Scanner(System.in);//����һ������ɨ�������
		System.out.print("�������뵱ǰ�����û�����:");
		String contents1=input.next(); //�����ַ�����
		
		String assignee = contents1;
		List tasklist = task.Select(assignee);
		
		int a = Integer.parseInt(tasklist.get(1).toString());
		List list = bushu.Select(a);
		
		
		System.out.println("��ǰ����ID:"+tasklist.get(0));
		System.out.println("��ǰ��������:"+tasklist.get(2));
		System.out.println("��ǰ���������:"+tasklist.get(4));
		System.out.println("��ǰִ�ж���ID:"+tasklist.get(1));
	}
	
	/** ����ҵ�����*/
	@Test
	public void competeMyPersonalTask(){
		Scanner input=new Scanner(System.in);//����һ������ɨ�������
		System.out.print("�����������ǰ������û���:");
		String contents1=input.next(); //�����ַ�����
		String assignee = contents1;
		
		List listTask = task.Select(assignee);
		int a = Integer.parseInt(listTask.get(1).toString());
		List bushuList = bushu.Select(a);
		String post = bushuList.get(2).toString();
		if (post.equals("ends")){
			task.Delete(assignee);
			System.out.println("��ǰ�˿��������");
			System.exit(0);
		}else {
			a+=1;
			task.Delete(assignee);
			int taskID=(int)(Math.random()*100);
			VisitTask addTask = new VisitTask();
			List list = bushu.Select(a);
	        addTask.Add(taskID, list.get(0), list.get(4), list.get(5), list.get(3), list.get(0));
	        List bushulist = bushu.Select(a);
			List listploy = ploy.Select(a);
			System.out.println("��ǰ����ID:"+taskID);
			System.out.println("��ǰ����ʵ��ID:"+bushulist.get(0));
			System.out.println("��ǰ����ͼ:"+list.get(1)+"->"+list.get(2));
		}
	}
}