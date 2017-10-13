package com.joya.common.web;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

/**
 * 로그인 여부 체크하는 필터
 * @author 최명승
 */
public class LoginCheckFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String email = null;
		String name = null;
		User userinfo = null;
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("user")) {
					String user = URLDecoder.decode(cookie.getValue(), "utf-8");
	                String[] tokens = user.split(Delimiter.USER_INFO);
	                email = tokens[0];
					UserService userService = new UserServiceImpl();
					userinfo = userService.read(email);
					name = userinfo.getName();
				}
			}
		}
			request.setAttribute("email", email);
			request.setAttribute("name", name);
			chain.doFilter(request, response);
	}

	@Override
	public void destroy() {	}

}
