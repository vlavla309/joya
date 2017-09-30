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
 * 게시글 등록 처리
 * 
 * 
 * @author 김미소
 */
public class QnAController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		if(email.equals("anonymous@naver.com")) {
			
		}
		String writer = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String contents = request.getParameter("contents");
		
		Article article = new Article();
		article.setTitle(title);
		article.setWriter(writer);
		article.setPasswd(passwd);
		article.setContents(contents);
		
		articleService.create(article);
		
		mav.addObject("article", article);
		mav.setView("/boards/qna.jsp");
		
		
		return null;
	}

}
