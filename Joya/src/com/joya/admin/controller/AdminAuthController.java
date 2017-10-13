package com.joya.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

/**
 * 관리자페이지 로그인 작업
 * @author 김형주
 */
public class AdminAuthController implements Controller {

	private UserService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		final int USER_ADMIN=1;
		ModelAndView mav = new ModelAndView();
		String location = "/admin/index.joya";
		
		// Post일 경우 로그인 작업
		if(request.getMethod().equalsIgnoreCase("post")) {
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			
			//회원 여부를 확인
			User user = userService.isMember(email, passwd);
			if(user != null){
				if(user.getType()==USER_ADMIN){	
					String adminInfo = null;
					try {
						//
						adminInfo = URLEncoder.encode(user.getEmail() + Delimiter.USER_INFO + user.getName(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						throw new ServletException("AdminAuthController.handleRequest() 실행 중 예외 발생..", e);
					}
					Cookie loginCookie = new Cookie("admin", adminInfo);
					loginCookie.setPath("/");
					response.addCookie(loginCookie);
				}
			} else {
				location = "/admin/login.joya?status=err";
			}
		}else {// Get방식일 경우 로그아웃
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equalsIgnoreCase("admin")) {
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
