package com.joya.common.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 ?���? 컨트롤러?�� ???�� ?��?��메소?�� 규약 ?��?�� - 커맨?��?��?�� ?��?��
 * @author �?기정
 */
public interface Controller {
	
	/** ?��?�� 규약 메소?�� 
	 * @throws UnsupportedEncodingException */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException;
}