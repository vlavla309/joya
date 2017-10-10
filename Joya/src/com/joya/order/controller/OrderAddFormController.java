package com.joya.order.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class OrderAddFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		UserService userserv=new UserServiceImpl();
		
		User user = userserv.read((String)request.getAttribute("email"));
		System.out.println("[user] : "+ user);
		mav.addObject("user", user);
	    mav.setView("/order/order_form.jsp");
	    return mav;
		
	}

}
