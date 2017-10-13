package com.joya.orderitem.dao;

import java.util.List;

import com.joya.orderitem.domain.OrderItems;

/**
 * @author 김형주
 *
 */
public interface OrderItemDao {
	
	public void create(OrderItems orderItem);
	public void update(OrderItems orderItem);
	public  List<OrderItems> listByOrderID(int orderId);
	public  OrderItems search(int orderid, int productid);
	
}
