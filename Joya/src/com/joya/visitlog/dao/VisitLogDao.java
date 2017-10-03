package com.joya.visitlog.dao;

public interface VisitLogDao {
	public void create(String ip);
	public int countVisitor(String date);
}
