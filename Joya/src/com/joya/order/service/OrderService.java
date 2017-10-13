package com.joya.order.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.order.domain.Orders;

/**
 * @author 김형주
 *
 */
public interface OrderService {
	/*주문등록*/
	public void create(Orders order);
	/*주문수정*/
	public void update(Orders order);
	/*주문취소*/
	public void delete(int orderId);
	/*orderid 반환*/
	public int getNewOrderId();
	/*주문리스트*/
	public  List<Orders> listByParam(Params param, String status);
	/*비회원 주문조회*/
	public  Orders search(String orderid, String email);
	/*주문리스트 페이징*/
	public int pageCount(Params param, String status);
}
