package com.joya.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.exception.MallException;
import com.joya.image.domain.Images;

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
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO images " + 
					   "            (image_name, " + 
					   "             product_id, " + 
					   "             path, " + 
					   "             order_no) " + 
					   "VALUES      (?, " + 
					   "             ?, " + 
					   "             ?, " + 
					   "             ? )";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, image.getImageName());
			pstmt.setInt(2, image.getProductId());
			pstmt.setString(3, image.getPath());
			pstmt.setInt(4, image.getOrderNo());
			
			pstmt.executeQuery();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new MallException("JdbcImageDao.create(Image image)실행 중 예외 발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}
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
	
	public  List<Images> listByProductid(int productid){
		List<Images> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO from images where PRODUCT_ID=?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productid);
			
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
			} catch (Exception e) {}
			
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
		image.setOrderNo(order);
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
		//List<Images> img = articledao.listAll();
		/*for (Images images : img) {
			System.out.println(images);
		}*/
		
		/*List<Images> img = articledao.listByProductid(1);
		for (Images images : img) {
			System.out.println(images);
		}*/
	}
	
	

}
