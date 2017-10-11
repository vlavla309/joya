package com.joya.wishlist.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;

public class WishlistToCartActionController implements Controller {
	
	private ImageService imgService= new ImageServiceImpl();
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		List<Images> list = imgService.listAll();
		
		mav.addObject("imglist", list);
		mav.setView("/product/list.jsp");
		
		return mav;
	}

}
