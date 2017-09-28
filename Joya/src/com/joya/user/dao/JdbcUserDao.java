package com.joya.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.exception.MallException;
import com.joya.common.web.Params;
import com.joya.user.domain.User;

public class JdbcUserDao implements UserDao{
	private DataSource dataSource;



	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public User read(String email) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT email, " + 
				"       phone, " + 
				"       name, " + 
				"       address, " + 
				"       point, " + 
				"       type, " + 
				"       TO_CHAR(birthdate, 'YYYY-MM-DD HH24:MI:SS') birthdate, " + 
				"       TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') regdate " + 
				"		FROM   users " + 
				"		WHERE  email = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = createUser(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.read(String id) �떎�뻾 以� �삁�쇅諛쒖깮", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return user;
	}

	@Override
	public List<User> listByParams(Params params) {
		String type = params.getType();
		String value = params.getValue();

		List<User> list = null;		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT email,");
		sb.append(" phone,");
		sb.append(" name,");
		sb.append(" address,");
		sb.append(" point,");
		sb.append(" birthdate,");
		sb.append(" type,");
		sb.append(" regdate");
		sb.append(" FROM   (SELECT CEIL(rownum / ?) request_page,");
		sb.append(" email,");
		sb.append(" phone,");
		sb.append(" name,");
		sb.append(" address,");
		sb.append(" point,");
		sb.append(" birthdate,");
		sb.append(" type,");
		sb.append(" regdate");
		sb.append(" FROM   (SELECT email,");
		sb.append(" phone,");
		sb.append(" name,");
		sb.append(" address,");
		sb.append(" point,");
		sb.append(" TO_CHAR(birthdate, 'YYYY/MM/DD HH24:MI:SS') birthdate,");
		sb.append(" TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate,");
		sb.append(" type");
		sb.append(" FROM   users ))");
		if(value!=null) {
			sb.append(" where email LiKE ?  or  product_name LIKE ?))");
		}
		sb.append(" WHERE  request_page = ?");

		//System.out.println(sb.toString());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());


			if(value != null){
				pstmt.setString(2, value);
				pstmt.setString(3, value);
			}else{
				pstmt.setInt(2, params.getPage());
			}

			rs = pstmt.executeQuery();
			list = new ArrayList<User>();

			while(rs.next()){
				list.add(createUser(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.listByParams(Params params) 에러발생", e);
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
	public int pageCount(Params params) {
		String type = params.getType();
		String value = params.getValue();

		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT COUNT(*) count");
		sb.append(" FROM   (SELECT email,");
		sb.append(" phone,");
		sb.append(" name,");
		sb.append(" address,");
		sb.append(" point,");
		sb.append(" TO_CHAR(birthdate, 'YYYY/MM/DD HH24:MI:SS') birthdate,");
		sb.append(" TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate,");
		sb.append(" type");
		sb.append(" FROM   users ");
		if(value!=null) sb.append(" where email LiKE ?  or  product_name LIKE ?)");
		else sb.append(")");

		//System.out.println(sb.toString());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());


			if(value != null){
				pstmt.setString(1, value);
				pstmt.setString(2, value);
			}

			rs = pstmt.executeQuery();

			while(rs.next()){
				count=rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.listByParams(Params params) 에러발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}

	private User createUser(ResultSet rs) throws SQLException {
		String email = rs.getString("email");		
		String name = rs.getString("name");		
		String passwd = "****";		
		String phone = rs.getString("phone");		
		String birthdate = rs.getString("birthdate");		
		String regdate = rs.getString("regdate");		
		String address = rs.getString("address");
		int point = rs.getInt("point");
		int type =rs.getInt("type");

		return new User(email, phone, name, passwd, address, point, birthdate, type, regdate);
	}


	public static void main(String[] args) {
		JdbcUserDao userDao=(JdbcUserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);


		Params params = new Params();
		List<User> users=userDao.listByParams(params);
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println(userDao.pageCount(params));
		
		System.out.println(userDao.read("joa@joa"));
		System.out.println(userDao.read("admin@joa"));
	}
}
