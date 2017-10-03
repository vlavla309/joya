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

public class ReadArticleController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		request.setCharacterEncoding("utf-8");
		System.out.println("readingarticle 컨트롤러--------------");
		System.out.println(request.getParameter("article_id"));
		int articleId = Integer.parseInt(request.getParameter("article_id"));
		
		Article article = new Article();
		
		articleService.count(articleId);
		article = articleService.read(articleId);
		
		mav.addObject("article", article);
		mav.setView("/boards/readingqna.jsp");
		
		return mav;
	}

}
