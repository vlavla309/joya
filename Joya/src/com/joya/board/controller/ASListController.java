package com.joya.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.article.domain.Article;
import com.joya.article.service.ArticleService;
import com.joya.article.service.ArticleServiceImpl;
import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.PageBuilder;
import com.joya.common.web.Params;

/**
 * A/S게시판 게시글 조회
 * @author 김미소
 */
public class ASListController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		int pageSize = 10; // 한 화면에서 보여줄 게시글 갯수
		int pageNum = 5; //한 화면에서 보여줄 페이지번호 수
		
		//요청시 전달 받은 매개변수
		String page = request.getParameter("page");
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		
		if(page == null) page = "1";
		int pageCount = Integer.parseInt(page);
		
		Params params = new Params();
		params.setPage(pageCount);
		params.setPageSize(pageSize);
		params.setPageNum(pageNum);
		params.setType(type);
		params.setValue(value);
		
		
		//페이징 처리 및 검색 조건에 맞는 게시글 조회
		List<Article> list = articleService.listByParams(params, 4);
		int rowCount = articleService.pageCount(params, 4);
		
		//페이징 계산 유틸리티 생성 및 실행
		PageBuilder pb = new PageBuilder(params, rowCount);
		pb.build();
		
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pb", pb);
		
		mav.setView("/boards/as.jsp");
		return mav;
	}

}
