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

public class DeleteArticleController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		System.out.println("삭제 컨트롤러*******************");
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		int articleId = Integer.parseInt(request.getParameter("articleid"));
		
		Article article = new Article();
		article.setArticleId(articleId);
		
		articleService.delete(article);
		System.out.println("삭제11111111111");
		
		mav.addObject("article", article);
		mav.setView("redirect:/boards/qnalist.joya");
		
		System.out.println("삭제2222222222222");
		
		return mav;
		
		
	}

}
