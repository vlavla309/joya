package com.joya.cart.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.wishlist.service.WishlistService;
import com.joya.wishlist.service.WishlistServiceImpl;



public class WishListToCartActionController implements Controller {
	
	private WishlistService wishlistService = new WishlistServiceImpl();
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		String[] productIds = request.getParameterValues("");
		String email=null;
		Map<String, String> cartMap=null;

		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equalsIgnoreCase("cart")) {
				cartMap=getCartMap(cookie.getValue());
				break;
			}
		}
		
		for (String productId : productIds) {
			cartMap.put(productId, "1");
			wishlistService.delete(email, Integer.parseInt(productId));
		}
		
		
		String cartInfo=mapToStrCart(cartMap);
		cookies=request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equalsIgnoreCase("cart")) {
				cookie.setValue(cartInfo);
				response.addCookie(cookie);
				break;
			}
		}
		
		
		mav.setView("/product/list.jsp");
		
		return mav;
	}
	
	private Map<String, String> getCartMap(String cartCookieVal) {
		Map<String, String> cartMap=new HashedMap<>();
		String[] cartItems=cartCookieVal.split(Delimiter.CART_ITEM);
		
		for (String item : cartItems) {
			String productId=item.split(Delimiter.CART_ITEM_INFO)[0];
			String amount=item.split(Delimiter.CART_ITEM_INFO)[1];
			cartMap.put(productId, amount);
		}
		
		return cartMap;
	}

	int i=0;
	private String mapToStrCart(Map<String, String> cartMap) {
		String cartInfo="";
		for(Map.Entry<String, String> entry:cartMap.entrySet()) {
			String productId=entry.getKey();
			String amount=entry.getValue();
			cartInfo+=productId+Delimiter.CART_ITEM_INFO+amount;
			if(++i<cartMap.size()) {
				cartInfo+=Delimiter.CART_ITEM;
			}
		}
		return cartInfo;
	}
}
