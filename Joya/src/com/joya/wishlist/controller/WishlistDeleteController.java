package com.joya.wishlist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.common.web.PageBuilder;
import com.joya.common.web.Params;
import com.joya.wishlist.domain.Wishlist;
import com.joya.wishlist.service.WishlistService;
import com.joya.wishlist.service.WishlistServiceImpl;

/**
 * ���ø���Ʈ ���� ��Ʈ�ѷ�
 *
 * @author ������
 *
 */
public class WishlistDeleteController implements Controller {
	
	private WishlistService wishlistService = new WishlistServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("productId");
		String page = request.getParameter("page");
		int productId = Integer.parseInt(id);
		PrintWriter out;
		response.setContentType("text/plain;charset=utf-8");
		
		boolean state = wishlistService.delete((String)request.getAttribute("email"), productId);
		
		try {
			out = response.getWriter();
			out.println(state);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String url = request.getHeader("REFERER");
		mav.setView("redirect:"+url);
		return mav;
	}
}