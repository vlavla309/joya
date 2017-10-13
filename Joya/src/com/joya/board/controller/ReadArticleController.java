package com.joya.board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.article.domain.Article;
import com.joya.article.service.ArticleService;
import com.joya.article.service.ArticleServiceImpl;
import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;

/**
 * 게시글 보기 작업
 * @author 김미소
 *
 */
public class ReadArticleController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		int articleId = Integer.parseInt(request.getParameter("articleid"));
		String boardId = request.getParameter("boardid");
		
		Article article = new Article();
		
		articleService.count(articleId);	//해당 게시글의 조회수 증가
		article = articleService.read(articleId);	//게시글 정보 조회
		
		mav.addObject("article", article);
		
		//게시판 별 뷰 설정
		if(boardId != null) {
			switch(boardId) {
			case "1":
				mav.setView("/boards/readnotice.jsp");
				break;
			case "2":
				mav.setView("/boards/readingqna.jsp");
				break;
			case "3":
				mav.setView("/boards/readreview.jsp");
				break;
			case "4":
				mav.setView("/boards/readingas.jsp");
				break;	
			}
		}
		return mav;
	}
}
