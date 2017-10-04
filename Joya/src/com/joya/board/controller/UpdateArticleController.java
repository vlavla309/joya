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

public class UpdateArticleController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav = new ModelAndView();
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String passwd = request.getParameter("passwd");
		
		Article article = new Article();
		article.setArticleId(articleId);
		article.setTitle(title);
		article.setContents(contents);
		article.setPasswd(passwd);
		
		articleService.edit(article);
		
		mav.addObject("article", article);
		mav.setView("redirect:/boards/qnalist.joya");
		
		return mav;
	}

}
