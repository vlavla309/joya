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

/**
 * 게시글 등록 처리
 * 
 * @author 김미소
 */
public class ArticleWriteController implements Controller {
	
	private ArticleService articleService = new ArticleServiceImpl();
	private ImageService imgService = new ImageServiceImpl();
	private String fileRepository = "C:/Users/kosta/Desktop/joya/Joya/WebContent/boards/asimages/";
	String fileName;
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		System.out.println("쓰기컨트롤러=================");
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		String boardId = request.getParameter("board_id");
		
		String email = null;
		String title = null;
		String writer = null;
		String passwd = null;
		String contents = null;
		String articleType = null;
		String filePath = null;
		
		if(boardId.equals("1") || boardId.equals("2")) {
			System.out.println("qna게시판");
			
			email = request.getParameter("email");
			title = request.getParameter("title");
			writer = request.getParameter("writer");
			passwd = request.getParameter("passwd");
			contents = request.getParameter("contents");
			articleType = request.getParameter("articleType");
			
			System.out.println("비밀글-------------"+articleType);
			
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
			System.out.println("qna게시판1111111111111");
			
			mav.setView("redirect:/boards/qnalist.joya");
			System.out.println("qna게시판2222222222");
			
		} else if(boardId.equals("3") || boardId.equals("4")) {
			
			System.out.println("AS게시판");
			
			// 파일업로드
			DiskFileItemFactory itemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
			fileUpload.setSizeMax(5 * 1024 * 1024);
			
			List<FileItem> fileList = null;
			List<File> imgs = new ArrayList<File>();
			String imageName = null;
			String path = "/boards/asimages/";
			String boardNo = null;
			
			try {
				fileList = fileUpload.parseRequest(request);
				for (int i = 0; i < fileList.size(); i++) {
					FileItem item = fileList.get(i);
					System.out.println("아이템"+item.getFieldName());
					if(item.isFormField()) {
						String param = item.getString("utf-8");
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
							articleService.create(article, "review");
							mav.setView("redirect:"+request.getHeader("REFERER"));
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
			
			System.out.println("AS게시판33333333333");
			
		}
		return mav;
	}

}
