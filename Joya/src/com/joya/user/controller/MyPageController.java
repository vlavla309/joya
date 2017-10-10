package com.joya.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.json.simple.JSONObject;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class MyPageController implements Controller{
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String email = request.getParameter("email");
		String referer = request.getParameter("referer");
		User user = userService.read(email);
		String[] tokens = user.getAddress().split(Delimiter.USER_INFO);
		
		if (referer != null) {
			switch (referer) {
			case "1":
				mav.setView("redirect:" + request.getContextPath() + "/mypage/orderlist.joya");
				break;
			case "2":
				mav.setView(request.getContextPath() + "/mypage/pwcheck.joya");
				break;
			default:
				mav.setView("redirect:" + request.getContextPath() + "/mypage/wishlist.joya");
				break;
			}
		} else {
			mav.setView(request.getContextPath() + "/mypage/main.joya");
		}
		
		mav.addObject("user", user);
		mav.addObject("address1", tokens[0]);
//		mav.addObject("address2", tokens[1]);
//		mav.addObject("address3", tokens[2]);
		
		return mav;
	}
}
