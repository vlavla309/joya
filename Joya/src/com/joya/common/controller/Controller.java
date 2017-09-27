package com.joya.common.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ëª¨ë“  ?„¸ë¶? ì»¨íŠ¸ë¡¤ëŸ¬?— ???•œ ?‹¤?–‰ë©”ì†Œ?“œ ê·œì•½ ?„ ?–¸ - ì»¤ë§¨?“œ?Œ¨?„´ ? ?š©
 * @author ê¹?ê¸°ì •
 */
public interface Controller {
	
	/** ?‹¤?–‰ ê·œì•½ ë©”ì†Œ?“œ 
	 * @throws UnsupportedEncodingException */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException;
}