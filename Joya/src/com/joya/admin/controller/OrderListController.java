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


/**
 * 관리자페이지에서 주문목록 조회
 * @author 김형주
 */
public class OrderListController implements Controller {
	private OrderService orderServ=new OrderServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		final int pageSize=10; //한 페이지에 보여줄 주문 수
		final int pagiSize=5;	//한 번에 보여줄 페이지 번호 수

		String page=request.getParameter("page");	//요청 페이지 번호
		if(page==null)page="1";	//요청한 페이지번호가 없을 경우 기본 1페이지
		
		int pageNo=Integer.parseInt(page); //정수로 변환
		
		Params params=new Params(); //리스트 조회시 사용할 파라메터 객체 생성
		params.setPage(pageNo);
		params.setPageSize(pageSize);
		params.setPageNum(pagiSize);
		
		String type=request.getParameter("type");	//검색 대상 선택 (email, orderer)
		String value=request.getParameter("target");	//검색 키워드
		String status=request.getParameter("status");	//주문상태 필터 (주문접수, 주문취소, 전체, ...)
		if(status!=null&&status.equals("전체"))status=null; //주문상태를 지정하지 않을 경우 전체 주문상태의 주문 조호
		if(type!=null)params.setType(type);
		if(value!=null)params.setValue(value);
		
		List<Orders> orders=orderServ.listByParam(params, status);	//서비스를 통해 주문 목록 가져오기
		PageBuilder pageBuilder=new PageBuilder(params, orderServ.pageCount(params, status)); //조건에 맞는 주문의 갯수
		pageBuilder.build(); //페이지 번호 출력에 필요한 정보를 계산
		
		
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

	


