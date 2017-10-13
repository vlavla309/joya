package com.joya.category.dao;

import java.util.List;

import com.joya.category.domain.Categories;
/**
 * 상품 카테고리 DAO 인터페이스
 * @author 김형주
 *
 */
public interface CategoryDao {
	/** 새 카테고리 추가*/
	public void create(Categories product);
	
	/** 특정 카테고리 수정*/
	public void update(Categories product);
	
	/** 특정 카레고리 삭제*/
	public void delete(int categoriesid);
	
	/** 특정 카테고리 조회*/
	public Categories read(String categoryName);
	
	/** 카테고리 목록 조회*/
	public  List<Categories> listAll();
}
