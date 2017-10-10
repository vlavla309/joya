package com.joya.order.dao;

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
				"             status, " + 
				"             usedpoint) " + 
				"VALUES      (?, " + 
				"             ?, " + 
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
			pstmt.setString(9, order.getStatus());
			pstmt.setInt(10, order.getUsedPoint());

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
	public List<Orders> listByParam(Params param, String status) {
		String type=param.getType();
		String value=param.getValue();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Orders> list=new ArrayList<Orders>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT order_id, ");
		sb.append("       email,");
		sb.append("       price,");
		sb.append("       orderer,");
		sb.append("       receiver,");
		sb.append("       address,");
		sb.append("       phone,");
		sb.append("       status,");
		sb.append("       payment_type,");
		sb.append("       payment,");
		sb.append("       payment_date,");
		sb.append("       usedpoint,");
		sb.append("       card_no,");
		sb.append("       approval_no,");
		sb.append("       order_date ");
		sb.append("FROM   (SELECT Ceil(rownum / ?) request_page, ");
		sb.append("               order_id, ");
		sb.append("               email,");
		sb.append("               price,");
		sb.append("               orderer,");
		sb.append("               receiver,");
		sb.append("               address,");
		sb.append("               phone,");
		sb.append("               status,");
		sb.append("               payment_type,");
		sb.append("               payment,");
		sb.append("               To_char(payment_date, 'YYYY/MM/DD') payment_date,");
		sb.append("               usedpoint,");
		sb.append("               card_no,");
		sb.append("               approval_no,");
		sb.append("               To_char(order_date, 'YYYY/MM/DD') order_date ");
		sb.append("        FROM   (SELECT * ");
		sb.append("                FROM   orders");
		
		if(type!=null&&status!=null) {
			sb.append("   WHERE  email = ? AND status = ? ");
		}else {
			if(type!=null) {
				sb.append("   WHERE  email = ? ");
			}
			if(status!=null) {
				sb.append("   WHERE  status = ? ");
			}
		}
		
		sb.append("                ORDER  BY order_id DESC)) ");
		sb.append(" WHERE  request_page = ?");
		
		System.out.println(sb.toString());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			
			pstmt.setInt(1, param.getPageSize());
			
			
			if(type!=null&&status!=null) {
				pstmt.setString(2, value);
				pstmt.setString(3, status);
				pstmt.setInt(4, param.getPage());
			}else {
				pstmt.setInt(2, param.getPage());
				if(type!=null) {
					pstmt.setString(2, value);
					pstmt.setInt(3, param.getPage());
				}
				if(status!=null) {
					pstmt.setString(2, status);
					pstmt.setInt(3, param.getPage());
				}
			}
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				list.add(createOrder(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Orders search(String orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	private Orders createOrder(ResultSet rs) {
		Orders order=new Orders();
		try {
			order.setOrderId(rs.getInt("order_id"));
			order.setEmail(rs.getString("email"));
			order.setPrice(rs.getInt("price"));
			order.setOrderer(rs.getString("orderer"));
			order.setReceiver(rs.getString("receiver"));
			order.setAddress(rs.getString("address"));
			order.setPhone(rs.getString("phone"));
			order.setStatus(rs.getString("status"));
			order.setPaymentType(rs.getString("payment_type"));
			order.setPayment(rs.getInt("payment"));
			order.setPaymentDate(rs.getString("payment_date"));
			order.setUsedPoint(rs.getShort("usedpoint"));
			order.setCardNo(rs.getInt("approval_no"));
			order.setOrderDate(rs.getString("order_date"));
			
		} catch (SQLException e) {e.printStackTrace();}
		return order;
		
	}
	
	@Override
	public int pageCount(Params param, String status) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		JdbcOrderDao dao=(JdbcOrderDao) DaoFactory.getInstance().getDao(JdbcOrderDao.class);
		
		Params param=new Params();
		param.setPageSize(50);
		List<Orders> orders=new ArrayList<Orders>();
		
		orders=dao.listByParam(param, "주문접수");
		System.out.println(param.toString());
		for (Orders order : orders) {
			System.out.println(order);
		}
		
		
		
		
	}

}

