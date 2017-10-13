package com.joya.product.dao;

import java.util.List;
import com.joya.common.web.Params;
import com.joya.product.domain.Product;
/**
 * 상품 Dao interface
 *
 * @author 한수진
 *
 */
public interface ProductDao {
	//create, update, list
	
	public void create(Product product);

	public void update(Product product);
	
	public Product read(int productId);
	
	public List<Product> listByParams(Params params, String categoryName, String orderType);
	
	
	public int pageCount(Params params, String cateforyName, String orderType);
	
	public int getNewProductId();
}
