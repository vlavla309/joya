package com.joya.user.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

/**
 * 회원탈퇴 컨트롤러
 *
 * @author 최명승
 *
 */
public class CloseAccountController implements Controller  {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String email = request.getParameter("email");
		
		userService.delete(email);
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("user")) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		} 
		
		mav.setView("redirect:" + request.getContextPath() + "/index.joya");
		
		return mav;
	}
}
