package com.joya.common.web;

/**
 * ?˜?´ì§? ê³„ì‚° ë°? ?˜?´ì§? ë²ˆí˜¸(1|2|3|4|5....) ì¶œë ¥?„ ê°ê°?˜ JSP?—?„œ ì²˜ë¦¬?•˜ì§? ?•Šê³?,
 * ?¬?‚¬?š©?•  ?ˆ˜ ?ˆ?„ë¡? ?œ ?‹¸ë¦¬í‹° ?´?˜?Š¤ ? •?˜
 * @author ê¹?ê¸°ì •
 */
public class PageBuilder {
	
	private Params params;            /** ?š”ì²? ?ŒŒ?¼ë©”í„° */
	
	private int totalRowCount;        /** ?…Œ?´ë¸”ë¡œë¶??„° ê²??ƒ‰?œ ?–‰?˜ ?ˆ˜ */
	private int totalPageCount;       /** ?—°?‚°?— ?”°ë¥? ? „ì²´í˜?´ì§? ?ˆ˜ */
	private int listNo;               /** ëª©ë¡ ë²ˆí˜¸ */
	private int currentStartPage;     /** ?˜„?¬ ëª©ë¡?˜ ?‹œ?‘?˜?´ì§? ë²ˆí˜¸ */
	private int currentEndPage;       /** ?˜„?¬ ëª©ë¡?˜ ë§ˆì?ë§‰í˜?´ì§? ë²ˆí˜¸ */
	private int previousStartPage;    /** ?´? „ ëª©ë¡?˜ ?‹œ?‘?˜?´ì§? ë²ˆí˜¸ */
	private int nextStartPage;        /** ?‹¤?Œ ëª©ë¡?˜ ?‹œ?‘?˜?´ì§? ë²ˆí˜¸ */
	
	
	public PageBuilder() {
		this(null, 0);
	}
	
	/**
	 * @param params           ?š”ì²? ?ŒŒ?¼ë©”í„°
	 * @param totalRowCount    ê²??ƒ‰???…ë³? ê²??ƒ‰?œ ?–‰?˜ ?ˆ˜
	 */
	public PageBuilder(Params params, int totalRowCount ) {
		this.params = params;
		this.totalRowCount = totalRowCount;
	}

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	
	public int getCurrentStartPage() {
		return currentStartPage;
	}

	public void setCurrentStartPage(int currentStartPage) {
		this.currentStartPage = currentStartPage;
	}

	public int getCurrentEndPage() {
		return currentEndPage;
	}

	public void setCurrentEndPage(int currentEndPage) {
		this.currentEndPage = currentEndPage;
	}

	public int getPreviousStartPage() {
		return previousStartPage;
	}

	public void setPreviousStartPage(int previousStartPage) {
		this.previousStartPage = previousStartPage;
	}

	public int getNextStartPage() {
		return nextStartPage;
	}

	public void setNextStartPage(int nextStartPage) {
		this.nextStartPage = nextStartPage;
	}

	@Override
	public String toString() {
		return "PageBuilder [params=" + params + ", totalRowCount=" + totalRowCount + ", totalPageCount="
				+ totalPageCount + ", listNo=" + listNo + ", currentStartPage=" + currentStartPage + ", currentEndPage="
				+ currentEndPage + ", previousStartPage=" + previousStartPage + ", nextStartPage=" + nextStartPage
				+ "]";
	}

	/** ?˜?´ì§? ê³„ì‚° */
	public void build(){
		// DBë¡œë??„° ê²??ƒ‰?œ ?–‰?˜ ?ˆ˜?— ?”°ë¥? ? „ì²´í˜?´ì§??ˆ˜ ê³„ì‚°
		totalPageCount = (int)Math.ceil((double)totalRowCount / params.getPageSize());
		
		// ëª©ë¡ë³? ë²ˆí˜¸
		listNo = (params.getPage() - 1) / params.getPageNum();
		//(1~5): 0, (6~10): 1, (11~15): 2, .....
		
		// ?˜„?¬ ëª©ë¡?˜ ?‹œ?‘?˜?´ì§?ë²ˆí˜¸?? ë§ˆì?ë§‰í˜?´ì§?ë²ˆí˜¸ ê³„ì‚°
		currentStartPage = (listNo * params.getPageNum()) + 1;
		currentEndPage = (listNo * params.getPageNum()) + params.getPageNum();
		
		/*
		if (currentStartPage > totalPageCount){
			currentStartPage = currentStartPage - params.getPageNum() + 1;
		}
		*/
		if (currentEndPage > totalPageCount){
			currentEndPage = totalPageCount;
		}
		
		// ?´? „ ëª©ë¡?˜ ?‹œ?‘?˜?´ì§? ë²ˆí˜¸ ê³„ì‚°
		previousStartPage = currentStartPage - params.getPageNum();
		// ì²«ë²ˆì§? ëª©ë¡?¸ ê²½ìš° 1?˜?´ì§?ë¡? ?„¤? •
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// ?‹¤?Œ ëª©ë¡?˜ ?‹œ?‘?˜?´ì§? ë²ˆí˜¸ ê³„ì‚°
		nextStartPage = currentStartPage + params.getPageNum();
	}
	
	/** ?˜„?¬ ëª©ë¡?—?„œ [ì²˜ìŒ?œ¼ë¡?] ì¶œë ¥ ?—¬ë¶? ë°˜í™˜ */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** ?˜„?¬ ëª©ë¡?—?„œ [??œ¼ë¡?] ì¶œë ¥ ?—¬ë¶? ë°˜í™˜ */
	public boolean isShowLast() {
		return currentEndPage < totalPageCount;
	}
	
	/** ?˜„?¬ ëª©ë¡?—?„œ [?´? „ëª©ë¡] ì¶œë ¥ ?—¬ë¶? ë°˜í™˜ */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** ?˜„?¬ ëª©ë¡?—?„œ [?‹¤?Œëª©ë¡] ì¶œë ¥ ?—¬ë¶? ë°˜í™˜ */
	public boolean isShowNext() {
		return currentEndPage < totalPageCount;
	}
	
	/** ?™?  ì¿¼ë¦¬?Š¤?Š¸ë§? ë°˜í™˜ */
	public String getQueryString(int page) {
		String queryString = "?page=" + page;
		// ì¡°ê±´ê²??ƒ‰?´ ?ˆ?Š” ê²½ìš°
		queryString += params.getType() != null ? "&type=" + params.getType() + "&value=" + params.getValue()  :  "";
		return queryString;
	}
	
	
	/** ?…Œ?Š¤?Š¸?„ ?œ„?•œ main */
	public static void main(String[] args) {
		/** ?‚¬?š©? ?„ ?ƒ?˜?´ì§?, ê²??ƒ‰?œ ?˜•, ê²??ƒ‰ê°?, ?˜?´ì§??— ì¶œë ¥?•  ?–‰?˜ ?ˆ˜, ?˜?´ì§? ?ˆ˜, ?…Œ?´ë¸”ì—?„œ ê²??ƒ‰?œ ?–‰?˜ ?ˆ˜ */
		Params params = new Params(15, null, null, 10, 10);
		int selectCount = 156;
		PageBuilder pageBuilder = new PageBuilder(params, selectCount);
		pageBuilder.build();
		
		System.out.println("ê²??ƒ‰?œ ?–‰?ˆ˜: " + pageBuilder.getTotalRowCount());
		System.out.println("?š”ì²??˜?´ì§?: " + pageBuilder.getParams().getPage());
		
		System.out.println("? „ì²´í˜?´ì§??ˆ˜: " + pageBuilder.getTotalPageCount());
		
		System.out.println("?˜„?¬ëª©ë¡?˜ ?‹œ?‘?˜?´ì§?: " + pageBuilder.getCurrentStartPage());
		System.out.println("?˜„?¬ëª©ë¡?˜ ??˜?´ì§?: " + pageBuilder.getCurrentEndPage());
		
		System.out.println("ì²˜ìŒ?œ¼ë¡? ë³´ì—¬ì£¼ê¸° ?—¬ë¶?: " + pageBuilder.isShowFirst());
		System.out.println("?´? „ëª©ë¡ ë³´ì—¬ì£¼ê¸° ?—¬ë¶?: " + pageBuilder.isShowPrevious());
		
		System.out.println("?‹¤?Œëª©ë¡ ë³´ì—¬ì£¼ê¸° ?—¬ë¶?: " + pageBuilder.isShowNext());
		System.out.println("??œ¼ë¡? ë³´ì—¬ì£¼ê¸° ?—¬ë¶?: " + pageBuilder.isShowLast());
		
		// JSP?—?„œ ?˜?´ì§? ë²ˆí˜¸ ì§ì ‘ ì¶œë ¥ ?‹œ		
		for(int i=pageBuilder.getCurrentStartPage(); i<=pageBuilder.getCurrentEndPage(); i++){
			System.out.print(i + " | ");
		}
		System.out.println();
		
		
		System.out.println("-----------------------------------------------");
		
		// ?´ë¦„ìœ¼ë¡? ê²??ƒ‰ ?‹œ
		Params searchParams = new Params(1, "name", "ê¹?ê¸°ì •", 10, 10);
		int searchCount = 11;
		PageBuilder pageBuilder2 = new PageBuilder(searchParams, searchCount);
		pageBuilder2.build();
		System.out.println("ê²??ƒ‰?œ ?–‰?ˆ˜: " + pageBuilder2.getTotalRowCount());
		System.out.println("?š”ì²??˜?´ì§?: " + pageBuilder2.getParams().getPage());
		
		System.out.println("? „ì²´í˜?´ì§??ˆ˜: " + pageBuilder2.getTotalPageCount());
		
	}
}
