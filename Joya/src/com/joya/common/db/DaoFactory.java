package com.joya.common.db;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.joya.common.exception.MallException;


/**
 * 팩토리 패턴 DaoFactory 작업
 * 싱글톤 패턴적용
 * @author 김형주
 */
public class DaoFactory {
	
	private static DaoFactory instance = new DaoFactory();
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER = "a";
	private static final String PASSWORD = "a";
	private static final int INIT_SIZE = 1;
	private static final int MAX_SIZE = 1;
	
	private BasicDataSource dataSource;
	
	private DaoFactory() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USER);
		dataSource.setPassword(PASSWORD);
		dataSource.setInitialSize(INIT_SIZE);
		dataSource.setMaxTotal(MAX_SIZE);
	}
	
	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static DaoFactory getInstance() {
		return instance;
	}
	

	public Object getDao(String className) {
		Object dao = null;
		try {
			Class cls = Class.forName(className);
			dao = cls.newInstance();
			
			// 동적 메소드호출
			Method method =  cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, dataSource);
			
		} catch (Exception e) {
			throw new MallException("DaoFactory.getDao(String className) 실행 중 예외발생", e);
		}
		return dao;
	}
	
	public Object getDao(Class cls) {
		return getDao(cls.getName());
	}
}
