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

/**
 * 비밀번호/회원정보 연결 컨트롤러
 *
 * @author 최명승
 *
 */
public class BridgeController implements Controller{
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String email = request.getParameter("email");
		User user = userService.read(email);
		String[] tokens = user.getAddress().split(Delimiter.USER_INFO);
		
			mav.setView(request.getContextPath() + "/mypage/modifyuser.joya");
		
		mav.addObject("user", user);
		mav.addObject("address1", tokens[0]);
		mav.addObject("address2", tokens[1]);
		mav.addObject("address3", tokens[2]);
		
		return mav;
	}
}
