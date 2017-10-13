package com.joya.order.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.article.domain.Article;
import com.joya.article.service.ArticleService;
import com.joya.article.service.ArticleServiceImpl;
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

/**
 * 주문에 대한 상품 정보들을 보여줌
 * @author 한수진
 *
 */
public class OrderDetailController implements Controller{
	
	private ProductService productservice = new ProductServiceImpl();
	private ImageService imgService= new ImageServiceImpl();
	private OrderItemService itemserv = new OrderItemServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		List<OrderItems> itemlist = itemserv.listByOrderID(Integer.parseInt(request.getParameter("orderid")));
		Map<Integer,Product> products=new HashMap<Integer,Product>();
		Map<Integer,Images> images=new HashMap<Integer,Images>();
		Map<Integer, Article> articles =new HashMap<Integer,Article>();
		String name = (String)request.getAttribute("name");
		
		for (OrderItems orderItems : itemlist) {
			Product product = productservice.read(orderItems.getProductId());
			products.put(orderItems.getProductId(),product);
			
			// 주문한 상품에 대해서 상품평을 썻는지 안썻는지 구분을 하기 위해서 article을 가져온다.
			// 사용자가 상품에 상품평을 한번밖에 못쓰기때문에 article에서 productid와 사용자만으로 구분이 가능함. 
			Article article = articleService.searchReview(orderItems.getProductId(), name, 3);
			articles.put(orderItems.getProductId(), article);
			
			List<Images> imgs=imgService.listByProductid(orderItems.getProductId());

			// 이미지는 title이미지만 가져와서 map객체로 반환
			for (Images img:imgs) {
				if(img.getOrderNo()==0) {
					images.put(orderItems.getProductId(), img);
					break;
				}
			}
			
		}
		
		mav.addObject("articles", articles);
		mav.addObject("name", name);
		mav.addObject("status", request.getParameter("status"));
		mav.addObject("products", products);
		mav.addObject("images", images);
		mav.addObject("itemlist", itemlist);
		mav.setView("/order/detail.joya");
		
		return mav;
	}

}
