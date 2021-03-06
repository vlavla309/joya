package com.joya.user.service;

import java.util.List;

import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;
import com.joya.user.dao.JdbcUserDao;
import com.joya.user.domain.User;

public class UserServiceImpl implements UserService{
	JdbcUserDao userDao=(JdbcUserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);
	
	@Override
	public void create(User user) {
		userDao.create(user);
	}

	@Override
	public void delete(String email) {
		userDao.delete(email);
	}
	
	@Override
	public void modify(User user) {
		userDao.modify(user);
	}
	
	@Override
	public User isMember(String id, String passwd) {
		return userDao.isMember(id, passwd);
	}

	@Override
	public User read(String email) {
		return userDao.read(email);
	}

	@Override
	public List<User> listByParams(Params params) {
		return userDao.listByParams(params);
	}

	@Override
	public int pageCount(Params params) {
		return userDao.pageCount(params);
	}

	@Override
	public void pointmodify(String email, int poiont) {
		userDao.pointmodify(email, poiont);
		
	}
}
