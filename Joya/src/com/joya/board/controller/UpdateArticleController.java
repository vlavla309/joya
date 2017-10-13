package com.joya.board.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
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

/**
 * 게시글 수정 작업
 * @author 김미소
 *
 */
public class UpdateArticleController implements Controller {
	final long maxSize = 5*1024*1024; //업로드 이미지 최대 크기
	private ArticleService articleService = new ArticleServiceImpl();

	private String fileRepository ;
	String fileName;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		fileRepository = request.getServletContext().getInitParameter("articleImageUploadPath");
		
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
			fileUpload.setSizeMax(maxSize);

			List<FileItem> fileList = null;
			String imageName = null;
			String path = "/boards/asimages/";
			String boardNo = null;

			try {
				fileList = fileUpload.parseRequest(request);
				for (int i = 0; i < fileList.size(); i++) {
					FileItem item = fileList.get(i);
					if (item.isFormField()) {
						switch (item.getFieldName()) {
						case "articleId" :
							articleId = Integer.parseInt(item.getString("utf-8"));
							break;
						case "title":
							title = item.getString("utf-8");
							break;
						case "articleType":
							articleType = item.getString("utf-8");
							break;
						case "passwd":
							passwd = item.getString("utf-8");
							break;
						case "contents":
							contents = item.getString("utf-8");
							break;
						}
					} else {
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
				article.setArticleId(articleId);
				article.setTitle(title);
				article.setContents(contents.replace("\r\n", "<br>"));
				article.setPasswd(passwd);
				article.setFilePath(path + imageName);

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
