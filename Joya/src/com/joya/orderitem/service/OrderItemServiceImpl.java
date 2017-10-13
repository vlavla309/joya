package com.joya.orderitem.service;

import java.util.List;

import com.joya.common.db.DaoFactory;
import com.joya.orderitem.dao.JdbcOrderItemDao;
import com.joya.orderitem.domain.OrderItems;

/**
 * @author 김형주
 *
 */
public class OrderItemServiceImpl implements OrderItemService {
	JdbcOrderItemDao itemDao=(JdbcOrderItemDao) DaoFactory.getInstance().getDao(JdbcOrderItemDao.class);
	@Override
	public void create(OrderItems orderItem) {
		itemDao.create(orderItem);
	}

	@Override
	public void update(OrderItems orderItem) {
		itemDao.update(orderItem);
	}

	@Override
	public List<OrderItems> listByOrderID(int orderId) {
		return itemDao.listByOrderID(orderId);
	}

	@Override
	public OrderItems search(int orderid, int productid) {
		return itemDao.search(orderid, productid);
	}

}
