package com.joya.category.service;

import java.util.List;

import com.joya.category.domain.Categories;

public interface CategoryService {
	
	public void create(Categories product);
	public Categories read(String categoryName);
	public  List<Categories> listAll();
}
