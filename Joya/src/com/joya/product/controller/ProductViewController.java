package com.joya.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;

public class ProductViewController implements Controller{
	private ProductService productservice = new ProductServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		String productid = request.getParameter("productid");
		String type = request.getParameter("type");
		Product product = productservice.read(Integer.parseInt(productid));
		
		
		if(type.equals("quick")) {
			JSONObject jsonMain = new JSONObject();
			JSONArray jArray = new JSONArray();
			
			JSONObject obj = new JSONObject();
			obj.put("productid", product.getProductId());
			obj.put("productname", product.getProductName());
			obj.put("price", product.getPrice());
			obj.put("amount", product.getAmount());
			obj.put("maker", product.getMaker());
			obj.put("hitcount", product.getHitcount());
			obj.put("categoryname", product.getCategoryName());
			obj.put("discription", product.getProductDesc());
			
			jArray.add(0, obj);
			
			jsonMain.put("Product", jArray);
			
			String str = jsonMain.toJSONString();
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
			
		}else {
			mav.addObject("product", product);
			mav.setView("/product/product.jsp");
			return mav;
		}
		
		
		
	}

}
