package com.joya.admin.controller;

import java.io.File;
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
import com.joya.image.domain.Images;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;


/**
 * 상품 등록 작업
 * @author 김형주
 */
public class ProductUploadActionController implements Controller {
	final long maxSize=5*1024*1024; //최대 사진 크기 5MB
	
	ProductService productService=new ProductServiceImpl();
	ImageService imgService= new ImageServiceImpl();
	
	//상품이미지가 업로드 되는 실제 경로
	private String fileRepository;
	String fileName;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		//이미지 파일 업로드 경로 설정
		fileRepository=request.getServletContext().getInitParameter("productImageUploadPath");
		
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setSizeMax(maxSize); 

		List<FileItem> fileList = null;

		String productName=null;
		String maker=null;
		int price=0;
		int amount=0;
		String categoryName=null;
		String productDesc=null;


		List<Images> images=new ArrayList<Images>();
		String imageName=null;
		int productId=0;
		String path="/shopimg/";
		
		try {
			fileList = fileUpload.parseRequest(request);
		
			for (int i=0; i<fileList.size(); i++) {
				FileItem item=fileList.get(i);
				if (item.isFormField()) {
					String fieldName=item.getFieldName();
					switch(fieldName) {
					case "productName":
						productName=item.getString("utf-8");
						break;
					case "maker":
						maker=item.getString("utf-8");
						break;
					case "price":
						price=Integer.parseInt(item.getString("utf-8"));
						break;
					case "amount":
						amount=Integer.parseInt(item.getString("utf-8"));
						break;
					case "categoryName":
						categoryName=item.getString("utf-8");
						break;
					case "productDesc":
						productDesc=item.getString("utf-8");
						break;
					}
				}else {
					imageName = item.getName();
					images.add(new Images(imageName, productId, path, 0));

					// 업로드된 파일을 서버의 특정 디렉토리에 쓰기
					File saveFile = new File(fileRepository + imageName);
					item.write(saveFile);
				}
			}
				Product product =new Product(0, productName, categoryName, maker, productDesc, "", price, amount, 0);

				productService.create(product);
				productId=productService.getNewProductId();

				int orderImage=0;
				for (Images image : images) {
					image.setOrderNo(orderImage++);
					image.setProductId(productId);
					imgService.create(image);
				}

			
		}catch (Exception e) {}
		mav.setView("/admin/");

		return mav;
	}
}
