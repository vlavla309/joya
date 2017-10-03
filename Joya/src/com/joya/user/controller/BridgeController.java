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
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class BridgeController implements Controller{
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String email = request.getParameter("email");
		String cancel = request.getParameter("cancel");
		User user = userService.read(email);
		String[] tokens = user.getAddress().split("###");
		
		if (cancel != null) {
			mav.setView(request.getContextPath() + "/mypage/main.joya");
		} else {
			mav.setView(request.getContextPath() + "/mypage/modify_user.joya");
		}
		
		mav.addObject("user", user);
		mav.addObject("address1", tokens[0]);
		mav.addObject("address2", tokens[1]);
		mav.addObject("address3", tokens[2]);
		
		return mav;
	}
}
