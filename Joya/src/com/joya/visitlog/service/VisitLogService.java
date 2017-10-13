package com.joya.visitlog.service;
/**
 * @author 김형주
 *
 */
public interface VisitLogService {
	public void create(String ip);
	public int countVisitor(String date);
}
