package com.joya.common.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext ?λͺμ£ΌκΈ?(??±/?λ©?) κ΄?? ¨ ?΄λ²€νΈ λ¦¬μ€?
 * @author κΉ?κΈ°μ 
 */
public class ServletContextLoadListener implements ServletContextListener {
	
	/**
	 * ServletContext??± ?΄λ²€νΈ μ²λ¦¬
     * ServletContextκ°? ??±?λ©?(?λΈλ¦Ώμ»¨ν?΄? μ΄κΈ°?) ?Ή ? ?λ¦¬μ??΄??΄?
     * λͺ¨λ  Servlet, JSP, Filter ?±?΄ κ³΅μ ?  ? ?? κ°μ²΄ ?? λ¦¬μ?€ ??± λ°? ?±λ‘?(μ΄κΈ°?)
	 */
	public void contextInitialized(ServletContextEvent event)  {
//		System.out.println("[Debug] : ServletContext ??±?¨ >>>");
//		DaoFactory2 daoFactory = new DaoFactory2();
		// λͺ¨λ  ?λΈλ¦Ώ, JSP?€?΄ κ³΅μ ?  ? ??λ‘? ServletContext? DaoFactory ???₯
//		ServletContext servletContext = event.getServletContext();
//		servletContext.setAttribute("daoFactory", daoFactory);
	}
	
	
	public void contextDestroyed(ServletContextEvent event)  {
//		System.out.println("[Debug] : ServletContext(?λΈλ¦Ώμ»¨ν?΄?) μ’λ£?¨ >>>");
    }
}
