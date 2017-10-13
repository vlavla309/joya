package com.joya.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.visitlog.service.VisitLogService;
import com.joya.visitlog.service.VisitLogServiceImpl;


/**
 * 방문자 수 조회 작업
 * 전달받은 기준 날짜로 부터 이틀 전, 하루 전, 다음날, 이틀 후 접속자수를 조회 한다
 * @author 김형주
 */
public class VisitorCountController implements Controller {
	final String format="yyyy-MM-dd"; //사용할 날짜 포맷 지정
	VisitLogService visitServ=new VisitLogServiceImpl();
	
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
				e.printStackTrace();
			}
			
			
		String datas="[";
		datas+="{y: '"+prevPrevDate+"', a: "+visitServ.countVisitor(prevPrevDate)+"},";
		datas+="{y: '"+prevDate+"', a: "+visitServ.countVisitor(prevDate)+"},";
		datas+="{y: '"+stdDate+"', a: "+visitServ.countVisitor(stdDate)+"},";
		datas+="{y: '"+nextDate+"', a: "+visitServ.countVisitor(nextDate)+"},";
		datas+="{y: '"+nextNextDate+"', a: "+visitServ.countVisitor(nextNextDate)+"},";
		datas+="]";
		
		mav.addObject("date", stdDate);
		mav.addObject("datas",datas);
		mav.setView("/admin/visitor_count.jsp");

		return mav;
	}
	
	/** 문자열을 Date객체로 변환 */
	private Date stringToDate(String date) throws ParseException {
		SimpleDateFormat transFormat = new SimpleDateFormat(format);
		return transFormat.parse(date);
	}
	
	/** Date객체를 문자열로 변환 */
	private String dateToString(Date date) {
		SimpleDateFormat transFormat = new SimpleDateFormat(format);
		return transFormat.format(date);
		
	}
	
	/** 기준일로부터 특정 날짜를 계산 */
	private String calcDate(String date, int day) throws ParseException {
		Date stdDate = stringToDate(date);
		long stdTime = stdDate.getTime();
		Date calcDate = new java.util.Date(stdTime+(1000*60*60*24*day));
		String result=dateToString(calcDate);
		return result;
	}
}


