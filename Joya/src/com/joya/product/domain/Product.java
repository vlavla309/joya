package com.joya.product.domain;

/**
 * 상품 도메인
 *
 * @author 한수진
 *
 */
public class Product {
	
	private int productId;
	private String categoryName;
	private String productName;
	private String maker;
	private String productDesc;
	private String regdate;
	private int price;
	private int amount;
	private int hitcount;
	
	public Product() {}
	
	public Product(int productId, String productName, String categoryName, String maker, String productDesc, String regdate, int price,
			int amount, int hitcount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryName = categoryName;
		this.maker = maker;
		this.productDesc = productDesc;
		this.regdate = regdate;
		this.price = price;
		this.amount = amount;
		this.hitcount = hitcount;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getProductDes() {
		return productDesc;
	}
	public void setProductDes(String productDes) {
		this.productDesc = productDes;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", maker=" + maker + ", productDesc=" + productDesc + ", regdate=" + regdate + ", price=" + price
				+ ", amount=" + amount + ", hitcount=" + hitcount + "]";
	}

	
	
}
