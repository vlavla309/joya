package com.joya.admin.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class UserListController implements Controller {
	private UserService userService=new UserServiceImpl(); 

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		final int pageSize=10;
		final int pagiSize=5;

		String page=request.getParameter("page");
		if(page==null)page="1";
		
		int pageNo=Integer.parseInt(page);
		
		Params params=new Params();
		params.setPage(pageNo);
		params.setPageSize(pageSize);
		params.setPageNum(pagiSize);
		
		String type=request.getParameter("type");
		String value=request.getParameter("value");
		
		if(type!=null)params.setType(type);
		if(value!=null)params.setValue(value);
		
		List<User> users=userService.listByParams(params);
		PageBuilder pageBuilder=new PageBuilder(params, userService.pageCount(params));
		pageBuilder.build();
		
		mav.addObject("users", users);
		mav.addObject("pageBuilder", pageBuilder);
		mav.addObject("params", params);;
	
		System.out.println("/admin/pages/userlist.jsp");
		mav.setView("/admin/pages/userlist.jsp");

		return mav;
	}

}




