package junit;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class TestActivti {
//使用代码创建工作流的23张表
	@Test
	public void createTable() {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
//		连接数据库的配置
		processEngineConfiguration.setJdbcDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		processEngineConfiguration.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=Activtit");
		processEngineConfiguration.setJdbcPassword("sa123456");
		/**
		 * public static final String DB_SCHEMA_UPDATE_FALSE = "false"; 不能自动创建表，需要表存在
		 * public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop"; 先删除表在创建表
		 * public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果没有表，就自动创建表
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//		工作流的核心对象，processEngine对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("ProcessEngine"+processEngine);
	}
	@Test
	public void createTable2() {

		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
		System.out.println("ProcessEngine"+processEngine);
	}
	
}
