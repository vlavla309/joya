package com.joya.article.dao;

import java.util.List;

import com.joya.article.domain.Article;
import com.joya.common.web.Params;

public interface ArticleDao {
	
	/** 글 등록 */
	public void create(Article article);
	
	/** 상품평 등록 */
	public void review(Article article);
	
	/** 전체 글 목록 */
	public List<Article> listAll();
	
	/** 게시글 상세보기 */
	public Article read(int articleId);
	
	/** 글 수정 */
	public void edit(Article article);
	
	/** 글 삭제 */
	public void delete(Article article);
	
	/** 답글등록(관리자) */
	public void reply(Article article);
	
	/** 게시글 조회수 증가 */
	public void count(int articleId);
	
	/** 선택페이지, 검색유형, 검색값, 한페이지당 출력 행수에 대한 글목록 반환 */
	public List<Article> listByParams(Params params);
	
	/** 출력페이지 계산을 위한 검색유형, 검색값에 대한 행의 수 반환 */
	public int pageCount(Params params);
	
}
