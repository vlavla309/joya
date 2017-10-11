package com.joya.wishlist.service;

import java.util.List;

import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;
import com.joya.wishlist.dao.JdbcWishlistDao;
import com.joya.wishlist.dao.WishlistDao;
import com.joya.wishlist.domain.Wishlist;

public class WishlistServiceImpl implements WishlistService {
	
	WishlistDao wishlistDao = (WishlistDao)DaoFactory.getInstance().getDao(JdbcWishlistDao.class);
	
	@Override
	public void insert(String userEmail, int productId) {
		wishlistDao.insert(userEmail, productId);	
	}
	
	@Override
	public List<Wishlist> listAll(String userEmail) {
		return wishlistDao.listAll(userEmail);
	}
	
	@Override
	public List<Wishlist> listAll() {
		return wishlistDao.listAll();
	}
	
	@Override
	public boolean delete(String userEmail, int productId) {
		return wishlistDao.delete(userEmail, productId);
	}
	
	@Override
	public List<Wishlist> listByPage(String email, int pageNum) {
		return wishlistDao.listByPage(email, pageNum);
	}
	
	@Override
	public List<Wishlist> listByParams(String userEmail, Params params) {
		return wishlistDao.listByParams(userEmail, params);
	}
}

