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
import com.joya.product.domain.Product;

/**
 * @author 김형주
 *
 */
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
				"             message, " + 
				"             usedpoint, payment," +
				"             gst_email) " +
				"VALUES      (?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " + 
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, ?," +
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
			pstmt.setString(10, order.getMassage());
			pstmt.setInt(11, order.getUsedPoint());
			pstmt.setInt(12, order.getPayment());
			pstmt.setString(13, order.getGstEmail());

			rs=pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcOrderDao.create(Orders order) ���� �߻�", e);
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
		// 임의의 주문번호를 생성(주문 테이블에서 주문번호를 증가시킴)하고 반환
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
			throw new MallException("JdbcUserDao.read(String id) ���� �߻�", e);
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
		sb.append("       gst_email,");
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
		sb.append("               gst_email,");
		sb.append("               To_char(order_date, 'YYYY/MM/DD') order_date ");
		sb.append("        FROM   (SELECT * ");
		sb.append("                FROM   orders");

		if(type!=null&&status!=null) {
			switch(type) {
			case "email":
				sb.append("   WHERE  email = ");
				sb.append("'"+value+"'");	
				break;
			case "orderer":
				sb.append("   WHERE  orderer = ");
				sb.append("'"+value+"'");	
				break;
			}


			sb.append("   AND status = ? ");

		}else {
			if(type!=null) {
				switch(type) {
				case "email":
					sb.append("   WHERE  email = ");
					sb.append("'"+value+"'");	
					break;
				case "orderer":
					sb.append("	  WHERE  orderer = ");
					sb.append("'"+value+"'");	
					break;
				}
			}
			if(status!=null) {
				sb.append("   WHERE  status = ? ");
			}
		}

		sb.append("                ORDER  BY order_id DESC)) ");
		sb.append(" WHERE  request_page = ?");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());


			pstmt.setInt(1, param.getPageSize());
			


			if(status!=null) {
				pstmt.setString(2, status);
				pstmt.setInt(3, param.getPage());
			}else {
				pstmt.setInt(2, param.getPage());
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

	//비회원 주문조회
	@Override
	public Orders search(String orderid, String email) {
		Orders order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from orders where GST_EMAIL=? and ORDER_ID=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, orderid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = createOrder(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("Orders search(String orderid, String email)", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return order;
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
			order.setUsedPoint(rs.getInt("usedpoint"));
			order.setCardNo(rs.getInt("approval_no"));
			order.setOrderDate(rs.getString("order_date"));
			order.setGstEmail(rs.getString("gst_email"));
		} catch (SQLException e) {e.printStackTrace();}
		return order;

	}

	@Override
	public int pageCount(Params param, String status) {
		String type=param.getType();
		String value=param.getValue();
		
		int count=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT count(*) count");
		sb.append("	FROM   (SELECT * ");
		sb.append(" 	     FROM  orders");

		if(type!=null&&status!=null) {
			switch(type) {
			case "email":
				sb.append("   WHERE  email = ");
				sb.append("'"+value+"'");	
				break;
			case "orderer":
				sb.append("	WHERE  orderer = ");
				sb.append("'"+value+"'");	
				break;
			}
			sb.append("   AND status = ? )");
		}else {
			if(type!=null) {
				switch(type) {
				case "email":
					sb.append("   WHERE  email = ");
					sb.append("'"+value+"'");	
					break;
				case "orderer":
					sb.append("	  WHERE  orderer = ");
					sb.append("'"+value+"'");	
					break;
				}
			}
			if(status!=null) {
				sb.append("   WHERE  status = ? ");
			}
			sb.append(" )");
		
		}
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());

			if(status!=null) {
				pstmt.setString(1, status);
			}

			rs = pstmt.executeQuery();

			if(rs.next()) {
				count=rs.getInt("count");
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


		return count;
	}

}

