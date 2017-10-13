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

/**
 * 주문 폼 들어가기전에 실행되는 컨트롤러
 * 사용자의 정보를 가져오고, 주문을 진행할 상품들의 정보와 이미지를 가져오기 위한 컨트롤러 
 * @author 한수진
 *
 */
public class OrderAddFormController implements Controller{
	ProductService productServ=new ProductServiceImpl();
	ImageService imgServ =new ImageServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		UserService userserv=new UserServiceImpl();
		String loginuser = (String)request.getAttribute("email");
		String type = request.getParameter("type");
		User user=null;
		
		Map<String, String> cartMap=new HashMap<String, String>();
		Map<String,Product> products=new HashMap<String,Product>();
		Map<String,Images> images=new HashMap<String,Images>();
		
		/* 쿠키에 있는 cart를 리스트로  가져온다. */
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

		/* cart에 있는 productid를 가지고 상품정보를 map객체로 가져온다. 
		또한 해당상품에 대한 image도 가져온다. image는 order_no가 0 인것(title 이미지)으로 가져온다.*/
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
		
		/* cart, product, image를 map으로 order폼에 반환 */
		mav.addObject("cart", cartMap);
		mav.addObject("products", products);
		mav.addObject("images", images);
		
		/* 회원이면 바로 주문폼으로 이동 */
		if(loginuser !=null) {
			user = userserv.read(loginuser);
			mav.addObject("user", user);
		    mav.setView("/order/order_form.jsp");
		}else {
			/* 비회원일 경우 바로 주문폼으로 이동하는 것이 아니라, login3 폼을 거친다.*/
			if(type !=null && type.equals("guest")) {
				mav.setView("/order/order_form.jsp");
			}else {
				/* login폼에서 type을 guest로 반환한다. */
				mav.setView("/user/login3.jsp");
			}
		}
	    return mav;
	}
	
	/* 쿠키에 저장되어있는 상품정보들이 string으로 되어있어서 파싱을 처리를 하고 map객체로 반환 */
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
