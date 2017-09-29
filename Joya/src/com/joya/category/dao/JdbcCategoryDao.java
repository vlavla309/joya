package com.joya.category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.category.domain.Categories;
import com.joya.common.exception.MallException;

public class JdbcCategoryDao implements CategoryDao{
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Categories category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categories read(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Categories> listAll() {

		List<Categories> list = null;		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT *");
		sb.append(" FROM categories");
	

		//		System.out.println(sb.toString());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<Categories>();

			while(rs.next()){
				list.add(new Categories(rs.getString("category_name"), rs.getString("parent")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcCategoryDao.listAll() 에러발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}

	@Override
	public void update(Categories category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int categoriesid) {
		// TODO Auto-generated method stub
		
	}
}
