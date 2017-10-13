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
 * 게시글 삭제 작업
 * @author 김미소
 */
public class DeleteArticleController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		int articleId = Integer.parseInt(request.getParameter("articleid"));
		
		Article article = new Article();
		article.setArticleId(articleId);
		
		articleService.delete(article);
		
		mav.addObject("article", article);
		mav.setView("redirect:/boards/qnalist.joya");
		
		return mav;
	}
}