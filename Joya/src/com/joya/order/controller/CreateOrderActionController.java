package com.joya.order.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.order.domain.Orders;
import com.joya.order.service.OrderService;
import com.joya.order.service.OrderServiceImpl;
import com.joya.orderitem.domain.OrderItems;
import com.joya.orderitem.service.OrderItemService;
import com.joya.orderitem.service.OrderItemServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;

public class CreateOrderActionController implements Controller {
	OrderService orderServ=new OrderServiceImpl();
	OrderItemService orderItemServ=new OrderItemServiceImpl();
	ProductService productServ=new ProductServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		int orderId=orderServ.getNewOrderId();
		
		String email=request.getParameter("email");
		int price=0;
		String orderer=request.getParameter("orderer");
		String receiver=request.getParameter("receiver");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String status = "주문접수";
		String paymentType=request.getParameter("paymentType");
		
		int usedpoint=0;
		String usedpointStr=request.getParameter("usedpoint");
		if(usedpointStr!=null) {
			usedpoint=Integer.parseInt(usedpointStr);
		}
		
		List<OrderItems> orderItems=null;
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equalsIgnoreCase("cart")) {
				String cartInfo = URLDecoder.decode(cookie.getValue(), "utf-8");
				orderItems=makeOrderItems(orderId, cartInfo);
			}
		}
		
		
		for (OrderItems orderItem : orderItems) {
			int productId=orderItem.getProductId();
			Product product=productServ.read(productId);
			price+=orderItem.getAmount()*product.getPrice();
			//orderItemServ.create(orderItem);
		}
		
		Orders order=new Orders();
		order.setEmail(email);
		order.setOrderId(orderId);
		order.setPrice(price);
		order.setOrderer(orderer);
		order.setReceiver(receiver);
		order.setAddress(address);
		order.setPhone(phone);
		order.setStatus(status);
		order.setPaymentType(paymentType);
		order.setUsedPoint(usedpoint);
		
		
		//orderServ.create(order);

		
	//	mav.setView("/product/list.jsp");
		return mav;
	}
	
	private List<OrderItems> makeOrderItems(int orderId, String cookieValue){
		List<OrderItems> list=new ArrayList<OrderItems>();
		String[] cartItems=cookieValue.split(Delimiter.CART_ITEM);
		for (String item : cartItems) {
			String productId=item.split(Delimiter.CART_ITEM_INFO)[0];
			String amount=item.split(Delimiter.CART_ITEM_INFO)[1];
			OrderItems orderItem=new OrderItems(Integer.parseInt(productId),orderId,Integer.parseInt(amount));
			list.add(orderItem);
		}
		return list;
	}
}
