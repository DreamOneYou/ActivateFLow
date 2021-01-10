package cn.qingjia;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;




public class QingJia {
	ProcessEngine porcessEngine =  ProcessEngines.getDefaultProcessEngine();
	/** �������̶���*/
	@Test
	public void deploymentProcessDefinition() {
		Deployment deployment = porcessEngine.getRepositoryService()//�����̶���Ͳ��������ص�service
						.createDeployment() //����һ���������
						.name("ѧ�����1")
						.addClasspathResource("diagrams/MyProcess.bpmn") //��classpath�м��أ�һ��ֻ�ܼ���һ��
						.addClasspathResource("diagrams/MyProcess.png")
						.deploy(); //��ɲ���
		System.out.println("����ID:"+deployment.getId());
		System.out.println("��������:"+deployment.getName());
	}
	/** ��������ʵ��*/
	@Test
	public void startProcessInstance(){
		//���̶����key
		String processDefinitionKey = "QingJia";
		ProcessInstance pi = porcessEngine.getRuntimeService()//������ִ�е�����ʵ����ִ�ж�����ص�service
					.startProcessInstanceByKey(processDefinitionKey); //ʹ�����̶����key��������ʵ����key��ӦMyProcess.bpmn��id������ֵ
		System.out.println("����ʵ��ID:"+pi.getId());//����ʵ��ID
		System.out.println("���̶���ID:"+pi.getProcessDefinitionId());//���̶���ID
	}
	/** ��ѯ��ǰ�˵ĸ�������*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "������";
		List<Task> list = porcessEngine.getTaskService()//������ִ�е����������ص�service
					.createTaskQuery() //���������ѯ����
					.taskAssignee(assignee) //ָ�����������ѯ��ָ��������
					.list();
		if(list!=null && list.size()>0) {
			for(Task task:list) {
				System.out.println("����ID:"+task.getId());
				System.out.println("��������:"+task.getName());
				System.out.println("����Ĵ���ʱ��:"+task.getCreateTime());
				System.out.println("����İ�����:"+task.getAssignee());
				System.out.println("����ʵ��ID:"+task.getProcessInstanceId());
				System.out.println("ִ�ж���ID:"+task.getExecutionId());
				System.out.println("���̶���ID:"+task.getProcessDefinitionId());
			}
		}
	}
	/** ����ҵ�����*/
	@Test
	public void competeMyPersonalTask(){
		//����ID
		String taskId = "22502";
		porcessEngine.getTaskService()//������ִ�е����������ص�service
					.complete(taskId);
		
		System.out.println("�����������ID��"+taskId);
	}
}