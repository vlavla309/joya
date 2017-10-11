package com.joya.admin.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.PageBuilder;
import com.joya.common.web.Params;
import com.joya.order.domain.Orders;
import com.joya.order.service.OrderService;
import com.joya.order.service.OrderServiceImpl;
import com.joya.user.domain.User;


/**
 * 관리자페이지에서 주문목록 조회
 * @author 김형주
 *
 */
public class OrderListController implements Controller {
	private OrderService orderServ=new OrderServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		System.out.println("주문목록 컨트롤러!!");
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
		String value=request.getParameter("target");
		String status=request.getParameter("status");
		if(status!=null&&status.equals("전체"))status=null;
		if(type!=null)params.setType(type);
		if(value!=null)params.setValue(value);
		
		List<Orders> orders=orderServ.listByParam(params, status);
		PageBuilder pageBuilder=new PageBuilder(params, orderServ.pageCount(params, status));
		pageBuilder.build();
		
		System.out.println("status "+status);
		for (Orders order : orders) {
			System.out.println(order);
		}
		
		if(status!=null) {
			mav.addObject("status", status);
		}else mav.addObject("status", "전체");
		mav.addObject("orders", orders);
		mav.addObject("pageBuilder", pageBuilder);
		mav.addObject("params", params);;
	
		mav.setView("/admin/orderlist.jsp");

		return mav;
	}

}




