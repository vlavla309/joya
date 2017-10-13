package com.joya.common.view;

import javax.servlet.ServletException;

/**
 * View 선택 및 실행
 * @author 김형주
 *
 */
public class ViewResolver{
	
	public View resolve(String path) throws ServletException{
		
		//다양한 view중 현재는 JSP뷰를 사용
		View view = new JSPView(path);
		return view;
	}
}
