package com.joya.orderitem.dao;

import java.util.List;

import com.joya.orderitem.domain.OrderItems;

/**
 * @author 김형주
 *
 */
public interface OrderItemDao {
	/*주문등록*/
	public void create(OrderItems orderItem);
	/*주문수정*/
	public void update(OrderItems orderItem);
	/*주문리스트*/
	public  List<OrderItems> listByOrderID(int orderId);
	/*비회원 주문조회*/
	public  OrderItems search(int orderid, int productid);
	
}
