package com.joya.common.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ëª¨ë“  ë·°ì— ???•œ ?‹¤?–‰ë©”ì†Œ?“œ ê·œì•½ ?„ ?–¸
 * @author ê¹?ê¸°ì •
 */
public interface View {
	
	/** ?‹¤?–‰ ê·œì•½ ë©”ì†Œ?“œ */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}