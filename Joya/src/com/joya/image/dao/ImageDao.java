package com.joya.image.dao;

import java.util.List;

import com.joya.image.domain.Images;


public interface ImageDao {
	
	public void create(Images image);
	public  List<Images> listAll();
	public  Images search(String filename);
	public  List<Images> listByProductid(int productid);
}
