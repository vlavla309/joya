package com.joya.common.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ?μ²???Όλ©ν° ?κΈ??Έμ½λ© μ²λ¦¬ ??°
 */
public class CharacterEncodingFilter implements Filter {
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ? μ²λ¦¬
		if(encoding != null){
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
		// ?μ²λ¦¬
	}

	@Override
	public void destroy() {	}

	

}
