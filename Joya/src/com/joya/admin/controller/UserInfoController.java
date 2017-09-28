package com.joya.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.PageBuilder;
import com.joya.common.web.Params;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;


/**
 * 
 * @author 김형주
 *
 */
public class UserInfoController implements Controller {
	private UserService userService=new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		String email=request.getParameter("email");
		System.out.println(email);
		User user=userService.read(email);
		
		JSONObject json=new JSONObject();
		
		json.put("email", user.getEmail());
		json.put("phone", user.getPhone());
		json.put("name", user.getName());
		json.put("address", user.getAddress());
		json.put("birthdate", user.getBirthdate());
		json.put("point", user.getPoint());
		json.put("type", user.getType());
		json.put("regdate", user.getRegdate());
		
		
		String result=json.toJSONString();
		System.out.println(result);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		try {
			response.getWriter().println(result);
		} catch (IOException e) {e.printStackTrace();}
		
		return null;
	}
}




