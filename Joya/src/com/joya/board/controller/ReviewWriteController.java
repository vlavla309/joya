package com.joya.board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;

/**
 * 상품평 쓰기 작업
 * @author 김미소
 *
 */
public class ReviewWriteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		String productid = request.getParameter("productid");

		mav.addObject("productid", productid);
		mav.addObject("orderid", request.getParameter("orderid"));
		
		mav.setView("/mypage/review_write.joya");
		
		return mav;
	}

}
