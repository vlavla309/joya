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
		String user = null;

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("user")) {
					user = URLDecoder.decode(cookie.getValue(), "utf-8");
	                String[] tokens = user.split(",");
	                user = tokens[1] + "("+tokens[0]+")";
				}
			}
		}
		request.setAttribute("user", user);
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {	}

	

}
