package com.joya.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;


/**

 * @author 김형주
 *
 */
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		String message = "호야 시작";
	
		mav.addObject("message", message);
		mav.setView("/hello.jsp");
		return mav;
	}

}




