package com.joya.orderitem.dao;

import java.util.List;

import com.joya.orderitem.domain.OrderItems;

public interface OrderItemDao {
	
	public void create(OrderItems orderItem);
	public void update(OrderItems orderItem);
	public  List<OrderItems> listByOrderID(int orderId);
	public  OrderItems search(int orderid, int productid);
	
}
