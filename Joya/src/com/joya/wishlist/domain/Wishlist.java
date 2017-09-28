package com.joya.wishlist.domain;
/**
 * 사용자 정보 저장을 위한 JavaBean
 * 
 * @author 정지현
 */
public class Wishlist {
	
	private int productId;
	private String email;
	private String regdate;
	
	public Wishlist() {	}
	
	public Wishlist(int productId, String email) {
		this(productId, email, null);
	}
	
	public Wishlist(int productId, String email, String regdate) {
		this.productId = productId;
		this.email = email;
		this.regdate = regdate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Wishlist [productId=" + productId + ", email=" + email + ", regdate=" + regdate + "]";
	}
	
}
