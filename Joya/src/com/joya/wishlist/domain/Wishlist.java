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
	//위시리스트의 상품 정보를 가져오기 위해 추가
	private String productName; 
	private String imgName;
	private String imgPath;
	
	public Wishlist() {	}
	
	public Wishlist(int productId, String email, String productName, String imgName, String imgPath) {
		this(productId, email, null, productName, imgName, imgPath);
	}
	
	public Wishlist(int productId, String email, String regdate, String productName, String imgName, String imgPath) {
		this.productId = productId;
		this.email = email;
		this.regdate = regdate;
		this.productName = productName;
		this.imgName = imgName;
		this.imgPath = imgPath;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	@Override
	public String toString() {
		return "Wishlist [productId=" + productId + ", email=" + email + ", regdate=" + regdate + ", productName="
				+ productName + ", imgName=" + imgName + ", imgPath=" + imgPath + "]";
	}
	
}