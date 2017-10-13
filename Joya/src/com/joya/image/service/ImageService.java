package com.joya.image.service;

import java.util.List;

import com.joya.image.domain.Images;

/**
 * @author 김형주
 *
 */
public interface ImageService {
	/*이미지 등록*/
	public void create(Images image);
	/*전체 이미지*/
	public  List<Images> listAll();
	/*이미지 검색*/
	public  Images search(String filename);
	/* productid로 이미지 검색 */
	public  List<Images> listByProductid(int productid);
}
