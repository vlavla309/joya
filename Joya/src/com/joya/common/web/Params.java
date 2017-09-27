package com.joya.common.web;

/**
 * ?—¬?Ÿ¬ê°œì˜ ?š”ì²??ŒŒ?¼ë©”í„°?“¤?„ ???¥(?¬?¥)?•˜ê¸? ?œ„?•œ JavaBean
 * {?‚¬?š©? ?„ ?ƒ?˜?´ì§?, ê²??ƒ‰?œ ?˜•, ê²??ƒ‰ê°?, ?•œ?˜?´ì§??— ì¶œë ¥?•˜?Š” ?–‰?˜ ê°??ˆ˜, ?˜?´ì§? ë²ˆí˜¸ ?“±}
 *  
 * @author ê¹?ê¸°ì •
 */
public class Params {
	private int page;         /** ?‚¬?š©? ?š”ì²? ?˜?´ì§? */
	private String type;      /** ?‚¬?š©? ê²??ƒ‰ ?œ ?˜• */
	private String value;     /** ?‚¬?š©? ê²??ƒ‰ ê°? */
	private int pageSize;     /** ?˜?´ì§??— ì¶œë ¥?•  ?–‰?˜ ?ˆ˜ */
	private int pageNum;      /** ?˜?´ì§??— ì¶œë ¥?•  ?˜?´ì§? ?ˆ˜ */
	
	public Params() {
		this(1, null, null, 10, 10);
	}
	
	public Params(int page, String type, String value, int pageSize, int pageNum) {
		this.page = page;
		this.type = type;
		this.value = value;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		if(pageSize < 0 || pageSize > 50){
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum < 0 || pageNum > 20){
			this.pageNum = 10;
			return;
		}
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "Params [page=" + page + ", type=" + type + ", value=" + value + ", pageSize=" + pageSize + ", pageNum="
				+ pageNum + "]";
	}
	
}
