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
	public void create(Article article, String articleType) {
		dao.create(article, articleType);
	}

	@Override
	public List<Article> listAll() {
		return dao.listAll();
	}

	@Override
	public Article read(int articleId) {
		return dao.read(articleId);
	}

	@Override
	public boolean edit(Article article) {
		return dao.edit(article);
	}

	@Override
	public boolean delete(Article article) {
		return dao.delete(article);
	}


	@Override
	public void reply(Article article) {
		dao.reply(article);
	}

	@Override
	public void count(int articleId) {
		dao.count(articleId);
		
	}

	@Override
	public List<Article> listByParams(Params params, int boardId) {
		return dao.listByParams(params, boardId);
	}

	@Override
	public int pageCount(Params params, int boardId) {
		return dao.pageCount(params, boardId);
	}

	@Override
	public List<Article> listByParams(Params params, int boardId, int productid) {
		return dao.listByParams(params, boardId, productid);
	}

	@Override
	public Article searchReview(int productId, String email, int boardId) {
		
		return dao.searchReview(productId, email, boardId);
	}




	
	
	

}
