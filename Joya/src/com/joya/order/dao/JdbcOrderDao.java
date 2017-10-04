package com.joya.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.exception.MallException;
import com.joya.common.web.Params;
import com.joya.order.domain.Orders;

public class JdbcOrderDao implements OrderDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Orders order) {
		System.out.println(order);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql="INSERT INTO orders " + 
				"            (order_id, " + 
				"             email, " + 
				"             price, " + 
				"             orderer, " + 
				"             receiver, " + 
				"             address, " + 
				"             phone, " + 
				"             payment_type, " + 
				"             usedpoint) " + 
				"VALUES      (?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?) ";

		try {
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getOrderId());
			pstmt.setString(2, order.getEmail());
			pstmt.setInt(3,  order.getPrice());
			pstmt.setString(4, order.getOrderer());
			pstmt.setString(5, order.getReceiver());
			pstmt.setString(6, order.getAddress());
			pstmt.setString(7, order.getPhone());
			pstmt.setString(8, order.getPaymentType());
			pstmt.setInt(9, order.getUsedPoint());

			rs=pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcOrderDao.create(Orders order) 에러 발생", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}

	@Override
	public void update(Orders order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNewOrderId() {
		int newOrderId=0;
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String sql="SELECT orders_seq.NEXTVAL new_id FROM DUAL";

		try {
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				newOrderId=rs.getInt("new_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.read(String id) 에러 발생", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return newOrderId;
	}

	@Override
	public List<Orders> listAll(Params param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders search(String orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		JdbcOrderDao dao=(JdbcOrderDao) DaoFactory.getInstance().getDao(JdbcOrderDao.class);
		System.out.println(dao.getNewOrderId());

	}

}

