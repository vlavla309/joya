package com.joya.visitlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.exception.MallException;

public class JdbcVisitLogDao implements VisitLogDao{
	private DataSource dataSource;

	public JdbcVisitLogDao() {
	}

	public JdbcVisitLogDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void create(String ip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countVisitor(String date) {
		int count =0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT count(*) count");
		sb.append(" FROM visitlog");
		sb.append(" where visitdate = ?");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
		
			pstmt.setString(1, date);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()){
				count=rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcVisitLog.countVisitor() 에러발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	public static void main(String[] args) {
		JdbcVisitLogDao vDao = (JdbcVisitLogDao) DaoFactory.getInstance().getDao(JdbcVisitLogDao.class);
		System.out.println(vDao.countVisitor("2011-12-27"));
	}
}
