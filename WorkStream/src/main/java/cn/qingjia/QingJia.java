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
	/** 部署流程定义*/
	@Test
	public void deploymentProcessDefinition() {
		Deployment deployment = porcessEngine.getRepositoryService()//与流程定义和部署对象相关的service
						.createDeployment() //创建一个部署对象
						.name("学生请假1")
						.addClasspathResource("diagrams/MyProcess.bpmn") //从classpath中加载，一次只能加载一个
						.addClasspathResource("diagrams/MyProcess.png")
						.deploy(); //完成部署
		System.out.println("部署ID:"+deployment.getId());
		System.out.println("部署名称:"+deployment.getName());
	}
	/** 启动流程实例*/
	@Test
	public void startProcessInstance(){
		//流程定义的key
		String processDefinitionKey = "QingJia";
		ProcessInstance pi = porcessEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的service
					.startProcessInstanceByKey(processDefinitionKey); //使用流程定义的key启动流程实例，key对应MyProcess.bpmn中id的属性值
		System.out.println("流程实例ID:"+pi.getId());//流程实例ID
		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID
	}
	/** 查询当前人的个人任务*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "朱明航";
		List<Task> list = porcessEngine.getTaskService()//与正在执行的任务管理相关的service
					.createTaskQuery() //创建任务查询对象
					.taskAssignee(assignee) //指定个人任务查询，指定办理人
					.list();
		if(list!=null && list.size()>0) {
			for(Task task:list) {
				System.out.println("任务ID:"+task.getId());
				System.out.println("任务名称:"+task.getName());
				System.out.println("任务的创建时间:"+task.getCreateTime());
				System.out.println("任务的办理人:"+task.getAssignee());
				System.out.println("流程实例ID:"+task.getProcessInstanceId());
				System.out.println("执行对象ID:"+task.getExecutionId());
				System.out.println("流程定义ID:"+task.getProcessDefinitionId());
			}
		}
	}
	/** 完成我的任务*/
	@Test
	public void competeMyPersonalTask(){
		//任务ID
		String taskId = "22502";
		porcessEngine.getTaskService()//与正在执行的任务管理相关的service
					.complete(taskId);
		
		System.out.println("完成任务：任务ID："+taskId);
	}
}