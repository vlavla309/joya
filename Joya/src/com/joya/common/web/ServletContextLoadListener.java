package com.joya.common.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext ?��명주�?(?��?��/?���?) �??�� ?��벤트 리스?��
 * @author �?기정
 */
public class ServletContextLoadListener implements ServletContextListener {
	
	/**
	 * ServletContext?��?�� ?��벤트 처리
     * ServletContext�? ?��?��?���?(?��블릿컨테?��?�� 초기?��) ?�� ?��?��리�??��?��?��?��
     * 모든 Servlet, JSP, Filter ?��?�� 공유?�� ?�� ?��?�� 객체 ?��?�� 리소?�� ?��?�� �? ?���?(초기?��)
	 */
	public void contextInitialized(ServletContextEvent event)  {
//		System.out.println("[Debug] : ServletContext ?��?��?�� >>>");
//		DaoFactory2 daoFactory = new DaoFactory2();
		// 모든 ?��블릿, JSP?��?�� 공유?�� ?�� ?��?���? ServletContext?�� DaoFactory ???��
//		ServletContext servletContext = event.getServletContext();
//		servletContext.setAttribute("daoFactory", daoFactory);
	}
	
	
	public void contextDestroyed(ServletContextEvent event)  {
//		System.out.println("[Debug] : ServletContext(?��블릿컨테?��?��) 종료?�� >>>");
    }
}
