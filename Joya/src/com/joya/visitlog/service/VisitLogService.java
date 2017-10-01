package com.joya.visitlog.service;

public interface VisitLogService {
	public void create(String ip);
	public int countVisitor(String date);
}
