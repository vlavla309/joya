package com.joya.article.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.joya.common.db.DaoFactory;

public class ArticleTest {
	
	ArticleDao dao = (ArticleDao)DaoFactory.getInstance().getDao(JdbcArticleDao.class);
	
	@Before
	public void setUp() throws Exception {      
		System.out.println("선행작업 수행됨");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("후행작업 수행됨");
	}

	@Test
	public void sumTest() {
		assertEquals(20, service.sum(10, 10)); 
		System.out.println(service.sum(10, 10));
	}
	
	@Test
	public void getMessageTest() {
		assertNotNull(service.getMessage());
	}

}
