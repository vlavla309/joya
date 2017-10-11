package com.joya.wishlist.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.wishlist.service.WishlistService;
import com.joya.wishlist.service.WishlistServiceImpl;

/**
 * ���ø���Ʈ ���� ��Ʈ�ѷ�
 *
 * @author �Ѽ���
 *
 */
public class WishlistCreateController implements Controller{
	
	private WishlistService wishlistService = new WishlistServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		int productId = Integer.parseInt(request.getParameter("productId"));
		String url ="";
		
		wishlistService.insert((String) request.getAttribute("email"), productId);
		url = request.getHeader("REFERER");
		System.out.println("이전페이지 url 출력해보기 : "+url);
			

		mav.setView("redirect:"+url);
		return mav;
	}

}