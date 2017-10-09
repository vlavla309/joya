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

import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

/**
 * ?���??��?��메터 ?���??��코딩 처리 ?��?��
 */
public class LoginCheckFilter implements Filter {
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{ 
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String email = null;
		String name = null;
		String passwd = null;

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("user")) {
					
					String user = URLDecoder.decode(cookie.getValue(), "utf-8");
	                String[] tokens = user.split(Delimiter.USER_INFO);
	                email = tokens[0];
	                System.out.println(email);
	                /*name = tokens[1];
	                passwd = tokens[2];*/
					
					UserService userService = new UserServiceImpl();
					
					User userinfo = userService.read(email);
					name = userinfo.getName();
					passwd = userinfo.getPasswd();
					System.out.println(name);
				}
			}
		}
		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("passwd", passwd);
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {	}

	

}
