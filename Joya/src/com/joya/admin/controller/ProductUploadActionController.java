package com.joya.admin.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.image.dao.ImageDao;
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;

import sun.font.CreatedFontTracker;


/**
 * 
 * @author 김형주
 *
 */
public class ProductUploadActionController implements Controller {
	ProductService productService=new ProductServiceImpl();
	ImageService imgService= new ImageServiceImpl();
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
		
		String productName=null;
		String maker=null;
		int price=0;
		int amount=0;
		String categoryName=null;
		String productDesc=null;
		
		
		List<File> imgs=new ArrayList<File>();
		List<Images> images=new ArrayList<Images>();
		String imageName=null;
		int productId=0;
		String path="/shopimg/";
		
		try {
			fileList = fileUpload.parseRequest(request);
			for (int i=0; i<fileList.size(); i++) {
				FileItem item=fileList.get(i);
				if (item.isFormField()) {
					switch(i) {
					case 0:
						productName=item.getString("utf-8");
						break;
					case 1:
						maker=item.getString("utf-8");
						break;
					case 2:
						price=Integer.parseInt(item.getString("utf-8"));
						break;
					case 3:
						amount=Integer.parseInt(item.getString("utf-8"));
						break;
					case 4:
						categoryName=item.getString("utf-8");
						break;
					case 5:
						productDesc=item.getString("utf-8");
						break;
					}
					System.out.println(item.getString("utf-8"));
				}else {
					imageName = item.getName();
					images.add(new Images(imageName, productId, path, 0));
					System.out.println("업로드 파일명: " + imageName);
					String[] tokens = imageName.split("\\\\");
	
					// 업로드된 파일을 서버의 특정 디렉토리에 저장
					File saveFile = new File(fileRepository + imageName);
					item.write(saveFile);
				}
				
				
				productService.create(new Product(0, productName, categoryName, maker, productDesc, "", price, amount, 0));
				productId=productService.getNewProductId();
				
				int orderImage=0;
				for (Images image : images) {
					image.setOrder(++orderImage);
					image.setProductId(productId);
					imgService.create(image);
				}
				
			
				
				
				
				}
		}catch (Exception e) {}
		mav.setView("/admin/pages/product_form.jsp");

		return mav;

		

	}

}


