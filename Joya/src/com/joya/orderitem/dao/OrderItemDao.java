package com.joya.orderitem.dao;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.orderitem.domain.OrderItems;

public interface OrderItemDao {
	
	public void create(OrderItems orderitem);
	public  List<OrderItems> listAll(Params param);
	public  OrderItems search(int orderid, int productid);
	
}
