package com.joya.common.web;

/**
 * ?��?���? 계산 �? ?��?���? 번호(1|2|3|4|5....) 출력?�� 각각?�� JSP?��?�� 처리?���? ?���?,
 * ?��?��?��?�� ?�� ?��?���? ?��?��리티 ?��?��?�� ?��?��
 * @author �?기정
 */
public class PageBuilder {
	
	private Params params;            /** ?���? ?��?��메터 */
	
	private int totalRowCount;        /** ?��?��블로�??�� �??��?�� ?��?�� ?�� */
	private int totalPageCount;       /** ?��?��?�� ?���? ?��체페?���? ?�� */
	private int listNo;               /** 목록 번호 */
	private int currentStartPage;     /** ?��?�� 목록?�� ?��?��?��?���? 번호 */
	private int currentEndPage;       /** ?��?�� 목록?�� 마�?막페?���? 번호 */
	private int previousStartPage;    /** ?��?�� 목록?�� ?��?��?��?���? 번호 */
	private int nextStartPage;        /** ?��?�� 목록?�� ?��?��?��?���? 번호 */
	
	
	public PageBuilder() {
		this(null, 0);
	}
	
	/**
	 * @param params           ?���? ?��?��메터
	 * @param totalRowCount    �??��???���? �??��?�� ?��?�� ?��
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

	/** ?��?���? 계산 */
	public void build(){
		// DB로�??�� �??��?�� ?��?�� ?��?�� ?���? ?��체페?���??�� 계산
		totalPageCount = (int)Math.ceil((double)totalRowCount / params.getPageSize());
		
		// 목록�? 번호
		listNo = (params.getPage() - 1) / params.getPageNum();
		//(1~5): 0, (6~10): 1, (11~15): 2, .....
		
		// ?��?�� 목록?�� ?��?��?��?���?번호?? 마�?막페?���?번호 계산
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
		
		// ?��?�� 목록?�� ?��?��?��?���? 번호 계산
		previousStartPage = currentStartPage - params.getPageNum();
		// 첫번�? 목록?�� 경우 1?��?���?�? ?��?��
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// ?��?�� 목록?�� ?��?��?��?���? 번호 계산
		nextStartPage = currentStartPage + params.getPageNum();
	}
	
	/** ?��?�� 목록?��?�� [처음?���?] 출력 ?���? 반환 */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** ?��?�� 목록?��?�� [?��?���?] 출력 ?���? 반환 */
	public boolean isShowLast() {
		return currentEndPage < totalPageCount;
	}
	
	/** ?��?�� 목록?��?�� [?��?��목록] 출력 ?���? 반환 */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** ?��?�� 목록?��?�� [?��?��목록] 출력 ?���? 반환 */
	public boolean isShowNext() {
		return currentEndPage < totalPageCount;
	}
	
	/** ?��?�� 쿼리?��?���? 반환 */
	public String getQueryString(int page) {
		String queryString = "?page=" + page;
		// 조건�??��?�� ?��?�� 경우
		queryString += params.getType() != null ? "&type=" + params.getType() + "&value=" + params.getValue()  :  "";
		return queryString;
	}
	
	
	/** ?��?��?��?�� ?��?�� main */
	public static void main(String[] args) {
		/** ?��?��?�� ?��?��?��?���?, �??��?��?��, �??���?, ?��?���??�� 출력?�� ?��?�� ?��, ?��?���? ?��, ?��?��블에?�� �??��?�� ?��?�� ?�� */
		Params params = new Params(15, null, null, 10, 10);
		int selectCount = 156;
		PageBuilder pageBuilder = new PageBuilder(params, selectCount);
		pageBuilder.build();
		
		System.out.println("�??��?�� ?��?��: " + pageBuilder.getTotalRowCount());
		System.out.println("?���??��?���?: " + pageBuilder.getParams().getPage());
		
		System.out.println("?��체페?���??��: " + pageBuilder.getTotalPageCount());
		
		System.out.println("?��?��목록?�� ?��?��?��?���?: " + pageBuilder.getCurrentStartPage());
		System.out.println("?��?��목록?�� ?��?��?���?: " + pageBuilder.getCurrentEndPage());
		
		System.out.println("처음?���? 보여주기 ?���?: " + pageBuilder.isShowFirst());
		System.out.println("?��?��목록 보여주기 ?���?: " + pageBuilder.isShowPrevious());
		
		System.out.println("?��?��목록 보여주기 ?���?: " + pageBuilder.isShowNext());
		System.out.println("?��?���? 보여주기 ?���?: " + pageBuilder.isShowLast());
		
		// JSP?��?�� ?��?���? 번호 직접 출력 ?��		
		for(int i=pageBuilder.getCurrentStartPage(); i<=pageBuilder.getCurrentEndPage(); i++){
			System.out.print(i + " | ");
		}
		System.out.println();
		
		
		System.out.println("-----------------------------------------------");
		
		// ?��름으�? �??�� ?��
		Params searchParams = new Params(1, "name", "�?기정", 10, 10);
		int searchCount = 11;
		PageBuilder pageBuilder2 = new PageBuilder(searchParams, searchCount);
		pageBuilder2.build();
		System.out.println("�??��?�� ?��?��: " + pageBuilder2.getTotalRowCount());
		System.out.println("?���??��?���?: " + pageBuilder2.getParams().getPage());
		
		System.out.println("?��체페?���??��: " + pageBuilder2.getTotalPageCount());
		
	}
}
