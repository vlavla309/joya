package com.joya.article.domain;

public class Article {

	private int articleId;
	private String email;
	private int boardId;
	private String title;
	private String contents;
	private String writer;
	private String regdate;
	private String passwd;
	private int groupNo;
	private int type;
	private int hitcount;
	private String filePath;
	private int productId;
	
	
	public Article() {}

	public Article(int articleId, String email, int boardId, String title, String contents, String writer,
			String regdate, String passwd, int groupNo, int type, int hitcount, String file, int productId) {
		super();
		this.articleId = articleId;
		this.email = email;
		this.boardId = boardId;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.regdate = regdate;
		this.passwd = passwd;
		this.groupNo = groupNo;
		this.type = type;
		this.hitcount = hitcount;
		this.filePath = file;
		this.productId = productId;
	}


	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public int getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getHitcount() {
		return hitcount;
	}


	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String file) {
		this.filePath = file;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", email=" + email + ", boardId=" + boardId + ", title=" + title
				+ ", contents=" + contents + ", writer=" + writer + ", regdate=" + regdate + ", passwd=" + passwd
				+ ", groupNo=" + groupNo + ", type=" + type + ", hitcount=" + hitcount + ", filePath=" + filePath
				+ ", productId=" + productId + "]";
	}
	
	
	
}
