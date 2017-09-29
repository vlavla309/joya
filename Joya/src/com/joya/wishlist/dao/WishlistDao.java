package com.joya.wishlist.dao;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.image.domain.Images;
import com.joya.wishlist.domain.Wishlist;

public interface WishlistDao {
	
	/** 위시리스트에 등록 */
	public void insert(String userEmail,  int productId);
	
	/** 위시리스트 전체 목록 반환 */
	public List<Wishlist> listAll(String userEmail);
	
	/** 위시리스트 목록에서 삭제 */
	public boolean delete(String userEmail,  int productId);
	
	/** 선택 페이지에 대한 위시리스트 반환 */
	public List<Wishlist> listByPage(String email, int pageNum);
	
	/** {선택페이지, 한페이지당 출력 행수}에 대한 위시리스트 반환 */
	public List<Wishlist> listByParams(String userEmail, Params params);
	
}
