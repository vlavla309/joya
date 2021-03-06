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

//	회원 가입
	@Override
	public void create(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO users " + 
					   "            (email, " + 
					   "             phone, " + 
					   "             name, " + 
					   "             passwd, " + 
					   "             address, " + 
					   "             point, " + 
					   "             birthdate, " + 
					   "             type) " + 
					   "VALUES      (?, " + 
					   "             ?, " + 
					   "             ?, " + 
					   "             ?, " + 
					   "             ?, " + 
					   "             ?, " + 
					   "             ?, " + 
					   "             ?) ";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPhone());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPasswd());
			pstmt.setString(5, user.getAddress());
			pstmt.setInt(6, 10000);
			pstmt.setString(7, user.getBirthdate());
			pstmt.setInt(8, user.getType());
			pstmt.executeQuery();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new MallException("JdbcUserDao.create(User user)실행 중 예외 발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}
	}

//	회원 탈퇴
	@Override
	public void delete(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String query = "UPDATE users " + 
					   "SET    NAME = '@deleted' " + 
					   "WHERE  email = ? ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcBoardDao.delete(String email) 에러 발생", e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}
	
//	회원 정보 수정
	@Override
	public void modify(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE users " + 
					   "SET    name = ?, " + 
					   "       passwd = ?, " + 
					   "       phone = ?, " + 
					   "       address = ?, " + 
					   "       point = ? " + 
					   "WHERE  email = ? ";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getAddress());
			pstmt.setInt(5, user.getPoint());
			pstmt.setString(6, user.getEmail());
			
			pstmt.executeQuery();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new MallException("JdbcUserDao.modify(User user)실행 중 예외 발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}
	}

	
//	회원 인증
	@Override
	public User isMember(String id, String passwd) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT email, " + 
					 "       phone, " + 
					 "       NAME, " + 
					 "       passwd, " + 
					 "       address, " + 
					 "       point, " + 
					 "       birthdate, " + 
					 "       type, " + 
					 "       To_char(regdate, 'YYYY/MM/DD') regdate " + 
					 "FROM   users " + 
					 "WHERE  email = ? " + 
					 "       AND passwd = ? AND name != '@deleted' ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = createUser(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.isMember(id, passwd) 실행 중 예외발생", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return user;
	}
	
//	회원 상세 정보 조회
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
				"       passwd, " + 
				"       TO_CHAR(birthdate, 'YYYYMMDD') birthdate, " + 
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
			throw new MallException("JdbcUserDao.read(String id) 에러 발생", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return user;
	}

//	전체 회원 조회
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
		sb.append(" passwd,");
		sb.append(" regdate");
		sb.append(" FROM   (SELECT CEIL(rownum / ?) request_page,");
		sb.append(" email,");
		sb.append(" phone,");
		sb.append(" name,");
		sb.append(" address,");
		sb.append(" point,");
		sb.append(" birthdate,");
		sb.append(" type,");
		sb.append(" passwd,");
		sb.append(" regdate");
		sb.append(" FROM   (SELECT email,");
		sb.append(" phone,");
		sb.append(" name,");
		sb.append(" address,");
		sb.append(" point,");
		sb.append(" TO_CHAR(birthdate, 'YYYY/MM/DD HH24:MI:SS') birthdate,");
		sb.append(" TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate,");
		sb.append(" type,");
		sb.append(" passwd");
		sb.append(" FROM   users ))");
		if(value!=null) {
			sb.append(" where email LiKE ?  or  product_name LIKE ?))");
		}
		sb.append(" WHERE  request_page = ?");

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

//	페이징
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

//	유저 객체 생성
	private User createUser(ResultSet rs) throws SQLException {
		String email = rs.getString("email");		
		String name = rs.getString("name");		
		String passwd = rs.getString("passwd");
		String phone = rs.getString("phone");		
		String birthdate = rs.getString("birthdate");		
		String regdate = rs.getString("regdate");		
		String address = rs.getString("address");
		int point = rs.getInt("point");
		int type =rs.getInt("type");

		return new User(email, phone, name, passwd, address, point, birthdate, type, regdate);
	}
	
// 회원 포인트 수정
	@Override
	public void pointmodify(String email, int poiont) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE users SET point = ? wHERE  email = ?";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, poiont);
			pstmt.setString(2, email);
			pstmt.executeQuery();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new MallException("JdbcUserDao.modify(User user)실행 중 예외 발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}
	}
	
}
