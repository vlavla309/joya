package com.joya.wishlist.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * 위시리스트 삭제 컨트롤러
 *
 * @author 정지현
 *
 */
public class WishlistDeleteController implements Controller {
	
	private WishlistService wishlistService = new WishlistServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		String userEmail = request.getParameter("email");
		String id = request.getParameter("productId");
		String page = request.getParameter("page");
		int productId = Integer.parseInt(id);
		
		PrintWriter out;
		response.setContentType("text/plain;charset=utf-8");
		
		boolean state = wishlistService.delete(userEmail, productId);
		
		try {
			out = response.getWriter();
			out.println(state);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mav.setView("redirect:/mypage/wishlist.joya?page=" + page);
		return mav;
	}
}

