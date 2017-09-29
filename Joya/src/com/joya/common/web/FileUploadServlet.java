package com.joya.common.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Apache 
 */
public class FileUploadServlet extends HttpServlet {
	
	private String fileRepository = "C:\\gugu\\fileupload\\";
	String fileName;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setSizeMax(5 * 1024 * 1024); 
		
		List<FileItem> fileList = null;
		
		try {
			fileList = fileUpload.parseRequest(request);
			for (FileItem item : fileList) {
				if (item.isFormField()) {
					String writer = item.getString("utf-8");
				}else {// 占쏙옙占싸듸옙 占쏙옙占쏙옙占쏙옙 占쏙옙占�
					fileName = item.getName();
					System.out.println("占쏙옙占싸듸옙 占쏙옙占싹몌옙: " + fileName);
					// fileName = c:\xxx\yyy\占쏙옙占싸듸옙占쏙옙占싹몌옙
					String[] tokens = fileName.split("\\\\");
					fileName = tokens[tokens.length-1];//占쏙옙占싹몌옙 占쏙옙占쏙옙
					long fileSize = item.getSize();
					System.out.println("占쏙옙占싹삼옙占쏙옙占쏙옙: " + fileSize);
	
					// 占쏙옙占싸듸옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 특占쏙옙 占쏙옙占썰리占쏙옙 占쏙옙占쏙옙
					File saveFile = new File(fileRepository + fileName);
					item.write(saveFile);
				}
			}
			/*// 占쏙옙占싸듸옙 占쏙옙占� Response
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>占쏙옙占쏙옙 占쏙옙占싸듸옙 占싹뤄옙!</h2>");
			out.println("<h3>"+fileName+"</h3>");
			out.println("</body>");
			out.println("</html>");*/
			
			response.sendRedirect("FileList");
		} catch (Exception e) {
			new ServletException(e.getMessage());
		}
		
	}
}
