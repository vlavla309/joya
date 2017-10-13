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
 * 회원 목록 조회 작업
 * @author 김형주
 */
public class UserListController implements Controller {
	private UserService userService=new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		final int pageSize=10; //한 화면에 보여줄 회원목록 수
		final int pagiSize=5;	//한 페이지에서 보여줄 페이지번호 수

		String page=request.getParameter("page");
		if(page==null)page="1";
		
		int pageNo=Integer.parseInt(page);
		
		
		Params params=new Params(); //회원 조회시 사용할 조건 Params 객체 생성
		params.setPage(pageNo);
		params.setPageSize(pageSize);
		params.setPageNum(pagiSize);
		
		String type=request.getParameter("type"); //회원 목록 조회시 검색 대상(email, name)
		String value=request.getParameter("value"); //회원 목록 조회시 검색 키워드
		
		if(type!=null)params.setType(type);
		if(value!=null)params.setValue(value);
		
		List<User> users=userService.listByParams(params);
		PageBuilder pageBuilder=new PageBuilder(params, userService.pageCount(params));
		pageBuilder.build();
		
		mav.addObject("users", users);
		mav.addObject("pageBuilder", pageBuilder);
		mav.addObject("params", params);;
	
		mav.setView("/admin/userlist.jsp");

		return mav;
	}
}