package com.joya.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

/**
 * 비밀번호 일치 확인 컨트롤러
 *
 * @author 최명승
 *
 */
public class CheckPasswdController implements Controller{
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/plain;charset=utf-8");
		User user = null;
		PrintWriter out;
		
		try {
			user = userService.isMember(email, passwd);
			out = response.getWriter();
			if (user != null) {
				out.println("true");
			} else {
				out.println("false");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
