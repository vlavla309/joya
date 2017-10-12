package com.joya.article.service;

import java.sql.ResultSet;
import java.util.List;

import com.joya.article.domain.Article;
import com.joya.common.web.Params;

public interface ArticleService {
	
	/** Q&A, 공지 게시글, A/S, 상품평 게시글 등록 */
	public void create(Article article, String articleType);
	
	/** 전체 글 목록 */
	public List<Article> listAll();
	
	/** 게시글 상세보기 */
	public Article read(int articleId);
	
	/** 상품평 조회 */
	public Article searchReview(int productId, String email, int boardId);
	
	/** 글 수정 */
	public boolean edit(Article article);
	
	/** 글 삭제 */
	public boolean delete(Article article);
	
	/** 답글등록(관리자) */
	public void reply(Article article);
	
	/** 게시글 조회수 증가 */
	public void count(int articleId);
	
	/** 선택페이지, 검색유형, 검색값, 한페이지당 출력 행수에 대한 글목록 반환 */
	public List<Article> listByParams(Params params, int boardId);
	public List<Article> listByParams(Params params, int boardId, int productid);
	
	/** 출력페이지 계산을 위한 검색유형, 검색값에 대한 행의 수 반환 */
	public int pageCount(Params params, int boardId);

}
