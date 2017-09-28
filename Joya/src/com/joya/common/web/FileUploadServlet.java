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
					System.out.println("�ۼ���: " + writer);
				}else {// ���ε� ������ ���
					fileName = item.getName();
					System.out.println("���ε� ���ϸ�: " + fileName);
					// fileName = c:\xxx\yyy\���ε����ϸ�
					String[] tokens = fileName.split("\\\\");
					fileName = tokens[tokens.length-1];//���ϸ� ����
					long fileSize = item.getSize();
					System.out.println("���ϻ�����: " + fileSize);
	
					// ���ε�� ������ ������ Ư�� ���丮�� ����
					File saveFile = new File(fileRepository + fileName);
					item.write(saveFile);
				}
			}
			/*// ���ε� ��� Response
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>���� ���ε� �Ϸ�!</h2>");
			out.println("<h3>"+fileName+"</h3>");
			out.println("</body>");
			out.println("</html>");*/
			
			response.sendRedirect("FileList");
		} catch (Exception e) {
			new ServletException(e.getMessage());
		}
		
	}
}
