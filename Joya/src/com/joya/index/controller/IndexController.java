package com.joya.index.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Params;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;
import com.joya.wishlist.domain.Wishlist;
import com.joya.wishlist.service.WishlistService;
import com.joya.wishlist.service.WishlistServiceImpl;

/**
 * 메인 페이지 컨트롤러
 *
 * @author 김형주	
 *
 */
public class IndexController implements Controller{
	private ImageService imgService= new ImageServiceImpl();
	private ProductService productservice = new ProductServiceImpl();
	private WishlistService wishlistService = new WishlistServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {

		ModelAndView mav = new ModelAndView();
		int pageSize = 6;


		Params param = new Params();
		param.setPageSize(pageSize);

		List<Product> productlist = productservice.listByParams(param, "전체",  "newProduct");
		List<Images> imglist = imgService.listAll();
		Map<Integer,String> imgs=new HashMap<Integer,String>();
		
		for (Product product : productlist) {
			for (Images images : imglist) {
				if((images.getProductId()==product.getProductId()) && images.getOrderNo()==0) {
					String path=images.getPath()+images.getImageName();
					imgs.put(product.getProductId(), path);
					break;
				}
			}
		}
		
		List<Wishlist> wishlist = wishlistService.listAll();

		

		mav.addObject("loginuser", (String)request.getAttribute("email"));
		mav.addObject("imgs", imgs);
		mav.addObject("wishlist", wishlist);
		mav.addObject("productlist", productlist);
		mav.setView("/index.jsp");
		return mav;
	}

}