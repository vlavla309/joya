package com.joya.admin.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.joya.category.domain.Categories;
import com.joya.category.service.CategoryService;
import com.joya.category.service.CategoryServiceImpl;
import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;


/**
 * 
 * @author 김형주
 *
 */
public class ProductUploadActionController implements Controller {
	
	private String fileRepository = "C:\\gugu\\fileupload\\";
	String fileName;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setSizeMax(5 * 1024 * 1024); 

		List<FileItem> fileList = null;

		try {
			fileList = fileUpload.parseRequest(request);
			for (FileItem item : fileList) {
				if (item.isFormField()) {
					System.out.println(item.getString("utf-8"));
				}else {
					fileName = item.getName();
					System.out.println("파일 이름: " + fileName);

					String[] tokens = fileName.split("\\\\");
					fileName = tokens[tokens.length-1];
					long fileSize = item.getSize();
					System.out.println("파일 사이즈: " + fileSize);


					File saveFile = new File(fileRepository + fileName);
					item.write(saveFile);
				}
			}
		}catch (Exception e) {}
		mav.setView("/admin/pages/product_form.jsp");

		return mav;

		

	}

}


