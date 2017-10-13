package com.joya.cart.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.CartManager;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;

/**
 * 장바구니 목록 조회 작업
 * @author 김형주
 */
public class CartListController implements Controller {
	ProductService productServ=new ProductServiceImpl();
	ImageService imgServ =new ImageServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		Map<String, String> cartMap;
		Map<String,Product> products=new HashMap<String,Product>();
		Map<String,Images> images=new HashMap<String,Images>();

		String cartCookieVal=CartManager.getCartCookieVal(request);

		cartMap=CartManager.getCartMap(cartCookieVal);

		//장바구니 정보 Map 객체의 키값(상품번호)를 통해 해당 상품의 정보를 조회, 해당 상품의 대표 사진을 각각의 Map객체에 저장
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
		mav.setView("/cart.jsp");
		return mav;
	}
}