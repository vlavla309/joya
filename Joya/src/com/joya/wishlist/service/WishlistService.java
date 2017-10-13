package com.joya.wishlist.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.wishlist.domain.Wishlist;

public interface WishlistService {
	
	/** 위시리스트 insert */
	public void insert(String userEmail,  int productId);
	
	/** 사용자 별 위시리스트 리스트 */
	public List<Wishlist> listAll(String userEmail);
	
	/** 위시리스트 전체 보기 */
	public List<Wishlist> listAll();
	
	/** 위시리스트 삭제 */
	public boolean delete(String userEmail,  int productId);
	
	/** 사용자 별 위시리스트 리스트 & 페이징 */
	public List<Wishlist> listByPage(String email, int pageNum);
	
	/** 사용자 별 위시리스트 리스트 & 페이징 */
	public List<Wishlist> listByParams(String userEmail, Params params);
	
	/**  */
	public Wishlist read(String userEmail, int productId);
}