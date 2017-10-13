package com.joya.order.service;

import java.util.List;

import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;
import com.joya.order.dao.JdbcOrderDao;
import com.joya.order.domain.Orders;

/**
 * @author 김형주
 *
 */
public class OrderServiceImpl implements OrderService {
	JdbcOrderDao dao=(JdbcOrderDao) DaoFactory.getInstance().getDao(JdbcOrderDao.class);
	@Override
	public void create(Orders order) {
		dao.create(order);
	}

	@Override
	public void update(Orders order) {
		dao.update(order);
	}

	@Override
	public void delete(int orderId) {
		dao.delete(orderId);
	}

	@Override
	public int getNewOrderId() {
		return dao.getNewOrderId();
	}

	@Override
	public List<Orders> listByParam(Params param, String status) {
		return dao.listByParam(param, status);
	}

	@Override
	public  Orders search(String orderid, String email) {
		return dao.search(orderid, email);
	}

	@Override
	public int pageCount(Params param, String status) {
		return dao.pageCount(param, status);
	}
	
	

}
