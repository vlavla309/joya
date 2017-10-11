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

public class ReplyArticleController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("reply 컨트롤러~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(request.getParameter("articleId"));
		
		ModelAndView mav = new ModelAndView();
		
		int articleId = Integer.parseInt(request.getParameter("articleid"));
		
		String boardId = request.getParameter("boardid");
		
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String passwd = request.getParameter("passwd");
		String contents = request.getParameter("contents");
		
		Article article = new Article();
		article.setArticleId(articleId);
		article.setEmail(email);
		article.setTitle(title);
		article.setWriter(writer);
		article.setPasswd(passwd);
		article.setContents(contents);
		
		articleService.reply(article);
		
		mav.addObject("article", article);
		if(boardId != null) {
			switch(boardId) {
			case "1":
				mav.setView("redirect:/boards/qnalist.joya");
				break;
			case "2":
				mav.setView("redirect:/boards/qnalist.joya");
				break;
			case "3":
				mav.setView("redirect:/boards/aslist.joya");
				break;
			case "4":
				mav.setView("redirect:/boards/aslist.joya");
				break;	
			}
		}

		return mav;
	}

}
