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
		
		/*String userEmail = request.getParameter("email");*/
		String userEmail = "joa@joa";
		String page = request.getParameter("page");
		if(page == null)  page = "1";
		int pageCount = Integer.parseInt(page);
		
		//이메일에 따른 전체 위시리스트 수
		int totalCount = wishlistService.listAll(userEmail).size();
		
		//요청 페이지 설정
		int requestPage = goEndPage(pageCount, totalCount, pageSize);
		
		Params params = new Params();
		params.setPageSize(pageSize);
		params.setPageNum(pageNum);
		params.setPage(requestPage);
		
		// 페이징
		List<Wishlist> list = wishlistService.listByParams(userEmail, params);
		/*for (Wishlist wishlist : list) {
			System.out.println(wishlist);
			System.out.println(wishlist.getEmail());
			System.out.println(wishlist.getProductId());
		}*/
		
		// 페이징 계산 유틸리티 생성 및 실행
		PageBuilder pageBuilder = new PageBuilder(params, totalCount);
	    pageBuilder.build();
	    
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/mypage/wishlist.jsp");
		
		return mav;
	}
	
	
	/** 전체 페이지 수 보다 큰 페이지를 요청하였을 때 마지막 페이지 반환 */
	private int goEndPage(int page, int totalContentCount, int pageSize) {
		int totalPageCount = 0;
		totalPageCount = (int)Math.ceil((double)totalContentCount / pageSize); // 전체 페이지 수
		
		if(page > totalPageCount) {
			page = totalPageCount;
		}
		return page;
	}
}