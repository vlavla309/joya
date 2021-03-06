package com.joya.image.domain;


/**
 * @author 김형주
 *
 */
public class Images {
	
	private String imageName;
	private int productId;
	private String path;
	private int orderNo;
	
	public Images() {}
	
	public Images(String imageName, int productId, String path, int order) {
		super();
		this.imageName = imageName;
		this.productId = productId;
		this.path = path;
		this.orderNo = order;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "images [imageName=" + imageName + ", productId=" + productId + ", path=" + path + ", order=" + orderNo
				+ "]";
	}
}
