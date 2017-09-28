package com.joya.product.service;

import java.util.List;

import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;
import com.joya.product.dao.JdbcProductDao;
import com.joya.product.dao.ProductDao;
import com.joya.product.domain.Product;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao=(ProductDao) DaoFactory.getInstance().getDao(JdbcProductDao.class);

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> listByParams(Params params, String categoryName, String orderType) {
		// TODO Auto-generated method stub
		return productDao.listByParams(params, categoryName, orderType);
	}

	@Override
	public int pageCount(Params params, String cateforyName, String orderType) {
		// TODO Auto-generated method stub
		return productDao.pageCount(params, cateforyName, orderType);
	}

	
	public static void main(String[] args) {
		ProductServiceImpl pro=new ProductServiceImpl();
		List<Product> pros=pro.listByParams(new Params(), "¹ÝÁö", "hitProduct");
		for (Product product : pros) {
			System.out.println(product);
		}
	}
}
