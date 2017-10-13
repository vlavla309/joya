package com.joya.category.service;

import java.util.List;

import com.joya.category.domain.Categories;
/**
 * 상품 카테고리 서비스 인터페이슨
 * @author 김형주
 */
public interface CategoryService {
	
	/** 새 카테고리 추가*/
	public void create(Categories product);
	/** 특정 카테고리 조회*/
	public Categories read(String categoryName);
	/** 카테고리 목록 조회*/
	public  List<Categories> listAll();
}
