package com.joya.product.domain;

public class Product {
	
	private int productId;
	private String categoryName;
	private String productName;
	private String maker;
	private String productDes;
	private String regdate;
	private int price;
	private int amount;
	
	public Product() {}
	
	public Product(int productId, String categoryName, String maker, String productDes, String regdate, int price,
			int amount) {
		super();
		this.productId = productId;
		this.categoryName = categoryName;
		this.maker = maker;
		this.productDes = productDes;
		this.regdate = regdate;
		this.price = price;
		this.amount = amount;
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
		return productDes;
	}
	public void setProductDes(String productDes) {
		this.productDes = productDes;
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", maker=" + maker + ", productDes=" + productDes + ", regdate=" + regdate + ", price=" + price
				+ ", amount=" + amount + "]";
	}
	
}
