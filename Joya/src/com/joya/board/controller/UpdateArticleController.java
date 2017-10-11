package com.joya.board.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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

public class UpdateArticleController implements Controller {

	private ArticleService articleService = new ArticleServiceImpl();
	private ImageService imgService = new ImageServiceImpl();
	private String fileRepository = "C:/kosta164/1Team/Joya/WebContent/boards/asimages/";
	String fileName;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		System.out.println("수정액션컨트롤러=====+========+============");
		request.setCharacterEncoding("utf-8");

		ModelAndView mav = new ModelAndView();
		
		String boardId = request.getParameter("boardid");
		int articleId = 0;
		String title = null;
		String passwd = null;
		String contents = null;
		String articleType = null;
		String filePath = null;

		if (boardId.equals("1") || boardId.equals("2")) {
			articleId = Integer.parseInt(request.getParameter("articleId"));
			title = request.getParameter("title");
			contents = request.getParameter("contents");
			passwd = request.getParameter("passwd");
			articleType = request.getParameter("articleType");

			Article article = new Article();
			article.setArticleId(articleId);
			article.setTitle(title);
			article.setContents(contents.replace("\r\n", "<br>"));
			article.setPasswd(passwd);

			articleService.edit(article);

			if (articleType == "secret") {
				mav.addObject("article", article + articleType);
			} else {
				mav.addObject("article", article);
			}

			mav.setView("redirect:/boards/qnalist.joya");
			
		} else if (boardId.equals("3") || boardId.equals("4")) {
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
					System.out.println("아이템" + item.getFieldName());
					if (item.isFormField()) {
						String param = item.getString("utf-8");
						switch (item.getFieldName()) {
						case "articleId" :
							articleId = Integer.parseInt(item.getString("utf-8"));
							System.out.println("as게시판articleId:"+articleId);
							break;
						case "title":
							title = item.getString("utf-8");
							System.out.println("as제목:" + title);
							break;
						case "articleType":
							articleType = item.getString("utf-8");
							System.out.println("as비밀글타입:" + articleType);
							break;
						case "passwd":
							passwd = item.getString("utf-8");
							System.out.println("as비번:" + passwd);
							break;
						case "contents":
							contents = item.getString("utf-8");
							System.out.println("as내용:" + contents);
							break;

						}
					} else {
						imageName = item.getName();
						System.out.println("이미지네임:" + imageName);
						File saveFile = new File(fileRepository + imageName);
						try {
							item.write(saveFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				Article article = new Article();
				article.setArticleId(articleId);
				article.setTitle(title);
				article.setContents(contents.replace("\r\n", "<br>"));
				article.setPasswd(passwd);
				article.setFilePath(path + imageName);
				System.out.println("AS게시판11111111111111");

				articleService.edit(article);

				if (articleType == "secret") {
					mav.addObject("article", article + articleType);
				} else {
					mav.addObject("article", article);
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			mav.setView("redirect:/boards/aslist.joya");

		}
		return mav;
	}

}
