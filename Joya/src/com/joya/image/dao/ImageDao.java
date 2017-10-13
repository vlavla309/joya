package com.joya.image.dao;

import java.util.List;

import com.joya.image.domain.Images;


public interface ImageDao {
	/*이미지 등록*/
	public void create(Images image);
	/*이미지 리스트*/
	public  List<Images> listAll();
	/*이미지 검색*/
	public  Images search(String filename);
	/*productid로 이미지검색*/
	public  List<Images> listByProductid(int productid);
}
