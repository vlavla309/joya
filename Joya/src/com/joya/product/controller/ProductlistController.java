package com.joya.product.controller;

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
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;

public class ProductlistController implements Controller{
	private ImageService imgService= new ImageServiceImpl();
	private ProductService productservice = new ProductServiceImpl();
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		List<Images> imglist = imgService.listAll();
		
		//List<Product> productlist = productservice.listByParams(null, null, null);
		
		mav.addObject("imglist", imglist);
		//mav.addObject("productlist", productlist);
		
		mav.setView("/product/list.jsp");
		
		
		return mav;
	}

}
