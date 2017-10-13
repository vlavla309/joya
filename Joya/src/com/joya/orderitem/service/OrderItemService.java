package com.joya.orderitem.service;

import java.util.List;

import com.joya.orderitem.domain.OrderItems;

/**
 * 
 * @author 김형주
 *
 */
public interface OrderItemService {

	public void create(OrderItems orderItem);

	public void update(OrderItems orderItem);

	public List<OrderItems> listByOrderID(int orderId);

	public OrderItems search(int orderid, int productid);
}
