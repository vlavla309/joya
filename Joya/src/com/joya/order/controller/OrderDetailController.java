package com.joya.order.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.orderitem.domain.OrderItems;
import com.joya.orderitem.service.OrderItemService;
import com.joya.orderitem.service.OrderItemServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;

public class OrderDetailController implements Controller{
	private ProductService productservice = new ProductServiceImpl();
	private ImageService imgService= new ImageServiceImpl();
	private OrderItemService itemserv = new OrderItemServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		List<OrderItems> itemlist = itemserv.listByOrderID(Integer.parseInt(request.getParameter("orderid")));
		Map<Integer,Product> products=new HashMap<Integer,Product>();
		Map<Integer,Images> images=new HashMap<Integer,Images>();
		
		for (OrderItems orderItems : itemlist) {
			Product product = productservice.read(orderItems.getProductId());
			products.put(orderItems.getProductId(),product);
			List<Images> imgs=imgService.listByProductid(orderItems.getProductId());
			for (Images img:imgs) {
				if(img.getOrderNo()==0) {
					images.put(orderItems.getProductId(), img);
					break;
				}
			}
		}
		
		mav.addObject("status", request.getParameter("status"));
		mav.addObject("products", products);
		mav.addObject("images", images);
		mav.addObject("itemlist", itemlist);
		mav.setView("/order/detail.joya");
		
		return mav;
	}

}
