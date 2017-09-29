package com.joya.category.dao;

import java.util.List;

import com.joya.category.domain.Categories;

public interface CategoryDao {

	public void create(Categories product);
	
	public Categories read(String categoryName);
	
	public  List<Categories> listAll();

	
	public void update(Categories product);
	
	public void delete(int categoriesid);
}
