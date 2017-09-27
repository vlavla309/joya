package com.joya.common.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * View ?Ñ†?Éù Î∞? ?ã§?ñâ
 * @author Íπ?Í∏∞Ï†ï
 *
 */
public class ViewResolver{
	
	public View resolve(String path) throws ServletException{
		View view = new JSPView(path);
//		View view = new XXXView(path);
		return view;
	}
}
