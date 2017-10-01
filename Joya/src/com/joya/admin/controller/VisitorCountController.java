package com.joya.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.visitlog.service.VisitLogService;
import com.joya.visitlog.service.VisitLogServiceImpl;


/**
 * 
 * @author 김형주
 *
 */
public class VisitorCountController implements Controller {
	
	VisitLogService visitServ=new VisitLogServiceImpl();
	String format="yyyy-MM-dd";

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		//String date=request.getParameter("date");
		String date=null;
		if(date==null) {
			
		}

		date="2011-12-12";
		
			try {
				System.out.println(calcDate(date, -2));
				System.out.println(calcDate(date, -1));
				System.out.println(calcDate(date, 1));
				System.out.println(calcDate(date, 2));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		Map<String, Integer> datas=new LinkedHashMap<String, Integer>();
		
		mav.addObject("date", date);
		
		mav.setView("/admin/pages/visitor_count.jsp");

		return mav;



	}

	private Date stringToDate(String date) throws ParseException {
		SimpleDateFormat transFormat = new SimpleDateFormat(format);
		return transFormat.parse(date);
		
	}
	private String dateToString(Date date) {
		SimpleDateFormat transFormat = new SimpleDateFormat(format);
		return transFormat.format(date);
		
	}
	
	private String calcDate(String date, int day) throws ParseException {
		Date stdDate = stringToDate(date);
		long stdTime = stdDate.getTime();
		Date calcDate = new java.util.Date(stdTime+(1000*60*60*24*day));
		String result=dateToString(calcDate);
		return result;
	}
	
	public static void main(String[] args) {
		VisitorCountController con =new VisitorCountController();
		try {
			con.handleRequest(null, null);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


