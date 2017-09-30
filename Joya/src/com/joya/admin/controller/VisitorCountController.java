package com.joya.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;


/**
 * 
 * @author 김형주
 *
 */
public class VisitorCountController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		String date=request.getParameter("date");
		if(date==null) {
			
		}
		
		mav.addObject("date", date);
		
		mav.setView("/admin/pages/visitor_count.jsp");

		return mav;



	}

}


