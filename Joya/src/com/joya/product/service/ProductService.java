package com.joya.product.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.product.domain.Product;

/**
 * 상품 Serviece interface
 *
 * @author 한수진
 *
 */
public interface ProductService {
	/*상품등록*/
	public void create(Product product);
	/*상품수정*/
	public void update(Product product);
	/*상품리스트*/
	public List<Product> listByParams(Params params, String categoryName, String orderType);
	/*상품페이지*/
	public int pageCount(Params params, String cateforyName, String orderType);
	/*상품상세보기*/
	public Product read(int productId);
	/*상품의 max productid 반환*/
	public int getNewProductId();
	
}
