package com.joya.wishlist.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.wishlist.domain.Wishlist;

public interface WishlistService {
	
	/** ���ø���Ʈ�� ��� */
	public void insert(String userEmail,  int productId);
	
	/** ���ø���Ʈ ��ü ��� ��ȯ */
	public List<Wishlist> listAll(String userEmail);
	
	/** ��ǰ ��Ͽ� ���ø���Ʈ ��ü ��� ��ȯ */
	public List<Wishlist> listAll();
	
	/** ���ø���Ʈ ��Ͽ��� ���� */
	public boolean delete(String userEmail,  int productId);
	
	/** ���� �������� ���� ���ø���Ʈ ��ȯ */
	public List<Wishlist> listByPage(String email, int pageNum);
	
	/** {����������, ���������� ��� ���}�� ���� ���ø���Ʈ ��ȯ */
	public List<Wishlist> listByParams(String userEmail, Params params);
	
	public Wishlist read(String userEmail, int productId);
}