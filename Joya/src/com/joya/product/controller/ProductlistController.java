package com.joya.product.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.PageBuilder;
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
 * 상품리스트 컨트롤러
 *
 * @author 한수진
 *
 */
public class ProductlistController implements Controller{
   private ImageService imgService= new ImageServiceImpl();
   private ProductService productservice = new ProductServiceImpl();
   private WishlistService wishlistService = new WishlistServiceImpl();

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, UnsupportedEncodingException {
      
      ModelAndView mav = new ModelAndView();
      int pageSize = 16;
      int pageNum = 5;
      String page = request.getParameter("page");
      if(page==null) page = "1";
      int pageCount = Integer.parseInt(page);
      String type = request.getParameter("type");
      String value= request.getParameter("value");
      String category= request.getParameter("category");
      if(category == null) {
         category="전체";
      }
      
      if(type == null) {
         type ="newProduct";
      }else if( type.equals("null")) {
         type ="newProduct";
      }
      
      Params param = new Params();
      param.setPage(pageCount);
      param.setPageNum(pageNum);
      param.setPageSize(pageSize);

      if(value!=null) {
         param.setType("name");
         param.setValue(value);
      }
      
      List<Product> productlist = productservice.listByParams(param, "반지",  type);
      List<Images> imglist = imgService.listAll();
      List<Wishlist> wishlist = wishlistService.listAll();
      
      int rowCount = productservice.pageCount(param, "반지", type);
      PageBuilder pageBuilder = new PageBuilder(param, rowCount);
      pageBuilder.build();
      
      mav.addObject("imglist", imglist);
      mav.addObject("wishlist", wishlist);
      mav.addObject("productlist", productlist);
      mav.addObject("pageBuilder", pageBuilder);
      mav.setView("/product/list.jsp");
      return mav;
   }

}