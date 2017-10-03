package com.joya.article.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.joya.article.domain.Article;
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
	public void createTest() {
		Article article = new Article();
		article.setEmail("joa@joa");
		article.setTitle("질문합니다");
		article.setContents("목걸이 언제 들어오나요?");
		article.setPasswd("1111");
		dao.create(article, "qna");
		System.out.println("회원가입됨");
		System.out.println(article.toString());
	}
	
	
}
