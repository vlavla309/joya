package com.joya.product.dao;

import java.util.List;
import com.joya.common.web.Params;
import com.joya.product.domain.Product;

public interface ProductDao {
	//create, update, list
	
	public void create(Product product);

	public void update(Product product);
	
	/** {선택페이지, 검색유형, 검색값, 한페이지당 출력 행수}에 대한 회원목록 반환 */
	public List<Product> listByParams(Params params);
	
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params);
	
	//test 
	public List<Product> listAll();
	public void search(String id);

}
