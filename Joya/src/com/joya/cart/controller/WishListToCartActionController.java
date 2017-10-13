package com.joya.cart.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.CartManager;
import com.joya.wishlist.service.WishlistService;
import com.joya.wishlist.service.WishlistServiceImpl;

/**
 * 위시리스트를 장바구니로 이동시키는 작업
 * @author 김형주
 *
 */
public class WishListToCartActionController implements Controller {
	private WishlistService wishlistService = new WishlistServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		String[] productIds = request.getParameterValues("ji-chk");
		String email=(String)request.getAttribute("email");
		Map<String, String> cartMap=null;
		
		String cartCookieVal=CartManager.getCartCookieVal(request);

		cartMap=CartManager.getCartMap(cartCookieVal);

		//장바구니 Map 객체에 위시리스트의 항목을 담고 해당 위시리스트는 DB에서 삭제
		if(productIds!=null) {
			for (String productId : productIds) {
				cartMap.put(productId, "1");
				wishlistService.delete(email, Integer.parseInt(productId));
			}
		}
		
		//장바구니 Map 객체를 쿠키값의 문자열로 변환
		cartCookieVal=CartManager.mapToStrCart(cartMap);
		
		//쿠키에 장바구니 쿠키 저장
		CartManager.setCartCookie(request, response, cartCookieVal);

		mav.setView("redirect:/cart.joya");

		return mav;
	}
}
