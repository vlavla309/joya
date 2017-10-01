package com.joya.visitlog.domain;

public class VisitLog {
	private String ip;
	private String visitDate;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	@Override
	public String toString() {
		return "VisitLog [ip=" + ip + ", visitDate=" + visitDate + "]";
	}
	
}
