package com.joya.article.service;

import java.util.List;

import com.joya.article.dao.ArticleDao;
import com.joya.article.dao.JdbcArticleDao;
import com.joya.article.domain.Article;
import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;

public class ArticleServiceImpl implements ArticleService {
	
	ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);

	@Override
	public void create(Article article) {
		dao.create(article);
	}

	@Override
	public void review(Article article) {

	}

	@Override
	public List<Article> listAll() {
		return null;
	}

	@Override
	public Article read(int articleId) {
		return null;
	}

	@Override
	public void edit(Article article) {

	}

	@Override
	public void delete(Article article) {

	}

	@Override
	public void reply(Article article) {

	}

	@Override
	public void count(int articleId) {

	}

	@Override
	public List<Article> listByParams(Params params) {
		return null;
	}

	@Override
	public int pageCount(Params params) {
		return 0;
	}
	
	/**
	public static void main(String[] args) {
		ArticleService service = new ArticleServiceImpl();
		Article article = new Article();
		article.setEmail("joa@joa");
		article.setTitle("질문있음");
		article.setContents("반지 재입고 언제됨?");
		article.setPasswd("1111");
		service.create(article);
		System.out.println(article.toString());
		
	}
	*/

}
