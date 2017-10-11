package com.joya.orderitem.dao;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.exception.MallException;
import com.joya.order.domain.Orders;
import com.joya.orderitem.domain.OrderItems;
import com.joya.product.dao.JdbcProductDao;

public class JdbcOrderItemDao implements OrderItemDao {
	private DataSource dataSource;



	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(OrderItems orderItem) {
		System.out.println(orderItem);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql="INSERT INTO orderitems " + 
				"            (product_id, " + 
				"             order_id, " + 
				"             amount) " + 
				"VALUES      (?, " + 
				"             ?, " +
				"             ?) ";

		try {
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderItem.getProductId());
			pstmt.setInt(2, orderItem.getOrderId());
			pstmt.setInt(3,  orderItem.getAmount());

			rs=pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcOrderItemDao.create(OrderItems orderItem) ���� �߻�", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}

	@Override
	public void update(OrderItems orderItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderItems> listByOrderID(int orderId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderItems> list=new ArrayList<OrderItems>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT product_id, ");
		sb.append("       order_id,");
		sb.append("       amount ");
		sb.append("       FROM orderitems");
		sb.append("		  WHERE  order_id = ?");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setInt(1, orderId);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				list.add(new OrderItems(rs.getInt("product_id"), rs.getInt("order_id"), rs.getInt("amount")));
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
	public OrderItems search(int orderid, int productid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		JdbcOrderItemDao item=(JdbcOrderItemDao) DaoFactory.getInstance().getDao(JdbcOrderItemDao.class);
		
		List<OrderItems> list = item.listByOrderID(9);
		
		for (OrderItems orderItems : list) {
			System.out.println(orderItems);
		}
		
	}

}
