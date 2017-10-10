package com.joya.order.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class OrderAddFormController implements Controller{
	ProductService productServ=new ProductServiceImpl();
	ImageService imgServ =new ImageServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		UserService userserv=new UserServiceImpl();
		String loginuser = (String)request.getAttribute("email");
		User user=null;
		
		Map<String, String> cartMap=new HashMap<String, String>();
		Map<String,Product> products=new HashMap<String,Product>();
		Map<String,Images> images=new HashMap<String,Images>();


		Cookie[] cookies=request.getCookies();
		String cartCookieVal=" ";
		if(cookies!=null){
			for(Cookie cookie:cookies) {
				if(cookie.getName().equalsIgnoreCase("cart")) {
					cartCookieVal=URLDecoder.decode(cookie.getValue(), "utf-8");
					break;
				}
			}
		}

		cartMap=getCartMap(cartCookieVal);

		for(String k:cartMap.keySet()) {
			Product product=productServ.read(Integer.parseInt(k));
			products.put(product.getProductId()+"",product);
			List<Images> imgs=imgServ.listByProductid(Integer.parseInt(k));
			for (Images img:imgs) {
				if(img.getOrderNo()==0) {
					images.put(k, img);
					break;
				}
			}
		}
		
		mav.addObject("cart", cartMap);
		mav.addObject("products", products);
		mav.addObject("images", images);
		
		if(loginuser !=null) {
			user = userserv.read(loginuser);
			mav.addObject("user", user);
		    mav.setView("/order/order_form.jsp");
		}else {
			mav.setView("/user/login3.jsp");
		}
	    return mav;
	}
	
	private Map<String, String> getCartMap(String cartCookieVal) {
		Map<String, String> cartMap=new HashMap<>();

		if(!cartCookieVal.equals(" ")) {
			String[] cartItems=cartCookieVal.split(Delimiter.CART_ITEM);
			for (String item : cartItems) {
				String productId=item.split(Delimiter.CART_ITEM_INFO)[0];
				String amount=item.split(Delimiter.CART_ITEM_INFO)[1];
				cartMap.put(productId, amount);
			}
		}

		return cartMap;
	}
}
