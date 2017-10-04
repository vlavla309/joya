package com.joya.order.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.order.domain.Orders;

public interface OrderService {
	public void create(Orders order);
	public void update(Orders order);
	public void delete(int orderId);
	
	public int getNewOrderId();
	
	public  List<Orders> listAll(Params param);
	public  Orders search(String orderid);
}
