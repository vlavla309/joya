package com.joya.order.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.order.domain.Orders;
import com.joya.order.service.OrderService;
import com.joya.order.service.OrderServiceImpl;

/**
 * 비회원들의 주문조회를 위한 컨트롤러
 * @author 한수진
 *
 */
public class OrderSearchForGuestController implements Controller{
	private OrderService orderServ=new OrderServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		String orderid = request.getParameter("orderno");
		String email = request.getParameter("gstemail");
		Orders order = orderServ.search(orderid, email);
		mav.addObject("orders", order);
		mav.setView("guestlist.joya");
		return mav;
	}

}
