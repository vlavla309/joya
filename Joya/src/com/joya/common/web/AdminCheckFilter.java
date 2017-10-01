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
 * 관리자인지 여부 확인 필터
 */
public class AdminCheckFilter implements Filter {
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{ 
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String admin = null;

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("admin")) {
					admin = URLDecoder.decode(cookie.getValue(), "utf-8");
	                String[] tokens = admin.split("###");
	                admin = tokens[1] + "("+tokens[0]+")";
				}
			}
		}
		request.setAttribute("admin", admin);
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {	}

	

}
