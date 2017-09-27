package com.joya.product.dao;

import java.util.List;
import com.joya.common.web.Params;
import com.joya.product.domain.Product;

public interface ProductDao {
	//create, update, list
	
	public void create(Product product);

	public void update(Product product);
	
	
	public List<Product> listByParams(Params params, String categoryName, String orderType);
	
	
	public int pageCount(Params params, String cateforyName, String orderType);
	
	//test 
	public List<Product> listAll();
	public void search(String id);

}
