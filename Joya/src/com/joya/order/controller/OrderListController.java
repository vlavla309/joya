package com.joya.order.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Params;

public class OrderListController implements Controller {
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {

		ModelAndView mav = new ModelAndView();

		int pageSize = 16;
		int pageNum = 5;
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		int pageCount = Integer.parseInt(page);
		String type = request.getParameter("type");
		String value = request.getParameter("value");

		Params param = new Params();
		param.setPage(pageCount);
		param.setPageNum(pageNum);
		param.setPageSize(pageSize);

		if (value != null) {
			param.setType("email");
			param.setValue(value);
		}
		
		// mav.addObject("order", order);
		mav.setView("/order/list.joya");

		return mav;
	}

}
