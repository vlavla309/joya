package com.joya.common.web;

/**
 * ??΄μ§? κ³μ° λ°? ??΄μ§? λ²νΈ(1|2|3|4|5....) μΆλ ₯? κ°κ°? JSP?? μ²λ¦¬?μ§? ?κ³?,
 * ?¬?¬?©?  ? ??λ‘? ? ?Έλ¦¬ν° ?΄??€ ? ?
 * @author κΉ?κΈ°μ 
 */
public class PageBuilder {
	
	private Params params;            /** ?μ²? ??Όλ©ν° */
	
	private int totalRowCount;        /** ??΄λΈλ‘λΆ??° κ²??? ?? ? */
	private int totalPageCount;       /** ?°?°? ?°λ₯? ? μ²΄ν?΄μ§? ? */
	private int listNo;               /** λͺ©λ‘ λ²νΈ */
	private int currentStartPage;     /** ??¬ λͺ©λ‘? ????΄μ§? λ²νΈ */
	private int currentEndPage;       /** ??¬ λͺ©λ‘? λ§μ?λ§ν?΄μ§? λ²νΈ */
	private int previousStartPage;    /** ?΄?  λͺ©λ‘? ????΄μ§? λ²νΈ */
	private int nextStartPage;        /** ?€? λͺ©λ‘? ????΄μ§? λ²νΈ */
	
	
	public PageBuilder() {
		this(null, 0);
	}
	
	/**
	 * @param params           ?μ²? ??Όλ©ν°
	 * @param totalRowCount    κ²?????λ³? κ²??? ?? ?
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

	/** ??΄μ§? κ³μ° */
	public void build(){
		// DBλ‘λ??° κ²??? ?? ?? ?°λ₯? ? μ²΄ν?΄μ§?? κ³μ°
		totalPageCount = (int)Math.ceil((double)totalRowCount / params.getPageSize());
		
		// λͺ©λ‘λ³? λ²νΈ
		listNo = (params.getPage() - 1) / params.getPageNum();
		//(1~5): 0, (6~10): 1, (11~15): 2, .....
		
		// ??¬ λͺ©λ‘? ????΄μ§?λ²νΈ?? λ§μ?λ§ν?΄μ§?λ²νΈ κ³μ°
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
		
		// ?΄?  λͺ©λ‘? ????΄μ§? λ²νΈ κ³μ°
		previousStartPage = currentStartPage - params.getPageNum();
		// μ²«λ²μ§? λͺ©λ‘?Έ κ²½μ° 1??΄μ§?λ‘? ?€? 
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// ?€? λͺ©λ‘? ????΄μ§? λ²νΈ κ³μ°
		nextStartPage = currentStartPage + params.getPageNum();
	}
	
	/** ??¬ λͺ©λ‘?? [μ²μ?Όλ‘?] μΆλ ₯ ?¬λΆ? λ°ν */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** ??¬ λͺ©λ‘?? [??Όλ‘?] μΆλ ₯ ?¬λΆ? λ°ν */
	public boolean isShowLast() {
		return currentEndPage < totalPageCount;
	}
	
	/** ??¬ λͺ©λ‘?? [?΄? λͺ©λ‘] μΆλ ₯ ?¬λΆ? λ°ν */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** ??¬ λͺ©λ‘?? [?€?λͺ©λ‘] μΆλ ₯ ?¬λΆ? λ°ν */
	public boolean isShowNext() {
		return currentEndPage < totalPageCount;
	}
	
	/** ??  μΏΌλ¦¬?€?Έλ§? λ°ν */
	public String getQueryString(int page) {
		String queryString = "?page=" + page;
		// μ‘°κ±΄κ²???΄ ?? κ²½μ°
		queryString += params.getType() != null ? "&type=" + params.getType() + "&value=" + params.getValue()  :  "";
		return queryString;
	}
	
	
	/** ??€?Έ? ?? main */
	public static void main(String[] args) {
		/** ?¬?©? ? ???΄μ§?, κ²??? ?, κ²??κ°?, ??΄μ§?? μΆλ ₯?  ?? ?, ??΄μ§? ?, ??΄λΈμ? κ²??? ?? ? */
		Params params = new Params(15, null, null, 10, 10);
		int selectCount = 156;
		PageBuilder pageBuilder = new PageBuilder(params, selectCount);
		pageBuilder.build();
		
		System.out.println("κ²??? ??: " + pageBuilder.getTotalRowCount());
		System.out.println("?μ²???΄μ§?: " + pageBuilder.getParams().getPage());
		
		System.out.println("? μ²΄ν?΄μ§??: " + pageBuilder.getTotalPageCount());
		
		System.out.println("??¬λͺ©λ‘? ????΄μ§?: " + pageBuilder.getCurrentStartPage());
		System.out.println("??¬λͺ©λ‘? ???΄μ§?: " + pageBuilder.getCurrentEndPage());
		
		System.out.println("μ²μ?Όλ‘? λ³΄μ¬μ£ΌκΈ° ?¬λΆ?: " + pageBuilder.isShowFirst());
		System.out.println("?΄? λͺ©λ‘ λ³΄μ¬μ£ΌκΈ° ?¬λΆ?: " + pageBuilder.isShowPrevious());
		
		System.out.println("?€?λͺ©λ‘ λ³΄μ¬μ£ΌκΈ° ?¬λΆ?: " + pageBuilder.isShowNext());
		System.out.println("??Όλ‘? λ³΄μ¬μ£ΌκΈ° ?¬λΆ?: " + pageBuilder.isShowLast());
		
		// JSP?? ??΄μ§? λ²νΈ μ§μ  μΆλ ₯ ?		
		for(int i=pageBuilder.getCurrentStartPage(); i<=pageBuilder.getCurrentEndPage(); i++){
			System.out.print(i + " | ");
		}
		System.out.println();
		
		
		System.out.println("-----------------------------------------------");
		
		// ?΄λ¦μΌλ‘? κ²?? ?
		Params searchParams = new Params(1, "name", "κΉ?κΈ°μ ", 10, 10);
		int searchCount = 11;
		PageBuilder pageBuilder2 = new PageBuilder(searchParams, searchCount);
		pageBuilder2.build();
		System.out.println("κ²??? ??: " + pageBuilder2.getTotalRowCount());
		System.out.println("?μ²???΄μ§?: " + pageBuilder2.getParams().getPage());
		
		System.out.println("? μ²΄ν?΄μ§??: " + pageBuilder2.getTotalPageCount());
		
	}
}
