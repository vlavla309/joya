package com.joya.admin.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.category.domain.Categories;
import com.joya.category.service.CategoryService;
import com.joya.category.service.CategoryServiceImpl;
import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;


/**
 * 상품 업로드 폼 입력 페이지
 * 현재 DB에 있는 카테고리를 조회 후 전달
 * @author 김형주
 */
public class ProductUploadFormController implements Controller {
	private CategoryService categoryService=new CategoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		List<Categories> categories=categoryService.listAll();
		
		mav.addObject("categories", categories);
		mav.setView("/admin/product_form.jsp");
		
		return mav;
	}
}




