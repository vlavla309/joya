package com.joya.image.service;

import java.util.List;

import com.joya.common.db.DaoFactory;
import com.joya.image.dao.JdbcImageDao;
import com.joya.image.domain.Images;

public class ImageServiceImpl implements ImageService {
	
	JdbcImageDao imgdao = (JdbcImageDao) DaoFactory.getInstance().getDao(JdbcImageDao.class);
	
	@Override
	public void create(Images image) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Images> listAll() {
		return imgdao.listAll();
	}

	@Override
	public Images search(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Images> listByProductid(int productid) {
		return imgdao.listByProductid(productid);
	}

}
