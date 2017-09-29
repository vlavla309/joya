package com.joya.product.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.product.domain.Product;

public interface ProductService {
	public void create(Product product);

	public void update(Product product);
	
	public Product read(int productId);
	
	public List<Product> listByParams(Params params, String categoryName, String orderType);
	
	
	public int pageCount(Params params, String cateforyName, String orderType);

	
}
