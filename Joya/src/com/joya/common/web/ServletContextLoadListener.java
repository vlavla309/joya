package com.joya.common.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext ?ƒëª…ì£¼ê¸?(?ƒ?„±/?†Œë©?) ê´?? ¨ ?´ë²¤íŠ¸ ë¦¬ìŠ¤?„ˆ
 * @author ê¹?ê¸°ì •
 */
public class ServletContextLoadListener implements ServletContextListener {
	
	/**
	 * ServletContext?ƒ?„± ?´ë²¤íŠ¸ ì²˜ë¦¬
     * ServletContextê°? ?ƒ?„±?˜ë©?(?„œë¸”ë¦¿ì»¨í…Œ?´?„ˆ ì´ˆê¸°?™”) ?›¹ ?• ?”Œë¦¬ì??´?…˜?‚´?˜
     * ëª¨ë“  Servlet, JSP, Filter ?“±?´ ê³µìœ ?•  ?ˆ˜ ?žˆ?Š” ê°ì²´ ?˜?Š” ë¦¬ì†Œ?Š¤ ?ƒ?„± ë°? ?“±ë¡?(ì´ˆê¸°?™”)
	 */
	public void contextInitialized(ServletContextEvent event)  {
//		System.out.println("[Debug] : ServletContext ?ƒ?„±?¨ >>>");
//		DaoFactory2 daoFactory = new DaoFactory2();
		// ëª¨ë“  ?„œë¸”ë¦¿, JSP?“¤?´ ê³µìœ ?•  ?ˆ˜ ?žˆ?„ë¡? ServletContext?— DaoFactory ???ž¥
//		ServletContext servletContext = event.getServletContext();
//		servletContext.setAttribute("daoFactory", daoFactory);
	}
	
	
	public void contextDestroyed(ServletContextEvent event)  {
//		System.out.println("[Debug] : ServletContext(?„œë¸”ë¦¿ì»¨í…Œ?´?„ˆ) ì¢…ë£Œ?¨ >>>");
    }
}
