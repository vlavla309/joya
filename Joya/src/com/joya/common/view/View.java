package com.joya.common.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 뷰에 ???�� ?��?��메소?�� 규약 ?��?��
 * @author �?기정
 */
public interface View {
	
	/** ?��?�� 규약 메소?�� */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}