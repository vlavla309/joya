package com.joya.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;
import com.joya.image.domain.Images;
import com.joya.product.dao.JdbcProductDao;
import com.joya.product.domain.Product;
import com.joya.wishlist.domain.Wishlist;

public class JdbcWishlistDao implements WishlistDao {
	
	private DataSource dataSource;
	
	public JdbcWishlistDao() {}
	
	public JdbcWishlistDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/** 위시리스트 등록 */
	public void insert(String userEmail,  int productId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO wishlist \r\n" + 
								"            (email, \r\n" + 
								"             product_id) \r\n" + 
								"VALUES      (?, \r\n" + 
								"             ?)";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			pstmt.setInt(2, productId);
			pstmt.executeUpdate();
			con.commit();
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {}
			System.out.println("JdbcWishlistDao.insert(userEmail, productId) 실행 중 예외발생");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}

	@Override
	/** 위시리스트 전체 목록 반환 */
	public List<Wishlist> listAll(String userEmail) {
		List<Wishlist> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT w.email                                  email, \r\n" + 
								"       w.product_id                             product_id, \r\n" + 
								"       To_char(w.regdate, 'YYYY.MM.DD HH24:MI:SS') regdate, \r\n" + 
								"       p.product_name                           product_name, \r\n" + 
								"       i.path                                   path, \r\n" + 
								"       i.image_name                             image_name \r\n" + 
								"FROM   wishlist w \r\n" + 
								"       JOIN products p \r\n" + 
								"         ON w.product_id = p.product_id \r\n" + 
								"       JOIN images i \r\n" + 
								"         ON p.product_id = i.product_id \r\n" + 
								"WHERE  w.email = ? \r\n" + 
								"       AND i.order_no = 0 \r\n" + 
								"ORDER  BY regdate DESC ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			list = new ArrayList<Wishlist>();
			while(rs.next()) {
				Wishlist wishlist = createWishlist(rs);
				list.add(wishlist);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JdbcWishlistDao.listAll(userEmail) 실행 중 예외발생");
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	public List<Wishlist> listAll() {
		List<Wishlist> list = null;
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select product_id, email from wishlist";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Wishlist>();
			while(rs.next()) {
				Wishlist wishlist = setWishlist(rs);
				list.add(wishlist);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JdbcWishlistDao.listAll() 실행 중 예외발생");
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}

	@Override
	/** 위시리스트 목록에서 삭제 */
	public boolean delete(String userEmail, int productId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "DELETE FROM wishlist \r\n" + 
								"WHERE  email = ? \r\n" + 
								"       AND product_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			pstmt.setInt(2, productId);
			rs = pstmt.executeQuery();
			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
			}
			System.out.println("JdbcWishlistDao.deleteUser(userEmail, productId) 실행 중 예외발생");
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
		return false;
	}

	@Override
	/** 선택 페이지에 대한 위시리스트 반환 */
	public List<Wishlist> listByPage(String userEmail, int pageNum) {
		List<Wishlist> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT email, \r\n" + 
								"       product_id, \r\n" + 
								"       regdate, \r\n" + 
								"       product_name, \r\n" + 
								"       path, \r\n" + 
								"       image_name \r\n" + 
								"FROM   (SELECT Ceil(rownum / 3) request_page, \r\n" + 
								"               email, \r\n" + 
								"               product_id, \r\n" + 
								"               regdate, \r\n" + 
								"               product_name, \r\n" + 
								"               path, \r\n" + 
								"               image_name \r\n" + 
								"        FROM   (SELECT w.email                                  email, \r\n" + 
								"                       w.product_id                             product_id, \r\n" + 
								"                       To_char(w.regdate, 'YYYY.MM.DD HH24:MI:SS') regdate, \r\n" + 
								"                       p.product_name                           product_name, \r\n" + 
								"                       i.path                                   path, \r\n" + 
								"                       i.image_name                             image_name \r\n" + 
								"                FROM   wishlist w \r\n" + 
								"                       JOIN products p \r\n" + 
								"                         ON w.product_id = p.product_id \r\n" + 
								"                       JOIN images i \r\n" + 
								"                         ON p.product_id = i.product_id \r\n" + 
								"                WHERE  w.email = ? \r\n" + 
								"                       AND i.order_no = 0 \r\n" + 
								"                ORDER  BY regdate DESC)) \r\n" + 
								"WHERE  request_page = ?  ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			pstmt.setInt(2, pageNum);
			rs = pstmt.executeQuery();
			list = new ArrayList<Wishlist>();
			while (rs.next()) {
				Wishlist wishlist = createWishlist(rs);
				list.add(wishlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JdbcWishlistDao.listByPage(userEmail, pageNum) 실행 중 예외발생");
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
	
	@Override
	/** {선택페이지, 한페이지당 출력 행수}에 대한 위시리스트 반환 */
	public List<Wishlist> listByParams(String userEmail, Params params) {
		List<Wishlist> list = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT email, \r\n" + 
								"       product_id, \r\n" + 
								"       regdate, \r\n" + 
								"       product_name, \r\n" + 
								"       path, \r\n" + 
								"       image_name \r\n" + 
								"FROM   (SELECT Ceil(rownum / ?) request_page, \r\n" + 
								"               email, \r\n" + 
								"               product_id, \r\n" + 
								"               regdate, \r\n" + 
								"               product_name, \r\n" + 
								"               path, \r\n" + 
								"               image_name \r\n" + 
								"        FROM   (SELECT w.email                                  email, \r\n" + 
								"                       w.product_id                             product_id, \r\n" + 
								"                       To_char(w.regdate, 'YYYY.MM.DD HH24:MI:SS') regdate, \r\n" + 
								"                       p.product_name                           product_name, \r\n" + 
								"                       i.path                                   path, \r\n" + 
								"                       i.image_name                             image_name \r\n" + 
								"                FROM   wishlist w \r\n" + 
								"                       JOIN products p \r\n" + 
								"                         ON w.product_id = p.product_id \r\n" + 
								"                       JOIN images i \r\n" + 
								"                         ON p.product_id = i.product_id \r\n" + 
								"                WHERE  w.email = ? \r\n" + 
								"                       AND i.order_no = 0 \r\n" + 
								"                ORDER  BY regdate DESC)) \r\n" + 
								"WHERE  request_page = ?  ";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, params.getPageSize());
			pstmt.setString(2, userEmail);
			pstmt.setInt(3, params.getPage());
			rs = pstmt.executeQuery();
			list = new ArrayList<Wishlist>();
			
			while(rs.next()){
				Wishlist wishlist = createWishlist(rs);
				list.add(wishlist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JdbcArticleDao.listByPage(userEmail, params) 실행 중 예외발생");
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	/** 단일 위시리스트 생성 */
	public Wishlist createWishlist(ResultSet rs) throws SQLException {
		String email = rs.getString("email");
		int productId = rs.getInt("product_id");			
		String regdate = rs.getString("regdate");
		String productName = rs.getString("product_name");
		String imgName = rs.getString("image_name");
		String imgPath = rs.getString("path");
		
		Wishlist wishlist = new Wishlist();
		wishlist.setEmail(email);
		wishlist.setProductId(productId);
		wishlist.setRegdate(regdate);
		wishlist.setProductName(productName);
		wishlist.setImgName(imgName);
		wishlist.setImgPath(imgPath);
		return wishlist;
	}
	
	public Wishlist setWishlist(ResultSet rs) throws SQLException {
		String email = rs.getString("email");
		int productId = rs.getInt("product_id");	
		Wishlist wishlist = new Wishlist();
		wishlist.setEmail(email);
		wishlist.setProductId(productId);
		return wishlist;
	}
	
}