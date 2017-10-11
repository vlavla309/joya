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

public class UpdateActionController implements Controller {

	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		request.setCharacterEncoding("utf-8");
		System.out.println("수정 전 액션 컨트롤러--------------");
		int articleId = Integer.parseInt(request.getParameter("articleid"));
		String boardId = request.getParameter("boardid");

		Article article = new Article();
		article = articleService.read(articleId);

		mav.addObject("article", article);
		if(boardId != null) {
			switch(boardId) {
			case "1":
				mav.setView("/boards/editingqna.jsp");
				break;
			case "2":
				mav.setView("/boards/editingqna.jsp");
				break;
			case "3":
				mav.setView("/boards/editingas.jsp");
				break;
			case "4":
				mav.setView("/boards/editingas.jsp");
				break;	
			}
		}

		return mav;
	}

}
