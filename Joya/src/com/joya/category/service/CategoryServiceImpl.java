package com.joya.category.service;

import java.util.List;

import com.joya.category.dao.JdbcCategoryDao;
import com.joya.category.domain.Categories;
import com.joya.common.db.DaoFactory;
/**
 * 상품 카테고리 서비스 구현
 * @author 김형주
 *
 */
public class CategoryServiceImpl implements CategoryService{
	
	JdbcCategoryDao categoryDao = (JdbcCategoryDao) DaoFactory.getInstance().getDao(JdbcCategoryDao.class);
	
	@Override
	public void create(Categories category) {
	}

	@Override
	public Categories read(String categoryName) {
		return categoryDao.read(categoryName);
		
	}

	@Override
	public List<Categories> listAll() {
		return categoryDao.listAll();
	}

}
