package com.joya.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.image.domain.Images;
import com.sun.prism.Image;

public class JdbcImageDao implements ImageDao{
	private DataSource dataSource;

	public JdbcImageDao() {}

	public JdbcImageDao(DataSource dataSource) {
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
	public void create(Images image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Images> listAll() {
		List<Images> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO from images";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Images>();
			while (rs.next()) {
				Images image = setimage(rs);
				list.add(image);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	
	private Images setimage(ResultSet rs) throws SQLException {
		String imageName = rs.getString("IMAGE_NAME");
		int productId = rs.getInt("PRODUCT_ID");
		String path = rs.getString("PATH");
		int order = rs.getInt("ORDER_NO");
		Images image = new Images();

		image.setImageName(imageName);
		image.setOrder(order);
		image.setPath(path);
		image.setProductId(productId);
		return image;
	}

	@Override
	public Images search(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		JdbcImageDao articledao = (JdbcImageDao) DaoFactory.getInstance().getDao(JdbcImageDao.class);
		List<Images> img = articledao.listAll();
		for (Images images : img) {
			System.out.println(images);
		}
	}
	
	

}
