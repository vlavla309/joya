package com.joya.board.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.joya.article.domain.Article;
import com.joya.article.service.ArticleService;
import com.joya.article.service.ArticleServiceImpl;
import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.image.service.ImageService;
import com.joya.image.service.ImageServiceImpl;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

/**
 * 게시글 등록 작업
 * @author 김미소
 */
public class ArticleWriteController implements Controller {
	final long maxSize=5*1024*1024; //업로드 이미지 파일 최대 크기
	
	private ArticleService articleService = new ArticleServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	private String fileRepository;
	String fileName;
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		fileRepository=request.getServletContext().getInitParameter("articleImageUploadPath");
		String boardId = request.getParameter("board_id");
		
		String email = null;
		String title = null;
		String writer = null;
		String passwd = null;
		String contents = null;
		String articleType = null;
		String filePath = null;
		
		if(boardId.equals("1") || boardId.equals("2")) {
			
			email = request.getParameter("email");
			title = request.getParameter("title");
			writer = request.getParameter("writer");
			passwd = request.getParameter("passwd");
			contents = request.getParameter("contents");
			articleType = request.getParameter("articleType");
			
			Article article = new Article();
			article.setEmail(email);
			article.setTitle(title);
			article.setWriter(writer);
			article.setPasswd(passwd);
			article.setContents(contents.replace("\r\n", "<br>"));
			
			if(boardId != null) {
				switch(boardId) {
				case "1":
					articleService.create(article, "notice");
					break;
				case "2":
					articleService.create(article, "qna");
					break;
				}
			}
			
			if(articleType == "secret") {
				mav.addObject("article", article + articleType);
			} else {
				mav.addObject("article", article);
			}
			
			mav.setView("redirect:/boards/qnalist.joya");
			
		} else if(boardId.equals("3") || boardId.equals("4")) {
			
			// 파일업로드
			DiskFileItemFactory itemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
			fileUpload.setSizeMax(maxSize);
			
			List<FileItem> fileList = null;
			String imageName = null;
			String path = "/boards/asimages/";
			String boardNo = null;
			String productid = null;
			String orderid = null;
			
			try {
				fileList = fileUpload.parseRequest(request);
				for (int i = 0; i < fileList.size(); i++) {
					FileItem item = fileList.get(i);
					if(item.isFormField()) {
						switch(item.getFieldName()) {
						case "board_id" :
							boardNo = item.getString("utf-8");
							break;
						case "title":
							title = item.getString("utf-8");
							break;
						case "articleType":
							articleType = item.getString("utf-8");
							break;
						case "email":
							email = item.getString("utf-8");
							break;
						case "writer":
							writer = item.getString("utf-8");
							break;
						case "passwd":
							passwd = item.getString("utf-8");
							break;
						case "contents":
							contents = item.getString("utf-8");
							break;
						case "productid":
							productid = item.getString("utf-8");
							break;
						case "orderid":
							orderid = item.getString("utf-8");
							break;
						
						}
					}else {
						imageName = item.getName();
						File saveFile = new File(fileRepository + imageName);
						try {
							item.write(saveFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
					Article article = new Article();
					article.setEmail(email);
					article.setTitle(title);
					article.setWriter(writer);
					article.setPasswd(passwd);
					article.setContents(contents.replace("\r\n", "<br>"));
					article.setFilePath(path + imageName);
					
					if(boardId != null) {
						switch(boardId) {
						case "3":
							article.setProductId(Integer.parseInt(productid));
							articleService.create(article, "review");
							User user = userService.read(email);
							userService.pointmodify(email, user.getPoint()+1000);
							mav.setView("redirect:/mypage/orderdetail.joya?orderid="+orderid);
							break;
						case "4":
							articleService.create(article, "as");
							mav.setView("redirect:/boards/aslist.joya");
							break;
						}
					}
					
					if(articleType == "secret") {
						mav.addObject("article", article + articleType);
					} else {
						mav.addObject("article", article);
					}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
		}
		return mav;
	}
}