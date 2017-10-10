package com.joya.user.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class RegisterController implements Controller{

	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthdate");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String address = address1 + Delimiter.USER_INFO + address2 + Delimiter.USER_INFO + address3;
			
		User user = new User(email, phone, name, passwd ,address, birthdate);
		
		userService.create(user);
		
		mav.setView(request.getContextPath() + "/user/registresult.joya");
		mav.addObject("user", user);
		mav.addObject("address1", address1);
		mav.addObject("address2", address2);
		mav.addObject("address3", address3);
		return mav;
	}
}
