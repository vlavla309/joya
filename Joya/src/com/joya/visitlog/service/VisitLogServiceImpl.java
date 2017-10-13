package com.joya.visitlog.service;

import com.joya.common.db.DaoFactory;
import com.joya.visitlog.dao.JdbcVisitLogDao;
import com.joya.visitlog.dao.VisitLogDao;

public class VisitLogServiceImpl implements VisitLogService{
	VisitLogDao vDao = (VisitLogDao) DaoFactory.getInstance().getDao(JdbcVisitLogDao.class);
	@Override
	public void create(String ip) {
		vDao.create(ip);
	}

	@Override
	public int countVisitor(String date) {
		 return vDao.countVisitor(date);
	}
	
	public static void main(String[] args) {
		VisitLogServiceImpl ser=new VisitLogServiceImpl();
	}
}
