package junit;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class TestActivti {
//ʹ�ô��봴����������23�ű�
	@Test
	public void createTable() {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
//		�������ݿ������
		processEngineConfiguration.setJdbcDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		processEngineConfiguration.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=Activtit");
		processEngineConfiguration.setJdbcPassword("sa123456");
		/**
		 * public static final String DB_SCHEMA_UPDATE_FALSE = "false"; �����Զ���������Ҫ�����
		 * public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop"; ��ɾ�����ڴ�����
		 * public static final String DB_SCHEMA_UPDATE_TRUE = "true";���û�б����Զ�������
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//		�������ĺ��Ķ���processEngine����
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("ProcessEngine"+processEngine);
	}
	@Test
	public void createTable2() {

		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
		System.out.println("ProcessEngine"+processEngine);
	}
	
}
