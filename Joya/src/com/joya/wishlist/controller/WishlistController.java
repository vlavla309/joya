package com.joya.wishlist.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.PageBuilder;
import com.joya.common.web.Params;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.wishlist.domain.Wishlist;
import com.joya.wishlist.service.WishlistService;
import com.joya.wishlist.service.WishlistServiceImpl;


/**
 * 위시리스트 컨트롤러
 *
 * @author 정지현
 *
 */
public class WishlistController implements Controller {
	
	private WishlistService wishlistService = new WishlistServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		int pageSize = 3; // 한페이지에 출력될 위시리스트 수
		int pageNum = 3; // 페이지 그룹 크기
		
		String userEmail = request.getParameter("email");
		String page = request.getParameter("page");
		if(page == null)  page = "1";
		int pageCount = Integer.parseInt(page);
		
		Params params = new Params();
		params.setPage(pageCount);
		params.setPageSize(pageSize);
		params.setPageNum(pageNum);
		
		// 페이징
		List<Wishlist> list = wishlistService.listByParams(userEmail, params);
		int totalCount = wishlistService.listAll(userEmail).size();
		
		// 페이징 계산 유틸리티 생성 및 실행
		PageBuilder pageBuilder = new PageBuilder(params, totalCount);
	    pageBuilder.build();
		
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/mypage/wishlist.jsp");
		
		return mav;
	}

}
