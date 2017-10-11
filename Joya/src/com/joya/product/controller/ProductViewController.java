package com.joya.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.joya.article.domain.Article;
import com.joya.article.service.ArticleService;
import com.joya.article.service.ArticleServiceImpl;
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
 * 상품 상세보기 컨트롤러
 *
 * @author 한수진
 *
 */
public class ProductViewController implements Controller {
	private ProductService productservice = new ProductServiceImpl();
	private ImageService ImageService = new ImageServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	private WishlistService wishlistService = new WishlistServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		String productid = request.getParameter("productid");
		String type = request.getParameter("type");
		Product product = productservice.read(Integer.parseInt(productid));
		List<Images> images = ImageService.listByProductid(Integer.parseInt(productid));

		int pageSize = 16;
		int pageNum = 5;
		String page = request.getParameter("page");
		if (page == null) page = "1";
		int pageCount = Integer.parseInt(page);
		Params param = new Params();
		param.setPage(pageCount);
		param.setPageNum(pageNum);
		param.setPageSize(pageSize);
		
		List<Article> review =articleService.listByParams(param, 3, Integer.parseInt(productid));
		
		for (Article article : review) {
			article.setContents(article.getContents().replaceAll("\r\n","<br>"));
		}
		
		// list에서 quick view를 누르거나, 상세보기 페이지로 이동해서 보여줄 때, 두 가지 경우때문에 type으로 분기함.
		if (type.equals("quick")) {

			JSONObject jsonMain = new JSONObject();
			JSONArray jArray = new JSONArray();

			// product 객체를 jsonobject에 넣기
			JSONObject obj = new JSONObject();
			obj.put("productid", product.getProductId());
			obj.put("productname", product.getProductName());
			obj.put("price", product.getPrice());
			obj.put("amount", product.getAmount());
			obj.put("maker", product.getMaker());
			obj.put("hitcount", product.getHitcount());
			obj.put("categoryname", product.getCategoryName());
			obj.put("discription", product.getProductDes());

			// jsonobject로 만들어진 json product를 배열로 만들기
			jArray.add(0, obj);

			// 배열로 만들어진 json product에 product라는 키,값을 지정함.
			jsonMain.put("Product", jArray);

			// image라는 객체를 jsonobject로 생성
			jArray = new JSONArray();
			int count = 0;
			for (Images image : images) {
				obj = new JSONObject();
				obj.put("path", image.getPath());
				obj.put("filename", image.getImageName());
				obj.put("orderno", image.getOrderNo());
				jArray.add(count, obj);
				count++;
			}
			jsonMain.put("images", jArray);

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

		} else {
			String userEmail = (String)request.getAttribute("email");
			mav.addObject("loginuser", userEmail);
			mav.addObject("imglist", images);
			mav.addObject("reviewlist", review);
			mav.addObject("product", product);
			Wishlist wish =  wishlistService.read(userEmail, Integer.parseInt(productid));
			mav.addObject("wishlist", wish);
			mav.setView("/product/product.jsp");
			return mav;
		}

	}

}
