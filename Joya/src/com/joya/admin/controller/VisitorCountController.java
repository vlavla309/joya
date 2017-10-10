package com.joya.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		
		
		
		String prevPrevDate=null;
		String prevDate=null;
		String stdDate=null;
		String nextNextDate=null;
		String nextDate=null;

		stdDate=request.getParameter("date");
		
		if(stdDate==null) {
			stdDate=dateToString(new Date());
		}

		
			try {
				prevPrevDate=calcDate(stdDate, -2);
				prevDate=calcDate(stdDate, -1);
				nextDate=calcDate(stdDate, 1);
				nextNextDate =calcDate(stdDate, 2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		String datas="[";
		datas+="{y: '"+prevPrevDate+"', a: "+visitServ.countVisitor(prevPrevDate)+"},";
		datas+="{y: '"+prevDate+"', a: "+visitServ.countVisitor(prevDate)+"},";
		datas+="{y: '"+stdDate+"', a: "+visitServ.countVisitor(stdDate)+"},";
		datas+="{y: '"+nextDate+"', a: "+visitServ.countVisitor(nextDate)+"},";
		datas+="{y: '"+nextNextDate+"', a: "+visitServ.countVisitor(nextNextDate)+"},";
		datas+="]";
		
		//System.out.println(datas);
		 
		
		mav.addObject("date", stdDate);
		mav.addObject("datas",datas);
		
		mav.setView("/admin/visitor_count.jsp");

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


