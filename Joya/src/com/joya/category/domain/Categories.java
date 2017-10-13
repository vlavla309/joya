package com.joya.category.domain;
/**
 * 상품 카테고리 도메인 클래스
 * @author 김형주
 *
 */
public class Categories {
	private String categoryName;
	private String parent;
	
	public Categories() {}
	
	public Categories(String categoryName, String parent) {
		super();
		this.categoryName = categoryName;
		this.parent = parent;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Categories [categoryName=" + categoryName + ", parent=" + parent + "]";
	}
	
}
