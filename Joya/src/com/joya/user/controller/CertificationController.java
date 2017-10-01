package com.joya.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class CertificationController implements Controller {

	private UserService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		String location = "/index.joya";

		// 로그인
		if(request.getMethod().equalsIgnoreCase("post")) {
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String referer = request.getParameter("referer");

			User user = userService.isMember(email, passwd);
			if(user != null){
				String userInfo = null;
				try {
					userInfo = URLEncoder.encode(user.getEmail() + "###" + user.getName(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new ServletException("UserAuthController.handleRequest() 실행중 예외 발생", e);
				}
				Cookie loginCookie = new Cookie("user", userInfo);
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
				if(referer != null) {
					if(referer.contains("/user/login.joya")) {
						location = "/index.joya";
					} else {
						location = referer;
					}
					}
				} else {
					location = "/user/login.joya";
				}
			}else {// 로그아웃
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
		}
		mav.setView("redirect:"+request.getContextPath() + location);
		return mav;
	}
}
