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
		
	}

	@Override
	public void delete(String email) {
		
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
}
