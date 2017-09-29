package com.joya.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;


/**
 * 
 * @author 김형주
 *
 */
public class ProductUploadActionController implements Controller {
	private ProductService productService=new ProductServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		
		
		
		
		return null;
	}
}




